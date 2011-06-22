Ext.onReady(function(){

    // NOTE: This is an example showing simple state management. During development,
    // it is generally best to disable state management as dynamically-generated ids
    // can change across page loads, leading to unpredictable results.  The developer
    // should ensure that stable state ids are set for stateful components in real apps.
    Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

    var viewport = new Ext.Viewport({
        layout:'border',
        items:[
        new Ext.BoxComponent({ // raw
            region:'north',
            el: 'north',
            height:32
        }),
        {
            region:'south',
            contentEl: 'south',
            split:true,
            height: 100,
            minSize: 100,
            maxSize: 200,
            collapsible: true,
            title:'South',
            margins:'0 0 0 0'
        }, {
            region:'east',
            title: 'East Side',
            collapsible: true,
            split:true,
            width: 225,
            minSize: 175,
            maxSize: 400,
            layout:'fit',
            margins:'0 5 0 0',
            items:
            new Ext.TabPanel({
                border:false,
                activeTab:1,
                tabPosition:'bottom',
                items:[{
                    html:'<p>A TabPanel component can be a region.</p>',
                    title: 'A Tab',
                    autoScroll:true
                },
                new Ext.grid.PropertyGrid({
                    title: 'Property Grid',
                    closable: true,
                    source: {
                        "(name)": "Properties Grid",
                        "grouping": false,
                        "autoFitColumns": true,
                        "productionQuality": false,
                        "created": new Date(Date.parse('10/15/2006')),
                        "tested": false,
                        "version": .01,
                        "borderWidth": 1
                    }
                })]
            })
        },{
            region:'west',
            id:'west-panel',
            title:'West',
            split:true,
            width: 200,
            minSize: 175,
            maxSize: 400,
            collapsible: true,
            margins:'0 0 0 5',
            layout:'accordion',
            layoutConfig:{
                animate:true
            },
            items: [{
                title: "SystemManage",
                border: false,
                layout: 'fit',
                iconCls:'settings',
                items: [{
                    xtype: 'treepanel',
                    //el:'tree-div',
                    useArrows:true,
                    autoScroll:true,
                    animate:true,
                    enableDD:true,
                    containerScroll: true,
                    //collapsed: true,
                    //rootVisable: false,

                    // auto create TreeLoader
                    dataUrl: 'mainInitMenu.jsp',

                    root: {
                        nodeType: 'async',
                        text: 'Ext JS',
                        draggable:false,
                        id:'source',
                        expanded : true
                    },
                    listeners: {
                        //                        'render': function(tp){
                        //                            tp.getSelectionModel().on('selectionchange', function(tree, node){
                        //                            })
                        //                        }
                        'click' : function(node, event){
                            if(node && node.leaf){
                                openLeafNode(node, event);
                            }
                        }
                    }
                }]
            },{
                title:'Settings',
                html:'<p>Some settings in here.</p>',
                border:false,
                iconCls:'settings'
            }]
        },
        {
            id: 'tabPanel',
            xtype: 'tabpanel',
            region:'center',
            deferredRender:false,
            activeTab:0,
            enableTabScroll: true,
            plugins: new Ext.ux.TabCloseMenu(),
            items:[
            //                {
            //                contentEl:'center1',
            //                title: 'Close Me',
            //                closable:true,
            //                autoScroll:true
            //            },
            {
                contentEl:'center2',
                title: 'Home Page',
                autoScroll:true
            }]
        }
        ]
    });
    Ext.get("hideit").on('click', function() {
        var w = Ext.getCmp('west-panel');
        w.collapsed ? w.expand() : w.collapse();
    });
});

function openLeafNode(node, event){
    var tabId = node.id; //设置新tab的id为node的id
    var child = Ext.getCmp(tabId); //根据id获取tab页，以判断是否已经打�?    if(child == null){
    var nodeUrl = node.attributes.url;
    nodeUrl = nodeUrl==null ? 'mainMenuNoUrlError.jsp' : nodeUrl; //新的页面要访问的网页地址
    if(child == null){
        child = Ext.getCmp('tabPanel').add({
            id: tabId,
            title: node.text,
            border: false,
            closable: true,
            layout: 'fit',
            //autoScroll : false,
            //autoLoad:{url:nodeUrl, scripts:true} //通过autoLoad属�?载入目标�?如果要用到脚�?必须加上scripts属�?
            html: '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + nodeUrl + '"></iframe>' //使用html打开tab�?
            //html: '<iframe STYLE="OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN" frameborder="0" width="100%" height="100%" src="' + nodeUrl + '"></iframe>' //使用html打开tab�?
        });
    }
    child.show();
}
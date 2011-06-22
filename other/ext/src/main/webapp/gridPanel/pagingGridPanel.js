Ext.onReady(function(){
    var store = new Ext.data.JsonStore({
        root: 'topics',
        totalProperty: 'totalCount', //记录总条数，不是总和这次返回的条数相等，用于计算还剩多少页
        idProperty: 'threadid',
        remoteSort: true,
        fields: [
            'title','forumtitle','forumid','author',
            {name: 'replycount', type:'int'},
            {name: 'lastpost', mapping: 'lastpost', type: 'date', dateFormat:'timestamp'},
            'lastposter', 'excerpt'
        ],
        proxy: new Ext.data.ScriptTagProxy({ //跨域访问数据
            url: 'http://extjs.com/forum/topics-browse-remote.php'
        })
    });
    store.setDefaultSort('lastpost', 'desc');

    function renderTopic(value, p, record){ //渲染topic，取record的数据生成链接
        return String.format('<b><a href="http://extjs.com/forum/showthread.php?t={2}" target="_blank">{0}</a></b><a href="http://extjs.com/forum/forumdisplay.php?f={3}" target="_blank">{1} Forum</a>', value, record.data.forumtitle, record.id, record.data.forumid);
    }

    function renderLast(value, p, r){ //渲染最后提交人和提交日期
        return String.format('{0}<br/>by {1}', value.dateFormat('M j, Y, g:i a'), r.data['lastposter']);
    }

    var pagingBar = new Ext.PagingToolbar({
        pageSize: 25,
        store: store,
        displayInfo: true,
        displayMsg: 'Displaying topics {0} - {1} of {2}', //表格右下角显示的信息
        emptyMsg: "No topics to display",
        items:[
            '-',{
                //bottomBar上的show preview按钮
                pressed: true,
                enableToggle: true,
                text: 'show Preview',
                cls: 'x-btn-text-icon details',
                toggleHandler: function(btn, pressed){
                    var view = grid.getView();
                    view.showPreview = pressed;
                    view.refresh();
                }
            }
        ]
    });

    var grid = new Ext.grid.GridPanel({
        el: 'gridPanel',
        width: 700,
        height: 500,
        title:'ExtJS.com - Browse Forums',
        store: store,
        trackMouseOver: false,
        disableSelection: true,
        loadMask: true,
        columns: [{
                id: 'topic',
                header: "Topic",
                dataIndex: 'title',
                width: 420,
                renderer: renderTopic, //指定渲染函数
                sortable: true
        },{
            header: 'Author',
            dataIndex: 'author',
            width: 100,
            hidden: true,
            sortable: true
        },{
            header: 'Replies',
            dataIndex: 'replycount',
            width: 70,
            aligh: 'right',
            sortable: true
        },{
            id: 'last',
            header: "Last Post",
            dataIndex: 'lastpost',
            width: 150,
            renderer: renderLast,
            sortable: true
        }],
        viewConfig: {
            forceFit:true,
            enableRowBody: true,
            showPreview: true,
            getRowClass : function(record, rowIndex, p, store){ //响应bottomBar的showPreview按钮的事件
                if(this.showPreview){
                    p.body = '<p>' + record.data.excerpt + '</p>';
                    return 'x-grid3-row-expanded';
                }else{
                    return 'x-grid3-row-collapsed';
                }
            }
        },
        bbar: pagingBar
    });

    grid.render();
    store.load({params:{start:0, limit:25}});
});


//不知道什么意思
Ext.ux.SliderTip = Ext.extend(Ext.Tip, {
    minWidth: 10,
    offsets: [0, -10],
    init: function(slider){
        slider.on('dragstart', this.onSlide, this);
        slider.on('drag', this.onSlide, this);
        slider.on('dragend', this.hide, this);
        slider.on('destroy', this.destroy, this);
    },

    onSlide: function(slider){
        this.show();
        this.body.update(this.getText(slider));
        this.doAutoWidth();
        this.el.alighTo(slider.thumb, 'b-t?', this.offsets);
    },

    getText: function(slider){
        return slider.getValue();
    }
});
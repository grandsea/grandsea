Ext.onReady(function(){
    var tabs = new Ext.TabPanel({
        renderTo: 'tabs1',
        width: 450,
        activeTab: 0,
        frame: true, //很多地方见到了，不理解
        defaults: {autoHeight: true},
        items: [
            {contentEl: 'script', title: 'Short Text'},
            {contentEl: 'markup', title: 'Long Text'}
        ]
    });

    var tabs2 = new Ext.TabPanel({
        renderTo: document.body, //添加到文档的body中
        activeTab: 0,
        width: 600,
        height: 250,
        plain:true, //不理解
        defaults: {autoScroll: true},
        items:[{
                title: 'Normal Tab',
                html: "My content was added during construction"
        },{
            title: 'Ajax Tab 1',
            closable: true,
            autoLoad: 'ajax1.htm'
        },{
            title: 'Ajax Tab 2',
            autoLoad: {url: 'ajax2.htm', params: 'foo=bar&wtf=1'}
        },{
            title: 'Event Tab',
            listeners: {activate: handleActivate},
            html: "I am tab 4's content. I also have an event listener attached."
        },{
            title: 'disabled tab',
            disabled: true,
            html: "Can't see me cause I'm disabled"
        }]
    });

    function handleActivate(tab){
        alert(tab.title + ' was activated.');
    }
});
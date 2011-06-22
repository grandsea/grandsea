Ext.onReady(function(){
    var tabs = new Ext.TabPanel({
        renderTo: 'tabs',
        resizeTabs: true,
        minTabWidth: 115,
        tabWidth: 135,
        enableTabScroll: true, //tab���ϵ����ҹ����ɼ�
        width: 600,
        height: 250,
        defaults: {autoScroll: true},
        plugins: new Ext.ux.TabCloseMenu() //tab�ϵ��Ҽ��˵�
    });

    var index = 0;
    while(index < 7){
        addTab();
    }

    function addTab(){
        tabs.add({
            title: 'New Tab' + (++index),
            iconCls: 'tabs',
            html: 'Tab Body' + (index) + '<br/><br/>',
                //+ Ext.example.bogusMarkup,
            closable: index%2
        }).show();
    }

    new Ext.Button({
        text: 'Add Tab',
        handler: addTab,
        iconCls: 'new tab'
    }).render(document.body, 'tabs');
});
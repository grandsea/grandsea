Ext.onReady(function(){
    var store = new Ext.data.Store({
        url: 'sheldon.xml',
        reader: new Ext.data.XmlReader({
            record: 'Item',
            id: 'ASIN',
            totalRecords: '@total'
        }, [
        {
            name: 'Author',
            mapping: 'ItemAttributes > Author'
        },
        'Title','Manufacturer','ProductGroup'
        ])
    });

    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
        {
            header: "Author",
            width: 120,
            dataIndex: 'Author',
            sortable: true
        },

        {
            header: "Title",
            width: 180,
            dataIndex: 'Title',
            sortable: true
        },

        {
            header: "Manufacturer",
            width: 115,
            dataIndex: 'Manufacturer',
            sortable: true
        },

        {
            header: "Product Group",
            width: 100,
            dataIndex: 'ProductGroup',
            sortable: true
        }
        ],
        renderTo: 'gridPanel',
        width: 540,
        height: 200
    })

    store.load();
});
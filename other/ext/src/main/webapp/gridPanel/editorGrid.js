Ext.onReady(function(){
    Ext.QuickTips.init();

    function formatDate(value){ //显示日期的列的渲染函数
        return value ? value.dateFormat('M d, Y') : '';
    }

    var fm = Ext.form;

    var checkColumn = new Ext.grid.CheckColumn({ //自定义的列，在后面有原型定义
        header: "Indoor?",
        dataIndex: 'indoor',
        width: 55
    });

    var cm = new Ext.grid.ColumnModel([{
        id: 'common',
        header: "Common Name",
        dataIndex: 'common',
        width: 220,
        editor: new fm.TextField({
            allowBlank: false
        })
    },{
        header: 'Light',
        dataIndex: 'light',
        width: 130,
        editor: new Ext.form.ComboBox({
            typeAhead: true,
            triggerAction: 'all',
            transform: 'light', //从id为light的select里面读数据
            lazyRender: true, //应该设为ture
            listClass: 'x-combo-list-small'
        })
    },{
        header: "Price",
        dataIndex: 'price',
        width: 70,
        aligh: 'right',
        renderer: 'usMoney',
        editor: new fm.NumberField({
            allowBlank: false,
            allowNegative: false,
            maxValue: 100000
        })
    },{
        header: 'Available',
        dataIndex: 'availDate',
        width: 95,
        renderer: formatDate,
        editor: new fm.DateField({
            format: 'm/d/y',
            minValue: '01/01/06',
            disabledDays: [0, 6],  //星期六和星期天不可以选
            disabledDaysText: 'Plants are not available on the weekends'
        })
    },
    checkColumn
    ]);

    cm.defaultSortable = true;

    var Plant = Ext.data.Record.create([ //Plant实际上是一个函数，可以用new Plant构造一个新的实例，下面有例子
    {
        name: 'common',
        type:'string'
    },

    {
        name: 'botanical',
        type:'string'
    },

    {
        name: 'light'
    },

    {
        name: 'price',
        type:'float'
    },

    {
        name: 'availDate',
        mapping:'availability',
        type: 'date',
        dataFormat: 'm/d/Y'
    },

    {
        name: 'indoor',
        type:'bool'
    }
    ]);

    var store = new Ext.data.Store({
        url: 'plants.xml',
        reader: new Ext.data.XmlReader({
            record: 'plant'
        }, Plant),
        sortInfo: {
            field: 'common',
            direction: 'ASC'
        } //排序方式
    });

    var grid = new Ext.grid.EditorGridPanel({
        store: store,
        cm: cm,
        renderTo: 'gridPanel',
        width: 600,
        height: 300,
        autoExpandColumn: 'common',
        title: 'Edit Plants?',
        frame: true,
        plugins: checkColumn,
        clicksToEdit: 1,

        tbar: [{
            text: 'Add Plant',
            handler: function(){
                var p = new Plant({ //新建一个记录
                    common: 'New Plant 1',
                    light: 'Mostly Shade',
                    price: 0,
                    availDate: (new Date()).clearTime(),
                    indoor: false
                });
                grid.stopEditing();
                store.insert(0,p);
                grid.startEditing(0,0);
            }
        }]
    });

    store.load();
});

Ext.grid.CheckColumn = function(config){
    Ext.apply(this, config); //接受传入的配置
    if(!this.id){
        this.id = Ext.id();
    }
    this.renderer = this.renderer.createDelegate(this);
};

Ext.grid.CheckColumn.prototype ={
    init : function(grid){
        this.grid = grid;
        this.grid.on('render', function(){
            var view = this.grid.getView();
            view.mainBody.on('mousedown', this.onMouseDown, this);
        }, this);
    },

    onMouseDown : function(e, t){
        if(t.className && t.className.indexOf('x-grid3-cc-'+this.id) != -1){
            e.stopEvent();
            var index = this.grid.getView().findRowIndex(t);
            var record = this.grid.store.getAt(index);
            record.set(this.dataIndex, !record.data[this.dataIndex]);
        }
    },

    renderer : function(v, p, record){
        p.css += ' x-grid3-check-col-td'; //表格的宽度
        //x-grid3-check-col用一个没有选中的checkbox做背景，x-grid3-check-col-on用选中的做背景
        return '<div class="x-grid3-check-col'+(v?'-on':'')+' x-grid3-cc-'+this.id+'">&#160;</div>';
    }
};
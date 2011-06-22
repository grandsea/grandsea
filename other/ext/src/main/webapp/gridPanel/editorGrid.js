Ext.onReady(function(){
    Ext.QuickTips.init();

    function formatDate(value){ //��ʾ���ڵ��е���Ⱦ����
        return value ? value.dateFormat('M d, Y') : '';
    }

    var fm = Ext.form;

    var checkColumn = new Ext.grid.CheckColumn({ //�Զ�����У��ں�����ԭ�Ͷ���
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
            transform: 'light', //��idΪlight��select���������
            lazyRender: true, //Ӧ����Ϊture
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
            disabledDays: [0, 6],  //�������������첻����ѡ
            disabledDaysText: 'Plants are not available on the weekends'
        })
    },
    checkColumn
    ]);

    cm.defaultSortable = true;

    var Plant = Ext.data.Record.create([ //Plantʵ������һ��������������new Plant����һ���µ�ʵ��������������
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
        } //����ʽ
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
                var p = new Plant({ //�½�һ����¼
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
    Ext.apply(this, config); //���ܴ��������
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
        p.css += ' x-grid3-check-col-td'; //���Ŀ��
        //x-grid3-check-col��һ��û��ѡ�е�checkbox��������x-grid3-check-col-on��ѡ�е�������
        return '<div class="x-grid3-check-col'+(v?'-on':'')+' x-grid3-cc-'+this.id+'">&#160;</div>';
    }
};
Ext.onReady(function(){

    Ext.QuickTips.init();

    Ext.form.Field.prototype.msgTarget = "side";

    var fs = new Ext.FormPanel({
        frame: true,
        title: 'XML Form',
        labelAlign: 'right',
        labelWidth: 85,
        width: 340,
        waitmsgTarget: true,

        reader: new Ext.data.XmlReader({
            record: 'contact',
            success: '@success'
        },[
            {name: 'first', mapping: 'name/first'},
            {name: 'last', mapping: 'name/last'},
            'company','email','state',
            {name: 'dob', type: 'date', dateFormat: 'm/d/Y'}
        ]),

        errorReader: new Ext.form.XmlErrorReader(),

        items: [
                new Ext.form.FieldSet({
                    fieldLabel: 'First Name',
                    name: 'first',
                    width: 190
                },{
                    fieldLabel: 'Last Name',
                    name: 'last',
                    width: '190'
                },{
                    fieldLabel: 'Company',
                    name: 'company',
                    width: 190
                },{
                    fieldLabel: 'Email',
                    name:'email',
                    vtype: 'email',
                    width:190
                },

                new Ext.form.ComboBox({
                    fieldLabel: 'State',
                    hiddenName: 'state',
                    store: new Ext.data.SimpleStore({
                        fields: ['abbr', 'state'],
                        data: Ext.exampledata.states //from states.js
                    }),
                    valueField: 'abbr',
                    displayField: 'state',
                    typeAhead: true,
                    mode: 'local',
                    triggerAciton: 'all',
                    emptyText: 'Select a state...',
                    selectOnFocus: true,
                    width: 190
                }),

                new Ext.form.DateField({
                    fieldLabel: 'Date of Birth',
                    name: 'dob',
                    width: 190,
                    allowBlank: false
                })

            )]
    });

    fs.addButton("Load", function(){
        fs.getForm().load({url: 'xml-form.xml', waitMsg: 'Loading'});
    });

    var submit = fs.addButton({
        
    })
});
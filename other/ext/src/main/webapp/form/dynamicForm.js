Ext.onReady(function(){
    Ext.QuickTips.init();

    //全局设置表单的校验错误显示在表单域旁边
    Ext.form.Field.prototype.msgTarget = 'side';
    var bd = Ext.getBody();
    /*
     * =============Simple form===============
     */
    bd.createChild({ //页面上穿件一个h2的元素
        tag: 'h2',
        html: 'Form 1 - Very Simple'
    });
    var simple = new Ext.FormPanel({
        labelWidth: 75, 
        url: 'save-form.php',
        frame: true,
        title: 'Simple Form',
        bodyStyle: 'padding:5px 5px 0',
        width: 350,
        defaults: {
            width:230
        },
        defaultType: 'textfield',

        items: [{
            fieldLabel: 'First Name',
            name: 'first',
            allowBlank: false
        },{
            fieldLabel: 'Last Name',
            name: 'last'
        },{
            fieldLabel: 'Company',
            name: 'company'
        },{
            fieldLabel: 'Email',
            name: 'email',
            vtype: 'email' //Email验证
        },new Ext.form.TimeField({
            fieldLabel: 'Time',
            name: 'time',
            minValue: '8:00am', //时间大小限制，这是个可以下拉选择的框
            maxValue: '6:00pm'
        })],
        buttons:[{
            text: 'Save'
        },{
            text: 'Cancel'
        }]
    });

    simple.render(document.body); //添加表单到页面

    bd.createChild({
        tag: 'h2',
        html: 'Form 2 - Adding fieldsets'
    });

    var fsf = new Ext.FormPanel({
        labelWidth: 75,
        url: 'save-form.jsp',
        frame:true,
        title: 'Simple Form with FieldSets',
        bodyStyle: 'paadding: 5px 5px 0',
        width: 350,

        items: [{
            xtype: 'fieldset',
            checkboxToggle: true, //有复选框的域集
            title: 'User Information',
            autoHeight: true,
            defaults: {
                width: 120
            },
            defaultType: 'textfield',
            collapsed: true,
            items:[{
                fieldLabel:'First Name',
                name: 'first',
                allowBlank: false
            },{
                fieldLabel: 'Last Name',
                name: 'last'
            },{
                fieldLabel: 'Company',
                name:'company'
            },{
                fieldLabel: 'Email',
                name : 'email',
                vtype: 'email'
            }]
        },{
            xtype: 'fieldset',
            title: 'Phone Number',
            collapsible: true, //可以展开的域集
            autoHeight: true,
            defaults: {
                width: 210
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Home',
                name: 'home',
                value: '(888) 55-1212'
            },{
                fieldLabel: 'Mobile',
                name: 'mobile'
            },{
                fieldLabel: 'Fax',
                name: 'fax'
            }]
        }],

        buttons:[{
            text:'save'
        },{
            text: 'cancel'
        }]
    });

    fsf.render(bd);

    bd.createChild({
        tag: 'h2',
        html:'Form 3 - A little more complex'
    });
    var top = new Ext.FormPanel({
        labelAlign: 'top',
        frame: true,
        title: 'Multi Column, Nested Layouts and Anchoring',
        bodyStyle: 'padding: 5px 5px 0',
        width: 600,
        items: [{
            layout: 'column', //columnlayout的panel，由子元素可以看到分成了等宽的两列
            items:[{
                columnWidth:.5, //占据第一列，宽度为整个panel的一半
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'First Name',
                    name: 'first',
                    anchor: '95%'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Company',
                    name: 'company',
                    anchor: '95%'
                }]
            },{
                columnWidth: .5,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Last Name',
                    name: 'last',
                    anchor: '95%'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Email',
                    name: 'email',
                    vtype: 'email',
                    anchor: '95%'
                }]
            }]
        },{
            xtype:'htmleditor', //html编辑器
            id: 'bio',
            fieldLabel: 'Biography',
            height: 200,
            anchor: '98%'
        }],
        buttons: [{
            text:'save'
        },{
            text: 'cancel'
        }]
    });
    
    top.render(bd);

    bd.createChild({
        tag: 'h2',
        html: 'Form 4 - Forms can be a TabPanel...'
    })
    
    var tabs = new Ext.FormPanel({
        labelWidth: 75,
        border: false,
        width: 350,
        
        items: {
            xtype: 'tabpanel', //标签面板
            activeTab: 0,
            defaults: {
                autoHeight: true,
                bodyStyle: 'padding:10px'
            },
            items: [{
                title: 'Personal Details', //第一个标签
                layout: 'form',
                defaults: {
                    width: 230
                },
                defaultType: 'textfield',
                    
                items: [{
                    fieldLabel: 'FirstName',
                    name: 'first',
                    allowBlank: false,
                    value: 'Jack'
                },{
                    fieldLabel: 'Last Name',
                    name: 'last',
                    value: 'Slocum'
                },{
                    fieldLabel: 'Company',
                    name: 'company',
                    value: 'Ext JS'
                },{
                    fieldLabel: 'Email',
                    name: 'email',
                    vtype: 'email'
                }]
            },{
                title: 'Phone Number', //第二个标签
                layout: 'form',
                defaults: {
                    width: 230
                },
                defaultType: 'textfield',
                
                items: [{
                    fieldLabel: 'Home',
                    name: 'home',
                    value: '(888) 555-1212'
                },{
                    fieldLabel: 'Business',
                    name: 'business'
                },{
                    fieldLabel: 'Mobile',
                    name: 'mobile'
                },{
                    fieldLabel: 'Fax',
                    name: 'fax'
                }]
            }]
        },
        
        buttons:[{
            text: 'save'
        },{
            text: 'cancel'
        }]
    });
    
    tabs.render(bd);

    bd.createChild({
        tag: 'h2',
        html: 'Form 5 - ... and forms can contain TabPanel(s)'
    });

    var tab2 = new Ext.FormPanel({
        labelAlign: 'top',
        title: 'Inner Tabs',
        bodyStyle: 'padding: 5px',
        width: 600,
        items: [{
            layout: 'column', //由子元素看出，分成两列
            border: false,
            items: [{
                columnWidth: .5,
                layout: 'form',
                border: false,
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'First Name',
                    name: 'first',
                    anchor: '95%'
                },{
                    xtype:'textfield',
                    fieldLabel: 'Company',
                    name: 'company',
                    anchor: '95%'
                }]
            },{
                columnWidth: .5,
                layout: 'form',
                border: false,
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Last Name',
                    name: 'last',
                    anchor: '95%'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Email',
                    name: 'email',
                    vtype: 'email',
                    anchor: '95%'
                }]
            }]
        },{
            xtype: 'tabpanel', //添加一个tabel面板
            plain: true,
            activeTab: 0,
            height: 235,
            defaults: {
                bodyStyle: 'padding:10px'
            },
            items: [{
                title: 'Personal Details',
                layout: 'form',
                defaults: {
                    width: 230
                },
                defaultType: 'textfield',

                items: [{
                    fieldLabel: 'First Name',
                    name: 'first',
                    allowBlank: false,
                    value: 'Jack'
                },{
                    fieldLabel: 'Last Name',
                    name: 'last',
                    value: 'Slocum'
                },{
                    fieldLabel: 'Company',
                    name: 'company',
                    value: 'Ext JS'
                },{
                    fieldLabel:'Email',
                    name: 'email',
                    vtype: 'email'
                }]
            },{
                title: 'Phone Numbers',
                layout: 'form',
                defaults: {
                    width: 230
                },
                defaultType: 'textfield',

                items: [{
                    fieldLabel: 'Home',
                    name: 'home',
                    value: '(888) 555-1212'
                },{
                    fieldLabel: 'Mobile',
                    name: 'mobile'
                },{
                    fieldLabel: 'Fax',
                    name: 'fax'
                }]
            },{
                cls: 'x-plain',
                title: 'Biography',
                layout: 'fit',
                items: {
                    xtype: 'htmleditor',
                    id:'bio2',
                    fieldLabel: 'Biography'
                }
            }]
        }],
        buttons: [{
            text:'save'
        },{
            text: 'cancel'
        }]
    });

    tab2.render(bd);
});
// Global vars
var MyForm;
var MyWindow;
var Txt_Name;
var Txt_BirthDate;

Ext.onReady(function(){
    Ext.QuickTips.init();

    function saveNewFriend(){

        Ext.Ajax.request({
            waitMsg: 'Wait a second...',
            url: 'db_friends.php',
            params: {
                Name:      Txt_Name.getValue(),
                BirthDate: Txt_BirthDate.getValue().format('d/m/Y')
            },
            success: function(response){
                var result=eval(response.responseText);
                switch(result){
                    case 1:
                        Ext.MessageBox.alert('OK','Your new Friend was created.');
                        MyWindow.hide();
                        break;
                    default:
                        Ext.MessageBox.alert('Error','Could not create your Friend.');
                        break;
                }
            },
            failure: function(response){
                var result=response.responseText;
                Ext.MessageBox.alert('Error','Could not connect to the database');
            }
        });
    }


    Txt_Name = new Ext.form.TextField({
        id: 'Name',
        fieldLabel: 'Name',
        minLength : 1,
        maxLength: 20,
        selectOnFocus: true,
        allowBlank: false,
        anchor : '80%',
        maskRe: /([0-9]+)$/
    });

    Txt_BirthDate = new Ext.form.DateField({
        id: 'BirthDate',
        fieldLabel: 'Birth date',
        vtype: 'daterange',
        format: 'd/m/Y',
        allowBlank: false,
        anchor : '32%'
    });

    MyForm = new Ext.FormPanel({
        labelAlign: 'top',
        frame:true,
        bodyStyle:'padding:5px 5px 0',
        width: 390,
        buttonAlign:'right',
        items: [Txt_Name, Txt_BirthDate],
        buttons: [{
            text: 'Save',
            handler: saveNewFriend
        },{
            text: 'Cancel',
            handler: function(){
                MyWindow.hide();
            }
        }]
    });

    MyWindow = new Ext.Window({
        id: 'MyWindow',
        title: 'New Friend',
        closable:true,
        width: 350,
        height: 240,
        plain:true,
        layout: 'fit',
        items: MyForm,
        form:  MyForm.getForm(),
        listeners: {
            "show" : function() {
                var firstElem = MyForm.getForm().findField(0);
                firstElem.focus.defer(150, firstElem);
            }
        }
    });
    MyWindow.show();

});
Ext.onReady(function(){
    var simple = new Ext.form.FormPanel({
        standardSubmit: true,
        frame:true,
        title: 'Register',
        width: 350,
        defaults: {
            width: 230
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Username',
            name: 'username',
            allowBlank:false
        },
        {
            inputType: 'hidden',
            id: 'submitbutton',
            name: 'myhiddenbutton',
            value: 'hiddenvalue'
        }
        ],
        buttons: [{
            text: 'Submit',
            handler: function() {
                simple.getForm().getEl().dom.action = 'index.jsp';
                simple.getForm().getEl().dom.method = 'POST';
                simple.getForm().submit();
            }
        }]
    });
    simple.render('mytraditionalform');
});
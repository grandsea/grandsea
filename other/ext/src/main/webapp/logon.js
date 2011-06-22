var logon = {

	width : 230,

	form : new Ext.form.FormPanel({
				url : 'logon.hs',
				labelWidth : 50,
				width : this.width,
				frame : true,
				defaults : {
					width : 150
				},
				defaultType : 'textfield',

				items : [{
							fieldLabel : '用户名',
							name : 'userName',
							allowBlank : false
						}, {
							fieldLabel : '密码',
							name : 'password',
							allowBlank : false,
							inputType : 'password'
						}]
			}),

	show : function() {
		if (!this.logonWindow) {
			this.logonWindow = new Ext.Window({
						title : '<p align="center">登陆</p>',
						layout : 'fit',
						width : this.width + 10,
						height : 135,
						frame : true,
						plain : true,
						closable : false,
						resizable : false,
						defaults : {
							align : 'center'
						},
						bodyStyle : 'padding 5px 5px 5px 5px',
						draggable : false,
						shadow : true,
						items : [this.form],

						buttons : [{
									text : '确定'
								}, {
									text : '重置'
								}],
						buttonAlign : 'center'
					});
		}
		this.logonWindow.show();
	}
};

Ext.onReady(function() {
			logon.show();
		});
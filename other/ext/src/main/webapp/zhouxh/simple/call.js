Ext.onReady(function(){
	var form = new Ext.form.FormPanel({
		renderTo: 'form',
		url: 'callAnswer.jsp',
		title: 'Echo Test',
		width: 350,
		labelWidth: 75,
		frame: true,
		bodyStyle: 'padding: 5px 5px 0',
		defaults:{width: 250},
		defaultType: 'textfield',
		items: [{
			fieldLabel: '输入',
			name: 'input'
		}]
	});
	
	Ext.get('update').on('click',function(){
		form.getForm().submit({
			success: function(form, action){
				Ext.fly('result').update(action.result.info);
			},
			failure: function(form, action){
				Ext.fly('result').update("errorType:" + action.failureType);
			}
		});
	});
	
	var windowForm = new Ext.form.FormPanel({
		renderTo: 'form',
		url: 'callAnswer.jsp',
//		title: 'Echo Test',
		width: 350,
		labelWidth: 75,
		frame: true,
		bodyStyle: 'padding: 5px 5px 0',
		defaults:{width: 250},
		defaultType: 'textfield',
		items: [{
			fieldLabel: '输入',
			name: 'input'
		},{
			xtype: 'textarea',
			fieldLabel: '输出',
			id: 'output',
			name: 'output',
			disabled: true
		}]
	});
	
	var formWindow = new Ext.Window({
		title: '<p align="center">服务器响应Demo</p>',
		width: 370,
		height: 200,
		frame: true,
		layout: 'fit',
		items: [windowForm],
		
		buttonAlign: 'center',
		buttons: [{
			text: '发送',
			handler: function(source, e){
				windowForm.getForm().submit({
					success: function(form, action){
						Ext.getCmp('output').setValue(action.result.info);
					},
					failure: function(form, action){
						Ext.getCmp('output').setValue("errorType:" + action.failureType);
					}
				});
			}
		},{
			text: '重置',
			handler: function(source, e){
				windowForm.getForm().reset();
			}
		}]
	});
	formWindow.show();
});
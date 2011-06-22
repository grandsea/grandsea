Ext.onReady(function(){
	var window = new Ext.Window({
		title: '<p align="center">window</p>',
		layout: 'fit',
		width: 500,
		height: 300,
		closeAction: 'hide',
		plain: true,
		items: new Ext.TabPanel({
			autoTabs: true,
			activeTab: 0,
			deferredRender: false,
			border: false,
			items: [{
				title: 'tab1',
				html: 'hello....'
			},{
				title: 'tab2',
				html: '.....world'
			}]
		}),
		buttons: [{
			text: 'submit',
			disabled: true
		},{
			text: 'close',
			handler: function(){
				window.hide();
			}
		}]
	});
	
	var showButton = Ext.get('showButton');
	showButton.on('click', function(){window.show(showButton);});
});
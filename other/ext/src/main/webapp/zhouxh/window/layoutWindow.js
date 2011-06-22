Ext.onReady(function(){
	var tab = new Ext.TabPanel({
		title: 'tabs',
		region: 'center',
		items: [{
			title: 'tab1',
			html: 'hello',
		},{
			title: 'tab2',
			html: 'good'
		}]
	});
	
	var navigate = new Ext.Panel({
		title: 'navigate',
		collapsible: true,
		region: 'west',
		split: true
	});
	
	var window =  new Ext.Window({
		layout: 'border',
		title: 'window',
		closeAction: 'hide',
		width: 600,
		height: 400,
		items: [navigate, tab]
	});
	
	Ext.fly('show').on('click',function(){window.show(Ext.fly('show'));});
});
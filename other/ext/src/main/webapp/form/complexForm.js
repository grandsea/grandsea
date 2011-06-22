Ext.onReady(function() {

	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';

	var tabelPanel = {
		xtype : 'tabpanel',
		title : 'basic information',
		activeTab : 0,
		defaults : {
			autoHeight : true,
			bodyStyle : 'padding:10px'
		},
		items : [ {
			title : 'Persional Details',
			layout : 'form',
			defaults : {
				width : 350
			},
			defaultType : 'textfield',

			items : [ {
				fieldLabel : 'First Name',
				name : 'firstName',
				allowBlank : false,
				blankText : 'firstName'
			}, {
				fieldLabel : 'Last Name',
				name : 'lastName',
				allowBlank : false,
				value : 'green'
			}, {
				xtype : 'radiogroup',
				fieldLabel : 'Sex',
				items : [ {
					boxLabel : 'male',
					name : 'sex',
					inputValue : 0,
					checked : true
				}, {
					boxLabel : 'female',
					name : 'sex',
					inputValue : 1
				} ]
			} ]
		}, {
			title : 'Company information',
			layout : 'form',
			defaultType : 'textfield',
			labelWidth : 130,
			defaults : {
				width : 300
			},
			items : [ {
				fieldLabel : 'Company Name',
				name : 'companyName',
				allowBlank : false
			}, {
				fieldLabel : 'Company Address',
				name : 'companyAddress'
			}, {
				fieldLabel : 'Company Type',
				xtype : 'checkboxgroup',
				items : [ {
					boxLabel : 'private',
					name : 'companyType',
					inputValue : 0,
					checked : true
				}, {
					boxLabel : '>1000',
					name : 'companyType',
					inputValue : 1,
					checked : false
				} ]
			} ]
		} ]
	};

	var checkboxToggle = {
		xtype : 'fieldset',
		autoHeight : true,
		collapsed : true,
		checkboxToggle : true,
		border : true,
		title : 'Snote',
		layout : 'fit',
		anchor:'100%',
		items : [ {
			xtype : 'htmleditor',
			name : 'snote',
			id : 'snote',
			fieldLabel : 'Snote'
		} ]
	};
	
	var collapsiblePanel = {
		title : 'collapsiable',
		xtype: 'fieldset',
		collapsible: true,
		autoHeight: true,
		defaults: {width: 210},
		defaultType: 'textfield',
		items: [{
			fieldLabel: 'Home',
			name: 'home'
		},{
			fieldLabel: 'Mobile',
			name: 'mobile'
		},{
			fieldLabel: 'Fax',
			name: 'fax'
		},{
			fieldLabel: 'Business',
			name: 'business'
		}]
	};

	var form1 = new Ext.form.FormPanel( {
		renderTo : Ext.getBody(),
		frame : true,
		title : 'form1',
		labelWidth : 80,
		width : 500,
		bodyStyle : 'padding: 5px 5px 0',
		url : 'ok.jsp',
		items : [ tabelPanel,collapsiblePanel,checkboxToggle ]
	});
});
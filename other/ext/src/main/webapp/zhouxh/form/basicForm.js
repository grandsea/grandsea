Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	//Turn on validation errors beside the field globally
	Ext.form.Field.prototype.msgTarget = 'side';
	
	var bd = Ext.getBody();
	
	bd.createChild({tag: 'h2', html: 'Form 1 - Very Simple'});
	
	var simpleForm = new Ext.form.FormPanel({
		title	: 'simpleForm',
		labelWidth :  75,
		frame : true,
		bodyStyle : 'padding: 5px 5 px 0',
		width: 350,
		url: 'save.jsp',
		defaults: {width : 230},
		defaultType: 'textfield',
		items: [{
			fieldLabel: 'First Name',
			name: 'firstName',
			allowBlank : false
		},{
			fieldLabel: 'Last Name',
			name: 'lastName',
			allowBlank : false
		},{
			fieldLabel: 'Company',
			name: 'company'
		},{
			fieldLabel : 'Email',
			name: 'email',
			vtype: 'email'
		}, new Ext.form.TimeField({
			fieldLabel: 'Time',
			name: 'time',
			minValue: '8:00am',
			maxValue: '5:00pm'
			
		})],
		    
		buttons: [{
			text: 'save'
		},{
			text: 'reset'
		}]
	});
	
	simpleForm.render(bd);
	
	bd.createChild({tag: 'h2', html:'Form 2 - Form with fieldSet'});
	
	var formWithSet = new Ext.form.FormPanel({
		title: 'Form With FieldSet',
		labelWidth : 75,
		url: 'save.jsp',
		frame : true,
		bodyStyle: 'padding 5px 5px 0',
		width: 350,
		
		items: [{
			xtype: 'fieldset',
			defaults: {width: 210},
			defaultType: 'textfield',
			title: 'User Information',
			collapsed: true,
			autoHeight :true,
			checkboxToggle: true,
			items: [{
				fieldLabel: 'First Name',
				name: 'firstName',
				allowBlank: false
			},{
				fieldLabel: 'Last Name',
				name: 'lastName'
			},{
				fieldLabel :'Company',
				name: 'company'
			},{
				fieldLabel: 'Email',
				name: 'email',
				vtype: 'email'
			}]
		},{
			xtype: 'fieldset',
			defaults: {width: 210},
			defaultType: 'textfield',
			title: 'Phone Number',
			autoHeight :true,
			collapsible: true,
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
                }
            ]
		}],
		
		 buttons: [{
            text: 'Save'
        },{
            text: 'Cancel'
        }]

	});
	
	formWithSet.render(bd);
	
	bd.createChild({tag:'h2',html:'A little more complex'});
	
	var complexForm = new Ext.form.FormPanel({
		title: 'A complex form',
		labelAlign: 'top',
		width: 600,
		frame: true,
		bodyStyle:'padding 5px 5px 0',
		items:[{
			layout: 'column',
			items:[{
				columnWidth: 0.5,				
				layout: 'form',
				items:[{
						xtype: 'textfield',
						fieldLabel: 'First Name',
						name:'first',
						anchor: '95%'
					},{
						xtype: 'textfield',
						fieldLabel: 'Company',
						name: 'company',
						anchor:'95%'
					}]
				},{
					columnWidth: 0.5,
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel:'Last Name',
						name: 'last',
						anchor: '95%'
					},{
						xtype: 'textfield',
						fieldLabel: 'Email',
						name:'email',
						vtype: 'email',
						anchor: '95%'
					}]
				}]
		},{
			xtype: 'htmleditor',
			id: 'bio',
			fieldLabel: 'Biography',
			height: 200,
			anchor:'98%'
		}],
		
		buttons: [{
			text: 'save'
		},{
			text:'cancel'
		}]
	});
	
	complexForm.render(bd);
	
	
});
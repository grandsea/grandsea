Ext.namespace('Ext.zhouxh');
Ext.zhouxh.simpleData = [ 
        [ 'AL', 'Alabama', 'The Heart of Dixie' ],
		[ 'AK', 'Alaska', 'The Land of the Midnight Sun' ],
		[ 'AZ', 'Arizona', 'The Grand Canyon State' ],
		[ 'AR', 'Arkansas', 'The Natural State' ],
		[ 'CA', 'California', 'The Golden State' ],
		[ 'CO', 'Colorado', 'The Mountain State' ],
		[ 'CT', 'Connecticut', 'The Constitution State' ],
		[ 'DE', 'Delaware', 'The First State' ],
		[ 'DC', 'District of Columbia', "The Nation's Capital" ],
		[ 'FL', 'Florida', 'The Sunshine State' ],
		[ 'GA', 'Georgia', 'The Peach State' ],
		[ 'HI', 'Hawaii', 'The Aloha State' ],
		[ 'ID', 'Idaho', 'Famous Potatoes' ],
		[ 'IL', 'Illinois', 'The Prairie State' ],
		[ 'IN', 'Indiana', 'The Hospitality State' ],
		[ 'IA', 'Iowa', 'The Corn State' ],
		[ 'KS', 'Kansas', 'The Sunflower State' ],
		[ 'KY', 'Kentucky', 'The Bluegrass State' ],
		[ 'LA', 'Louisiana', 'The Bayou State' ],
		[ 'ME', 'Maine', 'The Pine Tree State' ],
		[ 'MD', 'Maryland', 'Chesapeake State' ],
		[ 'MA', 'Massachusetts', 'The Spirit of America' ],
		[ 'MI', 'Michigan', 'Great Lakes State' ],
		[ 'MN', 'Minnesota', 'North Star State' ],
		[ 'MS', 'Mississippi', 'Magnolia State' ],
		[ 'MO', 'Missouri', 'Show Me State' ],
		[ 'MT', 'Montana', 'Big Sky Country' ],
		[ 'NE', 'Nebraska', 'Beef State' ], [ 'NV', 'Nevada', 'Silver State' ],
		[ 'NH', 'New Hampshire', 'Granite State' ],
		[ 'NJ', 'New Jersey', 'Garden State' ],
		[ 'NM', 'New Mexico', 'Land of Enchantment' ],
		[ 'NY', 'New York', 'Empire State' ],
		[ 'NC', 'North Carolina', 'First in Freedom' ],
		[ 'ND', 'North Dakota', 'Peace Garden State' ],
		[ 'OH', 'Ohio', 'The Heart of it All' ],
		[ 'OK', 'Oklahoma', 'Oklahoma is OK' ],
		[ 'OR', 'Oregon', 'Pacific Wonderland' ],
		[ 'PA', 'Pennsylvania', 'Keystone State' ],
		[ 'RI', 'Rhode Island', 'Ocean State' ],
		[ 'SC', 'South Carolina', 'Nothing Could be Finer' ],
		[ 'SD', 'South Dakota', 'Great Faces, Great Places' ],
		[ 'TN', 'Tennessee', 'Volunteer State' ],
		[ 'TX', 'Texas', 'Lone Star State' ],
		[ 'UT', 'Utah', 'Salt Lake State' ],
		[ 'VT', 'Vermont', 'Green Mountain State' ],
		[ 'VA', 'Virginia', 'Mother of States' ],
		[ 'WA', 'Washington', 'Green Tree State' ],
		[ 'WV', 'West Virginia', 'Mountain State' ],
		[ 'WI', 'Wisconsin', "America's Dairyland" ],
		[ 'WY', 'Wyoming', 'Like No Place on Earth' ] 
];

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var store = new Ext.data.SimpleStore({
		fields: ['abbr','state','nick'],
		data: Ext.zhouxh.simpleData
	});

	var firstComboBox = new Ext.form.ComboBox({
		store: store,
		displayField: 'state',
		typeAhead: true,
		mode: 'local',
		forceSelection: true,
		triggerAction: 'all',
		emptyText: 'Select a state...',
		selectOnFocus: true,
		applyTo: 'firstCombox'
	});
	
	var comboFromArray = new Ext.form.ComboBox({
		store: Ext.zhouxh.simpleData,
		typeAhead: true,
		forceSelection: true,
		triggerAction: 'all',
		emptyText: 'Select a state...',
		selectOnFocus: true,
		applyTo: 'second'
	});
	
	var comboWithTooltip = new Ext.form.ComboBox({
		tpl: '<tpl for="."><div ext:qtip="{state}. {nick}" class="x-combo-list-item">{state}</div></tpl>',
		store: store,
		displayField: 'state',
		typeAhead: true,
		forceSelection:true,
		mode: 'local',
		triggerAction: 'all',
		emptyText: 'Select a state...',
		selectOnFocus: true,
		applyTo: 'withTip'
	});
	
	var converted = new Ext.form.ComboBox({
		typeAhead: true,
		forceSelection: true,
		triggerAction: 'all',
		transform: 'state',
		width: 120
	});
	
	var permissionStore = new Ext.data.SimpleStore({
		fields:[
		{name:'value',type: 'int'},
		'text'
		]
	});
	
	permissionStore.loadData([
		[0,'可写'],
		[1,'只读'],
		[2,'隐藏']
		]);
	
	var permissionCombo = new Ext.form.ComboBox({
		store : permissionStore,
		forceSelection : true,
		triggerAction : 'all',
		typeAhead : true,
		displayField : 'text',
		valueField : 'value',
		lazyRender : true,
		listClass : 'x-combo-list-small',
		mode : 'local',
		renderTo: 'intCombo'
	});
});

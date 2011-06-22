<%-- 
    Document   : jsonStore
    Created on : 2009-11-18, 15:57:36
    Author     : zhouxh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="/commons/jspHeadInclude.jsp"></jsp:include>
<script type="text/javascript">
            Ext.onReady(function(){
                var record = Ext.data.Record.create([
                    {name: 'id'},
                    {name: 'firstName'},
                    {name: 'sex'}
                ]);

                var jsonReader = new Ext.data.JsonReader({
                    totalProperty: 'counts',
                    root: 'rows',
                    id: 'id'
                }, record);

                var columns = [
                               {id:'firstName', header: 'FirstName', dataIndex:'firstName', width: 160},
                               {header: 'Sex', dataIndex: 'sex', width:160}
                           ];

                var proxy = new Ext.data.HttpProxy({
                    url: 'jsonStoreData.txt'
                });
                
                <%--var store = new Ext.data.JsonStore({
                    url: 'jsonStoreData.txt',
                    root: 'rows',
                    fields: [
                        {name: 'id'},
                        {name: 'firstName'},
                        {name: 'sex'}
                    ]
                });--%>

                var firstStore = new Ext.data.Store({ //不是JsonReader
                    proxy: proxy,
                    reader : jsonReader
                });

                firstStore.load();

                var firstGrid = new Ext.grid.GridPanel({
                	enableDragDrop: true,
                	ddGroup: 'secondGridDDGroup',
                    store: firstStore,
                    columns: columns,
                    stripeRows: true,
                    autoExpandColumn: 'firstName',
                    height: 400,
                    width: 350,
                    autoSize: true,
                    title: 'JsonGrid'
                });

                var secondStore = new Ext.data.Store({
                    reader: jsonReader
                });
                
                var secondGrid = new Ext.grid.GridPanel({
                	enableDragDrop: true,
                	ddGroup: 'formGridDDGroup',
                    store: secondStore,
                    columns: columns,
                    stripeRows: true,
                    autoExpandColumn: 'firstName',
                    height: 400,
                    width: 350,
                    autoSize: true,
                    title: 'JsonGrid'
                });

                var panel = new Ext.Panel({
                    title: 'Drag and drop',
                    width: '700',
                    height: '400',
                    layout: 'column',
                    defaults: {columnWidth: 0.33},
                    items: [
                            firstGrid,
                            secondGrid,{
                                id: 'dropForm',
								xtype: 'form',
								title: 'dropForm',
								labelWidth: 50,
								width: 150,
								defaultType: 'textfield',
								items:[
								       {fieldLabel:'name',
									       name: 'firstName'},
									       {fieldLabel: 'sex',
										       name:'sex'}
										]
                                }
                    ]
                });

                panel.render('jsonGrid');
                // used to add records to the destination stores
            	var blankRecord =  Ext.data.Record.create(record);
                /****
            	* Setup Drop Targets
            	***/
            	// This will make sure we only drop to the view container
            	var secondGridDropTargetEl =  secondGrid.getView().el.dom.childNodes[0].childNodes[1];
            	var secondGridDropTarget = new Ext.dd.DropTarget(secondGridDropTargetEl, {
            		ddGroup    : 'secondGridDDGroup',
            		copy       : true,
            		notifyDrop : function(ddSource, e, data){
            			
            			// Generic function to add records.
            			function addRow(record, index, allItems) {
            				
            				// Search for duplicates
            				var foundItem = secondStore.find('id', record.data.id);
            				// if not found
            				if (foundItem  == -1) {
            					secondStore.add(record);
            					
            					// Call a sort dynamically
            					secondStore.sort('id', 'ASC');
            					
            					//Remove Record from the source
            					ddSource.grid.store.remove(record);
            				}
            			}

            			// Loop through the selections
            			Ext.each(ddSource.dragData.selections ,addRow);
            			return(true);
            		}
            	});

            	var formPanel = Ext.getCmp('dropForm');
            	var formDropTargetEl = formPanel.body.dom;
            	var formDropTarget = new Ext.dd.DropTarget(formDropTargetEl, {
					ddGroup: 'secondGridDDGroup',
					copy: true,
					notifyEnter: function(ddSource, e, data){
						formPanel.body.stopFx();
						formPanel.body.highlight();
            		},
					notifyDrop: function(ddSource, e, data){
						var selectedRecord = ddSource.dragData.selections[0];
						formPanel.getForm().loadRecord(selectedRecord);
						ddSource.grid.store.remove(selectedRecord);
						return(true);
            		}
               	});
               	
            	formDropTarget.addToGroup('formGridDDGroup'); //添加一个可以接受的drag源分组，使form可以接受两个grid的拖放
            });

                    
        </script>
<title>JsonStore</title>
</head>
<body>
<div id="jsonGrid"></div>
</body>
</html>

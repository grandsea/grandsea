<%-- 
    Document   : editorGridPanel
    Created on : 2009-11-19, 14:02:29
    Author     : zhouxh
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="/commons/jspHeadInclude.jsp"></jsp:include>
<script type="text/javascript">
         Ext.onReady(function(){
             var reader = new Ext.data.ArrayReader({},[
                 {name: 'company'},
                 {name: 'price', type: 'float'},
                 {name: 'change', type: 'float'},
                 {name: 'pctChange', type: 'float'},
                 {name: 'lastChange', type: 'date', dateFormat: 'n/j h:ia'},
                 {name: 'industry'},
                 {name: 'desc'},
                 {name: 'cost'}
             ]);

             var proxy = new Ext.data.HttpProxy({
                 url: 'groupingStore.txt'
             });

             var store = new Ext.data.GroupingStore({
                 reader: reader,
                 proxy: proxy,
                 sortInfo: {field:'company', direction:'ASC'},
                 groupField: 'industry'
             });

             store.load();

             var columnModel = new Ext.grid.ColumnModel([
            	 {id:'company',header: "Company", width: 60, sortable: true, dataIndex: 'company'},
                 {header: "Price", width: 20, sortable: true, 
                     renderer: Ext.util.Format.usMoney, 
                     dataIndex: 'price',
                     editor: new Ext.form.NumberField({
                         allowBlank: false,
                         allowNegative: false,
                         maxValue: 100000
                         })
                 },
                 {header: "Change", width: 20, 
                	 editor: new Ext.form.NumberField({
                         allowBlank: false,
                         allowNegative: false,
                         maxValue: 100000
                         }),
                     sortable: true, dataIndex: 'change', renderer: Ext.util.Format.usMoney},
                 {header: "Industry", width: 20, sortable: true, dataIndex: 'industry'},
                 {header: "Last Updated", width: 20, 
                     editor: new Ext.form.DateField({
                        allowBlank: false,
                     }),
                     sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'},
                 {header: 'Cost', width:30, 
                         renderer: function(v, params, record){
                         return Ext.util.Format.usMoney(record.data.price * record.data.change);
                     },
                     dataIndex:'cost'}
                 ]);

             var panel = new Ext.grid.EditorGridPanel({
                 store: store,
                 cm: columnModel,
				 clicksToEdit: 1,
                 view: new Ext.grid.GroupingView({
                     forceFit: true,
                     groupTxtTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]}'
                 }),

                 frame: true,
                 width: 800,
                 height: 450,
                 collapsible: true,
                 animCollapse: false,
                 title: 'Grouping Example',
                 iconCls: 'icon-grid',
                 renderTo: 'summaryGrid'
             });
         });
     </script>
<title>Summary累计</title>
</head>
<body>
<div id="summaryGrid"></div>
</body>
</html>

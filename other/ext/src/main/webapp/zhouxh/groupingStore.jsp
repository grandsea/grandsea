<%-- 
    Document   : groupingStore
    Created on : 2009-11-19, 11:26:03
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
                    {name: 'desc'}
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

                var panel = new Ext.grid.GridPanel({
                    store: store,
                    columns:[
                        {id:'company',header: "Company", width: 60, sortable: true, dataIndex: 'company'},
                        {header: "Price", width: 20, sortable: true, renderer: Ext.util.Format.usMoney, dataIndex: 'price'},
                        {header: "Change", width: 20, sortable: true, dataIndex: 'change', renderer: Ext.util.Format.usMoney},
                        {header: "Industry", width: 20, sortable: true, dataIndex: 'industry'},
                        {header: "Last Updated", width: 20, sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'}
                    ],

                    view: new Ext.grid.GroupingView({
                        forceFit: true,
                        groupTxtTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]}'
                    }),

                    frame: true,
                    width: 700,
                    height: 450,
                    collapsible: true,
                    animCollapse: false,
                    title: 'Grouping Example',
                    iconCls: 'icon-grid',
                    renderTo: 'groupingStore'
                });
            });
        </script>
        <title>GroupingStore</title>
    </head>
    <body>
        <div id="groupingStore"></div>
    </body>
</html>

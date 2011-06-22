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

                var store = new Ext.data.Store({ //不是JsonReader
                    proxy: proxy,
                    reader : jsonReader
                });

                store.load();

                var panel = new Ext.grid.GridPanel({
                    store: store,
                    columns: [
                        {id:'firstName', header: 'FirstName', dataIndex:'firstName', width: 160},
                        {header: 'Sex', dataIndex: 'sex', width:160}
                    ],
                    stripeRows: true,
                    autoExpandColumn: 'firstName',
                    height: 400,
                    width: 350,
                    autoSize: true,
                    title: 'JsonGrid'
                });

                panel.render('jsonGrid');
            });
        </script>
        <title>JsonStore</title>
    </head>
    <body>
        <div id="jsonGrid"></div>
    </body>
</html>

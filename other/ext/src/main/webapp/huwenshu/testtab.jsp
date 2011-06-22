<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TabPanel和Tree控件搭配测试</title>
<link rel="stylesheet" type="text/css" media="all" href="../ext/resources/css/ext-all.css" />
<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../ext/ext-all.js"></script>
<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript">Ext.BLANK_IMAGE_URL = '../ext/resources/images/default/s.gif';</script>
<script type="text/javascript">
//左边功能树
var menuTree = new Ext.tree.TreePanel({
    region:'west',
    title:'功能菜单',
    width:180,
    minSize:150,
    maxSize:200,
    split:true,
    autoScroll:true,
    autoHeight:false,
    collapsible:true,
    rootVisable:false, //不显示根节点
    root:new Ext.tree.TreeNode({
        id:'root',
        text:'功能菜单',
        draggable:false,
        expanded:true
    })
});

//添加第一个节点(html)
menuTree.root.appendChild(new Ext.tree.TreeNode({
    id:'htmlPanel',
    text:'通过html打开',
    listeners:{
        'click':function(node, event) {
            event.stopEvent();
            var n = contentPanel.getComponent(node.id);
            if (!n) { //判断是否已经打开该面板
                n = contentPanel.add({
                    'id':node.id,
                    'title':node.text,
                    closable:true,  //通过html载入目标页
                    html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="basicForm.html"></iframe>'
                });
            }
            contentPanel.setActiveTab(n);
        }
    }
}));

//添加第二个节点(autoLoad)
menuTree.root.appendChild(new Ext.tree.TreeNode({
    id:'autoLoadPanel',
    text:'通过autoLoad打开',
    listeners:{
        'click':function(node, event) {
            event.stopEvent();
            var n = contentPanel.getComponent(node.id);
            if (!n) { ////判断是否已经打开该面板
                n = contentPanel.add({
                    'id':node.id,
                    'title':node.text,
                    closable:true,
                    autoLoad:{url:'basicForm.html', scripts:true} //通过autoLoad属性载入目标页,如果要用到脚本,必须加上scripts属性
                });
            }
            contentPanel.setActiveTab(n);
        }
    }
}));

//添加第三个节点(function)
menuTree.root.appendChild(new Ext.tree.TreeNode({
    id:'functionPanel',
    text:'通过函数打开',
    listeners:{
        'click':function(node, event) {
            event.stopEvent();
            var n = contentPanel.getComponent(node.id);
            if (!n) {
                var p = new fnPanel();
                p.id = node.id;
                p.title = node.text;
                n = contentPanel.add(p);
            }
            contentPanel.setActiveTab(n);
        }
    }
}));

//通过扩展来构建要创建的面板
fnPanel = Ext.extend(Ext.Panel, {
    closable:true,
    autoScroll:true,
    layout:'fit', //如果用函数来创建该面板的话,布局必须设置为fit,否则不会显示该面板中的内容

    //创建面板内容
    createFormPanel:function() {
        return new Ext.form.FormPanel({
            buttonAlign:'center',
            labelAlign:'right',
            frame:false,
            bodyBorder:false,
            bodyStyle:'padding:25px',
            items:[{
                xtype:'textfield',
                fieldLabel:'用户名',
                width:350,
                name:'username'
            },{
                xtype:'textfield',
                fieldLabel:'密　码',
                width:350,
                name:'password'
            }],
            buttons:[{text:'登陆'}, {text:'取消'}]
        });
    },

    //重装控件初始化函数,在该函数中完成面板中内容的初始化
    initComponent:function() {
        fnPanel.superclass.initComponent.call(this);
        this.fp = this.createFormPanel();
        this.add(this.fp);
    }
});

//右边具体功能面板区
var contentPanel = new Ext.TabPanel({
    region:'center',
    enableTabScroll:true,
    activeTab:0,
    items:[{
        id:'homePage',
        title:'首页',
        autoScroll:true,
        html:'<div style="position:absolute;color:#ff0000;top:40%;left:40%;">Tree控件和TabPanel控件结合功能演示</div>'
    }]
});

Ext.onReady(function(){
    new Ext.Viewport({
        layout:'border', //使用border布局
        defaults:{activeItem:0},
        items:[menuTree, contentPanel]
    });
});
</script>
</head>
<body>
</body>
</html>
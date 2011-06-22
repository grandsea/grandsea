<% 
String node = request.getParameter("node");
System.out.println(node);
if("source".equals(node)){ %>
[
{text: 'simple', id: 'simple', cls: 'folder', url:'zhouxh/simple'},
{text: 'form', id: 'form', cls: 'folder', url:'zhouxh/form'},
{text: 'menu', id: 'menu', cls: 'folder', url:'zhouxh/menu'},
{text: 'tree', id: 'tree', cls: 'folder', url:'zhouxh/tree'},
{text: 'comboBox', id: 'comboBox', cls: 'folder', url:'zhouxh/comboBox'},
{text: 'window', id: 'window', cls: 'folder', url:'zhouxh/window'},
{text: 'summaryGridPanel.jsp', id: 'summaryGridPanel.jsp', cls: 'file', url:'zhouxh/summaryGridPanel.jsp', leaf: true},
{text: 'progressbar.jsp', id: 'progressbar.jsp', cls: 'file', url:'zhouxh/progressbar.jsp', leaf: true},
{text: 'ddGrid.jsp', id: 'ddGrid.jsp', cls: 'file', url:'zhouxh/ddGrid.jsp', leaf: true},
{text: 'bindGridPanel.jsp', id: 'bindGridPanel.jsp', cls: 'file', url:'zhouxh/bindGridPanel.jsp', leaf: true},
{text: 'pluginGridPanel.jsp', id: 'pluginGridPanel.jsp', cls: 'file', url:'zhouxh/pluginGridPanel.jsp', leaf: true},
{text: 'editorGridPanel', id: 'editorGridPanel', cls: 'file', url:'zhouxh/editorGridPanel.jsp', leaf: true},
{text: 'groupingStore', id: 'groupingStore', cls: 'file', url:'zhouxh/groupingStore.jsp', leaf: true},
{text: 'jsonStore', id: 'jsonStore', cls: 'file', url:'zhouxh/jsonStore.jsp', leaf: true},
{text: 'basicForm', id: 'basicForm', cls: 'file', url:'form/basicForm.jsp', leaf: true},
{text: 'simpleStore', id: 'simpleStore', cls: 'file', url:'zhouxh/simpleStore.jsp', leaf: true}
]
<%}else if("window".equals(node)){%>
[ 
{text: 'layoutWindow.jsp', id: 'layoutWindow.jsp', cls: 'file',url:'zhouxh/window/layoutWindow.jsp', leaf: true},
{text: 'messageBox.jsp', id: 'messageBox.jsp', cls: 'file',url:'zhouxh/window/messageBox.jsp', leaf: true},
{text: 'Hello.jsp', id: 'Hello.jsp', cls: 'file',url:'zhouxh/window/Hello.jsp', leaf: true} 
]
<%}else if("comboBox".equals(node)){%>
[
{text: 'comboBox.jsp', id: 'comboBox.jsp', cls: 'file',url:'zhouxh/comboBox/comboBox.jsp', leaf: true}
]
<%}else if("tree".equals(node)){%>
[
{text: 'simpleTree.jsp', id: 'simpleTree.jsp', cls: 'file',url:'zhouxh/tree/simpleTree.jsp', leaf: true}
]
<%}else if("menu".equals(node)){%>
[
{text: 'menu.jsp', id: 'menu.jsp', cls: 'file',url:'zhouxh/menu/menu.jsp', leaf: true}
]
<%}else if("form".equals(node)){%>
[
{text: 'complexForm.jsp', id: 'complexForm.jsp', cls: 'file',url:'zhouxh/form/complexForm.jsp', leaf: true},
{text: 'basicForm.jsp', id: 'basicForm.jsp', cls: 'file',url:'zhouxh/form/basicForm.jsp', leaf: true}
]
<%}else if("simple".equals(node)){%>
[
{text: 'call.jsp', id: 'call.jsp', cls: 'file',url:'zhouxh/simple/call.jsp', leaf: true}
]
<%} %>

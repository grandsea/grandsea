<% 
String node = request.getParameter("node");
System.out.println(node);
if("source".equals(node)){ %>
[
{text: 'comboBox', id: 'comboBox', cls: 'folder', url:'zhouxh/comboBox', checked: true},
{text: 'window', id: 'window', cls: 'folder', url:'zhouxh/window', checked: true},
{text: 'progressbar.jsp', id: 'progressbar.jsp', cls: 'file', url:'zhouxh/progressbar.jsp', leaf: true, checked: true},
{text: 'ddGrid.jsp', id: 'ddGrid.jsp', cls: 'file', url:'zhouxh/ddGrid.jsp', leaf: true, checked: true},
{text: 'bindGridPanel.jsp', id: 'bindGridPanel.jsp', cls: 'file', url:'zhouxh/bindGridPanel.jsp', leaf: true, checked: true},
{text: 'pluginGridPanel.jsp', id: 'pluginGridPanel.jsp', cls: 'file', url:'zhouxh/pluginGridPanel.jsp', leaf: true, checked: false},
{text: 'editorGridPanel', id: 'editorGridPanel', cls: 'file', url:'zhouxh/editorGridPanel.jsp', leaf: true, checked: true},
{text: 'groupingStore', id: 'groupingStore', cls: 'file', url:'zhouxh/groupingStore.jsp', leaf: true, checked: true},
{text: 'jsonStore', id: 'jsonStore', cls: 'file', url:'zhouxh/jsonStore.jsp', leaf: true, checked: true},
{text: 'basicForm', id: 'basicForm', cls: 'file', url:'form/basicForm.jsp', leaf: true, checked: true},
{text: 'simpleStore', id: 'simpleStore', cls: 'file', url:'zhouxh/simpleStore.jsp', leaf: true, checked: true}
]
<%}else if("window".equals(node)){%>
[ 
{text: 'layoutWindow.jsp', id: 'layoutWindow.jsp', cls: 'file',url:'zhouxh/window/layoutWindow.jsp', leaf: true, checked: true},
{text: 'messageBox.jsp', id: 'messageBox.jsp', cls: 'file',url:'zhouxh/window/messageBox.jsp', leaf: true, checked: true},
{text: 'Hello.jsp', id: 'Hello.jsp', cls: 'file',url:'zhouxh/window/Hello.jsp', leaf: true, checked: true} 
]
<%}else if("comboBox".equals(node)){%>
[
{text: 'comboBox.jsp', id: 'comboBox.jsp', cls: 'file',url:'zhouxh/comboBox/comboBox.jsp', leaf: true, checked: true}
]
<%} %>

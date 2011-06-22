Ext
		.onReady(function() {

			var tree = new Ext.tree.TreePanel( {
				useArrows : true,
				autoScroll : true,
				animate : true,
				enableDD : true,
				containerScroll : true,
				// collapsed: true,
				border : false,

				dataUrl : 'mainInitMenu.jsp',
				root : {
					nodeType : 'async',
					text : 'Ext JS',
					draggable : false,
					id : 'source',
					expanded : true
				}
			});
			tree.render('tree');

			tree
					.on(
							'nodedrop',
							function(e) {

								if (e.point == 'append') {
									alert('当前"【' + e.dropNode.text
											+ '】"被放到目录"【' + e.target.text
											+ '】"下！');
									var resultUrl = "../info/rss.do?method=treeNodeTuoDong&currenRootId="
											+ e.dropNode.id
											+ "&parentRootId="
											+ e.target.id + "&type=append";
									// var resulthtml =
									// XmlHttpHelper.transmit(false, "get",
									// "text", resultUrl, null, null);
								}

								else if (e.point == 'above') {
									alert('当前"' + e.dropNode.text + '"放在了"'
											+ e.target.text + '"上面！');
									var resultUrl = "../info/rss.do?method=treeNodeTuoDong&currenRootId="
											+ e.dropNode.id
											+ "&parentRootId="
											+ e.target.id + "&type=above";
									// var resulthtml =
									// XmlHttpHelper.transmit(false, "get",
									// "text", resultUrl, null, null);
								} else if (e.point == 'below') {
									alert('当前"' + e.dropNode.text + '"放在了"'
											+ e.target.text + '"下面！');
									var resultUrl = "../info/rss.do?method=treeNodeTuoDong&currenRootId="
											+ e.dropNode.id
											+ "&parentRootId="
											+ e.target.id + "&type=below";
									// var resulthtml =
									// XmlHttpHelper.transmit(false, "get",
									// "text", resultUrl, null, null);
								}

							});
		});
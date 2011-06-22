Ext.onReady(function(){
	Ext.get('confirmButton').on('click',function(){Ext.MessageBox.confirm('confirm','hello',showResult);});
	Ext.get('promptButton').on('click',function(){Ext.MessageBox.prompt('prompt','hello',showButtonAndText);});
	Ext.get('yesNoCancelButton').on('click',function(){
		Ext.MessageBox.show({
			title: 'Save Changes?',
			msg:'You are closing a tab that has unsaved changes',
			buttons: Ext.MessageBox.YESNOCANCEL,
			fn: showResult,
			animEl: 'yesNoCancelButton',
			icon: Ext.MessageBox.QUESTION
		});
	});
	
	Ext.get('multiLinePromptButton').on('click',function(){
		Ext.MessageBox.show({
			title: 'multilinePrompt',
			msg: 'Address',
			buttons: Ext.MessageBox.OKCANCEL,
			multiline: true,
			fn: showButtonAndText,
			animEl: 'multiLinePromptButton'
		});
	});
	
	
	Ext.get('progressButton').on('click',function(){
		Ext.MessageBox.show({
			title: 'progress',
			msg: 'Loading items....',
			progressText: 'Initializing...',
			width: 300,
			progress: true,
			closable: false,
			alimEl: 'progressButton'
		});
		
		var f = function(v){
			return function(){
				if(v == 12){
					Ext.MessageBox.hide();
					Ext.example.msg('Done','You fake items were loaded!');
				}else{
					var i = v / 11;
					Ext.MessageBox.updateProgress(i, Math.round(100* i) + '% completed');
				}
			};
		};
		for(var i = 1; i< 13; i++){
			setTimeout(f(i), i * 500);
		}
	});
	
	Ext.get('waitButton').on('click',function(){
		Ext.MessageBox.show({
			msg: 'Saving you data, please wait...',
			progressText: 'Saving',
			width: 300,
			wait: true,
			waitConfig: {interval:20},
			icon: 'ext-mb-download',
			animEl: 'waitButton'
		});
		setTimeout(function(){
			Ext.MessageBox.hide();
			Ext.example.msg('Done', 'You fake data was saved!');
		}, 4000);
	});
	Ext.get('alertButton').on('click',function(){Ext.MessageBox.alert('confirm','hello',showResult);});
	
	Ext.fly('info').dom.value = Ext.MessageBox.INFO;
	Ext.fly('question').dom.value = Ext.MessageBox.QUESTION;
	Ext.fly('error').dom.value = Ext.MessageBox.ERROR;
	Ext.fly('warning').dom.value = Ext.MessageBox.WARNING;
	
	Ext.get('iconButton').on('click',function(){
		Ext.MessageBox.show({
			title: 'icon MessageBox',
			icon: Ext.fly('icons').dom.value,
			msg: 'Here is a message with an icon!',
			buttons: Ext.MessageBox.OK,
			animEl: 'iconButton',
			fn: showResult
		});
	});
	
	function showResult(button){
		Ext.example.msg('Button Click','You clicked the {0} button', button);
	};
	
	function showButtonAndText(button, text){
		Ext.example.msg('Button Click And Text', 'You clicked the {0} button and input text {1}',button, text);
	};
});
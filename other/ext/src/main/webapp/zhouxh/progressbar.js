Ext.onReady(function() {

	var progressBar = new Ext.ProgressBar( {
		text : 'bar',
		height : '20',
		anchor : '80%'
	});

	var start = new Ext.Button( {
		text : 'start',
		handler : function() {
			Ext.fly('status').update('starting');
			progressBar.show();
			Runner.run(progressBar, start, 10, function() {
				progressBar.reset(true);
				Ext.fly('status').update('done');
			});
		}
	});

	var panel = new Ext.Panel( {
		title : '进度条',
		layout : 'anchor',
		items : [ start, progressBar ]
	});

	panel.render('progressBar');

	var waitButton = Ext.get('waitButton');
	waitButton.on('click',function(){
		waitProgressBar.reset();
	});
	//waitProgressBar
	var waitProgressBar = new Ext.ProgressBar({
		renderTo: 'waitBar',
	});
	waitProgressBar.wait({
		  interval: 100, //bar will move fast!
//		   duration: 5000,
		   increment: 15,
		   text: 'Updating...'
	});
});

// Please do not use the following code as a best practice! :)
var Runner = function() {
	var f = function(v, pbar, btn, count, cb) {
		return function() {
			if (v > count) {
				btn.disabled = false;
				cb();
			} else {
				if (pbar.id == 'pbar4') {
					// give this one a different count style for fun
					var i = v / count;
					pbar.updateProgress(i,
							Math.round(100 * i) + '% completed...');
				} else {
					pbar.updateProgress(v / count, 'Loading item ' + v + ' of '
							+ count + '...');
				}
			}
		};
	};
	return {
		run : function(pbar, btn, count, cb) {
			btn.disabled = true;
			var ms = 5000 / count;
			for ( var i = 1; i < (count + 2); i++) {
				setTimeout(f(i, pbar, btn, count, cb), i * ms);
			}
		}
	}
}();

$(function(){
	$(".btn").click(function(){
		anime({
			targets : '.panel',
			scale : {
				value : 0,
				duration : 300,
				easing : 'easeInOutQuart'
			},
			direction : 'alternate'
		});
	});

	
})


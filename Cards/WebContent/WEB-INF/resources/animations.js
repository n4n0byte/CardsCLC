$(function() {
	$(".btn").click(function() {
		$()
		if ($('#user').valid()) {
			anime({
				targets : '.panel',
				scale : {
					value : 0,
					duration : 300,
					easing : 'easeInOutQuart'
				},
				direction : 'normal	'
			});

		}
	});

})

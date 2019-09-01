function sticky_relocate_category() {
	var window_top = $(window).scrollTop();

	var nav = $('#sticky-anchor_category');

	if (nav.length) {
		var div_top = nav.offset().top;
		if (window_top > div_top) {
			$('#sticky_category').addClass('stick');
			$('#sticky-anchor_category').height(
					$('#sticky_category').outerHeight());
		} else {
			$('#sticky_category').removeClass('stick');
			$('#sticky-anchor_category').height(0);
		}
	}
}

$(function() {
	$(window).scroll(sticky_relocate_category);
	sticky_relocate_category();
});

function sticky_relocate_cart() {
	var window_top = $(window).scrollTop();

	var nav = $('#sticky-anchor_cart');

	if (nav.length) {
		var div_top = nav.offset().top;
		if (window_top > div_top) {
			$('#sticky_cart').addClass('stick1');
			$('#sticky-anchor_cart').height($('#sticky_cart').outerHeight());
		} else {
			$('#sticky_cart').removeClass('stick1');
			$('#sticky-anchor_cart').height(0);
		}
	}
}

$(function() {
	$(window).scroll(sticky_relocate_cart);
	sticky_relocate_cart();
});
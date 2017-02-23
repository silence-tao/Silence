/********************************回到顶部JavaScript代码********************************/
$(function() {
	$(window).on('scroll', function() {
		checkPosition($(window).height());
		showTopBar($(window).scrollTop());
	});

	checkPosition($(window).height());
	showTopBar($(window).scrollTop());
});

function move(dest, speed) {
	if($(window).scrollTop() != 0) {
		if(!$('html, body').is(':animated')) {
			$('html, body').animate({
				scrollTop: dest
			}, speed);
		}
	}
}

function go() {
	$('html, body').scrollTop(0);
}

function checkPosition(pos) {
	if($(window).scrollTop() > pos) {
		$('#backTop').fadeIn();
	} else {
		$('#backTop').fadeOut();
	}
}

function showTopBar(pos) {
	if(pos <= 100) {
		var opacity = pos / 100;
		$(".nav-top").css("opacity", opacity);
	} else {
		$(".nav-top").css("opacity", 1);
	}
}
/********************************回到顶部JavaScript代码********************************/
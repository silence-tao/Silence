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

/********************************遮罩层控制JavaScript代码********************************/
function openShade(id) {
	$("#" + id).show();
}

function closeShade(id) {
	$("#" + id).hide();
}

function inShade(id) {
	$("#" + id).fadeIn();
}

function outShade(id) {
	$("#" + id).fadeOut();
}

function downShade(id) {
	$("#" + id).slideDown();
}

function upShade(id) {
	$("#" + id).slideUp();
}
/********************************遮罩层控制JavaScript代码********************************/
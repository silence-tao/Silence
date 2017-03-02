/********************************回到顶部JavaScript代码********************************/
$(function() {
	$(window).on('scroll', function() {
		checkPosition($(window).height());
		showTopBar($(window).scrollTop());
	});

	checkPosition($(window).height());
	showTopBar($(window).scrollTop());
	
	$('.shade-bar').click(function() {
		if(!topBar) {
			$(this).fadeOut();
		}
	});
	
	$('.shade-bar').children().click(function(event) {
		event.stopPropagation();
	});
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
	if(!topBar && pos <= 100) {
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
var topBar = false;
/********************************history页面JavaScript代码********************************/
function topMobile(func1, leftTitle, centerTitle, func2, rightClass, rightTitle) {
	if(topBar) {
		$('#top-left-btn').find('span').eq(0).removeClass('icon-angle-left');
		$('body').css('overflow', 'hidden');
	} else {
		$('#top-left-btn').find('span').eq(0).addClass('icon-angle-left');
		$('body').css('overflow', 'auto');
	}
	$('#top-left-btn').attr('onclick', func1);
	$('#top-left-btn').find('span.left-title').text(leftTitle);
	$('#top-center-title').text(centerTitle);
	$('#top-right-btn').attr('onclick', func2);
	if(rightTitle == '' || rightTitle == null) {
		$('#top-right-btn').find('span').addClass(rightClass).addClass('right-btn').removeClass('right-title').text('');
	} else {
		$('#top-right-btn').find('span').removeClass(rightClass).removeClass('right-btn').addClass('right-title').text(rightTitle);
	}
}

function backPrevious() {
	
}

function picturePrev(source) {
	if(typeof FileReader === 'undefined') {
		alert("浏览器不支持……");
		return ;
	}
	
	var reader = new FileReader();
	
	reader.onload = function(e) {
		$(source).siblings('img').attr('src', this.result);
	}
	
	reader.readAsDataURL(document.getElementById($(source).attr('id')).files[0]);
}
/********************************history页面JavaScript代码********************************/

/********************************ajax多张图片上传JavaScript代码********************************/
window.silence = {
	ajaxFilesUpload : function(url, data, fileElementIds, successFunc, errorFunc) {
		$.ajaxFileUpload({
			url : url,
			fileElementId : fileElementIds,
			secureuri : false,
			dataType : 'json',
			data : data,
			type : 'POST',
			success: function(data) {
				successFunc(data);
			},
			error: function(data) {
				errorFunc(data);
			}
		});
	}
}
/********************************ajax多张图片上传JavaScript代码********************************/
/********************************回到顶部JavaScript代码********************************/
$(function() {
	$(window).on('scroll', function() {
		checkPosition($(window).height());
		showTopBar($(window).scrollTop());
	});

	checkPosition($(window).height());
	showTopBar($(window).scrollTop());
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
	
	$('.shade-bar').click(function() {
		$(this).fadeOut();
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
function openPopup() {
	topBar = true;
	topMobile('closePopup()', '取消', '添加动态', 'save()', 'icon-plus-circle', '保存');
	downShade('popup-bar');
}

function closePopup() {
	topBar = false;
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
	upShade('popup-bar');
}

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

var imageNum = 1;

function showImage(source) {
	picturePrev(source);
	$(source).siblings('label').remove();
	$(source).parent().removeClass('add-btn').append('<span class="icon-times-circle" onclick="removeImage(this)"></span>');
	var tpl_picture_show = $('#tpl-picture-show').html();
	if($(source).parent().parent().children().length < 9) {
		var picture_show = tpl_picture_show.replace(/\{id\}/g, ++imageNum);
		$(source).parent().parent().append(picture_show);
	}
}

function removeImage(target) {
	$(target).parent().remove();
}
/********************************history页面JavaScript代码********************************/
var basePath = 'http://localhost:8090/';//获取根目录
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

function boxToggle(id) {
	$("#" + id).toggle();
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

/********************************封装函数JavaScript代码********************************/
window.silence = {
	ajaxFilesUpload : function(url, data, fileElementIds, successFunc, errorFunc) {
		$.ajaxFileUpload({
			url : basePath + url,
			fileElementId : fileElementIds,
			secureuri : false,
			dataType : 'json',
			data : data,
			type : 'POST',
			success: function(data) {
				if(!data.success && data.status == -2) {
					window.location.href = basePath + 'user/login';
				} else {
					successFunc(data);
				}
			},
			error: function(data) {
				errorFunc(data);
			}
		});
	},
	ajaxCurrent : function(url, data, successFunc, errorFunc) {
		$.ajax({
            url: basePath + url,
            type : 'POST',
            data: data,
            dataType: 'json',
    		async: true,
            success : function(data) {
            	if(!data.success && data.status == -2) {
					window.location.href = basePath + 'user/login';
				} else {
					successFunc(data);
				}
            },
            error : function(data) {
            	errorFunc(data);
            }
        });
	}
}

function dateFormat(date ,format, loc) {
	var time = {};
	time.Year = date.getFullYear();
	time.TYear = ("" + time.Year).substr(2);
	time.Month = date.getMonth() + 1;
	time.TMonth = time.Month < 10 ? "0" + time.Month : time.Month;
	time.Day = date.getDate();
	time.TDay = time.Day < 10 ? "0" + time.Day : time.Day;
	time.Hour = date.getHours();
	time.THour = time.Hour < 10 ? "0" + time.Hour : time.Hour;
	time.hour = time.Hour < 13 ? time.Hour : time.Hour - 12;
	time.Thour = time.hour < 10 ? "0" + time.hour : time.hour;
	time.Minute = date.getMinutes();
	time.TMinute = time.Minute < 10 ? "0" + time.Minute : time.Minute;
	time.Second = date.getSeconds();
	time.TSecond = time.Second < 10 ? "0" + time.Second : time.Second;
	time.Millisecond = date.getMilliseconds();
	time.Week = date.getDay();
	var MMMArrEn = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec" ];
	var MMMArr = [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
			"十一月", "十二月" ];
	var WeekArrEn = [ "Sun", "Mon", "Tue", "Web", "Thu", "Fri", "Sat" ];
	var WeekArr = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
	var oNumber = time.Millisecond / 1000;
	if (format != undefined && format.replace(/\s/g, "").length > 0) {
		if (loc != undefined && loc == "en") {
			MMMArr = MMMArrEn.slice(0);
			WeekArr = WeekArrEn.slice(0);
		}
		format = format.replace(/yyyy/ig, time.Year)
				.replace(/yyy/ig, time.Year).replace(/yy/ig, time.TYear)
				.replace(/y/ig, time.TYear).replace(/MMM/g,
						MMMArr[time.Month - 1]).replace(/MM/g, time.TMonth)
				.replace(/M/g, time.Month).replace(/dd/ig, time.TDay).replace(
						/d/ig, time.Day).replace(/HH/g, time.THour).replace(
						/H/g, time.Hour).replace(/hh/g, time.Thour).replace(
						/h/g, time.hour).replace(/mm/g, time.TMinute).replace(
						/m/g, time.Minute).replace(/ss/ig, time.TSecond)
				.replace(/s/ig, time.Second).replace(/fff/ig, time.Millisecond)
				.replace(/ff/ig, oNumber.toFixed(2) * 100).replace(/f/ig,
						oNumber.toFixed(1) * 10).replace(/EEE/g,
						WeekArr[time.Week]);
	} else {
		format = time.Year + "-" + time.Month + "-" + time.Day + " "
				+ time.Hour + ":" + time.Minute + ":" + time.Second;
	}
	return format;
} 
/********************************封装函数JavaScript代码********************************/

//退出系统
function loginOut() {
	silence.ajaxCurrent('user/loginOut', {},
		function(data) {
			window.location.href = basePath;
		},
		function(data) {
			console.log(data);
		}
	);
}
//退出系统

//随机头像的生成
function getHeader() {
	var id = 0;
	while(id == 0) {
		id = Math.floor(Math.random()*31);
	}
	$('#user-header').attr('src', '/silence/resources/img/headers/' + id + '.png');
}
//随机头像的生成

/********************************消息提醒JavaScript代码********************************/
function tipsBar(yesOrNo, message) {
	if(yesOrNo) {
		$('#tips-icon').removeClass('icon-close').addClass('icon-check');
	} else {
		$('#tips-icon').removeClass('icon-check').addClass('icon-close');
	}
	$('#tips-box').text(message);
	inShade('tips-bar');
	setTimeout(function() {
		outShade('tips-bar');
	}, 800);
}
/********************************消息提醒JavaScript代码********************************/

/********************************分页JavaScript代码********************************/
function showPages(pages) {
	if(pages.totalCount == 0) {
		return ;
	}
	var pages_list = [];
	var begin = 1;
	if(pages.totalPage > 5 && pages.currentPage > 3) {
		if((pages.currentPage + 2) >= pages.totalPage) {
			begin = pages.totalPage - 4;
		} else {
			begin = pages.currentPage - 2;
		}
	}
	pages_list.push('<a href="javascript:;" onclick="toPage(1)" class="' + (pages.currentPage == 1 ? 'noclick' : '') + '">&lt;&lt;</a>');
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.currentPage - 1) + ')" class="' + (pages.currentPage == 1 ? 'noclick' : '') + '">&lt;</a>');
	for(var i = begin; i <= pages.totalPage && i < begin + 5; i++) {
		pages_list.push('<a href="javascript:;" onclick="toPage(' + i + ')" class="' + (pages.currentPage == i ? 'pre-page' : '') + '">' + i + '</a>');
	}
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.currentPage + 1) + ')" class="' + (pages.currentPage == pages.totalPage ? 'noclick' : '') + '">&gt;&gt;</a>');
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.totalPage) + ')" class="' + (pages.currentPage == pages.totalPage ? 'noclick' : '') + '">&gt;</a>');
	$('.page-bar').html(pages_list.join(''));
}
/********************************分页JavaScript代码********************************/

/********************************会话框JavaScript代码********************************/
function dialog(msg, confirm, close) {
	$('#dialog-text').text(msg);
	inShade('dialog-bar');
	$('#dialog-close').click(function () {
		if(close) {
			close();
		}
		outShade('dialog-bar');
		close = null;
	});
	$('#dialog-confirm').click(function () {
		if(confirm) {
			confirm();
		}
		confirm = null;
		outShade('dialog-bar');
	});
}
/********************************会话框JavaScript代码********************************/

/********************************获取URL参数JavaScript代码********************************/
function getUrlParam() {
    var str = window.location.search;
    var objURL = {};
    str.replace(
        new RegExp("([^?=&]+)(=([^&]*))?", "g"),
        function ($0, $1, $2, $3) {
            objURL[$1] = $3;
        }
    );
    return objURL;
}
/********************************获取URL参数JavaScript代码********************************/
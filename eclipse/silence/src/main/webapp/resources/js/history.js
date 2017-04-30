$(function() {
	$('.loading-shade').show();
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
	silence.ajaxCurrent('/silence/history/gethistories?currentPage=1', {},
		function(data) {
			if(data.success) {
				init(data.data);
				$('.loading-shade').hide();
			} else {
				alert("数据加载失败,请重试");
			}
		},
		function(data) {
			console.log(data);
			$('.loading-shade').hide();
		}
	);
	
	var page = 1;
	var isLoading = true;
	
	$(window).on('scroll', function() {
		if($(window).scrollTop() + $(window).height() >= $(document).height()) {
			if(isLoading && page >= 1) {
				isLoading = !isLoading;
				silence.ajaxCurrent('/silence/history/gethistories?currentPage=' + ++page, {},
					function(data) {
						isLoading = !isLoading;
						if(data.success) {
							init(data.data);
							if(data.data.length <= 0) {
								page = -1;
							}
						} else {
							alert("数据加载失败,请重试");
						}
					},
					function(data) {
						console.log(data);
						isLoading = !isLoading;
					}
				);
			} else {
				$('.loading-bottom').html('到底了哦');
				setTimeout(function() {
					$('.loading-bottom').hide();
				}, 1000);
			}
		}
	});
});

function init(data, isRefresh) {
	var tpl_history_html = $('#tpl_history_html').html();
	var histories_html = [];
	for(var i = 0; i < data.length; i++) {
		var tpl_image_html = '';
		switch(data[i].pictures.length) {
			case 1 :
				tpl_image_html = '<img src="/silenceUpload/{realPath}" class="img-responsive" />';
				break;
			case 2 :
			case 4 :
				tpl_image_html = '<div class="img-2"><img src="/silenceUpload/{realPath}" class="img-responsive" /></div>';
				break;
			default :
				tpl_image_html = '<div class="img-3"><img src="/silenceUpload/{realPath}" class="img-responsive" /></div>';
				break;
		}
		var images_html = [];
		for(var j = 0; j < data[i].pictures.length; j++) {
			var image_html = tpl_image_html.replace(/\{realPath\}/g, data[i].pictures[j]);
			images_html.push(image_html);
		}
		var history_html = tpl_history_html.replace(/\{time\}/g, dateFormat(new Date(data[i].recordTime), "HH:mm"))
										.replace(/\{title\}/g, data[i].title)
										.replace(/\{content\}/g, data[i].content)
										.replace(/\{historyId\}/g, data[i].historyId)
										.replace(/\{pictures\}/g, images_html.join(''))
										.replace(/\{date\}/g, dateFormat(new Date(data[i].recordTime), "yyyy-MM-dd"));
		histories_html.push(history_html);
	}
	if(isRefresh) {
		$('#cd-timeline').html(histories_html.join(''));
	} else {
		$('#cd-timeline').append(histories_html.join(''));
	}
}

function openPopup() {
	topBar = true;
	topMobile('closePopup()', '取消', '添加动态', 'saveHistory()', 'icon-plus-circle', '保存');
	downShade('popup-bar');
}

function closePopup() {
	topBar = false;
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
	upShade('popup-bar');
	removeAllImages();
}

function popupBar() {
	removeAllImages();
	inShade('popup-bar');
}

var imageNo = 1;
var imageNum = 0;

function showImage(source) {
	picturePrev(source);
	$(source).siblings('label').remove();
	$(source).parent().removeClass('add-btn').append('<span class="icon-times-circle" onclick="removeImage(this)"></span>');
	var tpl_picture_show = $('#tpl-picture-show').html();
	if($(source).parent().parent().children().length < 9) {
		var picture_show = tpl_picture_show.replace(/\{id\}/g, ++imageNo);
		$(source).parent().parent().append(picture_show);
	}
	imageNum++;
}

function removeImage(target) {
	if(--imageNum == 8) {
		var tpl_picture_show = $('#tpl-picture-show').html();
		var picture_show = tpl_picture_show.replace(/\{id\}/g, ++imageNo);
		$(target).parent().parent().append(picture_show);
	}
	$(target).parent().remove();
}

function removeAllImages() {
	$('#picture-list-bar').empty();
	var tpl_picture_show = $('#tpl-picture-show').html();
	var picture_show = tpl_picture_show.replace(/\{id\}/g, 1);
	$('#picture-list-bar').append(picture_show);
	imageNo = 1;
	$('#history-title').val('');
	$('#history-content').val('');
	$('#popup-box-message').text('');
}

function saveHistory() {
	var title = $('#history-title').val();
	var content = $('#history-content').val();
	if(title == '' || title == null || !title) {
		$('#popup-box-message').text('标题不能为空');
		return ;
	}
	if(content == '' || content == null || !content) {
		$('#popup-box-message').text('内容不能为空');
		return ;
	}
	var data = {};
	data.title = title;
	data.content = content;
	var fileElementIds = new Array();
	$('#picture-list-bar').find('input').each(function() {
		if($(this).val() != '') {
			fileElementIds.push($(this).attr('id'));
		}
	});
	silence.ajaxFilesUpload('/silence/history/savehistory',
		data,
		fileElementIds,
		function(data) {
			if(topBar) {
				closePopup();
			} else {
				outShade('popup-bar');
			}
			init(data.data, true);
			move(0, 350);
		},
		function(data) {
			$('#popup-box-message').text('保存失败,请重试');
		}
	);
}
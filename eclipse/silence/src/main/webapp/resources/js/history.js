$(function() {
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
	silence.ajaxCurrent('/silence/about/gethistories?currentPage=1', {},
		function(data) {
			if(data.success) {
				init(data.data);
			} else {
				alert("数据加载失败,请重试");
			}
		},
		function(data) {
			console.log(data);
		}
	);
});

function init(data) {
	var tpl_history_html = $('#tpl_history_html').html();
	var histories_html = [];
	for(var i = 0; i < data.length; i++) {
		var tpl_image_html = '';
		switch(data[i].pictures.length) {
			case 1 :
				tpl_image_html = '<img src="' + basePath + 'silenceUpload/{realPath}" class="img-responsive" />';
				break;
			case 2 :
			case 4 :
				tpl_image_html = '<div class="img-2"><img src="' + basePath + 'silenceUpload/{realPath}" class="img-responsive" /></div>';
				break;
			default :
				tpl_image_html = '<div class="img-3"><img src="' + basePath + 'silenceUpload/{realPath}" class="img-responsive" /></div>';
				break;
		}
		var images_html = [];
		for(var j = 0; j < data[i].pictures.length; j++) {
			var image_html = tpl_image_html.replace(/\{realPath\}/g, data[i].pictures[j]);
			images_html.push(image_html);
		}
		var history_html = tpl_history_html.replace(/\{time\}/g, new Date(data[i].recordTime).format("HH:mm"))
										.replace(/\{title\}/g, data[i].title)
										.replace(/\{content\}/g, data[i].content)
										.replace(/\{pictures\}/g, images_html.join(''))
										.replace(/\{date\}/g, new Date(data[i].recordTime).format("yyyy-MM-dd"));
		histories_html.push(history_html);
	}
	$('#cd-timeline').html(histories_html.join(''));
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
		$('#popupd-box-message').text('标题不能为空');
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
	silence.ajaxFilesUpload('/silence/about/savehistory',
		data,
		fileElementIds,
		function(data) {
			if(data.success) {
				if(topBar) {
					closePopup();
				} else {
					outShade('popup-bar');
				}
				init(data.data);
				move(0, 350);
			} else {
				alert("上传失败,请重试");
			}
		},
		function(data) {
			console.log(data);
		}
	);
}
$(function() {
	topMobile('backPrevious()', '返回', '我的动态', 'openPopup()', 'icon-plus-circle', '');
});

function openPopup() {
	topBar = true;
	topMobile('closePopup()', '取消', '添加动态', 'save()', 'icon-plus-circle', '保存');
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
			console.log(data);
		},
		function(data) {
			console.log(data);
		}
	);
}
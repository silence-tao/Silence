$(function() {
	getAllUser(1);
});

function getAllUser(currentPage) {
	var json = {};
	json.currentPage = currentPage;
	json.pageSize = 20;
	silence.ajaxCurrent('user/getAllUser', json,
		function(data) {
			showAllUser(data);
			console.log(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showAllUser(data) {
	var users = data.data.users;
	var userList = [];
	for(var i = 0; i < users.length; i++) {
		var param = [];
		var user = users[i];
		param.push('<td>' + (i + 1) + '</td>');
		param.push('<td>' + user.username + '</td>');
		param.push('<td>' + user.nikename + '</td>');
		param.push('<td>' + user.registerIp + '</td>');
		param.push('<td>' + dateFormat(new Date(user.registerTime), "yyyy-MM-dd HH:mm") + '</td>');
		param.push('<td>' + user.userRank + '</td>');
		param.push('<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>');
		userList.push('<tr>' + param.join('') + '</tr>');
	}
	$('tbody').html(userList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getAllUser(page);
	move(120, 350);
}
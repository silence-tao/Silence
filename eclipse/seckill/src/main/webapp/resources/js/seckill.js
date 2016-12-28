//存放主要交互逻辑js代码
//seckill.detail.init(params);
var seckill = {
	//封装秒杀相关Ajax的URL
	URL : {
		
	},
	//验证手机号
	validatePhone : function(phone) {
		if(phone && phone.length == 11 && !isNaN(phone)) {
			return true;
		} else {
			return false;
		}
	},
	//详情页秒杀逻辑
	detail : {
		//详情页初始化
		init : function(params) {
			//手机验证和登录,计时交互
			//规划交互流程
			//在cookie中查找手机号
			var killPhone = $.cookie('killPhone');
			var seckillId = params['seckillId'];
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			//验证手机
			if(!seckill.validatePhone(killPhone)) {
				//绑定phone
				//控制输出
				var killPhoneModal = $("#killPhoneModal");
				killPhoneModal.modal({
					show : true,//显示弹出层
					backdrop : 'static',//禁止位置关闭
					keyboard : false//关闭键盘事件
				});
				$("#killPhoneBtn").click(function() {
					var inputPhone = $("#killPhoneKey").val();
					if(seckill.validatePhone(inputPhone)) {
						//刷新页面
						$.cookie('killPhone', inputPhone, {expires : 7, path : '/seckill'})
						window.location.reload();
					} else {
						$("#killPhoneMessage").hide().html('').show();
					}
				});
			}
		}
	}
};
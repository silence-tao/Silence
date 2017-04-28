<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String pathFooter = request.getContextPath();
	String baseFooter = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathFooter+"/";
%>
<footer>
	<div class="container">
		<div class="footer-box">
			友情链接：
			<a href="http://www.yangqq.com" target="_blank">杨青个人博客</a>
			<a href="http://www.chinaliaowei.com/zhenshifu/#/" target="_blank">臻食府</a>
			<a href="http://www.szqlovepk.club/" target="_blank">花之物语</a>
		</div>
		<div class="footer-box">
			<a href="/silence/about">关于博主</a>
			<a href="https://user.qzone.qq.com/1228714091/infocenter?ptsig=Wp3IEfUGFRD4hWZB8B0K7MyKkV8KHx--NqiifhxuwX4_" target="_blank">QQ空间</a>
			<a href="http://weibo.com/3749857687/profile?rightmod=1&wvr=6&mod=personinfo&is_all=1" target="_blank">新浪微博</a>
			<a href="" target="_blank"></a>
			<a href="" target="_blank"></a>
		</div>
		<div class="footer-box">
			Copyright&nbsp;&copy;&nbsp;Design By Silence and All Rights Reversed.&nbsp;赣ICP备16012352号-1
		</div>
	</div>
</footer>

<div class="toolbar hidden-md hidden-sm hidden-xs">
	<c:choose>
		<c:when test="${empty userInfo }">
			<a href="user/login" title="我要登录" class="toolbar-item toolbar-item-login">
				<span class="toolbar-btn"></span>
			</a>
		</c:when>
		<c:otherwise>
			<div class="user-box">
				<a href="javascript:;" title="Silence" class="toolbar-item toolbar-item-user">
					<span class="toolbar-img">
						<img src="/silence/resources/img/14749103673516675.jpg" />
					</span>
				</a>
				<div class="user-card">
					<div class="user-info">
						<div class="user-bg">
							<img src="/silence/resources/img/background.jpg" class="img-responsive" />
						</div>
						<div class="user-header">
							<a href="#" title="个人中心"><img src="/silence/resources/img/14749103673516675.jpg"/></a>
						</div>
						<p class="user-name">Silence</p>
					</div>
					<div class="menu-list">
						<a href="#" title="个人中心"><span class="icon-home2"></span></a>
						<a href="#" title="消息中心"><span class="icon-envelope"><span class="message-num">9</span></span></a>
						<a href="#" title="文章管理"><span class="icon-books"></span></a>
						<a href="#" title="用户管理"><span class="icon-users2"></span></a>
						<a href="#" title="安全退出"><span class="icon-power-off"></span></a>
					</div>
				</div>
				<span class="msg-num">9</span>
			</div>
		</c:otherwise>
	</c:choose>
	
	<div class="qrcode-box">
		<a href="javascript:;" title="加我好友" class="toolbar-item toolbar-item-qq">
			<span class="toolbar-btn"></span>
		</a>
		<div class="qrcode">
			扫描二维码<br />
			加我为QQ好友
			<img src="/silence/resources/img/qrcodeforqq.jpg" width="160" height="160"/>
		</div>
	</div>
	
	<a href="javascript:;" id="backTop" title="回到顶部" class="toolbar-item toolbar-item-top" onclick="move(0, 350)">
		<span class="toolbar-btn"></span>
	</a>
</div>
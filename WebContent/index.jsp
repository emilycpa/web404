<%@page import="java.util.Calendar"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.database.po.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.uniquery.UnicomQuery"%>
<%@page import="com.util.DesUtil"%>
<%@page import="com.util.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.html"%>
<%@ page import="com.database.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userAgent = request.getHeader("User-Agent");
	boolean flag_type2 = false;

	String num = request.getHeader("x-up-calling-line-id");
	// type=1默认，type＝2黄色网站
	int type = 1;
	try {
		type = Integer.parseInt(request.getParameter("type"));
	} catch (Exception e) {
		type = 1;
	}

	String encryptMobile = "";

	if (num != null && !num.equals("")) {
		try {
			String mobile = num.substring(2);
			request.setAttribute("mobile", mobile);
			encryptMobile = DesUtil.encrypt(mobile);
			//url = "http://wap.10010hb.net/hbwebvas/wap/netData.jsp?usernumber=" + encryptMobile;
			DataBaseUtil.addAccessRecord(mobile, userAgent, type);
			List<Product> productData = new ArrayList<Product>();
			Product p = new Product();
			
			p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201606281422290015");
			p.setImgUrl("http://113.57.230.176:8888/404/images/100043.png");
			p.setName("10元包150M流量包");
			p.setCode("1201603021209160015");
			productData.add(p);
			
			p = new Product();
			p.setImgUrl("http://113.57.230.176:8888/404/images/1000026.png");
			p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021219290032");
			p.setName("微信10元流量包");
			p.setCode("1201603021219290032");
			productData.add(p);
			
			p = new Product();
			p.setImgUrl("http://113.57.230.176:8888/404/images/100045.png");
			p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201606281509110020");
			p.setName("10元包750M流量包");
			p.setCode("1201606281509110020");
			productData.add(p);
			/*
			UnicomQuery query = new UnicomQuery();
			List<Product> tempData = query.queryProduct(mobile);

			 if (tempData.size() == 1) {
				productData.add(tempData.get(0));
				p = new Product();
				p.setImgUrl("http://113.57.230.176:8888/404/images/1000026.png");
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021219290032");
				p.setName("微信10元流量包");
				p.setCode("1201606281422290015");
				productData.add(p);
			} else if (tempData.size() > 1) {
				productData.add(tempData.get(0));
				productData.add(tempData.get(1));
			} else {
				p = new Product();
				p.setImgUrl("http://113.57.230.176:8888/404/images/1000026.png");
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021219290032");
				p.setName("微信10元流量包");
				p.setCode("1201603021219290032");
				productData.add(p);
				p = new Product();
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201606281422290015");
				p.setImgUrl("http://113.57.230.176:8888/404/images/100043.png");
				p.setName("10元包150M流量包");
				p.setCode("1201603021209160015");
				productData.add(p);
			} */
			request.setAttribute("products", productData);
		} catch (Exception e) {

		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<script src="2.js"></script>
<!--  <script type='text/javascript'  src='http://113.57.230.176:8888/404/ddd.js'></script>-->

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="mobile-web-app-capable" content="yes" />

<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />


<meta name="baidu_union_verify"
	content="08a6f05465d25ea42ea22cca8ebd3c05"/>







<link rel="stylesheet" href="assets/css/amazeui.min.css">


<link rel="stylesheet" href="assets/css/app.css">


</head>
<title>404</title>

</head>

<body style="background-color: #ffffff">






	<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
		<div class="am-modal-dialog">

			<div class="am-modal-bd">
				<a href="http://h5.97csw.com/?channelid=135"><img
					id="imgContent" src="images/400300.jpg" width="100%" /></a>
			</div>

		</div>
	</div>




	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="images/001_r2_c2.jpg" width="100%" /></td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><a
				href="http://1.cyread.cn/Lottery/index.html?upid=1019"><img
					src="images/1080X360.jpg" width="100%" /></a></td>
		</tr>
	</table>


	<ul data-am-widget="gallery"
		class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default"
		data-am-gallery="{pureview: false}">
		<li>
			<div class="am-gallery-item">
				<a href="http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201606281415090012" class=""> <img
					src="images/100013.png" alt="" />
				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a href="http://c.tb.cn/c.ywSm" class=""> <img
					src="images/2.jpg" />
				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a
					href="http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201606281431000019"
					class=""> <img src="images/100047.png" />
				</a>
			</div>
		</li>
	</ul>



	<ul data-am-widget="gallery"
		style="left: 0px; bottom: 0px; position: fixed; z-index: 9999; width: 100%;"
		class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default"
		data-am-gallery="{pureview: false}">
		<c:forEach items="${products}" var="item">
			<li>
				<div class="am-gallery-item">
					<a href="${item.url}" class=""
						onclick="addOrderRecord('${item.code}','${mobile}')"> <img
						src="${item.imgUrl}" alt="" />
					</a>
				</div>
			</li>
		</c:forEach>
	</ul>






	<div data-am-widget="tabs"
		class="am-tabs am-tabs-d2 am-margin-horizontal-0">
		<ul class="am-tabs-nav am-cf">
			<li class="am-active"><a href="[data-tab-panel-0]">国内新闻444</a></li>
			<li class=""><a href="[data-tab-panel-1]">视频排行</a></li>
			<li class=""><a href="[data-tab-panel-2]">热门导购</a></li>
		</ul>
		<div class="am-tabs-bd">
			<div data-tab-panel-0 class="am-tab-panel am-active">
				<!-- 百度新闻 -->
				<script language="JavaScript" type="text/JavaScript"
					src="http://news.baidu.com/n?cmd=1&class=civilnews&pn=1&tn=newsbrofcu"></script>
			</div>
			<div data-tab-panel-1 class="am-tab-panel">
				<!-- 搜狐视频 -->
				<iframe id="f" width="100%" src="http://info.lm.tv.sohu.com/c/0000000bb77d04b441ee2c587a55089c01f65da4xdl/23652.do" frameborder="no" border="0" marginwidth="0" marginheight="0" allowtransparency="yes" scrolling="NO"> </iframe>
				<iframe id="d" width="100%" src="http://info.lm.tv.sohu.com/csp/0000000bb77d04b441ee2c5814ca41adb0c91609xdl/23652.do" frameborder="no" border="0" marginwidth="0" marginheight="0" allowtransparency="yes" scrolling="NO"> </iframe>
			</div>
			<div data-tab-panel-2 class="am-tab-panel">


				<div data-am-widget="list_news"
					class="am-list-news am-list-news-default">

					<div class="am-list-news-bd">
						<ul class="am-list">
							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/P9M34Xx" class="">天猫红包潮疯狂来袭手慢无</a>
									</h3>


									<div class="am-list-item-text">盛夏狂欢夜，红包抢不停</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/P9M34Xx" class=""> <img
										src="https://gw.alicdn.com/tps/TB1OYpqKpXXXXcGXpXXXXXXXXXX-520-600.jpg_500x1000q90.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>



							<!--缩略图在标题右边-->
							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/3Lu64Xx" class="">FANLUD
											热销爆款 仅售39.00 二条在减10元</a>
									</h3>


									<div class="am-list-item-text">休闲裤短裤男中裤5分裤修身短裤男夏天沙滩裤子韩版五分裤男夏季</div>

								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/3Lu64Xx" class=""> <img
										src="https://img.alicdn.com/imgextra/i4/1832316018/TB2uPFipXXXXXcqXpXXXXXXXXXX_!!1832316018.jpg"
										alt="我很囧，你保重....晒晒旅行中的那些囧！" />
									</a>
								</div>
							</li>
							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/JZV64Xx" class="">8090风格牛仔馆
											特价促销低至38.6元</a>
									</h3>


									<div class="am-list-item-text">春夏新款长裤青少年显瘦修身牛仔裤男小脚弹力男式青年纯棉长裤潮</div>

								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/JZV64Xx" class=""> <img
										src="https://gd3.alicdn.com/bao/uploaded/i3/1070610738/TB2AUh7ipXXXXaCXXXXXXXXXXXX_!!1070610738.jpg_400x400.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/oiK64Xx" class="">甜蜜丽莎新款韩版女装两件套69.00元抢购中</a>
									</h3>


									<div class="am-list-item-text">"2016夏季新款韩版女装雪纺小清新连衣裙子夏中长款套装裙两件套
										送原装腰带 送原装腰带 送原装腰带 送原装腰带"</div>

								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/oiK64Xx" class=""> <img
										src="https://img.alicdn.com/imgextra/i2/2003880722/TB2BlG4npXXXXc6XXXXXXXXXXXX_!!2003880722.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/ypl54Xx" class="">2016春夏季新款韩版短裤只需17.5元噢</a>
									</h3>


									<div class="am-list-item-text">仅此一天
										早买早便宜。选择我们的理由：不缩水，不起球，做工好，性价比高！上身效果超好的！一条百搭短裤可以让你随意变化更多美丽的身影，如此的简单百搭短裤是MM夏季不容错过的选择哦！</div>

								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/ypl54Xx" class=""> <img
										src="https://gd2.alicdn.com/bao/uploaded/i2/TB11Y1qHVXXXXb7XVXXXXXXXXXX_!!0-item_pic.jpg_400x400.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/sbZ54Xx" class="">倾澈运动户外专营店低价潮来袭
											游泳套装45.00元起售</a>
									</h3>


									<div class="am-list-item-text">男士防水鲨鱼皮平角泳裤 泡温泉泳衣游泳套装
										防水泳帽+电镀泳镜</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/sbZ54Xx" class=""> <img
										src="https://img.alicdn.com/bao/uploaded/i3/TB1BjsULXXXXXXZXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>

							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://s.click.taobao.com/Q0854Xx" class="">纯棉船袜春夏季薄款
											7双7色礼盒17.8元粉丝狂欢节</a>
									</h3>


									<div class="am-list-item-text">唯卡诺袜子女 船袜女纯棉袜春夏季薄款
										短袜浅口低帮隐形韩国女袜</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://s.click.taobao.com/Q0854Xx" class=""> <img
										src="https://img.alicdn.com/bao/uploaded/i2/1776697791/TB24PqeoXXXXXbwXXXXXXXXXXXX_!!1776697791.jpg_430x430q90.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>

							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a
											href="http://union.click.jd.com/jdc?e=&p=AyIHZR5aEQIUAFMcXiUCEwdWE1oWABYDUisfSlpMWGVCHlBDGRlLQx5BXg1bSkAOClBMW0tdC1ZWDEANTx0KUkBCDUUEG0RCRAFjDhkCEwdWE1oWABYDUisHZURTVyNPBnB1UlhPSQNrdm9gF28dGQ4iBFEZWxYBEgRTK1gRABIFUhpYFDIiYSgrGnsBEwVRGlslBxIAVhpYEQUVN1UeXBEEGw9UG1IUAhU3Ug%3D%3D&t=W1dCFBBFC1pXUwkEBwpZRxgHRQcLREJEAQUcTVZUGAVJHk1cTQkTSxhBekcLVRpbFgoTBFcfXxI%3D"
											class="">夏季控油利器48.3元即刻拥有 尽在佩佩彩妆 </a>
									</h3>


									<div class="am-list-item-text">佩佩(PEIPEI) 夏季控油必备
										轻透干湿两用粉饼保湿 10g 粉质细腻 防水定妆干粉</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a
										href="http://union.click.jd.com/jdc?e=&p=AyIHZR5aEQIUAFMcXiUCEwdWE1oWABYDUisfSlpMWGVCHlBDGRlLQx5BXg1bSkAOClBMW0tdC1ZWDEANTx0KUkBCDUUEG0RCRAFjDhkCEwdWE1oWABYDUisHZURTVyNPBnB1UlhPSQNrdm9gF28dGQ4iBFEZWxYBEgRTK1gRABIFUhpYFDIiYSgrGnsBEwVRGlslBxIAVhpYEQUVN1UeXBEEGw9UG1IUAhU3Ug%3D%3D&t=W1dCFBBFC1pXUwkEBwpZRxgHRQcLREJEAQUcTVZUGAVJHk1cTQkTSxhBekcLVRpbFgoTBFcfXxI%3D"
										class=""> <img
										src="http://img11.360buyimg.com/n1/jfs/t2713/342/1523235219/148574/5aa5ecb4/57413e71Nd226793d.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>

							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a
											href="http://union.click.jd.com/jdc?e=0&p=AyIHVCtaJQMiQwpDBUoyS0IQWlALHE4YDk5ER1xOGWUfXk9FSU8WWzhPBVpOM045ZRwXew1dVxkyEQNXG1gWAhEBZRhfFwIQAFQYWiUydHplUDUUMhcHUhtdEgYWBGUbXhIGFA5dGFITCxIFZRxrwoq10%2Bi9jYOix4rzK2sl&t=W1dCFBBFC14NXAAECUteDA%3D%3D"
											class="">狂欢主会场，好货6.18元抢</a>
									</h3>


									<div class="am-list-item-text">京东6.18来啦</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a
										href="http://union.click.jd.com/jdc?e=0&p=AyIHVCtaJQMiQwpDBUoyS0IQWlALHE4YDk5ER1xOGWUfXk9FSU8WWzhPBVpOM045ZRwXew1dVxkyEQNXG1gWAhEBZRhfFwIQAFQYWiUydHplUDUUMhcHUhtdEgYWBGUbXhIGFA5dGFITCxIFZRxrwoq10%2Bi9jYOix4rzK2sl&t=W1dCFBBFC14NXAAECUteDA%3D%3D"
										class=""> <img
										src="http://img20.360buyimg.com/cms/jfs/t2707/291/1838581437/174474/5ee5a438/574dc294N076fd7ae.jpg"
										alt="我最喜欢的一张画" />
									</a>
								</div>

							</li>



							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://h5.97csw.com/?channelid=135" class="">超神游戏中心好玩不断惊喜连连</a>
									</h3>


									<div class="am-list-item-text">您提供好玩的单机游戏下载服务,这里有好玩的单机游戏下载大全中文版下载</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://h5.97csw.com/?channelid=135" class=""> <img
										src="images/xx2.jpg" />
									</a>
								</div>
							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a
											href="http://h5.97csw.com/play.aspx?gameid=1000&channelid=577"
											class="">时下最热门游戏之一的疯狂捕鱼来啦</a>
									</h3>


									<div class="am-list-item-text">疯狂捕鱼是一款卡通益智游戏，这是继远洋渔业，第一英雄杰克克服困难艰辛的旅程，在大西洋海底冒险。他收获的美人鱼，珍珠，玛瑙，壳，但他不满足现状，他继续挑战自己，他想继续自己的梦想，他要寻找那传说中的海洋之心。</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a
										href="http://h5.97csw.com/play.aspx?gameid=1000&channelid=577"
										class=""> <img src="images/xx3.jpg" alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>

							<li
								class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
								<div class=" am-u-sm-8 am-list-main">
									<h3 class="am-list-item-hd">
										<a href="http://www.mychebao.com/?isBaiDu=30040" class="">车置宝
											专业免费的上门服务</a>
									</h3>


									<div class="am-list-item-text">最专业的二手车市场,自主研发的领先国际的VPQS检测体系，150项检测项目和1602个检测标准，准确还原您的爱车价值</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb">
									<a href="http://www.mychebao.com/?isBaiDu=30040" class="">
										<img src="images/xx1.jpg" alt="我最喜欢的一张画" />
									</a>
								</div>
							</li>
						</ul>
					</div>

				</div>
				
			</div>
		</div>
	</div>

	
<br>
<br>
<br>
<br>
<br>
<br>
<br>



	<script src="assets/js/jquery.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>

	
</body>
</html>

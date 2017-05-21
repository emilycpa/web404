
<%@ page language="java"
	import="java.util.*,javax.servlet.http.Cookie,com.database.DataBaseUtil,net.sf.json.JSONArray,net.sf.json.JSONObject"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String num = request.getHeader("x-up-calling-line-id");
	String mobile = "19999999999";
	//response.addHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");  

	//response.setHeader("Access-Control-Allow-Origin", "*");
	//response.setHeader("Access-Control-Allow-Methods:POST,GET","*");
    
	if (num != null && !num.equals("")) {
		mobile = num.substring(2);
	}

	
	Cookie cookie1;
	int flag =1;
	int reqType = Integer.parseInt(request.getParameter("reqType"));
	String url = request.getParameter("url");// 用户访问网站的域名
	
	boolean isok = false;// 是否可操作
	Cookie[] cookies = request.getCookies();
     Cookie sCookie=null;
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				
				if (cookies[i].getName().equals("popFlagForAbc123123")
						|| cookies[i].getName() == "popFlagForAbc123123") {
					sCookie=cookies[i];
					//System.out.println("cookies is "+cookies[i].getName());
					isok = false;
				}
			}
			}
	
		//DataBaseUtil.addrecord(mobile, url);// 插入历史记录表,pv查询用
		// 先判断cookie,无cookie的先决断可进行操作
		// response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");   
		
			if (sCookie == null)// 没有cookie，可以操作
			{
				Cookie cookie = new Cookie("popFlagForAbc123123",  Integer.toString(flag));
				//response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\""); 
				//response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
	            //response.addHeader("Content-Encoding:", "utf-8");
				//response.setHeader("P3P","CP=CAO PSA OUR");
				// response.setContentType("text/html;charset=utf-8");
				// response.setHeader("P3P", "CP=\"IDC DSP COR CURa ADMa OUR IND PHY ONL COM STA\"");
				//response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");   
				cookie.setDomain(".daoyi027.com");
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
				isok = true;
				//System.out.println("cookies is null" + url);

			} else {
				
				
				    flag=Integer.parseInt(sCookie.getValue())+1;
					Cookie cookie = new Cookie("popFlagForAbc123123", Integer.toString(flag));
					
					
					cookie.setDomain(".daoyi027.com");
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24);
					response.addCookie(cookie);
					isok = false;
					//System.out.println("sCookie.getValue()" + sCookie.getValue());

				
			}
			

		

		
	
	

	
	
%>



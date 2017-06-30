package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PoAction
 */
public class BoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsonp = request.getParameter("jsonpcallback");
		String num = request.getHeader("x-up-calling-line-id");
		String mobile = "19999999999";
		// response.addHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI
		// PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");
		JSONObject json = new JSONObject();
		synchronized (this) {
			if (num != null && !num.equals("")) {
				mobile = num.substring(2);
			}

			Cookie cookie1 = null;
			int flag = 0;

			// System.out.println("ad is="+request.getParameter("ad"));
			// request.getHeaders
			boolean isok = true;// 是否可操作
			boolean isok1 = false;// 黄
			boolean isok3 = true;// 二手车
			boolean isok4=true;
			boolean isok2=true;
			boolean isok5 = true;// 2345
			boolean isok6 = true;// 搜狗
			boolean isok7 = true;
			boolean isok8 = true;
			String url = request.getParameter("url");// 用户访问网站的域名

			cookie1 = getCookieByName(request, "FlagForAbc123123");// 取cookie

			if (cookie1 == null)// 没有cookie，可以操作
			{

				isok = true;
				// System.out.println("cookies is null" + url);

			} else {
				// System.out.println("cookie value is=" + cookie1.getValue());
				// cookie1.getValue()
				// System.out.println("flag value is="+flag);
				StringTokenizer st = new StringTokenizer(cookie1.getValue(), "#", true);
			//	 System.out.println("Token size:" + st.countTokens());
				if (st.countTokens() > 8)// 一共4种操作类型
				{
					isok = false;

				} else {
					isok = true;
				}
				if (isok) {
					while (st.hasMoreElements()) {
						String ns = st.nextToken();
						//System.out.println("ns is "+ns);
						int kk=0;
						if (ns == "1" || ns.equals("1")) {

							isok1 = false;
						}
						if (ns == "2" || ns.equals("2")) {

							isok2 = false;
						}
						if (ns == "3" || ns.equals("3")) {
							isok3 = false;
						}
						if(ns=="4"||ns.equals("4"))
						{
							isok4=false;
						}
						if (ns == "5" || ns.equals("5")) {
							isok5 = false;
						}
						if (ns == "6" || ns.equals("6")) {
							isok6 = false;
							//System.out.println("isok6 值 为：false" );
						}
						if (ns == "7" || ns.equals("7")) {
							kk++;
						}
						if(kk>=2)
						{
							isok7 = false;
							//System.out.println("isok7 值 为：false" );
						}
						//System.out.println("k 值 为：" + kk); 
						if (ns == "8" || ns.equals("8")) {
							isok8 = false;
						} 

					}
				}

			}
			int d = DataBaseUtil.getDomainConut(url);// url类型
			//System.out.println("d 值 为：" + d); 
			if (mobile != "19999999999" && isok)// 取得手机号
							// if (isok)   
			{

				Vector<Integer> v1 = DataBaseUtil.getList(mobile);// 用户当日已操作类型,
																	// ad为1黄，2是正常弹出，3车,4为内部广告
			
//			 for(int j=0;j<v1.size();j++)
//			 {
//					 System.out.println("v1 值 为：" +v1.get(j));
//				 
//				 }

				if (isok1 || isok3) {
					// System.out.println("v1.indexOf(new Integer(d)) 值 为：" +
					// v1.indexOf(new Integer(d)));
					isok1 = false;
					isok3 = false;
					if (v1.indexOf(new Integer(d)) == -1)// 在用户操作类型中没有当前url的类型
					{

						if (d == 3)// url为车
						{
							isok3 = true;
						} else if (d == 1)// url黄,判断时间
						{
							
							isok1 = true;
                          /*
							try {

								Calendar date = Calendar.getInstance();

								Calendar date1 = Calendar.getInstance();
								Calendar date2 = Calendar.getInstance();
								date1.set(Calendar.HOUR_OF_DAY, 20);
								date1.set(Calendar.MINUTE, 59);
								date1.set(Calendar.SECOND, 59);
								date2.set(Calendar.HOUR_OF_DAY, 06);
								date2.set(Calendar.MINUTE, 30);
								date2.set(Calendar.SECOND, 00);
								// date2.set(Calendar.DATE,
								// date.get(Calendar.DATE) + 1);
								// System.out.println("时间为：" + new
								// SimpleDateFormat("yyyy-MM-dd
								// HH:mm:ss").format(date.getTime()));
								// System.out.println("开始时间为：" + new
								// SimpleDateFormat("yyyy-MM-dd
								// HH:mm:ss").format(date1.getTime()));
								// System.out.println("结束时间为：" + new
								// SimpleDateFormat("yyyy-MM-dd
								// HH:mm:ss").format(date2.getTime()));

								if (date.after(date1) || date.before(date2)) {

									isok1 = true;
								}s

							} catch (Exception e) {
								e.printStackTrace();
							}*/

						}
					}
				}
				if(isok2)
				{
					//System.out.println(v1.indexOf(4));
					if(v1.indexOf(2)==-1&&v1.indexOf(99)==-1)
					{
						//System.out.println("isok2");
						isok2=true;
					}
					else
					{
						isok2=false;
					}
				}
				if(isok4)
				{
					//System.out.println(v1.indexOf(4));
					if(v1.indexOf(4)==-1&&d == 4)
					{
						//System.out.println("isok4");
						isok4=true;
					}
					else
					{
						isok4=false;
					}
				}
				if (isok5) {
					if (v1.indexOf(5) == -1) {
						isok5 = true;

					} else {
						isok5 = false;

					}
				}
				if (isok6 ) {
					if (v1.indexOf(6) == -1 && DataBaseUtil.getConutHours1(mobile, 5) > 0) {
						isok6 = true;
						//System.out.println("isok6 is true" );
					} else {
						isok6 = false;
						//System.out.println("isok6 is false" );
					}
				}

				if (isok7) {
					int k=0;
					for(int i=0;i<v1.size();i++) {
						
						//System.out.println("vector is "+v1.get(i)); 
						 if(v1.get(i)==7)
						 {
							 k++;
						 }
					}
					//System.out.println("K is "+k); 
					if (k<2) {
						isok7 = true;
					//System.out.println("isok7 is true"); 
					} else {
						isok7 = false;
						//System.out.println("isok7 is false"); 

					}
				}
				if (isok8 ) {
					//isok6 = false;
					if (v1.indexOf(8) == -1 && DataBaseUtil.getConutHours1(mobile, 6) > 0) {

						isok8 = true;
					} else {
						isok8 = false;
				

					}
				}
             
				/*if (isok1) {
					json.put("status", "0");//
					json.put("dese", "1");
				} 
				else*/ 
				if (isok2) {
					json.put("status", "0");//
					json.put("dese2", "2");
				}
				/*
				else if (isok3) {
					json.put("status", "0");//
					json.put("dese", "3");
				}*/
				 
			 if (isok5) {
					json.put("status", "0");// 2345
					json.put("dese5", "5");
				}else if (isok4) {
					json.put("status", "0");//
					json.put("dese4", "4");
				}  
			 else if (isok6) {
					json.put("status", "0");// 
					json.put("dese6", "6");
				}  else if (isok8) {
					json.put("status", "0");// 
					json.put("dese8", "8");
				}
				else {
					json.put("status", "2");// 返回不能操作
					json.put("dese0", "5");
				}

			} else {
				json.put("status", "1");// 返回不能操作
				json.put("dese", "4");
			}
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
            // System.out.println(json.toString());
			out.println(jsonp + "(" + json.toString() + ")");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {

				out.close();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();

		if (null != cookies) {

			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		} else {

		}
		return cookieMap;
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);

		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

}

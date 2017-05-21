package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import com.database.DataBaseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PopAction extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("session is=");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("session is2222=");
		// request.setCharacterEncoding("utf-8");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setHeader("Access-Control-Allow-Methods:POST,GET", "*");
		String jsonp = request.getParameter("jsonpcallback");
		String num = request.getHeader("x-up-calling-line-id");
		String mobile = "19999999999";
		// response.addHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI
		// PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");

		if (num != null && !num.equals("")) {
			mobile = num.substring(2);
		}

		JSONObject json = new JSONObject();
		Cookie cookie1=null;
		int flag = 0;
		int reqType = Integer.parseInt(request.getParameter("reqType"));
		System.out.println("reqType is="+reqType);
		System.out.println("ad is="+request.getParameter("ad"));
		// request.getHeaders
		boolean isok = true;// 是否可操作
		boolean isok1 = true;// 黄
		boolean isok3 = true;// 二手车 
		boolean isok5 = true;// 2345
		boolean isok6 = true;// 搜狗
		if (reqType == 1)// 请求服务器给出操作类型
		{
			String url = request.getParameter("url");// 用户访问网站的域名

			// System.out.println("session is="+sssi);

			// 先判断cookie,无cookie的先决断可进行操作

			cookie1 = getCookieByName(request, "FlagForAbc123123");// 取cookie

			if (cookie1 == null)// 没有cookie，可以操作
			{

				isok = true;
				System.out.println("cookies is null" + url);

			} else {
				System.out.println("cookie value is=" + cookie1.getValue());
				// cookie1.getValue()
				// System.out.println("flag value is="+flag);
				StringTokenizer st = new StringTokenizer(cookie1.getValue(), ",", true);
				System.out.println("Token size:" + st.countTokens());
				if (st.countTokens() == 4)// 一共4种操作类型
				{
					isok = false;

				} else {
					isok = true;
				}
				if (isok) {
					while (st.hasMoreElements()) {
						String ns=st.nextToken();
						if (ns == "1" ||ns.equals("1")) {
							System.out.println("isok1 is false:" + ns);
							isok1 = false;
						}
						if (ns == "3" || ns.equals("3")) {
							isok3 = false;
						}
						if (ns == "5" || ns.equals("5")) {
							isok5 = false;
						}
						if (ns== "6" || ns.equals("6")) {
							isok6 = false;
						}
						System.out.println("Token:" + ns);

					}
				}

			}
			int d = DataBaseUtil.getDomainConut(url);// url类型
			System.out.println("dd is " + d);
			// if (mobile != "19999999999" && isok)// 取得手机号
			if (isok) {
				// 是否有此手机号的操作记录
				// System.out.println("无手机号");
				/*
				 * if (DataBaseUtil.getConut(mobile) == 0) { isok = true; } else
				 * { isok = false; }
				 */
				Vector<Integer> v1 = DataBaseUtil.getList(mobile);// 用户当日已操作类型,
																	// ad为1黄，2是正常弹出，3车,4为内部广告
				for (int i = 0; i < v1.size(); i++) {
					System.out.println("Vector 值 为：" + v1.get(i));
				}
				if (isok1 || isok3) {
					System.out.println("v1.indexOf(new Integer(d)) 值 为：" + v1.indexOf(new Integer(d)));
					isok1 = false;
					isok3 = false;
					if (v1.indexOf(new Integer(d)) == -1)// 在用户操作类型中没有当前url的类型
					{
						
						if (d == 3)// url为车
						{
							isok3 = true;
						} else if (d == 1)// url黄,判断时间
						{
							DateFormat df = new SimpleDateFormat("HH:mm:ss");
							
							try {
								//Date dt1 = df.parse("21:59:59");
								//Date dt2 = df.parse("06:30:30");
								Calendar date = Calendar.getInstance();
								
								Calendar date1=Calendar.getInstance();
								Calendar date2=Calendar.getInstance();
								//date1.set(Calendar.DATE, date.get(Calendar.DATE));
								date1.set(Calendar.HOUR_OF_DAY, 21);
								date1.set(Calendar.MINUTE, 59);
								date1.set(Calendar.SECOND, 59);
								date2.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
								date2.set(Calendar.HOUR_OF_DAY, 06);
								date2.set(Calendar.MINUTE, 30);
								date2.set(Calendar.SECOND, 00);
								System.out.println("时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime()));
								System.out.println("开始时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1.getTime()));
								System.out.println("结束时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2.getTime()));
								if(date.after(date1))
								{
									System.out.println("aaaaaaaa：" );
								}   
								if(date.before(date2))
								{
									System.out.println("bbbbbbbbb：" );
								}
								if (date.after(date1)&&date.before(date2)) {
									System.out.println("gggggggg：" );
									isok1 = true;
								}

							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				}
				if(isok5)
				{
					if (v1.indexOf(5) == -1)
					{
						isok5=true;
						System.out.println("isok5=true" );
					}
					else
					{
						isok5=false;
					System.out.println("isok5=false" );
					}
				}
				if(isok6)
				{
					if (v1.indexOf(6) == -1&& DataBaseUtil.getConutHours(mobile, 5)>0)
					{
						isok6=true;
					}
					else
						isok6=false;
				}
				if(isok1)
				{
					json.put("status", "0");// 黄
					json.put("dese", "1");
				}
				else if(isok3)
				{
					json.put("status", "0");// 车
					json.put("dese", "3");
				}
				else if(isok5)
				{
					json.put("status", "0");// 2345
					json.put("dese", "5");
				}
				else if(isok6)
				{
					json.put("status", "0");// 搜狗
					json.put("dese", "6");
				}
				else
				{
					json.put("status", "1");// 返回不能操作
					json.put("dese", "4");
				}

			}
			else {
				json.put("status", "1");// 返回不能操作
				json.put("dese", "4");
			}

			// System.out.println("d is ="+d);

//			if (isok)// 可以操作
//
//			{
//
//				if (d == 1)// ad为1黄，2是正常弹出，3车,4为内部广告
//				{
//					json.put("status", "0");// 返回可以操作statur为是否操作标识.dese为操作内容标识,dese=0跳转，1=广告，2=点击后弹出
//					json.put("dese", "0");
//				}
//				if (d == 2)// 加载广告
//				{
//					json.put("status", "0");
//					json.put("dese", "1");
//				}
//				if (d == 0)// 点击弹出
//				{
//					json.put("status", "0");
//					json.put("dese", "2");
//				}
//
//			} else {
//				json.put("status", "1");// 返回不能操作
//				json.put("dese", "4");
//			}
		}

		if (reqType == 5)// 弹出事件后得到信息
		{
			int ad = Integer.parseInt((request.getParameter("ad")));
			DataBaseUtil.addAd(mobile, ad);
			String url = request.getParameter("url");// 用户访问网站的域名

			cookie1 = getCookieByName(request, "FlagForAbc123123");// 取cookie
			Cookie cookie;
			if (cookie1 == null)// 没有cookie，可以操作
			{

				cookie = new Cookie("FlagForAbc123123", Integer.toString(ad));// 设置网站cookie

			} else {
				System.out.println("cookie value is=" + cookie1.getValue());
				cookie = new Cookie("FlagForAbc123123", cookie1.getValue() + "," + ad);
				// System.out.println("flag value is="+flag);

			}

			// cookie.setDomain("113.57.230.176");
			cookie.setDomain("127.0.0.1");
			cookie.setPath("/");
			cookie.setMaxAge(getTime());
			response.addCookie(cookie);
			json.put("status", "3");
			json.put("dese", "0");

		}
		if (reqType == 2)// 记录用户行为
		{

			int ad = Integer.parseInt((request.getParameter("ad")));// ad为1黄，2是正常弹出，3车,4为内部广告
			DataBaseUtil.addAd(mobile, ad);

		}
		if (reqType == 3) {
			// System.out.println("无44444444 ");
			String url = request.getParameter("url");// 用户访问网站的域名
			// System.out.println("url is ="+url);
			DataBaseUtil.addrecord(mobile, url);// 插入历史记录表
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();

			out.println(jsonp + "(" + json.toString() + ")");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {

				out.close();
			}
		}

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

	public static boolean getCookieStat() {
		boolean isOk = false;
		return isOk;
	}

	public int getTime() // cookie时间为当天24天过期
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		int second = subSecond(cal.getTime(), new Date());
		if (second <= 0) {
			second = 1;
		}
		return second;
	}

	public static int subSecond(Date date1, Date date2) {
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		int sub = (int) ((d1 - d2) / 1000);
		return sub;
	}

}

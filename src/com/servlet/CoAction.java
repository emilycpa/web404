package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CoAction
 */
public class CoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsonp = request.getParameter("jsonpcallback");
		String num = request.getHeader("x-up-calling-line-id");
		String mobile = "19999999999";
		JSONObject json = new JSONObject();
		Cookie cookie1=null;
		synchronized (this) {
		if (num != null && !num.equals("")) {
			mobile = num.substring(2);
		}

		
		int ad = Integer.parseInt((request.getParameter("ad")));
		
		DataBaseUtil.addAd(mobile, ad);
		//System.out.println("mobile value is=" + mobile);

		cookie1 = getCookieByName(request, "FlagForAbc123123");// 取cookie
		Cookie cookie;
		if (cookie1 == null)// 没有cookie，可以操作
		{

			cookie = new Cookie("FlagForAbc123123", Integer.toString(ad));// 设置网站cookie

		} else {
			//System.out.println("cookie value is=" + cookie1.getValue());
			cookie = new Cookie("FlagForAbc123123", cookie1.getValue() + "," + ad);
			// System.out.println("flag value is="+flag);

		}

		cookie.setDomain("113.57.230.176");
		//cookie.setDomain("192.168.10.101");
		cookie.setPath("/");
		cookie.setMaxAge(getTime());
		response.addCookie(cookie);
		json.put("status", "3");
		json.put("dese", "0");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

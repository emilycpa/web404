package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseUtil;

/**
 * Servlet implementation class PoAction
 */
public class PoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobile = "19999999999";
		//response.addHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");  
		int reqType = Integer.parseInt(request.getParameter("reqType"));
		String num = request.getHeader("x-up-calling-line-id");
		
		if (num != null && !num.equals("")) {
			mobile = num.substring(2);
		}
		if (reqType == 2)// 记录用户行为
		{
			
			int ad = Integer.parseInt((request.getParameter("ad")));// ad为1是直接跳转，2是点击后弹出，3为加载外部js广告,4为内部广告
			DataBaseUtil.addAd(mobile, ad);
			
		}
		if(reqType==3)
		{
			//System.out.println("无44444444 "); 
			String url = request.getParameter("url");// 用户访问网站的域名
			//System.out.println("url is ="+url);
			DataBaseUtil.addrecord(mobile, url);// 插入历史记录表
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

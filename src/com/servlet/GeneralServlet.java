package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GeneralServlet
 */
public class GeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneralServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		try {
			String type = request.getParameter("type");
			if (type.equals("1")) {
				JSONObject popTotal;
				Object temp = request.getSession().getServletContext().getAttribute("pop_total");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(new Date());
				if (temp == null) {
					popTotal = new JSONObject();
					popTotal.put("total", 0);
					popTotal.put("date", date);
				} else {
					popTotal = (JSONObject) temp;
					if (popTotal.get("date").equals(date))
						if (popTotal.getInt("total") < 6000)
							popTotal.put("total", popTotal.getInt("total") + 1);
						else {
							// 日期更新
							popTotal.put("total", 0);
							popTotal.put("date", date);
						}
				}
				request.getSession().getServletContext().setAttribute("pop_total", popTotal);
				if (popTotal.getInt("total") > 6000) {
					json.put("result", 2);
					json.put("desc", "pop end");
				} else {
					json.put("result", 0);
					json.put("desc", "success");
				}
			}
		} catch (Exception e) {
			json.put("result", 1);
			json.put("desc", "error");
		}

		response.getWriter().write(json.toString());
	}

}

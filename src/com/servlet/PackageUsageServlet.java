package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uniquery.UnicomQuery;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class FlowBalanceServlet
 */
public class PackageUsageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageUsageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		JSONObject result = new JSONObject();
		try {
			String phoneNum = request.getParameter("phoneNum");
			String type = request.getParameter("type");
			UnicomQuery query = new UnicomQuery();
			String returnContent = query.packageUsage(phoneNum);
			if (type != null && type.equals("1")) {
				result.put("result", "0");
				result.put("content", returnContent);
			} else if (type != null && type.equals("2")) {
				if (returnContent != null) {
					JSONObject userInfo = JSONObject.fromObject(returnContent);
					if (userInfo.has("resultCode") && userInfo.optString("resultCode").equals("0")) {
						JSONArray records = userInfo.getJSONArray("records");
						float total = 0, used = 0;

						for (int i = 0; i < records.size(); i++) {
							JSONObject record = records.getJSONObject(i);
							if (record.has("yhdw") && record.optString("yhdw").equals("3")) {
								// 排除掉免费业务使用量
								if (record.has("zfmc") && record.optString("zfmc").equals("免费业务使用量"))
									continue;
								total += record.optDouble("yhze");
								used += record.optDouble("yhyy");
							}
						}
						result.put("result", "0");
						result.put("total", total);
						result.put("used", used);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", "1");
		}
		response.getWriter().write(result.toString());
	}

}

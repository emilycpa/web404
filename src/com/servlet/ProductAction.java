package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseUtil;
import com.database.po.ProductOrder;

/**
 * Servlet implementation class addProduct
 */
public class ProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductAction() {
		super();
	}

	@Override
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
		request.setCharacterEncoding("utf-8");
		int reqType = Integer.parseInt(request.getParameter("reqType"));

		if (reqType == 1) {
			// add
			String code = request.getParameter("code");
			String type = request.getParameter("type");
			String url = request.getParameter("url");
			String desc = request.getParameter("desc");
			String name = request.getParameter("name");
			String bss = request.getParameter("bss");
			String ecs = request.getParameter("ecs");
			String imgUrl = request.getParameter("imgUrl");
			DataBaseUtil.addProduct(name, code, type, url, desc, bss, ecs, imgUrl);
			response.sendRedirect("add.jsp");
		} else if (reqType == 2) {
			// edit
			int id = Integer.parseInt(request.getParameter("id"));
			String code = request.getParameter("code");
			String type = request.getParameter("type");
			String url = request.getParameter("url");
			String desc = request.getParameter("desc");
			String name = request.getParameter("name");
			String bss = request.getParameter("bss");
			String ecs = request.getParameter("ecs");
			String imgUrl = request.getParameter("imgUrl");
			DataBaseUtil.edit(id, name, code, type, url, desc, bss, ecs, imgUrl);
			response.sendRedirect("list.jsp");
		} else if (reqType == 3) {
			int id = Integer.parseInt(request.getParameter("id"));
			DataBaseUtil.delete(id);
			response.sendRedirect("list.jsp");
		} else if (reqType == 4) {
			String code = request.getParameter("code").trim();
			String userNum = request.getParameter("mobile").trim();
			ProductOrder order = new ProductOrder();
			order.setCode(code);
			order.setMobileNum(userNum);

			DataBaseUtil.addProductOrderRecord(order);
		}
	}

}

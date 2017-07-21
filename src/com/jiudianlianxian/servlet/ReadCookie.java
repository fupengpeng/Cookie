package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: ReadCookie
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Cookie
 * @author fupengpeng
 * @date 2017年7月21日 下午3:33:23
 *
 */
//@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//读取所有的cooki信息，在选择需要的 cookie
		Cookie [] cookies = request.getCookies();
		
		System.out.println(cookies.length);
		
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			out.println("cookie 的信息    名字="+cookie.getName()+"value = "+cookie.getValue());
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

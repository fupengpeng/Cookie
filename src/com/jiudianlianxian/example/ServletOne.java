
package com.jiudianlianxian.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: ServletOne
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Cookie
 * @author fupengpeng
 * @date 2017年7月21日 下午3:59:03
 *
 */
//@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean b = false;
		//获取cookie
		Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				//取出名称
		 		String name = cookie.getName();
				if("lasttime".equals(name)){
					//显示上次登录时间
					out.println("上次登录时间："+cookie.getValue());
					//跟新时间
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
					String nowTime = simpleDateFormat.format(new Date());
					System.out.println("----004"+nowTime);
					cookie.setValue(nowTime);
					cookie.setMaxAge(7*3600*24);  // 保存一周
					response.addCookie(cookie);
					b = true;
					break;
				}
				
			}
		}

		if(!b){
			out.println("第一次登录");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
			String nowTime = simpleDateFormat.format(new Date());
			Cookie cookie01 = new Cookie("lasttime",nowTime);
			System.out.println(nowTime);
			cookie01.setMaxAge(7*3600*24);  // 保存一周
			response.addCookie(cookie01);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

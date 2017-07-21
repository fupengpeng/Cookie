
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
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Cookie
 * @author fupengpeng
 * @date 2017��7��21�� ����3:59:03
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
		//��ȡcookie
		Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				//ȡ������
		 		String name = cookie.getName();
				if("lasttime".equals(name)){
					//��ʾ�ϴε�¼ʱ��
					out.println("�ϴε�¼ʱ�䣺"+cookie.getValue());
					//����ʱ��
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
					String nowTime = simpleDateFormat.format(new Date());
					System.out.println("----004"+nowTime);
					cookie.setValue(nowTime);
					cookie.setMaxAge(7*3600*24);  // ����һ��
					response.addCookie(cookie);
					b = true;
					break;
				}
				
			}
		}

		if(!b){
			out.println("��һ�ε�¼");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
			String nowTime = simpleDateFormat.format(new Date());
			Cookie cookie01 = new Cookie("lasttime",nowTime);
			System.out.println(nowTime);
			cookie01.setMaxAge(7*3600*24);  // ����һ��
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

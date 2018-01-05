package com.mengdi.sessionlistener;
/**
 * 获得在线人数
 * 实现 HttpSessionListener接口使该类变成了一个监听类，
 * 可监听整个web应用的HttpSession,一旦服务器为用户建立会话，就执行该监听器中的sessionCreated方法，从而可统计在线人数
 */
import java.util.ArrayList;

/*
 * 统计在线人数
 */
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.mengdi.sessionUtil.SessionUtil;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	
	private int userNumber = 0;
	
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         userNumber++;
         arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);//设置为全局
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         userNumber--;
         arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);
         @SuppressWarnings("unchecked")
		ArrayList<User> userList = (ArrayList<User>) arg0.getSession().getServletContext().getAttribute("userList");
         userList.remove(SessionUtil.getUserBySessionId(userList, arg0.getSession().getId()));
         arg0.getSession().getServletContext().setAttribute("userList", userList);
    }
	
}

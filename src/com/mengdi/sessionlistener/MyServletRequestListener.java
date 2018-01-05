package com.mengdi.sessionlistener;
import java.util.ArrayList;
import java.util.Date;

/*
 * 获取登录用户的IP地址
 */
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.mengdi.sessionUtil.SessionUtil;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListener
 *
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
	
	private ArrayList<User> userList; 
	
    public MyServletRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @SuppressWarnings("unchecked")
	public void requestInitialized(ServletRequestEvent arg0)  { 
    	userList = (ArrayList<User>)arg0.getServletRequest().getServletContext().getAttribute("userList");
    	if (userList ==null) {
    		userList = new ArrayList<User>();
    	}
         HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
         String sessionId = request.getSession().getId();
         if (SessionUtil.getUserBySessionId(userList, sessionId) == null) {
        	 User user = new User();
        	 user.setSessionId(sessionId);
        	 user.setIp(request.getRemoteAddr());
        	 user.setFirstTime(new Date().toLocaleString());
        	 userList.add(user);
         }
         arg0.getServletContext().setAttribute("userList", userList);
    }

	
}

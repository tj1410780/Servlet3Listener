package com.mengdi.sessionlistener;
/**
 * �����������
 * ʵ�� HttpSessionListener�ӿ�ʹ��������һ�������࣬
 * �ɼ�������webӦ�õ�HttpSession,һ��������Ϊ�û������Ự����ִ�иü������е�sessionCreated�������Ӷ���ͳ����������
 */
import java.util.ArrayList;

/*
 * ͳ����������
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
         arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);//����Ϊȫ��
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

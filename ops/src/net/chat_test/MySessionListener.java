package net.chat_test;


import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public final class MySessionListener implements HttpSessionListener {
	
	
    public MySessionListener() {
    }
    

    public void sessionCreated(HttpSessionEvent sessionEvent) {
    	
        // 생성된 세션을 받습니다.
    	HttpSession session = sessionEvent.getSession();

        // 세션에 무언가 저장을 하고, 메시지를 남깁니다.
        try {
        	String em_id=(String)session.getAttribute("EM_id");
            System.out.println("[MySessionListener] Session created: "+session);
            sessionEvent.getSession().getId();
            /*if(em_id!=null) {
            	session.setAttribute(em_id, "bar");
            }*/
            
             
        } catch (Exception e) {
            System.out.println("[MySessionListener] Error setting session attribute: " + e.getMessage());
        }
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {

        // 사라질 세션을 받습니다.
        HttpSession session = sessionEvent.getSession();

        // 메시지를 남깁니다.
        System.out.println("[MySessionListener] Session invalidated: "+session);
        System.out.println("[MySessionListener] Value of foo is: " + session.getAttribute("foo"));
    }
}

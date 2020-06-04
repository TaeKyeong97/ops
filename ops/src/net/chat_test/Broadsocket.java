package net.chat_test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/broadcasting",configurator = GetHttpSessionConfigurator.class)
public class Broadsocket implements HttpSessionListener{
	static HashMap<String,Session> sessionList = new HashMap<String,Session>();
	private Session wsSession;
	private HttpSession httpSession;

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());	
	
	private static Set<Session> user = Collections.synchronizedSet(new HashSet<>());
	static Session mySession=null;
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {		
		//접속중인 user 소켓 세션값 저장 (httpSessionListener
		String emId=(String)httpSession.getAttribute("EM_id");
		httpSession.setAttribute(emId, session);
		
		//세션 리스트 추가(공유)
		sessionList.put(emId, session);
		
		//대화 상대 세션 가져오기		
		//구분
		String[] messages=message.split("\\[\\@user\\#\\]");
		System.out.println(messages[1]);
		Session userID=sessionList.get(messages[1].trim());
		user.add(userID);
		//System.out.println("상대:"+userID);
		//System.out.println("상대:"+message);
		//시간출력
		Date now =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
		String nowTime=sdf.format(now);	
		
		//System.out.println(session.getId() + "님이 접속했습니다.");
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {					
					client.getBasicRemote().sendText(message);
					System.out.println(client.getId());
					System.out.println(nowTime);
					//userID.getBasicRemote().sendText(messages[0]);//특정 사용자에게 전송
					break;
				}
			}
		}
	}
	@OnOpen
	public void onOpen(Session session,EndpointConfig config) { // Add session to the connected
		
		this.wsSession=session;
		this.httpSession=(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		
		//접속중인 user 소켓 세션값 저장 (httpSessionListener
				String emId=(String)httpSession.getAttribute("EM_id");
				httpSession.setAttribute(emId, session);
				//System.out.println(httpSession.getAttribute(emId)); //My session
				
				//세션 리스트 추가(공유)
				sessionList.put(emId, session);
				
		//test.setSession(session,emId);
		//GetHttpSessionConfigurator.setSession(session);
		
		// sessions set
		//System.out.println(session);
		clients.add(session);
	}
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

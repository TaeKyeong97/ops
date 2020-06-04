package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Chatting;
import comm.Action;
import comm.ActionForward;

public class ChattListAction implements Action{
	//친구 목록
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		ProjectService pjs=new ProjectService();
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		/***********친구 추가 목록 가져오기***********/
		//친구 추가한 목록
		ArrayList<Chatting> chattList=pjs.chatting(myid);
		request.setAttribute("chattList", chattList);
		
		//승인 대기 중인 친구 목록
		ArrayList<Chatting> chatAck=pjs.chattingAck(myid);
		request.setAttribute("chatAck", chatAck);
		request.setAttribute("myid", myid);
		forward = new ActionForward("chatList.jsp",false);
		
		
		return forward;
	}
	

}

package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Chatting;
import Project.beans.ProjectBean;
import Project.beans.ProjectGroupBean;
import comm.Action;
import comm.ActionForward;

public class FileUploadAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//진행 중인 프로젝트 메인 페이지
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		ProjectService pjs=new ProjectService();
		String pj_no=request.getParameter("pj_no");
		
		//프로젝트 정보 가져오기
		ArrayList<ProjectBean> oppm=pjs.opProjectMain(pj_no);
		request.setAttribute("oppm", oppm);
		//프로젝트 참여 인원 가져오기
		ArrayList<ProjectBean> oppp=pjs.opMainPersonProject(pj_no,myid);
		request.setAttribute("oppp", oppp);
		//프로젝트 모든 그룹 정보 가져오기
		ArrayList<ProjectBean> opgp=pjs.opMainGroupPersonProject(pj_no);
		request.setAttribute("opgp", opgp);
		
		//프로젝트 그룹 갯수 가져오기
		int peoLenGroup=pjs.opProjectGroupcount(pj_no);
		request.setAttribute("peoLenGroup", peoLenGroup);
		
		//프로젝트 참여 인원 수 져오기
		int peoLen=pjs.opProjectPecount(pj_no);
		request.setAttribute("peoLen", peoLen);
		
		//그룹별 참여 인원 가져오기
		ArrayList<ProjectGroupBean> pjgno=new ArrayList<ProjectGroupBean>();
		for(int i=0;i<opgp.size();i++) {
			ProjectGroupBean pjb=new ProjectGroupBean();
			pjb.setPjG_no(opgp.get(i).getPjG_no());
			pjgno.add(pjb);
		}
		ProjectGroupPreInfoService pgpis=new ProjectGroupPreInfoService();
		ArrayList<ProjectGroupBean> pjgno2=pgpis.projectGroupPeInfo(pjgno);
		request.setAttribute("pjgno2", pjgno2);		
		
		//프로젝트 참여 권한 가져오기
		ProjectBean pjbRight=pjs.opMainProjectRightService(pj_no,myid);
		request.setAttribute("pjbRight", pjbRight);
		
		/***********친구 추가 목록 가져오기***********/
		//친구 추가한 목록
		ArrayList<Chatting> chattList=pjs.chatting(myid);
		request.setAttribute("chattList", chattList);
		
		//승인 대기 중인 친구 목록
		ArrayList<Chatting> chatAck=pjs.chattingAck(myid);
		request.setAttribute("chatAck", chatAck);
		
		forward = new ActionForward("fileUpload.jsp",false);
		
		return forward;
	}
}

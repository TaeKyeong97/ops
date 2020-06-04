package Project.simple;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.action.ProjectCurrentService;
import Project.action.ProjectInfoChangeService;
import Project.action.ProjectUserInfoService;
import Project.action.WorkListService;
import Project.beans.Member;
import Project.beans.ProjectBean;
import Project.beans.Work;
import comm.Action;
import comm.ActionForward;
import work.action.MyWorkListService;

public class ProjectMainView implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;
		
		HttpSession session=request.getSession();
		String EM_id=(String)session.getAttribute("EM_id");
		request.setAttribute("EM_id",EM_id);
		ProjectUserInfoService pjui=new ProjectUserInfoService();
		Member list=pjui.userInfoService(EM_id);
		
		//대표프로젝트 조회 (현재 대표 DB를 생성 하지 않아 가장 먼저 생성한 값 가져오기)
		ArrayList<ProjectBean> pjb=pjui.projectSelectMainService(EM_id);
		request.setAttribute("EM_id",EM_id);
		request.setAttribute("list",list);
		request.setAttribute("pjb",pjb);
		
		
		//생성한 프로젝트 리스트
		ProjectCurrentService pjcs= new ProjectCurrentService();
		ArrayList<ProjectBean> pjbl=pjcs.selectMyProjectService(EM_id);
		request.setAttribute("pjbl",pjbl);
		if(pjb!=null) {
			//업무 생성 리스트 조회
			WorkListService wls=new WorkListService();
			ArrayList<Work> workList=wls.worklistService(pjb.get(0).getPj_no(), EM_id);
			request.setAttribute("workList", workList);
			// 내업무 리스트 조회
			ArrayList<Work> workMyList=wls.workMylistService(pjb.get(0).getPj_no(), EM_id);
			request.setAttribute("workMyList", workMyList);
		}
		
		
		//내가 생성한 업무 리스트		
		String ws_noString=request.getParameter("ws_no");
		int ws_no=0;
		if(ws_noString!=null) {
			ws_no=Integer.parseInt(ws_noString);
		}
		MyWorkListService mwls=new MyWorkListService();
		ArrayList<Work> meworkMyList=mwls.myworkListService(EM_id);
		request.setAttribute("meworkMyList", meworkMyList);
		
		ProjectInfoChangeService pics=new ProjectInfoChangeService();
		Member member=pics.selectUserInfo(EM_id);
		request.setAttribute("member", member);
		forward=new ActionForward("pj.jsp",false);
		return forward;
	}
}

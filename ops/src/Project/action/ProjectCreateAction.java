package Project.action;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.ProjectBean;
import comm.Action;
import comm.ActionForward;

public class ProjectCreateAction implements Action {
	//프로젝트 생성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		ProjectBean pb=new ProjectBean();
		ProjectCreateService pjcs =new ProjectCreateService();
		HttpSession session=request.getSession();
		
		
		String EM_id=(String)session.getAttribute("EM_id");
		String title=request.getParameter("title");
		String subTitle=request.getParameter("subTitle");
		String c_userID[]=request.getParameterValues("c_userID");
		String serviceDate=request.getParameter("serviceDate");//사용기간
		String pjSpace=request.getParameter("pjSpace");
		String g_title[]=request.getParameterValues("g_title");
		String buy_price=request.getParameter("buy_price");
		
		String userId="";
		if(c_userID!=null) {
			for(int i=0; i<c_userID.length;i++) {
				if(i==0) {//작성자 아이디 추가로 넣음 , EM_id
					userId+=c_userID[i]+","+EM_id;
				}else {
					userId+=","+c_userID[i];
				}
			}
		}else {
			userId=EM_id;
		}
		String gTitle="";
		for(int i=0; i<g_title.length;i++) {
			if(i==0) {
				gTitle+=g_title[i];
			}else {
				gTitle+=","+g_title[i];
			}
		}
		
		pb.setPj_admin(EM_id);
		pb.setPj_title(title);
		pb.setPj_subTitle(subTitle);
		pb.setPjP_userId(userId);
		pb.setPj_serviceDate(serviceDate);
		pb.setPj_space(pjSpace);
		pb.setPj_date(new Timestamp(System.currentTimeMillis()));
		pb.setPjG_title(gTitle);
		
		String pj_no=pjcs.createProject(pb,buy_price);
		
		forward=new ActionForward("../index.ops",true);
		
		
		//폴더생성
		String path="/projectUpload/"+pj_no;
		String realFolder="";
		ServletContext context=request.getServletContext();
		realFolder=context.getRealPath(path);
		
		File file=new File(realFolder);
		if(!file.exists()){//폴더가 없으면 생성
			file.mkdirs();
		}		
		
		return forward;
	}
}

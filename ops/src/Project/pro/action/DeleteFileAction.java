package Project.pro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class DeleteFileAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파일 삭제
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String file_no=request.getParameter("file_no");
		
		DeleteFileService dfs=new DeleteFileService();
		dfs.deleteFileService(Integer.parseInt(file_no), myId);
		
		//따로 forward 하지 않음
		//forward = new ActionForward("",false);
		return forward;
	}
	
}

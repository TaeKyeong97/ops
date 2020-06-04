package Project.pro.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import comm.Action;
import comm.ActionForward;

public class FileUploadProAction  implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		MultipartRequest multi=null;
		HttpSession session = request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		//프로젝트 파일 업로드
		
		//프로젝트 번호
		String pjgp_no = request.getParameter("pjgp_no");	//그룹번호
		String pj_no=request.getParameter("pj_no");
		String page=request.getParameter("page");
		String exten=null;	//확장자 저장

		String realFolder="";
		String folder="/projectUpload/"+pj_no+"/";
		String fileName=null;
		String encType="utf-8";
		int maxSize=1024*1024*5;
		
		ServletContext context=request.getServletContext();
		realFolder=(String)context.getRealPath(folder);
		
		try {
			multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
			fileName=multi.getFilesystemName("files");
			
			String []fileNames=fileName.split("\\.");
			exten=fileNames[1];
			
			pj_no=multi.getParameter("pj_no");
			pjgp_no=multi.getParameter("pjgp_no");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		FileUploadProService fups=new FileUploadProService();
		fups.fileUploadProService(folder, fileName, Integer.parseInt(pj_no),Integer.parseInt(pjgp_no),exten,myId);
		forward=new ActionForward("project.op?pj_no="+pj_no+"&&gpContent=GongYu&&pjgp_no="+pjgp_no+"&&page="+page,true);
		
		return forward;
	}

}

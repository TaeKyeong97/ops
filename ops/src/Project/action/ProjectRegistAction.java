package Project.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project.beans.Member;
import comm.Action;
import comm.ActionForward;

public class ProjectRegistAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ProjectRegistService pj=new ProjectRegistService();
		ActionForward forward=null;
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String days=time.toString().substring(0,10);
		String realFolder="";
		String folder="/upload/"+days;
		//String folder="/upload";
		String encType="UTF-8";
		String fileName="";
		int maxSize=1024*1024*5;
		
		
		
		
		ServletContext context= request.getServletContext();
		realFolder=context.getRealPath(folder);
		//오늘 날짜 폴더생성
		File file=new File(realFolder);
		if(!file.exists()){//폴더가 없으면 생성
			file.mkdirs();
		}
		MultipartRequest multi=null;
		try{
			multi=new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		}catch(Exception e){e.printStackTrace();}
		
			Enumeration<?> enu=multi.getFileNames();
			if(enu.hasMoreElements()) {
				String typename=(String)enu.nextElement();
				fileName=multi.getFilesystemName(typename);
			}
			//fileName=multi.getFilesystemName("document");
			
		
			
		String year=multi.getParameter("year");
		String month=multi.getParameter("month");
		String day=multi.getParameter("day");
		String EM_bir=year+"-"+month+"-"+day;
			Member member= new Member(multi.getParameter("EM_id"),
			multi.getParameter("EM_pw"),
			multi.getParameter("EM_name"),EM_bir,
			multi.getParameter("EM_phon"),multi.getParameter("EM_email"),
			fileName,0,
			time,"1");
			//추가
			String userImg=(String) multi.getFilesystemName("userImg");
			
			
			boolean isSuccess=pj.getInsertMember(member,userImg,days);
			if(isSuccess) {
				forward= new ActionForward("../index.ops",true);
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out= response.getWriter();
				out.println("<script>");
				out.println("history.back();");
				out.println("</script>");
			}
		
		return forward;
	}
	
	
}

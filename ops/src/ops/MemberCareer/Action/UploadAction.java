package ops.MemberCareer.Action;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;

public class UploadAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("ops/main",true);
		ArrayList<String> saveFiles = new ArrayList<String>();
	    ArrayList<String> originFiles = new ArrayList<String>();
		String realDir=null;
		String dir="/upload/uploadFile/";
		String enctype="utf-8";
		int maxSize=1024*1024*1024;
		ServletContext ctx=request.getServletContext();
		realDir=ctx.getRealPath(dir);
		File realFile =new File(realDir);
		if(!realFile.isDirectory()) {
			realFile.mkdirs();
		}
		
		MultipartRequest multi=null;
		try { 
			multi=new MultipartRequest(request,realDir,maxSize,enctype,new DefaultFileRenamePolicy());
		  Enumeration<String> files = multi.getFileNames();
	        while (files.hasMoreElements()) {
	            String name = files.nextElement();
	            saveFiles.add(multi.getFilesystemName(name));
	            originFiles.add(multi.getOriginalFileName(name));
	        }	        
	        HttpSession session=request.getSession();
	        if(session.getAttribute("fileName")==null) {
	        	session.setAttribute("fileName", saveFiles.get(0));
	        }else {
	        	session.setAttribute("fileName", session.getAttribute("fileName")+","+saveFiles);
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}

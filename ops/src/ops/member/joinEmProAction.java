package ops.member;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;
import ops.member.beans.EmemberBean;
//기업 회원가입처리
public class joinEmProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
String myId=request.getParameter("myId");	//사용자 ID
		
		String realFolder=null;
		String folder="/EmMyImage/"+myId+"/profile/";
		int maxSize=1024*1024*20;	//20MB
		String fileName=null;
		String enctype="utf-8";
		
		
		ServletContext context= request.getServletContext();
		realFolder=context.getRealPath(folder);
		File realFile =new File(realFolder);
		if(!realFile.isDirectory()) {
			realFile.mkdirs();
		}
		
		MultipartRequest multipart =null;
		try {
			multipart=new MultipartRequest(request,realFolder,maxSize,enctype,new DefaultFileRenamePolicy());
			fileName=multipart.getFilesystemName("profile");
			
			String id=multipart.getParameter("id");
			String pw=multipart.getParameter("pw");
			String name=multipart.getParameter("name");
			String phone=multipart.getParameter("phone");
			String email=multipart.getParameter("email");
			String sex=multipart.getParameter("sex");
			String zipNo=multipart.getParameter("zipNo");
			String roadAddr=multipart.getParameter("roadAddr");
			String jibunAddr=multipart.getParameter("jibunAddr");
			String realAddr=multipart.getParameter("realAddr");
			String year=multipart.getParameter("year");
			String month=multipart.getParameter("month");
			String day=multipart.getParameter("day");
			String birthday=year+"-"+month+"-"+day;
			String liceName=multipart.getParameter("liceName");
			String liceNum=multipart.getParameter("liceNum");
			String repName=multipart.getParameter("repName");
			String typeOfBusiness=multipart.getParameter("typeOfBusiness");
			String joinNumber=multipart.getParameter("joinNumber");
			String repNum=multipart.getParameter("repNum");
			EmemberBean emb=new EmemberBean(0, id,pw,name,phone,email,sex,new Timestamp(System.currentTimeMillis()),0,fileName,liceNum,repName,typeOfBusiness,joinNumber,repNum);
			JoinProService jps=new JoinProService();
			jps.joinEmPro(emb, liceName, liceNum);
			
			forward=new ActionForward("../ops/main",true);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}
}

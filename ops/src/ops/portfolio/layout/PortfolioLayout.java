package ops.portfolio.layout;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;

public class PortfolioLayout{
	//card
	public PortfolioBeans cardLayout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		String path="portfolio/view/upload/";
		String realPath="";
		String enctype="utf-8";
		String fileNames=null;
		int maxSize=1024*1024*10;
		
		ServletContext context=request.getServletContext();
		realPath=context.getRealPath(path);
		
		MultipartRequest multi=null;
		multi=new MultipartRequest(request,realPath,maxSize,enctype,new DefaultFileRenamePolicy());
		fileNames=multi.getFilesystemName("uploadFile");
		
		PortfolioBeans ptfb=new PortfolioBeans();
		ptfb.setId(userID);
		ptfb.setTitle(multi.getParameter("title"));
		ptfb.setContent("no");	//카드형 게시판에는 content가 따로 존재하지 않음
		ptfb.setImg(fileNames);
		ptfb.setDate(new Timestamp(System.currentTimeMillis()));
		ptfb.setLayout(multi.getParameter("layout"));
		ptfb.setPo_public(multi.getParameter("range"));
		String po_reTitle=multi.getParameter("title");
		po_reTitle=po_reTitle.replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").trim();
		ptfb.setPo_reTitle(po_reTitle);
		
		if(multi.getParameterValues("content")!=null) {
			ptfb.setCard_content(multi.getParameterValues("content"));
		}				
		return ptfb;
	}
	
	//post
	public PortfolioBeans postLayout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		String path="portfolio/view/upload/";
		String realPath="";
		String enctype="utf-8";
		String fileNames=null;
		int maxSize=1024*1024*10;
		
		ServletContext context=request.getServletContext();
		realPath=context.getRealPath(path);
		
		MultipartRequest multi=null;
		multi=new MultipartRequest(request,realPath,maxSize,enctype,new DefaultFileRenamePolicy());
		fileNames=multi.getFilesystemName("uploadFile");
		
		PortfolioBeans ptfb=new PortfolioBeans();
		ptfb.setId(userID);
		ptfb.setTitle(multi.getParameter("title"));
		ptfb.setContent(multi.getParameter("context"));	//카드형 게시판에는 content가 따로 존재하지 않음
		ptfb.setImg(fileNames);
		ptfb.setDate(new Timestamp(System.currentTimeMillis()));
		ptfb.setLayout(multi.getParameter("layout"));
		ptfb.setPo_public(multi.getParameter("range"));
		String po_reTitle=multi.getParameter("title");
		po_reTitle=po_reTitle.replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").trim();
		ptfb.setPo_reTitle(po_reTitle);
		
		if(multi.getParameterValues("content")!=null) {
			ptfb.setCard_content(multi.getParameterValues("content"));
		}				
		return ptfb;
	}
}

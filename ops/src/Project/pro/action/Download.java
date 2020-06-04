package Project.pro.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class Download implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;
		
		DownloadService dls=new DownloadService();
		try {
			dls.fileDownload4(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return forward;
	}
}

package ops.Notice.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;

public class NoticeModifyProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NoticeModifyProService nmps = new NoticeModifyProService();
		boolean Modify = false;
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		ActionForward forward = null;
		Notice notice = new Notice();
		boolean isNoticeNo = nmps.NoticeNo(n_no);
		if(!isNoticeNo){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('접근불가');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			notice.setN_no(n_no);
			notice.setN_title(request.getParameter("title"));
			notice.setN_content(request.getParameter("content"));
			notice.setN_img(request.getParameter("img"));
			notice.setN_comName(request.getParameter("comName"));
			notice.setN_ceoName(request.getParameter("ceoName"));
			notice.setN_address(request.getParameter("address"));
			notice.setN_job(request.getParameter("job"));
			notice.setN_reCruit(Integer.parseInt(request.getParameter("reCruit")));
			notice.setN_field(request.getParameter("field"));
			notice.setN_gender(request.getParameter("gender"));
			notice.setN_age(request.getParameter("age"));
			notice.setN_acadamiBg(request.getParameter("acadamiBg"));
			notice.setN_sal(request.getParameter("sal"));
			notice.setN_endDate(request.getParameter("endDate"));
			notice.setN_workTerm(request.getParameter("workTerm"));
			notice.setN_workDay(request.getParameter("workDay"));
			notice.setN_workTime(request.getParameter("workTime"));
			notice.setN_workForm(request.getParameter("workForm"));
			notice.setN_name(request.getParameter("name"));
			notice.setN_email(request.getParameter("email"));
			notice.setN_phone(request.getParameter("phone"));
			notice.setN_supportForm(request.getParameter("supportForm"));
			notice.setN_bigo(request.getParameter("bigo"));
			
			
			isNoticeNo = nmps.modifyNotice(notice);
			
			if(Modify){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정되지않았습니다.');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward("noticeList.no", true);		
			}
		}

		return forward;
	}

}

package ops.MemberCareer.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;
import ops.MemberCareer.Beans.Careerfile;
import ops.member.LoginCk;
import ops.portfolio.PortfolioDAO;
//이력서 작성 action 및 service
public class CareerWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		/**********추가 사항***********/
		HttpSession session=request.getSession();
		String me=(String)session.getAttribute("userID");
		String portfolioList[]=request.getParameterValues("portfolioList");
		String userID=null,workDay="",sal=null,acadamiBg=null;
		String workDays[]=request.getParameterValues("workDays");
		String selectionVal=request.getParameter("selectionVal");
		String school=request.getParameter("school");
		String agrOpen=request.getParameter("agrOpen");
		Timestamp timeDate=new Timestamp(System.currentTimeMillis());
		String phone=request.getParameter("phone");
		String roadAddr=request.getParameter("roadAddr");
		String ca_schoolName=request.getParameter("ca_schoolName");
		String attendTerm[]=request.getParameterValues("attendTerm");
		StringBuffer ca_attendTerm=new StringBuffer();
		for(int caTerm=0;caTerm<attendTerm.length;caTerm++) {
			if(caTerm!=0) {
				ca_attendTerm.append("~"+attendTerm[caTerm]);
			}else {
				ca_attendTerm.append(attendTerm[caTerm]);
			}			
		}
		Date date=new Date();
		date.setTime(timeDate.getTime());
		String startDate=new SimpleDateFormat("yyyyMMdd").format(date);		
		int year  = Integer.parseInt(startDate.substring(0, 4));
	    int month = Integer.parseInt(startDate.substring(4, 6));
	    int dates  = Integer.parseInt(startDate.substring(6, 8));
		Calendar cal= Calendar.getInstance();
		cal.set(year, month - 1, dates); 
		cal.add(Calendar.MONTH, +1);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
	    String endDate = dateFormatter.format(cal.getTime());
		
		LoginCk lck=new LoginCk(request, response);
		if(request.getAttribute("userID")!=null) {
			userID=(String)request.getAttribute("userID");
		}
		for(int i=0;i<workDays.length;i++) {
			if(i==workDays.length-1) {
				workDay+=workDays[i];
			}else{
				workDay+=workDays[i]+",";
			}
		}
		if(selectionVal.equals("시급")) {
			sal=request.getParameter("hourly");
		}else if(selectionVal.equals("월급")) {
			sal=request.getParameter("monthly");
		}else{
			sal=request.getParameter("annual");
		}
		if(school.equals("초등학교")) {
			acadamiBg=request.getParameter("eschool");
		}else if(school.equals("중학교")||school.equals("고등학교")) {
			acadamiBg=request.getParameter("mhschool");
		}else{
			acadamiBg=request.getParameter("tcungs");
		}
		/***************************/
		
		Career c = new Career();
		c.setId(userID);
		c.setCa_title(request.getParameter("title"));
		c.setCa_subTitle(request.getParameter("subTitle"));
		c.setCa_selfText(request.getParameter("ca_selfText"));
		c.setCa_talk(request.getParameter("talk"));
		c.setCa_job(request.getParameter("job"));
		c.setCa_address(request.getParameter("address"));
		c.setWorkFormNo(Integer.parseInt(request.getParameter("workForm")));
		c.setCa_workTerm(request.getParameter("workTerm"));	//근무 기간 보류 ( ~ ) 의 일수 변환 (알바,프리랜서시 추가되어야함)
		c.setCa_workDay(workDay);
		c.setCa_workTime(request.getParameter("workTime"));	//근무시간 보류 (알바 선택시 추가되어야함)
		c.setCa_date(new Timestamp(System.currentTimeMillis()));
		c.setCa_sal(sal);					//문자 값으로 변환 필요 (완료)
		c.setCa_acadamiBg(school);
		c.setCa_startPublic(startDate);
		c.setCa_endPublic(endDate);
		c.setCa_publicTerm("30");
		c.setCa_phone(phone);
		c.setCa_addPhone(request.getParameter("addPhone"));
		c.setCa_private(Integer.parseInt(agrOpen));
		c.setRealAddr(roadAddr);
		/*추가*/
		c.setCa_schoolName(ca_schoolName);
		c.setCa_attendTerm(ca_attendTerm.toString());
		c.setCa_credit("0");
		c.setCa_certificateKind("0");
		c.setCa_grade("0");
		c.setCa_obtainDate("0");
		c.setCa_publisher("0");		
		/*추가*/
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		int x = cd.insertArticle(c);
		if(x>0) {
			commit(con);
			PortfolioDAO pfd=PortfolioDAO.getInstance();
			pfd.setConnection(con);
			pfd.portCareerLink(portfolioList, me);
			/*추가*/
			String fileName=(String)session.getAttribute("fileName");	
			UploadService us =new UploadService();
			int maxSize=us.careerNextNumber(me);
			Careerfile cf=new Careerfile();
			cf.setCa_no(maxSize);
			cf.setFileName(fileName);
			cf.setFileType("file");
			us.upload(cf);
			session.removeAttribute("fileName");
			/*추가*/
			
			forward = new ActionForward("ops/main",true);
		}else {
			rollback(con);
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		close(con);
		return forward;
	}

}

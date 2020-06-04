package ops.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

/**
 * Servlet implementation class JoinInfoController
 */
@WebServlet("/JOIN/*")
public class JoinInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProsses(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProsses(request, response);
	}
	
	protected void doProsses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uriInfo="/join";
		request.setCharacterEncoding("UTF-8");
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+uriInfo.length(), requestURI.length());
		ActionForward forward=null;
		Action action=null;
		
		
		if(command.equals("/joinV1")) {
			//회원 동의 (일반
			action=new JoinV1Action();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/join")) {
			//회원가입폼
			action = new JoinFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/joinPro")) {
			//회원가입 처리
			action = new JoinProAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/overCK")) {
			//아이디 중복 체크 페이지
			action=new OverCkAction();
			try {
				forward = action.execute(request,response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/joinV2")) {
			//회원동의 (기업)
			action=new JoinV2Action();
			try {
				forward = action.execute(request,response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/join2")) {
			//회원가입폼(기업)
			action = new JoinForm2Action();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/overCK2")) {
			//아이디 중복 체크페이지 (기업)
			action=new OverCk2Action();
			try {
				forward = action.execute(request,response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/LicenceseSearch")) {
			//사업자 등록 조회 확인 (기업)
			action=new LicenceseSearchAction();
			try {
				forward = action.execute(request,response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/joinPro2")) {
			//기업가입 하기
			action=new joinEmProAction();
			try {
				forward = action.execute(request,response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/joinSelect")) {
			//회원가입선택페이지
			try {
				forward = new ActionForward("../join/joinSelect.jsp",false);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dp=request.getRequestDispatcher(forward.getPath());
				dp.forward(request, response);
			}
		}
	}
}

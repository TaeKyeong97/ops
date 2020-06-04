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
 * 회원 정보에 관한 컨트롤러
 * 회원가입 , 로그인 , 로그아웃 , 회원 탈퇴 , 회원정보 수정
 */
@WebServlet("/myInfo/*")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProsses(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProsses(request, response);
	}
	
	protected void doProsses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uriInfo="/myInfo";
		request.setCharacterEncoding("UTF-8");
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+uriInfo.length(), requestURI.length());
		ActionForward forward=null;
		Action action=null;
		
		
		
		if(command.equals("/myPage")) {
			//회원페이지
			action=new myPageAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/myInfoChangePage")) {
			//회원정보 수정
			action=new MyInfoChangePageAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/myInfoChangeProPage")) {
			//회원정보 수정 정보 입력 페이지
			action=new MyInfoChangeProPageAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/myInfoChangePro")) {
			//회원정보 수정 처리페이지
			action=new MyInfoChangeProAction();
			try {
				forward = action.execute(request, response);
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

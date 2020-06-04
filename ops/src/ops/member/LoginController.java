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
 * Servlet implementation class LoginController
 */
@WebServlet("/LOGIN/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String uriInfo="/login";
		request.setCharacterEncoding("UTF-8");
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+uriInfo.length(), requestURI.length());
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("")) {
			response.sendRedirect(requestURI+"/login");
		}else if(command.equals("/")) {
			response.sendRedirect(requestURI+"login");
		}
		
		if(command.equals("/login")){
			//로그인폼
			action=new LoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/loginPro")) {
			//로그인 처리페이지
			action=new LoginProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/logout")) {
			//로그아웃
			action=new LogoutAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/userFind")) {
			//아이디 찾기
			action=new UserFindAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/searchPassword")) {
			//비밀번호 찾기
			action=new SearchPasswordAction();
			try {
				forward=action.execute(request, response);
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

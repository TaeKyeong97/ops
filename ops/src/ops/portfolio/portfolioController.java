package ops.portfolio;

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
 * Servlet implementation class portfolioController
 */
@WebServlet("/PORTFOLIO/*")
public class portfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public portfolioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPross(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPross(request, response);
	}
	protected void doPross(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uriInfo="/PORTFOLIO";
		String requestURI=request.getRequestURI();		
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+uriInfo.length(), requestURI.length());
		Action action=null;
		ActionForward forward=null;
		if(command.equals("/portfolioWriter")) {	//card형 포트폴리오 작성페이지
			action=new PortfolioWriterAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PortfolioWriterPro")) {
			action=new PortfolioWriterProAction();
			try {
				forward = action.execute(request, response);			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PortfolioModify")) {
			action = new PortfolioModifyAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/PortfolioView")) {
			action = new PortfolioViewAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/PortfolioModifyPro")) {
			action = new PortfolioModifyProAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/MyPortfolioList")) {
			action = new MyPortfolioListAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/PortfolioRemove")) {
			action = new PortfolioRemoveAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/portfolioList")) {
			action = new PortfolioListAction();
			try {
				forward=action.execute(request, response);					
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/MyPortfolioListCkeckList")) {
			action=new MyPortfolioListCkeckAction();
			try {
				forward= action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/portfolioCareerLinkSize")) {
			action=new PortfolioCareerLinkSizeAction();
			try {
				forward=action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/portfolioBoardWriter")) {	//board형 포트폴리오 작성페이지
			action=new PortfolioBoardWriterAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/bestPortfolio")) {
			action=new BestPortfolioAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher rd=request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}

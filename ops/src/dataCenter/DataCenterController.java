package dataCenter;

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
 * Servlet implementation class DataCenterController
 */
@WebServlet("/DataCenter/*")
public class DataCenterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataCenterController() {
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
		String uriInfo="/DataCenter";
		String requestURI=request.getRequestURI();		
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+uriInfo.length(), requestURI.length());
		Action action=null;
		ActionForward forward=null;
		
		if(command.equals("/setting")) {		//첫 이용자 동의 하기
			action=new CenterSettingProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/approvalState")) {	//동의 여부 확인
			action=new ApprovalStateAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/collectionInfoList")) { //현재 설정값 가져오기 (Main page)
			action=new CollectionInfoListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/collectionList")) { //수집 정보조회
			action=new CollectionListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/saveCollection")) { //적용 여부 저장
			action=new SaveCollectionAction();
			try {
				forward = action.execute(request, response);
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

package Project.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Buy.action.BuyListAction;
import Buy.action.MyRatingAction;
import Project.action.OrgaChartAction;
import Project.action.OverCKAction;
import Project.action.PjCreateView;
import Project.action.ProjectApplSettingAction;
import Project.action.ProjectCreateAction;
import Project.action.ProjectCreateListAction;
import Project.action.ProjectCurrentAction;
import Project.action.ProjectInfoChangeAction;
import Project.action.ProjectLoginProAction;
import Project.action.ProjectRegistAction;
import Project.action.SearchPasswordAction;
import Project.action.UserEmailChangeAction;
import Project.action.UserFindAction;
import Project.action.UserPasswordChangeAction;
import Project.action.WeartherAction;
import Project.action.WithdrawalAction;
import Project.action.WorkProAction;
import Project.action.WorkSortChangeAction;
import Project.action.projectMainSettingAction;
import Project.simple.NavAction;
import Project.simple.ProjectHeadAction;
import Project.simple.ProjectLoginAction;
import Project.simple.ProjectLogoutAction;
import Project.simple.ProjectMainView;
import comm.Action;
import comm.ActionForward;
import schedule.action.ScheduleModifyAction;
import schedule.action.ScheduleProAction;
import schedule.action.scheduleAction;
import work.action.MyWorkChangeAction;
import work.action.MyWorkListAction;
import work.action.MyWorkViewAction;
import work.action.MyworkDeleteAction;
import work.action.MyworkViewChangeAction;
import work.action.WorkViewAction;

/**
 * Servlet implementation class Controll
 */
@WebServlet("*.ops")
public class Controll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("utf-8");
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/join/joinPro.ops")) {
			action=new ProjectRegistAction();	
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/index.ops")){
			action =new ProjectMainView();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/login/login.ops")) {
			action=new ProjectLoginAction();
			try {
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/login/loginPro.ops")) {
			action=new ProjectLoginProAction();
			try {
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/logout/logoutPro.ops")){
			action =new ProjectLogoutAction();
			try {
				forward= action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/infoChange.ops")){
			//정보수정
			action =new ProjectInfoChangeAction();
			try {
				forward= action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/userEmailChange.ops")){
			action=new UserEmailChangeAction();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/passwordChange.ops")) {
			action=new UserPasswordChangeAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/create/projectPro.ops")) {
			action =new ProjectCreateAction();
			try {
				forward =action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/create/pjCreate.ops")) {
			//프로젝트 생성
			action=new PjCreateView();
			try {
				
				forward =action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OneFolderHead.ops")) {
			//해드 보여주기
			action=new ProjectHeadAction();
			try {
				forward =action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/pjCurrent.ops")) {
			//프로젝트 현황 페이지
			action=new ProjectCurrentAction();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectMainSettingPro.ops")) {
			//프로젝트 메인 페이지 노출 하기 (하나 선택)
			action=new projectMainSettingAction();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/pjCreateList.ops")) {
			//내가 생성한 프로젝트 리스트
			action =new ProjectCreateListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/nav.ops")) {
			action =new NavAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectApplSettingPro.ops")) {
			//프로젝트 승인
			action=new ProjectApplSettingAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/wearther.ops")) {
			//날씨 테스트
			action=new WeartherAction();
			try {
				forward=action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/join/overCK.ops")) {
			//중복 체크
			action=new OverCKAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/workPro.ops")) {
			action=new WorkProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/workSortChange.ops")){
			//업무 구분 변경(신규 업무 내업무 위치)
			action=new WorkSortChangeAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/workView.ops")) {
			//업무 상세 보기
			action=new WorkViewAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/myWorkList.ops")) {
			// 내가 생성한 업무 리스트 조회
			action=new MyWorkListAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MyWorkView.ops")) {
			// 내가 생성한 업무 상새보기
			action=new MyWorkViewAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MyworkViewChange.ops")) {
			// 내가 생성한 업무 상새보기 수정 보기
			action=new MyworkViewChangeAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MyWorkChange.ops")) {
			// 내가 생성한 업무 상새보기 수정 하기
			action=new MyWorkChangeAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MyworkDelete.ops")) {
			// 내가 생성한 업무 삭제하기
			action=new MyworkDeleteAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/buy.ops")) {
			// 프로젝트 구매 목록 보기
			action=new BuyListAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/rating.ops")) {
			// 랭킹 조회
			action=new MyRatingAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/login/userFind.ops")) {
			action=new UserFindAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/login/searchPassword.ops")) {
			// 비밀 번호 찾기
			action= new SearchPasswordAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Withdrawal.ops")) {
			action=new WithdrawalAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/orgchat.ops")) {
			action=new OrgaChartAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/schedule.ops")) {	//스케줄 페이지
			action=new scheduleAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/schedulePro.ops")) {//스케줄 등록
			action=new ScheduleProAction();
			try {
				forward= action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/scheduleModify.ops")) {//스케줄수정
			action=new ScheduleModifyAction();
			try {
				forward= action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//forward 처리
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());		//insert 하고 리스트를 뛰어주기 위해 리스트 처리페이지로 넘겨줌
				System.out.println(forward.getPath());
				System.out.println("리스트를 처리페이지뛰어주기위한");
			}else {
				//redirect false 값 넘어옴 (최종 화면도달) 연결된 문서 를 뿌려 주기 위해 보여줌
				RequestDispatcher db = request.getRequestDispatcher(forward.getPath());//RequestDispatcher 사용하는이유는 함께 가져가야 할 있을때 URL 요청함 
				db.forward(request, response);
			}
		}
	}

}

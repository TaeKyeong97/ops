package Project.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.action.pgAdminSettingAction;
import Project.action.pgAdminSettingProAction;
import Project.pro.action.ChattListAction;
import Project.pro.action.DeleteFileAction;
import Project.pro.action.Download;
import Project.pro.action.FileUploadAction;
import Project.pro.action.FileUploadProAction;
import Project.pro.action.FriendAcknoAddAction;
import Project.pro.action.ProjectAction;
import Project.pro.action.ProjectGroupAction;
import Project.pro.action.ProjectGroupPreExcAction;
import Project.pro.action.ProjectGroupPreInfoAction;
import Project.pro.action.ProjectGroupProAction;
import Project.pro.action.ProjectViewAction;
import Project.pro.action.SearchFriendAction;
import Project.pro.action.SelectFriendAddAction;
import Project.pro.action.SharingListAction;
import Project.pro.action.projectGroupAddAction;
import comm.Action;
import comm.ActionForward;
import net.chat_test.ChatAction;

/**
 * Servlet implementation class ProjectControll
 */
@WebServlet("*.op")
public class ProjectControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectControll() {
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
	
	protected void doProsses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command= requestURI.substring(contextPath.length());
		Action action=null;
		ActionForward forward=null;
		
		if(command.equals("/project.op")) {
			action=new ProjectAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectGroupAddPro.op")) {
			action = new projectGroupAddAction();
			try {
				forward =action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectGroupPreInfo.op")) {
			//특정 프로젝트 그룹 참여인원 정보 가져오기
			action = new ProjectGroupPreInfoAction();
			try {
				forward =action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectGroupPreExcInfo.op")) {
			//특정프로젝트 그룹 참여자를 제외한 프로젝트 참여인원
			action=new ProjectGroupPreExcAction();
			try {
				forward =action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/group.op")) {
			//그룹별 프로젝트 리스트
			action=new ProjectGroupAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/groupPro.op")) {
			//그룹별 생성
			action=new ProjectGroupProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/search-friend.op")) {
			//친구 찾기
			action=new SearchFriendAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/search-friendAdd.op")) {
			//친구 추가
			action=new SelectFriendAddAction();
			try {
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/projectView.op")) {
			//그룹 프로젝트 상세 보기
			action=new ProjectViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/friendAcknoAdd.op")) {
			//친구 승인 하기 거절하기
			action=new FriendAcknoAddAction();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/chatList.op")) {
			action=new ChattListAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/fileUpload.op")) {
			//프로젝트 파일 올리기 페이지
			action=new FileUploadAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/fileUploadPro.op")) {
			//프로젝트 파일 업로드
			action=new FileUploadProAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SharingList.op")) {
			//프로젝트 파일 업로드 리스트
			action=new SharingListAction();
			try {
				forward = action.execute(request, response);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/download.op")) {
			//파일 다운로드 시 호출
			action =new Download();
			try {
				forward = action.execute(request,response);				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/deleteFile.op")) {
			//파일 삭제
			action=new DeleteFileAction();
			try {
				forward= action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/chat.op")) {
			action=new ChatAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/pgAdminSetting.op")) {//프로젝트 그룹별 팀장 설정
			action=new pgAdminSettingAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/pgAdminSettingPro.op")) {//프로젝트 그룹별 팀장 설정
			action=new pgAdminSettingProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//forward 처리
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());		//insert 하고 리스트를 뛰어주기 위해 리스트 처리페이지로 넘겨줌
			}else {
				//redirect false 값 넘어옴 (최종 화면도달) 연결된 문서 를 뿌려 주기 위해 보여줌
				RequestDispatcher db = request.getRequestDispatcher(forward.getPath());//RequestDispatcher 사용하는이유는 함께 가져가야 할 있을때 URL 요청함 
				db.forward(request, response);
			}
		}
		
	}

}

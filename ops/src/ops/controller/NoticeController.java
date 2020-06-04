package ops.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Notice.Action.NoticeDeleteAction;
import ops.Notice.Action.NoticeDetailAction;
import ops.Notice.Action.NoticeListAction;
import ops.Notice.Action.NoticeModifyAction;
import ops.Notice.Action.NoticeModifyProAction;
import ops.Notice.Action.NoticeWriteAction;
import ops.Question.Action.QuestionDeleteAction;
import ops.Question.Action.QuestionDetailAction;
import ops.Question.Action.QuestionListAction;
import ops.Question.Action.QuestionModifyAction;
import ops.Question.Action.QuestionModifyProAction;
import ops.Question.Action.QuestionWriteAction;
import ops.announcement.Action.AnnouncementDeleteAction;
import ops.announcement.Action.AnnouncementDetailAction;
import ops.announcement.Action.AnnouncementListAction;
import ops.announcement.Action.AnnouncementModifyAction;
import ops.announcement.Action.AnnouncementModifyProAction;
import ops.announcement.Action.AnnouncementWriteAction;
import ops.announcement.Action.NoticCareerCanceAction;
import ops.announcement.Action.NoticCareerListAction;
import ops.announcement.Action.NoticCareerListSupportAction;
import ops.announcement.Action.NoticCareerRefusalAction;
import ops.announcement.Action.NoticCareerSuccessAction;
import ops.announcement.Action.NoticCorpCareerListAction;
import ops.announcement.Action.NoticSupportAction;
import ops.announcement.Action.noticCareerListsAction;
import ops.board.Action.BoardDeleteAction;
import ops.board.Action.BoardDetailAction;
import ops.board.Action.BoardListAction;
import ops.board.Action.BoardModifyAction;
import ops.board.Action.BoardModifyProAction;
import ops.board.Action.BoardReplyAction;
import ops.board.Action.BoardWriteAction;
import ops.board.Action.BorderWriteFormAction;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("*.no")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;		
		if(command.equals("/noticeWriteForm.no")) {	//공고 작성 페이지
				forward = new ActionForward("management/NoticeWrite.jsp",false);	
		}
		else if(command.equals("/noticeWrite.no")) {
			action = new NoticeWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeList.no")) {
			action = new NoticeListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeDetail.no")) {	//공고 상세 보기
			action = new NoticeDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeModifyForm.no")) {	
			action = new NoticeModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeModifyPro.no")) {
			action = new NoticeModifyProAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/noticeDelete.no")) {
			action = new NoticeDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/announcementWriteForm.no")) {
			forward = new ActionForward("./announcementWrite.jsp",true);
		}
		else if(command.equals("/announcementWrite.no")) {
			action = new AnnouncementWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/noticSupport.no")) { //공고 지원하기 (지원 넣기)
			action = new NoticSupportAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCareerListSupport.no")) { //공고 지원하기 (연결할 이력서 조회)
			action = new NoticCareerListSupportAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCareerList.no")) {	//공고 지원 리스트(사용자 입장)noticCareerList  /(기업 입장) noticCorpCareerList
			action = new NoticCareerListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCorpCareerList.no")) {	//공고 지원 리스트(사용자 입장)noticCareerList  /(기업 입장) noticCorpCareerList
			action = new NoticCorpCareerListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCareerSuccess.no")) {	//공고 지원 승인 하기
			action = new NoticCareerSuccessAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCareerLists.no")) {	//작성 공고 리스트
			action = new noticCareerListsAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/NoticCareerCance.no")) {//공고 채용취소
			action=new NoticCareerCanceAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticCareerRefusal.no")) {//공고 지원 거절
			action=new NoticCareerRefusalAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/announcementList.no")) {	//공지리스트
			action = new AnnouncementListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/announcementDetail.no")) { //공지 자세히보기
			action = new AnnouncementDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/announcementModify.no")) {	//공지 수정 페이지
			action = new AnnouncementModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/announcementModifyPro.no")) { //공지수정 하기
			action = new AnnouncementModifyProAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/announcementDelete.no")) { //공지 삭제
			action = new AnnouncementDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionWriteForm.no")) {	//Q&A 작성 페이지 (관지라)
			forward = new ActionForward("./questionWrite.jsp",true);
		}
		else if(command.equals("/questionWrite.no")) { //Q&A 작성 처리 (관지라)
			action = new QuestionWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionList.no")) {	//Q&A 보기 (일반)
			action = new QuestionListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionDetail.no")) { //사용안함
			action = new QuestionDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionModify.no")) {
			action = new QuestionModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionModifyPro.no")) {
			action = new QuestionModifyProAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/questionDelete.no")) {
			action = new QuestionDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardWriteForm.no")) { //질문 작성 페이지			
			action = new BorderWriteFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardWrite.no")) { //질문 작성 처리
			action = new BoardWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardList.no")) {	//질문 리스트
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardDetail.no")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardModify.no")) {
			action = new BoardModifyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardModifyPro.no")) {
			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardDelete.no")) {
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		else if(command.equals("/boardReply.no")) {	
			action = new BoardReplyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		
		
		if(forward!=null) {
			if(forward.isRedirect()) { 
				response.sendRedirect(forward.getPath());
			} else { 
				RequestDispatcher dp = request.getRequestDispatcher(forward.getPath());
				dp.forward(request, response);
			}
		}
	}

}

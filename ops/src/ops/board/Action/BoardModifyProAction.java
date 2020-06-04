package ops.board.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.board.Beans.Board;

public class BoardModifyProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		BoardModifyProService bmps = new BoardModifyProService();
		ActionForward forward = null;
		boolean isSuccess = false;
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		Board a = new Board();
		boolean isBoardNo = bmps.BoardNo(board_no);
		if(!isBoardNo){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('접근실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			a.setBoard_no(board_no);
			a.setBoard_title(request.getParameter("title"));
			a.setBoard_content(request.getParameter("content"));
			a.setBoard_img(request.getParameter("img"));	
			isBoardNo = bmps.modifyBoard(a);
			
			if(!isSuccess){
				forward = new ActionForward("boardList.no", false);
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패.');");
				out.println("history.back()");
				out.println("</script>");						
			}
		}
		return forward;
	}

}

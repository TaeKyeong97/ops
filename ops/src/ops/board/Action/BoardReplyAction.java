package ops.board.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.board.Beans.Board;

public class BoardReplyAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		BoardReplyService brps = new BoardReplyService();
		ActionForward forward = null;
		boolean isSuccess = false;
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		Board b = new Board();
		boolean isBoardNo = brps.BoardNo(board_no);
		if(!isBoardNo){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('접근실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			b.setBoard_no(board_no);
			b.setBoard_reply(request.getParameter("reply"));	
			isBoardNo = brps.modifyReply(b);
			
			if(!isSuccess){
				forward = new ActionForward("boardList.no", false);
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('댓글달기실패.');");
				out.println("history.back()");
				out.println("</script>");						
			}
		}
		return forward;
	}
}

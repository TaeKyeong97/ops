package ops.board.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class BoardDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		ActionForward forward = null;
		BoardDeleteService bdp = new BoardDeleteService();
		boolean DeleteSuccess = bdp.deleteBoard(board_no);
		if(!DeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("boardList.no", false);
		}
		return forward;
	}
}

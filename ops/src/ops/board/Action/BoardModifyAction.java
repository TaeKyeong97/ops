package ops.board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.board.Beans.Board;

public class BoardModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		BoardDetailService bds = new BoardDetailService();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		Board b = bds.getBoard(board_no);
	    request.setAttribute("b", b);
	   	
	    ActionForward forward = new ActionForward("boardModify.jsp",false);
   		return forward; 		
	 }

}

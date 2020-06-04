package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.board.Beans.Board;

public class BoardDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
			
		Board detail = null;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		detail = bd.selectBoardDetail(board_no);
		close(con);
		
		request.setAttribute("detail", detail);
		ActionForward forward = new ActionForward("boardDetail.jsp",false);
		return forward;
}

}

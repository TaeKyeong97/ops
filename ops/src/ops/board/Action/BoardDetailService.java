package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import ops.board.Beans.Board;


public class BoardDetailService {
	public Board getBoard(int board_no) throws Exception {
		
		Board b = null;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		
		b = bd.selectBoardDetail(board_no);
		close(con);
		
		return b;
	}
}

package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.board.Beans.Board;


public class BoardListService {
	public ArrayList<Board> getBoardList() {
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		ArrayList<Board> boardList = bd.selectBoardList();
		close(con);
		return boardList;
	}
}

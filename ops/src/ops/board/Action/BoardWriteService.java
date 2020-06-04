package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.board.Beans.Board;


public class BoardWriteService {
	public boolean insertBoard(Board b) {
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		boolean isSuccess = false;
		int x = bd.insertBoard(b);
		if(x>0) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}

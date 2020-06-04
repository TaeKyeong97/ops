package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;


public class BoardDeleteService {
	public boolean boardNo(int board_no) throws Exception {
		boolean isSuccess = false;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		isSuccess = bd.isBoardNo(board_no);
		close(con);
		return isSuccess;
		
	}
	public boolean deleteBoard(int board_no) throws Exception{
		boolean deleteSuccess = false;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		int x = bd.deleteBoard(board_no);
		if(x>0){
			commit(con);
			deleteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteSuccess;
	}
}

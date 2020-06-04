package ops.board.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.board.Beans.Board;

public class BoardModifyProService {
	public boolean BoardNo(int board_no) throws Exception {
		boolean BoardNo = false;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		BoardNo = bd.isBoardNo(board_no);
		close(con);
		return BoardNo;
		
	}
	public boolean modifyBoard(Board detail) throws Exception {
		boolean ModifySuccess = false;
		Connection con = getConnection();
		BoardData bd = BoardData.getInstance();
		bd.setConnection(con);
		int updateSuccess = bd.updateBoard(detail);
		if(updateSuccess > 0){
			commit(con);
			ModifySuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return ModifySuccess;
	}
}

package ops.board.Action;

import static common.ConUtilDAO.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ops.board.Beans.Board;

public class BoardData {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	private static BoardData instance;
	
	public static BoardData getInstance(){
		if(instance == null)
			instance = new BoardData();
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertBoard(Board b) { //1:1게시판작성 
		int x = 0;
		try {
			String sql = "insert into board values(null,?,?,?,?,?,null)";
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getBoard_id());
			ps.setString(2, b.getBoard_title());
			ps.setString(3, b.getBoard_content());
			ps.setString(4, b.getBoard_img());
			ps.setTimestamp(5, b.getBoard_date());
			x = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
		
	public ArrayList<Board> selectBoardList(){ //1:1게시판리스트
		String sql="select board_no, board_id, board_title, board_content, board_img, board_date, board_reply from board";
		ArrayList<Board> boardList = new ArrayList<Board>();
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				do{
				Board b = new Board();
				b = new Board();
				b.setBoard_no(rs.getInt("board_no"));
				b.setBoard_id(rs.getString("board_id"));
				b.setBoard_title(rs.getString("board_title"));
				b.setBoard_content(rs.getString("board_content"));
				b.setBoard_img(rs.getString("board_img"));
				b.setBoard_date(rs.getTimestamp("board_date"));
				b.setBoard_reply(rs.getString("board_reply"));
				boardList.add(b);
				}while(rs.next());
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			close(rs);
			close(ps);
		}
		return boardList;
	}
		
	public Board selectBoardDetail(int board_no) { //1:1게시판조회
		Board b = null;
		try {
			String sql = "select * from board where board_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				b = new Board();
				b.setBoard_no(rs.getInt("board_no"));
				b.setBoard_id(rs.getString("board_id"));
				b.setBoard_title(rs.getString("board_title"));
				b.setBoard_content(rs.getString("board_content"));
				b.setBoard_img(rs.getString("board_img"));
				b.setBoard_date(rs.getTimestamp("board_date"));
				b.setBoard_reply(rs.getString("board_reply"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(ps);
			}
			return b;
		}
	
	public boolean isBoardNo(int board_no){ //1:1게시판 번호조회
		String sql="select * from board where board_no=?";
		boolean isNo = false;
			
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				isNo = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(ps);
		}
		return isNo;
	}
	
	public int updateBoard(Board b){ //1:1게시판 업데이트
		String sql="update board set board_title=?, board_content=?, board_img=? where board_no=?";
		int x = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getBoard_title());
			ps.setString(2, b.getBoard_content());
			ps.setString(3, b.getBoard_img());
			ps.setInt(4, b.getBoard_no());
			x = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		return x;
	}
	
	public int deleteBoard(int board_no) { //1:1게시판삭제
		String sql = "delete from board where board_no=?";
		int x = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			x = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
	
	public int updateReply(Board b){ //1:1게시판 댓글달기
		String sql="update board set board_reply=? where board_no=?";
		int x = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getBoard_reply());
			ps.setInt(2, b.getBoard_no());
			x = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		return x;
	}
}

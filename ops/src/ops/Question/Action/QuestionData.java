package ops.Question.Action;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ops.Question.Beans.Question;


public class QuestionData {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	private static QuestionData instance;
	
	public static QuestionData getInstance(){
		if(instance == null)
			instance = new QuestionData();
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertQuestion(Question q) { //Q&A작성 
		int x = 0;
		try {
			String sql = "insert into question values(null,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getQ_title());
			ps.setString(2, q.getQ_content());
			ps.setTimestamp(3, q.getQ_date());
			x = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
	
	public ArrayList<Question> selectQuestionList(){ //Q&A리스트
		String sql = "select * from question";
		ArrayList<Question> questionList = new ArrayList<Question>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				do {
					Question q = new Question();
					q = new Question();
					q.setQ_no(rs.getInt("q_no"));
					q.setQ_title(rs.getString("q_title"));
					q.setQ_content(rs.getString("q_content"));
					q.setQ_date(rs.getTimestamp("q_date"));
					questionList.add(q);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}
		return questionList;
	}
	
	public Question selectQuestionDetail(int q_no) { //Q&A조회
		String sql = "select * from question where q_no=?";
		Question q = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, q_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				q = new Question();
				q.setQ_no(rs.getInt("q_no"));
				q.setQ_title(rs.getString("q_title"));
				q.setQ_content(rs.getString("q_content"));
				q.setQ_date(rs.getTimestamp("q_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return q;
	}
	
	public boolean isQuestionNo(int q_no) { //Q&A번호확인
		String sql = "select * from question where q_no=?";
		boolean isNo = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, q_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				isNo = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return isNo;
	}
	
	public int updateQuestion(Question q) { //Q&A수정
		int x = 0;
		String sql = "update question set q_title=?, q_content=? where q_no=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getQ_title());
			ps.setString(2, q.getQ_content());
			ps.setInt(3, q.getQ_no());
			x = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
	
	public int deleteQuestion(int q_no) { //Q&A삭제
		String sql = "delete from question where q_no=?";
		int x = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, q_no);
			x = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return x;
	}
}




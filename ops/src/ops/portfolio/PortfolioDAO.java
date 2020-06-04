package ops.portfolio;

import static common.ConUtilDAO.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ops.member.MemberDAO;
import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;

public class PortfolioDAO {
	private static PortfolioDAO instance=new PortfolioDAO();
	public static PortfolioDAO getInstance(){
		if(instance==null) {
			instance=new PortfolioDAO();
		}
		return instance;
	}
	Connection conn=null;
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	
	
	//포트폴리오 작성 처리하기
	public int portfolioCardWriterPro(PortfolioBeans ptfb) {//card
		int state=0;
		PreparedStatement psmt=null;
		String sql="insert into portfolio(po_no,po_id,po_title,po_subTitle,po_layout,po_content,po_date,po_public,po_img,po_reTitle) values(null,?,?,?,?,?,?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, ptfb.getId());
			psmt.setString(2, ptfb.getTitle().trim());
			psmt.setString(3, ptfb.getSubTitle());
			psmt.setString(4, ptfb.getLayout());
			psmt.setString(5, ptfb.getContent());
			psmt.setTimestamp(6, ptfb.getDate());
			psmt.setString(7, ptfb.getPo_public());
			psmt.setString(8, ptfb.getImg());
			psmt.setString(9, ptfb.getPo_reTitle());
			state=psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	public int portfolioCardWritePluse(String[] content,int no) {	//card 내용 추가
		int state=0;
		int[] stateArray;
		PreparedStatement psmt=null;
		String sql="insert into cardBoard(no,card_contentNo,card_content,po_noFk) values(null,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			int index=0;
			for(int i=0;i<content.length;i++) {
				index=i+1;
				psmt.setInt(1, index);
				psmt.setString(2, content[i].trim());
				psmt.setInt(3, no);
				psmt.addBatch();
				psmt.clearParameters();				
				
				if(i%10000==0) {
					stateArray=psmt.executeBatch();
					psmt.clearBatch();
					conn.commit();
				}
			}
			stateArray=psmt.executeBatch();
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	
	public int PortfolioMax(String userID) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select max(po_no) MaxNo from portfolio where po_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=rs.getInt("MaxNo");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
	//포트폴리오 보기(공개 범위에 따라)
	public PortfolioBeans portfolioView(int no,String userID,String layout){	//개인 또는 공개 범위에 따라
		PortfolioBeans pfb=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from portfolio where po_no=? AND po_public='Y' AND po_layout=? OR po_no=? AND po_id=? AND po_layout=? ORDER BY po_no DESC";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, layout);
			psmt.setInt(3, no);
			psmt.setString(4, userID);
			psmt.setString(5, layout);
			rs=psmt.executeQuery();
			if(rs.next()){
				MemberDAO md=MemberDAO.getInstance();
				md.setConnection(conn);
				pfb=new PortfolioBeans();
				pfb.setNo(rs.getInt("po_no"));
				pfb.setId(rs.getString("po_id"));
				pfb.setProfile(md.userProfile(rs.getString("po_id")));
				pfb.setTitle(rs.getString("po_title"));
				pfb.setContent(rs.getString("po_content"));
				pfb.setPo_public(rs.getString("po_public"));
				pfb.setDate(rs.getTimestamp("po_date"));
				pfb.setImg(rs.getString("po_img"));
				pfb.setLayout(rs.getString("po_layout"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return pfb;
	}
	
	//포트폴리오 카드 추가 조회
	public ArrayList<CardBoardBeans> portfolioCardView(int po_noFk){
		ArrayList<CardBoardBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from cardBoard where po_noFk=? ORDER BY card_contentNo asc";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, po_noFk);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<CardBoardBeans>();
				do {
					CardBoardBeans cbb=new CardBoardBeans();
					cbb.setContentNo(rs.getString("card_contentNo"));
					cbb.setContent(rs.getString("card_content"));
					list.add(cbb);					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		
		return list;
	}
	//My portfolio list
	public ArrayList<PortfolioBeans> myPortfolioList(String userID){
		ArrayList<PortfolioBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String deleteCode="<[a-zA-Z||\\s||:||;||\"||\\-||\\=||\"||#]*>";
		String deleteCodeEnd="</[a-zA-Z||\\s||:||;||\"||\\-||\\=||\"||#]*>";
		String sql="select * from portfolio where po_id=? ORDER BY po_no DESC";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<PortfolioBeans>();
				do {
					PortfolioBeans pfb=new PortfolioBeans();
					pfb.setNo(rs.getInt("po_no"));
					pfb.setTitle(rs.getString("po_title").trim().replaceAll(deleteCode, "").replaceAll(deleteCodeEnd,""));
					pfb.setContent(rs.getString("po_content"));
					pfb.setPo_public(rs.getString("po_public"));
					pfb.setImg(rs.getString("po_img"));
					pfb.setId(rs.getString("po_id"));
					pfb.setLayout(rs.getString("po_layout"));
					pfb.setDate(rs.getTimestamp("po_date"));
					list.add(pfb);					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//Best 포트폴리오
	public ArrayList<PortfolioBeans> PortfolioListBest(){
		ArrayList<PortfolioBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String deleteCode="<[a-zA-Z||\\s||:||;||\"||\\-||\\=||\"||#]*>";
		String deleteCodeEnd="</[a-zA-Z||\\s||:||;||\"||\\-||\\=||\"||#]*>";
		String sql="select * from portfolio where po_public!='N' order by po_no DESC limit 3";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<PortfolioBeans>();
				MemberDAO mb=MemberDAO.getInstance();
				mb.setConnection(conn);				
				do {
					PortfolioBeans pfb=new PortfolioBeans();
					pfb.setNo(rs.getInt("po_no"));
					pfb.setTitle(rs.getString("po_title").trim().replaceAll(deleteCode, "").replaceAll(deleteCodeEnd,""));
					pfb.setContent(rs.getString("po_content"));
					pfb.setPo_public(rs.getString("po_public"));
					pfb.setImg(rs.getString("po_img"));
					pfb.setId(rs.getString("po_id"));
					pfb.setName(mb.userName(rs.getString("po_id")));
					pfb.setLayout(rs.getString("po_layout"));
					pfb.setDate(rs.getTimestamp("po_date"));
					list.add(pfb);					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	//포트폴리오 존재 여부 확인
	public boolean isPortfolioModify(int po_no,String po_id) {
		boolean state=false;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from portfolio where po_no=? AND po_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, po_no);
			psmt.setString(2, po_id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);
		}
		return state;
	}
	//포트폴리오 수정하기
	public boolean portfolioCardModify(PortfolioBeans pfb) {
		boolean state=false;
		PreparedStatement psmt=null;
		String sql="";
		int result=0;
		try {
			if(pfb.getImg()!=null) {
				sql="update portfolio set po_title=?,po_content=?,po_public=?,po_img=? where po_no=? AND po_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, pfb.getTitle());
				psmt.setString(2, pfb.getContent());
				psmt.setString(3, pfb.getPo_public());
				psmt.setString(4, pfb.getImg());
				psmt.setInt(5, pfb.getNo());
				psmt.setString(6, pfb.getId());
				result=psmt.executeUpdate();
			}else {
				sql="update portfolio set po_title=?,po_content=?,po_public=? where po_no=? AND po_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, pfb.getTitle());
				psmt.setString(2, pfb.getContent());
				psmt.setString(3, pfb.getPo_public());
				psmt.setInt(4, pfb.getNo());
				psmt.setString(5, pfb.getId());
				result=psmt.executeUpdate();
			}
			
			if(result>0) {
				state=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	//포트폴리오 card pluse 수정하기
	public boolean portfolioCardPluseModify(PortfolioBeans pfb, String po_no) {
		boolean state=false;
		PreparedStatement psmt=null;
		String[] content=pfb.getCard_content();
		String sql="update cardBoard set card_content=? where po_noFk=? && card_contentNo=?";
		try {
			psmt=conn.prepareStatement(sql);
			for(int i=0;i<content.length;i++) {
				psmt.setString(1, content[i].trim());
				psmt.setInt(2, Integer.parseInt(po_no));
				psmt.setInt(3, i+1);
				psmt.addBatch();
				psmt.clearParameters();
				
				if(i%10000==0) {
					psmt.executeBatch();
					psmt.clearBatch();
					conn.commit();
				}
			}
			psmt.executeBatch();
			conn.commit();			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		
		return state;
	}
	
	//포트폴리오 삭제
	public boolean portfolioRemove(int no, String userID) {
		boolean state=false;
		PreparedStatement psmt=null;
		String sql="delete from portfolio where po_no=? AND po_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, userID);
			int x=psmt.executeUpdate();
			if(x>0) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	//pluse 카드 포트폴리오 삭제 (카드형 포트폴리오 삭제시 먼저 실행)
	public boolean portfolioCardRemove(int no) {
		boolean state=false;
		PreparedStatement psmt=null;
		String sql="delete from cardBoard where po_noFk=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			int x=psmt.executeUpdate();
			if(x>0) {
				state=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(psmt);
		}
		return state;
	}
	//포트폴리오 이력서 연결 삭제
	public int portCareerRemove(int po_no) {
		int state=0;
		PreparedStatement psmt=null;
		String sql="delete from cp_Include where po_no=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, po_no);
			state=psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	//포트폴리오 이력서 연결 조회 (건 수조회)
	public int portCareerLinkList(int po_no) {
		int state=0;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from cp_Include where po_no=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,po_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				do {
					state+=1;
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	//포트폴리오 이력서 연결 조회 ( 연결된 포트폴리오 리스트 )
	public ArrayList<PortfolioBeans> portfolioCareerList(int ca_no){
		ArrayList<PortfolioBeans> list=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select convert(REGEXP_REPLACE(po.po_title, '<(/)?(img|label|table|thead|tbody|tfoot|tr|td|p|div|span|font|strong|b)(.|\\\\s|\\\\t|\\\\n|\\\\r\\\\n)*?>', '') ,char) as po_title ,po.po_layout,po.po_no from portfolio po,cp_include cp where po.po_no=cp.po_no AND cp.ca_no=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, ca_no);
			rs=psmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<PortfolioBeans>();
				do {
					PortfolioBeans pb=new PortfolioBeans();
					pb.setTitle(rs.getString("po_title"));
					pb.setLayout(rs.getString("po.po_layout"));
					pb.setNo(rs.getInt("po.po_no"));
					list.add(pb);
				}while(rs.next());
			}		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//포트폴리오 이력서 연결
	public int portCareerLink(String[] portfolioList, String me) {
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		int state=0;
		int maxSize=0;
		try {
			sql="select MAX(ca_no) maxSize from career where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, me);
			rs=psmt.executeQuery();
			if(rs.next()) {
				maxSize=rs.getInt("maxSize");
			}
			sql="insert into cp_Include(p_noFk,ca_no,po_no) values(null,?,?)";
			psmt.clearParameters();
			psmt=conn.prepareStatement(sql);
			for(int i=0;i<portfolioList.length;i++) {
				psmt.setInt(1, maxSize);
				psmt.setInt(2, Integer.parseInt(portfolioList[i]));
				state=psmt.executeUpdate();
			}
			if(state>0) {
				conn.commit();
			}else {
				conn.rollback();			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(psmt);					
		}
		
		return state;
	}
}

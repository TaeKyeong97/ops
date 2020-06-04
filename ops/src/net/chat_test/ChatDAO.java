package net.chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChatDAO {
	private Connection conn;	//������ ���̽��� ���� �ϰ� ���ִ� �ϳ��� ��ü
	private ResultSet rs;	//��� ������ ������ �ִ� �ϳ��� ��ü
	
	public ChatDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?useSSL=false";
			String dbID="root";
			String dbPassword ="1111";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return "";// ������ ���̽� ����
	}
	
	public ArrayList<Chat> getChatList(String nowTime){
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM CHAT WHERE chatTime > ? ORDER BY chatTime";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, nowTime);
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatName(rs.getString("chatName"));
				chat.setChatContent(rs.getString("chatContent"));
				chat.setChatTime(rs.getString("getDate"));
				chatList.add(chat);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return chatList;
	}
	//��ȣ 1 ����
	public int getNext() {
		String SQL = "SELECT chatID FROM chat ORDER BY chatID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //ù��° �Խù��� ���
			
		} catch (Exception e) {
			e.printStackTrace();
		}return -1;// ������ ���̽� ����
	}
	
	public int submit(String chatName, String chatcontent, String toID, String dataID) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "INSERT INTO chat VALUES(?,?,?,now(),?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, chatName);
			pstmt.setString(3, chatcontent);
			pstmt.setString(4, toID);
			pstmt.setString(5, dataID);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public ArrayList<Chat> getListA(String chatName, String toID, String chatID,String dataID){
		String SQL = "SELECT * FROM chat WHERE ((chatName=? AND toID=? AND dataid=?) OR (chatName=? AND toID=? AND dataid=?)) ORDER BY chatTime";
		ArrayList<Chat> list = new ArrayList<Chat>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, chatName);
			pstmt.setString(2, toID);
			pstmt.setString(3, dataID);
			pstmt.setString(4, toID);
			pstmt.setString(5, chatName);
			pstmt.setString(6, dataID);
			rs = pstmt.executeQuery();
			list = new ArrayList<Chat>();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setChatID(rs.getInt("chatID"));
				chat.setChatName(rs.getString("chatName").replaceAll(" ","&nbsp;"));
				chat.setToID(rs.getString("toID").replaceAll(" ","&nbsp;"));
				chat.setChatContent(rs.getString("chatcontent"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11,13));
				String timeType= "����";
				if(chatTime >=12) {
					timeType = "����";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getString("chatTime").substring(0, 11)+ " " + timeType +" " +rs.getString("chatTime").substring(14, 16));
				list.add(chat);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
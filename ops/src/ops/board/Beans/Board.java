package ops.board.Beans;

import java.sql.Timestamp;

public class Board {
	private int board_no;
	private String board_id;
	private String board_title;
	private String board_content;
	private String board_img;
	private Timestamp board_date;
	private String board_reply;
	public String getBoard_reply() {
		return board_reply;
	}
	public void setBoard_reply(String board_reply) {
		this.board_reply = board_reply;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_img() {
		return board_img;
	}
	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
}

package ops.portfolio.beans;

public class CardBoardBeans {
	private int no;
	private String contentNo;
	private String[] contents;
	private String content;
	private int po_noFk;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContentNo() {
		return contentNo;
	}
	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getContents() {
		return contents;
	}
	public void setContents(String[] contents) {
		this.contents = contents;
	}
	public int getPo_noFk() {
		return po_noFk;
	}
	public void setPo_noFk(int po_noFk) {
		this.po_noFk = po_noFk;
	}
	
	
}

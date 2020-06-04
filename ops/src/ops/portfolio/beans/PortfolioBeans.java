package ops.portfolio.beans;

import java.sql.Timestamp;

public class PortfolioBeans {
	private int no;
	private String id;
	private String title;
	private String subTitle;
	private String layout;
	private String content;
	private Timestamp date;
	private String po_public;
	private String img;
	private String po_reTitle;
	private String name;
	private String profile;
		
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getPo_public() {
		return po_public;
	}
	public void setPo_public(String po_public) {
		this.po_public = po_public;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getPo_reTitle() {
		return po_reTitle;
	}
	public void setPo_reTitle(String po_reTitle) {
		this.po_reTitle = po_reTitle;
	}

	/*pluse cardBoard*/
	private int card_no;
	private String card_contentNo;
	private String[] card_content;
	private int card_po_noFk;

	public int getCard_no() {
		return card_no;
	}
	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}
	public String getCard_contentNo() {
		return card_contentNo;
	}
	public void setCard_contentNo(String card_contentNo) {
		this.card_contentNo = card_contentNo;
	}
	public String[] getCard_content() {
		return card_content;
	}
	public void setCard_content(String[] card_content) {
		this.card_content = card_content;
	}
	public int getCard_po_noFk() {
		return card_po_noFk;
	}
	public void setCard_po_noFk(int card_po_noFk) {
		this.card_po_noFk = card_po_noFk;
	}
	
	
}

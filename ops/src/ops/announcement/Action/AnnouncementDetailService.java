package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import ops.announcement.Beans.Announcement;

public class AnnouncementDetailService {
	public Announcement getAnnouncement(int a_no) throws Exception {
		
		Announcement a = null;
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		
		a = ad.selectAnnouncementDetail(a_no);
		close(con);
		
		return a;
	}
}

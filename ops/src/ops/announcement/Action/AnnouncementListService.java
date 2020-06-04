package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.announcement.Beans.Announcement;


public class AnnouncementListService {
	public ArrayList<Announcement> getAnnouncementList() {
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		ArrayList<Announcement> announcementList = ad.selectAnnouncementList();
		close(con);
		return announcementList;
	}
}

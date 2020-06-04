package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.announcement.Beans.Announcement;

public class AnnouncementWriteService {
	public boolean insertAnnouncement(Announcement a) {
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		boolean isSuccess = false;
		int x = ad.insertAnnouncement(a);
		
		if(x>0) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}

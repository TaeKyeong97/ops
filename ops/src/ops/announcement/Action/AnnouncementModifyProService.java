package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.announcement.Beans.Announcement;


public class AnnouncementModifyProService {
	public boolean AnnouncementNo(int a_no) throws Exception {
		
		boolean announcementNo = false;
		Connection con = getConnection();
		AnnouncementData nd = AnnouncementData.getInstance();
		nd.setConnection(con);
		announcementNo = nd.isAnnouncementNo(a_no);
		close(con);
		return announcementNo;
		
	}
	public boolean modifyAnnouncement(Announcement detail) throws Exception {
		
		boolean ModifySuccess = false;
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		int updateSuccess = ad.updateAnnouncement(detail);
		if(updateSuccess > 0){
			commit(con);
			ModifySuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return ModifySuccess;
	
	}
}


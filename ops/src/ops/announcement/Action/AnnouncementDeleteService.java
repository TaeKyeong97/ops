package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;


public class AnnouncementDeleteService {
	public boolean announcementNo(int a_no) throws Exception {
		boolean isSuccess = false;
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		isSuccess = ad.isAnnouncementNo(a_no);
		close(con);
		return isSuccess;
		
	}
	public boolean deleteAnnouncement(int a_no) throws Exception{
		boolean deleteSuccess = false;
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		int x = ad.deleteAnnouncement(a_no);
		if(x>0){
			commit(con);
			deleteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteSuccess;
	}
}

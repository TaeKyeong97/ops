package schedule.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;
import java.sql.Connection;
import schedule.beans.ScheduleBeans;

public class ScheduleProService {
	//스케줄 등록
	public int SchedulePro(ScheduleBeans sb) {
		
		Connection conn=getConnection();
		ScheduleDAO scd=ScheduleDAO.getInstance();
		scd.setConnection(conn);
		
		int state=scd.scheduleAdd(sb);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
	//스케줄 수정
	

}

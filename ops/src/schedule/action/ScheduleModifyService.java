package schedule.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;
import java.sql.Connection;
import schedule.beans.ScheduleBeans;

public class ScheduleModifyService {
	//스케줄 수정
	public int ScheduleModify(ScheduleBeans sb){
		int state=0;
		Connection conn=getConnection();
		ScheduleDAO sd=ScheduleDAO.getInstance();
		sd.setConnection(conn);
		state=sd.scheduleModify(sb);		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);		
		return state;
	}
}

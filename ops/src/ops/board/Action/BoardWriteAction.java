package ops.board.Action;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;
import ops.board.Beans.Board;

public class BoardWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		String userId=(String)session.getAttribute("userID");
		ActionForward forward = null;
		BoardWriteService bws = new BoardWriteService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 1024*1024*10;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String image = multi.getFilesystemName("img");	
		Board b = new Board();
		b.setBoard_id(userId);
		b.setBoard_title(multi.getParameter("title"));
		b.setBoard_content(multi.getParameter("content"));
		b.setBoard_img(image);
		b.setBoard_date(new Timestamp(System.currentTimeMillis()));
		bws.insertBoard(b);
		
		forward = new ActionForward("./boardList.no",true);
		return forward;
	}

}

package Project.action;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.ProjectBean;
import comm.Action;
import comm.ActionForward;

public class ProjectCreateListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//내가 생성한 프로젝트 리스트
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		
		ProjectCreateListService pcls=new ProjectCreateListService();
		ArrayList<ProjectBean> pcl=pcls.projectCreateListServices(myid);
		if(pcl!=null) {
			request.setAttribute("pcl",pcl);
		}
		forward =new ActionForward("pjCreateList.jsp",false);
		
		
		//내가생성한 프로젝트 용량
		ArrayList<String> img=new ArrayList<String>();//이미지
		ArrayList<String> document=new ArrayList<String>();//파일
		ArrayList<String> movie=new ArrayList<String>();	//동영상
		
		ArrayList<String> test2=new ArrayList<String>();
		ArrayList<String> documentSize=new ArrayList<String>();
		ArrayList<String> movieSize=new ArrayList<String>();
		ArrayList<String> kgg=new ArrayList<String>();
		
		ServletContext context=request.getServletContext();
		String folder="";
		String FileSize="";
		String filename[]=new String[3];
		String width="";		//임시보관
		String widthArray[]=null;
		String widths=null;
		int widthInt=0;
		double imgFileSize=0;
		double documents=0;
		double moviess=0;
		long movies=(long) 0;
		//스토리지 용량
		int storage=100;	//GB
		
		//저장 공간 크기 GB -> KB 계산함
		int GBKB=104857600;
		int GBMB=0;
		int GB=0;
		int kk=0;
		int gg=0;
		
		if(pcl!=null) {
			//용량 측정
			for(int i=0; i<pcl.size();i++) {
				
				//저장 공간 크기 GB -> KB 계산함
				if(pcl.get(i).getPj_space().equals("1")) {
					GBKB=31457280;	//30GB
					GBMB=30720;
					GB=30;
					kk=3;
					gg=524288;
				}else if(pcl.get(i).getPj_space().equals("2")) {
					GBKB=52428800;	//50GB
					GBMB=51200;
					GB=50;
					kk=5;
					gg=524288;	//1% 0.5GB라봄 KB단위
				}else if(pcl.get(i).getPj_space().equals("3")) {
					GBKB=104857600;	//100GB
					GBMB=102400;
					GB=100;
					kk=10;
					gg=1048576;	//1% 1GB라봄
				}
				
				
				folder =context.getRealPath("/projectUpload/"+pcl.get(i).getPj_no());
				Path path3 = Paths.get(folder); // 디렉토리와 파일이 생성될 장소
				  DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
				  for(Path path : directoryStream) {
				   if(Files.isDirectory(path)) {
				    System.out.println("[[디렉토리]] " + path.getFileName());
				   } else {
					   
					   String test=path.getFileName().toString();
					   filename=test.split("\\.");
					   int size=filename.length-1;
					   
					   if(filename[size].equals("jpg")||filename[size].equals("png")||filename[size].equals("gif")) {
						   //이미지 파일일 경우
						   imgFileSize+=Files.size(path);
					   }else if(filename[size].equals("txt")||filename[size].equals("hwp")||filename[size].equals("cell")||filename[size].equals("pdf")||filename[size].equals("html")||filename[size].equals("ppt")||filename[size].equals("doc")||filename[size].equals("docx")) {
						   //문서 파일일 경구
						   documents+=Files.size(path);
					   }else if(filename[size].equals("mkv")||filename[size].equals("mp4")||filename[size].equals("wmv")||filename[size].equals("avi")||filename[size].equals("mov")||filename[size].equals("asf")||filename[size].equals("mpg")||filename[size].equals("mpeg")||filename[size].equals("vod")||filename[size].equals("flv")||filename[size].equals("swf")) {
						   //문서 파일일 경구
						   movies+=Files.size(path);
					   }
					   
					   //System.out.println("[[파일]] " + path.getFileName() + " (크기:" + Files.size(path) + ")");
				   }
				  }
				  /******************************** 이미지 **********************************/
				//용량 단위 변환
				  if(imgFileSize<1048576) {//1MB가 안될경우 KB로계산
					  img.add(Double.toString(Math.round(imgFileSize/1024))+"KB");
					  //용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  double storKB=GBKB;		//100GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((imgFileSize/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  
					  int g=gg;	//1GB
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
				
					  test2.add(Integer.toString(kg));
					  kgg.add(Integer.toString(kg));
					  imgFileSize=0;//초기화
				  }else if(imgFileSize>=1048576&&imgFileSize<1073741824){
					  img.add(Double.toString(Math.round((Double)(imgFileSize/1024)/1024))+"MB");
					  //용량 그래프화를 위한 크기 계산
					  /***** 그나마 최적화 한 코드 값 ******/
					  
					  //용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  int storKB=GBMB;		//GB를 MB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((imgFileSize/1024)/1024));	//mb
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  
					  BigDecimal windthBigInt=new BigDecimal(storKB);
					  BigDecimal windthBigInt2=new BigDecimal(widthInt);
					  windthBigInt.subtract(windthBigInt2);	
					 
					  //
					  widths=windthBigInt.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);
					  //
					  widthInt=windthBigInt.intValue();
					  
					  //widthInt=storKB-widthInt;		//사용중 용량
					  int g=gg;
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
					  test2.add(Integer.toString(widthInt));
					  kgg.add(Integer.toString(kg));
					  
					  //초기화
					  imgFileSize=0;
				  }else {//1073741824 이상일경우
					  img.add(Double.toString(Math.round((Double)((Double)(imgFileSize/1024)/1024))/1024)+"GB");
					  
					  //용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  int storKB=GBKB;		//GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-(imgFileSize/1024));	//KB (남은용량)
					  
					  BigDecimal windthBigInt=new BigDecimal(storKB);
					  windthBigInt=windthBigInt.subtract(storage1);	
					  System.out.println(windthBigInt);
					  
					  widthInt=windthBigInt.intValue();
					  
					  
					  //widthInt=storKB-widthInt;		//사용중 용량
					  int g=gg;
					  
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  System.out.println(k+"입니다.");
							  kg=k;
							  break;							  
						  }
					  }
					  test2.add(Integer.toString(widthInt));
					  kgg.add(Integer.toString(kg));
					  /*
					  //용량 그래프화를 위한 크기 계산
					  double storKB=GB;		//100GB
					  BigDecimal storage1=new BigDecimal(storKB-(((long)(imgFileSize/1024)/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  
					  test2.add(Integer.toString(widthInt));
					  kgg.add(Integer.toString(widthInt));*/
					  
					  
					  
					  imgFileSize=0;
				  }
				  /******************************** 문서 **********************************/
				  if(documents<1048576) {//1MB가 안될경우 KB로계산
					document.add(Double.toString(Math.round((Double)(documents/1024)/1024))+"KB");
					//용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  double storKB=GBKB;		//100GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((documents/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  int g=gg;
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
					  documentSize.add(Integer.toString(kg));
					  
					  documents=0;
				  }else if(documents>=1048576&&documents<1073741824){
					  document.add(Double.toString(Math.round((Double)(documents/1024)/1024))+"MB");
					  
					//용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  double storKB=GBKB;		//100GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((documents/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  int g=gg;
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
					  documentSize.add(Integer.toString(kg));
					  
					  documents=0;
				  }else {//1073741824 이상일경우
					  document.add(Double.toString(Math.round((Double)((Double)(documents/1024)/1024))/1024)+"GB");
					  
					  //용량 그래프화를 위한 크기 계산
					  double storKB=GB;		//100GB
					  BigDecimal storage1=new BigDecimal(storKB-(((long)(documents/1024)/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  
					  documentSize.add(Integer.toString(widthInt));
					  
					  documents=0;
				  }
				  
				  /******************************** 영화 **********************************/
				  /*String movS=movies.toString();
				  String movSAll[]=movS.split("\\.");
				  double movieA=Double.parseDouble(movSAll[0]);*/
				  
				  if(movies<1048576) {//1MB가 안될경우 KB로계산
					  movie.add(Long.toString(Math.round((long)(movies/1024)/1024))+"KB");
					  
					  
					//용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  double storKB=GBKB;		//100GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((movies/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  int g=gg;
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
					  movieSize.add(Integer.toString(kg));
					  
					  movies=0;
				  }else if(movies>=1048576&&movies<1073741824){
					  movie.add(Long.toString(Math.round((long)(movies/1024)/1024))+"MB");
					  
					//용량 그래프화를 위한 크기 계산
					  //double storKB=storage*1024*1024;
					  double storKB=GBKB;		//100GB를 KB로 환산함
					  BigDecimal storage1=new BigDecimal(storKB-((movies/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  int g=gg;
					  int kg=0;
					  for(int k=1;k<=kk;k++) {
						  if(widthInt<g*k) {
							  kg=k;
							  break;							  
						  }
					  }
					  movieSize.add(Integer.toString(kg));
					  
					  movies=0;
				  }else {//1073741824 이상일경우
					  movie.add(Long.toString(Math.round((long)((long)(movies/1024)/1024))/1024)+"GB");
					
					  //용량 그래프화를 위한 크기 계산
					  double storKB=GB;		//100GB
					  BigDecimal storage1=new BigDecimal(storKB-(((long)(movies/1024)/1024)/1024));
					  widths=storage1.toString();
					  widthArray=widths.split("\\.");
					  widthInt=Integer.parseInt(widthArray[0]);//남은 용량
					  widthInt=((int)storKB)-widthInt;		//사용중 용량
					  
					  movieSize.add(Integer.toString(widthInt));
					  
					  movies=0;
				  }
			}
			request.setAttribute("img",img);
			request.setAttribute("document",document);
			request.setAttribute("imgSize", test2);
			request.setAttribute("documentSize", documentSize);
			request.setAttribute("movie", movie);
			request.setAttribute("movieSize", movieSize);
			
			request.setAttribute("kgg", kgg);
		}
		
		
		
		return forward;
	}
}

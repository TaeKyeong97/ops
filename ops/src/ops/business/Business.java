package ops.business;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
public class Business {
	//사업자 등록번호 조회
	@SuppressWarnings("null")
	public HashMap<String,String> businessOk(String liceName, String liceNum) throws Exception {
		HashMap<String,String> list=new HashMap<String,String>();
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +"="+ "NKr1%2FQfLQhOlZANC9dE%2F5qtVeM1Ayu4zRLb7jkfRvcWut0tiysJKT2f%2Frihd9gvEZZ7%2Bm5huttBoo0WZMLAruA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("wkpl_nm","UTF-8") + "=" + URLEncoder.encode(liceName, "UTF-8")); //삼성전자
        urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no","UTF-8") + "=" + URLEncoder.encode(liceNum, "UTF-8"));//124815
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        String seqs[]=sb.toString().split("<(/)?seq>|<(/)?wkplJnngStcd>|<(/)?wkplNm>|<(/)?wkplStylDvcd>");
        if(seqs.length>=3&&seqs.length<5) {
        	list.put("seq",seqs[1]);	//식별번호
        }else if(seqs.length>=5&&seqs.length<7){
        	list.put("seq",seqs[1]);
        	list.put("wkplJnngStcd",seqs[3]);	//사업장가입상태코드
        }else if(seqs.length>=7&&seqs.length<9) {
        	list.put("seq",seqs[1]);
        	list.put("wkplJnngStcd",seqs[3]);
        	list.put("wkplNm",seqs[5]);	//회사명
        }else if(seqs.length>=9&&seqs.length<11) {
        	list.put("seq",seqs[1]);
        	list.put("wkplJnngStcd",seqs[3]);
        	list.put("wkplNm",seqs[5]);
        	list.put("wkplStylDvcd",seqs[7]);	//법인 개인
        }else {
        	System.out.println("에러");
        }
        if(list.get("seq")!=null) {
        	/*사업장 업종 조회*/
            urlBuilder = new StringBuilder("http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getDetailInfoSearch"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +"="+ "NKr1%2FQfLQhOlZANC9dE%2F5qtVeM1Ayu4zRLb7jkfRvcWut0tiysJKT2f%2Frihd9gvEZZ7%2Bm5huttBoo0WZMLAruA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("seq","UTF-8") + "=" + URLEncoder.encode(list.get("seq"), "UTF-8"));//124815
            url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());
            rd=null;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            sb = new StringBuilder();
            line=null;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            String seqs2[]=sb.toString().split("<(/)?jnngpCnt>|<(/)?vldtVlKrnNm>");
            if(seqs2.length>=3&&seqs2.length<5) {
            	list.put("jnngpCnt",seqs2[1]);	//식별번호
            }else if(seqs2.length>=5&&seqs2.length<7){
            	list.put("jnngpCnt",seqs2[1]);
            	list.put("vldtVlKrnNm",seqs2[3]);	//가입자수
            }
        }
        
        rd.close();
        conn.disconnect();
        return list;
	}
}

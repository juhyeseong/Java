package messenger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ex07 {
	public static void main(String[] args) throws Exception {
		try {
            // 파일 경로와 이름
            String filePath = "ServerData.dat";
            
            // 파일을 바이트 스트림으로 읽어들임
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            
            // BufferedReader로 문자열을 읽어들임
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

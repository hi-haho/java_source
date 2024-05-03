package pack;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// Properties 파일 읽기
		//중요한 값들을 .properties 혹은 
		//yml 같은 외부 설정값을 관리하는 파일에 적어두고 사용하고, 
		//어플리케이션을 실행하기 위한 커맨드에서 직접 값을 넘겨주기도 합니다.
		//암호화에 사용되는  key값들을 하드코딩하는 경우 보안적인 측면에서 안전하지 못하다.
		//이런 경우 파일명.Properties에 정보를 담은 후 읽어 줄 수 있다.
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\ex.properties"));
			System.out.println(prop.getProperty("mes1"));
			System.out.println(prop.getProperty("mes2"));
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}

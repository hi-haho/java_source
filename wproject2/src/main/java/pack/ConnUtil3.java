package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConnUtil3 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//페이징
	private int recTotal = 0; //레코드 전체 갯수
	private int pageSize = 5; //페이지 당 출력 레코드 수
	private int totalPage = 0; //전체 페이지 수
	
	public ConnUtil3() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("ConnUtil err : " + e);
		}
	}
	/*
	//목록 가져오기
	public ArrayList<SangpumDTO> getDataAll(String pa){
		// System.out.println(" ==== "+pa); //1
		ArrayList<SangpumDTO> list = new ArrayList<SangpumDTO>();
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			pstmt = conn.prepareStatement("select * from sangdata order by code desc");
			rs=pstmt.executeQuery();
			
			//포인터 이동
			int startNum = (Integer.parseInt(pa)-1) * pageSize +1;
			for(int p =1; p<startNum; p++) {
				rs.next();
				//레코드 포인터 위치 이동
				//pa:1(recPointer:0),pa:2(recPointer:5),pa:3(recPointer:10)
			}
			
			int i = 1;
			while(rs.next() && i <= pageSize) {
				SangpumDTO dto = new SangpumDTO();
				dto.setCode(rs.getString("code")); //.setCode(rs.getString(1))
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
				i++;
			}
			
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	*/
	//getDataAll 메서드를 람다(+stream) 표현식으로 수정
	public ArrayList<SangpumDTO> getDataAll(String pa){
		ArrayList<SangpumDTO> list = new ArrayList<SangpumDTO>();
		
		String url = "jdbc:mariadb://localhost:3306/test";
		String sql="select * from sangdata order by code desc";
		try(Connection conn= DriverManager.getConnection(url,"root","123");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			int startNum = (Integer.parseInt(pa)-1) * pageSize +1;
			rs.absolute(startNum-1); //레코드 포인터를 시작 위치로 이동
			list = Stream.iterate(1, i -> i+1) //1부터 시작하는 스트림 생성
					.limit(pageSize) //스트림의 크기는 pageSize로 제한
					//map을 통해 각 스트림 요소에 대해 SangpumDTO 객체를 생성
					//rs.next()를 호출, 다음 레코드로 이동
					.map(i->{
						try {
							if(rs.next()) {
								SangpumDTO dto = new SangpumDTO();
								dto.setCode(rs.getString("code")); //.setCode(rs.getString(1))
								dto.setSang(rs.getString("sang"));
								dto.setSu(rs.getString("su"));
								dto.setDan(rs.getString("dan"));
								return dto;
							}
						} catch (Exception e) {
							System.out.println("getDataAll_map err : " + e);
						}
						return null;
					})
					.filter(Objects::nonNull) //null이 아닌 객체만 필터링
					.collect(Collectors.toCollection(ArrayList::new)); //list에 add(생성)
			//일반적인 List,Set형태보다 더 특정한 자료형으로 생성하고 싶을때 사용한다
			//List형태를 ArrayList형태로 생성한 모습
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		}
		return list;
	}
	
	
	//페이징
	public int prepareTotalPage() {
		
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			String sql ="select count(*) from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//글이 없는 경우
			if(rs.next()) recTotal = rs.getInt(1);
			
			//전체 페이지 수 구하기
			totalPage = recTotal / pageSize;
			if(recTotal % pageSize !=0) {
				totalPage +=1; //페이지 넘은 레코드를 위한 페이지 추가
			}
			//System.out.println("전체 페이지 수 : " + totalPage);
			
		} catch (Exception e) {
			System.out.println("prepareTotalPage err : " + e);
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return totalPage;
	}
	
	
	
	//상품 추가
	public void insertData(SangpumBean bean) {

		//System.out.println(bean.getSang()+ " "+bean.getSu()+ " "+bean.getDan());
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url,"root","123");
			
			//새 상품 코드를 만들기
			String sql ="select max(code) from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int nextCode = rs.getInt(1);
			//System.out.println("가장 큰 상품번호 : " + nextCode);
			
			//(신상)insert
			pstmt = conn.prepareStatement("insert into sangdata values(?,?,?,?)");
			pstmt.setInt(1, nextCode+1);
			pstmt.setString(2, bean.getSang());
			pstmt.setString(3, bean.getSu());
			pstmt.setString(4, bean.getDan());
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
}

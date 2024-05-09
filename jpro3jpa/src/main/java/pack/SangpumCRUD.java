package pack;

import java.util.List;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangpumCRUD {
	public static void main(String[] args) { //여기에서 오류나오면 import 확인해보기
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa"); //Factory : 객체를 싱글톤으로 만들고있다.
		
		//EntityManager : thread 단위로 작업 (내부적으로 thread를 사용하고있다.)
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction(); 
		
		//자료 추가 transaction있음 . auto-commit은 필수이다.
		try {
			transaction.begin(); // auto commit false로 전환
			SangpumTable sangtab = new SangpumTable(5,"도시락",3,6000); //생성자타고 들어간다.
			//pk가 있는 값이면 아래와 같은 err가 나타난다.
			//ins err: jakarta.persistence.RollbackException: Error while committing the transaction
			em.persist(sangtab);
			transaction.commit();			
		} catch (Exception e) {
			System.out.println("ins err: "+e);
			transaction.rollback();
			return;
			
		}
		// 자료 수정
		/*
		try {
			transaction.begin();
			SangpumTable sangtab = em.find(SangpumTable.class,"5");
			if(sangtab == null) {
				System.out.println("해당자료없음");
			}else {
//				String newName = "마스크";
//				sangtab.setSang(newName);
				sangtab.setSang("마스크");
				transaction.commit();
			}
			
		} catch (Exception e) {
			System.out.println("up err: "+e);
			transaction.rollback();
			return;
		}
		*/
		
		//자료 삭제
		try {
			transaction.begin(); //transaction 시작
			int findCode = 5;
			SangpumTable sangtab = em.find(SangpumTable.class, findCode);
			if(sangtab == null) {
				System.out.println("해당자료없음");
				transaction.rollback();
			}else {
				em.remove(sangtab);
				System.out.printf("\n%s자료 삭제됨 \n",findCode);
				transaction.commit();
			}
			
		} catch (Exception e) {
			System.out.println("dl err: "+e);
			transaction.rollback();
			return;
		}
		
		
		//JPA를 사용한 DML처리
		try {
			System.out.println("전체 자료 읽기 1 ");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			//조회의 시작점을 의미하는 root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
			
			for(SangpumTable st : resultList) {
				System.out.println(st.getCode() + " "+ st.getSang() + " " + st.getSu() +  " " + st.getDan());
			}
			
			System.out.println("전체 자료 읽기 2");
			//TypedQuery을 이용해 JPQL 사용
//			TypedQuery<SangpumTable> queryql = em.createQuery("select s from SangpumTable s", SangpumTable.class); //SangpumTable 엔티티 테이블이다.
//			List<SangpumTable> list = queryql.getResultList();
			//위의 두줄을 한줄로
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			
			
			for(SangpumTable st : list) {
				System.out.println(st.getCode() + " "+ st.getSang() + " " + st.getSu() +  " " + st.getDan());
			}
			
			System.out.println("\n== 부분 자료 읽기 1==");
			int findId = 1; // String으로 읽어도 상관없다. String findId = 1; find()메서드는 pk 칼럼이 대상이다.
			SangpumTable sangtab = em.find(SangpumTable.class, findId); //SangpumTable은 논리적 테이블 >물리적 테이블과 연결되어있다.
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else {
				System.out.printf("%s %s %s %s\n",sangtab.getCode(),sangtab.getSang(),sangtab.getSu(),sangtab.getDan());
			}
			
			System.out.println("\n== 부분 자료 읽기 2==");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(query.where(cb.equal(root.get("sang"),"장갑")));
			List<SangpumTable> list2 = typedQuery.getResultList();
			for(SangpumTable st : list2) {
				System.out.printf("%s %s %s %s\n",sangtab.getCode(),sangtab.getSang(),sangtab.getSu(),sangtab.getDan());
			}			
			
			
		} catch (Exception e) {
			System.out.println("err: "+e);
		}finally {
			em.close();
			emf.close(); // 필수
		}
	}
}

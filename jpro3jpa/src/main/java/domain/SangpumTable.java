package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//sangdata 테이블과 연결
//중간에 jpa가 껴있다.

@Entity // JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션
@Table(name="sangdata") //테이블 이름이 같지 않으면 적어줘야한다. 물리적인 테이블명 sangdata
public class SangpumTable {
	@Id //pk칼럼 알려주는 어노테이션
	@Column(name="code") //지금처럼 원본테이블과 칼럼명이 같으면 생략가능 
	private int code;
	@Column(name="sang", nullable = false) //
	private String sang;
	private int su;
	private int dan;
	
	public SangpumTable() {
		// jpa에서 생성자는 비어있어도 무조건 적어줘야한다.
	}
	
	public SangpumTable(int code,String sang, int su, int dan) {
		this.code = code;
		this.sang = sang;
		this.su = su;
		this.dan = dan;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	

}

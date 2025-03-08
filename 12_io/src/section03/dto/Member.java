package section03.dto;

import java.io.Serializable;

/*
 * 마커 인터페이스(Marker Interface)
 * - 어떤 역할 또는 어떤 기능의 대상임을 표시하는 인터페이스
 * 
 * Serializable 인터페이스
 * - 직렬화의 대상임을 명시하는 인터페이스
 * 
 */
public class Member implements Serializable { // 직렬화 가능하다는 마크를 implement(인터페이스 상속)
	// The serializable class Member 
	//does not declare a static final serialVersionUID 
	// field of type long
	// -> 직렬화된 객체가 Member인지 확인하는 용도의 id(식별번호)
	public static final long serialVersionUID = 123456789L; // 이걸 쓰면 Member에 노란줄 사라짐
	// public static final long serialVersionUID = 1111; // 숫자는 아무거나?
	

	private String id;
	private String pw;
	private String name;
	
	public Member() {}
	
	

	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

	
	
	
	
	
	
}

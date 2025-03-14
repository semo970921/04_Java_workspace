package section03.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import section03.dto.Member;

public class ObjectService {

	/**
	 * Member 객체 하나를 파일로 출력하기
	 */
	public void outputMember() {
		
		//출력용 스트림 참조 변수 선언
		FileOutputStream fos = null; // 기반 스트림
		ObjectOutputStream oos = null; //객체 출력 보조 스트림
		
		
		try {
			
			// 출력할 Member
			Member member = new Member("member111222333", "1q2w3e4r!", "짱구");
			
			// 파일 출력 기반 스트림 객체 생성
			fos = new FileOutputStream("io_test/byte/Member.bin"); 
			// .bin 확징자 : 바이너리 코드(== 바이트코드) 저장 파일 확장니
			
			// 객체 출력 보조 스트림 객체 생성
			oos = new ObjectOutputStream(fos); // 기반 스트림과 연결
			
			// 보조 스트림을 이용해서 파일에 Member 객체를 출력
			oos.writeObject(member);
			
			System.out.println("출력 완료");
			
			
			//=======================
			// 밑에 먼저 하고 try
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Unhandled exception type IOException
			
		}
		
	}
	
	
	/**
	 * 파일에서 Member 객체 입력 받기(읽어오기)
	 */
	public void inputMember() {
		
		// 스트림 참조 변수 선언
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			
			// 입력 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/Member.bin");
			
			// 객체 입력 보조 스트림 생성
			ois = new ObjectInputStream(fis);
			
			// 연결된 파일로 부터 Member 객체 읽어오기
//			ois.readObject();
			// - 파일에 존재하는 Member 객체는 직렬화된 상태!
			// -> readObject() 호출 시 자동으로 "역직렬화" 수행
			//  -> JVM이 객체를 인식 가능한 상태로 변경
			Member member = (Member)ois.readObject();
			
			
			System.out.println("읽어온 Member");
			System.out.println(member/* .toString() */); 
			
			
			
			//===============
			// catch먼저 하고 try
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			
			try {
				//ois.close();
				if(ois != null) ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Unhandled exception type IOException
		}
		
	}
	
	
	//===========================================================
	
	// -------------------250212----------------------------------
	
	public void outputMemberList() {
		
		// 스트림 객체 참조 변수
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; 
		// 이 통로 객체는 프로그램이 종료되도
		// 자동으로 사라지는게 아님
		
		try {
			
			List<Member> memberList = new ArrayList<Member>();
			
			memberList.add(new Member("member01", "pass01", "짱구"));
			memberList.add(new Member("member02", "pass02", "맹구"));
			memberList.add(new Member("member03", "pass03", "훈이"));
			memberList.add(new Member("member04", "pass04", "유리"));
			memberList.add(new Member("member05", "pass05", "철수"));
			memberList.add(new Member("member06", "pass06", "수지"));
			
			// 스트림 객체 생성
			fos = new FileOutputStream("io_test/byte/MemberList.bin"); // ㅡMemberList가 바이너리 형태로 연결된 파일이랑 연결
			
			// 보조스트림과 연결
			oos = new ObjectOutputStream(fos);
			
			// 보조 스트림을 이용해서 출력
			oos.writeObject(memberList);
			
			System.out.println("회원 목록 출력 완료");
			
			
			// =====================================
			// catch 먼저
			
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 메서드 추적
		} finally {
			// 따라서 수동으로 종료시킴
			try {
				//oos.close(); // 이거 쓰고 Suround~
				if(oos != null) oos.close(); // 이거 쓰고 Suround~
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 보조 스트림 close 시 기반 스트림도 같이 close!!
		}
	}
	
	
	// 위 파일 읽어와서 MemberList로 저장
	
	/**
	 * MemberList.bin 내용 읽어오기
	 */
	public void inputMemberList() {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			// 스트림 객체 생성
			fis = new FileInputStream("io_test/byte/MemberList.bin");
			ois = new ObjectInputStream(fis);
			
	
			// 직렬화된 상태로 저장된 List<Member> 객체를 읽아와
			// 역직렬화해서 저장
			List<Member> memberList = (List<Member>)ois.readObject(); // 다운캐스팅
			
			// 확인
			for(Member member : memberList) {
				System.out.println(member);
			}
			
			
			
			
			// ===============================
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 보조 스트림 close -> 기반 스트림도 같이 close
				if(ois != null)ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

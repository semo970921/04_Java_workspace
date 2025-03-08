package section01;

public class OuterClass1 {
	
	// Outer Class1의 필드( == 멤버 변수)
	private int num;
	
	private void test() { // 멤버 메서드
		System.out.println("OuterClass1의 test() 메서드 입니다.");
		System.out.println("num : " + num); 
		// 같은 멤버들끼리는 서로가 서로를 호출할 수 있음
		// 접근 제어자는 관련 없음
	}
	
	
	
	/*외부 클래스 메서드를 이용해서 내부 클래스 객체 생성*/
	// 이번엔 외부에서 내부클래스 메서드 호출하고싶음
	public void displaymessage() {
		System.out.println("[외부 클래스에서 내부 클래스 객체 생성]");
		
		InstanceInnerClass inner = new InstanceInnerClass();
		inner.display();
		
	}
	
	// =====================================
	//  밑에거 하고 displayMessage
	
	
	/* 인스턴스 내부 클래스 정의 == OuterClass1의 멤버 */
	public class InstanceInnerClass{ // 새로운 멤버 추가
		public void display() {
			System.out.println("InstanceInnerClass의 display() 메서드");
			
			num = 300; // OuterClass1의 멤버 변수 값 변경
			test(); // OuterClass1의 멤버 메서드 호출
			// 같은 멤버들끼리는 서로가 서로를 호출할 수 있음
			
			// -> 인스턴스 내부 클래스는 외부 클래스 멤버 접근 가능!
		}
	}
	
	
}

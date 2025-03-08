package section02;


public /* static */ class OuterClass2 {
	
	// 외부 클래스의 멤버
	private int outerInstanceNum = 100; // static X => 인스턴스 변수(인스턴스가 만들어져야만 사용 가능)
	private static int outerStaticNum = 20; // static O => 클래스 변수
	
	
	/*정적(static) 내부 클래스 정의*/
	public static class StaticInnerClass{
		public int innerInstanceNum = 300; // 내부 클래스의 인스턴스 변수
		public static int innerStaticNum = 50; // 내부 클래스의 클래스 변수
		
		public void display() {
			
			System.out.println("[내부 클래스 display() 메서드]");
			
			
			// System.out.println("outerInstanceNum : " + outerInstanceNum);
			// Cannot make a static reference to the non-static field outerInstanceNum
			// 오류 발생 -> 외부 클래스의 인스턴스 변수 호출 불가
			
			// 외부 클래스의 static 변수 호출 가능!
			// -> static끼리는 호출하는데 문제 없음(tip, static끼리는 static끼리 호출, heap끼리는 heap끼리 호출)
			System.out.println("outerStaticNum : " + outerStaticNum);
			
			
			// static 없는건 없는거끼리 호출 가능
			// 정적(static) 내부 클래스라도
			// 내부의 non-static 멤버끼리는 호출 가능!!
			System.out.println("innerInstanceNum : " + innerInstanceNum );
			
			
			//static() -> non-static 호출 X
			//static() -> tatic 호출 O
			//non-static -> static() 호출 O
			System.out.println("innerStaticNum : " + innerStaticNum);
		
		}
		
		public static void staticDisplay() {
			System.out.println("[내부 클래스 staticDisplay() 메서드]");

			// 외부 클래스의 클래스 변수는
			// 정적 내부 클래스의 static 메서드에서도 호출이 가능!
			// 즉, stataic 끼리 호출하는건 아무 문제 없음
			System.out.println("outerStaticNum : " + outerStaticNum);

			
			// innerInstanceNum은 static이 없고 staticDiplay는 static이 있음
			// 오류 발생 -> non-static 멤버 변수 호출 불가!
			// System.out.println("innerInstanceNum : " + innerInstanceNum );

			// static - static 호출 문제 없음
			System.out.println("innerStaticNum : " + innerStaticNum);
		}
		
	}
	
	
	
	
}

package section02;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		

		/*Predicate 계열
		 * - 매개 변수를 전달 받아
		 *   boolean 값을 반환하는 함수형 인터페이스
		 *   -> 조선식
		 *   
		 * - test() 메서드 제공
		 * 
		 */
		
		/*Predicate<T> : T를 전달 받아 boolean을 반환*/
		Predicate<Integer> ageLimit 
			= (age) -> { 
				if(age<0 || age>100) return false;
				return age>=20;
			};
			
		
			// 17은 0~100 사이 정수 이면서 20 이상인 경우
			if(ageLimit.test(17)) {
				System.out.println("성인입니다..");
			} else {
				System.out.println("성인X 또는 잘못 입력");
			}
		
		
			
			/*BiPredicate<T,U> : 매개 변수 T, U를 전달 받아 boolean 반환*/
			BiPredicate<String, String> StringLengthCompare 
			 = (str1, str2) -> str1.length() > str2.length();
			// str1이 str2보다 길면 true
			 
			 String str1 = "hello world!!";
			 String str2 = "show me the money";
			 
			 String result
			  = StringLengthCompare.test(str1, str2) ? str1 : str2;
			 
			 System.out.println(result + " 가 더 긴 문자열");
			 
			 
			
			
			
			
			
	}
}

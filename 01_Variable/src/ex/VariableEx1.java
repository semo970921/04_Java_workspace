package ex; // 현재 클래스 파일이 저장된 폴더 경로

public class VariableEx1 {
    public static void main(String[] args) {
        System.out.println("[Java 변수와 자료형]");

        int num1;
        /*System.out.println(num1);
        * Variable 'num1' might not have been initialized
        * */
        num1 = 200;
        System.out.println("num1 = " + num1);

        System.out.println("-----------------------");
        System.out.println("[자료형별 리터럴 작성법]");

        // 논리형(boolean, 1byte)
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println("---논리형---");
        System.out.println("bool1 = " + bool1);
        System.out.println("bool2 = " + bool2);

        if(bool1 && !bool2){
            System.out.println("이거 출력될까?");
        }

        // 정수형 : byte(1), short(2),=> int 보다 작은거
        // int(4)
        // long(8) => int 보다 큰거
        System.out.println("---정수형---");
        int intNum1 = 2147483647; // int 최대값
        // int intNum2 = 2147483648
        // long longNum1 = 2147483648;
        long longNum1 = 2147483648L;
        long longNum2 = 30_000_000_000l; // 300억
        System.out.println("intNum1 = " + intNum1);
        System.out.println("longNum1 = " + longNum1);
        System.out.println("longNum2 = " + longNum2);

        System.out.println("---실수형---");
        float floatNum = 1.123456789f;
        double doubleNum = 1.123456789;
        System.out.println("floatNum = " + floatNum);
        System.out.println("doubleNum = " + doubleNum);

        System.out.println("---문자형---");
        char ch1 = 'A';
        char ch2 = '가';
        char ch3 = '承';
        char ch4 = '★'; // ㅁ + 한자
        System.out.println("ch1 = " + ch1);
        System.out.printf("%c, %d, %x \n", ch1, (int)ch1, (int)ch1);
        System.out.println("ch2 = " + ch2);
        System.out.println("ch3 = " + ch3);
        System.out.println("ch4 = " + ch4);

        System.out.println("---String---");
        String str1 = "A";
        String str2 = "AB";
        String str3 = "ABC";
        String str4 = "ABCD";
        System.out.println("str1 = " + str1);
        System.out.println("str1의 주소 : " + System.identityHashCode(str1));
        System.out.println("str2 = " + str2);
        System.out.println("str2의 주소 : " + System.identityHashCode(str2));
    }
}

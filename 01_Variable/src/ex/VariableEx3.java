package ex;

public class VariableEx3 {

    public static void main(String[] args) {
        System.out.println("[강제 형변환 예제1 - 데이터 손실]");

        int num1 = 290;
        byte result1 = (byte)num1;

        System.out.println("num1 = " + num1); // 290
        System.out.println("result1 = " + result1); // 34

        System.out.println("---------------------------");
        System.out.println("[강제 형변환 예제2 - 데이터 손실]");

        double num2 = 123.999;
        int result2 = (int)num2;
        System.out.println("num2 = " + num2); // num2 = 123.999
        System.out.println("result2 = " + result2); //result2 = 123

        System.out.println("---------------------------");
        System.out.println("[강제 형변환 예제3 - 데이터 손실 의도적]");

        for(int i=0; i<5; i++){
            int randomNumber = (int)(Math.random() * 10 + 1);
            System.out.println("randomNumber = " + randomNumber);
        }

        System.out.println("---------------------------");
        System.out.println("[의도적으로 자료형 변환1]");

        int a3 = 5;
        int b3 = 2;

        System.out.println(a3 / b3); // 2

        // a3 / b3 == 2.5 나오게 만들기
        System.out.println((double)a3 / (double)b3); // 2.5
        System.out.println((double)a3 / b3); // 2.5

        System.out.println("---------------------------");
        System.out.println("[의도적으로 자료형 변환2]");

        System.out.println("문자(char) <-> 유니코드(int)");

        System.out.println("A의 유니코드 번호 : " + 'A'); // A
        System.out.println("A의 유니코드 번호 : " + (int)'A'); // 65
        System.out.println("A 뒤에 10번째 문자 : " + ('A' + 10)); // 75
        System.out.println("A 뒤에 10번째 문자 : " + (char)('A' + 10)); // K

        char a = 'A';
        System.out.println("a : " + a); // a : A




    }
}

package ex;

public class VariableEx2 {
    public static void main(String[] args) {
        System.out.println("[자동 형변환 예시1]");

        int a1 = 12;
        double b1 = 1.3;
        // int result1 = a1 + b1;
        double result1 = a1 + b1;
        System.out.println("result1 = " + result1);

        System.out.println("[자동 형변환 예시2]");
        char ch2 = 'A';
        int num2 = 100;
        int result2 = ch2 + num2;
        System.out.println("result2 = " + result2); // result2 = 165

        System.out.println("[자동 형변환 예시3]");
        int a3 = 3;
        int b3 = 2;

        // int / int = int (값 처리 원칙)
        int result3 = a3 / b3;
        System.out.println("result3 = " + result3); // result3 = 1

        System.out.println("[자동 형변환 예시4]");
        int a4 = 100;
        double b4 = 23.4;

       /* int result4 = a4 + b4;
       * Type mismatch: cannot convert from double to int*/
        int result4 = (int)(a4 + b4);
        double result5 = a4 + b4;
        System.out.println("result4 = " + result4); // result4 = 123
        System.out.println("result5 = " + result5); // result5 = 123.4




    }
}

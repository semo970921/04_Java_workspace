package common;

// import (가져오다) : 다른 패키지에 존재하는 클래스를 가져오는 구문
import java.util.Scanner;

public class ScannerEx1 {

    public static void main(String[] args) {


        // Scanner 생성 구문
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num1 = sc.nextInt();
        // sc.nextInt()
        // - 입력 버퍼에서 다음 정수 읽어오기
        // - 정수가 아닌 다른 값이 입력되어 읽어져 오면
        //   예외(Exception)이 발생한다

        // *  java.util.InputMismatchException -> 입력 자료형이 맞지 않음 예외

        System.out.println("입력 받은 num1 : " + num1);

        System.out.print("두 번째 정수 입력 : ");
        int num2 = sc.nextInt();
        System.out.println("입력 받은 num2 : " + num2);

        System.out.println("num1 + num2 = " + (num1 + num2)); // 우선순위 높이기 위해 괄호 필요

    }
}

package section01.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {

    Scanner sc = new Scanner(System.in);

    public void test1(){
        System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v1");

        System.out.print("첫 번째 정수 : ");
        int num1 = sc.nextInt();

        System.out.print("두 번째 정수 : ");
        int num2 = sc.nextInt();

        try {

			System.out.println("몫 : " + num1 / num2);

		} catch(ArithmeticException e) {

			System.out.println("0으로 나눌 수 없습니다.");
		}

        // System.out.println("몫 : " + num1 / num2);

        // 이게 출력되야 정상 출력 됨
        System.out.println("-----프로그램 종료-----");
    }

    public void test2(){
        System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v2");


        try {
            System.out.print("첫 번째 정수 : ");// InputMismatchException
            int num1 = sc.nextInt();
            System.out.print("두 번째 정수 : ");
            int num2 = sc.nextInt();

            System.out.println("몫 : " + num1 / num2);
        } catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");

        } catch(InputMismatchException e) {

            System.out.println("정수만 입력 해주세요.");
        }


        System.out.println("-----프로그램 종료-----");
    }

    public void test3() {
        System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v3");


        try {
            System.out.print("첫 번째 정수 : ");// InputMismatchException
            int num1 = sc.nextInt();
            System.out.print("두 번째 정수 : ");
            int num2 = sc.nextInt();

            System.out.println("몫 : " + num1 / num2);
        } catch(RuntimeException e) {

            System.out.println("프로그램 실행 중 예외 발생");

        }


        System.out.println("-----프로그램 종료-----");
    }

    public void test4() {
        System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v4");


        try {
            System.out.print("첫 번째 정수 : ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 정수 : ");
            int num2 = sc.nextInt();
            System.out.println("몫 : " + num1 / num2);

            // 강제 예외 발생
            int[] arr = new int[3];
            arr[10] = 100;
            // java.lang.ArrayIndexOutOfBoundsException
            // 배열의 인덱스 범위 초과

        }

        catch(InputMismatchException e) {
            System.out.println("정수만 입력해주세요.");
        }

        catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        catch(RuntimeException e) {
            System.out.println("실행 중 예외 발생");
        }

        System.out.println("-----프로그램 종료-----");
    }

    public void test5() {

        int input = 0;

        do {

            System.out.println("-----강제로 발생시켜 던질 예외 선택-----");

            System.out.println("1. ArithmeticException");
            System.out.println("2. ArrayIndexOutOfBoundsException");
            System.out.println("3. RuntimeException");
            System.out.println("4. IOException");
            System.out.println("5. Exception");
            System.out.println("0. 종료");

            try {
                System.out.print("예외 선택 >> ");
                input = sc.nextInt();
                switch(input) {
                    case 1: throw new ArithmeticException(); // break; // Unreachable cod
                    case 2: throw new ArrayIndexOutOfBoundsException();
                    case 3: throw new RuntimeException();
                    case 4: throw new IOException();
                    case 5: throw new Exception();
                    case 0: System.out.println("종료 선택");
                }

            } catch(InputMismatchException e) {
                System.out.println("정수만 입력해주세요.");
                sc.nextLine(); //입력 버퍼에 남은 문자열 제거
                input = -1; // 잘못 입력된 경우 종료되는 것을 방지
            } catch(ArithmeticException e){
                System.out.println("ArithmeticException() 처리 완료");
            } catch(RuntimeException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
                System.out.println(" 또는 ");
                System.out.println("RuntimeException");
            } catch(Exception e) {
                System.out.println("예외 최상위 부모 Exception으로");
                System.out.println("나머지 모든 예외 잡아서 처리");
            }


        }while(input != 0);

        System.out.println("-----프로그램 정상 종료-----");


    }

    public void test6() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("1. 정상수행 / 2. 예외 강제 발생 : ");
            int input = sc.nextInt();

            if(input == 1) System.out.println("예외 없이 정상 수행");
            else {
                System.out.println("[예외 강제 발생]");
                throw new Exception("강제로 던져진 예외");
            }

        } catch (Exception e) {

            /* 에러로 출력 */
            System.err.println(e.getMessage());

            return;
        } finally {

            System.out.println("<<< 프로그램 종료 >>>");

            sc.close();
        }
    }




}

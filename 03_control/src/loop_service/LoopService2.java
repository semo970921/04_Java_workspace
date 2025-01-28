package loop_service;

import java.util.Scanner;

public class LoopService2 {

    Scanner sc = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("[LoopService2222222");
        System.out.println("1. method1()");
        System.out.println("2. method2()");
        System.out.println("3. method3()");
        System.out.println("4. method4()");
        System.out.println("5. method5()");

        System.out.print("번호 입력 >> ");
        int input = sc.nextInt();

        switch(input){
            case 1: method1(); break;
            case 2: method2(); break;
            case 3: method3(); break;
            case 4: method4(); break;
            case 5: method5(); break;


            default: System.out.println("잘못 입력");
        }
    }

    /**
     * <pre>
     * (0,0) (0,1) (0,2)
     * (1,0) (1,1) (1,2)
     * (2,0) (2,1) (2,2)
     * (3,0) (3,1) (3,2)
     * </pre>
     */
    public void method1(){
        for(int row=0; row<4; row++){
            for(int col=0; col<3; col++){
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }
    }


    /**
     * 1 ~ 20 까지 출력
     * 단, 입력 받은 수에서 반복 멈추기
     */
    public void method2(){
        System.out.print("stop number >> ");
        int stop = sc.nextInt();

        for(int i=1; i<=20; i++){
            System.out.print(i + " ");

            if(i == stop){
                break;
            }
        }
    }

    /**
     * 1 ~ 20 까지 출력
     * 단, 입력 받은 수의 배수는 출력X
     */
    public void method3(){
        System.out.print("continue number >> ");
        int con = sc.nextInt();

        for(int i=1; i<=20; i++){
            if (i%con == 0){
                continue;
            }
            System.out.print(i + " ");
        }
    }

    /**
     * 0이 입력 될 때 까지
     * 입력된 모든 숫자 합계 구하기
     */
    public void method4(){
        int sum = 0;
       // int input = -1;
        int input = 0;

        while(input != 0){
            System.out.print("정수 입력 >> ");

            input = sc.nextInt();
            sum += input;
        }

        System.out.println("합계 : " + sum);
    }

    /**
     * 0이 입력 될 때 까지
     * 입력된 모든 숫자 합계 구하기
     */
    public void method5(){
        int sum = 0;
        int input = 0;

        do{
            System.out.print("정수 입력 >> ");

            input = sc.nextInt();
            sum += input;
        } while(input != 0);

        System.out.println("합계 : " + sum);
    }







}

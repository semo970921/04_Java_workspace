package loop.practice;

import java.util.Scanner;

/**
 * @author  정승원
 * 기능 제공용 클래스
 */
public class LoopPractice {

    Scanner sc = new Scanner(System.in);

    /** 실습문제 1
     * 사용자로부터 한 개의 값을 입력 받아
     * 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
     단, 입력한 수는 1보다 크거나 같아야 합니다.

     만일 1 미만의 숫자가 입력됐다면
     “1 이상의 숫자를 입력해주세요“를 출력하세요.
     */
    public void practice1(){
        System.out.print("1 이상의 숫자를 입력하세요: ");
        int input = sc.nextInt();

        if(input >= 1){
            for(int i=1; i<=input; i++){
                System.out.print(i + " ");
            }
        } else{
            System.out.println("1이상의 숫자를 입력해주세요.");
        }
    }

    /** 실습문제 2
     사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
     단, 입력한 수는 1보다 크거나 같아야 합니다.
     */
    public void practice2(){
        System.out.print("1이상의 숫자를 입력하세요: ");
        int input = sc.nextInt();

        if(input >= 1){
            for(int i=input; i>=1; i--){
                System.out.print(i + " ");
            }
        } else{
            System.out.println("1이상의 숫자를 입력하세요.");
        }
    }

    /** 실습문제 3
     1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.

     <pre>
     ex.
     정수를하나입력하세요: 8
     1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
     </pre>
     */
    public void practice3(){
        System.out.print("정수를 하나 입력하세요: ");
        int input = sc.nextInt();
        int sum = 0;

        for(int i=1; i<=input; i++){
            sum += i;
            if(i < input){
                System.out.print(i + " + ");
            } else{
                System.out.print(i + " = " + sum);
            }
        }
    }

    /** 실습문제 4
     사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
     만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.

     <pre>
     ex.
     첫 번째 숫자 : 8	첫 번째 숫자 : 4	첫 번째 숫자 : 9
     두 번째 숫자 : 4 	두 번째 숫자 : 8 	두 번째 숫자 : 0
     4 5 6 7 8 			4 5 6 7 8 			1 이상의 숫자를 입력해주세요
     </pre>
     .*/
    public void practice4(){
        System.out.print("첫 번째 숫자: ");
        int num1 = sc.nextInt(); // 작다고 가정

        System.out.print("두 번째 숫자: ");
        int num2 = sc.nextInt(); // 크다고 가정

        // solution1
        /*if(num1 < 1  || num2 < 1){
            System.out.print("1이상의 숫자를 입력하세요");
        }else{ // 둘 다 1 미만이 아님
            if(num1 > num2){
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        }

        for(int i=num1; i<=num2; i++){
            System.out.print(i + " ");
        }*/

        // solution2
        int start = num1;
        int end = num2;

        if(num1 < 1  || num2 < 1){
            System.out.print("1이상의 숫자를 입력하세요");
        }else{
            if(num1 > num2){
                start = num2;
                end = num1;
            }
        }

        for(int i=start; i<=end; i++){
            System.out.print(i + " ");
        }
    }



    /** 실습문제 5
     사용자로부터 입력 받은 숫자의 단을 출력하세요.
     <pre>
     ex.
     숫자: 4
     ===== 4단=====
     4 * 1 = 4
     4 * 2 = 8
     4 * 3 = 12
     4 * 4 = 16
     4 * 5 = 20
     4 * 6 = 24
     4 * 7 = 28
     4 * 8 = 32
     4 * 9 = 36
     </pre>
     */
    public void practice5(){
        System.out.print("숫자: ");
        int dan= sc.nextInt();

        System.out.printf("====%d====\n", dan);

        for(int i=1; i<10; i++){
            System.out.printf("%d * %d = %d\n", dan, i, i*dan);
        }
    }

    /** 실습문제 6
     사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
     단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
     <pre>
     숫자: 4
     ===== 4단=====
     4 * 1 = 4
     4 * 2 = 8
     ..
     ===== 5단=====
     5 * 1 = 5
     ..

     ..
     ===== 9단=====

     숫자: 10
     2~9 사이숫자만입력해주세요.
     </pre>
     */
    public void practice6(){
        System.out.print("숫자 : ");
        int dan = sc.nextInt();

        if(dan >= 2 && dan <= 9){
            for(int i=dan; i<=9; i++){
                System.out.printf("====%d====\n", i);

                for(int j=1; j<=9; j++){
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                }
            }
        } else{
            System.out.println("2~9 사이숫자만입력해주세요.");
        }
    }

    /** 실습문제7
     다음과 같은 실행 예제를 구현하세요.
     ex.
     정수 입력 : 4
     *
     **
     ***
     ****
     */
    public void practice7(){
        System.out.print("정수 입력: ");
        int input = sc.nextInt();

        for(int row=1; row<=input; row++){
            for(int col=1; col<=row; col++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /** 실습문제 8
     다음과 같은 실행 예제를 구현하세요.
     ex.
     정수 입력 : 4
     ****
     ***
     **
     *
     */
    public void practice8(){
        System.out.print("정수 입력: ");
        int input = sc.nextInt();

        for(int row=input; row>=1; row--){
            for(int col=row; col>=1; col--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /** 실습문제 9
     다음과 같은 실행 예제를 구현하세요.

     ex.
     정수입력: 4
          *
        **
       ***
     ****
     */
    public void practice9(){
        System.out.print("정수 입력: ");
        int input = sc.nextInt();

        // solution1
       /*for(int row=1; row<=input; row++){
           // solution1-1
           for(int col=1; col<=input-row; col++){
               System.out.print(" ");
           }
           for(int col=input; col>input-row; col--){
               System.out.print("*");
           }
           System.out.println();

           // solution 1-2
          for(int col=input-row; col>=1; col--){
               System.out.print(" ");
           }

           for(int col=1; col<= row; col++){
               System.out.print("*");
           }
           System.out.println();
       }*/

        // solution2
        for(int row=1; row<=input; row++){
            for(int col=1; col<=input; col++){
                if(col <=  input-row){
                    System.out.print(" ");
                } else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    /** 실습문제 10
     다음과 같은 실행 예제를 구현하세요.

     ex.
     정수 입력 : 3
     *
     **
     ***
     **
     *

     */
    public void practice10(){
        System.out.print("정수 입력: ");
        int input = sc.nextInt();

        // 위쪽 삼각형
        for(int row=1; row<=input; row++){
            for(int col=1; col<=row; col++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 아래쪽 삼각형
        for(int row= 1; row<input; row++){
            for(int col=1; col<=input-row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }







































}

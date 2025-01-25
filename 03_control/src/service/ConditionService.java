package service;

import java.util.Scanner;

/**
 * @author 정승원
 * 기능(예제, 연습문제) 제공용 클래스
 */
public class ConditionService {

    Scanner sc = new Scanner(System.in);

    /**
     * 1 ~ 10 사이 난수(정수)가
     * 짝수인지 홀수인지 검사
     */
    public void method1(){

        int randomNumber = (int)(Math.random() * 10 + 1);

        boolean result = randomNumber % 2 == 0;
        System.out.println("randomNumber : " + randomNumber);

        if(result){
            System.out.println("짝수 입니다.");
        } else {
            System.out.println("홀수 입니다.");
        }

    }

    /**
     * 나이를 입력 받아 "어린이", "청소년", "성인" 구분
     *
     * <pre>
     * 13세 이하 "어린이"
     * 13세 초과 19세 이하 "청소년"
     * 19세 초과 "성인"
     * </pre>
     */
    public void method2(){
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        String result;
        if(age > 19){
            result = "성인";
        } else if (age > 13){
            result = "청소년";
        } else{
            result = "어린이";
        }
        System.out.println(result);
    }

    /**
     * 나이를 입력 받아 구분하기
     *
     * <pre>
     * 13세 이하 "어린이"
     * 13세 초과 19세 이하 "청소년"
     * 	- 14 ~ 16 : 청소년(중)
     * 	- 17 ~ 19 : 청소년(고)
     * 19세 초과 "성인"
     * 0 미만 100 이상 : "잘못 입력하셨습니다"
     * </pre>
     */
    public void method3(){
        System.out.println("나이 입력 : ");
        int age = sc.nextInt();

        // 가장 먼저  "잘못 입력하셨습니다" 해야함
        // 이유는 노션
        if(age < 0 || age >=100){
            System.out.println("잘못 입력하셨습니다.");
            return;
        }

        String result;
        if(age > 19) {
            result = "성인";
        } else if(age>13){
            result = "청소년" + (age<=16 ? "(중)" : "(고)");
        } else{
            result = "어린이";
        }
        System.out.println(result);

    }

    // ============================================

    /**
     * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
     */
    public void displayMenu(){
        System.out.println("1. method1()");
        System.out.println("2. method2()");
        System.out.println("3. method3()");
        System.out.println("4. scoreTest()"); // 밑에 성적
        System.out.println("5. scoreTest2()"); // 밑에 성적


        System.out.print("메뉴 번호 입력 >> ");
        int input = sc.nextInt();

        switch(input){
            case 1 : method1(); break;
            case 2 : method2(); break;
            case 3 : method3(); break;
            case 4 : scoreTest(); break;
            case 5 : scoreTest2(); break;
            default :
                System.out.println("없는 메뉴 번호 입니다.");
        }
    }

    /** [성적 판별기]
     * <pre>
     * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
     *
     * - 중간고사 (40%), 기말고사(50%), 과제(10%)
     *
     * - 입력 시 각각 100점 만점으로 입력 받음
     *
     * - 합산된 점수에 따라 성적 부여
     *
     * 95점 이상 : A+
     * 90점 이상 : A
     * 85점 이상 : B+
     * 80점 이상 : B
     * 75점 이상 : C+
     * 70점 이상 : C
     * 65점 이상 : D+
     * 60점 이상 : D
     * 나머지    : F
     *
     *
     * [실행 화면]
     * 이름 : 홍길동
     * 중간고사 점수(40%) : 100
     * 기말고사 점수(50%) : 80
     * 과제 점수(10%) : 50
     *
     * 홍길동의 최종 점수 : 85.0점
     * 성적 : B+
     *</pre>
     */

// Solution1
    public void scoreTest(){
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.println(name);

        System.out.print("중간고사 점수(40%) : ");
        int midTerm = sc.nextInt();
        System.out.println(midTerm);

        System.out.print("중간고사 점수(50%) : ");
        int finalTerm = sc.nextInt();
        System.out.println(midTerm);

        System.out.print("과제 점수(10%) : ");
        int homework = sc.nextInt();
        System.out.println(midTerm);

        double result = (midTerm * 0.4) + (finalTerm * 0.5) + (homework * 0.1);

        System.out.printf("%s의 최종 점수 : %.1f", name, result);
        System.out.println();
        System.out.print("성적 : ");

        if(result >= 95 && result <= 100) {
            System.out.println("A+");
        } else if(result >= 90) {
            System.out.println("A");
        } else if (result >= 85) {
            System.out.println("B+");
        } else if (result >= 80) {
            System.out.println("B");
        } else if (result >= 75) {
            System.out.println("C+");
        } else if (result >= 70) {
            System.out.println("C");
        } else if (result >= 65) {
            System.out.println("D+");
        } else if (result >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }

    // solution2
    public void scoreTest2(){
        System.out.print("이름 : ");
        String name = sc.next(); // 입력 버퍼에서 다음 문자열(단어) 얻어오기

        System.out.print("중간고사 점수(40%) : ");
        int midTerm = sc.nextInt();

        System.out.print("기말고사 점수(50%) : ");
        int finalTerm = sc.nextInt();

        System.out.print("과제 점수(10%) : ");
        int report = sc.nextInt();

        // 점수 합계
        double sum = (midTerm * 0.4) + (finalTerm * 0.5) + (report * 0.1);

        String result; // 성적 저장용 변수

        switch((int)sum/10){ // 값 처리 원칙
            case 9,10 : result = "A"; break;
            case 8 : result = "B"; break;
            case 7 : result = "C"; break;
            case 6 : result = "D"; break;
            default : result = "F";
        }

        // [일의 자리]
        if(sum == 100 || (sum >= 60.0 && sum%10 >=5)){
            result += "+";
        }

        System.out.printf("\n%s의 최종점수 : %.1f점\n", name, sum);
        System.out.println("성적 : " + result);
    }

}

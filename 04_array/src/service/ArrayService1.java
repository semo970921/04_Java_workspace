package service;

import java.util.Scanner;

public class ArrayService1 {
    public void method1(){
        int[] arr;
        arr = new int[4];

        // JVM이 기본값으로 초기화 했는지 확인
        System.out.println("arr[0] : " + arr[0]);
        System.out.println("arr[1] : " + arr[1]);
        System.out.println("arr[2] : " + arr[2]);
        System.out.println("arr[3] : " + arr[3]);

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        System.out.println("arr[0] : " + arr[0]);
        System.out.println("arr[1] : " + arr[1]);
        System.out.println("arr[2] : " + arr[2]);
        System.out.println("arr[3] : " + arr[3]);

        for(int i=0; i<arr.length; i++){
            arr[i] = (i+1)*100;
        }
        System.out.println("arr[0] : " + arr[0]);
        System.out.println("arr[1] : " + arr[1]);
        System.out.println("arr[2] : " + arr[2]);
        System.out.println("arr[3] : " + arr[3]);
    }

    /**
     * 선언과 동시에 할당 + 초기화
     */
    public void method2(){
        int[] arr = {10,20,30};

        for(int num : arr){
            System.out.println(num);
        }
    }

    /**
     * 오늘의 점심 메뉴 뽑기
     */
    public void method3(){
        String[] menus = {"순대국", "닭갈비", "마라탕", "햄버거",
                                    "짜장면", "짬뽕", "샐러드", "국수"};

        int randomNumber = (int)(Math.random() * menus.length);

        System.out.println("오늘의 점심 메뉴눈!!! : " + menus[randomNumber]);
    }

    /**
     * Java 배열 사용 시 주의할 점
     */
    public void method4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[입력 받은 정수를 각 배열 요소에 저장 및 출력]");

        long[] arr = new long[3];

        for(int i=0; i<arr.length; i++){
            System.out.printf("arr[%d] 값 입력 : ", i);
            arr[i] = sc.nextLong();
        }

        for(long num : arr){
            System.out.println(num);
        }

        // ------------------주의-------------------------
        System.out.print("arr[3]에 대입할 값 : ");
        long input = sc.nextLong();
        arr[3] = input;

        System.out.println("확인 : " + arr[3]);
        //  JS와 다르다!!!(노션)

    }

    /**
     * 인원 수를 입력 받아 그 크기를 가지는
     * 정수 배열을 선언, 할당 하고
     * 각 배열 요소에 점수를 입력 받아 저장
     *
     * 입력이 완료되면 합계, 평균, 최대값, 최소값 출력
     */
    public void method5(){
        Scanner sc = new Scanner(System.in);

        System.out.print("입력 받을 인원 수 : ");
        int size = sc.nextInt();

        int[] scoreArr = new int[size];

        int sum = 0;
        for(int i=0; i<scoreArr.length; i++){
            System.out.printf("%d번째 인덱스 점수 입력 : ", i);
            scoreArr[i] = sc.nextInt();
            sum += scoreArr[i];
        }
        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + (double)sum/size); // 값 처리 원칙때문

        int maxIndex = 0;
        int minIndex = 0;
        for(int i=1; i<scoreArr.length; i++){
            if(scoreArr[i] > scoreArr[maxIndex]){
                maxIndex = i;
            }
            if(scoreArr[i] < scoreArr[minIndex]){
                minIndex = i;
            }
        }
        System.out.println("최대값 : " + scoreArr[maxIndex]);
        System.out.println("최소값 : " + scoreArr[minIndex]);


    }




}

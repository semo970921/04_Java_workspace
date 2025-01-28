package service;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService2 {
    public void method1(){
        int[] arr1 = {10, 20, 30, 40, 50};

        int[] copyArr1 = arr1;

        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("copyArr1 : " + Arrays.toString(copyArr1));

        copyArr1[0] = 999;
        System.out.println("[변경 후]");
        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("copyArr1 : " + Arrays.toString(copyArr1));

        System.out.println(arr1.hashCode());
        System.out.println(copyArr1.hashCode());

        System.out.println("=============================");

        int[] arr2 = {5, 6, 7, 8};

        int[] copyArr2 = new int[arr2.length];

        for(int i=0; i<arr2.length; i++){
            copyArr2[i] = arr2[i];
        }

        System.out.println("[변경 전]");
        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("copyArr2 : " + Arrays.toString(copyArr2));

        copyArr2[0] = 1234;

        System.out.println("[변경 후]");
        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("copyArr2 : " + Arrays.toString(copyArr2));

        System.out.println(arr2.hashCode());
        System.out.println(copyArr2.hashCode());

        int[] copyArr3 = new int[arr2.length];

        System.arraycopy(arr2, 0, copyArr3, 0, arr2.length);

        System.out.println("---------------------------");

        System.out.println("[변경 전]");
        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("copyArr3 : " + Arrays.toString(copyArr3));

        copyArr3[0] = 2222;
        System.out.println("[변경 후]");
        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("copyArr3 : " + Arrays.toString(copyArr3));

    }

    /**
     * 2차원 배열 선언, 할당, 초기화
     */
    public void method2(){
        int[][] arr = new int[2][3];

        arr[0][0] = 7;
        arr[0][1] = 14;
        arr[0][2] = 21;

        arr[1][0] = 28;
        arr[1][1] = 35;
        arr[1][2] = 42;

        // 단지 인덱스로 출력하면?
        System.out.println("arr[0] : " + arr[0]);
        System.out.println("arr[1] : " + arr[1]);
        System.out.println("--------------------");

        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 2차원 배열 선언 및 초기화
     */
    public void method3() {

        Scanner sc = new Scanner(System.in);

        // 1차원 배열 선언 및 초기화
        int[] arr1 = {30, 40, 50, 60};
        int[] arr2 = {15, 25, 35, 45};

        // 2차원 배열 선언 및 초기화
        int[][] arr = {
                arr1, // 30, 40, 50, 60
                arr2, // 15, 25, 35, 45
                { 99,88,77,66}
        };
        System.out.print("검색할 숫자 입력 : ");
        int input = sc.nextInt();

        // JS에서는 includes
        for(int row=0; row<arr.length; row++) {
            for(int col=0; col<arr[row].length; col++) {

                if(arr[row][col] == input) { //입력 받은 값을 찾은 경우
                    System.out.printf("%d행 %d열에 있습니다\n", row, col);
                    return; // 메서드 종료
                }
            }
        }
        System.out.println("존재하지 않습니다.");
    }



}

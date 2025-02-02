package view;

import dto.StudentDTO;
import service.StudentService;

import java.util.Scanner;

public class StudentView {
    private Scanner sc = new Scanner(System.in);


    private StudentService service = new StudentService();

    /**
     * 학생 관리 프로그램의 메인 메뉴 출력용 메서드
     */
    public void mainMenu() {

        int input = 0; //메뉴 번호를 저장할 변수

        do {
            System.out.println("\n----- 학생 관리 프로그램 -----");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 전체 조회");
            System.out.println("3. 학생 1명 정보 조회(인덱스)");
            System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
            System.out.println("5. 학생 정보 수정(인덱스)");
            System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
            System.out.println("7. 평균 최고점, 최저점 학생");
            System.out.println("0. 종료");

            System.out.print("메뉴 선택 >> ");


            input = sc.nextInt();
            sc.nextLine(); // 입력 버퍼에 남은 내용 모두 제거

            System.out.println(); // 줄바꿈

            switch(input) {
                case 1: break;
                case 2: allStudent(); break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 0: System.out.println("***프로그램 종료***"); break;
                default: System.out.println("***잘못된 메뉴 번호 입력***");
            }

        } while(input != 0);
    }

    /**
     * 학생 전체 조회
     */
    private void allStudent() {
        System.out.println("\n----학생 전체 조회----\n");

        StudentDTO[] students = service.getStudents(); // 값 처리 원칙

        for(StudentDTO std : students) {

            if(std == null) {
                continue;}

            System.out.println(std); // std.toString()

        }
    }

}

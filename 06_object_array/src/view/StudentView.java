package view;

import dto.StudentDTO;
import service.StudentService;

import java.util.Scanner;

public class StudentView {

    // 필드(Field)  == 멤버변수

    // 캡슐화 원칙
    // 입력용 객체 생성
    private Scanner sc = new Scanner(System.in);

    // 기능 제공용 객체 생성
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
            System.out.println("6. 학생 1명 점수 조회(인덱스/점수, 합계, 평균)");
            System.out.println("7. 평균 최고점, 최저점 학생");
            System.out.println("8. 학생 삭제(인덱스)");
            System.out.println("0. 종료");

            System.out.print("메뉴 선택 >> ");


            input = sc.nextInt();
            sc.nextLine(); // 입력 버퍼에 남은 내용 모두 제거

            System.out.println(); // 줄바꿈

            switch(input) {
                case 1: addStudent(); break;
                case 2: allStudent(); break;
                case 3: selectIndex(); break;
               // case 4: selectName(); break;
               // case 5: updateIndex(); break;
               // case 6: selectScore(); break;
               // case 7: selectMaxMin(); break;
               // case 8 : deleteStudent(); break;
                case 0: System.out.println("***프로그램 종료***"); break;
                default: System.out.println("***잘못된 메뉴 번호 입력***");
            }

        } while(input != 0);
    }

    /**
     * 1. 학생 추가
     * <pre>
     * 학번, 이름, 성별을 입력 받아
     * StudentDTO 객체로 만들어서
     * StudentService.addStudent() 메서드에 전달
     * -> 추가 성공 시 true,
     *    실패 시 false 반환 받아
     *    결과 출력
     * </pre>
     */
    private void addStudent(){
        System.out.println("\n#####학생 추가#####\n");

        System.out.print("학번 : ");
        String studentNumber = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("성별 : ");
        char gender  = sc.next().charAt(0);

        // 서비스 호출
        StudentDTO student = new StudentDTO(studentNumber, name, gender);
        boolean result = service.addStudent(student);
        if(result){
            System.out.println(name + " 학생이 추가되었습니다.\n");
        }else{
            System.out.println("더 이상 학생을 추가할 수 없습니다.\n");
        }
    }

    /**
     * 2. 학생 전체 조회
     */
    public void allStudent(){
        System.out.println("\n#####학생 전체 조회#####\n");

        StudentDTO[] students = service.getStudents();

        for(StudentDTO std : students){
            if(std == null){
                continue;
            }
        System.out.println(std);
//            String result = "@@@@@@\n" + std;
//            System.out.println(result);
        }
    }

    /**
     * 3. 학생 1명 조회(인덱스) view 메서드
     * <pre>
     * - 인덱스를 입력 받아
     *   StudentService.selectIndex()로 전달
     *
     * - 학생 객체 배열에서 해당 index 번째 학생을 반환 받기
     *
     * - 반환 받은 학생 정보를 출력
     *   단, 반환 받은 학생이 없을 경우(null)
     *   "해당 인덱스에 학생이 존재하지 않습니다" 출력
     * </pre>
     */
    public void selectIndex(){
        System.out.println("\n#####학생 1명 정보 조회(index)#####\n");

        System.out.print("조회할 인덱스 입력 : ");
        int index = sc.nextInt();

        StudentDTO student = service.selectIndex(index);
        if(student == null){
            System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
        } else{
            System.out.println(index + " 번째 학생 정보");
            System.out.println(student/*.toString()*/);
        }
    }













}

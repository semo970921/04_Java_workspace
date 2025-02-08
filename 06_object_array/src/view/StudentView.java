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
                case 4: selectName(); break;
                case 5: updateIndex(); break;
                case 6: selectScore(); break;
                case 7: selectMaxMin(); break;
                case 8 : deleteStudent(); break;
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
            System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
        } else{
            System.out.println(index + " 번째 학생 정보");
            System.out.println(student/*.toString()*/);
        }
    }

    /**
     * 4. 학생 이름으로 조회(동명이인X)
     * <pre>
     *     - 이름을 입력 받아
     *          반환형            클래스명.메서드명(매개변수)
     *      StudentDTO StuendntService.selectName(String name)
     *
     *     - 학생 정보 반환을 받아서 출력
     *     단, 반환 받은 학생이 없을 경우(null)
     *     "000 학생은 존재하지 않습니다" 출력
     * </pre>
     */
    public void selectName(){
        System.out.println("\n#####학생 이름으로 조회(동명이인X)#####\n");

        System.out.print("검색할 학생 이름 : ");
        String targetName = sc.next();

        StudentDTO student = service.selectName(targetName);

        if(student == null){
            System.out.println(targetName + " 학생은 존재하지 않습니다");
        } else {
            System.out.println(student.toString());
        }
    }

    /**
     * 5. 학생 정보 수정(인덱스)
     * <pre>
     *     - 인덱스 번호를 입력 받아 해당 인덱스에  학생이 있는지 확인(유효성 검사)
     *      1) index 범위 초과 : "인덱스 범위가 올바르지 않습니다."
     *      2) 참조하는 학생이 없을 경우 : "해당 인덱스에 학생이 존재하지 않습니다."
     *
     *     - 입력 받은 인덱스에 학생이 있는 경우
     *     HTML, CSS, JS, JAVA 점수를 순서대로 입력 받은 후
     *     void StudentService.updateScore(index, 점수들,,) 호출
     * </pre>
     */
    private void updateIndex(){
        System.out.println("\n#####학생 정보 수정(인덱스)#####\n");

        System.out.print("수정할 학생 인덱스 번호 입력 : ");
        int index = sc.nextInt();

        int check = service.checkIndex(index);

        if(check == 1){
            System.out.println("인덱스 범위가 올바르지 않습니다.");
            return;
        }

        if(check == 2){
            System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
            return;
        }

        System.out.print("HTML, CSS, JS, JAVA 순서로 점수 입력 : ");

        int html = sc.nextInt();
        int css = sc.nextInt();
        int js = sc.nextInt();
        int java = sc.nextInt();

        service.updateScore(index, html, css, js, java);

        System.out.println("***점수 수정 완료***");
    }

    /**
     * 6. 학생 1명 점수 조회(인덱스/점수, 합계 평균)
     *
     * <pre>
     *     - 인덱스 번호를 입력 받아 해당 인덱스에 학생이 있는지 검사(유효성 검사)
     *     1) index 범위 초과 : "인덱스 범위가 올바르지 않습니다."
     *     2) 참조하는 학생이 없을 경우 : " 해당 인덱스에 학생이 존재하지 않습니다."
     *
     *    - 인덱스가 정상 입력 되었다면
     *    해당 인덱스 번째 학생(studentDTO)을 반환 받기
     *
     * - 합계, 평균 구하기
     *
     * - 아래와 같은 형식으로 출력하기
     * ---------------------------
     * [20250001] 짱구(남)
       HTML : 10 / CSS : 20 : / JS :30 / Java : 40
       합계 : 100
       평균 : 25.0
     ----------------------------
     * </pre>
     */
    private void selectScore(){
        System.out.println("\n#####학생 1명 점수 조회(인덱스/점수, 합계, 평균)#####\n");

        System.out.print("점수를 조회할 학생 인덱스 번호 입력 : ");
        int index = sc.nextInt();

        int check = service.checkIndex(index);

        if(check == 1){
            System.out.println("인덱스 범위가 올바르지 않습니다.");
            return;
        }

        if(check == 2){
            System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
            return;
        } // 유효성 검사 끝

        StudentDTO std = service.selectIndex(index);

        int sum = std.getHtml() + std.getCss() + std.getJs() + std.getJava();
        double avg = sum / 4.0;

        System.out.println("--------------------------");
        System.out.println(std);
        System.out.println("합계 : " + sum);
        System.out.printf("평균 : %.1f\n", avg);
        System.out.println("--------------------------");
    }

    /**
     * 7. 평군 최고점, 최저점 학생
     * <pre>
     *     String StudentService.selectMaxMin() 메서드를 호출하여
     *     아래와 같은 문자열을 반환 받아 출력하기
     *
     * -------------------------
     * 최고점 : 유리(85.6)
     * 최저점 : 짱구(31.6)
     * --------------------------
     * </pre>
     */
    public void selectMaxMin(){
        System.out.println("\n#####평군 최고점, 최저점 학생#####\n");

        String result = service.selectMaxMin();

        System.out.println("-------------");
        System.out.println(result);
        System.out.println("-------------");
    }


    /**
     * 8. 학생 삭제(index 이용)
     * - index 입력 받아 검사(범위 초과, null 검사)
     *
     * - 정말 삭제 할 것인지 확인 절차 추가
     *   -> "정말로 삭제 하겠습니까? (Y/N) : Y"
     *
     *  - 'N' 입력 시 "취소 되었습니다." 출력
     *
     *  - 'Y' 입력 시
     */
    public void deleteStudent(){
        System.out.println("#####학생 삭제(index)#####\n");

        // 인덱스를 입력 받아 검사
        System.out.print("삭제할 학생 인덱스 번호 입력 : ");
        int index = sc.nextInt();

        // 인덱스 범위, 학생 참조 여부 확인 메서드 호출
        int check = service.checkIndex(index);

        if(check == 1) {
            System.out.println("인덱스 범위가 올바르지 않습니다");
            return;
        }

        if(check == 2) {
            System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
            return;
        } // 유효성 검사 끝

        // ==================================================

        // Y/N 입력
        System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");

//        char confirm = sc.next().charAt(0);
//        if(confirm == 'N') {}

        String confirm = sc.next();
        if(confirm.equals("N")){
            System.out.println("취소 되었습니다.");
            return;
        }

        // 'Y'인 경우
        // 삭제 서비스 호출
        String studentName = service.deleteStudent(index);
        System.out.println(studentName + " 학생이 삭제 되었습니다.");
    }
}

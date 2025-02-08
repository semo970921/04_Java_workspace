package service;

import dto.StudentDTO;

import java.util.Random;

public class StudentService {

    private StudentDTO[] students = new StudentDTO[5];

    // 기본 생성자
    public StudentService(){
        System.out.println("[초기 학생 정보가 추가됨]\n");

        students[0] = new StudentDTO("20250001", "짱구", '남');
        students[1] = new StudentDTO("20250002", "유리", '여');
        students[2] = new StudentDTO("20250003", "훈이", '남');

        // 자바 제공 난수 객체
        Random random = new Random();

        for(StudentDTO std : students){
            if(std == null){
                continue;
            }

            // random.nextInt(101) : 0 이상 101 미만의 정수형 난수
            std.setHtml(random.nextInt(101));
            std.setCss(random.nextInt(101));
            std.setJs(random.nextInt(101));
            std.setJava(random.nextInt(101));
        }
    }

    /**
     * students 객체 배열을 반환하는 메서드
     * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
     * @return students
     */
    public StudentDTO[] getStudents() {
        return students;
    }

    /**
     * 1. 학생 추가
     * <pre>
     *   students 객체 배열 요소 중
     *   비어있는 인덱스(null)를 찾아서
     *   전달 받은 StudentDTO 객체를 추가 후  true를 반환
     *   단, 비어있는 인덱스가 없으면 false를 반환
     * </pre>
     * @param student : 추가하려는 학생 객체의 참조 주소
     * @return 추가 성공 : true / 추가 실패 : false
     */
    public boolean addStudent(StudentDTO student){

        for(int i=0; i<students.length; i++){
            if(students[i] == null){
                students[i] = student;
                return true;
            }
        }
        return false;
    }

    /**
     * 3. index번째 학생 반환  service
     * @param index
     * @return index 번째 학생 객체 참조 주소 || null
     */
    public StudentDTO selectIndex(int index){
        if(index<0 || index>=students.length){
            return null;
        }
        return students[index];
    }

    /**
     * 4. targetName과 이름이 일치하는 학생 객체 를 반환하는 service method
     * @param targetName   // 입력받은 이름
     * @return 이름이 일치하는 학생 객체 주소 || null
     */
    public StudentDTO selectName(String targetName){
        for(StudentDTO std : students){

            if(std == null){
                return null;
            }

            if(std.getName().equals(targetName)){
                return std;
            }
        }
        return null;
    }

    /**
     * 5. 인덱스 유효성 검사
     * 전달 받은 index가 students 범위 내 index가 맞는지
     *   + 맞다면 index 번째에 참조하는 학생이 있는지 확인하는 메서드
     */
    public int checkIndex(int index){

        if(index<0 || index>=students.length){
            return 1;
        }

        if(students[index] == null){
            return 2;
        }

        return 3;
    }

    /**
     * 5. index 번째 학생의 점수 수정 service 메서드
     * @param index
     * @param html
     * @param css
     * @param js
     * @param java
     */
    public void updateScore(int index, int html, int css,
                            int js, int java){
        students[index].setHtml(html);
        students[index].setCss(css);
        students[index].setJs(js);
        students[index].setJava(java);
    }

    /**
     * syudent 배열에서 점수 평균의 최고, 최저  학생 찾기
     *
     * @return
     */
    public String selectMaxMin(){

        // 점수 평균의 최고점, 최저점 학생의 이름/평균 저장할 변수 선언
        String maxName = null;
        double maxAvg = 0.0;

        String minName = null;
        double minAvg = 100.0;

        for(StudentDTO std : students){
            if(std == null){
                break;
            }

            int sum
                    = std.getHtml() + std.getCss() + std.getJs() + std.getJava();
            double avg
                    = sum / 4.0;

            if(avg > maxAvg){
                maxAvg = avg;
                maxName = std.getName();
            }

            if(avg < minAvg){
                minAvg = avg;
                minName = std.getName();
            }
        }

        String result
            = String.format(
                    "최고점 : %s(%.1f)\n"
                    + "최저점 : %s(%.1f)",
                    maxName,maxAvg,
                    minName, minAvg);

        return result;
    }

    /**
     * 8. 학생 삭제(index)
     * index 번째 학생 삭제  후 요소 한 칸 씩 당기기
     * @param index : 삭제할 index 번호
     * @return 삭제된 학생 이름
     */
    public String deleteStudent(int index){

        String studentName = students[index].getName();

        students[index] = null;

        for(int i=index; i<students.length-1; i++){
            students[i] = students[i+1];
        }

        students[students.length-1] = null;

        return studentName;
    }






}




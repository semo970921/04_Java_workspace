package service;

import dto.StudentDTO;

import java.util.Random;

public class StudentService {

    private StudentDTO[] students = new StudentDTO[5];

    public StudentService(){
        System.out.println("[초기 학생 정보 추가됨...]\n");

        students[0] = new StudentDTO("20250001", "짱구", '남');
        students[1] = new StudentDTO("20250002", "유리", '여');
        students[2] = new StudentDTO("20250003", "훈이", '남');

        // 자바 제공 난수 발생 객체
        Random random = new Random();

        for(StudentDTO std : students){
            if(std == null){
                continue;
            }

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

}

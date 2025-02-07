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
     * index번째 학생 반환  service
     * @param index
     * @return index 번째 학생 객체 참조 주소 || null
     */
    public StudentDTO selectIndex(int index){
        if(index<0 || index>=students.length){
            return null;
        }
        return students[index];
    }



























}




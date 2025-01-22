package common;

public class PrintEx {
    public static void main(String[] args) {
        // print() 확인
        System.out.print("이름 : "); // 줄바꿈(개행)X
        System.out.print("홍길동"); // 줄바꿈(개행)X
        System.out.print(", 나이 : 20세"); // 줄바꿈(개행)X

        // println() 확인
        System.out.println(); // 출력 내용 없이 줄만 바꿈
        System.out.println(); // 출력 내용 없이 줄만 바꿈

        // printf() 확인
        System.out.println("[printf() 확인하기]");

        String name = "신짱구"; // 참조형(값 저장X, 값의 위치(주소) 저장)
        int age = 5; // 정수형 기본형, 4byte
        double height = 80.5;// 실수 기본형, 4byte
        char gender = '남'; // 문자형, 2byte
        boolean javaStudy = false; // 논리형, 1byte

        // 신짱구는 5세 남아로 키는 80.5cm 이며, 자바 공부 여부:false
        System.out.println(name +"는 " + age +"세 "
                + gender +"아로 " + "키는 " + height + "cm 이며, 자바 공부 여부:" + javaStudy );

        // printf() 버전
        System.out.printf("%s는 %d세 %c아로 키는 %.1fcm 이며, 자바 공부 여부:%b", name,age,gender,height,javaStudy);

        // 왼쪽 정렬
        System.out.println(); // 줄바꿈(개행)
        System.out.printf("%-6s/%-6d", name, age);

        // 오른쪽 정렬
        System.out.println(); // 줄바꿈(개행)
        System.out.printf("%6s/%6d", name, age);

        // (참고) 0 == 빈칸에 0추가(숫자만 가능)
        // 오른쪽 정렬
        System.out.println(); // 줄바꿈(개행)
        System.out.printf("%6s/%06d", name, age);
        // ----------------------------------------------

        System.out.println("[escape 문자]");

        System.out.print("1\t2\t3\n"); // 1	2	3
        System.out.println();
        System.out.print("\"홍길동\"의 자료형은 String\r"); // "홍길동"의 자료형은 String
        System.out.println();
        System.out.print("\\o/\n"); // \o/
    }
}

package section02;

public class Section02Run {
    public static void main(String[] args) {

        // 학생 객체 생성1 -> 기본 생성자
        Student s1 = new Student();

        // 학생 객체 생성2 -> 매개 변수 있는 생성자
        Student s2 = new Student("홍길동", 17, "종로 고등학교");
        System.out.println(s2.toString());

        System.out.println("==============");

        // 오버라이딩 테스트
        Person p3 = new Person("짱구", 5);
        System.out.println(p3/*.toString()*/);
        System.out.println(p3.introduce("데빌구"));

        System.out.println("==============");
        Student s3 = new Student("철수", 8, "떡잎초등학교");
        System.out.println(s3.toString());
        System.out.println(s3.introduce("모범생)"));
    }
}

package section02;

/**
 * Person 클래스를 상속 받은 Student 클래스
 */
public class Student extends Person {

    private String schoolName; // 학교명

    // 기본 생성자
    public Student() {
        super();
        System.out.println("[Student 기본 생성자로 생성됨]");
    }

    // 매개변수가 있는 생성자
    // -> Student가 가지고 있는
    // 모든 필드(schoolName, name, age) 초기화

    public Student(String name, int age, String schoolName) {
        // this.name = name;
        // setName(name);
        // setAge(age);
        super(name, age);
        this.schoolName = schoolName;

        System.out.println("[Student 매개 변수가 있는 생성자로 생성됨]");
    }
}

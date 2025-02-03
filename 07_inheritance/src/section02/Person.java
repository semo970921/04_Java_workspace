package section02;

public class Person {
    // 필드
    private String name;
    private int age;

    // 기본 생성자
    public Person(){
        System.out.println("[Person 기본 생성자로 생성됨]");
    }

    // 매개 변수 생성자
    public Person(String name, int age) {
        System.out.println("[Person 매개 변수있는 생성자로 생성됨]");

        this.name = name;
        this.age = age;
    }

    // getter/setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Person만의 함수
    public String toString(){
        return String.format("name: %s / age: %d", name, age);
    }
}

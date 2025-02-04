package section02;

public class Person  /*extends Object*/{
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

    @Override
    public String toString(){
        return String.format("name: %s / age: %d", name, age);
    }

    public /*final*/ String introduce(String alias){
        return String.format(
                "[Person]의 이름은 %s 이고, 별명은 %s 입니다.",
                name, alias);
    }
}

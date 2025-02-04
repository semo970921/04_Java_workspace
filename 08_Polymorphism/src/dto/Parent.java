package dto;

/**
 * 부모 역할 클래스
 * (Object 상속 받음)
 */
public class Parent extends Object {

    // 필드 == 멤버 변수
    private String lastName = "제갈";
    private int money = 10000;

    // 기본 생성자
    public Parent(){
        super();
        // 부모 생성자 호출(미작성시 컴파일러가 추가)
        // 즉, Object() 기본 생성자를 호출
        System.out.println("------------[Parent 클래스 객체 생성]-------------");
    }

    // 매개변수 생성자
    public Parent(String lastName, int money) {
        super();
        this.lastName = lastName;
        this.money = money;
        System.out.println("------------[Parent 클래스 객체 생성]-------------");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Parent [lastName=" + lastName + ", money=" + money + "]";
    }
}

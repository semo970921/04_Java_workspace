package section01.dto;

/**
 * Child 클래스
 * (Parent 상속)
 */
public class Child extends Parent{

    private String car;

    public Child() {
        super();
    }

    public Child(String lastName, int money, String car) {
        super(lastName, money);
        this.car = car;
        System.out.println("------------[Child 클래스 객체 생성]-------------");
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return super.toString() + " / Child [car=" + car + "]" ; // 클릭 => parent꺼
    }
}

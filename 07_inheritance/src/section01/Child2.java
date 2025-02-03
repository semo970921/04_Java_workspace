package section01;

public class Child2 extends Parent{

    //	private String lastName = "김"; // 성
    //	private String firstName = "바다"; // 이름
    //	private String address = "경기도 용인시"; // 집 주소
    //	private int money = 7000;

    // Child2만의 필드
    private String car;

    // Child2의 기본 생성자
    public Child2(){
        System.out.println("**** Child2 객체 생성됨 ****");

        setFirstName("바다");
        setAddress("경기도 용인시");
        setMoney(7000);
        car = "아반떼";
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}

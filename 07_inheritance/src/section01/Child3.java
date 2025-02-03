package section01;

public class Child3 extends Parent {

    //	private String lastName = "김"; // 성
    //	private String firstName = "가람"; // 이름
    //	private String address = "충북 청주시"; // 집 주소
    //	private int money = 9000;

    // Child3만의 필드
    private double bitCoin;

    // Child3 기본 생성자
    public Child3(){
        System.out.println("****  Child3 객체 생성됨 ****");

       // setFirstName("가람");
        firstName = "가람가람";

        setAddress("충북 청주시");
        setMoney(9000);
        bitCoin = 0.1;
    }

    // Child3 필드의 getter/setter

    public double getBitCoin() {
        return bitCoin;
    }

    public void setBitCoin(double bitCoin) {
        this.bitCoin = bitCoin;
    }
}

package section01;

public class Child1 extends Parent {

    // 물려 받은 필드가 존재하기 때문에 삭제!!
    //	private String lastName = "김"; // 성
    //	private String firstName = "산"; // 이름
    //	private String address = "서울시 강남구"; // 집 주소
    //	private int money = 5000;

    // Child1만의 필드
    private String laptop;

    // Child1 기본 생성자
    public Child1(){
        System.out.println("**** Child1 객체 생성됨 ****");
        setFirstName("산");
        setAddress("서울시 강남구");
        setMoney(5000);
        laptop = "맥북 m4 pro";
    }

    // Child1 필드의 getter/setter
    public String getLaptop() {
        return laptop;
    }

    public void setLaptop(String laptop) {
        this.laptop = laptop;
    }
}

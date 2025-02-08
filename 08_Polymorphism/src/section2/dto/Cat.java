package section2.dto;

public class Cat extends Animal {

    private String fur; // 털

    public Cat(){
        super();
    }

    public Cat(String type, String fur){
        super(type);
        this.fur = fur;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    // =========================================================
    // The type Cat must implement
    // the inherited abstract method Animal.move()
    // Cat 메서드가 상속받은 저 메서드를 구현해야만 한다
    @Override
    public void move() {
        System.out.println("고양이 : 4족 보행, 사뿐 사뿐 움직임");
    }

    @Override
    public void eat() {
        System.out.println("고양이 : 엎드려서 잠");
    }

    @Override
    public void sleep() {
        System.out.println("고양이 : 깨작 깨작 먹음");
    } // 여기까지 다 써야 에러가 사라짐
}

package section2.dto;

public class Snake extends Animal{

    public Snake(String type) {
        super(type);
    }

    @Override
    public void move() {
        System.out.println("뱀 : S자로 슬금슬금 기어다님");
    }

    @Override
    public void eat() {
        System.out.println("뱀 : 통으로 삼킴");
    }

    @Override
    public void sleep() {
        System.out.println("뱀 : 똬리틀고 잠");
    }
}

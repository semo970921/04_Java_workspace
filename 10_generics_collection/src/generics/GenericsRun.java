package generics;

import java.util.List;

public class GenericsRun {
    public static void main(String[] args) {

        Box<String> box1 = new Box<String>();
        box1.setValue("String만 전달 가능");
        System.out.println(box1.getValue()); // String만 전달 가능

        Box<Integer> box2 = new Box<Integer>();
        box2.setValue(12345); // int -> Integer (AutoBoxing)
        System.out.println(box2.getValue()); // 12345

        // ======================================

        System.out.println("[제네릭스를 이용한 구체적인 타입제한]");
        TestBox<Parent> t1 = new TestBox<Parent>();
        t1.setObj(new Parent());
        System.out.println(t1.getObj().getClass());

        TestBox<Child> t2 = new TestBox<Child>();
        t2.setObj(new Child());
        System.out.println(t2.getObj().getClass());

    }

    // ======================================
    // 와일드 카드
    public void test1(List <? extends Parent> list) {

    }
}

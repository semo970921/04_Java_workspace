package section2.run;

import section2.dto.Animal;
import section2.dto.Cat;

public class AbstractionRun {
    public static void main(String[] args) {

        // 확인1. 추상 클래스는 객체(instance) 생성 불가
        // Animal animal = new Animal();

        // 확인2. 추상 클래스를 상속 받은 객체 생성
        Cat cat = new Cat("포유류", "단모");
        cat.eat();
        cat.sleep();
        cat.move();
        /*고양이 : 엎드려서 잠
        고양이 : 깨작 깨작 먹음
        고양이 : 4족 보행, 사뿐 사뿐 움직임*/
        System.out.println("--------------------------------------------------");

        // 확인3. 추상 클래스를 참조형 변수로 사용
        Animal a2 = new Cat("포유류","장모");
        a2.eat(); //  section2.dto. Animal
        a2.sleep();
        a2.move();
        /*고양이 : 엎드려서 잠
        고양이 : 깨작 깨작 먹음
        고양이 : 4족 보행, 사뿐 사뿐 움직임*/
        System.out.println("--------------------------------------------------");

    }
}

package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

/**
 * 다형성 확인 + 기초
 */
public class TestRun {
    public static void main(String[] args) {

        /*Parent p1 = new Parent();
        System.out.println("p1.getLastName() : " + p1.getLastName());
        System.out.println("p1.hashCode() : " + p1.hashCode());

        System.out.println("----------------------------------------------");

        Child c1 = new Child("신", 500, "붕붕이");
        System.out.println("c1.getCar() : " + c1.getCar()); // 자기거
        System.out.println("c1.getLastName() : " + c1.getLastName()); // Parent거
        System.out.println("c1.hashCode() : " + c1.hashCode()); // Object거*/

       Parent p2 = new  Child("김", 9999, "아반떼");
       /* System.out.println("p2.getLastName() : " + p2.getLastName());
        System.out.println("p2.hashCode() : " + p2.hashCode());*/
        // System.out.println(p2.getCar()); // 오류 발생

        System.out.println( ( (Child)p2).getCar() );

        Child c2 = (Child)p2;
        System.out.println("c2.getCar() : " + c2.getCar());



    }
}

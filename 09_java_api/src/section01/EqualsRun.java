package section01;

import java.util.Random;

public class EqualsRun {
    public static void main(String[] args) {

        // Book 객체 생성
        Book book1 = new Book(1, "어린왕지", "생택쥐베리", 10000);
        Book book2 = new Book(1, "어린왕지", "생택쥐베리", 10000);
        Book book3 = book1;

        /*오버라이딩 전
        System.out.println("book1 == book1 : " + (book1 == book1)); // true
        System.out.println("book1 == book2 : " + (book1 == book2)); // false

        // boolean java.lang.Object.equals
        System.out.println("book1.equals(book2) : " + (book1.equals(book2))); // false */

        // 오버라이딩 후
        System.out.println("book1.equals(book2) : " + book1.equals(book2));

        // 1
        Book book4 = book1;
        System.out.println("book1.equals(book4) : " + book1.equals(book4));

        // 2
        Book book5 = null;
        System.out.println("book1.equals(book5) : " + book1.equals(book5));

        // 3
        Random random = new Random();
        System.out.println("book1.equals(random) : " + book1.equals(random));
    }
}

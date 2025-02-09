package section01;

public class HashCodeRun {
    public static void main(String[] args) {

        Book book1 = new Book(2, "해리포터","J.K.롤링",8000);
        Book book2 = new Book(2, "해리포터","J.K.롤링",8000);

        // 오버라이딩 전 -> book1 : 664740647 / book2 : 321001045
        // 오버라이딩 후 -> book1 : 2049242871 / book2 : 2049242871
        System.out.println("book1.hashCode() : " + book1.hashCode());
        System.out.println("book2.hashCode() : " + book2.hashCode());

    }
}

package section02;

public class ThrowsRun {
    public static void main(String[] args) {

        ThrowsTest tt = new ThrowsTest();

        try{

            tt.test2();

        } catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }

        finally{
            System.out.println("마지막에 무조건 수행");
        }



    }
}

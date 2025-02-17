package section04.service;

import section04.exception.MyTestException;
import section04.exception.NegativeQuantityException;

import java.util.Scanner;

public class UserDefineExceptionService {

    Scanner sc = new Scanner(System.in);

    public void test1() {
        System.out.println("-- 두 정수를 입력 받아 곱한 값 출력--");

        System.out.print("정수1 : ");
        int num1 = sc.nextInt();
        System.out.print("정수2 : ");
        int num2 = sc.nextInt();

        /*곱했을 때 결과가 음수이면 예외 발생*/
        try{
            int result = num1 * num2;

            if(result<0){
                throw new NegativeQuantityException("음수를 곱해서 결과가 -가 나옴");
            }
            System.out.println("결과 : " + result);
        }

        catch(NegativeQuantityException e){
            System.out.println(e.getMessage());

            e.printStackTrace();
        }

        finally{
            System.out.println("***프로그램 종료***");
        }
    }

    public void test2() {

        throw new MyTestException();

    }

}

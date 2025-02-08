package section1.service;

import section1.dto.Child;
import section1.dto.Parent;

public class PolymorphismService {

    public void printObject(Object obj){

        String result = null;

        // 범위가 큰 것부터 검사 했을 때의 문제점
        /*if(obj instanceof Parent) {
			// obj가 참조하는 객체의 타입이
			// Parent 또는 Parent를 상속 받는 자식 타입 => true

			// Parent와 관련된 정보들(성, 돈)
		}
		if(obj instanceof Child) {
			// obj가 참조하는 객체의 타입이
			// Child 또는 Child를 상속 받는 자식 타입 => true

			// Child와 관련된 정보들(성, 돈, 차)
		}*/

        if(obj instanceof Child){
            Child c = (Child)obj;

            result = "[Child Type]\n";
            result += c.getLastName() + " / "
                    + c.getMoney() + " / "
                    + c.getCar() + " / ";
        }

        else if(obj instanceof Parent){
            Parent p = (Parent)obj;

            result = "[Parent Type]\n";
            result += p.getLastName() + " / "
                    + p.getMoney();
        }

        else{
            result = "[Object Type] 필드 없음";
        }

        System.out.println("---------------------------------");
        System.out.println(result);
        System.out.println("---------------------------------");
    }


    /**
     * 매개 변수의 다형성 확인
     */
    public void test1(){
        Object obj = new Object();
        Parent parent = new Parent("김", 500);
        Child child = new Child("이", 6000, "소나타");

        printObject(obj);
        printObject(parent);
        printObject(child);
    }


    public Object getInstance(int num){
        if(num == 1) return new Child();

        if(num == 2) return new Parent();

        return new Object();
    }

    public void test2(){

       // Child c1 = getInstance(1);
        Object o1 = getInstance(1);
        Object o2 = getInstance(2);
        Object o3 = getInstance(3);

        printObject(o1);
        printObject(o2);
        printObject(o3);
    }

    /**
     * 바인딩 확인
     */
    public void test3(){

        Parent p1 = new Parent("김", 10);
        Child c1 = new Child("최", 20, "캐스퍼");

        Parent p2 = new Child("박", 30, "포터");

        System.out.println("p1.toString() : " + p1);
        System.out.println("c1.toString() : " + c1.toString());
        System.out.println("p2.toStsring() : " + p2.toString());

        /*p1.toString() : Parent [lastName=김, money=10]
        c1.toString() : Parent [lastName=최, money=20] / Child [car=캐스퍼]
        p2.toStsring() : Parent [lastName=박, money=30] / Child [car=포터]*/
    }

    /**
     * 객체 배열의 다형성
     */
    public void test4(){

        // Object 객체 참조 변수 5칸 짜리 배열을 생성해서
        // Object[] 참조 변수 arr에 배열 주소 대입
        Object[] arr = new Object[5];

        for(int i=0; i<arr.length; i++){
            arr[i]= getInstance(i%3 + 1);
            // i            : 0  1  2  3  4
            // i%3 + 1 : 1  2  3  1  2

            // 0번, 3번 : Child
            // 1번, 4번 : Parent
            // 2번         : Object

            // debug 모드 찍어보기
        }

        for(Object obj : arr){
            System.out.println(obj.toString());
        }

        /*Parent [lastName=제갈, money=10000] / Child [car=null]
        Parent [lastName=제갈, money=10000]
        java.lang.Object@6f539caf
        Parent [lastName=제갈, money=10000] / Child [car=null]
        Parent [lastName=제갈, money=10000]*/

        System.out.println("-------------------------------");
        System.out.println("[동적 바인딩이 없었더라면...]");

        for(Object obj : arr){
            // 참조 객체 타입 검사 후 다운 캐스팅
            if(obj instanceof Child) {
                System.out.println(((Child)obj).toString());
            }
            else if(obj instanceof Parent) {
                System.out.println(((Parent)obj).toString());
            }
            else {
                System.out.println(obj.toString());
            }
        }
    }


    public void test5(){

        Parent p = new Child("김", 200, "소나타");

        test6(p);
    }

    public void test6(Object obj){
        if(obj instanceof String){
            String p= (String)obj;
            System.out.println(obj);
        } else{
            System.out.println(obj.getClass());
            System.out.println(obj.getClass().getName());
        }
    }









}

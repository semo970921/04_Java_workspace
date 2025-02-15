package list;

import generics.Child;
import generics.Parent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListService {

    public void test1() {
        ArrayList list = new ArrayList();

        list.add(new Object());
        list.add("hello world");
        list.add(12345);
        list.get(0); // Object 타입 반환
        Object obj = list.get(1);
        System.out.println(obj);
        if (obj instanceof String) { // 타입 검증
            System.out.println(((String) obj).length()); // 다운 캐스팅
        }

        /*
         * ***불편하게 타입 검증, 다운 캐스팅을 하는 이유***
         * - 여러 타입을 저장할 수 있다는 컬렉션의 특징이
         *   오히려 독이 됨
         *  -> 제네릭스를 이용해 타입을 제한!
         *    -> 한 타입만 있을 테니까 검증, 다운캐스팅 X
         */

    }

    /**
     * 제네릭스를 이용하여 타입 제한
     */
    public void test2() {

        ArrayList<String> menuList = new ArrayList<String>();

        menuList.add("김치찌개");
        menuList.add("족발");
        menuList.add("보쌈");
        menuList.add("치킨");
        menuList.add("피자");
        menuList.add("마라탕");
        menuList.add("떡볶이");

        for (int i = 0; i < menuList.size(); i++) {
            String menu = menuList.get(i);
            System.out.println(menu);
        }

        System.out.println("----------------------------");

        // 향상된 for문 가능
        for (String menu : menuList) {
            System.out.println(menu);
        }

        System.out.println("------------------------------");

        menuList.add(1, "갈비탕");

        System.out.println(menuList.toString());

        String before = menuList.set(2, "불족발");
        System.out.println("------------------------------");
        System.out.println(before + "이/가 수정 되었습니다");
        System.out.println(menuList);

        System.out.println("보쌈 : " + menuList.contains("보쌈"));
        System.out.println("막국수 : " + menuList.contains("막국수"));

        System.out.println("치킨 인덱스 : " + menuList.indexOf("치킨"));
        System.out.println("햄버거 인덱스 : " + menuList.indexOf("햄버거"));


        System.out.println("------------------------------");
        System.out.println(menuList.remove(1) + "제거");
        System.out.println(menuList);

    }


    // 중간 삽입 시 성능 분석
    public void test3() {
        List<Integer> list = new LinkedList<Integer>();

        Random random = new Random();

        long start = System.currentTimeMillis();

        // int 범위 내에 난수 두개를 발생시켜 넣겠다
        list.add(random.nextInt(Integer.MAX_VALUE));
        list.add(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < 1_000_00; i++) { // 10만 바퀴
            // 1번 인덱스에 난수 삽입(중간 삽인)
            list.add(1, random.nextInt(Integer.MAX_VALUE));
        }
        long end = System.currentTimeMillis();

        System.out.println("걸린 시간 : " + (end - start) + "ms");
    }


    public void test4() {

        List<Parent> list1 = new ArrayList<Parent>();
        list1.add(new Parent());
        List<Child> list2 = new ArrayList<Child>();
        list2.add(new Child(1));
        list2.add(new Child(2));
        list2.add(new Child(3));

        List<Parent> list3 = new ArrayList<Parent>();

        list3.addAll(list1);
        list3.addAll(list2);

        for (Parent p : list3) {
            System.out.println(p);
        }
    }
}

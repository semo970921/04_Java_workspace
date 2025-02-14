package set.service;

import set.dto.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetService {

    public void test1(){

        Set<String> set = new HashSet<String>();

        set.add("네이버");
        set.add("카카오");
        set.add("라인");
        set.add("쿠팡");
        set.add("배달의민족");
        set.add("토스");
        set.add("당근마켓");
        set.add("직방");
        set.add("야놀자");
        System.out.println(set/*.toString()*/);

        set.add("배달의민족");
        set.add("배달의민족");
        System.out.println(set);

        set.add(null);
        set.add(null);
        set.add(null);
        System.out.println("null 중복X : " + set);

        System.out.println("set.size() : " + set.size());

        System.out.println("쿠팡 제거됨? : " + set.remove("쿠팡"));
        System.out.println("삼성 제거됨? : " + set.remove("삼성"));
        System.out.println(set);

        System.out.println("네이버 있음? : " + set.contains("네이버"));
        System.out.println("LG 있음? : " + set.contains("LG"));

        System.out.println("clear() 전 isEmpty() : " + set.isEmpty());
        set.clear();
        System.out.println("clear() 후 isEmpty() : " + set.isEmpty());

        System.out.println("set : " + set);
    }

    /**
     * Hash~ 컬렉션은 무조건  오버라이딩!
     */
    public void test2(){
        Person p1 = new Person("짱구", 5, '남');
        Person p2 = new Person("유리", 5, '여');
        Person p3 = new Person("철수", 5, '남');
        Person p4 = new Person("철수", 5, '남'); // 중복 필드 객체 생성

       //  Set<Person> personSet = new HashSet<Person>();
        Set<Person> personSet = new LinkedHashSet<Person>();

        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        personSet.add(p4);

        for(Person p :personSet ){
            System.out.println(p/*.toString()*/);
        }

    }

    /**
     * 반복 접근자
     */
    public void test3(){

        Set<String> snacks = new HashSet<String>();

        snacks.add("꼬북칩");
        snacks.add("포카칩");
        snacks.add("칙촉");
        snacks.add("홈런볼");
        snacks.add("쿠쿠다스");
        snacks.add("프링글스");
        snacks.add("다이제");

        Iterator<String> it = snacks.iterator();

        while(it.hasNext()){
            String snack = it.next();
            System.out.println(snack);
        }
    }













}

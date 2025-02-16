package set.service;

import set.dto.Person;

import java.util.*;

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

        System.out.println("---향상된 for문---");

        for(String snack : snacks){
            System.out.println(snack);
        }

        System.out.println("---set -> List로 변환---");
        List<String> list = new ArrayList<String>(snacks);

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    public void test4(){
        Set<String> set = new TreeSet<>();

        set.add("짱구");
        set.add("짱구");
        set.add("유리");
        set.add("철수");
        set.add("훈이");
        set.add("맹구");
        set.add("짱구2호");

        System.out.println(set);
    }

    public String getLottoNumber(){
        Random random = new Random();

        Set<Integer> lotto = new TreeSet<Integer>();

        while(lotto.size() < 6){
            lotto.add(random.nextInt(45)+1);
        }

        return lotto.toString();
    }

    public void lottoNumberGenerator(){
        Scanner sc = new Scanner(System.in);
        System.out.print("생성할 로또 번호 개수 입력 : ");
        int count = sc.nextInt();

        for(int i=0; i<count; i++) {
            System.out.printf("[%d회] : %s\n", i+1, getLottoNumber()); // 0회 1회 이렇게 말고 1회, 2회,.. 이렇게 하기위헤 i+1
        }

        System.out.println("금액 : " + (count*1000) + "원");
    }



}

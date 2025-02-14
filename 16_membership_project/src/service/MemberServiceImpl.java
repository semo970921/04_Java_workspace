
package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl()
            throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }


    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    // result == 1 : *** 회원이 추가 되었습니다 ***
    // result == 2 : "### 중복되는 휴대폰 번호가 존재합니다 ###"
    // 나머지        : *** 다시 입력 해주세요 ***
    @Override
    public int addMember(String name, String phone) throws IOException {

         List<Member> list = dao.getMemberList();
         for(Member member:list){

             // 중복된 번호가 있을 경우
             if (member.getPhone().equals(phone) == true) {
                 return 2 ; // 가입 X
             }

             if(phone.length()!=11){
                 return 3;
             }
         }
         // 중복된 번호가 없을 경우
        dao.addMember(new Member(name, phone));

        return 1;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {

        // dao에서 반환 받은 memberList를 그대로 view로 리턴
        return dao.getMemberList();
    }



    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {

        List<Member> searchList = new ArrayList<>();

        for(Member member : dao.getMemberList()){
            if(member.getName().equals(searchName)){
                searchList.add(member);
            }
        }
        return searchList;
    }




    @Override
    public String updateAmount(Member target, int acc) throws IOException {
        int oldAmount = target.getAmount();
        int newAmount = oldAmount + acc;
        target.setAmount(newAmount);

        String result = "";
        int oldGrade = target.getGrade();

        // 등급 업데이트
        if (newAmount >= 100000) {
            target.setGrade(Member.DIAMOND);
            if (!Objects.equals(oldGrade, Member.DIAMOND)) { // !oldGrade.equals(Member.
                result = "* 다이아 * 등급으로 변경 되셨습니다\n";
            }
        } else if (newAmount >= 50000) {
            target.setGrade(Member.GOLD);
            if (!Objects.equals(oldGrade,Member.GOLD)) {
                result = "* 골드 * 등급으로 변경 되셨습니다\n";
            }
        } else {
            target.setGrade(Member.COMMON);
        }

        dao.saveFile();

        return target.getName() + " 회원님의 누적 금액\n" +
                oldAmount + " -> " + newAmount + "\n" +
                result ;
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {

        String oldPhone = target.getPhone();
        target.setPhone(phone);
        dao.saveFile();
        return target.getName() + "님의 전화번호가 변경되었습니다. \n" +
                  oldPhone + " → " + phone ;

        // ex)
        // 홍길동님의 전화번호가 변경 되었습니다
        // 01012341234 -> 01044445555
    }


    // 회
    @Override
    public String deleteMember(Member target) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- 회원 탈퇴 -----\n");

        System.out.print("정말 탈퇴 처리 하시겠습니까? (y/n) : ");

        String answer = sc.next().toLowerCase();

        if (answer.equals("y")) {
            dao.getMemberList().remove(target);
            dao.saveFile();
            return target.getName() + " 회원이 탈퇴 처리 되었습니다.";
        } else {
            return "회원 탈퇴가 취소되었습니다.";
        }
    }

    @Override
    public boolean addNumber(String name, String phone) {
        return false;
    }

}

package dao;

import dto.Member;

import java.io.IOException;
import java.util.List;

// DAO(Data Access Object) :
// - 데이터가 저장된 곳(파일/DB)에 접근하는 역할의 객체
// - 데이터 저장/수정/삭제/조회 가능

public interface MemberDAO {

    // 인터페이스 메서드는
    // 묵시적(암묵적)으로 public abstract다!!

    /**
     * DAO 객체가 가지고 있는 memberList 반환
     * @return memberList
     */
    List<Member> getMemberList();


    /**
     * 회원 추가
     * @param member
     * @return true
     * @throws IOException
     */
    boolean addMember(Member member) throws IOException;


    /**
     * 파일 저장
     */
    void saveFile() throws IOException;


}


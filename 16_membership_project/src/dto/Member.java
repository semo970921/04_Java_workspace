package dto;

import java.io.Serializable;

public class Member implements Serializable{ // + 직렬화

    private static final long serialVersionUID = 1L;

    // DTO(Data Transfer Object) : 데이터 전달용 객체
    // - 여러 데이터를 한 번에 담아서
    //   계층간 데이터를 전달하는 목적으로 사용하는 객체

    // (계층 : view, service, dao 등 다른 클래스)


    // 등급을 나타내는 상수
    public static final int COMMON = 0;
    public static final int GOLD = 1;
    public static final int DIAMOND = 2;

    // 회원 정보를 저장할 필드
    private String name;
    private String phone;
    private int amount;
    private int grade;

    public Member() {}

    public Member(String name, String phone, int amount, int grade) {
        this.name = name;
        this.phone = phone;
        this.amount = amount;
        this.grade = grade;
    }

    /**
     * MemberDAOImpl 에서
     * 중복된 번호가 없을 경우
     * 회원 추가를 위한 오버로딩
     * @param name : 이름
     * @param phone : 폰 번호
     */
    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    // 등급을 문자열로 변환하는 메서드 추가
    public String getGradeString() {
        switch (grade) {
            case DIAMOND:
                return "DIAMOND";
            case GOLD:
                return "GOLD";
            case COMMON:
            default:
                return "COMMON";
        }
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", amount=" + amount +
                ", grade=" + grade +
                '}';
    }
}
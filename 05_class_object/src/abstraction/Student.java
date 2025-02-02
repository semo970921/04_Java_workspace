package abstraction;

public class Student {

    private String studentNumber;  // 학번(숫자로 이루어진 문자열(학번, 전화번호,..)
    private String name;                  // 이름
    private int html;                          // HTML 점수
    private int css;                           // CSS 점수
    private int js;                              // js 점수
    private int java;                          // java 점수

    public Student(){
        System.out.println("-- student 객체가 기본생성자로 생성되었습니다. --");
        studentNumber = "2021xxxxx";
        name = "미입력";
        html = 100;
        css = 100;
        js = 100;
        java = 100;
    }

    // Duplicate method Student() in type Student
	/*public Student() {
		- 변수, 메서드, 생성자 모두 중복되는 이름이 존재하면 안됨
	}*/

    /*매개 변수가 있는 생성자(String 2개)*/
    public Student(String studentNumber, String name){ // 오버로딩
        System.out.println("-- Student(String, String) 생성자로 객체 생성 --");

        // 생성되는 객체의 필드 초기화
        this.studentNumber = studentNumber;
        this.name = name;
    }

    /* 매개 변수가 있는 생성자(모든 필드 초기화) */
    public Student(String studentNumber, String name,
                   int html, int css, int js, int java) {

        System.out.println("--모든 필드를 초기화하는 생성자로 객체 생성--");

        this.studentNumber = studentNumber;
        this.name = name;
        this.html = html;
        this.css = css;
        this.js = js;
        this.java = java;
    }

    public String getStudentNumber(){
        return studentNumber;
    }

    public String getName(){
        return name;
    }

    public int getHtml() {
        return html;
    }

    public int getCss() {
        return css;
    }

    public int getJs() {
        return js;
    }

    public int getJava() {
        return java;
    }

    //---------------------------------------------------------------------

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    public void setCss(int css) {
        this.css = css;
    }

    public void setJs(int js) {
        this.js = js;
    }

    public void setJava(int java) {
        this.java = java;
    }

    // 성적 합계 계산해서 반환하는 메서드
    public int getSum(){
        return html + css + js + java;
    }

    // 평균 반환 메서드
    public double getAverage(){
        return getSum() / 4.0;
    }

    // 학생의 성적 정보를 문자열 형태로 반환
    public String toString(){
        String str
                = String.format(
                "[%s] %s\n"
                        + "HTML : %d / CSS : %d / JS : %d / Java : %d\n /"
                        + "합계 : %d\n"
                        + "평균 : %.2f"
                , studentNumber, name,
                html, css, js, java,
                getSum(), getAverage());

        return str; // 만들어진 문자열 반환
    }





}

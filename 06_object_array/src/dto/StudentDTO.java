package dto;

public class StudentDTO {
    private String studentNumber;   // 학번
    private String name;                    // 이름
    private char gender;                    // 성별
    private int html;                           // html 점수
    private int css;                            // css 점수
    private int js;                               // js 점수
    private int java;                           // java 점수

    // 매개변수가 있는 생성자
    public StudentDTO(String studentNumber, String name, char gender) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.gender = gender;
    }

    // getter/setter : 필드 간접 접근
    public String getStudentNumber(){
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHtml() {
        return html;
    }
    public void setHtml(int html) {
        this.html = html;
    }

    public int getCss() {
        return css;
    }
    public void setCss(int css) {
        this.css = css;
    }

    public int getJs() {
        return js;
    }
    public void setJs(int js) {
        this.js = js;
    }

    public int getJava() {
        return java;
    }
    public void setJava(int java) {
        this.java = java;
    }

    public String toString(){
        // [학번] 이름(성별)
        //HTML : 100 / CSS : 50 : / JS :70 / Java : 100
        return
                String.format(
                        "[%s] %s(%c)\n"
                        +"HTML : %d / CSS : %d / JS : %d / Java : %d",
                        studentNumber, name, gender,
                        html, css, js, java);
    }

}

package jito.web.springbootbasic.member.dto;

public class MemberRequest {
    private String name;
    private String age;

    public MemberRequest(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
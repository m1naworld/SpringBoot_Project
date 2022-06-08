package org.zerock.ex2.DTO;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.ex2.entity.Member;


@Data
@NoArgsConstructor
public class JoinForm {
    private Long num;
    private String name;
    private String userId;
    private String password;

    @Builder
    public JoinForm(Long num, String name, String userId, String password){
        this.num = num;
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public Member toEntity(){
        System.out.println("success");
        return Member.builder().name(name).userId(userId).password(password).build();

    }
}

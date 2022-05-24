package org.zerock.ex2.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String name;


    @Column(length = 30, nullable = false)
    private String userId;

    @Column(length = 200, nullable = false)
    private String password;

    @Builder
    public Member(String name, String userId, String password){
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

}

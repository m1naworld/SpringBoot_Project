package org.zerock.ex2.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String id;

    @Column(length = 200, nullable = false)
    private String password;

}

package com.example.mission7.member;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "terms")
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String title;

    @Lob
    @Column
    private String body;

    @Column
    private boolean optional;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 양방향 매핑: Terms와 MemberAgree
    @OneToMany(mappedBy = "terms")
    private Set<Member> memberAgrees;

    // 기타 getter와 setter 메소드 ...
}

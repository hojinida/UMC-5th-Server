package com.example.mission7.member;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "member_agree")
public class MemberAgree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 양방향 매핑: MemberAgree와 Member
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 20)
    private String termsId; // 약관 ID는 실제로 다른 테이블을 참조할 수 있습니다.

    @Column
    private boolean agreed;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // ... 기타 getter와 setter 메소드 ...
}

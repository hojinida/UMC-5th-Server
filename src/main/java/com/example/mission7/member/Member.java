package com.example.mission7.member;

import com.example.mission7.mission.MemberMission;
import com.example.mission7.review.Review;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 10)
    private String gender;

    @Column(length = 40)
    private String address;

    @Column(length = 40)
    private String specAddress;

    @Column
    private Date inactiveDate;

    @Column(length = 10)
    private String socialType;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    @Column(length = 60)
    private String email;

    @Column
    private int point;

    // 양방향 매핑: Member와 MemberMission
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberMission> memberMissions;

    // 양방향 매핑: Member와 Review
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    // 양방향 매핑: Member와 MemberAgree
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MemberAgree> memberAgrees;

    // 양방향 매핑: Member와 MemberPrefer
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MemberPrefer> memberPrefers;

    @ManyToOne
    @JoinColumn(name = "terms_id")
    private Terms terms;

    // ... 기타 getter와 setter 메소드 ...
}


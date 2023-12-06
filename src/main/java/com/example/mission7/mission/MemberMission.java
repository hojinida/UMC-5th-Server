package com.example.mission7.mission;

import com.example.mission7.member.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "member_mission")
@NoArgsConstructor
public class MemberMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 양방향 매핑: MemberMission과 Member
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 양방향 매핑: MemberMission과 Mission
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Getter
    @Column(length = 15)
    private String status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public void setStatus(String status) {
        this.status = status;
    }
    @Builder
    public MemberMission(Member member, Mission mission, String status, Date createdAt, Date updatedAt) {
        this.member = member;
        this.mission = mission;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 기타 getter와 setter 메소드 ...
}

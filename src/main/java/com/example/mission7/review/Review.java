package com.example.mission7.review;

import com.example.mission7.member.Member;
import com.example.mission7.store.domain.Store;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 양방향 매핑: Review와 Member
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 양방향 매핑: Review와 Store
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(length = 1000)
    private String content;

    @Column
    private float score;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 기타 getter와 setter 메소드 ...


    @Builder
    public Review(Member member, Store store, String content, float score, Date createdAt, Date updatedAt) {
        this.member = member;
        this.store = store;
        this.content = content;
        this.score = score;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
package com.example.mission7.store.domain;

import com.example.mission7.mission.Mission;
import com.example.mission7.region.Region;
import com.example.mission7.review.Review;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    @Column
    private float score;  // 상점 평점

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 양방향 매핑: Store와 Mission
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mission> missions;

    // 양방향 매핑: Store와 Review
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    // 단방향 매핑: Store와 Region
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;


    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    // 기타 getter와 setter 메소드 ...

    @Builder
    public Store(String name, String address, float score, Date createdAt, Date updatedAt, List<Mission> missions, List<Review> reviews, Region region) {
        this.name = name;
        this.address = address;
        this.score = score;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.missions = missions;
        this.reviews = reviews;
        this.region = region;
    }
}

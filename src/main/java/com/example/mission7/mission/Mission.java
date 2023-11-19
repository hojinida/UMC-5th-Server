package com.example.mission7.mission;

import com.example.mission7.store.Store;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 단방향 매핑: Mission과 Store
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column
    private String reward;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column
    private String missionSpec;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 양방향 매핑: Mission과 MemberMission
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberMission> memberMissions;

    // 기타 getter와 setter 메소드 ...
}

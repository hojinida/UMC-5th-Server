package com.example.mission7.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
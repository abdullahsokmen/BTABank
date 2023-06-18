package com.project.repository;

import com.project.repository.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends JpaRepository<Credit,Long> {
}

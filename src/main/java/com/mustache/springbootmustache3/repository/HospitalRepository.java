package com.mustache.springbootmustache3.repository;

import com.mustache.springbootmustache3.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}

package com.mustache.springbootmustache3.repository;

import com.mustache.springbootmustache3.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessType);
    List<Hospital> findByBusinessTypeNameInAndRoadNameAddressLike(List<String> businessType, String nameAddress);
}

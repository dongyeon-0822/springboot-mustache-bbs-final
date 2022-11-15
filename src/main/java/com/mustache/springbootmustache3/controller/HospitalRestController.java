package com.mustache.springbootmustache3.controller;

import com.mustache.springbootmustache3.domain.dto.HospitalResponse;
import com.mustache.springbootmustache3.domain.entity.Hospital;
import com.mustache.springbootmustache3.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id); //Entity
        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); //Dto
        return ResponseEntity.ok().body(hospitalResponse); // Return은 Dto로
    }
}

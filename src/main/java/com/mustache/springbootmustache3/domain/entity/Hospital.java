package com.mustache.springbootmustache3.domain.entity;

import com.mustache.springbootmustache3.domain.dto.HospitalResponse;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nation_wide_hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hospital {
    @Id
    private Integer id;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name="road_name_address")
    private String roadNameAddress;

    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
    public String businessStatusName;
    public Integer businessStatusCode;

    // HospitalEntity를 HospitalResponse Dto로 만들어주는 부분
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(),
                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize());
    }
}

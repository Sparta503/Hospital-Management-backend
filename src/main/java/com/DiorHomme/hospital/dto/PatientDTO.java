package com.DiorHomme.hospital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;
    
    private String phoneNumber;
    private String address;
    
    public PatientDTO(Long id, String name, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public static PatientDTO fromEntity(com.DiorHomme.hospital.model.Patient patient) {
        if (patient == null) {
            return null;
        }
        return new PatientDTO(
            patient.getId(),
            patient.getName(),
            patient.getEmail(),
            patient.getPhoneNumber(),
            patient.getAddress()
        );
    }
    
    public static com.DiorHomme.hospital.model.Patient toEntity(PatientDTO dto) {
        if (dto == null) {
            return null;
        }
        com.DiorHomme.hospital.model.Patient patient = new com.DiorHomme.hospital.model.Patient();
        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setAddress(dto.getAddress());
        return patient;
    }
}

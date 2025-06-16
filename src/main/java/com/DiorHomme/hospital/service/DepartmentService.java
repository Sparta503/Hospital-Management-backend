package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.dto.DepartmentDTO;
import com.DiorHomme.hospital.exception.DepartmentNotFoundException;
import com.DiorHomme.hospital.model.Department;
import com.DiorHomme.hospital.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public DepartmentDTO getDepartmentById(Long id) throws DepartmentNotFoundException {
        return convertToDTO(
                departmentRepository.findById(id)
                        .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id))
        );
    }
    
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDTO(savedDepartment);
    }
    
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) throws DepartmentNotFoundException {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));
        
        BeanUtils.copyProperties(departmentDTO, existingDepartment);
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return convertToDTO(updatedDepartment);
    }
    
    public void deleteDepartment(Long id) throws DepartmentNotFoundException {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));
        
        departmentRepository.delete(department);
    }

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        BeanUtils.copyProperties(department, dto);
        return dto;
    }

    private Department convertToEntity(DepartmentDTO dto) {
        Department department = new Department();
        BeanUtils.copyProperties(dto, department);
        return department;
    }
}

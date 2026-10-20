package service;

import model.Employee;
import model.Equipment;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;
import repository.EquipmentRepository;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EmployeeRepository employeeRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, EmployeeRepository employeeRepository) {
        this.equipmentRepository = equipmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public void assignEquipment(Long employeeId, Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Assign employee, update status, and save back to H2 database
        equipment.setEmployee(employee);
        equipment.setStatus("ASSIGNED");

        equipmentRepository.save(equipment);
    }
}
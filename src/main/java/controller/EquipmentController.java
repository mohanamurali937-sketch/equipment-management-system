package controller;

import model.Equipment;
import org.springframework.web.bind.annotation.*;
import repository.EquipmentRepository;
import service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentRepository equipmentRepository, EquipmentService equipmentService) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentService = equipmentService;
    }

    // Get all equipment for inventory table
    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // Add new equipment
    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    // Assign equipment to an employee
    @PostMapping("/{equipmentId}/assign/{employeeId}")
    public void assignEquipment(@PathVariable Long equipmentId, @PathVariable Long employeeId) {
        equipmentService.assignEquipment(employeeId, equipmentId);

    }
    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentRepository.deleteById(id);
    }
}
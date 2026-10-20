package service;

import exception.EmployeeNotFoundException;
import model.Employee;
import model.Equipment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.EmployeeRepository;
import repository.EquipmentRepository;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
// OR you can use:
// import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;

@ExtendWith(MockitoExtension.class)
class EquipmentServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentService service;

    @Test
    void shouldAssignEquipmentToEmployee() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(101L);
        employee.setName("Pranav");

        Equipment equipment = new Equipment();
        equipment.setId(501L);
        equipment.setName("Dell Laptop");

        when(employeeRepository.findById(101L)).thenReturn(Optional.of(employee));
        when(equipmentRepository.findById(501L)).thenReturn(Optional.of(equipment));

        // Act
        service.assignEquipment(101L, 501L);

        // Assert
        assertTrue(equipment.isAssigned());
        assertEquals(101L, equipment.getAssignedEmployeeId());
        verify(equipmentRepository, times(1)).save(equipment);
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {
        // Arrange
        when(employeeRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EmployeeNotFoundException.class, () -> service.assignEquipment(999L, 501L));
    }
}
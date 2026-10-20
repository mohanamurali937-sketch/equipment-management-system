package App;

import model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.EmployeeRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataInitializer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.count() == 0) {
            employeeRepository.save(new Employee("Alice Smith", "alice@example.com"));
            employeeRepository.save(new Employee("Bob Jones", "bob@example.com"));
            employeeRepository.save(new Employee("Charlie Brown", "charlie@example.com"));
            System.out.println(">>> Mock employees inserted into H2 database!");
        }
    }
}
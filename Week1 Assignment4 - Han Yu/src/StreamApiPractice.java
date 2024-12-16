import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Optional;

class Employee {
    private String name;
    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamApiPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 90000),
                new Employee("Bob", 85000),
                new Employee("Charlie", 75000),
                new Employee("Xander", 70000)
        );
        // average salary
        double averageSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("Average Salary: " + averageSalary);
        // Filter employees whose salary exceeds 80000
        System.out.println("Employees with salary > 80000:");
        employees.stream()
                .filter(e -> e.getSalary() > 80000)
                .map(Employee::getName)
                .forEach(System.out::println);
        // Collect a Map of employees with name as key
        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Function.identity()));
        System.out.println("Employee Map: " + employeeMap);
        // Find any employee whose name starts with 'X'
        Optional<Employee> employeeWithX = employees.stream()
                .filter(e -> e.getName().startsWith("X"))
                .findAny();
        System.out.println(employeeWithX.map(Employee::getName)
                .orElse("no such employee exists"));
        // Concatenate all employee names
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Concatenated Names: " + concatenatedNames);
    }
}

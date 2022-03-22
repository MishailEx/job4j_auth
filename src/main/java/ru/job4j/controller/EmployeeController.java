package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Employee;
import ru.job4j.model.EmployeeShow;
import ru.job4j.repository.EmployeeRepository;
import ru.job4j.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository persons;
    private final EmployeeService service;

    public EmployeeController(EmployeeRepository persons, EmployeeService service) {
        this.persons = persons;
        this.service = service;
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        return StreamSupport.stream(
                this.persons.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeShow> findById(@PathVariable int id) {
        var person = Optional.ofNullable(service.getEmployee(id));
        return new ResponseEntity<EmployeeShow>(
                person.orElse(new EmployeeShow()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee person) {
        return new ResponseEntity<Employee>(
                this.persons.save(person),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Employee person) {
        this.persons.save(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Employee person = new Employee();
        person.setId(id);
        this.persons.delete(person);
        return ResponseEntity.ok().build();
    }

}

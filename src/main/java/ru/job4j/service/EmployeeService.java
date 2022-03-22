package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.Employee;

import ru.job4j.model.EmployeeShow;
import ru.job4j.model.PersonShow;
import ru.job4j.repository.EmployeeRepository;
import ru.job4j.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository repository;
    private PersonRepository personRepository;

    public EmployeeService(EmployeeRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public EmployeeShow getEmployee(int id) {
       Employee employee = this.repository.findById(id).get();
       EmployeeShow employeeShow = new EmployeeShow();
       employeeShow.setId(employee.getId());
       employeeShow.setName(employee.getName());
       employeeShow.setSurname(employee.getSurname());
       employeeShow.setInn(employee.getInn());
       employeeShow.setDate(employee.getDate());
       List<PersonShow> l = personRepository.find(id).stream().map(PersonShow::toPersonShow).collect(Collectors.toList());
       employeeShow.getList().addAll(l);
       return employeeShow;
   }

}

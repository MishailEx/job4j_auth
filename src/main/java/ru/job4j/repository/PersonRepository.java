package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query("from person p where p.employee.id = :id")
    List<Person> find(int id);

}
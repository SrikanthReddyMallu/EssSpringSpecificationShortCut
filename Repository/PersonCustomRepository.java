package com.example.SpecificationConcept.Repository;

import com.example.SpecificationConcept.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCustomRepository
{
List<Person> findByFirstNameAndLastName(String firstName, String lastName);

}

package com.example.SpecificationConcept.Repository;

import com.example.SpecificationConcept.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person,Long>,PersonCustomRepository, JpaSpecificationExecutor<Person>
{
}

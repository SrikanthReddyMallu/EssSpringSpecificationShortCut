package com.example.SpecificationConcept.Controller;

import com.example.SpecificationConcept.Entity.Person;
import com.example.SpecificationConcept.Repository.PersonCustomRepository;
import com.example.SpecificationConcept.Repository.PersonRepository;
import com.example.SpecificationConcept.Specification.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SpecificationConcept")
public class Controller
{
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping(value="/findFirstAndLastName/{firstName}/{secondName}",
            method = RequestMethod.GET)
    public List<Person> findFirstAndLastName(@PathVariable("firstName")String firstName,
                                             @PathVariable("secondName")String secondName)
    {
        return personRepository.findByFirstNameAndLastName(firstName,secondName);
    }


    @RequestMapping(value="/findFirstLastName/{firstName}/{lastName}",
            method = RequestMethod.GET)
    public List<Person> findFirstLastName(@PathVariable("firstName")String firstName,
                                             @PathVariable("lastName")String lastName)
    {
       // Specification<Person> specification=Specification.where(PersonSpecification.hasFirstName(firstName).and(
      //          PersonSpecification.hasLastName(lastName)));
      //  return personRepository.findAll(specification);
        return personRepository.findAll(Specification.where(PersonSpecification.hasFirstName(firstName)).and(
                Specification.where(PersonSpecification.hasLastName(lastName))));
    }

    @RequestMapping(value="/findLastName/{lastName}",
            method = RequestMethod.GET)
    public List<Person> findFirstLastName(@PathVariable("lastName")String lastName)
    {
        return personRepository.findAll(Specification.where(PersonSpecification.contains(lastName)));
    }
}

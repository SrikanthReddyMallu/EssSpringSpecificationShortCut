package com.example.SpecificationConcept.Service;

import com.example.SpecificationConcept.Entity.Person;
import com.example.SpecificationConcept.Repository.PersonCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonCustomRepository {

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();   //Here EntityManager instance is used to be CriterlaBuilder class object
        CriteriaQuery cq=cb.createQuery();                       //CriteriaQuery object is used to create the Query
        Root<Person> root= cq.from(Person.class);                //Here cq.from is used to set the query root from the class

        Predicate firstNamePredicate=cb.equal(root.get("firstName"),firstName);
        Predicate lastNamePredicate=cb.equal(root.get("lastName"),lastName);

        cq.where(firstNamePredicate,lastNamePredicate);           //He we pass the predicate values to the where condition
        TypedQuery<Person> query=entityManager.createQuery(cq);   //Here typed query instance is used to prepare the query for execution and specifiy the type of the query
        return query.getResultList();                             //Here finally return the result
    }
}

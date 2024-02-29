package com.example.SpecificationConcept.Specification;

import com.example.SpecificationConcept.Entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PersonSpecification
{
    public static Specification<Person> hasFirstName(String firstName)
    {
        return((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("firstName"),firstName);
        });
    }

    public static Specification<Person> hasLastName(String lastName)
    {
        return((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("lastName"),lastName);
        });
    }

    public static Specification<Person> contains(String lastNaame)
    {
        return((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("lastName"),"%"+lastNaame+"%");
        });
    }
}

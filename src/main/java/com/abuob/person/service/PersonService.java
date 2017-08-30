package com.abuob.person.service;

import com.abuob.person.domain.Person;

public interface PersonService {

    Person createPerson (Person person);
    Person findPersonByName (String name);
    Person updatePerson (Person person);
    Person deletePerson (String name);
}

package com.abuob.person.service;

import com.abuob.person.domain.Person;

public interface PersonService {

    public Person createPerson (Person person);
    public Person findPersonByName (String name);
    public Person updatePerson (Person person);
    public Person deletePerson (String name);
}

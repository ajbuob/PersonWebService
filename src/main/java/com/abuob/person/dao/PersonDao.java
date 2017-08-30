package com.abuob.person.dao;

import com.abuob.person.domain.Person;

public interface PersonDao {

    Person findPersonByName (String name);
    Person createPerson (Person person);
    Person updatePerson (Person person);
    Person deletePerson (String name);
}

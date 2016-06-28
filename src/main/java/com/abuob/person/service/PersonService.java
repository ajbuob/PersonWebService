package com.abuob.person.service;

import com.abuob.person.domain.Person;

/**
 * Created by abuob on 6/26/16.
 */
public interface PersonService {

    public Person createPerson (Person person);
    public Person findPersonByName (String name);
    public Person updatePerson (Person person);
    public Person deletePerson (String name);
}

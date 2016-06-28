package com.abuob.person.dao;

import com.abuob.person.domain.Person;

/**
 * Created by abuob on 6/26/16.
 */
public interface PersonDao {

    public Person findPersonByName (String name);
    public Person createPerson (Person person);
    public Person updatePerson (Person person);
    public Person deletePerson (String name);
}

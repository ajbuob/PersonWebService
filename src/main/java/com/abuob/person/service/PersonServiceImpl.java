package com.abuob.person.service;

import com.abuob.person.dao.PersonDao;
import com.abuob.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by abuob on 6/26/16.
 */

@Service("PersonService")
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao personDao;

    public Person createPerson(Person person) {
        return personDao.createPerson(person);
    }

    public Person findPersonByName(String name) {
        return personDao.findPersonByName(name);
    }


    public Person updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    public Person deletePerson(String name) {
        return personDao.deletePerson(name);
    }

}

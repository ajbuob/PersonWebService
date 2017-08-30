package com.abuob.person.dao;

import com.abuob.person.domain.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("PersonDao")
public class PersonDaoImpl implements PersonDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person findPersonByName(String name) {
        Person person = null;

        if (!StringUtils.isBlank(name)){

            List<Person> people = jdbcTemplate.query("SELECT * FROM PERSON WHERE NAME = ?", new PersonMapper(), new Object[] {name});

            //Take the first entry in the array from the List
            if(people != null && !people.isEmpty()) {
                person = people.get(0);
            }

        }
        return person;
    }

    public Person createPerson(Person person) {

        int numRows = jdbcTemplate.update("INSERT INTO PERSON (NAME, AGE, HEIGHT, LIKES_ICE_CREAM) VALUES (?, ?, ?, ?)",
                new Object[] { person.getName(), person.getAge(), person.getHeight(), person.isLikesIceCream()});

        //Successful insert into the database, we will return the created person to the user
        if (numRows == 1){
            return person;
        }
        return null;
    }

    public Person updatePerson(Person person) {

        int numRows = jdbcTemplate.update("UPDATE PERSON SET AGE = ?, HEIGHT = ?, LIKES_ICE_CREAM =? WHERE NAME = ?",
                new Object[] { person.getAge(), person.getHeight(), person.isLikesIceCream(), person.getName()});

        //Successful update the database, we will return the created person to the user
        if (numRows == 1){
            return person;
        }
        return null;
    }

    public Person deletePerson(String name) {

        Person person = null;

        if (!StringUtils.isBlank(name)){

            List<Person> people = jdbcTemplate.query("SELECT * FROM PERSON WHERE NAME = ?", new PersonMapper(), new Object[] {name});

            if(people != null && !people.isEmpty()) {
                person = people.get(0);

                int numRows = jdbcTemplate.update("DELETE FROM PERSON WHERE NAME = ?",new Object[] {name});
                //Successful delete from the database, we will return the person to the user
                System.out.println("DEL NUM ROWS:"+numRows);

                if (numRows == 1){
                    return person;
                }
            }
        }
        return person;
    }

    private static final class PersonMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

            Person person = new Person();
            person.setName(rs.getString("NAME"));
            person.setAge(rs.getInt("AGE"));
            person.setHeight(rs.getInt("HEIGHT"));
            person.setLikesIceCream(rs.getBoolean("LIKES_ICE_CREAM"));
            return person;
        }
    }
}

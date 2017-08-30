package com.abuob.person.controller;

import com.abuob.person.domain.Person;
import com.abuob.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("PersonWebService")
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //Takes in a person information in the request and then returns
    //it to the user as confirmation of the creation.
    @RequestMapping(value = "/createPerson",method={RequestMethod.POST},produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Person createPerson (@RequestBody Person person,
                         HttpServletRequest request, HttpServletResponse response){

        Person p = personService.createPerson(person);

        if (p == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return   p;
    }

    //Takes the name of the person to perform a lookup of all the personal information.
    @RequestMapping(value = "/getPersonInfo",method={RequestMethod.GET},produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Person readPerson (@RequestParam(value="name") String name,
                                            HttpServletRequest request, HttpServletResponse response){


        if (name == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }

        Person p = personService.findPersonByName(name);

        if (p == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return p;
    }


    //Takes in a person information in the request and then returns
    //it to the user as confirmation of the creation.
    @RequestMapping(value = "/updatePerson",method={RequestMethod.PUT},produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Person updatePerson (@RequestBody Person person,
                                              HttpServletRequest request, HttpServletResponse response){

        Person p  = personService.updatePerson(person);

        if (p == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return p;
    }

    //Deletes the person with the specified name and then
    //returns the removed person object with all their information
    @RequestMapping(value = "/deletePerson",method={RequestMethod.DELETE},produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Person deletePerson (@RequestParam(value="name") String name,
                                              HttpServletRequest request, HttpServletResponse response){
        if (name == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }

        Person p  = personService.deletePerson(name);
        if (p == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return p;
    }
}

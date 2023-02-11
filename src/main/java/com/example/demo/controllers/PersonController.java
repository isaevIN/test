package com.example.demo.controllers;

import com.example.demo.models.Document;
import com.example.demo.models.Person;
import com.example.demo.service.DocumentService;
import com.example.demo.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@Api(value = "MainController")
@RequestMapping(value = "/person")
public class PersonController implements PersonApi {


    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        boolean savePerson = personService.savePerson(person);
        if(savePerson){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer personId){
        Person person = personService.getPerson(personId);
        if(person!=null){
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

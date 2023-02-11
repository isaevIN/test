package com.example.demo.service;

import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Person getPerson(Integer id){
        return personRepo.findById(Long.valueOf(id)).get();
    }

    public Boolean savePerson(Person person){
        try{
            personRepo.save(person);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

package com.example.demo;

import com.example.demo.domain.Address;
import com.example.demo.domain.Family;
import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private PersonRepository repository;
    @Test
    public void savePerson() {
        Person person = new Person("张","有才");
        Person person2 = new Person("James","Harden");

        Address address;
        address = new Address("北京","China");
        person.setAddress(address);

        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲","张良");
        Family mom = new Family("母亲","李香君");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);

        Person save = repository.save(person);
        Person save2 = repository.save(person2);
        System.out.println(save);
        System.out.println(save2);
    }

    @Test
    public void selectPerson(){
        List<Person> list = repository.findByAddress_City("北京");
        System.out.println(list);
    }

    @Test
    public void updatePerson(){
        Person person = repository.findByFirstnameAndLastname("张","有才").get(0);
        person.setLastname("小明");
        Person update = repository.save(person);
        System.out.println(update);
    }

    @Test
    public void deletePerson(){
        Person person = repository.findByFirstnameAndLastname("张","小明").get(0);
        repository.delete(person);
    }


}

package com.example.demo.domain;



import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


import javax.persistence.Id;
import java.util.List;

@RedisHash("persons")
public class Person {
    @Id
    private String id;
    @Indexed
    private  String firstname;
    @Indexed
    private String lastname;
    private Address address;
    private List<Family> familyList;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname  = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public List<Family> getFamilyList() {
        return familyList;
    }
    public void setFamilyList(List<Family> list) {
        this.familyList = list;
    }

    public Person(String id, String firstname, String lastname, Address address, List<Family> familyList) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.familyList = familyList;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                ", familyList=" + familyList +
                '}';
    }



}

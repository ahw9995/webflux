package com.example.webflux.service;

import com.example.webflux.entity.Person;
import com.example.webflux.model.PersonInfo;
import com.example.webflux.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonInfo getPerson(final String id) {

        Person person = this.personRepository.findById(id);

        if (Objects.isNull(person)) {
            return null;
        }

        return PersonInfo.builder()
                .seq(person.getSeq())
                .id(person.getId())
                .name(person.getFullName())
                .age(person.getAge())
                .build();
    }

    @Transactional
    public Boolean addPerson(final PersonInfo personInfo) {
        this.personRepository.save(Person.builder()
                .id(personInfo.getId())
                .fullName(personInfo.getName())
                .age(personInfo.getAge())
                .build());
        return true;
    }

    @Transactional
    public Boolean deletePerson(final String id) {
        Person person = this.personRepository.findById(id);
        this.personRepository.delete(person);
        return true;
    }
}

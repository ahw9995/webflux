package com.example.webflux.controller;

import com.example.webflux.model.PersonInfo;
import com.example.webflux.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WebFluxController {

    private final PersonService personService;

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonInfo> getPerson(@PathVariable("id") final String id) {
        return new ResponseEntity<>(this.personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> addPerson(@RequestBody final PersonInfo personInfo) {
        return new ResponseEntity<>(this.personService.addPerson(personInfo), HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable("id") final String id) {
        return new ResponseEntity<>(this.personService.deletePerson(id), HttpStatus.OK);
    }
}

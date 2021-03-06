package com.bootcamp.public_servicecreditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.public_servicecreditcard.model.dao.CreditCard;
import com.bootcamp.public_servicecreditcard.service.CreditCardService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditcard")
@RequiredArgsConstructor
public class CreditCardController {

    @Autowired
	private CreditCardService service;

	@GetMapping
    public Flux<CreditCard> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CreditCard> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/upload")
    public Mono<CreditCard> save(@RequestBody CreditCard creditcard) {
        return service.save(creditcard);
    }

    @PutMapping
    public Mono<CreditCard> put(@RequestBody CreditCard creditcard) {
        return service.save(creditcard);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }
	
}

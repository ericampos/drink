package com.eric.drink.controller;

import com.eric.drink.models.Revenda;
import com.eric.drink.repository.RevendaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revendas")
@RequiredArgsConstructor
public class RevendaController {

    private RevendaRepository repository;

    @PostMapping
    public ResponseEntity<Revenda> criar(@Valid @RequestBody Revenda revenda) {
        return ResponseEntity.ok(repository.save(revenda));
    }

}
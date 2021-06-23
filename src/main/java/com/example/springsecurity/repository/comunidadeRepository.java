package com.example.springsecurity.repository;

import com.example.springsecurity.model.CursoComunidade;
import org.springframework.data.repository.CrudRepository;

public interface comunidadeRepository extends CrudRepository<CursoComunidade, Long> {
}

package com.example.springsecurity.repository;

import com.example.springsecurity.model.ItensComprados;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<ItensComprados, Long> {

}

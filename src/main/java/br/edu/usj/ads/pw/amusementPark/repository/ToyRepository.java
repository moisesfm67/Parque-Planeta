package br.edu.usj.ads.pw.amusementPark.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.usj.ads.pw.amusementPark.model.Toy;

public interface ToyRepository extends CrudRepository<Toy, Long> {
    List<Toy> findAll();
}

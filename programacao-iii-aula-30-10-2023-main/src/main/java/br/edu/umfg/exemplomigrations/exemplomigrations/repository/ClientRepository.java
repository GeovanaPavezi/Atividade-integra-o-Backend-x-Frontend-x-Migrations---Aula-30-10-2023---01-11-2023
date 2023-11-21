package br.edu.umfg.exemplomigrations.exemplomigrations.repository;

import br.edu.umfg.exemplomigrations.exemplomigrations.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByEmailAndPassword(String email, String password);
}

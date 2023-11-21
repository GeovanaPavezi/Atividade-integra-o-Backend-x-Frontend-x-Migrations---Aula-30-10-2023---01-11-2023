package br.edu.umfg.exemplomigrations.exemplomigrations.controllers;

import br.edu.umfg.exemplomigrations.exemplomigrations.model.Client;
import br.edu.umfg.exemplomigrations.exemplomigrations.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> postClient (@RequestBody Client client){
        clientRepository.save(client);

        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<Iterable<Client>> getClient(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginClient(@RequestParam String email, @RequestParam String password) {
        Optional<Client> clientOptional = clientRepository.findByEmailAndPassword(email, password);
        if (clientOptional.isPresent()) {
            return ResponseEntity.ok("Cliente logado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}

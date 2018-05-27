package br.com.munieri.sistema.contas.view.endpoint.pessoa;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaEndpoint {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public ResponseEntity get() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody Pessoa pessoa) {
        Pessoa pessoaCriada = pessoaService.create(pessoa);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody Pessoa pessoa) {
        Pessoa pessoaCriada = pessoaService.update(pessoa);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


package br.com.munieri.sistema.contas.view.endpoint.pessoa;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}


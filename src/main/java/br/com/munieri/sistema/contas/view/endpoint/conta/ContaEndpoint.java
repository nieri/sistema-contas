package br.com.munieri.sistema.contas.view.endpoint.conta;

import br.com.munieri.sistema.contas.domain.conta.Conta;
import br.com.munieri.sistema.contas.domain.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContaEndpoint {

    @Autowired
    ContaService contaService;

    @RequestMapping(value = "/contas", method = RequestMethod.GET)
    public ResponseEntity get() {
        List<Conta> contas = contaService.findAll();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @RequestMapping(value = "/contas/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        Conta conta = contaService.findById(id);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @RequestMapping(value = "/contas", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody ContaDTO dto) {
        Conta conta = contaService.create(dto);
        return new ResponseEntity<>(conta, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/contas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

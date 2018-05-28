package br.com.munieri.sistema.contas.view.endpoint.transacao;

import br.com.munieri.sistema.contas.Domain.transacao.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransacaoEndpoint {

    @Autowired
    TransacaoService transacaoService;

    @RequestMapping(value = "/transacoes", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody TransacaoDTO dto) {
        transacaoService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

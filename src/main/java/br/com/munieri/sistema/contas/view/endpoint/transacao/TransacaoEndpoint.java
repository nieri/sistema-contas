package br.com.munieri.sistema.contas.view.endpoint.transacao;

import br.com.munieri.sistema.contas.domain.historico.Historico;
import br.com.munieri.sistema.contas.domain.transacao.service.TransacaoService;
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
        if(dto.getCodigoTransacao() == null) {
            dto.geraCodigoTransacao();
        }
        Historico historico = transacaoService.create(dto);
        return new ResponseEntity<>(historico, HttpStatus.CREATED);
    }
}

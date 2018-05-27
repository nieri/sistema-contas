package br.com.munieri.sistema.contas.view.endpoint.pessoa.fisica;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pf")
public class PessoaFisicaEndpoint {

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
    public ResponseEntity post(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = createPessoaFisica(dto);
        Pessoa pessoaCriada = pessoaService.create(pessoaFisica);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = createPessoaFisica(dto);
        Pessoa pessoaCriada = pessoaService.update(pessoaFisica);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private PessoaFisica createPessoaFisica(@RequestBody PessoaFisicaDTO dto) {
        return new PessoaFisica(dto.getCpf(), dto.getNome(), dto.getDataNascimento());
    }
}


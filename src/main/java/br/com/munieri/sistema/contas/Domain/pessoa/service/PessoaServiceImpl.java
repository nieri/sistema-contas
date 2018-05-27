package br.com.munieri.sistema.contas.Domain.pessoa.service;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(Long id) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return pessoa.get();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Pessoa pessoa = this.findById(id);
        pessoaRepository.delete(pessoa);
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
       return this.persist(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        this.checkIfExists(pessoa);
        this.persist(pessoa);
        return pessoa;
    }

    private void checkIfExists(Pessoa pessoa) {
        this.findById(pessoa.getId());
    }

    private Pessoa persist(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}

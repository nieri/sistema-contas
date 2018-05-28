package br.com.munieri.sistema.contas.Domain.pessoa.service;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaJuridica;
import br.com.munieri.sistema.contas.Domain.pessoa.repository.PessoaRepository;
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
    public Pessoa findByCpf(String cpf) {
        PessoaFisica pessoa = pessoaRepository.findByCpf(cpf);
        if (pessoa != null) {
            return pessoa;
        }

        return null;
    }

    @Override
    public Pessoa findByCnpj(String cnpj) {
        PessoaJuridica pessoa = pessoaRepository.findByCnpj(cnpj);
        if (pessoa != null) {
            return pessoa;
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

    @Override
    public Pessoa update(PessoaFisica pessoa) {
        this.checkIfExists(pessoa);
        this.persist(pessoa);
        return pessoa;
    }

    @Override
    public Pessoa update(PessoaJuridica pessoa) {
        this.checkIfExists(pessoa);
        this.persist(pessoa);
        return pessoa;
    }

    private void checkIfExists(Pessoa pessoa) {
        this.findById(pessoa.getId());
    }

    private void checkIfExists(PessoaFisica pessoa) {
        this.findByCpf(pessoa.getCpf());
    }

    private void checkIfExists(PessoaJuridica pessoa) {
        this.findByCnpj(pessoa.getCnpj());
    }

    private Pessoa persist(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}

package br.com.munieri.sistema.contas.Domain.conta.service;

import br.com.munieri.sistema.contas.Domain.conta.Conta;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaJuridica;
import br.com.munieri.sistema.contas.infraestructure.repository.conta.ContaRepository;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaRepository;
import br.com.munieri.sistema.contas.view.endpoint.conta.ContaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Override
    public Conta findById(Long id) {

        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isPresent()) {
            return conta.get();
        }
        return null;
    }

    @Override
    public Conta create(ContaDTO dto) {

        if (isPessoaFisica(dto)) {
            return criaContaPessoaFisica(dto);
        }
        if (isPessoaJuridica(dto)) {
            return criaContaPessoaJuridica(dto);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isPresent()) {
            contaRepository.delete(conta.get());
        }
    }

    @Override
    public Conta update(Conta conta) {
        return this.persist(conta);
    }

    private boolean isPessoaFisica(ContaDTO dto) {
        return dto.getCpfCnpj().length() == 11;
    }

    private boolean isPessoaJuridica(ContaDTO dto) {
        return dto.getCpfCnpj().length() == 14;
    }

    private Conta criaContaPessoaFisica(ContaDTO dto) {
        Conta conta = preparaContaPessoaFisica(dto);
        return this.persist(conta);
    }

    private Conta criaContaPessoaJuridica(ContaDTO dto) {
        Conta conta = preparaContaPessoaJuridica(dto);
        return this.persist(conta);
    }

    private Conta persist(Conta conta) {
        return contaRepository.save(conta);
    }

    private Conta preparaContaPessoaFisica(ContaDTO dto) {
        PessoaFisica pessoaFisica = pessoaRepository.findByCpf(dto.getCpfCnpj());
        return new Conta(dto.getNome(), dto.getStatus(), dto.getSaldo(), pessoaFisica);
    }

    private Conta preparaContaPessoaJuridica(ContaDTO dto) {
        PessoaJuridica pessoaJuridica = pessoaRepository.findByCnpj(dto.getCpfCnpj());
        return new Conta(dto.getNome(), dto.getStatus(), dto.getSaldo(), pessoaJuridica);
    }
}

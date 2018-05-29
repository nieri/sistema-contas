package br.com.munieri.sistema.contas.domain.pessoa.repository;

import br.com.munieri.sistema.contas.domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.domain.pessoa.PessoaJuridica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PessoaRepositoryImpl implements PessoaCustonRepository {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public PessoaFisica findByCpf(String cpf) {

        List<PessoaFisica> pessoas = em.createQuery("SELECT pf FROM PessoaFisica pf where pf.cpf =:cpf")
                .setParameter("cpf", cpf)
                .getResultList();
        return pessoas.get(0);
    }

    public PessoaJuridica findByCnpj(String cnpj) {

        List<PessoaJuridica> pessoas = em.createQuery("SELECT pj FROM PessoaJuridica pj where pf.cnpj =:cnpj")
                .setParameter("cnpj", cnpj)
                .getResultList();
        return pessoas.get(0);
    }
}

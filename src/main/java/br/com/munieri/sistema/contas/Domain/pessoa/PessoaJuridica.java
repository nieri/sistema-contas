package br.com.munieri.sistema.contas.Domain.pessoa;

import br.com.munieri.sistema.contas.Domain.conta.Conta;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pessoa_juridica")
@DiscriminatorValue("pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class PessoaJuridica extends Pessoa {

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "razao_social", length = 50)
    private String razaoSocial;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String nomeFantasia, String razaoSocial) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.setDataCriacao(LocalDateTime.now());
    }

    public PessoaJuridica(String cnpj, String nomeFantasia, String razaoSocial, Conta conta) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.setDataCriacao(LocalDateTime.now());
        this.getContas().add(conta);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}

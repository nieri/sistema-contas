package br.com.munieri.sistema.contas.infraestructure.repository.pessoa;

import br.com.munieri.sistema.contas.Domain.PessoaJuridica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@DiscriminatorValue("pessoa_juridica")
public class PessoaJuridicaEntity extends PessoaEntity implements PessoaJuridica {

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "razao_social", length = 50)
    private String razaoSocial;

    public PessoaJuridicaEntity() {
    }

    public PessoaJuridicaEntity(String cnpj, String nomeFantasia, String razaoSocial) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String cnpj() {
        return this.cnpj;
    }

    @Override
    public String nomeFantasia() {
        return this.nomeFantasia;
    }

    @Override
    public String razaoSocial() {
        return this.razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}

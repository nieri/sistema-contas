package br.com.munieri.sistema.contas.Domain.pessoa;

import javax.persistence.*;

@Entity
@Table(name = "pessoa_juridica")
@DiscriminatorValue("pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id_pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    @Column(name = "cnpj", nullable = false, length = 50)
    private String cnpj;

    @Column(name = "nome_fantasia", nullable = false, length = 50)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 50)
    private String razaoSocial;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String nomeFantasia, String razaoSocial) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
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

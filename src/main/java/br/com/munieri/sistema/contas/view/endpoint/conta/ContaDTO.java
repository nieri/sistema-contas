package br.com.munieri.sistema.contas.view.endpoint.conta;

import br.com.munieri.sistema.contas.domain.conta.StatusConta;

import java.math.BigDecimal;

public class ContaDTO {

    private String nome;
    private StatusConta status;
    private String cpfCnpj;
    private BigDecimal saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusConta getStatus() {
        return status;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

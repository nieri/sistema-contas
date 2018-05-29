package br.com.munieri.sistema.contas.domain.conta;

public enum StatusConta {

    ATIVA ("ATIVA"),
    BLOQUEADA ("BLOQUEADA"),
    CANCELADA ("CANCELADA");

    private final String status;

    StatusConta(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

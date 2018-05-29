package br.com.munieri.sistema.contas.domain.transacao;

public enum TipoTransacao {

    APORTE ("APORTE"),
    TRANSFERENCIA ("TRANSFERENCIA"),
    ESTORNO ("ESTORNO");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

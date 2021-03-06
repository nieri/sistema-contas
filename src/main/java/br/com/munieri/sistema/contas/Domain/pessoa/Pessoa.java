package br.com.munieri.sistema.contas.domain.pessoa;

import br.com.munieri.sistema.contas.domain.conta.Conta;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa")
public abstract class Pessoa {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @Column(name = "id_pessoa", unique = true, nullable = false)
    protected Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Set<Conta> contas = new HashSet<>();

    @Column(name = "data_criacao", updatable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_alteracao")
    @LastModifiedDate
    private LocalDateTime dataAlteracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}

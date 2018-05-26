package br.com.munieri.sistema.contas.infraestructure.repository.pessoa;

import br.com.munieri.sistema.contas.infraestructure.repository.conta.ContaEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "pessoa")
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa")
public abstract class PessoaEntity {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private Set<ContaEntity> contas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ContaEntity> getContas() {
        return contas;
    }

    public void setContas(Set<ContaEntity> contas) {
        this.contas = contas;
    }
}

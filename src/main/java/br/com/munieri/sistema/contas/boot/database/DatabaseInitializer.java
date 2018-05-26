package br.com.munieri.sistema.contas.boot.database;

import br.com.munieri.sistema.contas.infraestructure.repository.PessoaFisicaEntity;
import br.com.munieri.sistema.contas.infraestructure.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DatabaseInitializer {

    @Autowired
    private Environment env;

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;


    @PostConstruct
    public void init() {

        PessoaFisicaEntity entity = new PessoaFisicaEntity(34866702800L, "Murilo Nieri", LocalDate.of(1985, 11, 05));
        pessoaFisicaRepository.save(entity);
    }
}

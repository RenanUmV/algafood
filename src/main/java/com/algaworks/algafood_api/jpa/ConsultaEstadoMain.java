package com.algaworks.algafood_api.jpa;

import com.algaworks.algafood_api.AlgafoodApiApplication;
import com.algaworks.algafood_api.domain.model.Estado;
import com.algaworks.algafood_api.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaEstadoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

        List<Estado> todosEstados = estadoRepository.listar();

        for (Estado estado : todosEstados) {
            System.out.println(estado.getNome());
        }
    }
}

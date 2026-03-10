package com.algaworks.algafood_api.jpa;

import com.algaworks.algafood_api.AlgafoodApiApplication;
import com.algaworks.algafood_api.domain.model.Cozinha;
import com.algaworks.algafood_api.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class BuscaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Optional<Cozinha> cozinha = cozinhaRepository.findById(1L);

        System.out.printf("%d - %s\n", cozinha.get().getId(), cozinha.get().getNome());
    }
}

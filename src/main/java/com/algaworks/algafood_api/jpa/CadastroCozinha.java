package com.algaworks.algafood_api.jpa;

import com.algaworks.algafood_api.domain.model.Cozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> list(){
        return manager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }
}

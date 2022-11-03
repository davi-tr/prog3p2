package br.edu.femass.dao;


import java.util.List;

import javax.persistence.Query;

import br.edu.femass.model.Cliente;

public class DaoCLiente extends Dao<Cliente> {

    public List<Cliente> buscarTodos(){
        return em.createQuery("select c from Cliente c order by c.nome").getResultList();
    }
    
}

package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    public Cliente(){

    }

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }

    public Long getId() {
        return id;
    }

    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.nome;
    }

}

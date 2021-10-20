package com.example.cadastrarcliente.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

    private  int id;
    private String nome;
    private String telefone;
    private String email;
    private String obs;

    public Cliente(){

    }

    public Cliente(int id, String nome, String telefone, String email, String obs) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return nome;
    }
}

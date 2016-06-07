package com.edu.ifsp.fabio.xptosa.domain;

import com.google.gson.annotations.SerializedName;


public class Departamento {
    @SerializedName("n_dep")
    private Long id;

    @SerializedName("nome_dep")
    private String nome;

    @SerializedName("local_dep")
    private String local;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

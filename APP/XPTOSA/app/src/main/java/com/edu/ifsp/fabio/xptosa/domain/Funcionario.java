package com.edu.ifsp.fabio.xptosa.domain;

import com.google.gson.annotations.SerializedName;


public class Funcionario {
    @SerializedName("n_emp")
    private long id;

    @SerializedName("nome_emp")
    private String nome;

    @SerializedName("cargo")
    private String cargo;

    @SerializedName("sal")
    private double sal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}

package com.example.luca.filtertest.Model;

import java.io.Serializable;

/**
 * Created by Luca on 19/02/2018.
 */

public class FilterPassenger implements Serializable {

    private String nome;
    private boolean check;

    public FilterPassenger(String nome, boolean check) {
        this.nome = nome;
        this.check = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCheck() {
        return check;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterPassenger that = (FilterPassenger) o;

        return nome == that.nome;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}

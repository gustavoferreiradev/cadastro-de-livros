/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Entidades;

/**
 *
 * @author gustavo
 */
public class Generos {
    
    private int codGenero;
    private String genero;

    public Generos() {
    }

    public Generos(int codGenero, String genero) {
        this.codGenero = codGenero;
        this.genero = genero;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
    
    
    
}

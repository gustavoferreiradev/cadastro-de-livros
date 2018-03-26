/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Entidades;

import javax.swing.JTextField;

/**
 *
 * @author gustavo
 */
public class Autores {
    
    private int codAutor;
    private String autor;

    public Autores() {
    }

    public Autores(int codAutor, String autor) {
        this.codAutor = codAutor;
        this.autor = autor;
    }

    public int getCodAutor() {
        return codAutor;
    }

   public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return autor;
    }

     
    
}

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
public class Editoras {
    
    private int codEditora;
    private String editora;

    public Editoras() {
    }

    public Editoras(int codEditora, String editora) {
        this.codEditora = codEditora;
        this.editora = editora;
    }

    public int getCodEditora() {
        return codEditora;
    }

    public void setCodEditora(int codEditora) {
        this.codEditora = codEditora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return editora;
    }
    
    
    
}

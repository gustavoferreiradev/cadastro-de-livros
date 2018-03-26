/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Entidades;

import java.lang.Short;




/**
 *
 * @author gustavo
 */
public class Livros {
    
    private int codLivro;
    private double isbn;
    private String titulo;
    private Autores autoresEntity;
    private Editoras editorasEntity;
    private Generos generosEntity;
    private Short ano;
    private int paginas;

    public Livros() {

    }

    public Livros(int codLivro, double isbn, String titulo, Autores autoresEntity, Editoras editorasEntity, Generos generosEntity, Short ano, int paginas) {
        this.codLivro = codLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autoresEntity = autoresEntity;
        this.editorasEntity = editorasEntity;
        this.generosEntity = generosEntity;
        this.ano = ano;
        this.paginas = paginas;
    }


    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    public double getIsbn() {
        return isbn;
    }

    public void setIsbn(double isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutoresEntity() {
        return autoresEntity;
    }

    public void setAutoresEntity(Autores autoresEntity) {
        this.autoresEntity = autoresEntity;
    }

    public Editoras getEditorasEntity() {
        return editorasEntity;
    }

    public void setEditorasEntity(Editoras editorasEntity) {
        this.editorasEntity = editorasEntity;
    }

    public Generos getGenerosEntity() {
        return generosEntity;
    }

    public void setGenerosEntity(Generos generosEntity) {
        this.generosEntity = generosEntity;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return titulo;
    }


     
}

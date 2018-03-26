/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Models;

import br.edu.utfpr.Entidades.Livros;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class LivrosTableModel extends AbstractTableModel {
    
    private static final int COL_COD = 0;
    private static final int COL_ISBN = 1;
    private static final int COL_TITULO = 2;
    private static final int COL_AUTOR = 3;
    private static final int COL_EDITORA = 4;
    private static final int COL_GENERO = 5;
    private static final int COL_ANO = 6;
    private static final int COL_PAGINAS = 7;
    private final ArrayList<Livros> arrayLivros;
    private final String[] colunas = new String[]{"Código", "ISBN", "Título","Autor", "Editora,", "Gênero", "Ano", "Páginas"};

    public LivrosTableModel(ArrayList<Livros> arrayLivros) {
        this.arrayLivros = arrayLivros;
    }

    @Override
    public int getRowCount() {
        return this.arrayLivros.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livros livro = arrayLivros.get(rowIndex);
        switch (columnIndex) {
            case COL_COD:
                return livro.getCodLivro();

            case COL_ISBN:
                return livro.getIsbn();
                
            case COL_TITULO:
                return livro.getTitulo();
                
            case COL_AUTOR:
                return livro.getAutoresEntity();
                
            case COL_EDITORA:
                return livro.getEditorasEntity();
                
            case COL_GENERO:
                return livro.getGenerosEntity();
                
            case COL_ANO:
                return livro.getAno();
            case COL_PAGINAS:
                return livro.getPaginas();
            default:
                break;
        }
        return livro;
    }

    public void addLivro(Livros livro) {
        arrayLivros.add(livro);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);

    }

    public void updateLivros(int indiceLinha, Livros livro) {
        arrayLivros.set(indiceLinha, livro);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    
}

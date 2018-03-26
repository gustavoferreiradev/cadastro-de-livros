/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Models;

import br.edu.utfpr.Entidades.Autores;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class AutoresTableModel extends AbstractTableModel {

    private static final int COL_COD = 0;
    private static final int COL_AUTORES = 1;
    private final ArrayList<Autores> arrayAutores;
    private final String[] colunas = new String[]{"Código", "Autor"};

    public AutoresTableModel(ArrayList<Autores> arrayAutores) {
        this.arrayAutores = arrayAutores;
    }



    @Override
    public int getRowCount() {
        return this.arrayAutores.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autores autor = arrayAutores.get(rowIndex);
        switch (columnIndex) {
            case COL_COD:
                return autor.getCodAutor();

            case COL_AUTORES:
                return autor.getAutor();


            default:
                break;
        }
        return autor;
    }
    
        public void addAutor(Autores autor) {
        arrayAutores.add(autor);
        int ultimoIndice = getRowCount() -1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);

    }
    
    public void updateAutor(int indiceLinha, Autores autor){
        arrayAutores.set(indiceLinha, autor);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}

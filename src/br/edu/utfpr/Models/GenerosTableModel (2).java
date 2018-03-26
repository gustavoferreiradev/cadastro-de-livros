/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Models;

import br.edu.utfpr.Entidades.Generos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class GenerosTableModel extends AbstractTableModel {

    private static final int COL_COD = 0;
    private static final int COL_GENEROS = 1;
    private final ArrayList<Generos> arrayGeneros;
    private final String[] colunas = new String[]{"Código", "Gênero"};

    public GenerosTableModel(ArrayList<Generos> arrayGeneros) {
        this.arrayGeneros = arrayGeneros;
    }

    @Override
    public int getRowCount() {
        return this.arrayGeneros.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Generos genero = arrayGeneros.get(rowIndex);
        switch (columnIndex) {
            case COL_COD:
                return genero.getCodGenero();

            case COL_GENEROS:
                return genero.getGenero();

            default:
                break;
        }
        return genero;
    }

    public void addGenero(Generos genero) {
        arrayGeneros.add(genero);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);

    }

    public void updateGeneros(int indiceLinha, Generos genero) {
        arrayGeneros.set(indiceLinha, genero);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}

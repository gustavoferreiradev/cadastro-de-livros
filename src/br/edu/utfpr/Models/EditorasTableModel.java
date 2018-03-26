/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.Models;

import br.edu.utfpr.Entidades.Editoras;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class EditorasTableModel extends AbstractTableModel {

    private static final int COL_COD = 0;
    private static final int COL_EDITORAS = 1;
    private final ArrayList<Editoras> arrayEditoras;
    private final String[] colunas = new String[]{"Código", "Editora"};

    public EditorasTableModel(ArrayList<Editoras> arrayEditoras) {
        this.arrayEditoras = arrayEditoras;
    }

    @Override
    public int getRowCount() {
        return this.arrayEditoras.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editoras editora = arrayEditoras.get(rowIndex);
        switch (columnIndex) {
            case COL_COD:
                return editora.getCodEditora();

            case COL_EDITORAS:
                return editora.getEditora();

            default:
                break;
        }
        return editora;
    }

    public void addEditora(Editoras editora) {
        arrayEditoras.add(editora);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);

    }

    public void updateEditora(int indiceLinha, Editoras editora) {
        arrayEditoras.set(indiceLinha, editora);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}

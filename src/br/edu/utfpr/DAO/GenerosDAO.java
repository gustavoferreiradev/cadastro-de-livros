/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.Entidades.Generos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class GenerosDAO extends AbstractDAO<Generos> {

    private final String INSERT = "INSERT INTO Generos (CodGenero,Genero)"
            + "VALUES (0,?)";

    private final String LISTBYCOD = "SELECT * FROM Generos WHERE CodGenero=?";

    private final String LISTBYGENERO = "SELECT * FROM Generos WHERE Genero=?";
    
    private final String LISTGENEROS = "SELECT * FROM Generos";
            

    private final String UPDATE = "UPDATE Generos SET Genero= ? WHERE CodGenero=?";

    private final String DELETE = "DELETE FROM Generos WHERE CodGenero = ?";

    public ArrayList<Generos> getGeneros() {
        try {
            abrirConnection();
            ArrayList<Generos> arrayGeneros = new ArrayList<>();
            super.preparedStatement = connection.prepareStatement(LISTGENEROS);
            super.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer codGenero = resultSet.getInt("codGenero");
                String genero = resultSet.getString("genero");

                arrayGeneros.add((new Generos(codGenero, genero)));
            }
            return arrayGeneros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados: " + ex.getMessage());
            return new ArrayList<>();

        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    public Generos getGeneroById(int codGenero) {
        Generos genero = new Generos();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYCOD);
            preparedStatement.setInt(1, codGenero);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genero.setCodGenero(resultSet.getInt("codGenero"));
                genero.setGenero(resultSet.getString("Genero"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o gênero" + ex.getMessage());
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return genero;

    }

    public Generos getGenerobyNome(Generos nome) {
        Generos genero = new Generos();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYGENERO);
            preparedStatement.setString(1, nome.getGenero());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                genero.setCodGenero(resultSet.getInt("CodGenero"));
                genero.setGenero(resultSet.getString("Genero"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os gêneros" + ex.getMessage());
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return genero;
    }

    @Override
    public boolean inserir(Generos genero) {
        try {
            super.abrirConnection();
            super.preparedStatement = super.connection.prepareStatement(INSERT);
            preparedStatement.setString(1, genero.getGenero());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o registro! " + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }
    }

    @Override
    public boolean excluir(Generos genero) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, genero.getCodGenero());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o gênero" + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }
    }

    @Override
    public boolean atualizar(Generos genero) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, genero.getGenero());
            preparedStatement.setInt(2, genero.getCodGenero());
            JOptionPane.showMessageDialog(null, "Gênero alterado com sucesso!");
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o gênero" + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }
    }

    public void remover(int id) {
        try {
            abrirConnection();
            super.preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute(); //Execute por ser método booleano, ou excluiu ou não.
        } catch (SQLException ex) {
            Logger.getLogger(GenerosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }
}

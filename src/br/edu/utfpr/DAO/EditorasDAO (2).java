/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.Entidades.Autores;
import br.edu.utfpr.Entidades.Editoras;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class EditorasDAO extends AbstractDAO<Editoras> {

    private final String INSERT = "INSERT INTO Editoras (Editora)"
            + "VALUES (?)";

    private final String LISTBYCOD = "SELECT CodEditora,Editora FROM Editoras WHERE CodEditora=?";

    private final String LISTEDITORAS = "SELECT * FROM Editoras";

    private final String LISTBYEDITORA = "SELECT * FROM Editoras WHERE Editora=?";

    private final String UPDATE = "UPDATE Editoras SET Editora=? WHERE CodEditora=?";

    private final String DELETE = "DELETE FROM Editoras WHERE CodEditora = ?";

    public ArrayList<Editoras> getEditoras() {
        try {
            abrirConnection();
            ArrayList<Editoras> arrayEditoras = new ArrayList<>();
            super.preparedStatement = connection.prepareStatement(LISTEDITORAS);
            super.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer codEditora = resultSet.getInt("codEditora");
                String editora = resultSet.getString("editora");

                arrayEditoras.add((new Editoras(codEditora, editora)));
            }
            return arrayEditoras;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados: " + ex.getMessage());
            return new ArrayList<>();

        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    public Editoras getEditoraById(int codEditora) {
        Editoras editora = new Editoras();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYCOD);
            preparedStatement.setInt(1, codEditora);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editora.setCodEditora(resultSet.getInt("codEditora"));
                editora.setEditora(resultSet.getString("Editora"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a editora" + ex.getMessage());
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return editora;

    }

    public Editoras getEditorabyNome(Editoras nome) {
        Editoras editora = new Editoras();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYEDITORA);
            preparedStatement.setString(1, nome.getEditora());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                editora.setCodEditora(resultSet.getInt("CodEditora"));
                editora.setEditora(resultSet.getString("Editora"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar as editoras" + ex.getMessage());
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return editora;
    }

    @Override
    public boolean inserir(Editoras editoras) {
        try {
            super.abrirConnection();
            super.preparedStatement = super.connection.prepareStatement(INSERT);
            preparedStatement.setString(1, editoras.getEditora());
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
    public boolean excluir(Editoras editora) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, editora.getCodEditora());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a editora" + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    @Override
    public boolean atualizar(Editoras editora) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, editora.getEditora());
            preparedStatement.setInt(2, editora.getCodEditora());
            JOptionPane.showMessageDialog(null, "Editora alterada com sucesso!");
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a editora" + ex.getMessage());
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
            JOptionPane.showMessageDialog(null, "Editora excluída com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover a editora " + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }

}

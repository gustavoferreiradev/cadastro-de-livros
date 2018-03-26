/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.Entidades.Autores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.edu.utfpr.excecoes.Excecoes;

/**
 *
 * @author gustavo
 */
public class AutoresDAO extends AbstractDAO<Autores> {

    private final String INSERT = "INSERT INTO Autores (Autor)"
            + "VALUES (?)";

    private final String LISTBYCOD = "SELECT * FROM Autores WHERE CodAutor=?";

    private final String LISTBYAUTOR = "SELECT * FROM Autores WHERE Autor=?";

    private final String LISTAUTORES = "SELECT Autores.CodAutor,Autores.Autor FROM Autores";

    private final String UPDATE = "UPDATE Autores SET Autor= ? WHERE CodAutor=?";

    private final String DELETE = "DELETE FROM Autores WHERE CodAutor = ?";

    public ArrayList<Autores> getAutores() {
        try {
            abrirConnection();
            ArrayList<Autores> arrayAutores = new ArrayList<>();
            super.preparedStatement = connection.prepareStatement(LISTAUTORES);
            super.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer codAutor = resultSet.getInt("codAutor");
                String autor = resultSet.getString("autor");

                arrayAutores.add((new Autores(codAutor, autor)));
            }
            return arrayAutores;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados: " + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
            return new ArrayList<>();

        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    public ArrayList<Autores> getAutoresId(int cod) {
        try {
            abrirConnection();
            ArrayList<Autores> arrayAutores = new ArrayList<>();
            super.preparedStatement = connection.prepareStatement(LISTBYCOD);
            super.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                resultSet.getInt(cod);
                String autor = resultSet.getString("autor");

                arrayAutores.add((new Autores(cod, autor)));
            }
            return arrayAutores;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados: " + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
            return new ArrayList<>();

        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    public Autores getAutorById(int codAutor) {
        Autores autor = new Autores();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYCOD);
            preparedStatement.setInt(1, codAutor);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                autor.setCodAutor(resultSet.getInt("codAutor"));
                autor.setAutor(resultSet.getString("Autor"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o autor" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return autor;

    }

    public Autores getAutorbyNome(Autores nome) {
        Autores autor = new Autores();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYAUTOR);
            preparedStatement.setString(1, nome.getAutor());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                autor.setCodAutor(resultSet.getInt("CodAutor"));
                autor.setAutor(resultSet.getString("Autor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os autores" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

        return autor;
    }

    @Override
    public boolean inserir(Autores autor) {
        try {
            super.abrirConnection();
            super.preparedStatement = super.connection.prepareStatement(INSERT);
            preparedStatement.setString(1, autor.getAutor());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o registro! " + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }
    }

    @Override
    public boolean excluir(Autores autor) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, autor.getCodAutor());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o gênero" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }
    }

    @Override
    public boolean atualizar(Autores autor) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, autor.getAutor());
            preparedStatement.setInt(2, autor.getCodAutor());
            JOptionPane.showMessageDialog(null, "Autor alterado com sucesso!");
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o gênero" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
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
            JOptionPane.showMessageDialog(null, "Erro ao remover o autor");
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }
}

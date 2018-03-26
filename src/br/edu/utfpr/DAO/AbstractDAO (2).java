package br.edu.utfpr.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.edu.utfpr.conexao.Conexao;
import br.edu.utfpr.excecoes.Excecoes;

public abstract class AbstractDAO<T extends Object> {

    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public abstract boolean inserir(T object);

    public abstract boolean excluir(T object);

    public abstract boolean atualizar(T object);

    protected void abrirConnection() throws SQLException {
        if ((connection == null) || (connection.isClosed())) {
            connection = new Conexao().getConnection();
        }
    }

    protected void fecharConnection() {
        try {
            if ((connection != null) || (!connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar" + "a conexão" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        }
    }

    protected void fecharPreparedStatement() {
        try {
            if ((preparedStatement != null) || (!preparedStatement.isClosed())) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar" + "preparedStatement" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        }
    }

    protected void fecharResultSet() {
        try {
            if ((resultSet != null) || (!resultSet.isClosed())) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar" + "resultSet" + ex.getMessage());
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        }
    }
}

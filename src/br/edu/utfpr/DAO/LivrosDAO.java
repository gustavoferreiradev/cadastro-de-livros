/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.Entidades.Autores;
import br.edu.utfpr.Entidades.Editoras;
import br.edu.utfpr.Entidades.Generos;
import br.edu.utfpr.Entidades.Livros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class LivrosDAO extends AbstractDAO<Livros> {

    private final String INSERT = "INSERT INTO Livros (ISBN,Titulo,codAutor,CodEditora,CodGenero,Ano,Paginas)"
            + "VALUES (?,?,?,?,?,?,?)";

    private final String LISTLIVROS = "SELECT Livros.*, Autores.Autor, Editoras.Editora, Generos.Genero "
            + "FROM Livros "
            + "INNER JOIN Autores ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Editoras ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Generos ON Livros.CodGenero = Generos.CodGenero";

    private final String LIVROSAUTOR = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "ORDER BY Livros.CodLivro";

    private final String LIVROSEDITORA = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "ORDER BY Livros.CodLivro";

    private final String LIVROSGENERO = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "ORDER BY Livros.CodLivro";

    private final String UPDATE = "UPDATE Livros "
            + "SET ISBN=?, Titulo=?, CodAutor=?, CodEditora=?, CodGenero=?, Ano=?, Paginas=? WHERE codLivro=?";

    private final String LISTBYID = "SELECT Livros.*, Autores.Autor, Editoras.Editora, Generos.Genero "
            + "FROM Livros "
            + "INNER JOIN Autores ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Editoras ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Generos ON Livros.CodGenero = Generos.CodGenero "
            + "WHERE CodLivro=?";

    private final String LISTBYNOME = "SELECT Livros.*, Autores.Autor, Editoras.Editora, Generos.Genero "
            + "FROM Livros "
            + "INNER JOIN Autores ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Editoras ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Generos ON Livros.CodGenero = Generos.CodGenero"
            + "WHERE Livros.Titulo=?";

    private final String LISTBYAUTOR = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "WHERE Autores.Autor=?";

    private final String LISTBYEDITORA = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "WHERE Editoras.Editora=?";

    private final String LISTBYGENERO = "SELECT Livros.CodLivro, Livros.ISBN, Livros.Titulo, Autores.Autor, Editoras.Editora, Generos.Genero, Livros.Ano, Livros.Paginas "
            + "FROM Livros "
            + "INNER JOIN Livros ON Livros.CodAutor = Autores.CodAutor "
            + "INNER JOIN Livros ON Livros.CodEditora = Editoras.CodEditora "
            + "INNER JOIN Livros ON Livros.CodGenero = Generos.CodGenero "
            + "WHERE Generos.Genero=?";

    private final String DELETE = "DELETE FROM Livros WHERE codLivro =?";

    public ArrayList<Livros> getLivros() {

        try {
            abrirConnection();
            ArrayList<Livros> arrayLivros = new ArrayList<>();
            super.preparedStatement = connection.prepareStatement(LISTLIVROS);
            super.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("CodLivro");
                Double isbn = resultSet.getDouble("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("CodAutor");
                String Autor = resultSet.getString("Autor");

                Integer codEditora = resultSet.getInt("CodEditora");
                String Editora = resultSet.getString("Editora");

                Integer codGenero = resultSet.getInt("CodGenero");
                String Genero = resultSet.getString("Genero");

                Short ano = resultSet.getShort("Ano");
                Integer paginas = resultSet.getInt("Paginas");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                arrayLivros.add(new Livros(codigoLivro, isbn, titulo, autor, editora, genero, ano, paginas));

            }
            return arrayLivros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados" + ex.getMessage());
            return new ArrayList<>();

        } finally {
            fecharResultSet();
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    public Livros getLivrosById(int id) {
        Livros livro = new Livros();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("codLivro");
                Double isbn = resultSet.getDouble("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("codAutor");
                String Autor = resultSet.getString("Autor");
                Integer codEditora = resultSet.getInt("codEditora");
                String Editora = resultSet.getString("Editora");
                Integer codGenero = resultSet.getInt("codGenero");
                String Genero = resultSet.getString("Genero");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                Integer ano = resultSet.getInt("Ano");
                Integer paginas = resultSet.getInt("Paginas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o livro." + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharResultSet();
            fecharConnection();
        }
        return livro;
    }

    public Livros getLivrosByNome(Livros liv) {
        Livros livro = new Livros();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYNOME);
            preparedStatement.setString(1, liv.getTitulo());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("codLivro");
                Double isbn = resultSet.getDouble("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("codAutor");
                String Autor = resultSet.getString("Autor");
                Integer codEditora = resultSet.getInt("codEditora");
                String Editora = resultSet.getString("Editora");
                Integer codGenero = resultSet.getInt("codGenero");
                String Genero = resultSet.getString("Genero");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                Integer ano = resultSet.getInt("Ano");
                Integer paginas = resultSet.getInt("Paginas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o livro " + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharResultSet();
            fecharConnection();
        }
        return livro;
    }

    public Livros getLivrosByAutor(Livros liv) {
        Livros livro = new Livros();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYNOME);
            preparedStatement.setString(1, liv.getAutoresEntity().getAutor());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("codLivro");
                Integer isbn = resultSet.getInt("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("codAutor");
                String Autor = resultSet.getString("Autor");
                Integer codEditora = resultSet.getInt("codEditora");
                String Editora = resultSet.getString("Editora");
                Integer codGenero = resultSet.getInt("codGenero");
                String Genero = resultSet.getString("Genero");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                Integer ano = resultSet.getInt("Ano");
                Integer paginas = resultSet.getInt("Paginas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o livro." + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharResultSet();
            fecharConnection();
        }
        return livro;
    }

    public Livros getLivrosByEditora(Livros liv) {
        Livros livro = new Livros();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYNOME);
            preparedStatement.setString(1, liv.getEditorasEntity().getEditora());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("codLivro");
                Double isbn = resultSet.getDouble("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("codAutor");
                String Autor = resultSet.getString("Autor");
                Integer codEditora = resultSet.getInt("codEditora");
                String Editora = resultSet.getString("Editora");
                Integer codGenero = resultSet.getInt("codGenero");
                String Genero = resultSet.getString("Genero");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                Integer ano = resultSet.getInt("Ano");
                Integer paginas = resultSet.getInt("Paginas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o livro." + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharResultSet();
            fecharConnection();
        }
        return livro;
    }

    public Livros getLivrosByGenero(Livros liv) {
        Livros livro = new Livros();
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(LISTBYNOME);
            preparedStatement.setString(1, liv.getGenerosEntity().getGenero());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codigoLivro = resultSet.getInt("codLivro");
                Double isbn = resultSet.getDouble("ISBN");
                String titulo = resultSet.getString("Titulo");

                Integer codAutor = resultSet.getInt("codAutor");
                String Autor = resultSet.getString("Autor");
                Integer codEditora = resultSet.getInt("codEditora");
                String Editora = resultSet.getString("Editora");
                Integer codGenero = resultSet.getInt("codGenero");
                String Genero = resultSet.getString("Genero");

                Autores autor = new Autores(codAutor, Autor);
                Editoras editora = new Editoras(codEditora, Editora);
                Generos genero = new Generos(codGenero, Genero);

                Integer ano = resultSet.getInt("Ano");
                Integer paginas = resultSet.getInt("Paginas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o livro." + ex.getMessage());
        } finally {
            fecharPreparedStatement();
            fecharResultSet();
            fecharConnection();
        }
        return livro;
    }

    @Override
    public boolean inserir(Livros livro) {
        try {
            super.abrirConnection();
            super.preparedStatement = super.connection.prepareStatement(INSERT);
            preparedStatement.setDouble(1, livro.getIsbn());
            preparedStatement.setString(2, livro.getTitulo());
            preparedStatement.setInt(3, livro.getAutoresEntity().getCodAutor());
            preparedStatement.setInt(4, livro.getEditorasEntity().getCodEditora());
            preparedStatement.setInt(5, livro.getGenerosEntity().getCodGenero());
            preparedStatement.setShort(6, livro.getAno());
            preparedStatement.setInt(7, livro.getPaginas());
            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o registro" + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    @Override
    public boolean excluir(Livros livro) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, livro.getCodLivro());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir livro" + ex.getMessage());
            return false;
        } finally {
            fecharPreparedStatement();
            fecharConnection();
        }

    }

    @Override
    public boolean atualizar(Livros livro) {
        try {
            abrirConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setDouble(1, livro.getIsbn());
            preparedStatement.setString(2, livro.getTitulo());
            preparedStatement.setInt(3, livro.getAutoresEntity().getCodAutor());
            preparedStatement.setInt(4, livro.getEditorasEntity().getCodEditora());
            preparedStatement.setInt(5, livro.getGenerosEntity().getCodGenero());
            preparedStatement.setShort(6, livro.getAno());
            preparedStatement.setInt(7, livro.getPaginas());
            preparedStatement.setInt(8, livro.getCodLivro());
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os livros" + ex.getMessage());

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

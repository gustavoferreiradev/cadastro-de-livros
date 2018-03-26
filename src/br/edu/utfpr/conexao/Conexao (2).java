/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.conexao;

import br.edu.utfpr.excecoes.Excecoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author gustavo
 */
public class Conexao {

    private Connection connection;
    private final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/GUSTAVOFERREIRADASILVA";
    private final String USUARIO = "phpmyadmin";
    private final String SENHA = "#$%GFma";

    public Conexao() {

        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            Excecoes log = new Excecoes();
            log.gravaLog(ex);
        }

    }

    public Connection getConnection() {
        return connection;
    }

}

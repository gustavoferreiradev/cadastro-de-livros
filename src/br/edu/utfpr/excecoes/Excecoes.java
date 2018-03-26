/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.excecoes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class Excecoes {

    public void gravaLog(Exception ex) {
        FileWriter excecao = null;
        try {
            excecao = new FileWriter(System.getProperty("user.dir") + "/src/log.txt",true);
            PrintWriter gravar = new PrintWriter(excecao);
            gravar.println(ex);
            gravar.close();
            JOptionPane.showMessageDialog(null, "Log gravado com sucesso!");
        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar o log!");

        } finally {
            try {
                excecao.close();
            } catch (IOException ex1) {
                JOptionPane.showMessageDialog(null, "Erro ao garavar o log!");
            }
        }

    }

}

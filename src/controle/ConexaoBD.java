/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fabricio.correia
 */
public class ConexaoBD {
    public Statement stm;
    public ResultSet rs;
    public String driver = "org.postgresql.Driver";
    public String caminho = "jdbc:postgresql://localhost:5432/clinica";
    public String usuario = "postgres";
    public String senha = "SGCtimeunifacs9001";
    public Connection con;
    
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario,senha);
            JOptionPane.showMessageDialog(null, "conectado ao banco de dados");
            System.out.println("conectado ao banco de dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao conecar ao ao banco de dados /n"+ex.getMessage());
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



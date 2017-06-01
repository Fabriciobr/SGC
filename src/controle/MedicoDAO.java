/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Medico;

/**
 *
 * @author fabricio.correia
 */
public class MedicoDAO {
    
    ConexaoBD conexao = new ConexaoBD();
    
    public MedicoDAO(){
        conexao.conexao();
    }
    
    public void Salvar(Medico medico){
        try {
           
            PreparedStatement stm = conexao.con.prepareStatement("insert into medico (nome, especializacao, crm) values(?,?,?)");
            stm.setString(1,medico.getNome());
            stm.setString(2, medico.getEspecializacao());
            stm.setInt(3, medico.getCrm());
            stm.execute();
            JOptionPane.showInputDialog("Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("erro ao cadastrar /n"+ex.getMessage());
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


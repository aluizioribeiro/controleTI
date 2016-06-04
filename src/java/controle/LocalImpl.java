/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConnectionFactory;
import dao.LocalDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Local;

/**
 *
 * @author Aluizio Ribeiro
 */
public class LocalImpl implements LocalDao{
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void salvar(Local l) {
        String sql = "INSERT INTO local (nome) VALUES(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getNome());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Local l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Local l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Local> getListAll() {
        List<Local> list = new ArrayList<>();
        String sql = "SELECT id, nome FROM local ORDER BY nome";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Local l = new Local();
                l.setId(rs.getInt(1));
                l.setNome(rs.getString(2));
                
                list.add(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    @Override
    public Local findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

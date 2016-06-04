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

import dao.TonerDao;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Toner;

/**
 *
 * @author TI-01
 */
public class TonerImpl implements TonerDao {
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void salvar(Toner t) {
        String sql = "INSERT INTO Toner (nome, idtoner) VALUES(?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getLocal().getId());
            
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(TonerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Toner t) {
        String sql = "UPDATE toner set nome =?, idlocal = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getLocal().getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TonerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void remover(Toner t) {
        String sql = "DELETE FROM toner WHERE id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, t.getId());
            
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(TonerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public List<Toner> getListAll() {
        List<Toner> listToner = new ArrayList<>();
        String sql = "Select id, nome, idlocal from toner order by nome";
        try {
            stmt = conn.prepareStatement(sql);
            rs  = stmt.executeQuery();
            
            while(rs.next()){
                Toner t = new Toner();
                t.setId(rs.getInt(1));
                t.setNome(rs.getString(2));
                t.getLocal().setId(rs.getInt(3));
                
                listToner.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TonerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listToner;
    }

    @Override
    public Toner findById(int id) {
        String sql = "SELECT id, nome, idestado, estado.nome FROM cidade, estado "
                + " WHERE idestado = estado.id AND id = ?";
        Toner t = new Toner();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.next();
            t.setId(rs.getInt(1));
            t.setNome(rs.getString(2));
            
            t.getLocal().setId(rs.getInt(3));
            t.getLocal().setNome(rs.getString(4));
            
        } catch (SQLException ex) {
            Logger.getLogger(TonerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return t;
    }
}

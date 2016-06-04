/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ImpressoraDao;
import dao.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Impressora;

public class ImpressoraImpl implements ImpressoraDao {
	
	Connection conn = ConnectionFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs;

	@Override
	public void salvar(Impressora impressora) {
		try {
			String sql = "insert into impressora "
                                + "(marca, modelo, local) values(?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, impressora.getMarca());
                        stmt.setString(2, impressora.getModelo());
                        stmt.setString(2, impressora.getLocal());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Impressora  impressora) {
		// TODO Auto-generated method stub
            String sql = "update impressora set marca = ?, modelo = ?, local = ? "
                    + "where id = ?";
            try {
                stmt = conn.prepareStatement(sql);
                
                stmt.setString(1, impressora.getMarca());
                stmt.setString(2, impressora.getModelo());
                stmt.setString(2, impressora.getModelo());
                stmt.setInt(3, impressora.getId());
                
                stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
	}

	@Override
	public void remover(Impressora impressora) {
		// TODO Auto-generated method stub
            String sql = "delete from impressora where id = ?";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, impressora.getId());
                
                stmt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
	}

	@Override
	public List<Impressora> getListAll() {
		List<Impressora> list = new ArrayList<Impressora>();
		try {
			String sql = "select id, marca, modelo, local from contato";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Impressora impressora = new Impressora();
				impressora.setId(rs.getInt(1));
				impressora.setMarca(notNull(rs.getString(2)));
                                impressora.setModelo(notNull(rs.getString(3)));
                                impressora.setLocal(notNull(rs.getString(4)));
				
				list.add(impressora);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Impressora findById(int id) {
		String sql = "select id, marca, modelo, local from contato where id = ?";
                Impressora impressora = new Impressora();
                try{
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, id);
                    rs = stmt.executeQuery();
                    rs.next();
                    impressora.setId(rs.getInt(1));
                    impressora.setMarca(notNull(rs.getString(2)));
                    impressora.setModelo(notNull(rs.getString(3)));
                    impressora.setLocal(notNull(rs.getString(4)));
                }catch (SQLException e) {
			e.printStackTrace();
		}
		return impressora;
	}
        
        private String notNull(String v){
            if(v == null)
                return "";
            return v;
        }

}

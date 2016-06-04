/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Toner;

/**
 *
 * @author Aluizio Ribeiro
 */
public interface TonerDao {
    
    public void salvar(Toner t);
    public void atualizar(Toner t);
    public void remover(Toner t);
    public List<Toner> getListAll();
    public Toner findById(int id);
    
    
}

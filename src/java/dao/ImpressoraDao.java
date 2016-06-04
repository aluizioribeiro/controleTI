/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import modelo.Impressora;

/**
 *
 * @author TI-01
 */
public interface ImpressoraDao {
	
	public void salvar(Impressora impressora);
	public void atualizar(Impressora impressora);
	public void remover(Impressora impressora);
	public List<Impressora> getListAll();
	public Impressora findById(int id);

}

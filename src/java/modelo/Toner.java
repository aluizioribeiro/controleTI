/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author TI-01
 */
public class Toner {
    
    private int id;
    private String nome;
    private Local local;

    public Toner() {
        local = new Local();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local getLocal() {
        return local;
    }

    public void setEstado(Local local) {
        this.local = local;
    }
    
    
}

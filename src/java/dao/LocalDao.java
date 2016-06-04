
package dao;

import java.util.List;
import modelo.Local;

/**
 *
 * @author Maicon
 */
public interface LocalDao {
    
    public void salvar(Local l);
    public void atualizar(Local l);
    public void remover(Local l);
    public List<Local> getListAll();
    public Local findById(int id);
    
}

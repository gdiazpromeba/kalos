package kalos.datos.dao;

import java.util.List;

import kalos.beans.PreposicionBean;

public interface PreposicionesDAO {

	/* (non-Javadoc)
	 * @see kalos.dao.AdjetivoDAO#getTodos()
	 */
	List<PreposicionBean> getTodas();
	List<String> seleccionaTodosLosIds();
	
    List<PreposicionBean> getRegistros(List<String> ids);
    
    void modifica(PreposicionBean preposicion);
    void inserta(PreposicionBean preposicion);
    void borra(String id);

    List<PreposicionBean> seleccionaPreposicionesNoAcentuables();
    

    List<PreposicionBean> seleccionaPorFormaParaAM(String forma);
    
}
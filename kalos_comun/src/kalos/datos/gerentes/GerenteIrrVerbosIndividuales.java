package kalos.datos.gerentes;

import java.util.List;

import kalos.beans.IrrVerboIndividual;
import kalos.enumeraciones.Particularidad;

public interface GerenteIrrVerbosIndividuales extends Reseleccionable{
	
	List<IrrVerboIndividual> seleccionaPorVerboPartic(String verboId, Particularidad partic);
	
	List<IrrVerboIndividual> seleccionaPorForma(String forma);
	
	List<String> seleccionaIdsPorVerboPartic(String verboId, Particularidad partic);
	
	void inserta(IrrVerboIndividual bean);
	
	void modifica(IrrVerboIndividual bean);
	
	void borra(String pk);
	
	List<IrrVerboIndividual> getBeans(List<String> ids);
	
	
}

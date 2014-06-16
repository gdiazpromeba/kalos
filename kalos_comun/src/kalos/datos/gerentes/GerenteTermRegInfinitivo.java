package kalos.datos.gerentes;

import java.util.List;

import kalos.beans.TermRegInfinitivo;

public interface GerenteTermRegInfinitivo {

	List<TermRegInfinitivo> seleccionaPorTerminacion(String terminacion);

	void inserta(TermRegInfinitivo bean);
	
	void borraTodo();
}
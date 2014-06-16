package kalos.datos.gerentes;

import java.util.List;

import kalos.beans.TransParticipiosBean;

public interface GerenteTransParticipios {

	List<TransParticipiosBean> seleccionaTodos();
	List<TransParticipiosBean> seleccionaPorSubstraer(String forma);

}
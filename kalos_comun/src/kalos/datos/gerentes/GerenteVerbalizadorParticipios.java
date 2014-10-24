package kalos.datos.gerentes;

import java.util.List;

import kalos.beans.VerbalizadorBean;
import kalos.datos.dao.VerbalizadorParticipiosDAO;

public interface GerenteVerbalizadorParticipios {

    /* (non-Javadoc)
     * @see kalos.datos.gerentes.GerenteVerbalizadorParticipios#seleccionaPorTerminacionGenitivo(java.lang.String)
     */
    public abstract List<VerbalizadorBean> seleccionaPorTerminacionGenitivo(String terminacionGenitivo);

    /* (non-Javadoc)
     * @see kalos.datos.gerentes.GerenteVerbalizadorParticipios#seleccionaPorTerminacionNominativo(java.lang.String)
     */
    public abstract List<VerbalizadorBean> seleccionaPorTerminacionNominativo(String terminacionNominativo);

    /**
     * @param verbalizadorParticipiosDAO The verbalizadorParticipiosDAO to set.
     */
    public abstract void setVerbalizadorParticipiosDAO(VerbalizadorParticipiosDAO verbalizadorParticipiosDAO);

}
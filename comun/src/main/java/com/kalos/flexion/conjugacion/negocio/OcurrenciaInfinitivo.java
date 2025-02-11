
package com.kalos.flexion.conjugacion.negocio;

/**
 * Title:        Kalos
 * Description:  Greek verb conjugation and research tool
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Mariana Esplugas and Gonzalo Díaz
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

import com.kalos.enumeraciones.Aspecto;
import com.kalos.enumeraciones.FuerteDebil;
import com.kalos.enumeraciones.Voz;

/**
 * Estructura para guardar las formas de infinitivo. 
 * Hay una por particularidad.
 * @author gonzy
 */
public class OcurrenciaInfinitivo {

    @SuppressWarnings("unchecked")
    List<String>[][][] formas = new List[4][6][2]; //voz, aspecto fuerte

    public List<String> getFormas(Voz voz, Aspecto aspecto, FuerteDebil fuerte) {
        int iVoz = voz.valorEntero();
        int iFuerte = fuerte.valorEntero();
        int iAspecto = aspecto.valorEntero();
        try {
            return formas[iVoz][iAspecto][iFuerte];
        } catch (ArrayIndexOutOfBoundsException ex) {
            StringBuffer mensaje = new StringBuffer(
                    "error en getForma: fuera del array al tratar de obtener la siguiente forma : \n");
            mensaje.append("      voz=" + voz + "\n");
            mensaje.append("      aspecto=" + aspecto + "\n");
            mensaje.append("      modo=" + fuerte + "\n");
            mensaje.append(ex.getStackTrace().toString());
            return null;
        }
    }

    public String getFormaIndividual(Voz voz, Aspecto aspecto, FuerteDebil fuerte, int subindice) {
        int iVoz = voz.valorEntero();
        int iFuerte = fuerte.valorEntero();
        int iAspecto = aspecto.valorEntero();
        return (String) formas[iVoz][iAspecto][iFuerte].get(subindice);
    }

    /*
    public void addFormaIndividual(Voz voz, Aspecto aspecto, FuerteDebil fuerte, String cadena) {
    	int iVoz = Voz.getInt(voz);
    	int iFuerte=fuerte.valorEntero();
    	int iAspecto=Aspecto.getInt(aspecto);
    	if (formas[iVoz][iAspecto][iFuerte] == null)
    		formas[iVoz][iAspecto][iFuerte] = new ArrayList();
    	formas[iVoz][iAspecto][iFuerte].add(cadena);
    }
    */

    /**
     * Agrega una forma en el subíndice especificado, o crea la lista y agrega en el índice si la lista
     * no existía.
     * @param voz
     * @param fuerte
     * @param subindice
     * @param cadena
     */
    public void agregaFormaIndividual(Voz voz, Aspecto aspecto, FuerteDebil fuerte, String cadena, int subindice) {
        int iVoz = voz.valorEntero();
        int iFuerte = fuerte.valorEntero();
        int iAspecto = aspecto.valorEntero();
        if (formas[iVoz][iAspecto][iFuerte] == null) {
            formas[iVoz][iAspecto][iFuerte] = new ArrayList<String>();
        }
        List<String> listaFormas = formas[iVoz][iAspecto][iFuerte];
        while (listaFormas.size() <= subindice) {
            listaFormas.add(null);
        }
        listaFormas.set(subindice, cadena);
    }

    public void setFormaIndividual(Voz voz, Aspecto aspecto, FuerteDebil fuerte, int subindice, String cadena) {
        int iVoz = voz.valorEntero();
        int iFuerte = fuerte.valorEntero();
        int iAspecto = aspecto.valorEntero();
        formas[iVoz][iAspecto][iFuerte].set(subindice, cadena);
    }

    public int getCantidadDeFormas(Voz voz, Aspecto aspecto, FuerteDebil fuerte) {
        int iVoz = voz.valorEntero();
        int iFuerte = fuerte.valorEntero();
        int iAspecto = aspecto.valorEntero();
        if (formas[iVoz][iAspecto][iFuerte] == null)
            return 0;
        else
            return formas[iVoz][iAspecto][iFuerte].size();
    }

}

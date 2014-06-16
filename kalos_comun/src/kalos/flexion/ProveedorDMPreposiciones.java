/*
 * Created on May 4, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package kalos.flexion;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kalos.beans.PreposicionBean;
import kalos.beans.Significado;
import kalos.datos.gerentes.GerentePreposiciones;
import kalos.enumeraciones.Caso;
import kalos.enumeraciones.Idioma;
import kalos.operaciones.OpPalabras;
import kalos.recursos.CadenasEnum;
import kalos.recursos.Configuracion;

/**
 * 
 * Representa el contacto del paquete de conjugación con el exterior. Su
 * objetivo es proveer representaciones de la conjugación de un verbo o
 * infinitivo, via dataModules Estos datamodules presentan el dato bruto, sin
 * rotar ni seleccionar ni transformar en renderers de celda Su interfaz con el
 * mundo exterior (fuera de este paquete) debe ser la clase
 * CreadorTableModelsGrilla
 * 
 * @author GDiaz
 * 
 */
public class ProveedorDMPreposiciones {

    private GerentePreposiciones gerentePreposiciones;

    /**
     * Produce un tablemodel con todas las filas de ese tipo de partícula
     * 
     * @param tipo
     * @return
     */
    public DefaultTableModel getTMModeloPreposiciones() {
        DefaultTableModel tm = new DefaultTableModel(new String[]{"PARTICULARIDAD", "ORDEN", "FORMA", "SIGNIFICADO", "CASOS" }, 0);
        List<PreposicionBean> beans = gerentePreposiciones.seleccionaTodos();
        for (PreposicionBean bean : beans) {
            Significado sig=bean.getSignificados().get(Idioma.getEnum(Configuracion.getIdiomaSignificados()));
            String valorSignificado=sig.getValor();
            StringBuffer casos=new StringBuffer();
            if (bean.isAcusativo()){
                casos.append(CadenasEnum.getCadena(Caso.Acusativo));
            }
            if (bean.isGenitivo()){
                if (casos.length()>0)
                    casos.append(", ");
                casos.append(CadenasEnum.getCadena(Caso.Genitivo));
            }
            if (bean.isDativo()){
                if (casos.length()>0)
                    casos.append(", ");
                casos.append(CadenasEnum.getCadena(Caso.Dativo));
            }

            tm.addRow(new Object[]{
                    bean.getParticularidad(), 
                    bean.getOrden(),
                    OpPalabras.strBetaACompleto(bean.getFormaDiccionario()),
                    valorSignificado,
                    casos.toString(),
            });
        }
        return tm;
    }
    
  

    public void setGerentePreposiciones(GerentePreposiciones gerentePreposiciones) {
        this.gerentePreposiciones = gerentePreposiciones;
    }

}

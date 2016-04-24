package com.kalos.datos.gerentes;import java.util.ArrayList;import java.util.Collections;import java.util.HashSet;import java.util.Iterator;import java.util.List;import java.util.Set;import org.apache.log4j.Logger;import com.kalos.beans.ReferenciaVerboSimple;import com.kalos.beans.TipoJerarquico;import com.kalos.beans.VerboBean;import com.kalos.beans.VerboSimpleCompuesto;import com.kalos.datos.dao.IrrVerbosDAO;import com.kalos.datos.dao.IrrVerbosIndividualesDAO;import com.kalos.datos.dao.VerbosDAO;import com.kalos.enumeraciones.LugarSubcadena;import com.kalos.enumeraciones.Particularidad;import com.kalos.operaciones.OpPalabras;import com.kalos.operaciones.comparadores.ComparadorBeansGriegos;public class GerenteVerbosImpl implements GerenteVerbos {    private VerbosDAO verbosDAO;    private IrrVerbosDAO irrVerbosDAO;    private IrrVerbosIndividualesDAO irrVerbosIndividualesDAO;    private Object[] M;    private String N;    private GerenteSignificados gerenteSignificados;    private GerentePreposicionesEnVerbos gerentePreposicionesEnVerbos;    private GerenteVerbosCompuestos gerenteVerbosCompuestos;    Logger O = Logger.getLogger(getClass().getName());    public List<VerboBean> getBeans(List<String> paramList) {        return this.verbosDAO.getRegistros(paramList);    }    public List<String> seleccionaPorLetra(String paramString) {        List<String> localList = this.verbosDAO.seleccionaPorLetra(paramString);        this.N = "seleccionaPorLetra";        this.M = new Object[] { paramString };        return localList;    }    public List<String> seleccionaPorVerbo(String paramString, LugarSubcadena paramh) {        List<String> localList = this.verbosDAO.seleccionaPorVerbo(paramString, paramh);        return localList;    }    public List<VerboBean> seleccionaPorVerboParaAM(String paramString) {        List<VerboBean> localList = this.verbosDAO.seleccionaPorVerboParaAM(paramString);        return localList;    }    public List<VerboBean> seleccionaPorIdsParaAM(List<String> paramList) {        List<VerboBean> localList = this.verbosDAO.getRegistrosSinSignificado(paramList);        return localList;    }    public List<String> seleccionaPorTipos(Integer[] paramArrayOfInteger) {        List<String> localList = this.verbosDAO.seleccionaPorTipos(paramArrayOfInteger);        return localList;    }    public List<String> seleccionaPorTipos(List<TipoJerarquico> paramList) {        Integer[] arrayOfInteger = new Integer[paramList.size()];        for (int i = 0; i < arrayOfInteger.length; i++) {            TipoJerarquico locale = paramList.get(i);            arrayOfInteger[i] = Integer.valueOf(locale.getCodigo());        }        List<String> localList = this.verbosDAO.seleccionaPorTipos(arrayOfInteger);        return localList;    }    public void inserta(VerboBean paramh) {        this.verbosDAO.inserta(paramh);        this.gerenteSignificados.refresca(paramh);    }    public void borra(String paramString) {        this.verbosDAO.borra(paramString);        this.gerenteSignificados.borraSignificadosDelReferente(paramString);    }    public void actualiza(VerboBean paramh) {        this.verbosDAO.modifica(paramh);        this.gerenteSignificados.refresca(paramh);    }    public VerboBean seleccionaUno(String paramString) {        VerboBean localh = this.verbosDAO.seleccionaInidvidual(paramString);        return localh;    }    public VerboBean seleccionaIndividualSinSignificado(String paramString) {        VerboBean localh = this.verbosDAO.seleccionaInidvidualParaAM(paramString);        return localh;    }    public List<String> reseleccionar() {        if (this.N.equals("seleccionaPorLetra")) {            String str = (String) this.M[0];            return seleccionaPorLetra(str);        }        throw new RuntimeException("reselección no especificada");    }    public void ordena(String paramString) {        this.verbosDAO.modificaCodigosTodos(paramString);        this.O.info("códigos modificados");        List<String> localList1 = this.verbosDAO.seleccionaPorLetra(paramString);        this.O.info("selección por letra efectuada");        List<VerboBean> verboBeans = this.verbosDAO.getRegistros(localList1);        this.O.info("registros obtenidos");        String[] arrayOfString = { "verbo" };        for (VerboBean bean : verboBeans) {            bean.setVerbo(OpPalabras.strBetaACompleto(bean.getVerbo()));        }        this.O.info("pasaje a beta completado");        Collections.sort(verboBeans, new ComparadorBeansGriegos(arrayOfString));        this.O.info("ordenamiento completado");        int i = 10;        Iterator<VerboBean> localIterator = verboBeans.iterator();        while (localIterator.hasNext()) {            VerboBean localh = (VerboBean) localIterator.next();            String str = localh.getId();            this.verbosDAO.modificaCodigoIndividual(i, str);            i += 10;        }        this.O.info("modificación de códigos individuales completada");    }    public void setUltimosParametros(Object[] paramArrayOfObject) {        this.M = paramArrayOfObject;    }    public Object[] getUltimosParametros() {        return this.M;    }    public String getUltimaSeleccion() {        return this.N;    }    public void setUltimaSeleccion(String paramString) {        this.N = paramString;    }    public VerbosDAO getVerbosDAO() {        return this.verbosDAO;    }    public void setVerbosDAO(VerbosDAO paramW) {        this.verbosDAO = paramW;    }    public void setGerenteSignificados(GerenteSignificados paramn) {        this.gerenteSignificados = paramn;    }    public void actualizaReferenciaVerboSimple(String paramString, ReferenciaVerboSimple params) {        this.gerentePreposicionesEnVerbos.borraPorVerbo(paramString);        List<String> localList = params.getPreposiciones();        if ((localList != null) && (localList.size() > 0)) {            this.gerentePreposicionesEnVerbos.inserta(paramString, localList);        }        this.gerenteVerbosCompuestos.borraPorVerboCompuesto(paramString);        if ((params != null) && (params.getEntradaVerboSimple() != null)) {            VerboSimpleCompuesto localH = new VerboSimpleCompuesto();            localH.setIdVerboSimple(params.getEntradaVerboSimple().getId());            localH.setIdVerboCompuesto(paramString);            this.gerenteVerbosCompuestos.inserta(localH);        }    }    public void borraInformacionCompuesto(String paramString) {        this.gerentePreposicionesEnVerbos.borraPorVerbo(paramString);        this.gerenteVerbosCompuestos.borraPorVerboCompuesto(paramString);    }    public ReferenciaVerboSimple seleccionaReferenciaVerboSimple(String paramString) {        VerboSimpleCompuesto localH = this.gerenteVerbosCompuestos.seleccionaPorVerboCompuesto(paramString);        if (localH == null) {            return null;        }        VerboBean localh = seleccionaUno(localH.getIdVerboSimple());        List<String> localList = this.gerentePreposicionesEnVerbos.seleccionaPorVerbo(paramString);        if ((paramString == null) || (localList == null)) {            return null;        }        ReferenciaVerboSimple locals = new ReferenciaVerboSimple();        locals.setEntradaVerboSimple(localh);        locals.setPreposiciones(localList);        return locals;    }    public List<Particularidad> seleccionaPartics(String paramString) {        VerboBean localh = this.verbosDAO.seleccionaInidvidual(paramString);        Set<Particularidad> localHashSet = new HashSet<Particularidad>();        List<Particularidad> localList1 = this.irrVerbosDAO.seleccionaPartics(paramString);        List<Particularidad> localList2 = this.irrVerbosIndividualesDAO.seleccionaPartics(paramString);        localHashSet.addAll(localList1);        localHashSet.addAll(localList2);        localHashSet.add(localh.getParticularidad());        if (localh.isCompuesto()) {            VerboSimpleCompuesto localH = this.gerenteVerbosCompuestos.seleccionaPorVerboCompuesto(paramString);            List<Particularidad> localList3 = seleccionaPartics(localH.getIdVerboSimple());            localHashSet.addAll(localList3);        }        return new ArrayList<Particularidad>(localHashSet);    }    public void setGerentePreposicionesEnVerbos(GerentePreposicionesEnVerbos paramfA) {        this.gerentePreposicionesEnVerbos = paramfA;    }    public void setGerenteVerbosCompuestos(GerenteVerbosCompuestos paramU) {        this.gerenteVerbosCompuestos = paramU;    }    public void setIrrVerbosDAO(IrrVerbosDAO paramJ) {        this.irrVerbosDAO = paramJ;    }    public void setIrrVerbosIndividualesDAO(IrrVerbosIndividualesDAO paramBA) {        this.irrVerbosIndividualesDAO = paramBA;    }}
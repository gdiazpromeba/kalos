package com.kalos.analisismorfologico.negocio;import java.util.ArrayList;import java.util.Arrays;import java.util.Collection;import java.util.GregorianCalendar;import java.util.HashSet;import java.util.Iterator;import java.util.List;import java.util.Set;import com.kalos.beans.ParticulaBean;import com.kalos.beans.ResultadoUniversal;import com.kalos.datos.gerentes.GerenteEncParticulas;import com.kalos.datos.gerentes.GerenteParticulas;import com.kalos.operaciones.AACacheable;import com.kalos.operaciones.OpPalabras;import org.apache.log4j.Logger;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;public class AMParticulas implements AnalizadorMorfologico, ApplicationContextAware {    private GerenteParticulas gerenteParticulas;    Logger logger = Logger.getLogger(getClass().getName());    private boolean invocado = false;    private ApplicationContext applicationContext;    private List<String> formas;    public void setApplicationContext(ApplicationContext paramApplicationContext) {        this.applicationContext = paramApplicationContext;    }    private void paso1() {        if (!this.invocado) {            this.gerenteParticulas = (GerenteParticulas) this.applicationContext.getBean("gerenteParticulas");            this.invocado = true;            this.formas = new ArrayList<String>();            List<ParticulaBean> localList = this.gerenteParticulas.seleccionaParticulasNoAcentuablesSinSignificado();            Iterator<ParticulaBean> localIterator = localList.iterator();            while (localIterator.hasNext()) {                ParticulaBean locall = localIterator.next();                String str = locall.getForma();                str = OpPalabras.strBetaACompleto(str);                this.formas.add(str);            }        }    }    public long buscaCanonica(String[] formas, Set<ResultadoUniversal> resultados, AACacheable paramB, boolean placeholder,            boolean debug) {        paso1();        long tiempoInicial = System.currentTimeMillis();        Set<String> localHashSet = new HashSet<String>(Arrays.asList(formas));        paso2(localHashSet, resultados);        long tiempoFinal = System.currentTimeMillis();        long lapso = tiempoFinal - tiempoInicial;        if (debug) {            GregorianCalendar localGregorianCalendar = new GregorianCalendar();            localGregorianCalendar.setTimeInMillis(lapso);            System.out.println("tardó " + localGregorianCalendar.get(12) + " minutos " + localGregorianCalendar.get(13)                    + " segundos " + localGregorianCalendar.get(14) + " milisegundos");        }        return lapso;    }        Logger log= Logger.getLogger(this.getClass().getName());                private void paso2(Set<String> setOriginal, Set<ResultadoUniversal> setResultados) {        List<ResultadoUniversal> listResultados = new ArrayList<ResultadoUniversal>();        Iterator<String> itFormas = setOriginal.iterator();        while (itFormas.hasNext()) {            String formaCompleta = itFormas.next();            String formaBeta = OpPalabras.strCompletoABeta(formaCompleta);            List<ParticulaBean> particulas = this.gerenteParticulas.seleccionaParticulasDadaFormaSinSignificado(formaBeta);            Iterator<ParticulaBean> it = particulas.iterator();            while (it.hasNext()) {                ParticulaBean bean = it.next();                String formaEncabezadoCompleta = OpPalabras.strBetaACompleto(bean.getFormaEncabezado());                log.info("la forma encabezado =" + bean.getFormaEncabezado());                ResultadoUniversal reu = new ResultadoUniversal(bean.getParticulaTipo(), bean.getParticulaId(), null, null,                        bean.getParticularidad(), null, formaCompleta, null, null, null, bean.getPersona(),                        bean.getCaso(), bean.getGenero(), bean.getNumero(), null, null, formaEncabezadoCompleta, null, null);                log.info("y en el reu quedó=" +  reu.getFormaCanonica());                listResultados.add(reu);            }        }        setResultados.addAll(listResultados);    }    public void setGerenteParticulas(GerenteParticulas paramVA) {        this.gerenteParticulas = paramVA;    }}
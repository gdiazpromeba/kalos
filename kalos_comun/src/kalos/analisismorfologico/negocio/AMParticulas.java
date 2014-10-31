package kalos.analisismorfologico.negocio;import java.util.ArrayList;import java.util.Arrays;import java.util.Collection;import java.util.GregorianCalendar;import java.util.HashSet;import java.util.Iterator;import java.util.List;import java.util.Set;import kalos.beans.ParticulaBean;import kalos.beans.ResultadoUniversal;import kalos.datos.gerentes.GerenteParticulas;import kalos.operaciones.AACacheable;import kalos.operaciones.OpPalabras;import org.apache.log4j.Logger;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;public class AMParticulas implements AnalizadorMorfologico, ApplicationContextAware {    private GerenteParticulas gerenteParticulas;    Logger logger = Logger.getLogger(getClass().getName());    private boolean Â = false;    private ApplicationContext applicationContext;    private List<String> formas;    public void setApplicationContext(ApplicationContext paramApplicationContext) {	this.applicationContext = paramApplicationContext;    }    private void paso1() {	if (!this.Â) {	    this.gerenteParticulas = (GerenteParticulas) this.applicationContext.getBean("gerenteParticulas");	    this.Â = true;	    this.formas = new ArrayList<String>();	    List<ParticulaBean> localList = this.gerenteParticulas.seleccionaParticulasNoAcentuablesSinSignificado();	    Iterator<ParticulaBean> localIterator = localList.iterator();	    while (localIterator.hasNext()) {		ParticulaBean locall = localIterator.next();		String str = locall.getForma();		str = OpPalabras.strBetaACompleto(str);		this.formas.add(str);	    }	}    }    public long buscaCanonica(String[] formas, Set<ResultadoUniversal> resultados, AACacheable paramB, boolean paramBoolean1,	    boolean paramBoolean2) {	paso1();	long l1 = System.currentTimeMillis();	Set<String> localHashSet = new HashSet<String>(Arrays.asList(formas));	paso2(localHashSet, resultados);	paso3(resultados);	long l2 = System.currentTimeMillis();	long l3 = l2 - l1;	if (paramBoolean2) {	    GregorianCalendar localGregorianCalendar = new GregorianCalendar();	    localGregorianCalendar.setTimeInMillis(l3);	    System.out.println("tardó " + localGregorianCalendar.get(12) + " minutos " + localGregorianCalendar.get(13)		    + " segundos " + localGregorianCalendar.get(14) + " milisegundos");	}	return l3;    }    private void paso2(Set<String> paramSet, Set<ResultadoUniversal> paramSet1) {	List<ResultadoUniversal> localArrayList = new ArrayList<ResultadoUniversal>();	Iterator<String> localIterator1 = paramSet.iterator();	while (localIterator1.hasNext()) {	    String str1 = (String) localIterator1.next();	    String str2 = OpPalabras.strCompletoABeta(str1);	    List<ParticulaBean> localList = this.gerenteParticulas.seleccionaParticulasDadaFormaSinSignificado(str2);	    Iterator<ParticulaBean> localIterator2 = localList.iterator();	    while (localIterator2.hasNext()) {		ParticulaBean locall =  localIterator2.next();		ResultadoUniversal localj = new ResultadoUniversal(locall.getParticulaTipo(), locall.getParticulaId(), null, null,			locall.getParticularidad(), null, str1, null, null, null, locall.getPersona(),			locall.getCaso(), locall.getGenero(), locall.getNumero(), null, null, null, null, null);		localArrayList.add(localj);	    }	}	paramSet1.addAll(localArrayList);    }    private void paso3(Collection<ResultadoUniversal> paramCollection) {	Iterator<ResultadoUniversal> localIterator = paramCollection.iterator();	while (localIterator.hasNext()) {	    ResultadoUniversal localj = localIterator.next();	    ParticulaBean bean = this.gerenteParticulas.getParticulaSinSignificado(localj.getId());	    String str = OpPalabras.strBetaACompleto(bean.getForma());	    localj.setFormaCanonica(str);	}    }    public void setGerenteParticulas(GerenteParticulas paramVA) {	this.gerenteParticulas = paramVA;    }}
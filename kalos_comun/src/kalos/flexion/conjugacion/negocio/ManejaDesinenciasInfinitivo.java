package kalos.flexion.conjugacion.negocio;import java.util.ArrayList;import java.util.Iterator;import java.util.List;import kalos.beans.DesinInfinitivo;import kalos.datos.gerentes.GerenteDesinInfinitivos;import kalos.enumeraciones.Acento;import kalos.enumeraciones.Aspecto;import kalos.enumeraciones.FuerteDebil;import kalos.enumeraciones.Voz;import kalos.operaciones.OpPalabras;public class ManejaDesinenciasInfinitivo {    @SuppressWarnings("unchecked")    private List<Desinencia>[][][][] desinencias = new List[7][4][6][2];    public Desinencia[] getDesinencias(int juego, Voz voz, Aspecto aspecto, FuerteDebil fuerte) {	int i = Voz.getInt(voz);	int j = Aspecto.getInt(aspecto);	int k = FuerteDebil.getInt(fuerte);	List<Desinencia> localList = this.desinencias[juego][i][j][k];	if (localList == null) {	    return null;	}	try {	    return (Desinencia[]) localList.toArray(new Desinencia[0]);	} catch (Exception localException) {	    System.out.println("error al tratar de obtener la desinencia ***********");	    System.out.println("juego=" + juego);	    System.out.println("voz=" + voz);	    System.out.println("aspecto=" + aspecto);	    System.out.println("fuerte=" + fuerte);	    System.out.println("***************************************************");	    throw new RuntimeException("error en ManejaDesinenciasInfinitivo.getDesinencias()");	}    }    private void puebla(int juego, Voz voz, Aspecto aspecto, FuerteDebil fuerte, String cadena, int posicion, Acento acento) {	int i = Voz.getInt(voz);	int j = Aspecto.getInt(aspecto);	int k = FuerteDebil.getInt(fuerte);	try {	    if (this.desinencias[juego][i][j][k] == null) {		this.desinencias[juego][i][j][k] = new ArrayList<Desinencia>();	    }	    this.desinencias[juego][i][j][k].add(new Desinencia(cadena, posicion, acento, juego));	} catch (Exception localException) {	    System.out.println("error al tratar de obtener la desinencia ***********");	    System.out.println("juego=" + juego);	    System.out.println("voz=" + voz);	    System.out.println("aspecto=" + aspecto);	    System.out.println("fuerte=" + fuerte);	    System.out.println("***************************************************");	    throw new RuntimeException("error en ManejaDesinenciasInfinitivo.setDesinencias()");	}    }    public ManejaDesinenciasInfinitivo(boolean todas, GerenteDesinInfinitivos gerDesInfinitivos) {	List<DesinInfinitivo> localList;	if (!todas) {	    localList = gerDesInfinitivos.seleccionaRestringidas();	} else {	    localList = gerDesInfinitivos.seleccionaTodas();	}	Iterator<DesinInfinitivo> localIterator = localList.iterator();	while (localIterator.hasNext()) {	    DesinInfinitivo locald = localIterator.next();	    puebla(locald.getJuego(), locald.getVoz(), locald.getAspecto(), locald.getFuerte(),		    OpPalabras.strBetaACompleto(locald.getDesinencia()), locald.getSilaba(), locald.getAcento());	}    }}
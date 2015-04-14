package com.kalos.analisismorfologico.negocio;import java.io.PrintStream;import java.util.*;import com.kalos.beans.*;import com.kalos.datos.gerentes.*;import com.kalos.enumeraciones.*;import com.kalos.fonts.CarPos;import com.kalos.operaciones.*;import org.apache.log4j.Logger;// Referenced classes of package kalos.analisismorfologico.negocio://            AMUtilpublic class AMNominal implements CompLetras {    private String tiposDePrimera[];    private static String tiposDeSegunda[];    private Integer nomVocDistintos[];    public Integer tiposNeutros[];    public Integer tiposNoNeutros[];    private GerenteTermRegSustantivo gerenteTermRegSustantivo;    private GerenteTiposSustantivo gerenteTiposSustantivo;    private GerenteDesinSust gerenteDesinSust;    private AMUtil amUtil;    Logger logger;    private static String arrNSNaturales[][] = { { "(.*)(-73-|-106-)(.*)", "OJ" }, { "(.*)(-6-)(.*)", "A" },	    { "(.*)(-8-)(.*)", "A_" }, { "(.*)(-29-)(.*)", "N" }, { "(.*)(-108-)(.*)", "A_J" },	    { "(.*)(-122-|-123-)(.*)", "HJ" }, { "(.*)(-74-)(.*)", "AJ" }, { "(.*)(-119-)(.*)", "OUJ" },	    { "(.*)(-124-|-125-)(.*)", "N" }, { "(.*)(-26-|-129-)(.*)", "" }, { "(.*)(-104-)(.*)", "HJ" } };    private static String arrNSMismoNatural[][] = { { "(.*)(-31-|-12-)(.*)", "H" }, { "(.*)(-10-)(.*)", "A_" },	    { "(.*)(-7-|-27-)(.*)", "A" }, { "(.*)(-84-|-35-)(.*)", "J" }, { "(.*)(-121-)(.*)", "HJ" },	    { "(.*)(-25-)(.*)", "OJ" }, { "(.*)(-110-|-111-)(.*)", "ON" }, { "(.*)(-92-|-114-|-115-)(.*)", "WJ" },	    { "(.*)(-96-)(.*)", "AI" }, { "(.*)(-49-)(.*)", "OUN" }, { "(.*)(-92-|-93-)(.*)", "W" },	    { "(.*)(-30-|-103-)(.*)", "N" }, { "(.*)(-37-|-85-)(.*)", "" }, { "(.*)(-109-|-82-)(.*)", "A_J" },	    { "(.*)(-100-)(.*)", "OI" } };    private static String arrNSMismoTodo[][] = { { "(.*)(-33-)(.*)", "H" }, { "(.*)(-70-|-112-|-113-)(.*)", "" },	    { "(.*)(-128-|-103-|-36-)(.*)", "J" }, { "(.*)(-61-|-62-|-63-|-64-|-65-|-66-|-67-|-68-)(.*)", "J" },	    { "(.*)(-79-)(.*)", "UJ" }, { "(.*)(-105-)(.*)", "HJ" }, { "(.*)(-118-)(.*)", "OUJ" },	    { "(.*)(-107-)(.*)", "OJ" } };    private static String arrNSUltimanatural[][] = { { "(.*)(-50-)(.*)", "HJ" } };    private static String arrNSAgudoUltima[][] = { { "(.*)(-52-)(.*)", "J" }, { "(.*)(-39-)(.*)", "" },	    { "(.*)(-72-)(.*)", "EJ" }, { "(.*)(-78-)(.*)", "UJ" }, { "(.*)(-81-)(.*)", "J" } };    private static String arrGSNatural[][] = { { "(.*)(-104-|-106-|-108-|-110-)(.*)", "OU" },	    { "(.*)(-6-|-31-)(.*)", "HJ" }, { "(.*)(-8-)(.*)", "A_J" },	    { "(.*)(-26-|-29-|-37-|-64-|-70-|-124-|-125-)(.*)", "OJ" }, { "(.*)(-101-|-131-|-132-)(.*)", "WN" },	    { "(.*)(-93-)(.*)", "W" }, { "(.*)(-114-)(.*)", "WOJ" }, { "(.*)(-122-|-123-)(.*)", "OUJ" } };    private static String arrGSMismoNatural[][] = { { "(.*)(-27-|-33-|-12-|-109-)(.*)", "HJ" },	    { "(.*)(-100-|-101-)(.*)", "WN" }, { "(.*)(-7-|-10-)(.*)", "A_J" }, { "(.*)(-82-)(.*)", "A_" },	    { "(.*)(-25-|-30-|-81-|-112-|-113-|-103-)(.*)", "OJ" }, { "(.*)(-119-|-105-|-107-|-111-)(.*)", "OU" } };    private static String arrGSUltimaNatural[][] = { { "(.*)(-90-)(.*)", "OUJ" }, { "(.*)(-10-)(.*)", "A_J" },	    { "(.*)(-12-)(.*)", "HJ" }, { "(.*)(-96-)(.*)", "WN" }, { "(.*)(-115-)(.*)", "WOJ" } };    private static String arrDP[][] = { { "(.*)(-124-|-125-|-103-|-52-)(.*)", "NOJ" }, { "(.*)(-21-)(.*)", "TOJ" },	    { "(.*)(-113-)(.*)", "NTOJ" }, { "(.*)(-61-|-62-|-63-|-64-|-65-|-66-|-67-|-68-)(.*)", "TOJ" },	    { "(.*)(-61-|-62-|-63-|-64-|-65-|-66-|-67-|-68-)(.*)", "DOJ" },	    { "(.*)(-61-|-62-|-63-|-64-|-65-|-66-|-67-|-68-)(.*)", "QOJ" } };    private static String duales1ra2da[][] = { { "(.*)(-7-|-8-|-10-)(.*)", "A_J" },	    { "(.*)(-12-|-26-|-27-|-31-|-33-)(.*)", "HJ" }, { "(.*)(-98-|-104-|-105-|-108-|-109-)(.*)", "OU" } };    private static String genLabiales[] = { "BOJ", "POJ", "FOJ" };    private static String genGuturales[] = { "GOJ", "KOJ", "COJ" };    public AMNominal(GerenteTiposSustantivo gerenteTiposSustantivo, GerenteDesinSust gerenteDesinSust) {	logger = Logger.getLogger(getClass().getName());	String idPrimera = "-14a3b83f:108a8943d49:-7fe5-14a3";	String idSegunda = "-14a3b83f:108a8943d49:-7fe6-14a3";	List dePrimera = gerenteTiposSustantivo.getTiposHoja(idPrimera);	List deSegunda = gerenteTiposSustantivo.getTiposHoja(idSegunda);	tiposDePrimera = new String[dePrimera.size()];	this.gerenteDesinSust = gerenteDesinSust;	this.gerenteTiposSustantivo = gerenteTiposSustantivo;	tiposDeSegunda = new String[deSegunda.size()];	for (int i = 0; i < dePrimera.size(); i++) {	    tiposDePrimera[i] = "-".concat(Integer.toString(((TipoJerarquico) dePrimera.get(i)).getValorEntero()))		    .concat("-");	}	for (int i = 0; i < deSegunda.size(); i++) {	    tiposDeSegunda[i] = "-".concat(Integer.toString(((TipoJerarquico) deSegunda.get(i)).getValorEntero()))		    .concat("-");	}	nomVocDistintos = getNomGenDistintos();	List tipos = gerenteTiposSustantivo.getTodos();	List listTiposNeutros = new ArrayList();	List listTiposNoNeutros = new ArrayList();	for (Iterator iterator = tipos.iterator(); iterator.hasNext();) {	    TipoSustantivo tis = (TipoSustantivo) iterator.next();	    if (tis.getGeneroSugerido() != null) {		if (tis.getGeneroSugerido().equals(Genero.Neutro)) {		    listTiposNeutros.add(Integer.valueOf(tis.getValorEntero()));		} else {		    listTiposNoNeutros.add(Integer.valueOf(tis.getValorEntero()));		}	    }	}	tiposNeutros = (Integer[]) listTiposNeutros.toArray(new Integer[0]);	tiposNoNeutros = (Integer[]) listTiposNoNeutros.toArray(new Integer[0]);    }    public void corrigePluralizados(Set terminaciones) {	for (Iterator iterator = terminaciones.iterator(); iterator.hasNext();) {	    TermRegSustantivo trs = (TermRegSustantivo) iterator.next();	    if (gerenteTiposSustantivo.esPluralizado(trs.getTipoSustantivo())) {		trs.setNumero(Numero.Singular);	    }	}    }    public void paso1(Set setEntradas, Set setOriginal, AACacheable cacheAA, boolean debug) {	StringBuffer sbDebug = new StringBuffer();	for (Iterator iterator = setEntradas.iterator(); iterator.hasNext();) {	    String entrada = (String) iterator.next();	    String entradaFacil = OpPalabras.facilita(entrada);	    String entradaBeta = OpPalabras.strCompletoABeta(entrada);	    String entradaFacilBeta = OpPalabras.strCompletoABeta(entradaFacil);	    List terminaciones = gerenteTermRegSustantivo.seleccionaPorTerminacion(entradaFacilBeta);	    Iterator iterator1 = terminaciones.iterator();	    while (iterator1.hasNext()) {		TermRegNominal trs = (TermRegNominal) iterator1.next();		String regex = trs.getRegExDesinencia();		if (regex != null && !entradaBeta.matches(regex)) {		    if (debug) {			sbDebug.append((new StringBuilder("        la terminaci\363n es '"))				.append(trs.getTerminacion()).append("' tipo ").append(trs.getTipoSustantivo())				.append(" pero no coincide con la regexp=").append(regex).append(" \n").toString());		    }		    continue;		}		if (trs.getPosicionConcuerda() == 2) {		    AnalisisAcento aa = cacheAA.getAnalisisAcento(entrada);		    boolean licito = aa.actuales.esTipoAcentonaturalDadaPosicion;		    boolean dosSilabas = aa.cantidadDeSilabas > 2 && aa.actuales.silaba == aa.sugeridos.silaba;		    boolean masSilabas = aa.cantidadDeSilabas <= 2 && aa.actuales.silaba == -1;		    if (!licito || !dosSilabas && !masSilabas) {			if (debug) {			    sbDebug.append((new StringBuilder("        la terminaci\363n es '"))				    .append(trs.getTerminacion())				    .append("' tipo ")				    .append(trs.getTipoSustantivo())				    .append(" pero la entrada no cumple con la concordancia de acento seg\372n la 'regla de d"					    + "os s\355labas' \n").toString());			}			continue;		    }		}		trs.setFormaOriginal(entrada);		trs.setTerminacionPendienteRevision(trs);		setOriginal.add((TermRegSustantivo) trs);	    }	}	if (debug) {	    System.out.println("***** despu\351s de la b\372squeda de terminaciones (paso 1) *******************"		    + "**");	    System.out.println(sbDebug.toString());	    System.out.println("-- contenido del set resultado --");	    amUtil.debugBeans(setOriginal, new String[] { "formaOriginal" });	}    }    public void reconstruyeTemas(Set setOriginal, Set setSiguiente, AACacheable cacheAA, boolean debug) {	Iterator iterator = setOriginal.iterator();	while (iterator.hasNext()) {	    TermRegSustantivo reg = (TermRegSustantivo) iterator.next();	    reg = reg.clona();	    OrigenTema origenTema = reg.getOrigenTema();	    Caso caso = reg.getCaso();	    Numero numero = reg.getNumero();	    int tipoSust = reg.getTipoSustantivo();	    String tiposHoja = reg.getTiposHoja();	    String formaOriginal = reg.getFormaOriginal();	    String terminacion = OpPalabras.strBetaACompleto(reg.getTerminacion());	    if ((caso.equals(Caso.Nominativo) || caso.equals(Caso.Genitivo)) && numero.equals(Numero.Singular)) {		continue;	    }	    if (tipoSust == 1 && numero.equals(Numero.Dual)		    && (caso.equals(Caso.Nominativo) || caso.equals(Caso.Vocativo) || caso.equals(Caso.Acusativo))) {		String temaOrig = OpPalabras.comeFinal(formaOriginal, terminacion.length());		String temaOrigBase = OpPalabras.desacentuar(temaOrig);		for (int i = 0; i < duales1ra2da.length; i++) {		    if (tiposHoja.matches(duales1ra2da[i][0])) {			String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto(duales1ra2da[i][1]));			AnalisisAcento aaOrig = cacheAA.getAnalisisAcento(formaOriginal);			temaGen = OpPalabras.acentua(temaGen, aaOrig.actuales.silaba);			TermRegSustantivo regAux = reg.clona(); 			regAux.setGenitivoPropuesto(temaGen);			setSiguiente.add(regAux);		    }		}	    }	    if (origenTema.equals(OrigenTema.NominativoSingular)) {		String temaOrig = OpPalabras.comeFinal(formaOriginal, terminacion.length());		String temaOrigBase = OpPalabras.desacentuar(temaOrig);		for (int i = 0; i < arrNSMismoNatural.length; i++) {		    if (tiposHoja.matches(arrNSMismoNatural[i][0])) {			AnalisisAcento aa = cacheAA.getAnalisisAcento(formaOriginal);			if (aa.actuales.esTipoAcentonaturalDadaPosicion) {			    String temaNom = (new StringBuilder(String.valueOf(temaOrigBase))).append(				    OpPalabras.strBetaACompleto(arrNSMismoNatural[i][1])).toString();			    temaNom = OpPalabras.desacentuar(temaNom);			    String nomPropuesto = OpPalabras.acentuarMismaPosicion(formaOriginal, temaNom);			    TermRegSustantivo regAux =reg.clona(); 			    regAux.setNominativoPropuesto(nomPropuesto);			    setSiguiente.add(regAux);			}		    }		}		for (int i = 0; i < arrNSMismoTodo.length; i++) {		    if (tiposHoja.matches(arrNSMismoTodo[i][0])) {			String temaNom = (new StringBuilder(String.valueOf(temaOrigBase))).append(				OpPalabras.strBetaACompleto(arrNSMismoTodo[i][1])).toString();			temaNom = OpPalabras.desacentuar(temaNom);			String nomPropuesto = OpPalabras.acentuarTodoIgual(formaOriginal, temaNom);			TermRegSustantivo regAux = reg.clona(); 			regAux.setNominativoPropuesto(nomPropuesto);			setSiguiente.add(regAux);		    }		}		for (int i = 0; i < arrNSNaturales.length; i++) {		    if (tiposHoja.matches(arrNSNaturales[i][0]) && esNatural(formaOriginal, cacheAA)) {			String temaNom = (new StringBuilder(String.valueOf(temaOrigBase))).append(				OpPalabras.strBetaACompleto(arrNSNaturales[i][1])).toString();			String nomPropuesto = OpPalabras.acentua(temaNom);			TermRegSustantivo regAux = reg.clona(); 			regAux.setNominativoPropuesto(nomPropuesto);			setSiguiente.add(regAux);		    }		}		for (int i = 0; i < arrNSAgudoUltima.length; i++) {		    if (tiposHoja.matches(arrNSAgudoUltima[i][0])) {			String temaNom = (new StringBuilder(String.valueOf(temaOrigBase))).append(				OpPalabras.strBetaACompleto(arrNSAgudoUltima[i][1])).toString();			String nomPropuesto = OpPalabras.acentua(temaNom, -1, Acento.Agudo);			TermRegSustantivo regAux = reg.clona();			regAux.setNominativoPropuesto(nomPropuesto);			setSiguiente.add(regAux);		    }		}		for (int i = 0; i < arrNSUltimanatural.length; i++) {		    if (tiposHoja.matches(arrNSUltimanatural[i][0])) {			String temaNom = (new StringBuilder(String.valueOf(temaOrigBase))).append(				OpPalabras.strBetaACompleto(arrNSUltimanatural[i][1])).toString();			String nomPropuesto = OpPalabras.acentua(temaNom, -1);			TermRegSustantivo regAux = reg.clona(); 			regAux.setNominativoPropuesto(nomPropuesto);			setSiguiente.add(regAux);		    }		}	    }	    if (origenTema.equals(OrigenTema.VocativoSingular)) {		String temaGen = OpPalabras.comeFinal(formaOriginal, terminacion.length());		String temaVoc = OpPalabras.comeFinal(formaOriginal, terminacion.length());		if (tiposHoja.matches("(.*)(-70-)(.*)")) {		    temaGen = (new StringBuilder(String.valueOf(temaGen))).append(OpPalabras.strBetaACompleto("NTOJ"))			    .toString();		    String genPropuesto = OpPalabras.desacentuar(temaGen);		    genPropuesto = OpPalabras.acentuarMismaPosicion(formaOriginal, genPropuesto);		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(genPropuesto);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-76-)(.*)")) {		    String temaNomPropuesto = temaVoc.concat(OpPalabras.strBetaACompleto("HJ"));		    temaNomPropuesto = OpPalabras.desacentuar(temaNomPropuesto);		    temaNomPropuesto = OpPalabras.acentua(temaNomPropuesto, -2);		    TermRegSustantivo regAux = reg.clona();		    regAux.setNominativoPropuesto(temaNomPropuesto);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-124-)(.*)")) {		    String nomPropuesto = OpPalabras.comeFinal(temaVoc, 1);		    nomPropuesto = nomPropuesto.concat(OpPalabras.strBetaACompleto("WN"));		    nomPropuesto = OpPalabras.desacentuar(nomPropuesto);		    nomPropuesto = OpPalabras.acentua(nomPropuesto);		    TermRegSustantivo regAux = reg.clona();		    regAux.setNominativoPropuesto(nomPropuesto);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-125-)(.*)")) {		    String nomPropuesto = OpPalabras.comeFinal(temaVoc, 1);		    nomPropuesto = nomPropuesto.concat(OpPalabras.strBetaACompleto("ON"));		    nomPropuesto = OpPalabras.desacentuar(nomPropuesto);		    nomPropuesto = OpPalabras.acentua(nomPropuesto);		    TermRegSustantivo regAux = reg.clona();		    regAux.setNominativoPropuesto(nomPropuesto);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-84-|-85-|-127-)(.*)")) {		    StringBuffer sb = new StringBuffer(temaVoc);		    TermRegSustantivo regAux = reg.clona();		    String temaNomPropuesto = OpPalabras.desacentuar(sb.toString());		    temaNomPropuesto = OpPalabras.acentuarMismaPosicion(formaOriginal, temaNomPropuesto);		    regAux.setNominativoPropuesto(temaNomPropuesto);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-122-)(.*)")) {		    StringBuffer sb = new StringBuffer(temaVoc);		    sb.append(OpPalabras.strBetaACompleto("HJ"));		    TermRegSustantivo regAux = reg.clona();		    String temaNomPropuesto = OpPalabras.desacentuar(sb.toString());		    temaNomPropuesto = OpPalabras.acentua(temaNomPropuesto);		    regAux.setNominativoPropuesto(temaNomPropuesto);		    setSiguiente.add(regAux);		}	    }	    if (origenTema.equals(OrigenTema.GenitivoSingular)) {		String temaOrig = OpPalabras.comeFinal(formaOriginal, terminacion.length());		String temaOrigBase = OpPalabras.desacentuar(temaOrig);		for (int i = 0; i < arrGSMismoNatural.length; i++) {		    if (tiposHoja.matches(arrGSMismoNatural[i][0])) {			boolean es1ra2da = false;			if (formaOriginal.endsWith(OpPalabras.strBetaACompleto("W=N")) && caso == Caso.Genitivo				&& numero == Numero.Plural) {			    for (int e = 0; e < tiposDePrimera.length; e++) {				String tipo1ra = tiposDePrimera[e];				if (tiposHoja.indexOf(tipo1ra) <= -1) {				    continue;				}				es1ra2da = true;				break;			    }			    for (int e = 0; e < tiposDeSegunda.length; e++) {				String tipo2da = tiposDeSegunda[e];				if (tiposHoja.indexOf(tipo2da) <= -1) {				    continue;				}				es1ra2da = true;				break;			    }			    if (es1ra2da) {				String temaGen = temaOrigBase.concat(OpPalabras					.strBetaACompleto(arrGSMismoNatural[i][1]));				temaGen = OpPalabras.acentua(temaGen, -1);				TermRegSustantivo regAux = reg.clona();				regAux.setGenitivoPropuesto(temaGen);				setSiguiente.add(regAux);				temaGen = (new StringBuilder(String.valueOf(temaOrigBase))).append(					OpPalabras.strBetaACompleto(arrGSMismoNatural[i][1])).toString();				AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);				if (aaGen.cantidadDeSilabas >= 2) {				    temaGen = OpPalabras.acentua(temaGen, -2);				    regAux = reg.clona();				    regAux.setGenitivoPropuesto(temaGen);				    setSiguiente.add(regAux);				}			    }			}			AnalisisAcento aa = cacheAA.getAnalisisAcento(formaOriginal);			if (aa.actuales.esTipoAcentonaturalDadaPosicion) {			    String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto(arrGSMismoNatural[i][1]));			    temaGen = OpPalabras.acentuarMismaPosicion(formaOriginal, temaGen);			    TermRegSustantivo regAux = reg.clona();			    regAux.setGenitivoPropuesto(temaGen);			    setSiguiente.add(regAux);			}		    }		}		for (int i = 0; i < arrGSNatural.length; i++) {		    if (tiposHoja.matches(arrGSNatural[i][0]) && esNatural(formaOriginal, cacheAA)) {			String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto(arrGSNatural[i][1]));			temaGen = OpPalabras.desacentuar(temaGen);			String genPropuesto = OpPalabras.acentua(temaGen);			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(genPropuesto);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-35-|-36-)(.*)")) {		    String adicionesGen[] = labialOGutural(temaOrig, terminacion, caso, numero);		    for (int i = 0; i < adicionesGen.length; i++) {			String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto(adicionesGen[i]));			temaGen = OpPalabras.desacentuar(temaGen);			AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);			if (aaGen.cantidadDeSilabas <= 2) {			    temaGen = OpPalabras.acentua(temaGen, -1);			} else {			    temaGen = OpPalabras.acentua(temaGen);			}			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(temaGen);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-50-)(.*)")) {		    String genPropuesto = null;		    if (caso == Caso.Dativo && numero == Numero.Singular) {			genPropuesto = temaOrigBase.concat(OpPalabras.strBetaACompleto("EOUJ"));		    } else {			genPropuesto = temaOrigBase.concat(OpPalabras.strBetaACompleto("OUJ"));		    }		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(genPropuesto);		    if (aaGen.cantidadDeSilabas >= 2) {			TermRegSustantivo regAux = reg.clona();			String temaAcentuado = OpPalabras.acentua(genPropuesto, -2);			regAux.setGenitivoPropuesto(temaAcentuado);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-72-|-73-|-75|-76-|-121-|-122-|-123-)(.*)")) {		    String temaGen = null;		    if (!reg.isExContraccion()) {			temaGen = OpPalabras.comeFinal(temaOrigBase, 1).concat(OpPalabras.strBetaACompleto("OUJ"));		    } else {			temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto("OUJ"));		    }		    temaGen = OpPalabras.desacentuar(temaGen);		    String temaAcentuado = null;		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);		    AnalisisAcento aaOrig = cacheAA.getAnalisisAcento(formaOriginal);		    if (tiposHoja.matches("(.*)(-73-|-122-|-123-)(.*)") && aaGen.cantidadDeSilabas >= 2) {			TermRegSustantivo regAux = reg.clona();			temaAcentuado = OpPalabras.acentua(temaGen, -2);			regAux.setGenitivoPropuesto(temaAcentuado);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-72-|-121-)(.*)")) {			TermRegSustantivo regAux = reg.clona();			temaAcentuado = OpPalabras.acentua(temaGen, -1);			regAux.setGenitivoPropuesto(temaAcentuado);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-76-|-75-)(.*)") && aaOrig.actuales.silabaB1 <= aaGen.cantidadDeSilabas) {			TermRegSustantivo regAux = reg.clona();			temaAcentuado = OpPalabras.acentuarMismaPosicion(formaOriginal, temaGen);			regAux.setGenitivoPropuesto(temaAcentuado);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-74-)(.*)")) {		    String temaGen = null;		    if (!reg.isExContraccion()) {			temaGen = (new StringBuilder(String.valueOf(OpPalabras.comeFinal(temaOrigBase, 1)))).append(				OpPalabras.strBetaACompleto("WJ")).toString();		    } else {			temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto("WJ"));		    }		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);		    if (aaGen.cantidadDeSilabas >= 2) {			temaGen = OpPalabras.acentua(temaGen, -2);			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(temaGen);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-84-|-85-|-128-|-129-)(.*)")) {		    StringBuffer temaGen = new StringBuffer(temaOrigBase);		    if (!reg.isExContraccion()) {			if (temaGen.length() <= 1) {			    continue;			}			temaGen.deleteCharAt(temaGen.length() - 1);		    }		    if (tiposHoja.matches("(.*)(-84-|-85-)(.*)")) {			TermRegSustantivo regAux = reg.clona();			String genitivoPropuesto = temaGen.toString().concat(OpPalabras.strBetaACompleto("EOJ"));			genitivoPropuesto = OpPalabras.acentuarMismaPosicion(cacheAA, formaOriginal, genitivoPropuesto);			regAux.setGenitivoPropuesto(genitivoPropuesto);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-129-|-128-)(.*)")) {			TermRegSustantivo regAux = reg.clona();			String genitivoPropuesto = temaGen.toString().concat(OpPalabras.strBetaACompleto("EWJ"));			genitivoPropuesto = OpPalabras.desacentuar(genitivoPropuesto);			genitivoPropuesto = OpPalabras.acentua(genitivoPropuesto, -3);			regAux.setGenitivoPropuesto(genitivoPropuesto);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-79-)(.*)")) {		    StringBuffer tema = new StringBuffer(OpPalabras.desacentuar(temaOrigBase));		    if (caso == Caso.Dativo && numero == Numero.Plural) {			tema.append(OpPalabras.strBetaACompleto("A_O/J"));		    } else {			tema.append(OpPalabras.strBetaACompleto("O/J"));		    }		    TermRegSustantivo regAux = reg.clona();		    String palabra = OpPalabras.acentua(tema.toString(), -1);		    regAux.setGenitivoPropuesto(palabra);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-78-)(.*)")) {		    StringBuffer tema = new StringBuffer(OpPalabras.desacentuar(temaOrigBase));		    if (numero == Numero.Plural && (caso == Caso.Nominativo || caso == Caso.Vocativo)			    || numero == Numero.Dual			    && (caso == Caso.Nominativo || caso == Caso.Vocativo || caso == Caso.Acusativo)			    || caso == Caso.Dativo) {			tema.append('\u03B5');		    }		    tema.append(OpPalabras.strBetaACompleto("WJ"));		    TermRegSustantivo regAux = reg.clona();		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(tema.toString());		    if (aaGen.cantidadDeSilabas >= 2) {			String palabra = OpPalabras.acentua(tema.toString(), -2);			regAux.setGenitivoPropuesto(palabra);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-52-)(.*)")) {		    StringBuffer tema = new StringBuffer(OpPalabras.desacentuar(temaOrigBase));		    tema.append(OpPalabras.strBetaACompleto("OJ"));		    AnalisisAcento aaForma = cacheAA.getAnalisisAcento(formaOriginal);		    String palabra = null;		    if (aaForma.cantidadDeSilabas <= 2) {			palabra = OpPalabras.acentua(tema.toString(), -1);		    } else {			palabra = OpPalabras.acentua(tema.toString(), -2);		    }		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(palabra);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-61-|-62-|-63-|-64-|-65-|-66-|-67-|-68-)(.*)")) {		    String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto("OJ"));		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);		    int cantSilabas = aaGen.cantidadDeSilabas;		    if (tiposHoja.matches("(.*)(-65-|-66-)(.*)") && cantSilabas >= 3) {			String temaGenPropuesto = OpPalabras.acentua(temaGen, -3);			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(temaGenPropuesto);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-61-)(.*)")) {			int posicion = 0;			if (temaGen.endsWith(OpPalabras.strBetaACompleto("DOJ"))				|| temaGen.endsWith(OpPalabras.strBetaACompleto("OTOJ"))) {			    posicion = -2;			} else if (temaGen.endsWith(OpPalabras.strBetaACompleto("THTOJ"))) {			    posicion = -3;			}			if (cantSilabas >= posicion) {			    String temaGenPropuesto = OpPalabras.acentua(temaGen, posicion);			    TermRegSustantivo regAux = reg.clona();			    regAux.setGenitivoPropuesto(temaGenPropuesto);			    setSiguiente.add(regAux);			}		    }		    if (tiposHoja.matches("(.*)(-63-|-64-)(.*)")) {			String temaGenPropuesto = null;			if (cantSilabas > 2) {			    temaGenPropuesto = OpPalabras.acentua(temaGen);			} else {			    temaGenPropuesto = OpPalabras.acentua(temaGen, -1, Acento.Agudo);			}			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(temaGenPropuesto);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-37-|-39-|-116-|-117-)(.*)")) {		    String temaGen = null;		    temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto("OJ"));		    AnalisisAcento aaGen = cacheAA.getAnalisisAcento(temaGen);		    if (aaGen.cantidadDeSilabas <= 2 || tiposHoja.matches("(.*)(-37-|-39-)(.*)")) {			temaGen = OpPalabras.acentua(temaGen, -1, Acento.Agudo);		    } else if (tiposHoja.matches("(.*)(-116-)(.*)")) {			temaGen = OpPalabras.acentua(temaGen);		    } else {			temaGen = OpPalabras.acentua(temaGen, -2, Acento.Agudo);		    }		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(temaGen);		    setSiguiente.add(regAux);		}		for (int i = 0; i < arrGSUltimaNatural.length; i++) {		    if (tiposHoja.matches(arrGSUltimaNatural[i][0])) {			AnalisisAcento aa = cacheAA.getAnalisisAcento(formaOriginal);			if (aa.actuales.esTipoAcentonaturalDadaPosicion) {			    String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto(arrGSUltimaNatural[i][1]));			    temaGen = OpPalabras.acentua(temaGen, -1);			    TermRegSustantivo regAux = reg.clona();			    regAux.setGenitivoPropuesto(temaGen);			    setSiguiente.add(regAux);			}		    }		}		if (tiposHoja.matches("(.*)(-92-)(.*)")) {		    String temaGen = temaOrigBase.concat(OpPalabras.strBetaACompleto("W/"));		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(temaGen);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-118-|-49-)(.*)")) {		    String temaGen = (new StringBuilder(String.valueOf(temaOrigBase))).append(			    OpPalabras.strBetaACompleto("OU=")).toString();		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(temaGen);		    setSiguiente.add(regAux);		}	    }	    if (origenTema.equals(OrigenTema.NominativoPlural)) {		if (tiposHoja.matches("(.*)(-78-)(.*)")) {		    String temaGen = OpPalabras.comeFinal(formaOriginal, terminacion.length());		    temaGen = (new StringBuilder(String.valueOf(temaGen))).append(OpPalabras.strBetaACompleto("EWJ"))			    .toString();		    temaGen = OpPalabras.desacentuar(temaGen);		    temaGen = OpPalabras.acentua(temaGen, -2);		    TermRegSustantivo regAux = reg.clona();		    regAux.setGenitivoPropuesto(temaGen);		    setSiguiente.add(regAux);		}		if (tiposHoja.matches("(.*)(-116-|-117-|-37-|-39-)(.*)")) {		    String temaNom = OpPalabras.comeFinal(formaOriginal, terminacion.length() + 2);		    temaNom = temaNom.concat(OpPalabras.strBetaACompleto("HR"));		    temaNom = OpPalabras.desacentuar(temaNom);		    if (tiposHoja.matches("(.*)(-116-)(.*)")) {			String temaNomPropuesto = OpPalabras.acentua(temaNom);			TermRegSustantivo regAux = reg.clona();			regAux.setNominativoPropuesto(temaNomPropuesto);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-117-)(.*)")) {			String temaNomPropuesto = OpPalabras.acentua(temaNom, -1, Acento.Agudo);			TermRegSustantivo regAux = reg.clona();			regAux.setNominativoPropuesto(temaNomPropuesto);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-39-)(.*)")) {			String temaNomPropuesto = OpPalabras.acentua(temaNom, -2, Acento.Agudo);			TermRegSustantivo regAux = reg.clona();			regAux.setNominativoPropuesto(temaNomPropuesto);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-37-)(.*)")) {			AnalisisAcento aaNom = cacheAA.getAnalisisAcento(temaNom);			String temaNomPropuesto = null;			if (aaNom.cantidadDeSilabas <= 2) {			    temaNomPropuesto = OpPalabras.acentua(temaNom, -1, Acento.Agudo);			} else {			    temaNomPropuesto = OpPalabras.acentua(temaNom, -2, Acento.Agudo);			}			TermRegSustantivo regAux = reg.clona();			regAux.setNominativoPropuesto(temaNomPropuesto);			setSiguiente.add(regAux);		    }		}	    }	    if (origenTema.equals(OrigenTema.DativoPlural)) {		String temaOrig = OpPalabras.comeFinal(formaOriginal, terminacion.length());		String temaOrigBase = OpPalabras.desacentuar(temaOrig);		for (int i = 0; i < arrDP.length; i++) {		    if (tiposHoja.matches(arrDP[i][0])) {			String temaGen = (new StringBuilder(String.valueOf(temaOrigBase))).append(				OpPalabras.strBetaACompleto(arrDP[i][1])).toString();			temaGen = OpPalabras.acentuarMismaPosicion(formaOriginal, temaGen);			TermRegSustantivo regAux = reg.clona();			regAux.setGenitivoPropuesto(temaGen);			setSiguiente.add(regAux);		    }		}		if (tiposHoja.matches("(.*)(-112-|-70-|-25-|-61-|-29-|-30-)(.*)")) {		    String temaOrigNeutralizado = OpPalabras.desespirituar(temaOrigBase);		    String temaGen = null;		    if (temaOrigNeutralizado.endsWith(OpPalabras.strBetaACompleto("OU"))			    || temaOrigNeutralizado.endsWith(OpPalabras.strBetaACompleto("EI"))			    || temaOrigNeutralizado.endsWith(OpPalabras.strBetaACompleto("W"))) {			temaGen = OpPalabras.comeFinal(temaOrigBase, 1);			if (temaOrigNeutralizado.endsWith(OpPalabras.strBetaACompleto("W"))) {			    temaGen = (new StringBuilder(String.valueOf(temaGen))).append(				    OpPalabras.strBetaACompleto("O")).toString();			}			if (temaGen.length() == 1) {			    CarPos unica = CarPos.getCarPos(temaGen, 0);			    if (unica.esVocal() && !unica.tieneEspiritu()) {				com.kalos.enumeraciones.Espiritu espirituAnterior = OpPalabras.getEspiritu(temaOrigBase);				temaGen = OpPalabras.espirituPalabra(temaGen, espirituAnterior);			    }			}		    } else {			StringBuffer sb = new StringBuffer(temaOrigBase);			CarPos ultima = CarPos.getCarPos(sb.toString(), temaOrigBase.length() - 1);			sb.setCharAt(temaOrigBase.length() - 1, ultima.getVersionCorta());			temaGen = sb.toString();		    }		    if (tiposHoja.matches("(.*)(-25-|-61-)(.*)")) {			temaGen = (new StringBuilder(String.valueOf(temaGen))).append(				OpPalabras.strBetaACompleto("TOJ")).toString();		    } else {			temaGen = (new StringBuilder(String.valueOf(temaGen))).append(				OpPalabras.strBetaACompleto("NTOJ")).toString();		    }		    if (tiposHoja.matches("(.*)(-70-|-29-)(.*)")) {			TermRegSustantivo regAux = reg.clona();			String formaFinal = OpPalabras.acentua(temaGen);			regAux.setGenitivoPropuesto(formaFinal);			setSiguiente.add(regAux);		    }		    if (tiposHoja.matches("(.*)(-30-|-112-|-25-|-61-)(.*)")) {			TermRegSustantivo regAux = reg.clona();			String formaFinal = OpPalabras.acentua(temaGen, -2);			regAux.setGenitivoPropuesto(formaFinal);			setSiguiente.add(regAux);		    }		}	    }	}	StringBuffer sbDebug = new StringBuffer();	aplicaFiltroReglaNominativos(setSiguiente, sbDebug, cacheAA, debug);	if (debug) {	    System.out.println("reconstruyeTemas***********************************************");	    if (sbDebug.toString().length() > 0) {		System.out.println("  registros descartados por tener acento del nominativo propuesto menor que lo n"			+ "atural: ");		System.out.println(sbDebug.toString());	    }	    System.out.println("resultado: ");	    amUtil.debugBeans(setSiguiente,		    new String[] { "formaOriginal", "nominativoPropuesto", "genitivoPropuesto" });	}    }    public void aplicaFiltroReglaNominativos(Set setSiguiente, StringBuffer sbDebug, AACacheable cacheAA, boolean debug) {	for (Iterator it = setSiguiente.iterator(); it.hasNext();) {	    TermRegSustantivo trs = (TermRegSustantivo) it.next();	    if (trs.getNominativoPropuesto() != null) {		String nomPropuesto = trs.getNominativoPropuesto();		AnalisisAcento aaNom = cacheAA.getAnalisisAcento(nomPropuesto);		if (aaNom.actuales.silaba < aaNom.sugeridos.silaba) {		    if (debug) {			sbDebug.append((new StringBuilder("      quitando por regla del sustantivo ")).append(				OpBeans.debugBean(trs, new String[] { "nominativoPropuesto" })).toString());		    }		    it.remove();		}	    }	}    }    private boolean esNatural(String formaOriginal, AACacheable cacheAA) {	AnalisisAcento aaOrig = cacheAA.getAnalisisAcento(formaOriginal);	boolean tipoOK = aaOrig.sugeridos.tipoAcento == aaOrig.actuales.tipoAcento;	boolean posicionOK = aaOrig.sugeridos.silabaB1 == aaOrig.actuales.silabaB1;	return tipoOK && posicionOK;    }    public boolean todosTiposSonDelGenero(String contenidoCampo, Integer array[]) {	String tiposHojaStrings[] = contenidoCampo.split("\\-");	for (int i = 0; i < tiposHojaStrings.length; i++) {	    if (!tiposHojaStrings[i].equals("")) {		int tipoDelCampo = Integer.parseInt(tiposHojaStrings[i]);		boolean esDelGenero = false;		for (int e = 0; e < array.length; e++) {		    if (array[e].intValue() != tipoDelCampo) {			continue;		    }		    esDelGenero = true;		    break;		}		if (!esDelGenero) {		    return false;		}	    }	}	return true;    }    public void validaContraTerminacionesPendientes(Set set, AACacheable cacheAA, boolean debug) {	Iterator it = set.iterator();	while (it.hasNext()) {	    TermRegNominal fila = (TermRegNominal) it.next();	    TermRegSustantivo pendiente = (TermRegSustantivo) fila.getTerminacionPendienteRevision();	    if (pendiente == null || fila.getTipoSustantivo() != pendiente.getTipoSustantivo()) {		continue;	    }	    String nomPropuesto = fila.getNominativoPropuesto();	    String genPropuesto = fila.getGenitivoPropuesto();	    String formaOriginal = fila.getFormaOriginal();	    AnalisisAcento aaOriginal = cacheAA.getAnalisisAcento(formaOriginal);	    int silabaOrdenada = pendiente.getSilaba().getInt();	    if (silabaOrdenada != 0 && aaOriginal.actuales.silaba != silabaOrdenada) {		it.remove();		continue;	    }	    Acento acentoOrdenado = pendiente.getAcento();	    if (!acentoOrdenado.equals(Acento.Ninguno) && !aaOriginal.actuales.tipoAcento.equals(acentoOrdenado)) {		it.remove();		continue;	    }	    if (nomPropuesto != null || genPropuesto != null) {		String propuesto = nomPropuesto == null ? genPropuesto : nomPropuesto;		AnalisisAcento aaFormaOriginal = cacheAA.getAnalisisAcento(formaOriginal);		AnalisisAcento aaPropuesto = cacheAA.getAnalisisAcento(propuesto);		int posicionConcuerda = pendiente.getPosicionConcuerda();		int acentoConcuerda = pendiente.getAcentoConcuerda();		if (posicionConcuerda == 1			&& acentoConcuerda == 1			&& (aaFormaOriginal.actuales.tipoAcento != aaPropuesto.actuales.tipoAcento || aaFormaOriginal.actuales.silabaB1 != aaPropuesto.actuales.silabaB1)			|| posicionConcuerda == 1			&& acentoConcuerda == 0			&& (aaFormaOriginal.actuales.silabaB1 != aaPropuesto.actuales.silabaB1 || !aaFormaOriginal.actuales.esTipoAcentonaturalDadaPosicion)) {		    continue;		}	    }	    fila.setTerminacionPendienteRevision(null);	}	if (debug) {	    System.out.println("el set de nomGen luego de validarlo contra las terminaciones pendientes");	    amUtil.debugBeans(set, new String[] { "nominativoPropuesto", "genitivoPropuesto", "formaOriginal" });	}    }    private String[] labialOGutural(String tema, String terminacion, Caso caso, Numero numero) {	if ((caso == Caso.Nominativo || caso == Caso.Vocativo) && numero == Numero.Singular || caso == Caso.Dativo		&& numero == Numero.Plural) {	    char primera = terminacion.charAt(0);	    if (primera == '\u03BE') {		return genGuturales;	    } else {		return genLabiales;	    }	} else {	    return (new String[] { "OJ" });	}    }    public Integer[] getNomGenDistintos() {	List termNV = gerenteDesinSust.seleccionaNominativosSingulares();	List resultadosNoHoja = new ArrayList();	List aBorrar = new ArrayList();	for (int i = 0; i < termNV.size(); i++) {	    int anterior = 0;	    int siguiente = 0;	    if (i > 0) {		anterior = ((DesinSust) termNV.get(i - 1)).getTipoSustantivo();	    }	    if (i < termNV.size() - 1) {		siguiente = ((DesinSust) termNV.get(i + 1)).getTipoSustantivo();	    }	    int actual = ((DesinSust) termNV.get(i)).getTipoSustantivo();	    if (actual != anterior && actual != siguiente) {		resultadosNoHoja.add(Integer.valueOf(actual));		aBorrar.add((DesinSust) termNV.get(i));	    }	}	termNV.removeAll(aBorrar);	aBorrar.clear();	for (int i = 0; i < termNV.size(); i++) {	    int siguiente = 0;	    if (i < termNV.size() - 1) {		siguiente = ((DesinSust) termNV.get(i + 1)).getTipoSustantivo();	    }	    int actual = ((DesinSust) termNV.get(i)).getTipoSustantivo();	    if (actual == siguiente) {		DesinSust desActual = (DesinSust) termNV.get(i);		DesinSust desSiguiente = (DesinSust) termNV.get(i + 1);		if (desActual.getCaso().equals(Caso.Nominativo)			&& desSiguiente.getCaso().equals(Caso.Vocativo)			&& (!desActual.getDesinencia().equals(desSiguiente.getDesinencia()) || !desSiguiente				.getOrigenTema().equals(OrigenTema.NominativoSingular)				&& !desSiguiente.getOrigenTema().equals(OrigenTema.NominativoPlural))) {		    aBorrar.add(desActual);		    aBorrar.add(desSiguiente);		    resultadosNoHoja.add(Integer.valueOf(actual));		    resultadosNoHoja.add(Integer.valueOf(siguiente));		}	    }	}	termNV.removeAll(aBorrar);	Set resultados = new HashSet();	Map mapTipos = gerenteTiposSustantivo.getMapaTiposID();	for (Iterator iterator = resultadosNoHoja.iterator(); iterator.hasNext();) {	    Integer tipoNoHoja = (Integer) iterator.next();	    String idNoHoja = (String) mapTipos.get(tipoNoHoja);	    List hojas = gerenteTiposSustantivo.getTiposHoja(idNoHoja);	    TipoJerarquico tij;	    for (Iterator iterator1 = hojas.iterator(); iterator1.hasNext(); resultados.add(Integer.valueOf(tij		    .getValorEntero()))) {		tij = (TipoJerarquico) iterator1.next();	    }	}	List lstArray = new ArrayList(resultados);	return (Integer[]) lstArray.toArray(new Integer[0]);    }    public void setAmUtil(AMUtil amUtil) {	this.amUtil = amUtil;    }    public void setGerenteTermRegSustantivo(GerenteTermRegSustantivo gerenteTermRegSustantivo) {	this.gerenteTermRegSustantivo = gerenteTermRegSustantivo;    }    public Integer[] getNomVocDistintos() {	return nomVocDistintos;    }}
package kalos.flexion.conjugacion;import kalos.B.P;import kalos.B.U;import kalos.B.X;import kalos.B.Z;import kalos.B.c;import kalos.B.d;import kalos.B.j;import kalos.B.k;import kalos.E.E.aA;import kalos.E.E.fA;import kalos.G.F;import kalos.H.B;import kalos.H.B.A.A;import kalos.K.S;import kalos.K.h;import kalos.K.y;import kalos.datos.gerentes.GerenteIrrInfinitivos;import kalos.datos.gerentes.GerenteIrrVerbos;import kalos.datos.gerentes.GerentePreposicionesEnVerbos;import kalos.datos.gerentes.GerenteVerbos;import kalos.datos.gerentes.GerenteVerbosCompuestos;import kalos.enumeraciones.CompLetras;import kalos.enumeraciones.TipoVerbo;import kalos.enumeraciones.Voz;import kalos.flexion.Preposiciones;import kalos.flexion.conjugacion.negocio.ManejaDesinenciasInfinitivo;import kalos.operaciones.OpPalabras;import org.apache.log4j.Logger;// Referenced classes of package kalos.H.B://            Apublic class Infinitivos implements CompLetras, TipoVerbo {    private static class _A {	static String B;	static String A;	static void A(boolean flag, String s, String s1) {	    B = s;	    A = s1;	    if (flag) {		char c1 = s.charAt(s.length() - 1);		char c2 = s1.charAt(0);		if (c1 == '\u03C3') {		    if (c2 == '\u03C3') {			A = s1.substring(1);		    }		} else if (c1 == '\u03BC' && c2 != '\u03BC') {		    B = s.substring(0, s.length() - 1);		}	    }	}	private _A() {	}    }    private Verbos verbos;    private GerenteVerbos gerenteVerbos;    private GerenteIrrVerbos gerenteIrrVerbos;    private GerenteIrrInfinitivos gerenteIrrInfinitivos;    private ManejaDesinenciasInfinitivo manejaDesinenciasInfinitivo;    private GerenteVerbosCompuestos gerenteVerbosCompuestos;    private GerentePreposicionesEnVerbos gerentePreposicionesEnVerbos;    private Preposiciones preposiciones;    Logger logger;    public D() {	logger = Logger.getLogger(getClass().getName());    }    private void A(A a, h h1, List list) {	StringBuffer stringbuffer = new StringBuffer(OpPalabras.strBetaACompleto(h1.getVerbo()));	OpPalabras.desacentuar(stringbuffer);	StringBuffer stringbuffer1 = new StringBuffer();	Voz z;	if (F.esDeponente(h1.getTipoVerbo())) {	    z = Voz.Media;	} else {	    z = Voz.Activa;	}	stringbuffer1.append(stringbuffer);	verbos.extraeTemaDadaCanonica(stringbuffer1, h1.getTipoVerbo(), k.V);	OpPalabras.desacentuar(stringbuffer1);	switch (h1.getTipoVerbo()) {	case 21: // '\025'	case 24: // '\030'	case 25: // '\031'	case 26: // '\032'	case 51: // '3'	case 52: // '4'	case 53: // '5'	case 54: // '6'	case 55: // '7'	case 56: // '8'	case 57: // '9'	case 58: // ':'	case 59: // ';'	case 60: // '<'	case 61: // '='	case 62: // '>'	case 63: // '?'	case 64: // '@'	case 65: // 'A'	case 66: // 'B'	case 67: // 'C'	case 68: // 'D'	case 79: // 'O'	case 80: // 'P'	case 91: // '['	case 92: // '\\'	case 93: // ']'	case 94: // '^'	    A(a, k.V, stringbuffer1.toString(), 1, Voz.Activa , Voz.Media, z == Voz.Media, c.F, list);	    break;	case 45: // '-'	case 46: // '.'	case 47: // '/'	case 48: // '0'	case 49: // '1'	case 50: // '2'	    A(a, k.V, stringbuffer1.toString(), 4, Voz.Activa, Voz.Media, z == Voz.Media, c.D, list);	    break;	}    }    private void B(A a, h h1, List list) {	StringBuffer stringbuffer = new StringBuffer(OpPalabras.strBetaACompleto(h1.getVerbo()));	OpPalabras.desacentuar(stringbuffer);	StringBuffer stringbuffer1 = new StringBuffer();	Voz z;	if (F.esDeponente(h1.getTipoVerbo())) {	    z = Voz.Media;	} else {	    z = Voz.Activa;	}	stringbuffer1.append(stringbuffer);	verbos.extraeTemaDadaCanonica(stringbuffer1, h1.getTipoVerbo(), k.W);	boolean flag = z == Voz.Media;	OpPalabras.desacentuar(stringbuffer1);	String s = stringbuffer1.toString();	switch (h1.getTipoVerbo()) {	case 22: // '\026'	case 23: // '\027'	case 27: // '\033'	case 28: // '\034'	case 29: // '\035'	case 30: // '\036'	case 31: // '\037'	case 32: // ' '	case 33: // '!'	case 34: // '"'	case 35: // '#'	case 36: // '$'	case 37: // '%'	case 38: // '&'	case 39: // '\''	case 40: // '('	case 41: // ')'	case 42: // '*'	case 43: // '+'	case 44: // ','	case 69: // 'E'	case 70: // 'F'	case 71: // 'G'	case 72: // 'H'	case 75: // 'K'	case 76: // 'L'	case 77: // 'M'	case 78: // 'N'	case 81: // 'Q'	case 82: // 'R'	case 83: // 'S'	case 84: // 'T'	case 85: // 'U'	case 86: // 'V'	case 88: // 'X'	case 89: // 'Y'	case 90: // 'Z'	default:	    break;	case 73: // 'I'	case 74: // 'J'	case 87: // 'W'	    return;	case 45: // '-'	case 46: // '.'	case 47: // '/'	case 48: // '0'	case 49: // '1'	case 50: // '2'	    c c1 = c.F;	    A(a, k.W, stringbuffer1.toString(), 1, Voz.Activa, Voz.Pasiva, z == Voz.Media, c1, list);	    break;	case 21: // '\025'	case 24: // '\030'	case 25: // '\031'	case 26: // '\032'	    OpPalabras.alargaUltimaVocal(stringbuffer1);	    s = OpPalabras.acortaUltimaVocal(s);	    c c2 = c.F;	    A(a, k.W, stringbuffer1.toString(), s, 1, Voz.Activa, Voz.Pasiva, flag, c2, list);	    break;	case 51: // '3'	case 52: // '4'	case 53: // '5'	case 54: // '6'	case 55: // '7'	case 56: // '8'	case 57: // '9'	case 58: // ':'	case 59: // ';'	case 60: // '<'	case 61: // '='	case 62: // '>'	case 63: // '?'	case 64: // '@'	case 65: // 'A'	case 66: // 'B'	case 67: // 'C'	case 68: // 'D'	case 79: // 'O'	case 80: // 'P'	case 91: // '['	case 92: // '\\'	case 93: // ']'	case 94: // '^'	    c c3 = c.G;	    if (stringbuffer1.charAt(stringbuffer1.length() - 1) == '\u03B6') {		stringbuffer1.setCharAt(stringbuffer1.length() - 1, '\u03B4');	    }	    if (OpPalabras.right(stringbuffer1.toString(), 2) == "\u03C0\u03C4") {		stringbuffer1.deleteCharAt(stringbuffer1.length() - 1);	    }	    A(a, k.W, stringbuffer1.toString(), 1, Voz.Activa, Voz.Pasiva, flag, c3, list);	    break;	}    }    private void C(A a, h h1, List list) {	StringBuffer stringbuffer = new StringBuffer(OpPalabras.strBetaACompleto(h1.getVerbo()));	OpPalabras.desacentuar(stringbuffer);	StringBuffer stringbuffer1 = new StringBuffer();	Voz z;	if (F.esDeponente(h1.getTipoVerbo())) {	    z = Voz.Media;	} else {	    z = Voz.Activa;	}	stringbuffer1.append(stringbuffer);	verbos.extraeTemaDadaCanonica(stringbuffer1, h1.getTipoVerbo(), k.S);	switch (h1.getTipoVerbo()) {	case 22: // '\026'	case 23: // '\027'	case 27: // '\033'	case 28: // '\034'	case 29: // '\035'	case 30: // '\036'	case 31: // '\037'	case 32: // ' '	case 33: // '!'	case 34: // '"'	case 35: // '#'	case 36: // '$'	case 37: // '%'	case 38: // '&'	case 39: // '\''	case 40: // '('	case 41: // ')'	case 42: // '*'	case 43: // '+'	case 44: // ','	case 69: // 'E'	case 70: // 'F'	case 71: // 'G'	case 72: // 'H'	case 73: // 'I'	case 74: // 'J'	case 75: // 'K'	case 76: // 'L'	case 77: // 'M'	case 78: // 'N'	case 81: // 'Q'	case 82: // 'R'	case 83: // 'S'	case 84: // 'T'	case 85: // 'U'	case 86: // 'V'	case 87: // 'W'	case 88: // 'X'	case 89: // 'Y'	case 90: // 'Z'	default:	    break;	case 21: // '\025'	case 24: // '\030'	case 25: // '\031'	case 26: // '\032'	    OpPalabras.alargaUltimaVocal(stringbuffer1);	    stringbuffer1 = new StringBuffer(OpPalabras.desacentuar(stringbuffer1.toString()));	    String s = OpPalabras.acortaUltimaVocal(stringbuffer1.toString());	    A(a, k.S, stringbuffer1.toString(), s, 1, Voz.Activa, Voz.Pasiva, z == Voz.Media, c.F, list);	    break;	case 45: // '-'	case 46: // '.'	case 47: // '/'	case 48: // '0'	case 49: // '1'	case 50: // '2'	    A(a, k.S, stringbuffer1.toString(), 1, Voz.Activa, Voz.Pasiva, z == Voz.Media, c.F, list);	    break;	case 51: // '3'	case 52: // '4'	case 53: // '5'	case 54: // '6'	case 55: // '7'	case 56: // '8'	case 57: // '9'	case 58: // ':'	case 59: // ';'	case 60: // '<'	case 61: // '='	case 62: // '>'	case 63: // '?'	case 64: // '@'	case 65: // 'A'	case 66: // 'B'	case 67: // 'C'	case 68: // 'D'	case 79: // 'O'	case 80: // 'P'	case 91: // '['	case 92: // '\\'	case 93: // ']'	case 94: // '^'	    if (stringbuffer1.charAt(stringbuffer1.length() - 1) == '\u03B6') {		stringbuffer1.setCharAt(stringbuffer1.length() - 1, '\u03B4');	    }	    if (OpPalabras.right(stringbuffer1.toString(), 2) == "\u03C0\u03C4") {		stringbuffer1 = new StringBuffer(OpPalabras.left(stringbuffer1.toString(), stringbuffer1.length() - 1));	    }	    A(a, k.S, stringbuffer1.toString(), 1, Voz.Activa, Voz.Pasiva, z == Voz.Media, c.G, list);	    break;	}    }    private void D(A a, h h1, List list) {	StringBuffer stringbuffer = new StringBuffer(OpPalabras.strBetaACompleto(h1.getVerbo()));	OpPalabras.desacentuar(stringbuffer);	StringBuffer stringbuffer4 = new StringBuffer();	Z z;	if (F.esDeponente(h1.getTipoVerbo())) {	    z = Voz.Media;	} else {	    z = Voz.Activa;	}	stringbuffer4.append(stringbuffer);	verbos.extraeTemaDadaCanonica(stringbuffer4, h1.getTipoVerbo(), k.U);	boolean flag = z == Voz.Media;	switch (h1.getTipoVerbo()) {	case 22: // '\026'	case 23: // '\027'	case 27: // '\033'	case 28: // '\034'	case 29: // '\035'	case 30: // '\036'	case 31: // '\037'	case 32: // ' '	case 33: // '!'	case 34: // '"'	case 35: // '#'	case 36: // '$'	case 37: // '%'	case 38: // '&'	case 39: // '\''	case 40: // '('	case 41: // ')'	case 42: // '*'	case 43: // '+'	case 44: // ','	case 69: // 'E'	case 70: // 'F'	case 71: // 'G'	case 72: // 'H'	case 73: // 'I'	case 74: // 'J'	case 75: // 'K'	case 76: // 'L'	case 77: // 'M'	case 78: // 'N'	case 81: // 'Q'	case 82: // 'R'	case 83: // 'S'	case 84: // 'T'	case 85: // 'U'	case 86: // 'V'	case 87: // 'W'	case 88: // 'X'	case 89: // 'Y'	case 90: // 'Z'	default:	    break;	case 21: // '\025'	case 24: // '\030'	case 25: // '\031'	case 26: // '\032'	    OpPalabras.alargaUltimaVocal(stringbuffer4);	    StringBuffer stringbuffer1 = new StringBuffer(OpPalabras.reduplica(stringbuffer4.toString()));	    stringbuffer1 = new StringBuffer(OpPalabras.acortaUltimaVocal(stringbuffer1.toString()));	    A(a, k.U, stringbuffer1.toString(), 1, Voz.Activa, Voz.Media, flag, c.F, list);	    break;	case 45: // '-'	case 46: // '.'	case 47: // '/'	case 48: // '0'	case 49: // '1'	case 50: // '2'	    StringBuffer stringbuffer2 = new StringBuffer(OpPalabras.reduplica(stringbuffer4.toString()));	    A(a, k.U, stringbuffer2.toString(), 1, Voz.Activa, Voz.Media, flag, c.F, list);	    break;	case 51: // '3'	case 52: // '4'	case 53: // '5'	case 54: // '6'	case 55: // '7'	case 56: // '8'	case 57: // '9'	case 58: // ':'	case 59: // ';'	case 60: // '<'	case 61: // '='	case 62: // '>'	case 63: // '?'	case 64: // '@'	case 65: // 'A'	case 66: // 'B'	case 67: // 'C'	case 68: // 'D'	case 79: // 'O'	case 80: // 'P'	case 91: // '['	case 92: // '\\'	case 93: // ']'	case 94: // '^'	    if (stringbuffer4.charAt(stringbuffer4.length() - 1) == '\u03B6') {		stringbuffer4.setCharAt(stringbuffer4.length() - 1, '\u03B4');	    }	    if (OpPalabras.right(stringbuffer4.toString(), 2) == "\u03C0\u03C4") {		stringbuffer4.deleteCharAt(stringbuffer4.length() - 1);	    }	    if ((OpPalabras.right(stringbuffer4.toString(), 2) == "\u03C3\u03C3")		    | (OpPalabras.right(stringbuffer4.toString(), 2) == "\u03C4\u03C4")) {		stringbuffer4.delete(stringbuffer4.length() - 2, stringbuffer4.length());		stringbuffer4.append('\u03B3');	    }	    StringBuffer stringbuffer3 = new StringBuffer(OpPalabras.reduplica(stringbuffer4.toString()));	    A(a, k.U, stringbuffer3.toString(), 1, Voz.Activa, Voz.Media, flag, c.G, list);	    break;	}    }    private void A(k k1, A a, List list, List list1, List list2) {	Iterator iterator = list.iterator();	do {	    if (!iterator.hasNext()) {		break;	    }	    S s = (S) iterator.next();	    String s1 = OpPalabras.strBetaACompleto(s.getTema());	    if (s.isReduplicacion()) {		s1 = OpPalabras.reduplica(s1);	    }	    boolean flag = s.getTiempo() == j.L;	    boolean flag1 = (s.getVoz() == Voz.Activa) & (s.getVozJuego() == Voz.Media);	    boolean flag2 = s.getPropagacion().equals(d.E) || s.getPropagacion().equals(d.B);	    A(a, s1, s.getVoz(), ((U) (k1)), s.getFuerte(), s.getContraccion(), s.getJuego(), s.getVozJuego(),		    ((U) (s.getTiempoJuego())), flag, list2, s.getSubPart());	    if (flag2 && !flag1 && s.getVoz().equals(Voz.Activa)) {		A(a, s1, Voz.Media, ((U) (k1)), s.getFuerte(), s.getContraccion(), s.getJuego(), Voz.Media,			((U) (s.getTiempoJuego())), flag, list2, s.getSubPart());	    }	} while (true);	A(a, list1, k1, list2);    }    public void conjugaPorDefecto(A a, h h1, List list) {	A(a, h1, list);	B(a, h1, list);	C(a, h1, list);	D(a, h1, list);    }    private void A(A a, List list, k k1, List list1) {	y y1;	String s;	for (Iterator iterator = list.iterator(); iterator.hasNext(); a.agregaFormaIndividual(y1.getVoz(), k1,		y1.getFuerte(), s, y1.getSupPart())) {	    y1 = (y) iterator.next();	    s = OpPalabras.strBetaACompleto(y1.getForma());	    s = preposiciones.une(s, list1, false);	}    }    private void A(A a, k k1, String s, int i, Z z, Z z1, boolean flag, c c1, List list) {	A(a, k1, s, s, i, P.A, z, z1, flag, c1, null, false, list);    }    private void A(A a, k k1, String s, String s1, int i, Z z, Z z1, boolean flag, c c1, List list) {	A(a, k1, s, s1, i, P.A, z, z1, flag, c1, (k) null, false, list);    }    private void A(A a, k k1, String s, String s1, int i, P p, Z z, Z z1, boolean flag, c c1, k k2, boolean flag1,	    List list) {	for (int l = Z.getInt(z); l <= Z.getInt(z1); l++) {	    Z z2 = Z.getEnum(l);	    if (flag && z2.equals(Voz.Media)) {		continue;	    }	    Z z3;	    if (flag && z2.equals(Voz.Activa)) {		z3 = Voz.Media;	    } else {		z3 = z2;	    }	    if (k2 == null) {		k2 = k1;	    }	    String s2 = null;	    if (z2 == Voz.Pasiva) {		s2 = s1;	    } else {		s2 = s;	    }	    A(a, s2, z2, ((U) (k1)), p, c1, i, z3, ((U) (k2)), flag1, list, 0);	}    }    private void A(A a, String s, Z z, U u, P p, c c1, int i, Z z1, U u1, boolean flag, List list, int l) {	k k1 = kalos.B.A.A.comoAspecto(u1);	kalos.H.B.A.D ad[] = manejaDesinenciasInfinitivo.getDesinencias(i, z1, k1, p);	if (ad == null) {	    return;	}	for (int i1 = 0; i1 < ad.length; i1++) {	    String s1 = ad[i1].A;	    kalos.H.B._A.A(flag, s, s1);	    s = kalos.H.B._A.B;	    s1 = kalos.H.B._A.A;	    int j1 = ad[i1].getPosicion();	    E e = ad[i1].getTipoAcento();	    if (s1.equals("&")) {		a.agregaFormaIndividual(z, k1, p, preposiciones.une(s, list, true), l);	    } else {		String s2 = OpPalabras.contraeGenerica(s, s1, c1, j1, e);		boolean flag1 = j1 == 0 && c1 != c.D;		s2 = preposiciones.une(s2, list, flag1);		a.agregaFormaIndividual(z, k1, p, s2, l);	    }	}    }    public void conjuga(A a, h h1, X x) {	h h2 = h1;	List list = null;	if (h1.isCompuesto()) {	    kalos.K.H h3 = gerenteVerbosCompuestos.seleccionaPorVerboCompuesto(h1.getId());	    h2 = gerenteVerbos.seleccionaIndividualSinSignificado(h3.getIdVerboSimple());	    if (h1.isCompuesto()) {		list = gerentePreposicionesEnVerbos.seleccionaPorVerbo(h1.getId());		for (int i = 0; i < list.size(); i++) {		    list.set(i, OpPalabras.strBetaACompleto((String) list.get(i)));		}	    }	}	if (!h2.isDibujado() && x.equals(h2.getParticularidad())) {	    conjugaPorDefecto(a, h2, list);	}	A(a, h2, x, list);	if (h1.isCompuesto()) {	    A(a, h1, x, null);	}    }    private void A(A a, h h1, X x, List list) {	Object obj = new ArrayList();	Object obj1 = new ArrayList();	obj = gerenteIrrVerbos.seleccionaPorVerboParticParaInfinitivos(h1.getId(), x);	obj1 = gerenteIrrInfinitivos.seleccionaPorVerbopartic(h1.getId(), x);	ArrayList arraylist = new ArrayList();	ArrayList arraylist1 = new ArrayList();	ArrayList arraylist2 = new ArrayList();	ArrayList arraylist3 = new ArrayList();	ArrayList arraylist4 = new ArrayList();	ArrayList arraylist5 = new ArrayList();	ArrayList arraylist6 = new ArrayList();	ArrayList arraylist7 = new ArrayList();	A(((List) (obj)), ((List) (obj1)), ((List) (arraylist)), ((List) (arraylist1)), ((List) (arraylist2)),		((List) (arraylist3)), ((List) (arraylist4)), ((List) (arraylist5)), ((List) (arraylist6)),		((List) (arraylist7)));	A(k.V, a, ((List) (arraylist)), ((List) (arraylist4)), list);	A(k.W, a, ((List) (arraylist1)), ((List) (arraylist5)), list);	A(k.S, a, ((List) (arraylist2)), ((List) (arraylist6)), list);	A(k.U, a, ((List) (arraylist3)), ((List) (arraylist7)), list);    }    private void A(List list, List list1, List list2, List list3, List list4, List list5, List list6, List list7,	    List list8, List list9) {	kalos.H.A.A.distribuye(list, "tiempo", new j[] { j.Q, j.R, j.O, j.L },		new List[] { list2, list3, list4, list5 });	kalos.H.A.A.distribuye(list1, "aspecto", new k[] { k.V, k.W, k.S, k.U }, new List[] { list6, list7, list8,		list9 });    }    public kalos.H.B.A getVerbos() {	return verbos;    }    public void setVerbos(Verbos a) {	verbos = a;    }    public GerenteIrrVerbos getGerenteIrrVerbos() {	return gerenteIrrVerbos;    }    public void setGerenteIrrVerbos(kalos.E.E.y y1) {	gerenteIrrVerbos = y1;    }    public GerenteIrrInfinitivos getGerenteIrrInfinitivos() {	return gerenteIrrInfinitivos;    }    public void setGerenteIrrInfinitivos(GerenteIrrInfinitivos aa) {	gerenteIrrInfinitivos = aa;    }    public GerenteVerbos getGerenteVerbos() {	return gerenteVerbos;    }    public void setGerenteVerbos(GerenteVerbos p) {	gerenteVerbos = p;    }    public void setManejaDesinenciasInfinitivo(kalos.H.B.A.E e) {	manejaDesinenciasInfinitivo = e;    }    public void setGerentePreposicionesEnVerbos(GerentePreposicionesEnVerbos fa) {	gerentePreposicionesEnVerbos = fa;    }    public void setGerenteVerbosCompuestos(GerenteVerbosCompuestos u) {	gerenteVerbosCompuestos = u;    }    public void setPreposiciones(B b) {	preposiciones = b;    }}
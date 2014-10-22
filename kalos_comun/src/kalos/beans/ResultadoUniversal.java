package kalos.beans;import java.util.List;import kalos.enumeraciones.Aspecto;import kalos.enumeraciones.Caso;import kalos.enumeraciones.FuerteDebil;import kalos.enumeraciones.Genero;import kalos.enumeraciones.GradoComparacion;import kalos.enumeraciones.Modo;import kalos.enumeraciones.Numero;import kalos.enumeraciones.Particularidad;import kalos.enumeraciones.Persona;import kalos.enumeraciones.Tiempo;import kalos.enumeraciones.TipoPalabra;import kalos.enumeraciones.Voz;import org.apache.log4j.Logger;public class ResultadoUniversal {    Logger U = Logger.getLogger(getClass().getName());    private TipoPalabra tipoPalabra;    private String id;    private String significado;    private Particularidad particCanonica;    private Particularidad particIrr;    private Voz voz;    private String formaAccidentada;    private Tiempo tiempo;    private Aspecto aspecto;    private FuerteDebil fuerteDebil;    private Persona persona;    private Caso caso;    private Genero genero;    private Numero numero;    private Modo modo;    private GradoComparacion grado;    private String formaCanonica;    private List<String> preposiciones;    private String idCompuesto;    Integer O;    public String getIdSimpleOCompuesto() {	if (this.idCompuesto == null) {	    return this.id;	}	return this.idCompuesto;    }    public ResultadoUniversal() {    }    public ResultadoUniversal(TipoPalabra paraml, String paramString1, String paramString2, Particularidad paramX1, Particularidad paramX2, Voz paramZ,	    String paramString3, Tiempo paramj, Aspecto paramk, FuerteDebil paramP, Persona param_, Caso parama, Genero paramA,	    Numero paramn, Modo paramp, GradoComparacion parami, String paramString4, List<String> paramList, String paramString5) {	this.tipoPalabra = paraml;	this.id = paramString1;	this.significado = paramString2;	this.particCanonica = paramX1;	this.particIrr = paramX2;	this.voz = paramZ;	this.formaAccidentada = paramString3;	this.tiempo = paramj;	this.aspecto = paramk;	this.fuerteDebil = paramP;	this.persona = param_;	this.caso = parama;	this.genero = paramA;	this.numero = paramn;	this.modo = paramp;	this.grado = parami;	this.formaCanonica = paramString4;	this.preposiciones = paramList;	this.idCompuesto = paramString5;	this.O = Integer.valueOf(B());    }    public boolean equals(Object paramObject) {	if ((paramObject instanceof ResultadoUniversal)) {	    ResultadoUniversal localj = (ResultadoUniversal) paramObject;	    return localj.A().equals(A());	}	return false;    }    public int hashCode() {	if (this.O == null) {	    this.O = Integer.valueOf(B());	}	return this.O.intValue();    }    private String A() {	StringBuffer localStringBuffer = new StringBuffer(100);	localStringBuffer.append(this.tipoPalabra);	localStringBuffer.append("|");	localStringBuffer.append(this.id);	localStringBuffer.append("|");	localStringBuffer.append(this.significado);	localStringBuffer.append("|");	localStringBuffer.append(this.particCanonica);	localStringBuffer.append("|");	localStringBuffer.append(this.particIrr);	localStringBuffer.append("|");	localStringBuffer.append(this.voz);	localStringBuffer.append("|");	localStringBuffer.append(this.formaAccidentada);	localStringBuffer.append("|");	localStringBuffer.append(this.tiempo);	localStringBuffer.append("|");	localStringBuffer.append(this.aspecto);	localStringBuffer.append("|");	localStringBuffer.append(this.fuerteDebil);	localStringBuffer.append("|");	localStringBuffer.append(this.persona);	localStringBuffer.append("|");	localStringBuffer.append(this.caso);	localStringBuffer.append("|");	localStringBuffer.append(this.genero);	localStringBuffer.append("|");	localStringBuffer.append(this.numero);	localStringBuffer.append("|");	localStringBuffer.append(this.modo);	localStringBuffer.append("|");	localStringBuffer.append(this.grado);	localStringBuffer.append("|");	localStringBuffer.append(this.formaCanonica);	localStringBuffer.append("|");	if (this.preposiciones != null) {	    localStringBuffer.append(this.preposiciones.toString());	    localStringBuffer.append("|");	}	return localStringBuffer.toString();    }    private int B() {	return 0;    }    public Aspecto getAspecto() {	return this.aspecto;    }    public void setAspecto(Aspecto paramk) {	this.aspecto = paramk;	this.O = null;    }    public Caso getCaso() {	return this.caso;    }    public void setCaso(Caso parama) {	this.caso = parama;	this.O = null;    }    public String getFormaAccidentada() {	return this.formaAccidentada;    }    public void setFormaAccidentada(String paramString) {	this.formaAccidentada = paramString;	this.O = null;    }    public String getFormaCanonica() {	return this.formaCanonica;    }    public void setFormaCanonica(String paramString) {	this.formaCanonica = paramString;	this.O = null;    }    public FuerteDebil getFuerte() {	return this.fuerteDebil;    }    public void setFuerte(FuerteDebil paramP) {	this.fuerteDebil = paramP;	this.O = null;    }    public Genero getGenero() {	return this.genero;    }    public void setGenero(Genero paramA) {	this.genero = paramA;	this.O = null;    }    public String getId() {	return this.id;    }    public void setId(String paramString) {	this.id = paramString;	this.O = null;    }    public Modo getModo() {	return this.modo;    }    public void setModo(Modo paramp) {	this.modo = paramp;	this.O = null;    }    public void setGrado(GradoComparacion parami) {	this.grado = parami;	this.O = null;    }    public Numero getNumero() {	return this.numero;    }    public void setNumero(Numero paramn) {	this.numero = paramn;	this.O = null;    }    public Particularidad getParticCanonica() {	return this.particCanonica;    }    public Particularidad getParticularidad() {	if (this.particIrr != null) {	    return this.particIrr;	}	return this.particCanonica;    }    public void setParticCanonica(Particularidad paramX) {	this.particCanonica = paramX;	this.O = null;    }    public Particularidad getParticIrr() {	return this.particIrr;    }    public void setParticIrr(Particularidad paramX) {	this.particIrr = paramX;	this.O = null;    }    public Persona getPersona() {	return this.persona;    }    public void setPersona(Persona param_) {	this.persona = param_;	this.O = null;    }    public List<String> getPreposiciones() {	return this.preposiciones;    }    public void setPreposiciones(List<String> paramList) {	this.preposiciones = paramList;	this.O = null;    }    public String getSignificado() {	return this.significado;    }    public void setSignificado(String paramString) {	this.significado = paramString;	this.O = null;    }    public Tiempo getTiempo() {	return this.tiempo;    }    public void setTiempo(Tiempo paramj) {	this.tiempo = paramj;	this.O = null;    }    public TipoPalabra getTipoPalabra() {	return this.tipoPalabra;    }    public void setTipoPalabra(TipoPalabra paraml) {	this.tipoPalabra = paraml;	this.O = null;    }    public Voz getVoz() {	return this.voz;    }    public void setVoz(Voz paramZ) {	this.voz = paramZ;	this.O = null;    }    public GradoComparacion getGrado() {	return this.grado;    }    public String getIdCompuesto() {	return this.idCompuesto;    }    public void setIdCompuesto(String paramString) {	this.idCompuesto = paramString;    }}
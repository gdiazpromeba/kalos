package kalos.datos.gerentes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import kalos.beans.EntradaDiccionario;
import kalos.beans.Significado;
import kalos.enumeraciones.Idioma;
import kalos.enumeraciones.LugarSubcadena;
import kalos.enumeraciones.TipoPalabra;
import kalos.operaciones.OpBeans;
import kalos.operaciones.comparadores.ComparadorBeansGriegos;
import kalos.recursos.Configuracion;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

public class GerenteDiccionarioImpl extends JdbcDaoSupport implements GerenteDiccionario {

    private class SelRefPorLetraSinSig extends SelReferenteId {

	public SelRefPorLetraSinSig(DataSource datasource) {
	    super(datasource, selRefPorLetraSinSigSql);
	    declareParameter(new SqlParameter(1));
	}
    }

    class SelReferenteId extends MappingSqlQuery {

	protected Object mapRow(ResultSet resultset, int i) throws SQLException {
	    String s = resultset.getString("REFERENTE_ID");
	    return s;
	}

	public SelReferenteId(DataSource datasource, String s) {
	    super(datasource, s);
	}
    }

    class SelConSig extends SelAbstractaConSig {

	public SelConSig(DataSource datasource, String s) {
	    super(datasource, s);
	}
    }

    class SelSinSig extends SelAbstractaSinSig {

	public SelSinSig(DataSource datasource, String s) {
	    super(datasource, s);
	}
    }

    abstract class SelAbstractaSinSig extends MappingSqlQuery {

	protected Object mapRow(ResultSet resultset, int i) throws SQLException {
	    EntradaDiccionario n = new EntradaDiccionario();
	    n.setId(resultset.getString("REFERENTE_ID"));
	    n.setNormal(resultset.getString("NORMAL_UNICODE"));
	    n.setTipoPalabra(TipoPalabra.getEnum(resultset.getString("TIPO_PALABRA")));
	    n.setNormalBeta(resultset.getString("NORMAL"));
	    return n;
	}

	public SelAbstractaSinSig(DataSource datasource, String s) {
	    super(datasource, s);
	}
    }

    abstract class SelAbstractaConSig extends MappingSqlQuery {

	protected Object mapRow(ResultSet resultset, int i) throws SQLException {
	    EntradaDiccionario n = new EntradaDiccionario();
	    n.setId(resultset.getString("REFERENTE_ID"));
	    n.setNormal(resultset.getString("NORMAL_UNICODE"));
	    n.setTipoPalabra(TipoPalabra.getEnum(resultset.getString("TIPO_PALABRA")));
	    n.setNormalBeta(resultset.getString("NORMAL"));
	    Significado q1 = new Significado();
	    q1.setIdioma(Configuracion.getIdiomaSignificados());
	    q1.setReferenteId(n.getId());
	    q1.setId(resultset.getString("SIGNIFICADO_ID"));
	    q1.setValor(resultset.getString("VALOR"));
	    HashMap<Idioma, Significado> hashmap = new HashMap<Idioma, Significado>();
	    hashmap.put(Idioma.getEnum(Configuracion.getIdiomaSignificados()), q1);
	    n.setSignificados(hashmap);
	    return n;
	}

	public SelAbstractaConSig(DataSource datasource, String s) {
	    super(datasource, s);
	}
    }

    private void puebla() {
	StringBuffer stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID \n");
	stringbuffer.append("FROM \n");
	stringbuffer.append("  DICCIONARIO DIC  \n");
	stringbuffer.append("WHERE \n");
	stringbuffer.append("  DIC.LETRA=? \n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selRefPorLetraSinSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID \n");
	stringbuffer.append("FROM \n");
	stringbuffer.append("  DICCIONARIO DIC \n");
	stringbuffer.append("  INNER JOIN SIGNIFICADOS SIG  ON SIG.REFERENTE_ID=DIC.REFERENTE_ID \n");
	stringbuffer.append("WHERE \n");
	stringbuffer.append("  DIC.NEUTRALIZADA LIKE __NEUTRALIZADA__ \n");
	stringbuffer.append("  AND SIG.IDIOMA='" + Configuracion.getIdiomaSignificados() + "'  \n");
	stringbuffer.append("  AND DIC.TIPO_PALABRA IN (__TIPO_PALABRA__)  \n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selRefPorTipoPalabraConSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID \n");
	stringbuffer.append("FROM \n");
	stringbuffer.append("  DICCIONARIO DIC \n");
	stringbuffer.append("  INNER JOIN SIGNIFICADOS SIG  ON SIG.REFERENTE_ID=DIC.REFERENTE_ID \n");
	stringbuffer.append("WHERE \n");
	stringbuffer.append("  AND SIG.IDIOMA='" + Configuracion.getIdiomaSignificados() + "'  \n");
	stringbuffer.append("  AND DIC.TIPO_PALABRA IN (__TIPO_PALABRA__)  \n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selRefPorTipoPalabraConSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID \n");
	stringbuffer.append("FROM \n");
	stringbuffer.append("  DICCIONARIO DIC \n");
	stringbuffer.append("  INNER JOIN SIGNIFICADOS SIG  ON SIG.REFERENTE_ID=DIC.REFERENTE_ID \n");
	stringbuffer.append("WHERE \n");
	stringbuffer.append("  DIC.SIN_LARGAS LIKE __SIN_LARGAS__ \n");
	stringbuffer.append("  AND SIG.IDIOMA='" + Configuracion.getIdiomaSignificados() + "'  \n");
	stringbuffer.append("  AND DIC.TIPO_PALABRA IN (__TIPO_PALABRA__)  \n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selRefPorTipoPalabraYSinLargasConSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID \n");
	stringbuffer.append("FROM \n");
	stringbuffer.append("  DICCIONARIO DIC \n");
	stringbuffer.append("WHERE \n");
	stringbuffer.append("  DIC.NORMAL LIKE ? \n");
	stringbuffer.append("  AND DIC.TIPO_PALABRA IN (__TIPO_PALABRA__)  \n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selRefPorTipoPalabrayNormalSinSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("SELECT \n");
	stringbuffer.append("  DIC.REFERENTE_ID,\n");
	stringbuffer.append("  DIC.NORMAL,\n");
	stringbuffer.append("  DIC.NORMAL_UNICODE,\n");
	stringbuffer.append("  DIC.TIPO_PALABRA,\n");
	stringbuffer.append("  SIG.SIGNIFICADO_ID,\n");
	stringbuffer.append("  SIG.VALOR\n");
	stringbuffer.append("FROM  \n");
	stringbuffer.append("  DICCIONARIO DIC\n");
	stringbuffer.append(" INNER JOIN SIGNIFICADOS SIG\n");
	stringbuffer.append(" ON DIC.REFERENTE_ID=SIG.REFERENTE_ID\n");
	stringbuffer.append("WHERE\n");
	stringbuffer.append("  AND SIG.IDIOMA='" + Configuracion.getIdiomaSignificados() + "'  \n");
	stringbuffer.append(" AND DIC.REFERENTE_ID IN (?)\n");
	stringbuffer.append("ORDER BY \n");
	stringbuffer.append("  DIC.CODIGO \n");
	selFormasPorRefConSigSql = stringbuffer.toString();
	stringbuffer = new StringBuffer(200);
	stringbuffer.append("UPDATE DICCIONARIO SET   \n");
	stringbuffer.append("  CODIGO=?   \n");
	stringbuffer.append("WHERE    \n");
	stringbuffer.append("  REFERENTE_ID=?   \n");
	updateCodigoSql = stringbuffer.toString();
    }

    public List<String> seleccionaPorLetra(String s) {
	return selRefPorLetraSinSig.execute(new Object[] { s });
    }

    public void ordena(String letra) {
	List<String> ids = selRefPorLetraSinSig.execute(letra);
	List<EntradaDiccionario> beans = getRegistros(ids);
	String[] camposaABeta = new String[] { "normalBeta" };
	OpBeans.pasaDeBetaACompleto(beans, camposaABeta);
	Collections.sort(beans, new ComparadorBeansGriegos(camposaABeta));
	OpBeans.pasaDeCompletoABeta(beans, camposaABeta);
	int contador = 10;
	for (EntradaDiccionario bean : beans) {
	    String id = bean.getId();
	    modificaCodigoIndividual(contador, id);
	    contador += 10;
	}
    }

    public List seleccionaPorNeutralizada(String s, LugarSubcadena h1, List list) {
	String s1 = null;
	switch (h1) {
	case Principio: // '\001'
	    s1 = (new StringBuilder()).append("'").append(s).append("%'").toString();
	    break;

	case Medio: // '\002'
	    s1 = (new StringBuilder()).append("'%").append(s).append("%'").toString();
	    break;

	case Fin: // '\003'
	    s1 = (new StringBuilder()).append("'%").append(s).append("'").toString();
	    break;

	case Exacto: // '\004'
	    s1 = (new StringBuilder()).append("'").append(s).append("'").toString();
	    break;
	}
	String s2 = selRefPorTipoPalabraConSigSql.replaceFirst("__NEUTRALIZADA__", s1);
	s2 = s2.replaceFirst("__TIPO_PALABRA__", concatenaTipos(list));
	SelReferenteId _ld = new SelReferenteId(getDataSource(), s2);
	List list1 = _ld.execute();
	return list1;
    }

    public List seleccionaPorTipos(List list) {
	String s = selRefPorTipoPalabraConSigSql;
	s = s.replaceFirst("__TIPO_PALABRA__", concatenaTipos(list));
	SelReferenteId _ld = new SelReferenteId(getDataSource(), s);
	List list1 = _ld.execute();
	return list1;
    }

    private String concatenaTipos(List<String> list) {
	StringBuffer stringbuffer = new StringBuffer(200);
	for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
	    String l1 = iterator.next();
	    stringbuffer.append("'").append(l1).append("',");
	}
	if (stringbuffer.length() > 0)
	    stringbuffer.delete(stringbuffer.length() - 1, stringbuffer.length());
	return stringbuffer.toString();
    }

    public List seleccionaPorSinLargas(String s, LugarSubcadena h1, List list) {
	String s1 = null;
	switch (h1) {
	case Principio: // '\001'
	    s1 = (new StringBuilder()).append("'").append(s).append("%'").toString();
	    break;

	case Medio: // '\002'
	    s1 = (new StringBuilder()).append("'%").append(s).append("%'").toString();
	    break;

	case Fin: // '\003'
	    s1 = (new StringBuilder()).append("'%").append(s).append("'").toString();
	    break;

	case Exacto: // '\004'
	    s1 = (new StringBuilder()).append("'").append(s).append("'").toString();
	    break;
	}
	String s2 = selRefPorTipoPalabraYSinLargasConSigSql.replaceFirst("__SIN_LARGAS__", s1);
	s2 = s2.replaceFirst("__TIPO_PALABRA__", concatenaTipos(list));
	SelReferenteId _ld = new SelReferenteId(getDataSource(), s2);
	List list1 = _ld.execute();
	return list1;
    }

    public List seleccionaPorNormal(String s, LugarSubcadena h1, List list) {
	String s1 = null;
	switch (h1) {
	case Principio: // '\001'
	    s1 = (new StringBuilder()).append("'").append(s).append("%'").toString();
	    break;

	case Medio: // '\002'
	    s1 = (new StringBuilder()).append("'%").append(s).append("%'").toString();
	    break;

	case Fin: // '\003'
	    s1 = (new StringBuilder()).append("'%").append(s).append("'").toString();
	    break;

	case Exacto: // '\004'
	    s1 = (new StringBuilder()).append("'").append(s).append("'").toString();
	    break;
	}
	s1 = StringUtils.replace(s1, "_", "\\\\_");
	String s2 = StringUtils.replace(selRefPorTipoPalabrayNormalSinSigSql, "?", s1);
	s2 = s2.replaceFirst("__TIPO_PALABRA__", concatenaTipos(list));
	SelReferenteId _ld = new SelReferenteId(getDataSource(), s2);
	List list1 = _ld.execute();
	return list1;
    }

    public void modificaCodigoIndividual(int codigo, String id) {
	updateCodigo.update(new Object[] { Integer.valueOf(codigo), id });
    }

    public List getRegistros(List<String> ids) {
	StringBuffer sb = new StringBuffer();
	for (String id : ids) {
	    sb.append("'" + id + "',");
	}
	sb.deleteCharAt(sb.length() - 1);
	String s = selFormasPorRefConSigSql.replaceFirst("\\?", sb.toString());
	SelConSig _la = new SelConSig(getDataSource(), s);
	List list2 = _la.execute();
	return list2;
    }

    public void initDao() throws Exception {
	super.initDao();
	puebla();
	updateCodigo = new SqlUpdate(getDataSource(), updateCodigoSql);
	selRefPorLetraSinSig = new SelRefPorLetraSinSig(getDataSource());
    }

    private SqlUpdate updateCodigo;
    private SelRefPorLetraSinSig selRefPorLetraSinSig;
    private static String selRefPorLetraSinSigSql;
    private static String selRefPorTipoPalabraConSigSql;
    private static String selRefPorTipoPalabraYSinLargasConSigSql;
    private static String selRefPorTipoPalabrayNormalSinSigSql;
    private static String selFormasPorRefConSigSql;
    private static String selFormasPorRefSinSigSql;
    private static String updateCodigoSql;

}

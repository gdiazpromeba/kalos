// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package com.kalos.datos.dao;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.sql.DataSource;import com.kalos.beans.Significado;import com.kalos.beans.SustantivoBean;import com.kalos.datos.dao.comunes.SeleccionIds;import com.kalos.datos.util.DBUtil;import com.kalos.enumeraciones.Genero;import com.kalos.enumeraciones.Idioma;import com.kalos.enumeraciones.LugarSubcadena;import com.kalos.enumeraciones.Particularidad;import com.kalos.recursos.Configuracion;import com.kalos.utils.Listas;import org.springframework.jdbc.core.SqlParameter;import org.springframework.jdbc.core.support.JdbcDaoSupport;import org.springframework.jdbc.object.MappingSqlQuery;import org.springframework.jdbc.object.SqlUpdate;// Referenced classes of package kalos.E.C://            $Apublic class SustantivosDAOImpl extends JdbcDaoSupport implements		SustantivosDAO {	class Borrado extends SqlUpdate {		public Borrado(DataSource datasource) {			super(datasource, DELETE_SQL);			declareParameter(new SqlParameter(1));		}	}	class ModifCodigoIndividual extends SqlUpdate {		public ModifCodigoIndividual(DataSource datasource) {			super(datasource, UPDATE_CODIGO_INDIV_SQL);			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));		}	}	class ModificacionCodigoMult extends SqlUpdate {		public ModificacionCodigoMult(DataSource datasource) {			super(datasource, UPDATE_CODIGO_MULT_SQL);			declareParameter(new SqlParameter(1));		}	}	class Modificacion extends SqlUpdate {		public Modificacion(DataSource datasource) {			super(datasource, UPDATE_SQL);			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));		}	}	class Insercion extends SqlUpdate {		public Insercion(DataSource datasource) {			super(datasource, INSERT_SQL);			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(1));			declareParameter(new SqlParameter(4));			declareParameter(new SqlParameter(4));		}	}	class SeleccionPorGenitivo extends SeleccionAbstractaSinSig {		public SeleccionPorGenitivo(DataSource datasource) {			super(datasource, SEL_POR_GENITIVO_SQL);			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(12));		}	}	class ObtencionPorId extends SeleccionAbstractaSinSig {		public ObtencionPorId(DataSource datasource) {			super(datasource, GET_POR_ID_SQL);			declareParameter(new SqlParameter(1));		}	}	class SeleccionPorNominativoParaAM extends SeleccionAbstractaSinSig {		public SeleccionPorNominativoParaAM(DataSource datasource) {			super(datasource, SEL_POR_NOMINATIVO_SQL);			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(12));		}	}	class SeleccionIdsPorNom extends SeleccionIds {		public SeleccionIdsPorNom(DataSource datasource, String s) {			super(datasource, s, "SUSTANTIVO_ID");		}	}	class ObtencionConSignificado extends SeleccionAbstracta {		public ObtencionConSignificado(DataSource datasource) {			super(datasource, GET_CON_SIGNIFICADO_SQL);			declareParameter(new SqlParameter(1));		}	}	class SeleccionIdsPorLetra extends SeleccionIds {		public SeleccionIdsPorLetra(DataSource datasource) {			super(datasource, SEL_IDS_POR_LETRA_SQL, "SUSTANTIVO_ID");			declareParameter(new SqlParameter(1));		}	}	class SelPorIds extends SeleccionAbstracta {		public SelPorIds(DataSource datasource, String s) {			super(datasource, s);		}	}	class SeleccionIdsPorTipos extends SeleccionIds {		public SeleccionIdsPorTipos(DataSource datasource, String s) {			super(datasource, s, "SUSTANTIVO_ID");		}	}	abstract class SeleccionAbstractaSinSig extends MappingSqlQuery<SustantivoBean> {		protected SustantivoBean mapRow(ResultSet resultset, int j) throws SQLException {			SustantivoBean bean = new SustantivoBean();			bean.setId(resultset.getString("SUSTANTIVO_ID"));			bean.setLetra(resultset.getString("LETRA"));			bean.setCodigo(resultset.getInt("CODIGO"));			bean.setNominativo(resultset.getString("NOMINATIVO"));			bean.setGenitivo(resultset.getString("GENITIVO"));			bean.setGenero(Genero.getEnum(resultset.getString("GENERO")));			bean.setDibujado(resultset.getInt("DIBUJADO") != 0);			bean.setPartic(Particularidad.getEnum(resultset.getString("PARTIC")));			bean.setTipoNominal(resultset.getInt("TIPO_SUSTANTIVO"));			bean.setIdTipo(resultset.getString("TIPO_SUSTANTIVO_ID"));			bean.setSoloSingular(resultset.getInt("SOLO_SINGULAR") != 0);			bean.setPluralizado(resultset.getInt("PLURALIZADO") != 0);			return bean;		}		public SeleccionAbstractaSinSig(DataSource datasource, String s) {			super(datasource, s);		}	}	private class SeleccionPorNominativo extends SeleccionAbstractaSinSig {		public SeleccionPorNominativo(DataSource datasource) {			super(datasource, SEL_POR_NOMINATIVO_SQL);			declareParameter(new SqlParameter(12));			declareParameter(new SqlParameter(12));		}	}	abstract class SeleccionAbstracta extends MappingSqlQuery<SustantivoBean> {		protected SustantivoBean mapRow(ResultSet resultset, int j) throws SQLException {			SustantivoBean bean = new SustantivoBean();			bean.setId(resultset.getString("SUSTANTIVO_ID"));			bean.setLetra(resultset.getString("LETRA"));			bean.setCodigo(resultset.getInt("CODIGO"));			bean.setNominativo(resultset.getString("NOMINATIVO"));			bean.setGenitivo(resultset.getString("GENITIVO"));			bean.setGenero(Genero.getEnum(resultset.getString("GENERO")));			bean.setDibujado(resultset.getInt("DIBUJADO") != 0);			bean.setPartic(Particularidad.getEnum(resultset.getString("PARTIC")));			bean.setTipoNominal(resultset.getInt("TIPO_SUSTANTIVO"));			bean.setIdTipo(resultset.getString("TIPO_SUSTANTIVO_ID"));			bean.setSoloSingular(resultset.getInt("SOLO_SINGULAR") != 0);			bean.setPluralizado(resultset.getInt("PLURALIZADO") != 0);			Significado q1 = new Significado();			q1.setIdioma(Configuracion.getIdiomaSignificados());			q1.setReferenteId(bean.getId());			q1.setId(resultset.getString("SIGNIFICADO_ID"));			q1.setValor(resultset.getString("VALOR"));			Map<Idioma, Significado> hashmap = new HashMap<>();			hashmap.put(Idioma.getEnum(Configuracion.getIdiomaSignificados()), q1);			bean.setSignificados(hashmap);			return bean;		}		public SeleccionAbstracta(DataSource datasource, String s) {			super(datasource, s);		}	}	private void puebla() {		StringBuffer stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT \n");		stringbuffer.append(" SUS.SUSTANTIVO_ID \n");		stringbuffer.append("FROM \n");		stringbuffer.append(" SUSTANTIVOS SUS \n");		stringbuffer.append("WHERE \n");		stringbuffer.append(" SUS.LETRA=? \n");		stringbuffer.append("ORDER BY \n");		stringbuffer.append(" SUS.CODIGO \n");		SEL_IDS_POR_LETRA_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID   \n");		stringbuffer.append("FROM  \n");		stringbuffer.append("    SUSTANTIVOS SUS  \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("    SUS.NOMINATIVO LIKE ?   \n");		stringbuffer.append("    OR SUS.NOMINATIVO LIKE CONCAT('*', ?)   \n");		stringbuffer.append("ORDER BY  \n");		stringbuffer.append("    SUS.CODIGO   \n");		SEL_IDS_POR_NOMINATIVO_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO   \n");		stringbuffer.append("FROM  \n");		stringbuffer.append("    SUSTANTIVOS SUS  \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("    SUS.NOMINATIVO =?   \n");		stringbuffer.append("    OR SUS.NOMINATIVO = CONCAT('*', ?)   \n");		stringbuffer.append("ORDER BY  \n");		stringbuffer.append("    SUS.CODIGO   \n");		SEL_POR_NOMINATIVO_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO   \n");		stringbuffer.append("FROM  \n");		stringbuffer.append("    SUSTANTIVOS SUS  \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("    SUS.SUSTANTIVO_ID =?   \n");		GET_POR_ID_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO   \n");		stringbuffer.append("FROM  \n");		stringbuffer.append("    SUSTANTIVOS SUS  \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("    SUS.GENITIVO =?   \n");		stringbuffer.append("    OR SUS.GENITIVO = CONCAT('*', ?)   \n");		stringbuffer.append("ORDER BY  \n");		stringbuffer.append("    SUS.CODIGO   \n");		SEL_POR_GENITIVO_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT   \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID   \n");		stringbuffer.append("FROM        \n");		stringbuffer.append("  SUSTANTIVOS SUS       \n");		stringbuffer.append("    INNER JOIN TIPOS_SUSTANTIVO TIS                 \n");		stringbuffer.append("      ON SUS.TIPO_SUSTANTIVO_ID=TIS.TIPO_SUSTANTIVO_ID       \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("  TIS.TIPO_SUSTANTIVO IN (?) \n");		stringbuffer.append("ORDER BY  \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO   \n");		SEL_ID_POR_TIPO_SUSTANTIVO_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT   \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO,   \n");		stringbuffer.append("  SIG.SIGNIFICADO_ID,   \n");		stringbuffer.append("  SIG.VALOR   \n");		stringbuffer.append("FROM        \n");		stringbuffer.append("  SUSTANTIVOS SUS       \n");		stringbuffer.append("    LEFT JOIN SIGNIFICADOS SIG                 \n");		stringbuffer.append("      ON SUS.SUSTANTIVO_ID=SIG.REFERENTE_ID       \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID=?    \n");		stringbuffer.append("  AND (SIG.IDIOMA IS NULL OR SIG.IDIOMA='").append(Configuracion.getIdiomaSignificados()).append("')   \n");		GET_CON_SIGNIFICADO_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT   \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO   \n");		stringbuffer.append("FROM        \n");		stringbuffer.append("  SUSTANTIVOS SUS       \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO=0    \n");		stringbuffer.append("  AND SUS.NOMINATIVO=?    \n");		SEL_POR_NOMINATIVO_TIPO0_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("SELECT   \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO,   \n");		stringbuffer.append("  SUS.GENERO,   \n");		stringbuffer.append("  SUS.NOMINATIVO,   \n");		stringbuffer.append("  SUS.GENITIVO,   \n");		stringbuffer.append("  SUS.DIBUJADO,   \n");		stringbuffer.append("  SUS.PARTIC,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  SUS.TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SUS.SOLO_SINGULAR,   \n");		stringbuffer.append("  SUS.PLURALIZADO,   \n");		stringbuffer.append("  SIG.SIGNIFICADO_ID,   \n");		stringbuffer.append("  SIG.VALOR   \n");		stringbuffer.append("FROM        \n");		stringbuffer.append("  SUSTANTIVOS SUS       \n");		stringbuffer.append("    LEFT JOIN SIGNIFICADOS SIG                 \n");		stringbuffer.append("      ON SUS.SUSTANTIVO_ID=SIG.REFERENTE_ID       \n");		stringbuffer.append("WHERE  \n");		stringbuffer.append("  SUS.SUSTANTIVO_ID IN (?)    \n");		stringbuffer.append("  AND (SIG.IDIOMA IS NULL OR SIG.IDIOMA='").append(Configuracion.getIdiomaSignificados()).append("')   \n");		stringbuffer.append("ORDER BY  \n");		stringbuffer.append("  SUS.LETRA,   \n");		stringbuffer.append("  SUS.CODIGO   \n");		SEL_POR_IDS_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("INSERT INTO SUSTANTIVOS(   \n");		stringbuffer.append("  SUSTANTIVO_ID,   \n");		stringbuffer.append("  LETRA,   \n");		stringbuffer.append("  CODIGO,   \n");		stringbuffer.append("  NOMINATIVO,   \n");		stringbuffer.append("  GENITIVO,   \n");		stringbuffer.append("  GENERO,   \n");		stringbuffer.append("  DIBUJADO,   \n");		stringbuffer.append("  PARTIC,   \n");		stringbuffer.append("  TIPO_SUSTANTIVO,   \n");		stringbuffer.append("  TIPO_SUSTANTIVO_ID,   \n");		stringbuffer.append("  SOLO_SINGULAR,   \n");		stringbuffer.append("  PLURALIZADO   \n");		stringbuffer.append(" ) VALUES (    \n");		stringbuffer.append("  ?,?,?,?,?,?,?,?,?,?,?,?  \n");		stringbuffer.append(")     \n");		INSERT_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("UPDATE SUSTANTIVOS SET   \n");		stringbuffer.append("  LETRA=?,   \n");		stringbuffer.append("  CODIGO=?,   \n");		stringbuffer.append("  NOMINATIVO=?,   \n");		stringbuffer.append("  GENITIVO=?,   \n");		stringbuffer.append("  GENERO=?,   \n");		stringbuffer.append("  DIBUJADO=?,   \n");		stringbuffer.append("  PARTIC=?,   \n");		stringbuffer.append("  TIPO_SUSTANTIVO=?,   \n");		stringbuffer.append("  TIPO_SUSTANTIVO_ID=?,   \n");		stringbuffer.append("  SOLO_SINGULAR=?,   \n");		stringbuffer.append("  PLURALIZADO=?   \n");		stringbuffer.append("WHERE    \n");		stringbuffer.append("  SUSTANTIVO_ID=?   \n");		UPDATE_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("UPDATE SUSTANTIVOS SET   \n");		stringbuffer.append("  CODIGO=CODIGO * 100   \n");		stringbuffer.append("WHERE    \n");		stringbuffer.append("  LETRA=?   \n");		UPDATE_CODIGO_MULT_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("UPDATE SUSTANTIVOS SET   \n");		stringbuffer.append("  CODIGO=?   \n");		stringbuffer.append("WHERE    \n");		stringbuffer.append("  SUSTANTIVO_ID=?   \n");		UPDATE_CODIGO_INDIV_SQL = stringbuffer.toString();		stringbuffer = new StringBuffer(200);		stringbuffer.append("DELETE FROM SUSTANTIVOS WHERE   \n");		stringbuffer.append("  SUSTANTIVO_ID=?  \n");		DELETE_SQL = stringbuffer.toString();	}	public List<SustantivoBean> seleccionaInvariables(String nominativo) {		List<SustantivoBean> list = seleccionPorNominativo.execute(nominativo, nominativo);		return list;	}	public List<String> getPorTipos(Integer ainteger[]) {		StringBuffer stringbuffer = new StringBuffer();		Integer ainteger1[] = ainteger;		int j = ainteger1.length;		for (int k = 0; k < j; k++) {			int l = ainteger1[k].intValue();			stringbuffer.append(l);			stringbuffer.append(",");		}		stringbuffer.deleteCharAt(stringbuffer.length() - 1);		String s = SEL_ID_POR_TIPO_SUSTANTIVO_SQL.replaceFirst("\\?",				stringbuffer.toString());		SeleccionIdsPorTipos selIdsPorTipos = new SeleccionIdsPorTipos(getDataSource(), s);		List<String> list = selIdsPorTipos.execute();		return list;	}	public List<SustantivoBean> getRegistros(List<String> ids) {		List<List<String>> listaDeListas = Listas.segmentos(ids, 500);		List<SustantivoBean> beans = new ArrayList<SustantivoBean>();		for (List<String> listaDeIds : listaDeListas) {			StringBuffer sb = new StringBuffer(500);			for (String id : listaDeIds) {				sb.append("'").append(id).append("',");			}			sb.deleteCharAt(sb.length() - 1);			String sql = SEL_POR_IDS_SQL.replaceFirst("\\?", sb.toString());			SelPorIds sel = new SelPorIds(getDataSource(), sql);			List<SustantivoBean> segmBeans = sel.execute();			beans.addAll(segmBeans);		}		return beans;	}	public List<String> getPorLetra(String letra) {		return seleccionIdsPorLetra.execute( letra );	}	public SustantivoBean getInidvidual(String s) {		SustantivoBean bean = (SustantivoBean) obtencionConSignificado.findObject(s);		return bean;	}	public List<String> seleccionaPorNominativo(String s, LugarSubcadena h1) {		String s1 = null;		switch (h1) {		case Principio: // '\001'			s1 = (new StringBuilder()).append("'").append(s).append("%'").toString();			break;		case Medio: // '\002'			s1 = (new StringBuilder()).append("'%").append(s).append("%'").toString();			break;		case Fin: // '\003'			s1 = (new StringBuilder()).append("'%").append(s).append("'").toString();			break;		case Exacto: // '\004'			s1 = (new StringBuilder()).append("'").append(s).append("'").toString();			break;		}		String s2 = SEL_IDS_POR_NOMINATIVO_SQL.replaceAll("\\?", s1);		SeleccionIdsPorNom selIdsPorNom = new SeleccionIdsPorNom(getDataSource(), s2);		List<String> list = selIdsPorNom.execute();		return list;	}	public List<SustantivoBean> seleccionaPorNominativoParaAM(String nominativo) {		List<SustantivoBean> list = seleccionPorNominativoParaAM.execute(nominativo, nominativo );		return list;	}	public SustantivoBean seleccionaIndividualParaAM(String s) {		SustantivoBean bean = (SustantivoBean) obtencionPorId.findObject(s);		return bean;	}	public List<SustantivoBean> seleccionaPorGenitivoParaAM(String genitivo) {		List<SustantivoBean> list = seleccionPorGenitivo.execute( genitivo, genitivo );		return list;	}	public void inserta(SustantivoBean j) {		String s = DBUtil.getHashableId();		insercion.update(new Object[] { s, j.getLetra(),				Integer.valueOf(j.getCodigo()), j.getNominativo(),				j.getGenitivo(), Genero.getLetra(j.getGenero()),				Integer.valueOf(j.isDibujado() ? 1 : 0),				Particularidad.getString(j.getPartic()),				Integer.valueOf(j.getTipoNominal()), j.getIdTipo(),				Integer.valueOf(j.isSoloSingular() ? 1 : 0),				Integer.valueOf(j.isPluralizado() ? 1 : 0) });		j.setId(s);	}	public void modifica(SustantivoBean j) {		modificacion.update(new Object[] { j.getLetra(),				Integer.valueOf(j.getCodigo()), j.getNominativo(),				j.getGenitivo(), Genero.getLetra(j.getGenero()),				Integer.valueOf(j.isDibujado() ? 1 : 0),				Particularidad.getString(j.getPartic()),				Integer.valueOf(j.getTipoNominal()), j.getIdTipo(),				Integer.valueOf(j.isSoloSingular() ? 1 : 0),				Integer.valueOf(j.isPluralizado() ? 1 : 0), j.getId() });	}	public void modificaCodigosTodos(String s) {		modificaCodigoMult.update(new Object[] { s });	}	public void modificaCodigoIndividual(int j, String s) {		modifCodigoIndividual.update(new Object[] { Integer.valueOf(j), s });	}	public void borra(String s) {		borrado.update(new Object[] { s });	}	public void initDao() throws Exception {		super.initDao();		puebla();		seleccionIdsPorLetra = new SeleccionIdsPorLetra(getDataSource());		obtencionConSignificado = new ObtencionConSignificado(getDataSource());		obtencionPorId = new ObtencionPorId(getDataSource());		seleccionPorNominativoParaAM = new SeleccionPorNominativoParaAM(getDataSource());		seleccionPorGenitivo = new SeleccionPorGenitivo(getDataSource());		seleccionPorNominativo = new SeleccionPorNominativo(getDataSource());		insercion = new Insercion(getDataSource());		borrado = new Borrado(getDataSource());		modificacion = new Modificacion(getDataSource());		modificaCodigoMult = new ModificacionCodigoMult(getDataSource());		modifCodigoIndividual = new ModifCodigoIndividual(getDataSource());	}	static String C() {		return SEL_POR_NOMINATIVO_TIPO0_SQL;	}	static String K() {		return SEL_IDS_POR_LETRA_SQL;	}	static String G() {		return GET_CON_SIGNIFICADO_SQL;	}	static String A() {		return SEL_POR_NOMINATIVO_SQL;	}	static String I() {		return GET_POR_ID_SQL;	}	static String F() {		return SEL_POR_GENITIVO_SQL;	}	static String L() {		return INSERT_SQL;	}	static String H() {		return UPDATE_SQL;	}	static String B() {		return UPDATE_CODIGO_MULT_SQL;	}	static String J() {		return UPDATE_CODIGO_INDIV_SQL;	}	static String E() {		return DELETE_SQL;	}	private static String SEL_IDS_POR_LETRA_SQL;	private static String SEL_ID_POR_TIPO_SUSTANTIVO_SQL;	private static String GET_CON_SIGNIFICADO_SQL;	private static String SEL_POR_NOMINATIVO_SQL;	private static String SEL_IDS_POR_NOMINATIVO_SQL;	private static String GET_POR_ID_SQL;	private static String SEL_POR_GENITIVO_SQL;	private static String SEL_POR_NOMINATIVO_TIPO0_SQL;	private static String SEL_POR_IDS_SQL;	private static String INSERT_SQL;	private static String UPDATE_SQL;	private static String UPDATE_CODIGO_MULT_SQL;	private static String UPDATE_CODIGO_INDIV_SQL;	private static String DELETE_SQL;	private SeleccionPorNominativo seleccionPorNominativo;	private SeleccionIdsPorLetra seleccionIdsPorLetra;	private ObtencionConSignificado obtencionConSignificado;	private SeleccionPorNominativoParaAM seleccionPorNominativoParaAM;	private ObtencionPorId obtencionPorId;	private SeleccionPorGenitivo seleccionPorGenitivo;	private Insercion insercion;	private Modificacion modificacion;	private ModificacionCodigoMult modificaCodigoMult;	private ModifCodigoIndividual modifCodigoIndividual;	private Borrado borrado;}
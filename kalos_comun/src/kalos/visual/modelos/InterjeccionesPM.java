// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package kalos.visual.modelos;import kalos.beans.InterjeccionBean;import kalos.beans.Significado;// Referenced classes of package kalos.A.C://            Bimport kalos.bibliotecadatos.FuenteDatosCacheable;import kalos.operaciones.OpSignificados;public class InterjeccionesPM extends PagingModel<InterjeccionBean> {    public InterjeccionesPM(FuenteDatosCacheable b, int i) {	super(b, i);    }    public Object getValueAt(int i, int j) {	InterjeccionBean y = (InterjeccionBean) getFila(i);	switch (j) {	case 0: // '\0'	    return y.getLetra();	case 1: // '\001'	    return Integer.valueOf(y.getCodigo());	case 2: // '\002'	    return y.getInterjeccion();	case 3: // '\003'	    Significado q = OpSignificados.getSignificadoIndividual(y);	    return q.getValor();	}	return null;    }    public int getColumnCount() {	return 4;    }}
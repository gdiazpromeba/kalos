// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package kalos.beans;import java.util.HashMap;import java.util.Map;import kalos.enumeraciones.GradoComparacion;// Referenced classes of package kalos.K://            Rimport kalos.enumeraciones.Particularidad;public class AdjetivoBean    implements ISignificados{    public AdjetivoBean()    {        I = new HashMap();    }    public int getCodigo()    {        return U;    }    public void setCodigo(int i)    {        U = i;    }    public String getFemenino()    {        return M;    }    public void setFemenino(String s)    {        M = s;    }    public String getId()    {        return K;    }    public void setId(String s)    {        K = s;    }    public String getLetra()    {        return Q;    }    public void setLetra(String s)    {        Q = s;    }    public String getMasculino()    {        return T;    }    public void setMasculino(String s)    {        T = s;    }    public String getNeutro()    {        return L;    }    public void setNeutro(String s)    {        L = s;    }    public int getTipoAdjetivo()    {        return J;    }    public void setTipoAdjetivo(int i)    {        J = i;    }    public Particularidad getParticularidad()    {        return V;    }    public void setParticularidad(Particularidad x)    {        V = x;    }    public Map getSignificados()    {        return I;    }    public void setSignificados(Map map)    {        I = map;    }    public String getIdTipo()    {        return R;    }    public void setIdTipo(String s)    {        R = s;    }    public boolean isVerbal()    {        return O;    }    public void setVerbal(boolean flag)    {        O = flag;    }    public String getMascFem()    {        return N;    }    public void setMascFem(String s)    {        N = s;    }    public String getGenitivo()    {        return P;    }    public void setGenitivo(String s)    {        P = s;    }    public GradoComparacion getGrado()    {        return S;    }    public void setGrado(GradoComparacion i)    {        S = i;    }    private String K;    private String Q;    private int U;    private String T;    private String M;    private String L;    private String N;    private String P;    private int J;    private Particularidad V;    private String R;    private Map I;    private boolean O;    private GradoComparacion S;}
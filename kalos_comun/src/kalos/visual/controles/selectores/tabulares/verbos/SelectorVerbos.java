// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package kalos.visual.controles.selectores.tabulares.verbos;

import kalos.A.B.A;
import kalos.A.B.F.A.C;
import kalos.E.E.P;
import kalos.datos.gerentes.GerenteVerbos;
import kalos.visual.controles.FabricaControles;
import kalos.visual.controles.selectores.DialogSelectorBeans;
import kalos.visual.controles.selectores.tabulares.sustantivos.DialogSelectorSustantivos;

// Referenced classes of package kalos.A.B.F.A.A:
//            A

public class SelectorVerbos extends SelectorActivoBeansTabular
{

    public SelectorVerbos(GerenteVerbos p, FabricaControles a, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(p, flag, flag1, flag2, true, "verbo");
        P = p;
        O = a;
    }

    protected DialogSelectorVerbos D()
    {
        return new DialogSelectorVerbos(O, P);
    }

    protected volatile DialogSelectorBeans A()
    {
        return D();
    }

    private GerenteVerbos P;
    private FabricaControles O;
}

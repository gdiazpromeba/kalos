// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package kalos.visual.controles.selectores.tabulares;

import javax.swing.JTextField;
import kalos.A.B.F.A;
import kalos.E.E.c;

// Referenced classes of package kalos.A.B.F.A:
//            B

public abstract class SelectorActivoBeansTabular extends SelectorTabular
{

    public SelectorActivoBeansTabular(c c, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s)
    {
        super(c, flag, flag1, flag2, flag3, s);
    }

    public void muestraDialog()
    {
        J = A();
        J.setSize(540, 380);
        J.setLocationRelativeTo(null);
        J.setModal(true);
        J.setVisible(true);
        if(J.isAcepto())
        {
            Object obj = J.getBeanSeleccionado();
            L = obj;
            super.B.setText(kalos.G.A.getPropiedad(obj, H));
        }
        J.dispose();
    }
}

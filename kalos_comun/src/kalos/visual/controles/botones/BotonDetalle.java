// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package kalos.A.B.B;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import kalos.C.B;
import kalos.C.F;

public class C extends JButton
{

    public C()
    {
        super(F.C.getImagen("detalle16.gif"));
        setPreferredSize(new Dimension(22, 22));
        setMaximumSize(new Dimension(22, 22));
        A();
    }

    private void A()
    {
        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent componentevent)
            {
                A.setSize(new Dimension(22, 22));
            }

            final C A;

            
            {
                A = C.this;
                super();
            }
        }
);
    }
}

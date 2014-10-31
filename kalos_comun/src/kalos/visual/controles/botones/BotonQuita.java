// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package kalos.A.B.A.C;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import kalos.C.B;
import kalos.C.F;
import kalos.recursos.Recursos;

public class BotonQuita extends JPanel
{

    public BotonQuita(int i, boolean flag)
    {
        this(i);
        B = flag;
        botonAlternable.setEnabled(flag);
        botonAlternable.setSelected(true);
        campoTexto.setEditable(false);
        if(!flag)
            botonAlternable.setVisible(false);
    }

    public BotonQuita(int i)
    {
        B = false;
        botonAlternable = new JToggleButton(Recursos.cargador.getImagen("quita16.gif"));
        campoTexto = new JTextField(i);
        botonAlternable.setPreferredSize(new Dimension(22, 22));
        botonAlternable.setMaximumSize(new Dimension(22, 22));
        setLayout(new BorderLayout());
        add(campoTexto, "Center");
        add(botonAlternable, "East");
        botonAlternable.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseevent)
            {
                JToggleButton jtogglebutton = (JToggleButton)mouseevent.getSource();
                A.A(A).setEditable(!jtogglebutton.isSelected());
                if(jtogglebutton.isSelected())
                {
                    A.A(A).setText(F.getCadena("nulo"));
                    A.A(A).setEditable(false);
                } else
                {
                    A.A(A).setText("");
                    A.A(A).setEditable(true);
                }
            }

            final A A;

            
            {
                A = A.this;
                super();
            }
        }
);
    }

    public void setEnabled(boolean flag)
    {
        botonAlternable.setEnabled(B && flag);
    }

    public String getText()
    {
        if(campoTexto.getText().equals(Recursos.getCadena("nulo")))
            return null;
        else
            return campoTexto.getText().toUpperCase();
    }

    public void setText(String s)
    {
        if(s == null)
        {
            campoTexto.setText(Recursos.getCadena("nulo"));
            campoTexto.setEditable(false);
            botonAlternable.setSelected(true);
        } else
        {
            campoTexto.setText(s);
            botonAlternable.setSelected(false);
            campoTexto.setEditable(B);
        }
    }

    public void requestFocus()
    {
        campoTexto.requestFocus();
    }

    public JTextField elTexto()
    {
        return campoTexto;
    }

    static JTextField A(A a)
    {
        return a.C;
    }

    private JTextField campoTexto;
    private boolean B;
    private JToggleButton botonAlternable;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package kalos.iu;import com.jgoodies.forms.builder.PanelBuilder;import com.jgoodies.forms.layout.CellConstraints;import com.jgoodies.forms.layout.FormLayout;import java.awt.BorderLayout;import javax.swing.*;public class PanelProgreso extends JPanel{    public PanelProgreso()    {        barra = new JProgressBar();        etiqueta = new JLabel();        etiqueta.setHorizontalAlignment(4);        setLayout(new BorderLayout());        FormLayout formlayout = new FormLayout("fill:pref:grow(0.9), 3dlu, 40dlu, 9dlu", "15dlu");        PanelBuilder panelbuilder = new PanelBuilder(formlayout);        CellConstraints cellconstraints = new CellConstraints();        panelbuilder.add(etiqueta, cellconstraints.xy(1, 1));        panelbuilder.add(barra, cellconstraints.xy(3, 1));        add(panelbuilder.getPanel());        etiqueta.setVisible(false);        barra.setVisible(false);    }    public JProgressBar barra;    public JLabel etiqueta;}
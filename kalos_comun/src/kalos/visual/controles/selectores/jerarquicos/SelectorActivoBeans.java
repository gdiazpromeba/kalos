// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package kalos.visual.controles.selectores.jerarquicos;import java.awt.BorderLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JPanel;import javax.swing.JTextField;import javax.swing.UIManager;import kalos.bibliotecadatos.ListaSeleccionable;import kalos.datos.gerentes.Reseleccionable;import kalos.datos.gerentes.SelectorTodos;import kalos.operaciones.OpBeans;import kalos.recursos.Configuracion;import kalos.visual.controles.botones.BotonCopia;import kalos.visual.controles.botones.BotonDetalle;import kalos.visual.controles.botones.BotonQuita;import kalos.visual.controles.selectores.DialogSelectorBeans;import org.springframework.beans.BeansException;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;import com.jgoodies.forms.builder.PanelBuilder;import com.jgoodies.forms.layout.CellConstraints;import com.jgoodies.forms.layout.FormLayout;public abstract class SelectorActivoBeans extends JPanel implements ApplicationContextAware {    public SelectorActivoBeans(Reseleccionable ba, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s) {	botonDetalle = new BotonDetalle();	botonQuita = new BotonQuita();	botonCopia = new BotonCopia();	L = ba;	C = flag;	G = flag1;	D = flag2;	J = flag3;	H = s;	FormLayout formlayout = new FormLayout("30dlu:grow(0.9), 3dlu, pref,pref,pref ", "fill:15dlu");	textoDescripcion = new JTextField();	if (flag3)	    textoDescripcion.setFont(Configuracion.getFont());	setLayout(new BorderLayout());	PanelBuilder panelbuilder = new PanelBuilder(formlayout);	CellConstraints cellconstraints = new CellConstraints();	if (!flag1 && !flag && !flag2) {	    panelbuilder.add(textoDescripcion, cellconstraints.xyw(1, 1, 5));	} else {	    panelbuilder.add(textoDescripcion, cellconstraints.xy(1, 1));	    panelbuilder.add(botonDetalle, cellconstraints.xy(3, 1));	    panelbuilder.add(botonQuita, cellconstraints.xy(4, 1));	    panelbuilder.add(botonCopia, cellconstraints.xy(5, 1));	}	add(panelbuilder.getPanel());	setEnabled(flag);	textoDescripcion.setEnabled(false);	textoDescripcion.setBackground(UIManager.getColor("Label.background"));	if (!flag1)	    botonQuita.setVisible(false);	botonDetalle.addActionListener(new ActionListener() {	    public void actionPerformed(ActionEvent actionevent) {		muestraDialog();	    }	});	botonQuita.addActionListener(new ActionListener() {	    public void actionPerformed(ActionEvent actionevent) {		quitaSeleccion();	    }	});    }    public Object getBeanSeleccionado() {	return listaSeleccionable.getSeleccionado();    }    public String getIdSeleccionado() {	Object obj = listaSeleccionable.getSeleccionado();	if (obj != null)	    return OpBeans.getId(obj);	else	    return null;    }    public void setEnabled(boolean flag) {	botonDetalle.setVisible(flag);	botonQuita.setVisible(flag & G);	botonCopia.setVisible(D & flag);    }    //protected abstract DialogSelectorBeans A();    public abstract void muestraDialog();    public ApplicationContext getApplicationContext() {	return null;    }    protected void fuerzaSeleccion(String s) {	listaSeleccionable.setPK(s);	if (s == null) {	    textoDescripcion.setText("");	    return;	}	Object obj = getBeanSeleccionado();	if (obj != null) {	    textoDescripcion.setText(cadenaPathSeleccionado());	} else {	    if (!(L instanceof SelectorTodos)) {		StringBuffer stringbuffer = new StringBuffer(			" El gerente reseleccionable es nulo o no implementa Selector todos, imposible reintentar");		stringbuffer.append("Error al querer forzar la selección con la siguiente PK: \n");		stringbuffer.append(s);		throw new RuntimeException(stringbuffer.toString());	    }	    java.util.List list = ((SelectorTodos) L).getTodos();	    listaSeleccionable = new ListaSeleccionable(list);	    Object obj1 = getBeanSeleccionado();	    if (obj1 != null) {		textoDescripcion.setText(cadenaPathSeleccionado());	    } else {		StringBuffer stringbuffer1 = new StringBuffer(			"Error al querer forzar la selecci\363n con la siguiente PK: \n");		stringbuffer1.append(s);		throw new RuntimeException(stringbuffer1.toString());	    }	}    }    protected abstract String cadenaPathSeleccionado();    public final void quitaSeleccion() {	listaSeleccionable = null;	textoDescripcion.setText("");    }    public JTextField getTextoDescripcion() {	return textoDescripcion;    }    public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {	applicationContext = applicationcontext;    }    protected BotonDetalle botonDetalle;    protected BotonQuita botonQuita;    public BotonCopia botonCopia;    protected DialogSelectorBeans dialogSelectorBeans;    protected boolean C;    protected boolean G;    protected boolean D;    protected JTextField textoDescripcion;    protected boolean J;    protected String H;    protected ListaSeleccionable listaSeleccionable;    ApplicationContext applicationContext;    Reseleccionable L;}
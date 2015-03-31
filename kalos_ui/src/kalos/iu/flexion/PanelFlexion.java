// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package kalos.iu.flexion;import java.awt.BorderLayout;import java.awt.event.ComponentAdapter;import java.awt.event.ComponentEvent;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.util.HashMap;import java.util.Map;import javax.swing.JFrame;import javax.swing.JPanel;import javax.swing.JTabbedPane;import javax.swing.JTable;import javax.swing.SwingUtilities;import javax.swing.table.DefaultTableModel;import kalos.beans.EntradaDiccionario;import kalos.enumeraciones.Reportes;import kalos.flexion.CreadorTableModelsGrilla;import kalos.flexion.CreadorTableModelsReporte;import kalos.iu.PanelProgreso;import kalos.iu.jasper.UtilidadJasper;import kalos.iu.tareas.TareaCuadro;import kalos.iu.tareas.TareaLeyenda;import kalos.iu.tareas.TareaOcultaProgreso;import kalos.recursos.Configuracion;import kalos.recursos.Recursos;import kalos.visual.controles.deslizador.Deslizador;import kalos.visual.controles.util.UtilTipografias;import kalos.visual.controles.ventanas.DialogErrores;import org.apache.log4j.Logger;import org.springframework.beans.BeansException;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;// Referenced classes of package kalos.iu.F://            C, Bimport foxtrot.Worker;public class PanelFlexion extends JPanel implements ApplicationContextAware {	public PanelFlexion() {		tab = new JTabbedPane();		panelJasper = new JPanel();		panelJasper.setLayout(new BorderLayout());		panelTabla = new JPanel();		deslizador = new Deslizador();		panelFlexionNorte = new PanelFlexionNorte();		cacheTablas = new HashMap<Reportes, DefaultTableModel>();		cacheJasper = new HashMap<Reportes, DefaultTableModel>();		logger = Logger.getLogger(getClass().getName());		ejecutandose = false;		setLayout(new BorderLayout());		add(panelFlexionNorte, BorderLayout.NORTH);		add(tab, BorderLayout.CENTER);		panelTabla.setLayout(new BorderLayout());		tab.addTab(Recursos.getCadena("cuadro"), panelTabla);		tab.addTab(Recursos.getCadena("vista_preliminar_impresion"), panelJasper);		tabla = new JTable();		tabla.setFont(Configuracion.getFont());		panelFlexionNorte.deslizador.addPropertyChangeListener(new PropertyChangeListener() {			public void propertyChange(PropertyChangeEvent propertychangeevent) {				Deslizador a = (Deslizador) propertychangeevent.getSource();				cambiaTamañoFont(a.getValor());			}		});		addComponentListener(new ComponentAdapter() {			public void componentShown(ComponentEvent componentevent) {				proceder();			}		});	}	public void setFormaCanonica(String s) {		panelFlexionNorte.setFormaCanonica(s);	}	private void proceder() {		if (!ejecutandose) {			tabla.setSelectionMode(0);			repaint();			new Thread() {				public void run() {					panProgreso = (PanelProgreso) applicationContext.getBean("panelProgreso");					creadorTMGrilla = (CreadorTableModelsGrilla) applicationContext.getBean("creadorTableModelsGrilla");					creadorTMReporte = (CreadorTableModelsReporte) applicationContext.getBean("creadorTableModelsReporte");					paramReporte = (ParametrosReporte) applicationContext.getBean("parametrosReporte");					utilJasper = (UtilidadJasper) applicationContext.getBean("utilidadJasper");					panelFlexionNorte.habilitarBotones();				}			}.start();			ejecutandose = true;		}	}	public void activar(EntradaDiccionario n) {		panelFlexionNorte.pueblaSegunEntrada(n);	}	public void creaTableModel(String s, Reportes m) {		try {			logger.info((new StringBuilder()).append("creando tableModel de flexión para id=").append(s)					.append(" tipo de reporte=").append(m).toString());			TareaCuadro e = new TareaCuadro(s, tabla, m, paramReporte, creadorTMGrilla, creadorTMReporte, cacheTablas, cacheJasper, panelTabla, panelJasper, utilJasper);			Worker.post(new TareaLeyenda(panProgreso, "creando_cuadros"));			Worker.post(e);			Worker.post(new TareaOcultaProgreso(panProgreso));			panelFlexionNorte.getCrear().setEnabled(true);			panelFlexionNorte.getCrearMas().setEnabled(true);			panelFlexionNorte.getTiposReporte().setEnabled(true);			panelFlexionNorte.getMasTipos().setEnabled(true);		} catch (Exception exception) {			logger.error("error en la generación de cuadros", exception);			panProgreso.barra.setIndeterminate(false);			panProgreso.etiqueta.setVisible(false);			panProgreso.barra.setVisible(false);			panelFlexionNorte.getCrear().setEnabled(true);			panelFlexionNorte.getCrearMas().setEnabled(true);			panelFlexionNorte.getTiposReporte().setEnabled(true);			panelFlexionNorte.getMasTipos().setEnabled(true);			JFrame jframe = (JFrame) SwingUtilities.getRoot(this);			DialogErrores d = new DialogErrores(jframe, Recursos.getCadena("error"), Recursos.getCadena("error_en_am"),					true, exception);			d.setLocationRelativeTo(null);			d.setVisible(true);		}	}	public void setCreadorTableModelsGrilla(CreadorTableModelsGrilla j) {		creadorTMGrilla = j;	}	public PanelFlexionNorte getPanelEleccionTipoReporte() {		return panelFlexionNorte;	}	public void setCreadorTableModelsReporte(CreadorTableModelsReporte f) {		creadorTMReporte = f;	}	public void setParametrosReporte(ParametrosReporte b) {		paramReporte = b;	}	public void setUtilidadJasper(UtilidadJasper b) {		utilJasper = b;	}	public void cambiaTamañoFont(float f) {		UtilTipografias.cambiaTamañoEnTabla(tabla, f);		repaint();		revalidate();	}	public void setPanelProgreso(PanelProgreso b) {		panProgreso = b;	}	public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {		applicationContext = applicationcontext;	}	private CreadorTableModelsGrilla creadorTMGrilla;	private CreadorTableModelsReporte creadorTMReporte;	private ParametrosReporte paramReporte;	private JTabbedPane tab;	private PanelFlexionNorte panelFlexionNorte;	private JPanel panelTabla;	private JPanel panelJasper;	private UtilidadJasper utilJasper;	private JTable tabla;	private PanelProgreso panProgreso;	private Deslizador deslizador;	private ApplicationContext applicationContext;	private Map<Reportes, DefaultTableModel> cacheTablas;	private Map<Reportes, DefaultTableModel> cacheJasper;	Logger logger;	private boolean ejecutandose;}
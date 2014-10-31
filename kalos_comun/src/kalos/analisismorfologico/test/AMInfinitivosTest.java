package kalos.analisismorfologico.test;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import kalos.analisismorfologico.negocio.AMInfinitivos;
import kalos.beans.ResultadoUniversal;
import kalos.beans.TestInfinitivoBean;
import kalos.datos.gerentes.GerenteTestInfinitivos;
import kalos.enumeraciones.Aspecto;
import kalos.enumeraciones.CompLetras;
import kalos.enumeraciones.FuerteDebil;
import kalos.enumeraciones.Voz;
import kalos.operaciones.AACacheable;
import kalos.operaciones.OpBeans;
import kalos.operaciones.OpPalabras;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class AMInfinitivosTest extends TestCase implements CompLetras {
    private AMInfinitivos amInfinitivos;
    private GerenteTestInfinitivos gerenteTestInfinitivos;
    private static long o = 0L;

    public AMInfinitivosTest(String paramString) {
	super(paramString);
    }

    public static void main(String[] paramArrayOfString) {
	new AMInfinitivosTest("testRegulares");
    }

    public void testTabla() {
	try {
	    List<TestInfinitivoBean> beans = this.gerenteTestInfinitivos.seleccionaTodos();
	    String str = "";
	    AACacheable localB = null;
	    Iterator<TestInfinitivoBean> itBeans = beans.iterator();
	    while (itBeans.hasNext()) {
		TestInfinitivoBean localB1 = itBeans.next();
		if (!str.equals(localB1.getIdVerbo())) {
		    localB = new AACacheable();
		}
		boolean bool = testGenerico(localB1.getFormaConjugada(), localB1.getIdVerbo(), localB1.getVoz(),
			localB1.getAspecto(), localB1.getFuerte(), localB, false);
		if (!bool) {
		    System.out.println("falló para la forma " + localB1.getFormaConjugada());
		}
		assertTrue(bool);
	    }
	} catch (Exception localException) {
	    localException.printStackTrace();
	}
    }

    public boolean testGenerico(String paramString1, String paramString2, Voz paramZ, Aspecto paramk,
	    FuerteDebil paramP, AACacheable cacheAA, boolean paramBoolean) {
	System.out.print("conjugando ... " + paramString1);
	String[] arrayOfString = { OpPalabras.strBetaACompleto(paramString1) };
	Set<ResultadoUniversal> localHashSet = new HashSet<ResultadoUniversal>();
	long l = this.amInfinitivos.buscaCanonica(arrayOfString, localHashSet, cacheAA, false, paramBoolean);
	o += l;
	System.out.print("  tardanza=" + l + " tiempo acumulado=" + o + "\n");
	boolean bool = false;
	Iterator<ResultadoUniversal> localIterator = localHashSet.iterator();
	while (localIterator.hasNext()) {
	    ResultadoUniversal localj = localIterator.next();
	    try {
		if ((localj.getIdSimpleOCompuesto().equals(paramString2)) && (localj.getVoz().equals(paramZ))
			&& (localj.getAspecto().equals(paramk)) && (localj.getFuerte().equals(paramP))) {
		    bool = true;
		    break;
		}
	    } catch (Exception localException) {
		System.out.println("el registro siguiente:");
		OpBeans.debugBean(localj, new String[0]);
		System.out.println("no coincide con los siguientes valores esperados:");
		System.out.println("  idVerbo=" + paramString2);
		System.out.println("  voz=" + paramZ);
		System.out.println("  aspecto=" + paramk);
		System.out.println("  fuerte=" + paramP);
		bool = false;
		break;
	    }
	}
	return bool;
    }

    public static ApplicationContext creaContexto() {
	DefaultListableBeanFactory localDefaultListableBeanFactory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader localXmlBeanDefinitionReader = new XmlBeanDefinitionReader(
		localDefaultListableBeanFactory);
	FileSystemResource localFileSystemResource = new FileSystemResource(System.getProperty("user.dir")
		+ File.separator + "daos.xml");
	localXmlBeanDefinitionReader.loadBeanDefinitions(localFileSystemResource);
	localFileSystemResource = new FileSystemResource(System.getProperty("user.dir") + File.separator
		+ "gerentes-datos.xml");
	localXmlBeanDefinitionReader.loadBeanDefinitions(localFileSystemResource);
	localFileSystemResource = new FileSystemResource(System.getProperty("user.dir") + File.separator
		+ "flexion.xml");
	localXmlBeanDefinitionReader.loadBeanDefinitions(localFileSystemResource);
	localFileSystemResource = new FileSystemResource(System.getProperty("user.dir") + File.separator
		+ "analisisMorfologico.xml");
	localXmlBeanDefinitionReader.loadBeanDefinitions(localFileSystemResource);
	GenericApplicationContext localGenericApplicationContext = new GenericApplicationContext(
		localDefaultListableBeanFactory);
	return localGenericApplicationContext;
    }

    protected void setUp() throws Exception {
	ApplicationContext localApplicationContext = creaContexto();
	this.amInfinitivos = (AMInfinitivos) localApplicationContext.getBean("amInfinitivos");
	this.gerenteTestInfinitivos = (GerenteTestInfinitivos) localApplicationContext
		.getBean("gerenteTestInfinitivos");
    }
}

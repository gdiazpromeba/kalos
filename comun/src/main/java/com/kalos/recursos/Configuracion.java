// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.// Jad home page: http://www.kpdus.com/jad.html// Decompiler options: packimports(3) package com.kalos.recursos;import java.awt.Font;import java.io.File;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.io.InputStream;import java.io.OutputStreamWriter;import java.util.Properties;import org.apache.log4j.Logger;import com.kalos.utils.SortedProperties;public class Configuracion {    public static String getProperty(String property) {        return prop.getProperty(property);    }    public static boolean isDebug() {        return Boolean.valueOf(prop.getProperty("debug"));    }    public static int getMaximoFormasAM() {        return Integer.parseInt(prop.getProperty("max_forms_MA"));    }    public static String getUltimoIdioma() {        return prop.getProperty("last_language");    }    public static String getIdiomaSignificados() {        return prop.getProperty("language_meanings");    }    public static int getTamañoDiccionario() {        return Integer.parseInt(prop.getProperty("font_size_dictionary"));    }    public static int getTamañoAM() {        return Integer.parseInt(prop.getProperty("font_size_MA"));    }    public static int getTamañoFlexion() {        return Integer.parseInt(prop.getProperty("font_size_inflection"));    }    public static void setTamañoDiccionario(int i) {        prop.setProperty("font_size_dictionary", Integer.toString(i));        reescribeIni();    }    public static void setTamañoAM(int i) {        prop.setProperty("font_size_MA", Integer.toString(i));        reescribeIni();    }    public static void setTamañooFlexion(int i) {        prop.setProperty("font_size_inflection", Integer.toString(i));        reescribeIni();    }    public static void setUltimoIdioma(String s) {        prop.setProperty("last_language", s);    }    public static void setIdiomaSignificados(String s) {        prop.setProperty("language_meanings", s);    }    public static void setUltimoTeclado(String s) {        prop.setProperty("last_keyboard", s);    }    public static String getUltimoTeclado() {        return prop.getProperty("last_keyboard");    }    public static void reescribeIni() {        if (readOnly) return;        try {            String dir = new File(Configuracion.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().toString();            File file = new File(dir + "/kalos.properties");            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));            prop.store(osw, null);        } catch (IOException ioexception) {            System.out.println("error re-writing kalos.properties");            ioexception.printStackTrace();        }    }    public static boolean getMuestraMakrones() {        return Boolean.parseBoolean(prop.getProperty("show_makrons"));    }    public static void setMuestraMakrones(boolean flag) {        prop.setProperty("show_makrons", Boolean.toString(flag));    }    public static String getVersionNumero() {        return prop.getProperty("version");    }    public static void setVersionNumero(String s) {        prop.setProperty("version", s);    }    public static String getComandoAbre() {        return comandoAbre;    }    public static String getParmetrosAbre() {        return parametrosAbre;    }    public static String getComandoCierra() {        return comandoCierra;    }    public static String getParmetrosCierra() {        return parametrosCierra;    }    public static long getVecesVentana() {        return vecesVentana;    }    public static void aumentaVecesVentana() {        vecesVentana++;    }    public static Font getFont() {        return font;    }    public static void setFont(Font font) {        prop.setProperty("font_name", font.getFontName());        prop.setProperty("font_size", Integer.toString(font.getSize()));        Configuracion.font = font;        reescribeIni();    }    public static String getNombre() {        return prop.getProperty("registered_to");    }    public static void setNombre(String s) {        if (s == null)            prop.setProperty("registered_to", "");        else            prop.setProperty("registered_to", s);        reescribeIni();    }    private static Logger logger;    private static Font font;    private static String comandoAbre;    private static String comandoCierra;    private static String parametrosAbre;    private static String parametrosCierra;    private static long vecesVentana = 0L;    private static SortedProperties prop = new SortedProperties();    private static boolean readOnly;    static    {        logger = Logger.getLogger(com.kalos.recursos.Configuracion.class.getName());        try {            //archivo en el directorio de proyecto            String dirLocal = new File("kalos.properties").getAbsolutePath();            logger.info("looking for configuration file in =" + dirLocal);            String dir = new File(Configuracion.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().toString();            logger.info("execution path for configuration=" + dir);            File file = new File(dir + "/kalos.properties");            if (file.exists()) {                logger.info("kalos.properties found in the execution dir");                prop.load(new FileInputStream(file));                readOnly = false;            } else {                logger.info("kalos.properties not found in execution dir, falling back to classpath");                InputStream ins = Configuracion.class.getClassLoader().getResource("kalos.properties").openStream();                prop.load(ins);                readOnly = true;            }        } catch (Exception exception) {            System.out.println("Error reading congiguration file kalos.properties");            exception.printStackTrace();            System.exit(0);        }        String fontName = prop.getProperty("font_name");        int fontSize = Integer.valueOf(prop.getProperty("font_size"));        font = new Font(fontName, 0, fontSize);        if (!font.canDisplay('\u1F87')) {            logger.warn("ninguna font hallada para el nombre=" + fontName + " tamaño " + fontSize);            font = null;        }    }}
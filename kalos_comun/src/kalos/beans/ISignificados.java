package kalos.beans;

import java.util.Map;

import kalos.enumeraciones.Idioma;

public interface ISignificados
{
	
	public void setSignificados(Map<Idioma, Significado> significados);

    public abstract Map getSignificados();


    public abstract String getId();
}
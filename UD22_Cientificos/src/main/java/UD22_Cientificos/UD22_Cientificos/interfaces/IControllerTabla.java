package UD22_Cientificos.UD22_Cientificos.interfaces;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;

public interface IControllerTabla {
	public void startCientificos(ConexionSQL connexion);
	public void startProyectos(ConexionSQL connexion);
	public void startAsignadoA(ConexionSQL connexion);
	public void start(ConexionSQL connexion);
}

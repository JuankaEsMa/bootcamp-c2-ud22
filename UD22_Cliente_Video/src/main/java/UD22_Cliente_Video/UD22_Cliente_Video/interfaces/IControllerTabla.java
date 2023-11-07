package UD22_Cliente_Video.UD22_Cliente_Video.interfaces;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;

public interface IControllerTabla {
	public void startCliente(ConexionSQL connexion);
	public void startVideos(ConexionSQL connexion);
	public void start(ConexionSQL connexion);
}

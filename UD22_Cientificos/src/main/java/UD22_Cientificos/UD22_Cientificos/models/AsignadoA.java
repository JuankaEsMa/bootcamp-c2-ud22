package UD22_Cientificos.UD22_Cientificos.models;

public class AsignadoA {
	String idCientifico;
	String idProyecto;
	
	public AsignadoA(String idCientifico, String idProyecto) {
		super();
		this.idCientifico = idCientifico;
		this.idProyecto = idProyecto;
	}
	
	public String getIdCientifico() {
		return idCientifico;
	}
	public void setIdCientifico(String idCientifico) {
		this.idCientifico = idCientifico;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	
}

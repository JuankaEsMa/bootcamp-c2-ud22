package UD22_Cientificos.UD22_Cientificos.models;

public class Cientifico {
	private String dni;
	private String nomApels;
	public Cientifico(String dni, String nomApels) {
		super();
		this.dni = dni;
		this.nomApels = nomApels;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNomApels() {
		return nomApels;
	}
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
	
}

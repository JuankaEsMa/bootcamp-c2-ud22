package UD22_Cientificos.UD22_Cientificos.models;

public class Proyecto {
	private String id;
	private String nombre;
	private String horas;
	public Proyecto(String id, String nombre, String horas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	
}

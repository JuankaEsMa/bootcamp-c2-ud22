package UD22_Cliente_Video.UD22_Cliente_Video.models;

public class Video {
	private String id;
	private String title;
	private String director;
	private String cliId;
	
	public Video(String id, String title, String director, String cliId) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.cliId = cliId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCliId() {
		return cliId;
	}
	public void setCli_id(String cli_id) {
		this.cliId = cli_id;
	}
}

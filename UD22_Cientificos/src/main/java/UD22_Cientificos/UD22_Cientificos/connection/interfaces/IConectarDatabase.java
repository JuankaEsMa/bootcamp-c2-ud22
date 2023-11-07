package UD22_Cientificos.UD22_Cientificos.connection.interfaces;

public interface IConectarDatabase {
	public void onConnectPress(String port, String username, String password);
	public void onCancelPress();
}

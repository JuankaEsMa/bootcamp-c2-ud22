package UD22_Cliente.UD22_Cliente.connection.interfaces;

public interface IConectarDatabase {
	public void onConnectPress(String port, String username, String password);
	public void onCancelPress();
}

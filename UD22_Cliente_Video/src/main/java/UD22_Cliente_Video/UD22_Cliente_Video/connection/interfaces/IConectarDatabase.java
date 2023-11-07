package UD22_Cliente_Video.UD22_Cliente_Video.connection.interfaces;

public interface IConectarDatabase {
	public void onConnectPress(String port, String username, String password);
	public void onCancelPress();
}

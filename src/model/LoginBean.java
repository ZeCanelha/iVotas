/**
 * Raul Barbosa 2014-11-07
 */
package model;


import java.net.MalformedURLException;
import java.rmi.*;
import Interface.RMIInterface;

public class LoginBean {
	private RMIInterface server;
	private String username; // username and password supplied by the user
	private String password;
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public LoginBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace(); // what happens *after* we reach this line?
		}
	}

	public boolean getLoginValidation() throws RemoteException
	{
		return server.login_user(this.username, this.password);
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

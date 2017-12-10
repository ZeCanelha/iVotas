/**
 * Raul Barbosa 2014-11-07
 */
package model;


import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

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
	
	public HashMap<String,String> getAllElections() throws RemoteException
	{
		HashMap<String,String> new_map = new HashMap<>();
		new_map =  server.getAllElections();
		
		new_map.remove("size");
		
		return new_map;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

/**
 * Raul Barbosa 2014-11-07
 */
package model;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class CreateFacBean {
	private RMIInterface server;
	private String facname; 
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public CreateFacBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}

	public boolean createFaculdade() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("name", this.facname);
		return server.create_fac(map);

	}
	
	public void setFacname(String facname) {
		this.facname = facname;
	}

}

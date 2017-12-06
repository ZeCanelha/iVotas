/**
 * Raul Barbosa 2014-11-07
 */
package model;


import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class ManageMesaBean {
	private RMIInterface server;
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	private String optipo,iduser,idmesa;

	public ManageMesaBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace(); // what happens *after* we reach this line?
		}
	}
	
	public boolean gerir_mesa() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("userid", iduser);
		map.put("idmesa",idmesa);
		map.put("operation", optipo);
		return server.manage_mesa(map);
		
	}
	
	public String getOptipo() {
		return optipo;
	}


	public void setOptipo(String optipo) {
		this.optipo = optipo;
	}


	public String getIduser() {
		return iduser;
	}


	public void setIduser(String iduser) {
		this.iduser = iduser;
	}


	public String getIdmesa() {
		return idmesa;
	}


	public void setIdmesa(String idmesa) {
		this.idmesa = idmesa;
	}

	
}

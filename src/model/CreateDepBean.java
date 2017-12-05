package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import Interface.RMIInterface;

public class CreateDepBean {
	private RMIInterface server;
	private String depname,idfac;
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public CreateDepBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}

	public boolean createDepartamento() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("name", depname);
		map.put("id_fac",idfac);
		
		return server.create_dep(map);
		

	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getIdfac() {
		return idfac;
	}

	public void setIdfac(String idfac) {
		this.idfac = idfac;
	}
	
	

}
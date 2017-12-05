/**
 * Raul Barbosa 2014-11-07
 */
package model;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class AssociateMesaBean {
	private RMIInterface server;
	private String iddep, ideleicao; 
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public AssociateMesaBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public boolean associate_mesa() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("electionid", ideleicao);
		map.put("dep", iddep);
		return server.associate_table(map);
	}

	public String getIddep() {
		return iddep;
	}

	public void setIddep(String iddep) {
		this.iddep = iddep;
	}

	public String getIdeleicao() {
		return ideleicao;
	}

	public void setIdeleicao(String ideleicao) {
		this.ideleicao = ideleicao;
	}

	
}

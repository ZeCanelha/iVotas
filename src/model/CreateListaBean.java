/**
 * Raul Barbosa 2014-11-07
 */
package model;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class CreateListaBean {
	private RMIInterface server;
	private String title,type,electionId; 
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public CreateListaBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public boolean createLista() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("name", title);
		map.put("type0", type);
		map.put("election_id", electionId);
		
		
		return server.create_list(map);
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getElectionId() {
		return electionId;
	}

	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

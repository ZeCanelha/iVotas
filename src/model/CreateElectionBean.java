/**
 * Raul Barbosa 2014-11-07
 */
package model;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class CreateElectionBean {
	private RMIInterface server;
	private String title, description,dep,begin,end,type; 
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public CreateElectionBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public boolean createElection() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("title", title);
		map.put("description", description);
		map.put("dep", dep);
		map.put("type0", type);
		map.put("begin_date", begin);
		map.put("end_date", end);
		
		return server.create_eleicao(map);
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

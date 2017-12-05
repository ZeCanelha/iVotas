/**
 * Raul Barbosa 2014-11-07
 */
package model;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;

import Interface.RMIInterface;

public class EditElectionBean {
	private RMIInterface server;
	private String title, description,begin,end,ideleicao;
	
	public String getIdeleicao() {
		return ideleicao;
	}

	public void setIdeleicao(String ideleicao) {
		this.ideleicao = ideleicao;
	}

	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	


	public EditElectionBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public boolean editElection() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("title", title);
		map.put("description", description);
		map.put("election_id", ideleicao);
		map.put("begin_date", begin);
		map.put("end_date", end);
		
		return server.edit_election(map);
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
}

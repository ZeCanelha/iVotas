package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import Interface.RMIInterface;

public class DetailElectionBean {
	private RMIInterface server;
	private String ideleicao;
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	

	public DetailElectionBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public HashMap<String,String> getDetailElections() throws RemoteException
	{
		return server.detail_election(ideleicao);
	}
	
	public void startNotifications() throws RemoteException
	{
		server.startWebSocketNotifications();
	}

	public String getIdeleicao() {
		return ideleicao;
	}


	public void setIdeleicao(String ideleicao) {
		this.ideleicao = ideleicao;
	}
	

	

}
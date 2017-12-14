package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import Interface.RMIInterface;

public class DetailUserBean {
	private RMIInterface server;
	private String iduser;
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	

	public DetailUserBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
	}
	
	public HashMap<String,String> getUserVote() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map = server.get_user_vote(iduser);
		
		if (map.get("id_mesa").equals("1"))
		{
			map.replace("id_mesa", "Browser");
		}
		
		return map;
	}


	public String getIduser() {
		return iduser;
	}


	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	

	

}
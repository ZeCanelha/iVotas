/**
 * Raul Barbosa 2014-11-07
 */
package model;


import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;



import Interface.RMIInterface;

public class LoginBean {
	private RMIInterface server;
	private String username; // username and password supplied by the user
	private String password;
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	private String electionid,votevalue,usertype,userid;
	


	public LoginBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace(); // what happens *after* we reach this line?
		}
	}
	
	public String getTipoUtilizador() throws RemoteException
	{
		return server.get_elector_type(userid);
	}
	
	public boolean getLoginValidation() throws RemoteException
	{
		return server.login_user(this.username, this.password,this.userid);
	}
	
	public HashMap<String,String> getAllElections() throws RemoteException
	{
		HashMap<String,String> new_map = new HashMap<>();
		new_map =  server.getAllElections();
		
		new_map.remove("size");
		
		return new_map;
	}
	
	public HashMap<String,String> getElectionLists() throws RemoteException
	{
		return server.getListas(electionid);
	}
	
	public HashMap<String,String> getElectionDetails() throws RemoteException
	{
		
		return server.detail_election(electionid);
	
	}
	
	public boolean userVote() throws RemoteException
	{
		return server.alreadyVote(userid);
	}
	public boolean userVoteConselho() throws RemoteException
	{
		return server.alreadyVoteConselho(userid);
	}
	
	public String getTipoEleicao() throws RemoteException
	{
		return server.getElectionType(electionid);
	}
	
	
	public boolean vote() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		
		map.put("id_eleicao", electionid);
		map.put("list_name", votevalue);
		map.put("id_mesa", "-1");
		map.put("userid", userid);
		
		return server.vote(map);
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getElectionid() {
		return electionid;
	}

	public void setElectionid(String electionid) {
		this.electionid = electionid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getVotevalue() {
		return votevalue;
	}

	public void setVotevalue(String votevalue) {
		this.votevalue = votevalue;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


}

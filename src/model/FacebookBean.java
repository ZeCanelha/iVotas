package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import com.github.scribejava.core.model.Token;

import Interface.RMIInterface;

public class FacebookBean {
	private RMIInterface server;
	
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	
	private Token accessToken;
	private String authorizationUrl;
	private String username;
	private String facebook_id;
	private String userid;



	public FacebookBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
		
	}
	
	public boolean getLoginConfirmation(String facebook_id) throws RemoteException
	{
		String user_id;
		
		user_id = server.getFacebookConfirmation(facebook_id);
		
		if ( user_id != null )
		{
			this.setUserid(user_id);
			return true;
		}
		
		return false;
		
	}
	
	public boolean associateFaceAccount(String userid, String facebookid, String accessToken) throws RemoteException
	{
		return server.associateFacebookAccount(userid, facebookid, accessToken);
		
	}
	
	public HashMap<String,String> getFacebookCredentials(String userid) throws RemoteException
	{
		return server.getFacebookLoginInformation(userid);
	}
	
	public boolean removeFacebookInformation(String userid) throws RemoteException
	{
		return server.removeFacebookInformation(userid);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}

	public Token getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Token accessToken) {
		this.accessToken = accessToken;
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	
	
	
	
}
	
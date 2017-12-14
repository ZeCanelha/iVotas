package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


import com.github.scribejava.core.model.Token;

import Interface.RMIInterface;

public class FacebookBean {
	private RMIInterface server;
	
	
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	
	private Token accessToken;
	private String authorizationUrl;

	public FacebookBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}
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
	
	
	
	
	
}
	
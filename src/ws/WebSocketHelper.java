package ws;

import Interface.RMIInterface;
import Interface.WSHelperInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class WebSocketHelper extends UnicastRemoteObject implements WSHelperInterface
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String rmiAddress = "//localhost:6005/rmiserver";
	
	public RMIInterface rmi_server;
	private WebSocketAnnotation websocket;
	private HttpSession browserSession;
	
	WebSocketHelper(WebSocketAnnotation web, HttpSession session) throws RemoteException 
	{
		//TODO: Remove subscription;
		// Lookup and subscribe
		
		this.browserSession = session;
		this.websocket = web;
		
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		try {
			rmi_server = (RMIInterface) Naming.lookup(rmiAddress);
			rmi_server.subscribeWS(this);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getAllUsersVotes() throws RemoteException {
		
		String text = "Numero total de votos: ";
		this.websocket.sendMessage(text + rmi_server.getAllUserVotes());
		
	}
	
	public void removeSubscription() throws RemoteException
	{
		rmi_server.removeSubscription(this);
	}

	@Override
	public void getOnlineUsers() throws RemoteException {
		
		
	}

	@Override
	public void getTableState() throws RemoteException 
	{
		
		String text = "Mesas de voto online: ";
		this.websocket.sendMessage(text + rmi_server.getStates());
		
		
	}
	

}

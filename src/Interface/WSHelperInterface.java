package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface WSHelperInterface extends Remote
{
	void getAllUsersVotes() throws RemoteException;
	void getOnlineUsers() throws RemoteException;
	void getTableState() throws RemoteException;

}

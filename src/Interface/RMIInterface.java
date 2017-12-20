package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface RMIInterface extends Remote {
	public boolean authenticate_user( String user_id ) throws RemoteException;
    public boolean login_user ( String username, String password, String userid) throws  RemoteException;
    public HashMap<String,String> getAllElections() throws RemoteException;
    //public ArrayList<Eleicao> getCurrentElections(String id_mesa) throws RemoteException;
    public boolean vote (HashMap<String,String> map) throws RemoteException;
    public String get_elector_type(String userid) throws RemoteException;
    public HashMap<String,String> getListas(String electionid) throws RemoteException;
    public String getFreeTable() throws RemoteException;
    public void update_estado_mesa(String id_mesa) throws RemoteException;
    public boolean alreadyVote ( String userid) throws RemoteException;
    public boolean alreadyVoteConselho ( String userid ) throws RemoteException;
    public String getElectionType(String electionid) throws RemoteException;
    public int getAllUserVotes() throws RemoteException;
    String getFacebookConfirmation(String facebook_id) throws RemoteException;
    boolean associateFacebookAccount(String userid, String facebook_id,String accessToken) throws RemoteException;
    HashMap<String,String> getFacebookLoginInformation(String userid) throws RemoteException; 
    boolean removeFacebookInformation(String userid) throws RemoteException;



    // Funções da consola de administração

    public boolean create_register(HashMap<String, String> m) throws RemoteException;
    public boolean create_fac(HashMap<String, String> m) throws RemoteException;
    public boolean create_dep(HashMap<String, String> m) throws RemoteException;
    public boolean create_eleicao(HashMap<String, String> m) throws RemoteException;
    public boolean create_list (HashMap<String, String> m) throws RemoteException;
    public boolean edit_election(HashMap<String, String> m) throws RemoteException;
    public boolean alter_user(HashMap<String, String> m) throws RemoteException;
    public boolean associate_table(HashMap<String, String> m) throws RemoteException;
    public HashMap<String ,String> get_user_vote(String userid) throws RemoteException;
    public HashMap<String, String> detail_election(String electionid) throws RemoteException;
    public boolean manage_mesa(HashMap<String, String> map) throws RemoteException;
    public boolean isnt_started ( String election_id) throws RemoteException;
    public boolean same_department( String user_id, int dep ) throws RemoteException;

    // Callbacks | Subscribes

    //public void subscribe_admin_console(AdminConsoleInterface cliente_rmi) throws RemoteException;
    
    
    public void startWebSocketNotifications() throws RemoteException;
    
    void subscribeWS(WSHelperInterface c) throws RemoteException;
    void removeSubscription(WSHelperInterface c) throws RemoteException;
    
    

}


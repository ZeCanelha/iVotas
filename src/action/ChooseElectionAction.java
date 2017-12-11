package action;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.LoginBean;

public class ChooseElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String electionid;

	

	@Override
	public String execute() 
	{
		HashMap<String,String> map = new HashMap<>();
		
		this.getLoginBean().setElectionid(electionid);
		
		try {
			map = this.getLoginBean().getElectionDetails();
			
			for(String i: map.values())
			{
				System.out.println(i);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	public LoginBean getLoginBean() {
		if(!session.containsKey("heyBean"))
			this.setLoginBean(new LoginBean());
		return (LoginBean) session.get("heyBean");
	}

	public void setLoginBean(LoginBean heyBean) {
		this.session.put("heyBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public String getElectionid() {
		return electionid;
	}

	public void setElectionid(String electionid) {
		this.electionid = electionid;
	}
}
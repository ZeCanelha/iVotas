package action;

import com.opensymphony.xwork2.ActionSupport;

import model.LoginBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class OnlineTablesAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	

	

	@Override
	public String execute() {
		
		try {
			this.getHeyBean().startTablesNotifications();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public LoginBean getHeyBean() {
		return (LoginBean) session.get("heyBean");
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

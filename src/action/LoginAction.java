/**
 * Raul Barbosa 2014-11-07
 */
package action;

import com.opensymphony.xwork2.ActionSupport;

import model.LoginBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String username = null, password = null, userid = null;
	private String tipo_eleitor;

	@Override
	public String execute() {
		// any username is accepted without confirmation (should check using RMI)
		if(this.username != null && !username.equals("") && !userid.equals("")) {
			
			if (this.username.equals("admin") && this.password.equals("admin"))
			{
				session.put("username", "admin");
				session.put("loggedin", true);
				return "admin";
			}
			else
			{
				this.getHeyBean().setUsername(this.username);
				this.getHeyBean().setPassword(this.password);
				this.getHeyBean().setUserid(userid);
				try {
					tipo_eleitor = this.getHeyBean().getTipoUtilizador();
					if (tipo_eleitor == null)
						return ERROR;
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.getHeyBean().setUsertype(tipo_eleitor);
				try {
					if (this.getHeyBean().getLoginValidation())
					{
						session.put("userid", userid);
						session.put("username", username);
						session.put("loggedin", true); // this marks the user as logged in
						return SUCCESS;
					}
				} catch (RemoteException e) {
					
					e.printStackTrace();
				}
			}
			
			return LOGIN;
			
		}
		else
			return LOGIN;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username; // will you sanitize this input? maybe use a prepared statement?
	}

	public void setPassword(String password) {
		this.password = password; // what about this input? 
	}
	
	public LoginBean getHeyBean() {
		if(!session.containsKey("heyBean"))
			this.setHeyBean(new LoginBean());
		return (LoginBean) session.get("heyBean");
	}

	public void setHeyBean(LoginBean heyBean) {
		this.session.put("heyBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

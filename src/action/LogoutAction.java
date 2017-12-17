package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware 
{
	
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	@Override
	public String execute() {
		
		this.session.remove("loggedin");
		return SUCCESS;
	
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

package action;
import com.opensymphony.xwork2.ActionSupport;

import model.CreateDepBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateDepAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String depname,idfac;


	@Override
	public String execute() {
		this.getDepBean().setDepname(this.depname);
		this.getDepBean().setIdfac(this.idfac);
		
		try {
			if (this.getDepBean().createDepartamento())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
			
	}
	
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getIdfac() {
		return idfac;
	}
	public void setIdfac(String idfac) {
		this.idfac = idfac;
	}
	
	
	
	public CreateDepBean getDepBean() {
		if(!session.containsKey("depBean"))
			this.setDepBean(new CreateDepBean());
		return (CreateDepBean) session.get("depBean");
	}

	public void setDepBean(CreateDepBean heyBean) {
		this.session.put("depBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
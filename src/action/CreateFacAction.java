package action;

import com.opensymphony.xwork2.ActionSupport;

import model.CreateFacBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateFacAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String facname;

	

	@Override
	public String execute() {
		this.getFacBean().setFacname(this.facname);
		try {
			if (this.getFacBean().createFaculdade())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
			
	}
	
	public String getFacname() {
		return facname;
	}

	public void setFacname(String facname) {
		this.facname = facname;
	}
	
	
	public CreateFacBean getFacBean() {
		if(!session.containsKey("facBean"))
			this.setFacBean(new CreateFacBean());
		return (CreateFacBean) session.get("facBean");
	}

	public void setFacBean(CreateFacBean heyBean) {
		this.session.put("facBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

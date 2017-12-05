package action;

import com.opensymphony.xwork2.ActionSupport;

import model.CreateListaBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateListaAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String title,type,electionId;

	

	@Override
	public String execute() {
		this.getListaBean().setType(type);
		this.getListaBean().setTitle(title);
		this.getListaBean().setElectionId(electionId);
		
		try {
			if(this.getListaBean().createLista())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
		
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getElectionId() {
		return electionId;
	}


	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CreateListaBean getListaBean() {
		if(!session.containsKey("listaBean"))
			this.setListaBean(new CreateListaBean());
		return (CreateListaBean) session.get("listaBean");
	}

	public void setListaBean(CreateListaBean heyBean) {
		this.session.put("listaBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

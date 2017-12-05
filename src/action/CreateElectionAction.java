package action;

import com.opensymphony.xwork2.ActionSupport;

import model.CreateElectionBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String title, description,dep,begin,end,type;

	

	@Override
	public String execute() {
		this.getElectionBean().setBegin(begin);
		this.getElectionBean().setDep(dep);
		this.getElectionBean().setDescription(description);
		this.getElectionBean().setEnd(end);
		this.getElectionBean().setTitle(title);
		this.getElectionBean().setType(type);
		
		
		
		try {
			if ( this.getElectionBean().createElection())
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






	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CreateElectionBean getElectionBean() {
		if(!session.containsKey("electionBean"))
			this.setElectionBean(new CreateElectionBean());
		return (CreateElectionBean) session.get("electionBean");
	}

	public void setElectionBean(CreateElectionBean heyBean) {
		this.session.put("electionBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

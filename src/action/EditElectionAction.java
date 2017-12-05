package action;

import com.opensymphony.xwork2.ActionSupport;

import model.EditElectionBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class EditElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String title, description,begin,end,ideleicao;


	@Override
	public String execute() {
		this.getElectionBean().setBegin(begin);
		this.getElectionBean().setDescription(description);
		this.getElectionBean().setEnd(end);
		this.getElectionBean().setTitle(title);
		this.getElectionBean().setIdeleicao(ideleicao);
		
		try {
			if (this.getElectionBean().editElection())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ERROR;
			
	}
	
	public String getIdeleicao() {
		return ideleicao;
	}


	public void setIdeleicao(String ideleicao) {
		this.ideleicao = ideleicao;
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


	public EditElectionBean getElectionBean() {
		if(!session.containsKey("editElectionBean"))
			this.setEdtitElectionBean(new EditElectionBean());
		return (EditElectionBean) session.get("editElectionBean");
	}

	public void setEdtitElectionBean(EditElectionBean heyBean) {
		this.session.put("editElectionBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

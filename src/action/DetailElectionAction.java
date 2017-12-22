package action;

import com.opensymphony.xwork2.ActionSupport;

import model.DetailElectionBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DetailElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String ideleicao;

	

	@Override
	public String execute() {
		
		HashMap<String,String> map = null;
		this.getDetailBean().setIdeleicao(ideleicao);
		
		try {
			
			map = this.getDetailBean().getDetailElections();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (map.get("title") != null)
			return SUCCESS;
		return ERROR;
		
		
			
	}


	public DetailElectionBean getDetailBean() {
		if(!session.containsKey("detailBean"))
			this.setDetailBean(new DetailElectionBean());
		return (DetailElectionBean) session.get("detailBean");
	}

	public void setDetailBean(DetailElectionBean detailBean) {
		this.session.put("detailBean", detailBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getIdeleicao() {
		return ideleicao;
	}
	public void setIdeleicao(String ideleicao) {
		this.ideleicao = ideleicao;
	}
}

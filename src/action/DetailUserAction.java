package action;

import com.opensymphony.xwork2.ActionSupport;

import model.DetailUserBean;

import org.apache.struts2.interceptor.SessionAware;


import java.util.Map;

public class DetailUserAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String iduser;

	

	@Override
	public String execute() {
		this.getUserBean().setIduser(iduser);
		return SUCCESS;	
			
	}

	public DetailUserBean getUserBean() {
		if(!session.containsKey("detailUserBean"))
			this.setDetailUserBean(new DetailUserBean());
		return (DetailUserBean) session.get("detailUserBean");
	}

	public void setDetailUserBean(DetailUserBean detailUserBean) {
		this.session.put("detailUserBean", detailUserBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	

	public String getIduser() {
		return iduser;
	}


	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

}

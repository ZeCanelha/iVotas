package action;

import com.opensymphony.xwork2.ActionSupport;

import model.AssociateMesaBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class AssociateMesaAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String ideleicao,iddep;

	

	@Override
	public String execute() {
		
		this.getAssociateBean().setIddep(iddep);
		this.getAssociateBean().setIdeleicao(ideleicao);
		
		try {
			if (this.getAssociateBean().associate_mesa())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
			
	}
	
	
	public AssociateMesaBean getAssociateBean() {
		if(!session.containsKey("associateBean"))
			this.setAssociateBean(new AssociateMesaBean());
		return (AssociateMesaBean) session.get("associateBean");
	}

	public void setAssociateBean(AssociateMesaBean heyBean) {
		this.session.put("associateBean", heyBean);
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
	public String getIddep() {
		return iddep;
	}
	public void setIddep(String iddep) {
		this.iddep = iddep;
	}
}

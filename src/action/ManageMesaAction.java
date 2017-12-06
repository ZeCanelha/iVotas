package action;

import com.opensymphony.xwork2.ActionSupport;

import model.ManageMesaBean;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class ManageMesaAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String idmesa,iduser,optipo;

	

	@Override
	public String execute() {
		this.getMesaBean().setIdmesa(idmesa);
		this.getMesaBean().setIduser(iduser);
		this.getMesaBean().setOptipo(optipo);
		
		try {
			if (this.getMesaBean().gerir_mesa())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
			
	}
	
	
	
	public ManageMesaBean getMesaBean() {
		if(!session.containsKey("mesaBean"))
			this.setMesaBean(new ManageMesaBean());
		return (ManageMesaBean) session.get("mesaBean");
	}

	public void setMesaBean(ManageMesaBean heyBean) {
		this.session.put("mesaBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getIdmesa() {
		return idmesa;
	}
	public void setIdmesa(String idmesa) {
		this.idmesa = idmesa;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getOptipo() {
		return optipo;
	}
	public void setOptipo(String optipo) {
		this.optipo = optipo;
	}
	
}

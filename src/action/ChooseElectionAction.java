package action;



import java.rmi.RemoteException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.LoginBean;

public class ChooseElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String electionid,tipoEleicao;

	

	@Override
	public String execute() 
	{	
		this.getLoginBean().setElectionid(electionid);
		
		try {
			this.getLoginBean().startNotifications();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/* Verificar se o utilizador pode votar */
		
		try {
			System.out.println(this.getLoginBean().userVoteConselho());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			tipoEleicao = this.getLoginBean().getTipoEleicao();
			
			if (tipoEleicao.equalsIgnoreCase("NUCLEO"))
			{
				if (!this.getLoginBean().userVote())
				{
					if(!this.getLoginBean().getUsertype().equalsIgnoreCase("estudante"))
					{
						return "stop";
					}
					else
					{
						return SUCCESS;
					}
				}
				else
					return "stop";
				
			}
			else if (tipoEleicao.equalsIgnoreCase("DEPARTAMENTO") || tipoEleicao.equalsIgnoreCase("FACULDADE") )
			{
				if (!this.getLoginBean().userVote())
				{
					if(!this.getLoginBean().getUsertype().equalsIgnoreCase("estudante"))
					{
						return SUCCESS;
					}
					else
					{
						return "stop";
					}
				}
				else
					return "stop";
				
			}
			else if (tipoEleicao.equalsIgnoreCase("CONSELHO GERAL"))
			{
				if (this.getLoginBean().userVoteConselho())
					return "stop";
				return SUCCESS;
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		
	}
	
	public LoginBean getLoginBean() {
		if(!session.containsKey("heyBean"))
			this.setLoginBean(new LoginBean());
		return (LoginBean) session.get("heyBean");
	}

	public void setLoginBean(LoginBean heyBean) {
		this.session.put("heyBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public String getElectionid() {
		return electionid;
	}

	public void setElectionid(String electionid) {
		this.electionid = electionid;
	}
}
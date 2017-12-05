package action;

import java.rmi.RemoteException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.EditUserBean;

public class EditUserAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String nome,password,departamento,morada,telefone,numcc,validadecc,tipo,iduser;


	@Override
	public String execute() 
	{
		this.getUserBean().setNome(nome);
		this.getUserBean().setDepartamento(departamento);
		this.getUserBean().setMorada(morada);
		this.getUserBean().setNumcc(numcc);
		this.getUserBean().setPassword(password);
		this.getUserBean().setTelefone(telefone);
		this.getUserBean().setValidadecc(validadecc);
		this.getUserBean().setTipo(tipo);
		this.getUserBean().setIduser(iduser);
		
		
		try {
			if (this.getUserBean().alter_user())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
	}
	

	
	
	public EditUserBean getUserBean() {
		if(!session.containsKey("editUserBean"))
			this.setEditUserBean(new EditUserBean());
		return (EditUserBean) session.get("editUserBean");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMorada() {
		return morada;
	}


	public void setMorada(String morada) {
		this.morada = morada;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumcc() {
		return numcc;
	}
	public void setNumcc(String numcc) {
		this.numcc = numcc;
	}

	public String getValidadecc() {
		return validadecc;
	}
	public void setValidadecc(String validadecc) {
		this.validadecc = validadecc;
	}
	public void setEditUserBean(EditUserBean heyBean) {
		this.session.put("editUserBean", heyBean);

	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

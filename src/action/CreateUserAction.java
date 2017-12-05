package action;

import java.rmi.RemoteException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.CreateUserBean;

public class CreateUserAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String nome,password,departamento,morada,telefone,numcc,validadecc,tipo;


	@Override
	public String execute() {
		this.getUserBean().setNome(nome);
		this.getUserBean().setDepartamento(departamento);
		this.getUserBean().setMorada(morada);
		this.getUserBean().setNumcc(numcc);
		this.getUserBean().setPassword(password);
		this.getUserBean().setTelefone(telefone);
		this.getUserBean().setValidadecc(validadecc);
		this.getUserBean().setTipo(tipo);
		
		
		try {
			if ( this.getUserBean().create_user())
			{
				return SUCCESS;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
	}
	

	
	
	public CreateUserBean getUserBean() {
		if(!session.containsKey("userBean"))
			this.setUserBean(new CreateUserBean());
		return (CreateUserBean) session.get("userBean");
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
	public void setUserBean(CreateUserBean heyBean) {
		this.session.put("userBean", heyBean);

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
}

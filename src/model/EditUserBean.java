package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import Interface.RMIInterface;

public class EditUserBean {
	
	private RMIInterface server;
	private static final String rmiAddress = "rmi://127.0.0.1:6005/rmiserver";
	private String nome,password,departamento,morada,telefone,numcc,validadecc,tipo,iduser;
	
	



	public EditUserBean() {
		
		try {
			server = (RMIInterface) Naming.lookup(rmiAddress);
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {

			e.printStackTrace();
		}

	}
	
	public boolean alter_user() throws RemoteException
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("username", nome);
		map.put("password", password);
		map.put("morada",morada);
		map.put("telemovel", telefone);
		map.put("validade", validadecc);
		map.put("dep", departamento);
		map.put("cartao", numcc);
		map.put("tipo", tipo);
		map.put("userid", iduser);
		return server.alter_user(map);
		
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
}

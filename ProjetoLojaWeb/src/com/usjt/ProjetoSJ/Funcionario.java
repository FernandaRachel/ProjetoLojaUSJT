package com.usjt.ProjetoSJ;

import com.usjt.DAO.FuncionarioDAO;
import com.usjt.TO.FuncionarioTO;

public class Funcionario {
	
	private int idFuncionario;
	   private String usuario;
	   private String senha;
	   private String rg;
	   private boolean logado = false;
	   
	   
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	
	public void criar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(idFuncionario);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setRg(rg);
		dao.incluir(to);
	}
	public void atualizar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(idFuncionario);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setRg(rg);
		dao.atualizar(to);
	}
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(idFuncionario);
		dao.excluir(to);
	}
	/*public void carregar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = dao.carregar(idFuncionario);
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setRg(rg);
	}*/ 
	
	@Override
	public String toString() {
		return "Cliente [id:" + idFuncionario + ", Usuario:" + usuario + ", Senha:" + senha + "RG:"
				+ rg + "]";
	}

}

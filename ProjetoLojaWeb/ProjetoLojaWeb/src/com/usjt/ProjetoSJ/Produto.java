package com.usjt.ProjetoSJ;

import com.usjt.DAO.ProdutoDAO;
import com.usjt.TO.ProdutoTO;

public class Produto {
	
	private int qtd, id;
    private double valor; 
    private String nome, marca, fornecedor; 

	   public Produto(int id, int qtd, double valor, String nome, String marca, String fornecedor){
	      this.id = id;
	      this.qtd = qtd;
	      this.valor = valor;
	      this.nome = nome;
	      this.marca = marca;
	      this.fornecedor = fornecedor;
	   }
	   
	   public Produto(){
	   
	   }
	   
	   public Produto(int id){
	      this.id = id;
	   }
	 
	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void criar() {
	   ProdutoDAO dao = new ProdutoDAO();
	   ProdutoTO to = new ProdutoTO();
	   to.setId(id);
	   to.setQtd(qtd);
	   to.setValor(valor);
	   to.setNome(nome);
	   to.setMarca(marca);		
	   dao.incluir(to);
	   }
	public void atualizar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
   		to.setQtd(qtd);
   		to.setValor(valor);
   		to.setNome(nome);
   		to.setMarca(marca);	
		dao.atualizar(to);
	}
	
	public void delete(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
		dao.excluir(to);
	}
	
	public void carregar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
   		to.setQtd(qtd);
   		to.setValor(valor);
   		to.setNome(nome);
   		to.setMarca(marca);
   		dao.carregar(to);
	}

}

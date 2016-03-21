package com.usjt.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Funcionario;

import java.io.IOException;
import java.io.PrintWriter;

public class FuncionarioControle {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pID = request.getParameter("func");
		String pUser = request.getParameter("user");
		String pSenha = request.getParameter("senha");
		String pRG = request.getParameter("rg");
		int id = Integer.parseInt(pID);
		String event = request.getParameter("event");

		Funcionario f = new Funcionario();

		if (event.equals("Cadastrar")) {
			f.criar();
			
			PrintWriter out = response.getWriter();
			out.println("Cliente cadastrado");
			
		} else if (event.equals("Excluir")) {
			f.excluir();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + f.getIdFuncionario() + "<br>");
			out.println("nome: " + f.getUsuario() + "<br>");
			out.println("valor: " + f.getSenha() + "<br>");
			out.println("marca: " + f.getRg() + "<br>");
			out.println("</body></html>");

		} else if (event.equals("Atualizar")) {
			f.atualizar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + f.getIdFuncionario() + "<br>");
			out.println("nome: " + f.getUsuario() + "<br>");
			out.println("valor: " + f.getSenha() + "<br>");
			out.println("marca: " + f.getRg() + "<br>");
			out.println("</body></html>");

		} else {
			f.carregar();
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + f.getIdFuncionario() + "<br>");
			out.println("nome: " + f.getUsuario() + "<br>");
			out.println("valor: " + f.getSenha() + "<br>");
			out.println("marca: " + f.getRg() + "<br>");
			out.println("</body></html>");

		}
	}
}

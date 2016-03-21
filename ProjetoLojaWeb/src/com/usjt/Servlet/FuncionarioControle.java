package com.usjt.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Funcionario;

import java.io.IOException;

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
		} else if (event.equals("Excluir")) {
			f.excluir();
		} else if (event.equals("Atualizar")) {
			f.atualizar();
		} else {
			f.carregar();
		}
	}
}

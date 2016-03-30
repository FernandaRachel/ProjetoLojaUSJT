package com.usjt.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Funcionario;
import com.usjt.TO.FuncionarioTO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FuncionarioController.do")
public class FuncionarioController extends HttpServlet {
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
		
		String event = request.getParameter("event");

		
		Funcionario f = new Funcionario(0,pUser,pSenha,pRG);

		if (event.equals("Cadastrar")) {
			f.criar();
			
			PrintWriter out = response.getWriter();
			out.println("Cliente cadastrado");
			
			f.carregar();
		} else if (event.equals("Excluir")) {
			int id = Integer.parseInt(pID);
			
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
		f.carregar();
		
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(f.getIdFuncionario());
		to.setUsuario(f.getUsuario());
		to.setSenha(f.getSenha());
		to.setRg(f.getRg());
		
		request.setAttribute("funcionario", to);

		RequestDispatcher view = 
					request.getRequestDispatcher("Funcionario.jsp");
		view.forward(request, response);

		
	}
}

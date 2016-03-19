package com.usjt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Funcionario;

@WebServlet("/FuncionarioController")
public class FuncionarioController {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
			}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String pId = request.getParameter("id");
//		String pUser = request.getParameter("user");
//		String pSenha = request.getParameter("senha");
//		String pNome = request.getParameter("rg");
//		int id = Integer.parseInt(pId);

		
		Funcionario f = new Funcionario();
		f.criar();
		//f.carregar();
		
		PrintWriter out = response.getWriter();
		out.println("teste");
//		out.println("<html><head><title>Produto Cadastrado</title></head><body>");
//		out.println( "id: "+p.getId()+"<br>");
//		out.println( "nome: "+p.getNome()+"<br>");
//		out.println( "valor: "+p.getValor()+"<br>");
//		out.println( "marca: "+p.getMarca()+"<br>");
//		out.println( "fornecedor: "+p.getFornecedor()+"<br>");
//		out.println("</body></html>");
		
//		if(submit.equals(addprod)){
//			
//		}
//		
	}

}

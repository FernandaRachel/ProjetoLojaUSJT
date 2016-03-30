package com.usjt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Produto;
import com.usjt.TO.ProdutoTO;

@WebServlet("/ManterProduto.do")
public class ProdutoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		String pQtd = request.getParameter("qtd");
		String pValor = request.getParameter("valor");
		String pNome = request.getParameter("nome");
		String pMarca = request.getParameter("marca");
		String pForn = request.getParameter("fornecedor");
		
		double valor = Double.parseDouble(pValor);
		int qtd = Integer.parseInt(pQtd);
		String event = request.getParameter("event");

		Produto p = new Produto(0, qtd, valor, pNome, pMarca, pForn);

		if (event.equals("Adicionar Produto")) {

			p.criar();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + p.getId() + "<br>");
			out.println("nome: " + p.getNome() + "<br>");
			out.println("valor: " + p.getValor() + "<br>");
			out.println("marca: " + p.getMarca() + "<br>");
			out.println("fornecedor: " + p.getFornecedor() + "<br>");
			out.println("</body></html>");
		} else if (event.equals("Excluir Produto")) {
			int id = Integer.parseInt(pId);
			p.delete();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + p.getId() + "<br>");
			out.println("nome: " + p.getNome() + "<br>");
			out.println("valor: " + p.getValor() + "<br>");
			out.println("marca: " + p.getMarca() + "<br>");
			out.println("fornecedor: " + p.getFornecedor() + "<br>");
			out.println("</body></html>");

		} else if (event.equals("Atualizar")) {
			p.atualizar();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + p.getId() + "<br>");
			out.println("nome: " + p.getNome() + "<br>");
			out.println("valor: " + p.getValor() + "<br>");
			out.println("marca: " + p.getMarca() + "<br>");
			out.println("fornecedor: " + p.getFornecedor() + "<br>");
			out.println("</body></html>");

		} else {
			p.carregar();

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Produto Cadastrado</title></head><body>");
			out.println("id: " + p.getId() + "<br>");
			out.println("nome: " + p.getNome() + "<br>");
			out.println("valor: " + p.getValor() + "<br>");
			out.println("marca: " + p.getMarca() + "<br>");
			out.println("fornecedor: " + p.getFornecedor() + "<br>");
			out.println("</body></html>");
		}

		ProdutoTO to = new ProdutoTO();
		to.setId(p.getId());
		to.setQtd(p.getQtd());
		to.setValor(p.getValor());
		to.setNome(p.getNome());
		to.setMarca(p.getMarca());
		to.setFornecedor(p.getFornecedor());
		

		request.setAttribute("produto", to);

		RequestDispatcher view = request.getRequestDispatcher("Produto.jsp");
		view.forward(request, response);

	}

}

package com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.usjt.ProjetoSJ.ConnectionFactory;
import com.usjt.TO.ProdutoTO;

public class ProdutoDAO {

	public void incluir(ProdutoTO to) {
		String sqlInsert = "INSERT INTO PRODUTO (QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR) VALUES (?,?,?,?,?)";

		// PreparedStatement stm = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setInt(1, to.getQtd());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getMarca());
			stm.setString(5, to.getFornecedor());
			stm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // Fim inserir

	public void excluir(ProdutoTO to) {
		String sqlDelete = "DELETE FROM PRODUTO WHERE idProduto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim excluir

	public void carregar(int id) {
		String sqlSelect = "SELECT QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR FROM Produto WHERE idProduto = ?";

		ProdutoTO to = new ProdutoTO();
		ResultSet rs = null;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			rs = stm.executeQuery();

			if (rs.next()) {
				to.setQtd(rs.getInt(1));
				to.setValor(rs.getDouble(2));
				to.setNome(rs.getString(3));
				to.setMarca(rs.getString(4));
				to.setFornecedor(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // Fim Carregar

	public void atualizar(ProdutoTO to) {
		String sqlUpdate = "UPDATE PRODUTO SET QNT_ESTOQUE = ?, VALOR = ?, NOME = ?, MARCA = ?, FORNECEDOR = ? WHERE idProduto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {

			stm.setInt(1, to.getQtd());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getMarca());
			stm.setString(5, to.getFornecedor());
			stm.setInt(6, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

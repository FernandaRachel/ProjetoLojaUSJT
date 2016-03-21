package com.usjt.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.usjt.ProjetoSJ.ConnectionFactory;
import com.usjt.TO.FuncionarioTO;

import java.sql.*;

public class FuncionarioDAO {

	public void incluir(FuncionarioTO to) {

		String sqlInsert = "INSERT INTO FUNCIONARIO (USUARIO, SENHA, RG) VALUES (?,?,?)";

		// PreparedStatement stm = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setString(1, to.getUsuario());
			stm.setString(2, to.getSenha());
			stm.setString(3, to.getRg());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim inserir

	public void atualizar(FuncionarioTO to) {
		String sqlUpdate = "UPDATE FUNCIONARIO SET USUARIO = ?, SENHA = ?, rg = ? WHERE idFuncionario = ?";
		// PreparedStatement stm = null;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			// PreparedStatement stm = conn.prepareStatement(sqlUpdate);

			stm.setString(1, to.getUsuario());
			stm.setString(2, to.getSenha());
			stm.setString(3, to.getRg());
			stm.setInt(4, to.getIdFuncionario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public FuncionarioTO carregar(int id) {
		String sqlSelect = "SELECT usuario, senha, rg,  FROM Funcionario WHERE IdFuncionario = ?";
		// PreparedStatement stm = null;
		ResultSet rs = null;

		FuncionarioTO to = new FuncionarioTO();

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setInt(1, id);

			if (rs.next()) {
				to.setIdFuncionario(rs.getInt(1));
				to.setUsuario(rs.getString(2));
				to.setSenha(rs.getString(3));
				to.setRg(rs.getString(4));

				stm.setInt(4, to.getIdFuncionario());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return to;
	}

	public void excluir(FuncionarioTO to) {
		String sqlDelete = "DELETE FROM FUNCIONARIO WHERE idFuncionario = ?";
		// PreparedStatement stm = null; --> DUVIDA (?) Por q o
		// PreparedStatement n começa como NULL???

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, to.getIdFuncionario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim excluir

}

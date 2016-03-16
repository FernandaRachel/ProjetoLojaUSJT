package com.usjt.DAO;
import javax.sql.*;
import com.usjt.TESTE,*;

import ProjetoSJ.ConnectionFactory;

import com.usjt.TO.FuncionarioTO;

import java.sql.*;

public class FuncionarioDAO {

	public void incluir (FuncionarioTO to){
	     
		String sqlInsert = "INSERT INTO FUNCIONARIO (USUARIO, SENHA, RG) VALUES (?,?,?)";
	      
	      PreparedStatement stm = null; 
	      try{
	    	  Connection conn = new ConnectionFactory.obtemConexao();
	      
	        stm = conn.prepareStatement(sqlInsert);
			 stm.setString(1, to.getUsuario());
	         stm.setString(2, to.getSenha());
	         stm.setString(3, to.getRg());
	         stm.execute();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	         try{
	            conn.rollback();
	         }
	         catch(SQLException e1) {
	            System.out.print(e1.getStackTrace());
	         }      
	      }
	      finally{
	         if(stm!=null){
	            try{
	               stm.close();
	            }
	            catch(SQLException e1){
	               System.out.println(e1.getStackTrace());
	            }
	         }
	      }
	   } // Fim inserir
	 
	public void atualizar(FuncionarioTO to) {
	      String sqlUpdate = "UPDATE FUNCIONARIO SET USUARIO = ?, SENHA = ?, rg = ? WHERE idFuncionario = ?";
	      PreparedStatement stm = null;
	      try {
	    	  //PreparedStatement stm = conn.prepareStatement(sqlUpdate);
	         stm = conn.prepareStatement(sqlUpdate);
	         stm.setString(1, to.getUsuario());
	         stm.setString(2, to.getSenha());	
	         stm.setString(3, to.getRg());	
	         stm.setInt(4, to.getIdFuncionario());
	         stm.execute();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	         try {
	            conn.rollback();
	         } 
	         catch (SQLException e1) {
	            System.out.print(e1.getStackTrace());
	         }
	      } 
	      finally {
	         if (stm != null) {
	            try {
	               stm.close();
	            } 
	            catch (SQLException e1) {
	               System.out.print(e1.getStackTrace());
	            }
	         }
	      }
	   }

	   public void excluir(FuncionarioTO to){
	      String sqlDelete = "DELETE FROM FUNCIONARIO WHERE idFuncionario = ?";
	    //  PreparedStatement stm = null;  --> DUVIDA (?) Por q o PreparedStatement n começa como NULL???
	      try{
	    	 Connection conn = ConnectionFactory.obtemConexao();
	    	 PreparedStatement stm = conn.prepareStatement(sqlDelete);
	         stm = conn.prepareStatement(sqlDelete);
	         stm.setInt(1, to.getIdFuncionario());
	         stm.execute();         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	         try{
	            conn.rollback();
	         }
	         catch(SQLException e1){
	            System.out.println(e1.getStackTrace());
	         }
	      }
	      finally{
	         if(stm!=null){
	            try{
	               stm.close();
	            }
	            catch(SQLException e1){
	               System.out.println(e1.getStackTrace());
	            }
	         }
	      }
	   } // Fim excluir


}

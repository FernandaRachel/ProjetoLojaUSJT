package ProjetoSJ;
import java.sql.*;

public class ConnectionFactory {
	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		}
		}
		
	// Obtém conexão com o banco de dados
		public static Connection obtemConexao() throws SQLException {
		
			return DriverManager
		.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
		}
		

}

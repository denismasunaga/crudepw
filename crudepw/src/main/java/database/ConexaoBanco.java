package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	private static Connection obterConexao() throws SQLException {
	    return DriverManager.getConnection("jdbc:hsqldb:" + db_file_name_prefix, "sa", "");                      // password
	}
}

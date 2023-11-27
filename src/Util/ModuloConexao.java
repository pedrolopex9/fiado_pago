package Util;

import java.sql.Connection;
import java.sql.*;
/*import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;*/

public class ModuloConexao {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/projetos";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "Guilherme-2003";

    private static Connection conexao;

    public ModuloConexao() {
        ModuloConexao.conexao = null;
    }

  public Connection conectar() {
      try {
          
          Class.forName("org.postgresql.Driver");
         
          // Conecte ao banco de dados
          conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
          return conexao;

        
      } catch (Exception e) {
    	  System.out.println(e);
          e.printStackTrace();
          return null;
      }
  }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexao()
    {
    	return conexao;
    }

    public boolean executarSQL(String sql) {
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


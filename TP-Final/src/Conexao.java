import java.sql.*;
	import javax.swing.JOptionPane;

	public class Conexao {
	    private String url;
        private String usuario;
        private String senha;
        private Connection con;
        private Statement Stmt = null;
	    
	    public Conexao(){

            url = "jdbc:sqlserver://localhost:1433";
            usuario = "root";
            senha = "root";

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = (Connection) DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conexão Realizada com Sucesso!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
           

	    public void incluir(String nome, int idade, float peso, float altura, String objetivo){        
	        try {
	            Stmt.executeUpdate("insert into tb_aluno (nome, idade, peso, altura, objetivo)values("+"'"+ nome +"'"+","+idade+","+peso+","+altura+",'"+objetivo+"')");
	            JOptionPane.showMessageDialog(null, "enviado");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Não enviado");
	        }        
	    }
	}
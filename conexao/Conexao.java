package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//clase conexao
public class Conexao {
    // ela será a mesma para todos os objetos da classe
    public static Connection connection;
    public PreparedStatement pstm;
    public Statement stmt;
    public ResultSet rs;
    //construtor abre conexao
    public void  Conexao(){
        if(connection == null){
            try {
                Class.forName("org.postgresql.Driver");        
            }catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null," Inclui drive na biblioteca! ");
                e.printStackTrace();
                return;
            }
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/projet_celular","postgres","sua_senha");        
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Conexao falhou! Cheque seu console ");
                e.printStackTrace();
                return;
            }
        }
    }
}

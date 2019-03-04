
package model;

import conexao.Conexao;
import static conexao.Conexao.connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class FuncionarioDAO extends Conexao{       
    public FuncionarioDAO(){
        Conexao();
    }
    public void Salvar(Funcionario funcionario) throws SQLException{
  
        String sql = "insert into funcionario(nome, sobrenome, telefone, endereco, dtNascimento, salario)values(?,?,?,?,?,?)";
        pstm = connection.prepareStatement(sql);
        pstm.setString(1, funcionario.getNome());
        pstm.setString(2, funcionario.getSobrenome());
        pstm.setString(3, funcionario.getTelefone());
        pstm.setString(4, funcionario.getEndereco());
        pstm.setInt(5, funcionario.getDtNascimento());
        pstm.setFloat(6, funcionario.getSalario());
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null,"Cadastro funcionario realizado com sucesso");      

    }
    public List<Funcionario> consulta() throws Exception{
	String SQL = "select * from funcionario";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        Funcionario funcionario;
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	while(rs.next()){
           funcionario = new Funcionario();
           funcionario.setNome(rs.getString("Nome"));
           funcionario.setSobrenome(rs.getString("sobrenome"));
           funcionario.setTelefone(rs.getString("telefone"));
           funcionario.setEndereco(rs.getString("endereco"));
           funcionario.setDtNascimento(rs.getInt("dtNascimento"));
           funcionarios.add(funcionario);
           
        }
        return funcionarios;
    }
}

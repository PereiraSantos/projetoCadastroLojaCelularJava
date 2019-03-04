
package model;

import conexao.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO extends Conexao{
    public ClienteDAO(){
        Conexao();
    }
    public void Salvar(Cliente cliente) throws SQLException{
  
        String sql = "insert into cliente(cpf, nome, sobrenome, telefone, endereco, dtNascimento)values(?,?,?,?,?,?)";
        pstm = connection.prepareStatement(sql);
        pstm.setInt(1, cliente.getCpf());
        pstm.setString(2, cliente.getNome());
        pstm.setString(3, cliente.getSobrenome());
        pstm.setString(4, cliente.getTelefone());
        pstm.setString(5, cliente.getEndereco());
        pstm.setInt(6, cliente.getDtNascimento());
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null,"Cadastro cliente realizado com sucesso");      

    }
    public List<Cliente> consulta() throws Exception{
	String SQL = "select * from cliente";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        Cliente cliente;
	List<Cliente> clientes = new ArrayList<Cliente>();
	while(rs.next()){
           cliente = new Cliente();
           cliente.setCpf(rs.getInt("cpf"));
           cliente.setNome(rs.getString("nome"));
           cliente.setSobrenome(rs.getString("sobrenome"));
           cliente.setTelefone(rs.getString("telefone"));
           cliente.setEndereco(rs.getString("endereco"));
           cliente.setDtNascimento(rs.getInt("dtNascimento"));
           clientes.add(cliente);
           
        }
        return clientes;
    }
    // busca no banco
    public List<Cliente> consultac(String nome) throws Exception{
        String SQL = "SELECT cpf, nome, sobrenome, telefone, endereco, dtNascimento FROM cliente WHERE nome='" + nome  + "'";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        Cliente cliente;
	List<Cliente> clientes = new ArrayList<Cliente>();
	while(rs.next()){
           cliente = new Cliente();
           cliente.setCpf(rs.getInt("cpf"));
           cliente.setNome(rs.getString("nome"));
           cliente.setSobrenome(rs.getString("sobrenome"));
           cliente.setTelefone(rs.getString("telefone"));
           cliente.setEndereco(rs.getString("endereco"));
           cliente.setDtNascimento(rs.getInt("dtNascimento"));
           clientes.add(cliente);
           
        }
        return clientes;
    }
}

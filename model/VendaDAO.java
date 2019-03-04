
package model;

import conexao.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VendaDAO extends Conexao{
    public VendaDAO(){
        Conexao();
    }
    public void Salvar(Venda venda) throws SQLException{
  
        String sql = "insert into venda(cpf, codigoproduto, quantidade, datavenda, tipovenda, qmes, valorvenda)values(?,?,?,?,?,?,?)";
        pstm = connection.prepareStatement(sql);
        pstm.setInt(1, venda.getCpf());
        pstm.setInt(2, venda.getCodigoProduto());
        pstm.setInt(3, venda.getQuantidade());
        pstm.setString(4, venda.getData());
        pstm.setString(5, venda.getTipoVenda());
        pstm.setInt(6, venda.getQMes());
        pstm.setFloat(7, venda.getValorVenda());
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null,"Cadastro venda realizado com sucesso");      
 
    }
    public List<VendaT> consulta() throws Exception{
	String SQL = "SELECT  cliente.cpf, nome, sobrenome, marca, modelo, valor FROM vendA inner join cliente on venda.cpf = cliente.cpf inner join produto on venda.codigoproduto = produto.codigoproduto;";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        VendaT vendat;
	List<VendaT> vendas = new ArrayList<VendaT>();
	while(rs.next()){
           vendat = new VendaT();
           vendat.setCpf(rs.getInt("cpf"));
           vendat.setNome(rs.getString("nome"));
           vendat.setSobrenome(rs.getString("sobrenome"));
           vendat.setMarca(rs.getString("marca"));
           vendat.setModelo(rs.getString("modelo"));
           vendat.setValor(rs.getFloat("valor"));
           
           vendas.add(vendat);
           
        }
        return vendas;
    }
}

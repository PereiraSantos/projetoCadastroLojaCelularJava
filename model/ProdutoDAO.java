
package model;

import static conexao.Conexao.connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import conexao.Conexao;

public class ProdutoDAO extends Conexao{
    public ProdutoDAO(){
        Conexao();
    }
    public void Salvar(Produto produto) throws SQLException{
  
        String sql = "insert into produto(marca, modelo, descricao, valor)values(?,?,?,?)";
        pstm = connection.prepareStatement(sql);
        pstm.setString(1, produto.getMarca());
        pstm.setString(2, produto.getModelo());
        pstm.setString(3, produto.getDescricao());
        pstm.setFloat(4, produto.getValor());
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null,"Cadastro produto realizado com sucesso");      

    }

    
        public List<Produto> consulta() throws Exception{
	String SQL = "select * from produto";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        Produto produto;
	List<Produto> produtos = new ArrayList<Produto>();
	while(rs.next()){
           produto = new Produto();
           produto.setCodigoProduto(rs.getInt("codigoProduto"));
           produto.setMarca(rs.getString("marca"));
           produto.setModelo(rs.getString("modelo"));
           produto.setDescricao(rs.getString("descricao"));
           produto.setValor(rs.getFloat("valor"));
           produtos.add(produto);
           
        }
        return produtos;
    }
    // busca no banco
    public List<Produto> consultap(String marca) throws Exception{

        String SQL = "SELECT codigoproduto, marca, modelo, descricao, valor FROM produto WHERE marca='" + marca  + "'";
	pstm = connection.prepareStatement(SQL);
	rs = pstm.executeQuery();
        Produto produto;
	List<Produto> produtos = new ArrayList<Produto>();
	while(rs.next()){
           produto = new Produto();
           produto.setCodigoProduto(rs.getInt("codigoproduto"));
           produto.setMarca(rs.getString("marca"));
           produto.setModelo(rs.getString("modelo"));
           produto.setDescricao(rs.getString("descricao"));
           produto.setValor(rs.getFloat("valor"));

           produtos.add(produto);
           
        }
        return produtos;
    }
}

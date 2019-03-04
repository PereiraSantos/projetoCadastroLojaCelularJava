
package view;

import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.Produto;
import model.ProdutoDAO;
import table.ProdutoTableModel;

public class TelaTabelaProduto extends JFrame{
     private JPanel contentPane;
    private JTable table;
    private ProdutoTableModel produtoTableModel;
    private List<Produto> Produtos = null;
    
        public TelaTabelaProduto() throws Exception {

        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela");
        this.setVisible(true);
        this.setSize(1000, 600);
        table = new JTable();
        table.setBounds(22, 50, 900, 500);
        tela.add(table);

        ProdutoDAO produto= new ProdutoDAO();
        Produtos = produto.consulta();

        produtoTableModel = new ProdutoTableModel(Produtos);
        table.setModel(produtoTableModel);
    }
}

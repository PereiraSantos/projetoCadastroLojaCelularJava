
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Produto;


public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> consulta;

    public ProdutoTableModel(List<Produto> Produtos) {
        this.consulta = Produtos;

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.consulta.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "codigoProduto";
            case 1:
                return "marca";
            case 2:
                return "modelo";
            case 3:
                return "descricao";
            case 4:
                return "valor";
            default:
                return "?";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = consulta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produto.getCodigoProduto();
            case 1:
                return produto.getMarca();
            case 2:
                return produto.getModelo();
            case 3:
                return produto.getDescricao();
            case 4:
                return produto.getValor();

            default:
                return null;
        }

    }

    public Produto getPneu(int rowIndex) {
        Produto produto = consulta.get(rowIndex);
        return produto;
    }
}

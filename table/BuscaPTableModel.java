
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;


public class BuscaPTableModel extends AbstractTableModel{
        private List<Produto> consultap;

    public BuscaPTableModel(List<Produto> Produtos) {
        this.consultap = Produtos;

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return this.consultap.size();
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
        Produto produto = consultap.get(rowIndex);
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
        Produto produto = consultap.get(rowIndex);
        return produto;
    }
}

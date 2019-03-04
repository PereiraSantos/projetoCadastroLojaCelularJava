
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;
import model.VendaT;


public class VendaTableModel extends AbstractTableModel {
        private List<VendaT> consulta;

    public VendaTableModel(List<VendaT> Vendas) {
        this.consulta = Vendas;

    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return this.consulta.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "cpf";
            case 1:
                return "nome";
            case 2:
                return "sobrenome";
            case 3:
                return "marca";
            case 4:
                return "modelo";
            case 5:
                return "valor";
            default:
                return "?";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaT venda = consulta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return venda.getCpf();
            case 1:
                return venda.getNome();
            case 2:
                return venda.getSobrenome();
            case 3:
                return venda.getMarca();
            case 4:
                return venda.getModelo();
            case 5:
                return venda.getValor();
            default:
                return null;
        }

    }

    public VendaT getPneu(int rowIndex) {
        VendaT venda = consulta.get(rowIndex);
        return venda;
    }
}

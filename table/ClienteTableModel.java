
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

public class ClienteTableModel extends AbstractTableModel {
    
        private List<Cliente> consulta;

    public ClienteTableModel(List<Cliente> Clientes) {
        this.consulta = Clientes;

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
                return "Cpf";
            case 1:
                return "Nome";
            case 2:
                return "Sobrenome";
            case 3:
                return "Telefone";
            case 4:
                return "Endereco";
            case 5:
                return "DtNascimento";
            default:
                return "?";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = consulta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cliente.getCpf();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getSobrenome();
            case 3:
                return cliente.getTelefone();
            case 4:
                return cliente.getEndereco();
            case 5:
                return cliente.getDtNascimento();
            default:
                return null;
        }

    }

    public Cliente getPneu(int rowIndex) {
        Cliente cliente = consulta.get(rowIndex);
        return cliente;
    }
}

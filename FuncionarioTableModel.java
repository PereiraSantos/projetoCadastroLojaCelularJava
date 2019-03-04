
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Funcionario;


public class FuncionarioTableModel extends AbstractTableModel{
    
    private List<Funcionario> consulta;

    public FuncionarioTableModel(List<Funcionario> Funcionarios) {
        this.consulta = Funcionarios;

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
                return "Nome";
            case 1:
                return "Sobrenome";
            case 2:
                return "Telefone";
            case 3:
                return "Endereco";
            case 4:
                return "DtNascimento";
            case 5:
                return "salario";
            default:
                return "?";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = consulta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return funcionario.getNome();
            case 1:
                return funcionario.getSobrenome();
            case 2:
                return funcionario.getTelefone();
            case 3:
                return funcionario.getEndereco();
            case 4:
                return funcionario.getDtNascimento();
            case 5: 
                return funcionario.getSalario();
            default:
                return null;
        }

    }

    public Funcionario getPneu(int rowIndex) {
        Funcionario funcionario = consulta.get(rowIndex);
        return funcionario;
    }
}

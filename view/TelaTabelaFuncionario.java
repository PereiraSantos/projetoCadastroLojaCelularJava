
package view;

import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.Funcionario;
import model.FuncionarioDAO;
import table.FuncionarioTableModel;


public class TelaTabelaFuncionario extends JFrame{
     private JPanel contentPane;
    private JTable table;
    private FuncionarioTableModel funcionarioTableModel;
    private List<Funcionario> Funcionarios = null;
    
        public TelaTabelaFuncionario() throws Exception {

        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela");
        this.setVisible(true);
        this.setSize(1000, 600);
        table = new JTable();
        table.setBounds(22, 50, 900, 500);
        tela.add(table);

        FuncionarioDAO funcionario = new FuncionarioDAO();
        Funcionarios = funcionario.consulta();

        funcionarioTableModel = new FuncionarioTableModel(Funcionarios);
        table.setModel(funcionarioTableModel);
    }
}

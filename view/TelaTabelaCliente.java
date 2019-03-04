
package view;

import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.Cliente;
import model.ClienteDAO;
import table.ClienteTableModel;

public class TelaTabelaCliente extends JFrame{
    private JPanel contentPane;
    private JTable table;
    private ClienteTableModel clienteTableModel;
    private List<Cliente> Clientes = null;
    
        public TelaTabelaCliente() throws Exception {

        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela");
        this.setVisible(true);
        this.setSize(1000, 600);
        table = new JTable();
        table.setBounds(22, 50, 900, 500);
        tela.add(table);

        ClienteDAO cliente = new ClienteDAO();
        Clientes = cliente.consulta();

        clienteTableModel = new ClienteTableModel(Clientes);
        table.setModel(clienteTableModel);
    }
}

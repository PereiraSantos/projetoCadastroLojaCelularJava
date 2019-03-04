
package view;

import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.VendaT;
import model.VendaDAO;
import table.VendaTableModel;

public class TelaTabelaVenda extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private VendaTableModel vendaTableModel;
    private List<VendaT> Vendas = null;
    
        public TelaTabelaVenda() throws Exception {

        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela");
        this.setVisible(true);
        this.setSize(1000, 600);
        table = new JTable();
        table.setBounds(22, 50, 900, 500);
        tela.add(table);

        VendaDAO vendadao = new VendaDAO();
        Vendas = vendadao.consulta();

        vendaTableModel = new VendaTableModel(Vendas);
        table.setModel(vendaTableModel);
    }
}

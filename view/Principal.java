package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cliente;
import model.ClienteDAO;
import model.Produto;
import model.ProdutoDAO;
import model.Venda;
import model.VendaDAO;
import table.BuscaCTableModel;
import table.BuscaPTableModel;

public class Principal extends JFrame {

    public JMenuBar menuBar;
    public JMenu menuCadastro, menuTabela, menuVenda;
    public JMenuItem cadastroCliente, cadastroFuncionario, cadastroProduto, tabelaCliente, tabelaFuncionario, tabelaProduto, tabelaVenda;
    public JLabel lblVenda, lblCpf, lblCodProduto, lblQuantidade, lblTipoVenda, lblQMes, lblData, lblBuscaCliente, lblBuscaProduto;
    public JTextField txtCpf, txtCodProduto, txtQuantidade, txtTipoVenda, txtQMes, txtData, txtBuscaCliente, txtBuscaProduto;
    public JButton btnPesquisarC, btnPesquisarP, btnSalvar, btnLimpar;
    private JTable tableC, tableP;
    private BuscaCTableModel buscaCTableModel;
    private List<Cliente> Clientes = null;
     private BuscaPTableModel buscaPTableModel;
    private List<Produto> Produtos = null;

    public Principal() {
        // cria tela
        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela");
        this.setVisible(true);
        // this.setResizable(false);
        this.setLocation(20, 20);
        this.setSize(1200, 650);

        // Cria uma barra de menu para o JFrame
        menuBar = new JMenuBar();
        tela.add(menuBar);
        // Adiciona a barra de menu ao  frame
        this.setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        menuCadastro = new JMenu("  Cadastro  ");
        menuBar.add(menuCadastro);
        
        menuTabela = new JMenu("  Tabela  ");
        menuBar.add(menuTabela);
        
        menuVenda = new JMenu("  Venda  ");
        menuBar.add(menuVenda);
        
        // Cria e adiciona um item simples para o menu
        cadastroCliente = new JMenuItem("  Cadastro Cliente");
        cadastroFuncionario = new JMenuItem("  Cadastro Funcionario");
        cadastroProduto = new JMenuItem("  Cadastro Produto");
        
        // adiciona o JMenuItem no JMenu
        menuCadastro.add(cadastroCliente);
        menuCadastro.add(cadastroFuncionario);
        menuCadastro.add(cadastroProduto);

        // Cria e adiciona um item simples para o menu
        tabelaCliente = new JMenuItem("  Tabela Cliente");
        tabelaFuncionario = new JMenuItem("  Tabela Funcionario");
        tabelaProduto = new JMenuItem("  Tabela Produto");
        // adiciona o JMenuItem no JMenu
        menuTabela.add(tabelaCliente);
        menuTabela.add(tabelaFuncionario);
        menuTabela.add(tabelaProduto);
        
        
        tabelaVenda = new JMenuItem("  Tabela Venda");
        
        menuVenda.add(tabelaVenda);
        
        // label // rotulos
        
        lblVenda = new JLabel(" Tela Venda");
        tela.add(lblVenda);
        lblVenda.setBounds(10, 10, 200, 30);
       
        lblCpf = new JLabel(" Cpf:");
        tela.add(lblCpf);
        lblCpf.setBounds(10, 60, 200, 30);
        
        lblCodProduto = new JLabel(" Codigo Produto:");
        tela.add(lblCodProduto);
        lblCodProduto.setBounds(10, 110, 200, 30);
        
        lblQuantidade = new JLabel(" Quantidade:");
        tela.add(lblQuantidade);
        lblQuantidade.setBounds(10, 160, 200, 30);
        
        lblTipoVenda = new JLabel(" Tipo Pagamento:");
        tela.add(lblTipoVenda);
        lblTipoVenda.setBounds(600, 60, 200, 30);
        
        lblQMes = new JLabel(" Quantidade Mês:");
        tela.add(lblQMes);
        lblQMes.setBounds(600, 110, 200, 30);
        
        lblData = new JLabel(" Data Venda:");
        tela.add(lblData);
        lblData.setBounds(600, 160, 200, 30);
        
        lblBuscaCliente = new JLabel(" Nome do Cliente: ");
        tela.add(lblBuscaCliente);
        lblBuscaCliente.setBounds(10, 300, 200, 30);
        
        lblBuscaProduto = new JLabel(" Nome do Produto:");
        tela.add(lblBuscaProduto);
        lblBuscaProduto.setBounds(600, 300 ,200,30);
        
        // entrada de dados
        
        txtCpf = new JTextField();
        tela.add(txtCpf);
        txtCpf.setBounds(200, 60 ,300, 30);
        
        txtCodProduto = new JTextField();
        tela.add(txtCodProduto);
        txtCodProduto.setBounds(200, 110 ,300, 30);
        
        txtQuantidade = new JTextField();
        tela.add(txtQuantidade);
        txtQuantidade.setBounds(200, 160 ,300, 30);
        
        txtTipoVenda = new JTextField();
        tela.add(txtTipoVenda);
        txtTipoVenda.setBounds(800, 60 ,300, 30);
        
        txtQMes = new JTextField();
        tela.add(txtQMes);
        txtQMes.setBounds(800, 110 ,300, 30);
        
        txtData = new JTextField();
        tela.add(txtData);
        txtData.setBounds(800, 160 ,300, 30);
        
        txtBuscaCliente = new JTextField();
        tela.add(txtBuscaCliente);
        txtBuscaCliente.setBounds(200, 300 ,150, 30);
        
        txtBuscaProduto = new JTextField();
        tela.add(txtBuscaProduto);
        txtBuscaProduto.setBounds(800, 300 ,150, 30);
        
        // botão
        
        btnPesquisarC = new JButton("Pesquisar");
        tela.add(btnPesquisarC);
        btnPesquisarC.setBounds(360, 300, 140, 30);
        
        btnPesquisarP = new JButton("Pesquisar");
        tela.add(btnPesquisarP);
        btnPesquisarP.setBounds(960, 300, 140, 30);
        
        btnSalvar = new JButton("Salvar");
        tela.add(btnSalvar);
        btnSalvar.setBounds(960, 200, 140, 30);
        
        btnLimpar = new JButton("Limpar");
        tela.add(btnLimpar);
        btnLimpar.setBounds(800, 200, 140, 30);
        
        //tabela
        
        tableC = new JTable();
        tableC.setBounds(10, 350, 490, 200);
        tela.add(tableC);
        

        
        tableP = new JTable();
        tableP.setBounds(600, 350, 500, 200);
        tela.add(tableP);
        
        
        
        // evento no MenuItem
        cadastroCliente.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    TelaCadastroCliente cliente = new TelaCadastroCliente();
                }
            }
        );
        cadastroFuncionario.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    TelaCadastroFuncionario funcionario = new TelaCadastroFuncionario();
                }
            }
        );
        cadastroProduto.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    TelaCadastroProduto Produto = new TelaCadastroProduto();
                }
            }
        );
        tabelaCliente.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try { 
                        TelaTabelaCliente tabelac = new TelaTabelaCliente();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        );
        tabelaFuncionario.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try { 
                        TelaTabelaFuncionario tabelaf = new TelaTabelaFuncionario();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        );
        tabelaProduto.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try { 
                        TelaTabelaProduto produto = new TelaTabelaProduto();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );
        btnSalvar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    verificar();
                }
            }
        );
        btnLimpar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    limpar();
                }
            }
        );
        tabelaVenda.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try {
                        TelaTabelaVenda tabelav = new TelaTabelaVenda();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );
        btnPesquisarC.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try {
                        pesquisaC();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );
        btnPesquisarP.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {             
                    try {
                        pesquisaP();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );

    }
    // envia dados para venda
    public void cadastrar(){
        Venda venda = new Venda();
        venda.setCpf(Integer.parseInt(txtCpf.getText()));
        venda.setCodigoProduto(Integer.parseInt(txtCodProduto.getText()));
        venda.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        venda.setTipoVenda(txtTipoVenda.getText());
        venda.setQMes(Integer.parseInt(txtQMes.getText()));
        venda.setData(txtData.getText());
        venda.vendaVista(txtTipoVenda.getText());
        VendaDAO vendadao = new VendaDAO();
        try {
            vendadao.Salvar(venda);  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    // chama tabela cliente
    public void pesquisaC() throws Exception{
        ClienteDAO cliente = new ClienteDAO();
        Clientes = cliente.consultac(txtBuscaCliente.getText());
        
        buscaCTableModel = new BuscaCTableModel(Clientes);
        tableC.setModel(buscaCTableModel);
    }
    // chama tabela produto
    public void pesquisaP() throws Exception{
        ProdutoDAO produtodao = new ProdutoDAO();
        Produtos = produtodao.consultap(txtBuscaProduto.getText());
        
        buscaPTableModel = new BuscaPTableModel(Produtos);
        tableP.setModel(buscaPTableModel);
    }
    // limpa entrada de dados
    public void limpar(){
        txtCpf.setText("");
        txtCodProduto.setText("");
        txtQuantidade.setText("");
        txtTipoVenda.setText("");
        txtQMes.setText("");      
        txtData.setText("");
    }
    // verifica campos 
    public void verificar(){
        if(txtCpf.getText().equals("") || txtCodProduto.getText().equals("") || txtQuantidade.getText().equals("") || txtTipoVenda.getText().equals("") 
            || txtQMes.getText().equals("") || txtData.getText().equals("")  || txtTipoVenda.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos");
        }else{
            cadastrar();
            limpar();
        }
    }
    public static void main(String[] args) {
        // estancia tela
        Principal tela = new Principal();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

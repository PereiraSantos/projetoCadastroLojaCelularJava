
package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;
import model.ClienteDAO;

public class TelaCadastroCliente extends JFrame{
    public JLabel lblCpf, lblNome, lblSobrenome, lblTelefone, lblEndereco, lblDtNascimento;
    public JTextField txtCpf, txtNome, txtSobrenome, txtTelefone, txtEndereco, txtDtNascimento;
    public JButton btnSalvar, btnLimpar;
    public TelaCadastroCliente(){
        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela Cadastro Cliente");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(50, 100);
        this.setSize(500, 500);
        
        // label
        lblCpf = new JLabel("Cpf:");
        tela.add(lblCpf);
        lblCpf.setBounds(10,10,200,40);
        
        lblNome = new JLabel("Nome:");
        tela.add(lblNome);
        lblNome.setBounds(10,60,200,40);
        
        lblSobrenome = new JLabel("Sobrenome:");
        tela.add(lblSobrenome);
        lblSobrenome.setBounds(10, 110,200,40);
        
        lblTelefone = new JLabel("Telefone:");
        tela.add(lblTelefone);
        lblTelefone.setBounds(10,160,200,40);
        
        lblEndereco = new JLabel("Endereço:");
        tela.add(lblEndereco);
        lblEndereco.setBounds(10,210,200,40);       
        
        lblDtNascimento = new JLabel("Dt Nascimento:");
        tela.add(lblDtNascimento);
        lblDtNascimento.setBounds(10,260,200,40);

        // campo testo
        
        txtCpf = new JTextField();
        tela.add(txtCpf);
        txtCpf.setBounds(150,10,300,30);
        
        txtNome = new JTextField();
        tela.add(txtNome);
        txtNome.setBounds(150,60,300,30);
        
        txtSobrenome = new JTextField();
        tela.add(txtSobrenome);
        txtSobrenome.setBounds(150,110,300,30);
        
        txtTelefone = new JTextField();
        tela.add(txtTelefone);
        txtTelefone .setBounds(150,160,300,30);
        
        txtEndereco = new JTextField();
        tela.add(txtEndereco);
        txtEndereco.setBounds(150,210,300,30);
        
        txtDtNascimento = new JTextField();
        tela.add(txtDtNascimento);
        txtDtNascimento.setBounds(150,260,300,30); 
        
        // butao
        
        btnSalvar = new JButton("salvar");
        tela.add(btnSalvar);
        btnSalvar.setBounds(150,310,200,40);
        
        btnLimpar = new JButton("Limpar");
        tela.add(btnLimpar);
        btnLimpar.setBounds(150,360,200,40);
        
        btnSalvar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 verificar(); 
                }
            } 
        ); 
        btnLimpar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 limpar(); 
                }
            } 
        );
    }
    // envia dados cliente
    public void cadastrar(){
        Cliente cliente = new Cliente();
        cliente.setCpf(Integer.parseInt(txtCpf.getText()));
        cliente.setNome(txtNome.getText());
        cliente.setSobrenome(txtSobrenome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setDtNascimento(Integer.parseInt(txtDtNascimento.getText()));
       
        ClienteDAO clientedao = new ClienteDAO();
        try {
            clientedao.Salvar(cliente);  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    // limpa campos
    public void limpar(){
        txtCpf.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");      
        txtDtNascimento.setText("");

    }
    // verifica campos 
    public void verificar(){
        if(txtCpf.getText().equals("") || txtNome.getText().equals("") || txtSobrenome.getText().equals("") || txtTelefone.getText().equals("") 
            || txtEndereco.getText().equals("") || txtDtNascimento.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos");
        }else{
            cadastrar();
            limpar();
        }
    }
}


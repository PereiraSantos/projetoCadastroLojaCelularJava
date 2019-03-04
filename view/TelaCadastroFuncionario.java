
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
import model.Funcionario;
import model.FuncionarioDAO;

public class TelaCadastroFuncionario extends JFrame{
    public JLabel lblNome, lblSobrenome, lblTelefone, lblEndereco, lblDtNascimento, lblSalario;
    public JTextField txtNome, txtSobrenome, txtTelefone, txtEndereco, txtDtNascimento,txtSalario;
    public JButton btnSalvar, btnLimpar;

    public TelaCadastroFuncionario() {
        Container tela = getContentPane();
        this.setTitle("Tela Cadastro Funcionario");
        this.setLayout(null);
        this.setSize(400, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(500, 500);
        
        // label
        
        lblNome = new JLabel("Nome:");
        tela.add(lblNome);
        lblNome.setBounds(10,10,200,40);
        
        lblSobrenome = new JLabel("Sobrenome:");
        tela.add(lblSobrenome);
        lblSobrenome.setBounds(10, 60,200,40);
        
        lblTelefone = new JLabel("Telefone:");
        tela.add(lblTelefone);
        lblTelefone.setBounds(10,110,200,40);
        
        lblEndereco = new JLabel("Endereço:");
        tela.add(lblEndereco);
        lblEndereco.setBounds(10,160,200,40);       
        
        lblDtNascimento = new JLabel("Dt Nascimento:");
        tela.add(lblDtNascimento);
        lblDtNascimento.setBounds(10,210,200,40);
        
        lblSalario = new JLabel("Salario:");
        tela.add(lblSalario);
        lblSalario.setBounds(10,260,200,40);

        // campo testo
        
        txtNome = new JTextField();
        tela.add(txtNome);
        txtNome.setBounds(150,10,300,30);
        
        txtSobrenome = new JTextField();
        tela.add(txtSobrenome);
        txtSobrenome.setBounds(150,60,300,30);
        
        txtTelefone = new JTextField();
        tela.add(txtTelefone);
        txtTelefone .setBounds(150,110,300,30);
        
        txtEndereco = new JTextField();
        tela.add(txtEndereco);
        txtEndereco.setBounds(150,160,300,30);
        
        txtDtNascimento = new JTextField();
        tela.add(txtDtNascimento);
        txtDtNascimento.setBounds(150,210,300,30);

        txtSalario = new JTextField();
        tela.add(txtSalario);
        txtSalario.setBounds(150, 260, 300, 30);

        // butão
        btnSalvar = new JButton("salvar");
        tela.add(btnSalvar);
        btnSalvar.setBounds(150, 310, 200, 40);

        btnLimpar = new JButton("Limpar");
        tela.add(btnLimpar);
        btnLimpar.setBounds(150, 360, 200, 40);

        btnSalvar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
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

    public void cadastrar(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(txtNome.getText());
        funcionario.setSobrenome(txtSobrenome.getText());
        funcionario.setTelefone(txtTelefone.getText());
        funcionario.setEndereco(txtEndereco.getText());
        funcionario.setDtNascimento(Integer.parseInt(txtDtNascimento.getText()));
        funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
        
        FuncionarioDAO funcionariodao = new FuncionarioDAO(); 
        try {
            funcionariodao.Salvar(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpar() {
        txtNome.setText("");
        txtSobrenome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtDtNascimento.setText("");
        txtSalario.setText("");
    }
    // verifica campos 
    public void verificar(){
        if(txtNome.getText().equals("") || txtNome.getText().equals("") || txtSobrenome.getText().equals("") || txtTelefone.getText().equals("") 
            || txtEndereco.getText().equals("") || txtDtNascimento.getText().equals("") || txtSalario.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Todos os campos deve ser preenchido");
        }else{
            cadastrar();
            limpar();
        }
    }
}

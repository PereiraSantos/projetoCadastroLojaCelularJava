
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
import model.Produto;
import model.ProdutoDAO;

public class TelaCadastroProduto extends JFrame{
    public JLabel lblMarca ,lblModelo, lblDescricao,lblValor;
    public JTextField txtMarca, txtModelo, txtDescricao, txtValor;
    public JButton btnSalvar, btnLimpar;
    
    public TelaCadastroProduto(){
        Container tela = getContentPane();
        this.setLayout(null);
        this.setTitle("Tela Cadastro Produto");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(50, 100);
        this.setSize(500, 400);
        
        // label
        
        lblMarca = new JLabel("Marca:");
        tela.add(lblMarca);
        lblMarca.setBounds(10,10,200,40);
        
        lblModelo = new JLabel("Modelo:");
        tela.add(lblModelo);
        lblModelo.setBounds(10,60,200,40);
        
        lblDescricao = new JLabel("Descricão:");
        tela.add(lblDescricao);
        lblDescricao.setBounds(10,110,200,40);
        
        lblValor = new JLabel("Valor:");
        tela.add(lblValor);
        lblValor.setBounds(10,160,200,40);
        
        // campo testo
        
        txtMarca = new JTextField();
        tela.add(txtMarca);
        txtMarca.setBounds(150,10,300,30);
        
        txtModelo = new JTextField();
        tela.add(txtModelo);
        txtModelo.setBounds(150,60,300,30);
        
        txtDescricao = new JTextField();
        tela.add(txtDescricao);
        txtDescricao.setBounds(150,110,300,30);
        
        txtValor = new JTextField();
        tela.add(txtValor );
        txtValor.setBounds(150,160,300,30);
        
        // butão
        
        btnSalvar = new JButton("salvar");
        tela.add(btnSalvar);
        btnSalvar.setBounds(150,210,200,40);
        
        btnLimpar = new JButton("Limpar");
        tela.add(btnLimpar);
        btnLimpar.setBounds(150,260,200,40);
        
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

    public void cadastrar(){
       Produto produto = new Produto();
       produto.setMarca(txtMarca.getText());
       produto.setModelo(txtModelo.getText());
       produto.setDescricao(txtDescricao.getText());
       produto.setValor(Float.parseFloat(txtValor.getText()));
       
       ProdutoDAO prod = new ProdutoDAO();
        try {
            prod.Salvar(produto);  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void limpar(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        
    }
    // verifica campos 
    public void verificar(){
        if(txtMarca.getText().equals("") || txtModelo.getText().equals("") || txtDescricao.getText().equals("") || txtValor.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos");
        }else{
            cadastrar();
            limpar();
        }
    }
}
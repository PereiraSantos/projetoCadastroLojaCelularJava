
package model;

import interfaces.Transacao;

public class Venda implements Transacao{
    private int codigoVenda;
    private int cpf;
    private int codigoProduto;
    private int quantidade;
    private String tipoVenda;
    private int QMes;
    private String data;
    private Float valorVenda;
    
public Venda(){
   this.valorVenda = 0f;
}

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }
     
    public int getQMes() {
        return QMes;
    }

    public void setQMes(int QMes) {
        this.QMes = QMes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public void vendaVista(String v) {
        if (v.equals("prazo")){
            if (this.getQMes() <= 6 ){
                if (this.getQMes() >= 4){
                    this.setValorVenda(this.getValorVenda() + 400);  
                }else{
                    this.setValorVenda(this.getValorVenda() + 200);
                }        
            }else{
                if (this.getQMes() >= 10){
                    this.setValorVenda(this.getValorVenda() + 800); 
                }else{
                    this.setValorVenda(this.getValorVenda()+ 600);
                }
            }
        }else{
            this.setValorVenda(this.getValorVenda()- 100);
        }
    }
}

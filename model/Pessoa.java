
package model;

public abstract class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected String telefone;
    protected String endereco;
    protected int dtNascimento;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(int dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}

package br.com.fedablio.model;

public class Conexao {

    private long _id;
    private String endereco;
    private String porta;
    private String palavra;

    public Conexao(){}

    public Conexao(long id, String endereco, String porta, String palavra){
        this._id = id;
        this.endereco = endereco;
        this.porta = porta;
        this.palavra = palavra;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}

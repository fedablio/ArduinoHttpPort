package br.com.fedablio.model;

public class Porta {

    private long _id;
    private String nome;

    public Porta(){

    }

    public Porta(long id, String nome){
        this._id = id;
        this.nome = nome;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

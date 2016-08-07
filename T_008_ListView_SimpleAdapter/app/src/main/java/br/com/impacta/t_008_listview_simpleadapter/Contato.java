package br.com.impacta.t_008_listview_simpleadapter;

/**
 * Created by nalmir on 03/08/2016.
 */
public class Contato {

    private long idcontato;
    private String nome;
    private String telefone;
    private int idade;

    public long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(long idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

package br.com.impacta.t_008_listview_baseadapter;

/**
 * Created by nalmir on 04/08/2016.
 */
public class Produto {

    private long idproduto;
    private String nome;
    private double valor;

    public Produto() {
        this.idproduto = -1;
        this.nome = "sem nome";
        this.valor = 0;
    }

    public Produto(long idproduto, String nome, double valor) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.valor = valor;
    }

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

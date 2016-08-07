package br.com.impacta.extra_checkbox_radiobutton_programmatically;

/**
 * Created by nalmir on 01/08/2016.
 */
public class Produto {

    private long idproduto;
    private String descricao;
    private double valor;
    private boolean ativo;

    public Produto() {
        this.idproduto = -1;
        this.descricao = "sem descricao";
        this.valor = 0.0;
        this.ativo = false;
    }

    public Produto(long idproduto, String descricao, double valor, boolean ativo) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.valor = valor;
        this.ativo = ativo;
    }

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

package br.com.impacta.t_telas;

/**
 * Created by nalmir on 27/07/2016.
 */
public class Produto {

    private long idproduto;
    private String descricao;
    private float valor;


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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}

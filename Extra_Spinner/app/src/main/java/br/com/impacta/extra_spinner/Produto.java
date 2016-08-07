package br.com.impacta.extra_spinner;

import java.util.HashMap;

/**
 * Created by nalmir on 01/08/2016.
 */
public class Produto {

    private long idproduto;
    private String descricao;
    private double valor;

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

    @Override
    public String toString() {
        return descricao;
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String> item = new HashMap<>();
        item.put("id", String.valueOf(idproduto));
        item.put("valor", descricao);
        //
        return item;
    }

    public HMAuxHugo toHashMap_2() {
        HMAuxHugo item = new HMAuxHugo();
        item.put(HMAuxHugo.ID, String.valueOf(idproduto));
        item.put(HMAuxHugo.TEXTO_01, descricao);
        //
        return item;
    }
}

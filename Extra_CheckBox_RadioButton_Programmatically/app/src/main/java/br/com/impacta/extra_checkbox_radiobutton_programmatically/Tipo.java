package br.com.impacta.extra_checkbox_radiobutton_programmatically;

/**
 * Created by nalmir on 01/08/2016.
 */
public class Tipo {

    private long idtipo;
    private String descricao;

    public Tipo() {
        this.idtipo = -1;
        this.descricao = "sem descricao";
    }

    public Tipo(long idtipo, String descricao) {
        this.idtipo = idtipo;
        this.descricao = descricao;
    }

    public long getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(long idtipo) {
        this.idtipo = idtipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

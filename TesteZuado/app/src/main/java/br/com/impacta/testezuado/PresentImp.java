package br.com.impacta.testezuado;

/**
 * Created by nalmir on 04/08/2016.
 */
public class PresentImp implements iPresenter {

    private iView acessoTela;

    public PresentImp(iView acessoTela) {
        this.acessoTela = acessoTela;
    }

    @Override
    public void processarNome(String nome) {
        String resultado = "Seja Bem Vindo " + nome;
        //
        acessoTela.onMostrarResultado(resultado);
    }
}

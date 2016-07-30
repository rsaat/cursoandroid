package br.com.impacta.t_002_edittext;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private EditText et_nome;
    private EditText et_senha;
    //
    private Button btn_validar;

    private String erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVaraivel();
        inicializarAcao();
    }

    private void inicializarVaraivel() {
        et_nome = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);
        //
        btn_validar = (Button) findViewById(R.id.btn_validar);
    }

    private void inicializarAcao() {
        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacao()){
                    mostrarMensagem("Ok");
                } else {

                    mostrarMensagem(erro);
                }
            }
        });
    }

    private boolean validacao() {
        erro = "";

        String nome = et_nome.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();
        //
        if (nome.length() == 0){
            erro = "Nome é Obrigatório!!!";
            //
            return false;
        }
        //
        if (senha.length() == 0){
            erro = "Senha é Obrigatória!!!";
            //
            return false;
        }
        //
        if ( !nome.equalsIgnoreCase("Hugo") || !senha.equals("T12")){
            erro = "Credenciais Inválidas!!!";
            //
            return false;
        }

        return true;
    }

    private void mostrarMensagem(String erro) {
        Toast.makeText(
                getBaseContext(),
                erro,
                Toast.LENGTH_SHORT
        ).show();
    }
}

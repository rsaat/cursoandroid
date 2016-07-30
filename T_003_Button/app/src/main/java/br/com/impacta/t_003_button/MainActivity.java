package br.com.impacta.t_003_button;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements IAbacaxi {

    private Context context;

    private Button btn_salvar;
    private Button btn_apagar;
    private Button btn_cancelar;

    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();
        //
        // NullPointerException
        btn_salvar = (Button) findViewById(R.id.btn_salvar);
        btn_apagar = (Button) findViewById(R.id.btn_apagar);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
    }

    private void inicializarAcao() {
//        btn_salvar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(
//                        context,
//                        "Salvei com Sucesso!!!",
//                        Toast.LENGTH_SHORT
//                ).show();
//            }
//        });
//        //
//        btn_apagar.setOnClickListener(hugoListener);
        //
        btn_salvar.setOnClickListener(menuListener);
        btn_apagar.setOnClickListener(menuListener);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = !status;
                //
                if (status){
                    btn_apagar.setOnClickListener(null);
                } else {
                    btn_apagar.setOnClickListener(menuListener);
                }
            }
        });
    }


    @Override
    public void chamarRecepcionista(String nome) {

    }

    private View.OnClickListener menuListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String resultado = "";

            switch (v.getId()){
                case R.id.btn_salvar:
                    resultado = "Botao Salvar";
                    break;
                case R.id.btn_apagar:
                    resultado = "Botao Apagar";
                    break;
                default:
                    resultado = "Nao Implementado!!!";
                    break;
            }

            Toast.makeText(
                    context,
                    resultado,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };


    private View.OnClickListener hugoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(
                    context,
                    "Apaguei com Sucesso!!!",
                    Toast.LENGTH_SHORT
            ).show();
        }
    };

}


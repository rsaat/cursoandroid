package br.com.impacta.testezuado;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements iView {

    private EditText et_nome;
    private Button btn_mostra_nome;

    private iPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel();
        inicializarAcao();
        //
        presenter = new PresentImp(this);
    }

    private void inicializarVariavel() {
        et_nome = (EditText) findViewById(R.id.et_nome);
        btn_mostra_nome = (Button) findViewById(R.id.btn_mostrar_nome);
    }

    private void inicializarAcao() {
        btn_mostra_nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.processarNome(et_nome.getText().toString());
            }
        });
    }


    @Override
    public void onMostrarResultado(String texto) {
        Toast.makeText(
                getBaseContext(),
                texto,
                Toast.LENGTH_SHORT
        ).show();
    }
}

package br.com.impacta.t_006_spinner;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private Context context;
    //
    //private ArrayList<String> nomes; // fonte de dados
    private ArrayAdapter<String> adapter_nomes;

    private Spinner sp_nomes;


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
        sp_nomes = (Spinner) findViewById(R.id.sp_nome);
        //
        adapter_nomes = new ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_item,
                geradorDados(10000)
        );
        //
        adapter_nomes.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        //
        sp_nomes.setAdapter(adapter_nomes);
    }

    private ArrayList<String> geradorDados(int quantidade) {
        ArrayList<String> nomes = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade ; i++) {
            nomes.add("Nome - " + String.valueOf(i));
        }
        //
        return nomes;
    }

    private void inicializarAcao() {

        sp_nomes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}

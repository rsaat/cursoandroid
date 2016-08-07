package br.com.impacta.t_008_listview_arrayadapter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Context context;
    //
    private ListView lv_nomes;

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
        lv_nomes = (ListView) findViewById(R.id.lv_nomes);
        //
        lv_nomes.setAdapter(
                new ArrayAdapter<String>(
                        context,
                        R.layout.row,
                        new String [] {
                                "Hugo",
                                "Pedro",
                                "Luiz",
                                "Joao",
                                "Maria"
                        }
                )
        );
    }

    private void inicializarAcao() {

        lv_nomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) parent.getItemAtPosition(position);
                //
                Toast.makeText(
                        context,
                        nome,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }

}

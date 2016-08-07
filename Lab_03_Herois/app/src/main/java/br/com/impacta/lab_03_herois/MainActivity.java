package br.com.impacta.lab_03_herois;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private ListView lv_herois;



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
        lv_herois = (ListView) findViewById(R.id.lv_herois);
        //
        String[] De = { Constantes.FOTO, Constantes.NOME};
        int[] Para = { R.id.celula_iv_foto, R.id.celula_tv_nome };
        lv_herois.setAdapter(
                new SimpleAdapter(
                        context,
                        gerarHerois(),
                        R.layout.celula_heroi,
                        De,
                        Para
                )
        );
    }

    private List<HashMap<String, String>> gerarHerois() {
        List<HashMap<String, String>> herois = new ArrayList<>();
        //
        int [] fotos = {
                R.drawable.avenger01,
                R.drawable.avenger02,
                R.drawable.avenger03,
                R.drawable.avenger04,
                R.drawable.avenger05,
                R.drawable.avenger06,
                R.drawable.avenger07,
                R.drawable.avenger08,
                R.drawable.avenger09,
                R.drawable.avenger10,
                R.drawable.avenger11
        };
        //
        String [] nomes = {
                "Gaviao Arqueiro",
                "War Machine",
                "Thor",
                "Nick Fury",
                "Locky",
                "Iron Man",
                "Hulk",
                "Ant Man",
                "Capitao America",
                "Viuva Negra",
                "Filipe"
        };
        //
        String [] poderes = {
                "Sem poder",
                "Muito Bom",
                "Martelo",
                "Chefe",
                "Trolador",
                "Humildao",
                "Muita Paciencia",
                "Ego Grande",
                "Bom Rapaz",
                "Sensualidade",
                "Estagiario"
        };
        //
        for (int i = 0; i < fotos.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            //
            item.put(Constantes.FOTO, String.valueOf(fotos[i]));
            item.put(Constantes.NOME, nomes[i]);
            item.put(Constantes.PODER, poderes[i]);
            //
            herois.add(item);
        }
        //
        return herois;
    }

    private void inicializarAcao() {
        lv_herois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> iAux =
                        (HashMap<String, String>) parent.getItemAtPosition(position);
                //
                Toast.makeText(
                        context,
                        iAux.get(Constantes.PODER),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

}

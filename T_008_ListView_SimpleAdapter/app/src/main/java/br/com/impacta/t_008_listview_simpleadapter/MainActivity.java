package br.com.impacta.t_008_listview_simpleadapter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private Context context;
    //
    private ListView lv_contatos;
    //
    private SimpleAdapter adapter_contatos;

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
        lv_contatos = (ListView) findViewById(R.id.lv_contatos);
        //
        String[] De = {"nome", "telefone", "id"};
        int[] Para = {R.id.celula_txt_nome, R.id.celula_txt_telefone};
        adapter_contatos = new SimpleAdapter(
                context,
                gerarContatos(10),
                R.layout.celula,
                De,
                Para
        );
        //
        lv_contatos.setAdapter(adapter_contatos);
    }

    private List<HashMap<String, String>> gerarContatos(int quantidade) {
        List<HashMap<String, String>> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("id", String.valueOf(i));
            item.put("nome", "Nome - " + String.valueOf(i));
            item.put("telefone", "Telefone - " + String.valueOf(i));
            //
            contatos.add(item);
        }
        //
        return contatos;
    }

    private void inicializarAcao() {

    }


}

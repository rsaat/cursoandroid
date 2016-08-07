package br.com.impacta.extra_spinner;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Context context;
    private Spinner sp_produtos;
    private List<Produto> produtos;
    private ArrayAdapter<Produto> adapter_produtos;

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
        sp_produtos = (Spinner) findViewById(R.id.sp_produtos);
        //
        produtos = gerarProdutos(10);
        //
        adapter_produtos = new ArrayAdapter<Produto>(
                context,
                android.R.layout.simple_spinner_item,
                produtos
        );
        //
        adapter_produtos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        //
        sp_produtos.setAdapter(adapter_produtos);
        //
        sp_produtos.setSelection(setarID(sp_produtos, 100));
    }

    private int setarID(Spinner sp_Aux, int id) {
        int indice = 0;
        //
        for (int i = 0; i < sp_Aux.getCount(); i++) {
            Produto pAux = (Produto) sp_Aux.getItemAtPosition(i);
            //
            if (pAux.getIdproduto() == id){
                indice = i;
                //
                break;
            }
        }
        //
        return indice;
    }

    private void inicializarAcao() {
        sp_produtos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Produto pAux = (Produto) parent.getItemAtPosition(position);
                    //
                    Toast.makeText(
                            context,
                            String.valueOf(pAux.getIdproduto()) + " - " + String.valueOf(position) + " - " + String.valueOf(id),
                            Toast.LENGTH_SHORT
                    ).show();
                }

                /*
                if (position != 0) {
                    Object p =  parent.getItemAtPosition(position);
                    HMAuxHugo pAux = (HMAuxHugo) parent.getItemAtPosition(position);
                    //
                    Toast.makeText(
                            context,
                            pAux.get(HMAuxHugo.ID) + " - " + String.valueOf(position) + " - " + String.valueOf(id),
                            Toast.LENGTH_SHORT
                    ).show();
                }
                */

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<Produto> gerarProdutos(int quantidade) {
        List<Produto> pds = new ArrayList<>();
        //
        Produto coringa = new Produto();
        coringa.setIdproduto(-1);
        coringa.setDescricao("< Selecione o Produto >");
        coringa.setValor(0.0);
        //
        pds.add(coringa);
        //
        for (int i = 0; i < quantidade; i++) {
            Produto pAux = new Produto();
            //
            pAux.setIdproduto(i + 10);
            pAux.setDescricao("Produto - " + String.valueOf(i + 10));
            pAux.setValor(0.5 * (i + 10));
            //
            pds.add(pAux);
        }
        //
        return pds;
    }

    private List<HashMap<String, String>> gerarProdutos_HM(int quantidade) {
        List<HashMap<String, String>> pds = new ArrayList<>();
        //
        Produto coringa = new Produto();
        coringa.setIdproduto(-1);
        coringa.setDescricao("< Selecione o Produto >");
        coringa.setValor(0.0);
        //
        pds.add(coringa.toHashMap());
        //
        for (int i = 0; i < quantidade; i++) {
            Produto pAux = new Produto();
            //
            pAux.setIdproduto(i + 10);
            pAux.setDescricao("Produto - " + String.valueOf(i + 10));
            pAux.setValor(0.5 * (i + 10));
            //
            pds.add(pAux.toHashMap());
        }
        //
        return pds;
    }

    private List<HMAuxHugo> gerarProdutos_HM_2(int quantidade) {
        List<HMAuxHugo> pds = new ArrayList<>();
        //
        Produto coringa = new Produto();
        coringa.setIdproduto(-1);
        coringa.setDescricao("< Selecione o Produto >");
        coringa.setValor(0.0);
        //
        pds.add(coringa.toHashMap_2());
        //
        for (int i = 0; i < quantidade; i++) {
            Produto pAux = new Produto();
            //
            pAux.setIdproduto(i + 10);
            pAux.setDescricao("Produto - " + String.valueOf(i + 10));
            pAux.setValor(0.5 * (i + 10));
            //
            pds.add(pAux.toHashMap_2());
        }
        //
        return pds;
    }


}

package br.com.impacta.t_008_listview_baseadapter_interface;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private ListView lv_produtos;
    private List<HMAux> produtos;
    private Adapter_Produtos adapter_produtos;

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
        lv_produtos = (ListView) findViewById(R.id.lv_produtos);
        //
        adapter_produtos = new Adapter_Produtos(
                context,
                R.layout.celula,
                gerarProduto(10)
        );
        //
        adapter_produtos.setOnGosteiDoProdutoListener(new Adapter_Produtos.IAProdutos() {
            @Override
            public void gostouDoProduto(String texto, boolean gostei) {

                String resultado = "";

                if (gostei) {
                    resultado = "ID do Produto: " + texto + " Gostei";
                } else {
                    resultado = "ID do Produto: " + texto + " Lixo";
                }

                Toast.makeText(
                        context,
                        resultado,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        //
        lv_produtos.setAdapter(adapter_produtos);
    }

    private List<HMAux> gerarProduto(int quantidade) {
        List<HMAux> mDados = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux item = new HMAux();
            //
            item.put(HMAux.ID, String.valueOf(i));
            item.put(HMAux.TEXTO_01, "Produto - " + String.valueOf(i));
            item.put(HMAux.TEXTO_02, String.valueOf(i * 0.5));
            //
            mDados.add(item);
        }
        //
        return mDados;
    }

    private void inicializarAcao() {
        lv_produtos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);
                //
                Toast.makeText(
                        context,
                        item.get(HMAux.TEXTO_01),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }


}

package br.com.impacta.t_008_listview_baseadapter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Context context;
    private ListView lv_produtos;
    private List<Produto> produtos;
    //
    private Adapter_Produtos adapter_produtos;

    private int sistema = 0;

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
        produtos = gerarProdutos(100);
        //
        int layout_a_ser_utilizado;

        switch (sistema){
            case 0:
                layout_a_ser_utilizado = R.layout.celula_produto_parada;
                break;
            case 1:
                layout_a_ser_utilizado = R.layout.celula_produto;
                break;
            default:
                layout_a_ser_utilizado = R.layout.celula_produto_parada;
                break;
        }
        //
        adapter_produtos = new Adapter_Produtos(
                context,
                layout_a_ser_utilizado,
                produtos
        );
        //
        lv_produtos.setAdapter(adapter_produtos);
    }

    private List<Produto> gerarProdutos(int quantidade) {
        List<Produto> pAuxs = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            Produto pp = new Produto(
                    i,
                    "Nome - " + String.valueOf(i),
                    0.5 * i
            );
            //
            pAuxs.add(pp);
        }
        //
        return pAuxs;
    }

    private void inicializarAcao() {
        lv_produtos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_produtos.setIdprodutoselecionado(id);
            }
        });
    }
}

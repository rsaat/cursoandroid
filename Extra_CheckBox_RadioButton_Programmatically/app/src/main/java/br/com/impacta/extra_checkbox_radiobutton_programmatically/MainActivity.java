package br.com.impacta.extra_checkbox_radiobutton_programmatically;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private LinearLayout ll;
    private RadioGroup rg;

    private Button btn_from_db;
    private Button btn_to_db;

    private List<Produto> produtos;
    private List<CheckBox> checkBoxes;

    private List<Tipo> tipos;
    private List<RadioButton> radioButtons;

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
        ll = (LinearLayout) findViewById(R.id.ll);
        //
        rg = (RadioGroup) findViewById(R.id.rg);
        //
        produtos = gerarProdutos(100);
        tipos = gerarTipos(100);
        //
        checkBoxes = gerarUI_CheckBoxes();
        radioButtons = gerarUI_RadioButtons();
        //
        btn_from_db = (Button) findViewById(R.id.btn_from_db);
        btn_to_db = (Button) findViewById(R.id.btn_to_db);
    }

    private List<Produto> gerarProdutos(int quantidade) {
        List<Produto> pds = new ArrayList<>();
        //
        for (int i = 0; i < quantidade; i++) {
            Produto pAux = new Produto();
            //
            pAux.setIdproduto(i + 10);
            pAux.setDescricao("Produto - " + String.valueOf(i + 10));
            pAux.setValor(0.5 * (i + 10));
            pAux.setAtivo((i % 2) == 0 ? true : false);
            //
            pds.add(pAux);
        }
        //
        return pds;
    }

    private List<Tipo> gerarTipos(int quantidade) {
        List<Tipo> tps = new ArrayList<>();
        //
        for (int i = 0; i < quantidade; i++) {
            Tipo tAux = new Tipo();
            //
            tAux.setIdtipo(i + 10);
            tAux.setDescricao("Tipo - " + String.valueOf(i + 10));
            //
            tps.add(tAux);
        }
        //
        return tps;
    }

    private List<CheckBox> gerarUI_CheckBoxes() {
        List<CheckBox> cks = new ArrayList<>();
        //
        for (int i = 0; i < produtos.size(); i++) {
            CheckBox ckAux = new CheckBox(this);
            ckAux.setId(i);
            ckAux.setText(produtos.get(i).getDescricao());
            //
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            //
            cks.add(ckAux);
            //
            ll.addView(ckAux, params);
        }
        //
        return cks;
    }

    private List<RadioButton> gerarUI_RadioButtons() {
        List<RadioButton> rbs = new ArrayList<>();
        //
        for (int i = 0; i < tipos.size(); i++) {
            RadioButton rbAux = new RadioButton(this);
            rbAux.setId(i);
            rbAux.setText(tipos.get(i).getDescricao());
            //
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            //
            rbs.add(rbAux);
            //
            rg.addView(rbAux, params);
        }
        //
        return rbs;
    }

    private void inicializarAcao() {
        btn_from_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montar_Produtos_Tipos();
            }
        });
        //
        btn_to_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obter_Resultados();
            }
        });

    }

    private void montar_Produtos_Tipos() {
        Produto p1 = produtos.get(5);
        Produto p2 = produtos.get(8);
        Produto p3 = produtos.get(10);
        Produto p4 = produtos.get(30);
        Produto p5 = produtos.get(50);
        //
        List<Produto> pSelecionados = new ArrayList<>();
        pSelecionados.add(p1);
        pSelecionados.add(p2);
        pSelecionados.add(p3);
        pSelecionados.add(p4);
        pSelecionados.add(p5);
        //
        for (Produto pAux : pSelecionados) {
            for (int i = 0; i < produtos.size(); i++) {
                if (pAux.getIdproduto() == produtos.get(i).getIdproduto()){
                    checkBoxes.get(i).setChecked(true);
                }
            }
        }
        //
        int mSelectedIdTipo = 60;
        //
        for (int i = 0; i < tipos.size(); i++) {
            if (tipos.get(i).getIdtipo() == mSelectedIdTipo){
                radioButtons.get(i).setChecked(true);
                //
                break;
            }
        }
    }

    private void obter_Resultados() {
        StringBuilder sb = new StringBuilder();
        //
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isChecked()){
                sb.append(produtos.get(i).getDescricao())
                        .append("\n");
            }
        }
        //
        int position = rg.getCheckedRadioButtonId();
        //
        sb.append(tipos.get(position).getDescricao());
        //
        Toast.makeText(
                context,
                sb.toString(),
                Toast.LENGTH_SHORT
        ).show();
    }
}

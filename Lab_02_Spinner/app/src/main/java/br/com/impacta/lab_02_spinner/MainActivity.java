package br.com.impacta.lab_02_spinner;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private Context context;
    //
    private EditText et_nome;
    private EditText et_idade;
    //
    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;
    //
    private ImageView iv_foto;
    //
    private Spinner sp_estados;
    //
    private Button btn_obter_resultados;

    private String msgErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel();
        inicializarAcao();
    }

    //region Inicializacao
    private void inicializarVariavel() {
        context = getBaseContext();
        //
        et_nome = (EditText) findViewById(R.id.et_nome);
        et_idade= (EditText) findViewById(R.id.et_idade);
        //
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_m = (RadioButton) findViewById(R.id.rb_m);
        rb_f = (RadioButton) findViewById(R.id.rb_f);
        //
        iv_foto = (ImageView) findViewById(R.id.iv_foto);
        //
        sp_estados = (Spinner) findViewById(R.id.sp_estado);
        //
        btn_obter_resultados = (Button) findViewById(R.id.btn_obter_dados);
        //
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_m:
                        iv_foto.setImageResource(R.drawable.man);
                        break;
                    case R.id.rb_f:
                        iv_foto.setImageResource(R.drawable.woman);
                        break;
                    default:
                        iv_foto.setImageResource(R.mipmap.ic_launcher);
                        break;
                }
            }
        });
        //
        sp_estados.setAdapter(
                new ArrayAdapter<String>(
                        context,
                        android.R.layout.simple_spinner_item,
                        gerarEstados()
                )
        );

    }

    private List<String> gerarEstados() {
        List<String> estados = new ArrayList<>();
        //
        estados.add("Sao Paulo");
        estados.add("Rio de Janeiro");
        estados.add("Rio Grande do Sul");
        //
        return estados;
    }
    //endregion

    private void inicializarAcao() {
        btn_obter_resultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()){
                    mostrarDados();
                } else {
                    mostrarErro();
                }
            }
        });
    }

    private boolean validacao() {
        msgErro = "";
        //
        if (et_nome.getText().toString().trim().length() == 0){
            msgErro = "Erro: Nome é Obrigatorio!!!";
            //
            return false;
        }
        //
        if (et_idade.getText().toString().trim().length() == 0){
            msgErro = "Erro: Idade é Obrigatoria!!!";
            //
            return false;
        }
        //
        try{
            int i = Integer.parseInt(et_idade.getText().toString());
        } catch (Exception e){
            msgErro = "Erro: Idade Invalida!!!";
            //
            return false;
        }
        //
        if ( rg.getCheckedRadioButtonId() == -1){
            msgErro = "Erro: Selecao de Sexo é Obrigatoria!!!";
            //
            return false;
        }
        //
        return true;
    }

    private void mostrarDados() {
        StringBuilder sb = new StringBuilder();
        //
        sb.append("Resultados:\n")
                .append("Nome: ")
                .append(et_nome.getText().toString().trim())
                .append("\n")
                .append("Idade: ")
                .append(et_idade.getText().toString().trim())
                .append("\n")
                .append("Sexo: ")
                .append(rg.getCheckedRadioButtonId() == R.id.rb_m ? "Masculino" : "Feminino")
                .append("\n")
                .append("Estado: ")
                .append((String)sp_estados.getSelectedItem());
        //
        Toast.makeText(
                context,
                sb.toString(),
                Toast.LENGTH_SHORT
        ).show();
    }

    private void mostrarErro() {
        Toast.makeText(
                context,
                msgErro,
                Toast.LENGTH_SHORT
        ).show();
    }

}

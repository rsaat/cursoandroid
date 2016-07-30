package br.com.impacta.extra_txt_desconto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    private EditText et_desconto;
    private EditText et_preco;

    private double preco_eup = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        et_desconto = (EditText) findViewById(R.id.et_desconto);
        et_preco = (EditText) findViewById(R.id.et_preco);
        //
        et_desconto.setText("0");
        et_preco.setText(String.valueOf(preco_eup));
    }

    private void inicializarAcao() {
        et_desconto.addTextChangedListener(txt_desconto);
        et_preco.addTextChangedListener(txt_preco);
    }

    private TextWatcher txt_desconto = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            // Desliguei
            et_preco.removeTextChangedListener(txt_preco);
            try{
                double desconto_digitado =
                        Double.parseDouble(et_desconto.getText().toString());
                //
                double preco_desconto = ( 1 - desconto_digitado/100) * preco_eup;

                et_preco.setText(String.valueOf(preco_desconto));
            } catch (Exception e){
                et_preco.setText(String.valueOf(preco_eup));
            }
            //
            // Religar
            et_preco.addTextChangedListener(txt_preco);

        }
    };

    private TextWatcher txt_preco = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            et_desconto.removeTextChangedListener(txt_desconto);
            //
            try{
                double preco_desconto = Double.parseDouble(et_preco.getText().toString());
                double desconto = (1 - preco_desconto/preco_eup) * 100;
                //
                et_desconto.setText(String.valueOf(desconto));

            } catch (Exception e){
                et_desconto.setText("");
            }
            //
            et_desconto.addTextChangedListener(txt_desconto);

        }
    };

}

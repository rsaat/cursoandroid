package br.com.impacta.t_005_checkbox_radiobutton_togglebutton;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {
    private Context context;

    private CheckBox ck_android;
    private CheckBox ck_ios;
    //
    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;
    //
    private ToggleButton tomada;

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
        ck_android = (CheckBox) findViewById(R.id.ck_android);
        ck_ios = (CheckBox) findViewById(R.id.ck_ios);
        //
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_m = (RadioButton) findViewById(R.id.rb_m);
        rb_f = (RadioButton) findViewById(R.id.rb_f);
        //
        tomada = (ToggleButton) findViewById(R.id.tomada);
    }

    private void inicializarAcao() {
        testes();
        //
        ck_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String resultado = "";

                if (isChecked){
                    resultado = "Sabe Android";
                } else {
                    resultado = "Não SAbe";
                }
                //
                Toast.makeText(
                        context,
                        resultado,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        //
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String resultado = "";

                switch (checkedId){
                    case R.id.rb_f:
                        resultado = "feminino";
                        break;
                    case R.id.rb_m:
                        resultado = "masculino";
                        break;
                    default:
                        resultado = "nao implementou";
                        break;
                }
            }
        });


    }

    private void testes() {
        int saber_android = 0;
        int saber_ios = 1;
        //
        String sexo = "f";
        //
        boolean status = true;

        if (saber_android == 1){
            ck_android.setChecked(true);
        } else {
            ck_android.setChecked(false);
        }

        if (saber_ios == 1){
            ck_ios.setChecked(true);
        } else {
            ck_ios.setChecked(false);
        }

        if ( sexo.equalsIgnoreCase("f")){
            rb_f.setChecked(true);
        }
        //
        if ( sexo.equalsIgnoreCase("M")){
            rb_m.setChecked(true);
        }

        Log.d("TAG", "passei por aqui!!!");

        tomada.setChecked(status);

        int saber_android_r = 0;
        int saber_ios_r = 0;
        //
        String sexo_r = "";
        //
        boolean status_r = false;

        if (ck_android.isChecked()){
            saber_android_r = 1;
        } else {
            saber_android_r = 0;
        }
        //
        if (ck_ios.isChecked()){
            saber_ios_r = 1;
        } else {
            saber_ios_r = 0;
        }

        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_m:
                sexo_r = "M";
                break;
            case R.id.rb_f:
                sexo_r = "F";
                break;
            default:
                sexo_r = "nao determinado";
        }

        status_r = tomada.isChecked();
    }

}

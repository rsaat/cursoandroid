package br.com.impacta.t_007_imageview;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    private Context context;
    //
    private ImageView iv_foto_01;
    private Button btn_foto_01;
    private Button btn_foto_02;
    private ImageView iv_foto_02;

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
        iv_foto_01 = (ImageView) findViewById(R.id.iv_foto_01);
        btn_foto_01 = (Button) findViewById(R.id.btn_foto_01);
        btn_foto_02 = (Button) findViewById(R.id.btn_foto_02);
        iv_foto_02 = (ImageView) findViewById(R.id.iv_foto_02);
        //
        iv_foto_01.setImageBitmap(null);
        iv_foto_02.setImageBitmap(null);
    }

    private void inicializarAcao() {
        btn_foto_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_foto_01.setImageResource(R.drawable.fear);
            }
        });
        //
        btn_foto_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_foto_02.setImageBitmap(
                        BitmapFactory.decodeFile("/sdcard/DBase/foto_tt.jpg"));
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}

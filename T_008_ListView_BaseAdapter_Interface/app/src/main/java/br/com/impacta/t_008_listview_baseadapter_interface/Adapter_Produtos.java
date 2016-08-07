package br.com.impacta.t_008_listview_baseadapter_interface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nalmir on 05/08/2016.
 */
public class Adapter_Produtos extends BaseAdapter {

    private Context context;
    private int resource;
    private List<HMAux> dados;

    public interface IAProdutos {
        public void gostouDoProduto(String texto, boolean gostei);
    }

    private IAProdutos delegate;

    public void setOnGosteiDoProdutoListener(IAProdutos delegate) {
        this.delegate = delegate;
    }

    public Adapter_Produtos(Context context, int resource, List<HMAux> dados) {
        this.context = context;
        this.resource = resource;
        this.dados = dados;
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        HMAux item = dados.get(position);
        //
        return Long.parseLong(item.get(HMAux.ID));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HMAux item = dados.get(position);

        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(context);
            //
            convertView = mInflater.inflate(resource, parent, false);
        }

        TextView tv_nome =
                (TextView) convertView.findViewById(R.id.celula_tv_nome);
        TextView tv_valor =
                (TextView) convertView.findViewById(R.id.celula_tv_valor);
        //
        CheckBox ck_gostei =
                (CheckBox) convertView.findViewById(R.id.celula_ck_gostei);
        //
        ck_gostei.setTag(item);
        ck_gostei.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                HMAux ii = (HMAux) buttonView.getTag();
                //
                if (delegate != null) {
                    delegate.gostouDoProduto(ii.get(HMAux.ID), isChecked);
                }
            }
        });

        //HMAux item = dados.get(position);

        tv_nome.setText(item.get(HMAux.TEXTO_01));
        tv_valor.setText(item.get(HMAux.TEXTO_02));


        return convertView;
    }
}

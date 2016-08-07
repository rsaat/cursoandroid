package br.com.impacta.t_008_listview_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nalmir on 04/08/2016.
 */
public class Adapter_Produtos extends BaseAdapter {

    private Context context;
    //
    private LayoutInflater mLayoutInflater; // ????
    private int resource; // Layout Celula
    private List<Produto> dados; // Fonte de Dados

    private long idprodutoselecionado = -1;

    public void setIdprodutoselecionado(long idprodutoselecionado) {
        this.idprodutoselecionado = idprodutoselecionado;
        //
        notifyDataSetChanged();
    }

    public Adapter_Produtos(Context context, int resource, List<Produto> dados) {
//        this.mLayoutInflater = (LayoutInflater)
//                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        //
        this.resource = resource;
        this.dados = dados;
    }

    // Quantidade de Dados que voce esta fornecendo para o Adapter
    @Override
    public int getCount() {
        return dados.size();
    }

    // Denvolve o Registro associado o posicao passsada pelo parametro position
    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    // Devolver o ID do Registro associado o posicao passsada pelo parametro position
    @Override
    public long getItemId(int position) {
        return dados.get(position).getIdproduto();
    }

    // Devolve uma View(Celula) juntando o Layout + Dados da posicao referencia
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if ( convertView == null){
            convertView = mLayoutInflater.inflate(resource, parent, false);
        }

        // Acesso a Tela ( LayOut Celula )
        TextView tv_nome = (TextView)
                convertView.findViewById(R.id.celula_tv_nome);
        TextView tv_valor = (TextView)
                convertView.findViewById(R.id.celula_tv_valor);
        LinearLayout ll =
                (LinearLayout) convertView.findViewById(R.id.ll);

        // Acesso aos Dados da posicao refenrenciada
        Produto pAux = dados.get(position);

        // Juntei LayOut Celula com os Dados
        tv_nome.setText(pAux.getNome());
        tv_valor.setText(String.valueOf(pAux.getValor()));

        //Regra
        if ( (pAux.getIdproduto() % 2) == 0){
            tv_valor.setTextColor(
                    context.getResources().getColor(R.color.azul_paulista));
        } else {
            tv_valor.setTextColor(
                    context.getResources().getColor(R.color.vermerlho_paulista));
        }

        if (idprodutoselecionado == pAux.getIdproduto()){
            ll.setBackgroundColor(0xFF00FF00);
        } else {
            ll.setBackgroundColor(0x00000000);
        }

        return convertView;
    }
}

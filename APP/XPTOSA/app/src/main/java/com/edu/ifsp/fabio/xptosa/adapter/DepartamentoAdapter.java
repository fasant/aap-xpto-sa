package com.edu.ifsp.fabio.xptosa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edu.ifsp.fabio.xptosa.domain.Departamento;

import java.util.List;

import com.edu.ifsp.fabio.xptosa.R;


public class DepartamentoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Departamento> departamentos;

    public DepartamentoAdapter(Context context, List departamentos) {
        this.context = context;
        this.departamentos = departamentos;
    }

    @Override
    public int getCount() {
        return departamentos != null ? departamentos.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return departamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departamentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_departamento, parent, false);

        TextView tNome = (TextView) view.findViewById(R.id.tNome);
        TextView tLocal = (TextView) view.findViewById(R.id.tLocal);;

        Departamento departamento = departamentos.get(position);
        tNome.setText(departamento.getNome());
        tLocal.setText(departamento.getLocal());

        return view;
    }
}

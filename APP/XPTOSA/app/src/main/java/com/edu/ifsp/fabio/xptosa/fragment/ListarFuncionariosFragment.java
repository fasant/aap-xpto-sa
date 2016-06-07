package com.edu.ifsp.fabio.xptosa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edu.ifsp.fabio.xptosa.R;
import com.edu.ifsp.fabio.xptosa.presenter.ListarFuncionariosPresenter;


public class ListarFuncionariosFragment extends Fragment {

    private ListView mList;


    public ListarFuncionariosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_funcionarios, container, false);

        mList = (ListView) view.findViewById(R.id.listViewFuncionario);
        ListarFuncionariosPresenter listarFuncionariosPresenter = new ListarFuncionariosPresenter();

        listarFuncionariosPresenter.listarFuncionarios(getContext(), mList);

        return view;
    }

}

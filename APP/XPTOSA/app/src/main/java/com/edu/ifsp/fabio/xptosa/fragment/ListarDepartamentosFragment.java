package com.edu.ifsp.fabio.xptosa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edu.ifsp.fabio.xptosa.R;
import com.edu.ifsp.fabio.xptosa.presenter.ListarDepartamentosPresenter;

/**
 *
 */
public class ListarDepartamentosFragment extends Fragment {
    private ListView mList;

    public ListarDepartamentosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_departamentos, container, false);

        mList = (ListView) view.findViewById(R.id.listView);
        ListarDepartamentosPresenter listarDepartamentosPresenter = new ListarDepartamentosPresenter();

        listarDepartamentosPresenter.listarDepartamentos(getContext(), mList);

        return view;
    }

}

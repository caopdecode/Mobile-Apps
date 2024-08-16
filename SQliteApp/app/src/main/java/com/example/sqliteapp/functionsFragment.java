package com.example.sqliteapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link functionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class functionsFragment extends Fragment {

    Button btn_camaraview;
    Button btn_navegadorWeb;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public functionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment functionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static functionsFragment newInstance(String param1, String param2) {
        functionsFragment fragment = new functionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_functions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_camaraview = (Button) view.findViewById(R.id.btn_camaraview);
        btn_navegadorWeb = (Button) view.findViewById(R.id.btn_navegadorWeb);

        btn_camaraview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

        btn_navegadorWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirNavegador(); }
        });
    }

    public void abrirNavegador(){
        Intent nav = new Intent(functionsFragment.this.getActivity(), webActivity.class);
        startActivity(nav);
    }

    public void abrirCamara () {
        Intent cam = new Intent(functionsFragment.this.getActivity(), camaraActivity.class);
        startActivity(cam);
    }
}
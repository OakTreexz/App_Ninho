package com.example.app_ninho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_ninho.R;

/** Tela de espaço reservado para Galeria e Infos, até serem implementadas. */
public class TelaProvisoriaFragment extends Fragment {

    private static final String ARG_TITULO = "titulo";

    public static TelaProvisoriaFragment novo(String titulo) {
        TelaProvisoriaFragment fragment = new TelaProvisoriaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITULO, titulo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_provisoria, container, false);
        TextView titulo = view.findViewById(R.id.tv_provisoria);
        if (getArguments() != null) {
            titulo.setText(getArguments().getString(ARG_TITULO));
        }
        return view;
    }
}
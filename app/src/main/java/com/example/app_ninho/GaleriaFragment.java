package com.example.app_ninho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/** Aba Galeria: lista os assuntos que têm fotos de referência. */
public class GaleriaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_galeria, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView lista = view.findViewById(R.id.rv_topicos);
        lista.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        lista.setAdapter(new TopicoGaleriaAdapter(modulo -> {
            if (Galeria.temFotos(modulo)) {
                FotosTopicoActivity.abrir(requireContext(), modulo);
            } else {
                Toast.makeText(requireContext(),
                        "As fotos deste assunto estarão disponíveis em breve.",
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
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

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView lista = view.findViewById(R.id.rv_modulos);
        lista.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        lista.setAdapter(new ModuloAdapter(modulo -> {
            if (Formularios.disponivel(modulo)) {
                TriagemFezesActivity.abrir(requireContext(), modulo);
            } else {
                Toast.makeText(requireContext(),
                        "Este módulo estará disponível em breve.",
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
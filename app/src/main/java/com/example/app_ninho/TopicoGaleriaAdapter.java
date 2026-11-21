package com.example.app_ninho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/** Cards dos assuntos da aba Galeria (um por módulo clínico). */
public class TopicoGaleriaAdapter extends RecyclerView.Adapter<TopicoGaleriaAdapter.ViewHolder> {

    public interface OnTopicoClickListener {
        void onTopicoClick(ModuloClinico modulo);
    }

    private final ModuloClinico[] topicos = ModuloClinico.values();
    private final OnTopicoClickListener listener;

    public TopicoGaleriaAdapter(OnTopicoClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_topico_galeria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModuloClinico modulo = topicos[position];
        holder.titulo.setText(modulo.getTitulo());
        holder.subtitulo.setText(Galeria.temFotos(modulo) ? "Ver fotos" : "Em breve");
        holder.itemView.setOnClickListener(v -> listener.onTopicoClick(modulo));
    }

    @Override
    public int getItemCount() {
        return topicos.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titulo;
        final TextView subtitulo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tv_titulo);
            subtitulo = itemView.findViewById(R.id.tv_subtitulo);
        }
    }
}
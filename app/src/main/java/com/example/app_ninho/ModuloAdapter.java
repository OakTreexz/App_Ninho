package com.example.app_ninho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModuloAdapter extends RecyclerView.Adapter<ModuloAdapter.ViewHolder> {

    public interface OnModuloClickListener {
        void onModuloClick(ModuloClinico modulo);
    }

    private final ModuloClinico[] modulos = ModuloClinico.values();
    private final OnModuloClickListener listener;

    public ModuloAdapter(OnModuloClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_modulo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModuloClinico modulo = modulos[position];
        holder.emoji.setText(modulo.getEmoji());
        holder.titulo.setText(modulo.getTitulo());
        holder.itemView.setOnClickListener(v -> listener.onModuloClick(modulo));
    }

    @Override
    public int getItemCount() {
        return modulos.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView emoji;
        final TextView titulo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            emoji = itemView.findViewById(R.id.tv_emoji);
            titulo = itemView.findViewById(R.id.tv_titulo);
        }
    }
}
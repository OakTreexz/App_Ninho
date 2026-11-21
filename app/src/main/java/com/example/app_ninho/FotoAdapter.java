package com.example.app_ninho;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/** Cards de foto de um assunto, com o nível do semáforo. */
public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.ViewHolder> {

    public interface OnFotoClickListener {
        void onFotoClick(FotoGaleria foto);
    }

    private final List<FotoGaleria> fotos = new ArrayList<>();
    private final OnFotoClickListener listener;

    public FotoAdapter(OnFotoClickListener listener) {
        this.listener = listener;
    }

    public void setFotos(List<FotoGaleria> novas) {
        fotos.clear();
        fotos.addAll(novas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_foto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FotoGaleria foto = fotos.get(position);

        holder.titulo.setText(foto.getTitulo());
        holder.nivel.setText(NivelUi.nome(foto.getNivel()));
        holder.ponto.setBackgroundTintList(ColorStateList.valueOf(
                NivelUi.cor(holder.itemView.getContext(), foto.getNivel())));

        if (foto.getImagem() != 0) {
            holder.imagem.setImageResource(foto.getImagem());
            holder.imagem.setContentDescription(foto.getTitulo());
            holder.imagem.setVisibility(View.VISIBLE);
            holder.rotulo.setVisibility(View.GONE);
        } else {
            holder.imagem.setImageDrawable(null);
            holder.imagem.setVisibility(View.GONE);
            holder.rotulo.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(v -> listener.onFotoClick(foto));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imagem;
        final TextView rotulo;
        final TextView titulo;
        final View ponto;
        final TextView nivel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.iv_foto);
            rotulo = itemView.findViewById(R.id.tv_rotulo);
            titulo = itemView.findViewById(R.id.tv_titulo);
            ponto = itemView.findViewById(R.id.v_ponto);
            nivel = itemView.findViewById(R.id.tv_nivel);
        }
    }
}
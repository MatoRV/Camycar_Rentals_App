package com.example.camycarrentals.Controller.maquinaCard;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.R;

public class MaquinaCardAdapter extends RecyclerView.Adapter<MaquinaCardViewHolder> {

    private final ArrayList<Maquina> mList;

    private LayoutInflater mInflater;

    public MaquinaCardAdapter(Context context, ArrayList<Maquina> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @NonNull
    @Override
    public MaquinaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.lista_maquinas, parent, false);
        return new MaquinaCardViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MaquinaCardViewHolder holder, int position) {
        holder.setTvModeloMaquina(this.mList.get(position).getFabricante() + " " + this.mList.get(position).getModelo().toUpperCase());
        holder.setTvEstadoMaquina(this.mList.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

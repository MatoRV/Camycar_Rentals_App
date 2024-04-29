package com.example.camycarrentals.Controller.maquinaCard;

import java.util.LinkedList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.R;

public class MaquinaCardAdapter extends RecyclerView.Adapter<MaquinaCardViewHolder> {

    private final LinkedList<Maquina> mList;

    private LayoutInflater mInflater;

    public MaquinaCardAdapter(Context context, LinkedList<Maquina> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @NonNull
    @Override
    public MaquinaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.prueba_maquinas, parent, false);
        return new MaquinaCardViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MaquinaCardViewHolder holder, int position) {
        holder.setTvModeloMaquina(this.mList.get(position).getModelo().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

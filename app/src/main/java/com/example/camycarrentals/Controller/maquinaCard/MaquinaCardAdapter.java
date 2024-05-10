package com.example.camycarrentals.Controller.maquinaCard;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.databinding.ListaMaquinasBinding;

public class MaquinaCardAdapter extends RecyclerView.Adapter<MaquinaCardViewHolder> {

    private final ArrayList<Maquina> mList;

    private OnClickListener onClickListener;

    public MaquinaCardAdapter(ArrayList<Maquina> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MaquinaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MaquinaCardViewHolder(ListaMaquinasBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MaquinaCardViewHolder holder, int position) {
        Maquina maquina = this.mList.get(position);
        holder.setTvModeloMaquina(this.mList.get(position).getFabricante() + " " + this.mList.get(position).getModelo().toUpperCase());
        holder.setTvEstadoMaquina(this.mList.get(position).getEstado());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position, maquina);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {

        void onClick(int position, Maquina item);
    }
}

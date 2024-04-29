package com.example.camycarrentals.Controller.maquinaCard;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.R;

public class MaquinaCardViewHolder extends RecyclerView.ViewHolder {

    MaquinaCardAdapter mAdapter;

    private TextView tvModeloMaquina;

    private TextView tvEstadoMaquina;

    public MaquinaCardViewHolder(View itemView, MaquinaCardAdapter adapter) {
        super(itemView);

        tvModeloMaquina = itemView.findViewById(R.id.modeloMaquinaPrueba);
        tvEstadoMaquina = itemView.findViewById(R.id.estadoMaquinaPrueba);
        this.mAdapter = adapter;
    }

    public void setTvModeloMaquina(String data) {
        tvModeloMaquina.setText(data);
    }

    public void setTvEstadoMaquina(String data) {
        tvEstadoMaquina.setText(data);
    }
}

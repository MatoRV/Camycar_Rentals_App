package com.example.camycarrentals.Controller.maquinaCard;

import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.databinding.ListaMaquinasBinding;

public class MaquinaCardViewHolder extends RecyclerView.ViewHolder {

    MaquinaCardAdapter mAdapter;

    ListaMaquinasBinding binding;

    public MaquinaCardViewHolder(ListaMaquinasBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    final ListaMaquinasBinding getBinding() {
        return binding;
    }

    final void setBinding(ListaMaquinasBinding binding) {
        this.binding = binding;
    }

    public void setTvModeloMaquina(String data) {
        binding.modeloMaquina.setText(data);
    }

    public void setTvEstadoMaquina(String data) {
        binding.estadoMaquina.setText(data);
    }

    final String getTvModeloMaquina() {
        return (String) binding.modeloMaquina.getText();
    }

    final String getTvEstadoMaquina() {
        return (String) binding.estadoMaquina.getText();
    }
}

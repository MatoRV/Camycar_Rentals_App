package com.example.camycarrentals.View;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.camycarrentals.Controller.MainController;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import org.jetbrains.annotations.NotNull;

public class SortBottomDialogFragment extends BottomSheetDialogFragment {

    private MaterialButton aplicarButton, resetButton;
    private ChipGroup cgFabricante, cgTipoMaquina, cgCapacidadCarga, cgEstado;
    private MaquinaCardViewModel mViewModel;

    private Chip chipFabricante, chipTipoMaquina, chipCapacidadCarga, chipEstado;
    public SortBottomDialogFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.sort_fragment, container, false);
        mViewModel = MainController.getSingleton().getMaquinaCardViewModel();
        aplicarButton = view.findViewById(R.id.btnApply);
        resetButton = view.findViewById(R.id.btnResetAll);
        cgFabricante = view.findViewById(R.id.cgFabricante);
        cgTipoMaquina = view.findViewById(R.id.cgTipoMaquina);
        cgCapacidadCarga = view.findViewById(R.id.cgCapacidadCarga);
        cgEstado = view.findViewById(R.id.cgEstado);

        StringBuilder filtro = new StringBuilder("/filtro");
        ArrayList<String> cadena = new ArrayList<>();
        cadena.add("");
        cadena.add("");
        cadena.add("");
        cadena.add("");

        cgCapacidadCarga.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chipCapacidadCarga = group.findViewById(checkedId);
                if (chipCapacidadCarga != null) {
                    cadena.set(0, "capacidadCarga=" + chipCapacidadCarga.getText().toString());
                }
            }
        });
        cgEstado.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chipEstado = group.findViewById(checkedId);
                if (chipEstado != null) {
                    cadena.set(1, "estado=" + chipEstado.getText().toString());
                }
            }
        });
        cgFabricante.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chipFabricante = group.findViewById(checkedId);
                if (chipFabricante != null) {
                    cadena.set(2, "fabricante=" + chipFabricante.getText().toString());
                }
            }
        });

        cgTipoMaquina.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chipTipoMaquina = group.findViewById(checkedId);
                if (chipTipoMaquina != null) {
                    cadena.set(3, "tipoMaquina=" + chipTipoMaquina.getText().toString());
                }
            }
        });
        aplicarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cadena.size() > 1) {
                    if (!cadena.get(0).equals("") && !cadena.get(1).equals("") && !cadena.get(2).equals("") && !cadena.get(3).equals("")) {
                        filtro.append("?");
                    }
                    for (int i = 0; i < cadena.size(); i++) {
                        if (i == cadena.size() - 1) {
                            filtro.append(cadena.get(i));
                        } else if (!cadena.get(i).equals("")) {
                            filtro.append(cadena.get(i)).append("&");
                        }
                    }
                }
                if (cadena.size() == 1) {
                    filtro.append("?").append(cadena.get(0));
                } else {
                    filtro.append("");
                }

                mViewModel.loadMaquina(String.valueOf(filtro));
                filtro.delete(7, filtro.length());
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Reset", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < cgCapacidadCarga.getChildCount(); i++) {
                    chipCapacidadCarga = (Chip) cgCapacidadCarga.getChildAt(i);
                    chipCapacidadCarga.setChecked(false);
                }
                for (int i = 0; i < cgEstado.getChildCount(); i++) {
                    chipEstado = (Chip) cgEstado.getChildAt(i);
                    chipEstado.setChecked(false);
                }
                for (int i = 0; i < cgFabricante.getChildCount(); i++) {
                    chipFabricante = (Chip) cgFabricante.getChildAt(i);
                    chipFabricante.setChecked(false);
                }
                for (int i = 0; i < cgTipoMaquina.getChildCount(); i++) {
                    chipTipoMaquina = (Chip) cgTipoMaquina.getChildAt(i);
                    chipTipoMaquina.setChecked(false);
                }
                mViewModel.loadMaquina("");
            }
        });
        return view;
    }

}

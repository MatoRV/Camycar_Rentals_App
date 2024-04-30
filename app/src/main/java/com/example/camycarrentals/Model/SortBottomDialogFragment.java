package com.example.camycarrentals.Model;

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
    private ChipGroup cgFabricante, cgTipoMaquina;
    private MaquinaCardViewModel mViewModel;

    private Chip chip;
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

        StringBuilder filtro = new StringBuilder("/filtro?");
        ArrayList<String> cadena = new ArrayList<>();

        cgFabricante.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chip = group.findViewById(checkedId);
                if (chip != null) {
                    cadena.add("fabricante=" + chip.getText().toString());
                    filtro.append("fabricante=").append(chip.getText().toString());
                }
            }
        });

        cgTipoMaquina.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                chip = group.findViewById(checkedId);
                if (chip != null) {
                    cadena.add("tipoMaquina=" + chip.getId());
                    Toast.makeText(view.getContext(), "El id es: " + chip.getId(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        aplicarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cadena.size() > 1) {
                    for (int i = 0; i < cadena.size(); i++) {
                        if (i == cadena.size() - 1) {
                            filtro.append(cadena.get(i));
                        } else {
                            filtro.append(cadena.get(i)).append("&");
                        }
                    }
                }
                if (cadena.size() == 1) {
                    filtro.append(cadena.get(0));
                } else {
                    filtro.append("");
                }

                mViewModel.loadMaquina(String.valueOf(filtro));
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Reset", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < cgFabricante.getChildCount(); i++) {
                    chip = (Chip) cgFabricante.getChildAt(i);
                    chip.setChecked(false);
                }
                for (int i = 0; i < cgTipoMaquina.getChildCount(); i++) {
                    chip = (Chip) cgTipoMaquina.getChildAt(i);
                    chip.setChecked(false);
                }
                mViewModel.loadMaquina("");
            }
        });
        return view;
    }

}

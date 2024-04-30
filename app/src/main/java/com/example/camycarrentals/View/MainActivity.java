package com.example.camycarrentals.View;

import java.util.ArrayList;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Controller.MainController;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardAdapter;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.Model.SortBottomDialogFragment;
import com.example.camycarrentals.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Maquina> mMaquinaList = new ArrayList<>();

    Toolbar toolbar;

    private RecyclerView mRecyclerView;

    private MaquinaCardAdapter mAdapter;

    private MaquinaCardViewModel mViewModel;

    private ChipGroup chipGroup;

    private Chip chip;

    private MaterialButton aplicarButton;

    private Button sortButton;

    private static MainActivity myActiveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sortButton = findViewById(R.id.btnSort);
        chipGroup = findViewById(R.id.cgFabricante);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sort_fragment, null);
        aplicarButton = view.findViewById(R.id.btnApply);

        mRecyclerView = findViewById(R.id.rvMaquinas);
        mAdapter = new MaquinaCardAdapter(this, mMaquinaList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mViewModel = new ViewModelProvider(this).get(MaquinaCardViewModel.class);
        MainController.getSingleton().setupViewModel(mViewModel);

        mViewModel.getMaquinas().observe(this, maquinas -> {
            mMaquinaList.clear();
            mMaquinaList.addAll(maquinas);
            mAdapter.notifyDataSetChanged();
        });
        mViewModel.loadMaquina("");

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SortBottomDialogFragment.getmSortBottomDialogFragment().show(getSupportFragmentManager(), null);
            }
        });

        aplicarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder filtro = new StringBuilder("/filtro?");
                chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull @NotNull ChipGroup group, int checkedId) {
                        chip = group.findViewById(checkedId);
                        if (chip != null) {
                            filtro.append("fabricante=").append(chip.getText().toString());
                        }
                    }
                });
                mViewModel.loadMaquina(String.valueOf(filtro));
            }
        });

    }

//    public void accessData() {
//        List<Maquina> maquinas = MainController.getSingleton().getMaquinasRequested();
//        mMaquinaList.clear();
//        for (Maquina maquina : maquinas) {
//            mMaquinaList.add(maquina);
//        }
//
//        mAdapter.notifyDataSetChanged();
//    }

}
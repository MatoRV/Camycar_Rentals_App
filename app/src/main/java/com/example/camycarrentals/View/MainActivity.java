package com.example.camycarrentals.View;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Controller.MainController;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardAdapter;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.R;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Maquina> mMaquinaList = new ArrayList<>();

    Toolbar toolbar;

    private RecyclerView mRecyclerView;

    private MaquinaCardAdapter mAdapter;

    private MaquinaCardViewModel mViewModel;

    private Button sortButton;
    private SortBottomDialogFragment sortBottomDialogFragment;

    private static MainActivity myActiveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sortBottomDialogFragment = new SortBottomDialogFragment();
        sortButton = findViewById(R.id.btnSort);

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
                sortBottomDialogFragment.show(getSupportFragmentManager(), null);
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
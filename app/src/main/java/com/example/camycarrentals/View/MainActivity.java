package com.example.camycarrentals.View;

import java.util.ArrayList;
import android.content.Intent;
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
import com.example.camycarrentals.View.UsuarioView.ProfileView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Maquina> mMaquinaList = new ArrayList<>();

    Toolbar toolbar;

    private RecyclerView mRecyclerView;

    private MaquinaCardAdapter mAdapter;

    private MaquinaCardViewModel mViewModel;

    private Button sortButton;
    private SortBottomDialogFragment sortBottomDialogFragment;

    private BottomNavigationView mBottomNavigationView;

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
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setSelectedItemId(R.id.item1);
        mBottomNavigationView.setOnItemSelectedListener(itemSelectedListener);

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

    private final NavigationBarView.OnItemSelectedListener itemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.item2:
                Intent p = new Intent(MainActivity.this, ProfileView.class);
                startActivity(p);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                finish();
                break;
        }
        return false;
    };

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
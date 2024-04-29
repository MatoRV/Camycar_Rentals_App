package com.example.camycarrentals.View;

import java.util.LinkedList;
import java.util.List;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.camycarrentals.Controller.MainController;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardAdapter;
import com.example.camycarrentals.Controller.maquinaCard.MaquinaCardViewModel;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.R;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Maquina> mMaquinaList = new LinkedList<>();

    private RecyclerView mRecyclerView;

    private MaquinaCardAdapter mAdapter;

    private MaquinaCardViewModel mViewModel;

    private static MainActivity myActiveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);        mRecyclerView = findViewById(R.id.rvMaquinas);
        mAdapter = new MaquinaCardAdapter(this, mMaquinaList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mViewModel = new ViewModelProvider(this).get(MaquinaCardViewModel.class);
//        MainController.getSingleton().setupViewModel(mViewModel);

        mViewModel.getMaquinas().observe(this, maquinas -> {
            mMaquinaList.clear();
            mMaquinaList.addAll(maquinas);
            mAdapter.notifyDataSetChanged();
        });
        mViewModel.loadMaquina();

//        Button generar = (Button) findViewById(R.id.btMaquinas);
//        generar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Obteniendo info de las maquinas",Toast.LENGTH_LONG).show();
//                mViewModel.loadMaquina();
//            }
//        });

        MainActivity.myActiveActivity = this;
        MainController.setActivity(this);
    }

//    public void accessData() {
//        List<Maquina> lista = MainController.getSingleton().getMaquinasRequested();
//
//        mMaquinaList.clear();
//        for (Maquina maquina : lista) {
//            mMaquinaList.add(maquina);
//        }
//
//        mAdapter.notifyDataSetChanged();
//    }
}
package com.example.camycarrentals.View.UsuarioView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.R;
import com.example.camycarrentals.View.MainActivity;
import com.google.android.material.navigation.NavigationBarView;

public class ProfileView extends AppCompatActivity {

    private TextView tvCorreo, tvNombre;

    private NavigationBarView mBottomNavigationBar;

    private ConstraintLayout mButtonIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        mBottomNavigationBar = findViewById(R.id.bottom_navigation);
        tvCorreo = findViewById(R.id.tvCorreo);
        tvNombre = findViewById(R.id.tvProfile);
        mButtonIP = findViewById(R.id.btnProfile);

        mBottomNavigationBar.setSelectedItemId(R.id.item2);
        mBottomNavigationBar.setOnItemSelectedListener(itemSelectedListener);
        tvCorreo.setText(LoginController.getSingleton().getDatosLogin().getCorreo());
        tvNombre.setText(LoginController.getSingleton().getDatosLogin().getNombre());

        mButtonIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileView.this, InformacionPersonalView.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

    private final NavigationBarView.OnItemSelectedListener itemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent p = new Intent(ProfileView.this, MainActivity.class);
                startActivity(p);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                finish();
                break;
        }
        return false;
    };
}

package com.example.app_ninho;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Empurra o conteúdo para baixo da barra de status.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container), (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, barras.top, 0, 0);
            return insets;
        });

        BottomNavigationView nav = findViewById(R.id.bottom_nav);
        nav.setOnItemSelectedListener(item -> {
            Fragment destino = fragmentPara(item.getItemId());
            if (destino == null) return false;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, destino)
                    .commit();
            return true;
        });

        if (savedInstanceState == null) {
            nav.setSelectedItemId(R.id.nav_home);
        }
    }

    private Fragment fragmentPara(int itemId) {
        if (itemId == R.id.nav_home) {
            return new HomeFragment();
        } else if (itemId == R.id.nav_galeria) {
            return TelaProvisoriaFragment.novo(getString(R.string.nav_galeria));
        } else if (itemId == R.id.nav_infos) {
            return TelaProvisoriaFragment.novo(getString(R.string.nav_infos));
        }
        return null;
    }
}

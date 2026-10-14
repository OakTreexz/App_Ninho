package com.example.app_ninho;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_ninho.MainActivity;
import com.example.app_ninho.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final long TEMPO_SPLASH = 2500; // ms

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable irParaProximaTela = () -> {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish(); // remove a splash da pilha (o botão voltar não retorna a ela)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View logo = findViewById(R.id.imgIconeNinho);
        View nome = findViewById(R.id.txtNomeApp);
        View slogan = findViewById(R.id.txtSlogan);

        // Estado inicial (invisível)
        logo.setAlpha(0f);
        logo.setScaleX(0.6f);
        logo.setScaleY(0.6f);
        nome.setAlpha(0f);
        slogan.setAlpha(0f);

        // Logo: fade + "pulinho" de escala
        logo.animate()
                .alpha(1f).scaleX(1f).scaleY(1f)
                .setDuration(900)
                .setInterpolator(new OvershootInterpolator())
                .start();

        // Nome e slogan entram depois, em sequência
        nome.animate().alpha(1f).setStartDelay(700).setDuration(500).start();
        slogan.animate().alpha(1f).setStartDelay(1000).setDuration(500).start();

        handler.postDelayed(irParaProximaTela, TEMPO_SPLASH);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(irParaProximaTela); // evita abrir a tela depois de fechar
    }
}
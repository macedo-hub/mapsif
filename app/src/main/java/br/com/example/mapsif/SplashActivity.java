package br.com.example.mapsif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //pega o modo escuro que ficou salvo
        boolean modoEscuro = getSharedPreferences("configuracoes", MODE_PRIVATE).getBoolean("modo_escuro", false);
        if (modoEscuro) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        //escolhe o vídeo conforme o tema do app
        int idDoVideo;
        if (modoEscuro) {
            idDoVideo = R.raw.splash_video_fundo_escuro;
        } else {
            idDoVideo = R.raw.splash_video_fundo_claro;
        }
        VideoView videoSplash = findViewById(R.id.videoSplash);
        videoSplash.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + idDoVideo));
        videoSplash.setOnCompletionListener(videoTocado -> abrirTelaPrincipal());
        videoSplash.start();
    }

    //abre a tela principal
    private void abrirTelaPrincipal() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
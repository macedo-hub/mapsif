package br.com.example.mapsif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- LUCAS EMANUEL ---
        abrirLink(R.id.btnGithubLucas, "https://github.com/macedo-hub");
        abrirLink(R.id.btnLinkedinLucas, "https://www.linkedin.com/in/lucas-nóbrega-866774409?utm_source=share_via&utm_content=profile&utm_medium=member_android");

        // --- IASMIM ANAHÍ ---
        abrirLink(R.id.btnGithubIasmim, "https://github.com/iasmimanahi");
        abrirLink(R.id.btnLinkedinIasmim, "https://www.linkedin.com/in/iasmim-anah%C3%AD-alves-silva-822905418/");

        // --- PROFESSOR ORIENTADOR ---
        abrirLink(R.id.btnGithubOrientador, "https://github.com/alexandrecostapb");
        abrirLink(R.id.btnLinkedinOrientador, "https://www.linkedin.com/in/alexandrecostapb?utm_source=share_via&utm_content=profile&utm_medium=member_android");

        // --- REPOSITÓRIO DO PROJETO ---
        abrirLink(R.id.cardGithubProjeto, "https://github.com/macedo-hub/mapsif");
    }

    //Método simples para abrir o link ao clicar no botão
    private void abrirLink(int idDoElemento, String url) {
        View elemento = findViewById(idDoElemento);
        if (elemento != null) {
            elemento.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            });
        }
    }
}
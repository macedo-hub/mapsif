package br.com.example.mapsif;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private ImageButton menuButton;
    private ImageButton sobreButton;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton sobreButton = findViewById(R.id.sobreButton);
        ImageButton menuButton = findViewById(R.id.menuButton);
        DrawerLayout drawerLayout = findViewById(R.id.main);

        // blocos
        Button columnAPrimeiroAndar = findViewById(R.id.columnAPrimeiroAndar);
        Button columnATerreo = findViewById(R.id.columnATerreo);
        Button columnBPrimeiroAndar = findViewById(R.id.columnBPrimeiroAndar);
        Button columnBTerreo = findViewById(R.id.columnBTerreo);

        // Botões do menu lateral
        Button btnInicioTrilha = findViewById(R.id.btn_inicio_trilha);
        Button btnSalaDescanso = findViewById(R.id.btn_sala_descanso);
        Button btnSalaServidor = findViewById(R.id.btn_sala_servidor);
        Switch modoNoturnoSwitch = findViewById(R.id.modoNoturnoSwitch);

        SharedPreferences preferencias = getSharedPreferences("configuracoes", MODE_PRIVATE);
        modoNoturnoSwitch.setChecked(preferencias.getBoolean("modo_escuro", false));

        modoNoturnoSwitch.setOnCheckedChangeListener((botao, ligado) -> {
            boolean jaSalvo = preferencias.getBoolean("modo_escuro", false);
            if (ligado == jaSalvo) {
                return; // nada mudou, não faz nada
            }

            preferencias.edit().putBoolean("modo_escuro", ligado).apply();

            if (ligado) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });



        // sobre
        sobreButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(intent);
        });

        // menu lateral
        menuButton.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // bloco A - 1º andar
        columnAPrimeiroAndar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaSalasActivity.class);
                intent.putExtra("localizacao", "BLOCO_A_PRIMEIRO_ANDAR");
                startActivity(intent);
            }
        });

        // Bloco A - Térreo
        columnATerreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaSalasActivity.class);
                intent.putExtra("localizacao", "BLOCO_A_TERREO");
                startActivity(intent);
            }
        });

        // Bloco B - 1º andar
        columnBPrimeiroAndar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaSalasActivity.class);
                intent.putExtra("localizacao", "BLOCO_B_PRIMEIRO_ANDAR");
                startActivity(intent);
            }
        });

        // Bloco B - Térreo
        columnBTerreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaSalasActivity.class);
                intent.putExtra("localizacao", "BLOCO_B_TERREO");
                startActivity(intent);
            }
        });

        // Início da trilha
        btnInicioTrilha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalheSalaActivity.class);
                intent.putExtra("salaId", "inicio_trilha");
                intent.putExtra("localizacao", "BLOCO_A_PRIMEIRO_ANDAR");
                intent.putExtra("origem", "menu");
                startActivity(intent);
            }
        });

        // Sala de descanso
        btnSalaDescanso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalheSalaActivity.class);
                intent.putExtra("salaId", "sala_descanso");
                intent.putExtra("localizacao", "BLOCO_A_PRIMEIRO_ANDAR");
                intent.putExtra("origem", "menu");
                startActivity(intent);
            }
        });

        // Sala de servidor
        btnSalaServidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalheSalaActivity.class);
                intent.putExtra("salaId", "sala_servidor");
                intent.putExtra("localizacao", "BLOCO_A_PRIMEIRO_ANDAR");
                intent.putExtra("origem", "menu");
                startActivity(intent);
            }
        });
    }
}
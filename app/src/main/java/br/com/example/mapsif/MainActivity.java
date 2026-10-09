package br.com.example.mapsif;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
    }
}
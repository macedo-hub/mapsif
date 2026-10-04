package br.com.example.mapsif;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.example.mapsif.adapter.SalaAdapter;
import br.com.example.mapsif.data.SalaRepository;
import br.com.example.mapsif.model.Localizacao;
import br.com.example.mapsif.model.Sala;

public class ListaSalasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_salas);

        String localizacao = getIntent().getStringExtra("localizacao");
        Localizacao localizacaoEnum = Localizacao.valueOf(localizacao);

        List<Sala> salas = SalaRepository.getSalasPorLocalizacao(localizacaoEnum);

        RecyclerView recyclerSalas = findViewById(R.id.recyclerSalas);
        recyclerSalas.setLayoutManager(new LinearLayoutManager(this));
        recyclerSalas.setAdapter(new SalaAdapter(this, salas));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerSalas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package br.com.example.mapsif;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Busca a localização selecionada
        String localizacao = getIntent().getStringExtra("localizacao");
        Localizacao localizacaoEnum = Localizacao.valueOf(localizacao);

        // Localiza a lista
        RecyclerView recyclerSalas = findViewById(R.id.recyclerSalas);

        // Busca as salas daquele andar
        List<Sala> salas = SalaRepository.getSalasPorLocalizacao(localizacaoEnum);

        // Configura a lista
        recyclerSalas.setLayoutManager(new LinearLayoutManager(this));
        recyclerSalas.setAdapter(new SalaAdapter(this, salas, localizacao));

        // Botão de voltar
        ImageButton btnVoltarLista = findViewById(R.id.btnVoltarLista);

        btnVoltarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

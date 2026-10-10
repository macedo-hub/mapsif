 package br.com.example.mapsif;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.example.mapsif.data.SalaRepository;
import br.com.example.mapsif.model.Sala;

public class DetalheSalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhe_sala);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Busca os dados da sala
        String salaId = getIntent().getStringExtra("salaId");
        Sala sala = SalaRepository.getSalaPorId(salaId);

        // Localiza os elementos da tela
        TextView txtTitulo = findViewById(R.id.txtTituloDetalhe);
        ImageView imgSala = findViewById(R.id.imgDetalheSala);
        TextView txtDescricao = findViewById(R.id.txtDescricaoDetalhe);
        ImageButton btnVoltarDetalhe = findViewById(R.id.btnVoltarDetalhe);

        // Exibe os dados da sala
        txtTitulo.setText(sala.getTitulo());
        imgSala.setImageResource(sala.getImagem());
        txtDescricao.setText(sala.getDescricao());

        // Botão de voltar
        btnVoltarDetalhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String origem = getIntent().getStringExtra("origem");

                if ("menu".equals(origem)) {
                    Intent intent = new Intent(DetalheSalaActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(DetalheSalaActivity.this, ListaSalasActivity.class);
                    intent.putExtra("localizacao", getIntent().getStringExtra("localizacao"));
                    startActivity(intent);
                }
            }
        });
    }
}

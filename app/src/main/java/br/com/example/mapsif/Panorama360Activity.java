package br.com.example.mapsif;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.webkit.WebViewAssetLoader;
import java.io.IOException;
import br.com.example.mapsif.data.SalaRepository;
import br.com.example.mapsif.model.Sala;

public class Panorama360Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panorama_360);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // pega a sala escolhida
        String salaId = getIntent().getStringExtra("salaId");
        Sala sala = SalaRepository.getSalaPorId(salaId);

        // elementos da tela
        TextView txtTitulo = findViewById(R.id.txtTituloPanorama);
        ImageButton btnVoltar = findViewById(R.id.btnVoltarPanorama);
        WebView webView = findViewById(R.id.webViewPanorama);

        txtTitulo.setText(sala.getTitulo());

        // botão de voltar: fecha esta tela e volta para o detalhe da sala
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // o panorama tem o mesmo nome do id da sala
        String arquivo = salaId + ".jpg";

        // se o arquivo não existir, avisa e volta
        try {
            getAssets().open("panoramas/" + arquivo).close();
        } catch (IOException e) {
            Toast.makeText(this, "360° ainda não disponível para este ambiente", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // serve a pasta assets como se fosse um servidor https
        final WebViewAssetLoader loader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this))
                .build();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return loader.shouldInterceptRequest(request.getUrl());
            }
        });

        // avisa a página se o app está no modo escuro
        int modo = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        String tema = (modo == Configuration.UI_MODE_NIGHT_YES) ? "escuro" : "claro";

        webView.loadUrl("https://appassets.androidplatform.net/assets/panorama.html?imagem=" + arquivo + "&modo=" + tema);
    }
}
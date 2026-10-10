package br.com.example.mapsif.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.example.mapsif.DetalheSalaActivity;
import br.com.example.mapsif.R;
import br.com.example.mapsif.model.Sala;
import java.util.List;

public class SalaAdapter extends RecyclerView.Adapter<SalaAdapter.SalaViewHolder> {
    private final Context context;
    private final List<Sala> salas;
    private final String localizacao;

    // Guarda as informações recebidas.
    public SalaAdapter(Context context, List<Sala> salas, String localizacao) {
        this.context = context;
        this.salas = salas;
        this.localizacao = localizacao;
    }

    // Cria o visual de cada sala.
    @Override
    public SalaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sala, parent, false);
        return new SalaViewHolder(view);
    }

    // Mostra as informações de cada sala.
    @Override
    public void onBindViewHolder(@NonNull SalaViewHolder holder, int position) {
        Sala sala = salas.get(position);
        holder.txtTitulo.setText(sala.getTitulo());
        holder.txtSubtitulo.setText(sala.getSubtitulo());
        holder.imgIcone.setImageResource(sala.getIcone());

        // Abre a sala escolhida.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetalheSalaActivity.class);
                intent.putExtra("salaId", sala.getId());
                intent.putExtra("localizacao", localizacao);
                context.startActivity(intent);
            }
        });
    }

    // Retorna o total de salas.
    @Override
    public int getItemCount() {
        return salas.size();
    }

    // Liga os dados da sala aos itens da tela.
    static class SalaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcone;
        TextView txtTitulo;
        TextView txtSubtitulo;
        SalaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcone = itemView.findViewById(R.id.imgIconeSala);
            txtTitulo = itemView.findViewById(R.id.txtTituloSala);
            txtSubtitulo = itemView.findViewById(R.id.txtSubtituloSala);
        }
    }
}

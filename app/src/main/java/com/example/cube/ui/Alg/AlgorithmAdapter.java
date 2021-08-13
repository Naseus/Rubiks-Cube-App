package com.example.cube.ui.Alg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cube.R;
import com.example.cube.models.Algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ViewHolder> {

    List<Algorithm> data = new ArrayList<Algorithm>();
    Context context;

    public AlgorithmAdapter(Context context, List<Algorithm> algs) {
            this.context = context;
            this.data = algs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View algView = LayoutInflater.from(context).inflate(R.layout.item_alg, parent, false);
        return new ViewHolder(algView);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Algorithm alg = data.get(position);
        holder.bind(alg, context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout container;
        TextView tvAlgName;
        TextView tvMoves;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvAlgName = itemView.findViewById(R.id.tvAlgName);
            tvMoves = itemView.findViewById(R.id.tvMoves);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Algorithm alg, Context context) {
            tvAlgName.setText(alg.getAlgName());
            tvMoves.setText(alg.getMoves());
        }
    }
}

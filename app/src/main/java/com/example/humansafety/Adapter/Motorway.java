package com.example.humansafety.Adapter;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class Motorway extends FirebaseRecyclerAdapter<Motorway_model,Motorway.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Motorway(@NonNull FirebaseRecyclerOptions<Motorway_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Motorway.ViewHolder holder, int position, @NonNull Motorway_model model) {
        holder.ID.setText(model.getUser());
        holder.Num.setText(model.getNumber());


    }

    @NonNull
    @Override
    public Motorway.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.motorway_item,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView ID;
        TextView Num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID=itemView.findViewById(R.id.MI_TV_ID);
            Num=itemView.findViewById(R.id.MI_TV_Number);

        }
    }
}

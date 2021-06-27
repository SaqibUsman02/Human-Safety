package com.example.humansafety.Adapter;

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

public class Rescue_Adapter extends FirebaseRecyclerAdapter<Motorway_model,Rescue_Adapter.ViewHolder> {

    /**
     * Initialize a {@link androidx.recyclerview.widget.RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link com.firebase.ui.database.FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Rescue_Adapter(@NonNull FirebaseRecyclerOptions<Motorway_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Rescue_Adapter.ViewHolder holder, int position, @NonNull Motorway_model model) {
        holder.ID.setText(model.getUser());
        holder.Num.setText(model.getNumber());


    }

    @NonNull
    @Override
    public Rescue_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.motorway_item,parent,false);
        return new Rescue_Adapter.ViewHolder(view);
    }  public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView ID;
        TextView Num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID=itemView.findViewById(R.id.MI_TV_ID);
            Num=itemView.findViewById(R.id.MI_TV_Number);

        }
    }
}


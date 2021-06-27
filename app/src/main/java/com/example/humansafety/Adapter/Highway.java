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

public class Highway extends FirebaseRecyclerAdapter<Motorway_model,Highway.ViewHolder> {

/**
 * Initialize a {@link androidx.recyclerview.widget.RecyclerView.Adapter} that listens to a Firebase query. See
 * {@link com.firebase.ui.database.FirebaseRecyclerOptions} for configuration options.
 *
 * @param options
 */
public Highway(@NonNull FirebaseRecyclerOptions<Motorway_model> options) {
        super(options);
        }

@Override
protected void onBindViewHolder(@NonNull Highway.ViewHolder holder, int position, @NonNull Motorway_model model) {
        holder.ID.setText(model.getUser());
        holder.Num.setText(model.getNumber());


        }

@NonNull
@Override
public Highway.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.motorway_item,parent,false);
        return new ViewHolder(view);
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

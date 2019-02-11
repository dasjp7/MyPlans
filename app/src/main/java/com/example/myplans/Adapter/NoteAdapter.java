package com.example.myplans.Adapter;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myplans.R;
import com.example.myplans.model.Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NoteAdapter extends FirestoreRecyclerAdapter<Model,NoteAdapter.NoteHolder> {
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Model model) {
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        holder.priority.setText(String.valueOf(model.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,
                viewGroup, false);
        return new NoteHolder(v);
    }
    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder
     {
         TextView title,desc,priority;

         public NoteHolder(View itemView) {
             super(itemView);
             title = itemView.findViewById(R.id.text_view_title);
             desc = itemView.findViewById(R.id.text_view_description);
             priority = itemView.findViewById(R.id.text_view_priority);
         }
     }
}

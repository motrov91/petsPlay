package com.example.ingmanuel.petsplay.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.R;

import java.util.List;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.PetsViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Pet> data;

    private OnItemClickListener listener;

    public PetsAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PetsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.item_pets, viewGroup, false);

        return new PetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetsViewHolder holder, int i) {
        if (data != null){
            final Pet current = data.get(i);
            holder.txtNamePet.setText(current.getNamePet());
        }else {
            holder.txtNamePet.setText("No pets");
        }
    }

    public void setData(List<Pet> newData){
        this.data = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (data != null){
            return data.size();
        }else {
            return 0;
        }
    }

    public class PetsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPet;
        TextView txtNamePet;
        LinearLayout linear;

        public PetsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPet = itemView.findViewById(R.id.imagePet);
            txtNamePet = itemView.findViewById(R.id.txtName);
            linear = itemView.findViewById(R.id.LinearItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null){
                        listener.onItemClick(data.get(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Pet pet);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


}

package com.example.airrq.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airrq.databinding.AirItemBinding;
import com.example.airrq.viewmodel.RecyclerViewModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<RecyclerViewModel> listModel;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(List<RecyclerViewModel> listModel) {
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        AirItemBinding airItemBinding = AirItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(airItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewModel myRecyclerModel = listModel.get(position);
        holder.bind(myRecyclerModel);
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AirItemBinding myAirItemBinding;

        public ViewHolder(@NonNull AirItemBinding myAirItemBinding) {
            super(myAirItemBinding.getRoot());
            this.myAirItemBinding = myAirItemBinding;
        }

        public void bind(RecyclerViewModel recyclerViewModel){
            this.myAirItemBinding.setViewmodel(recyclerViewModel);
        }
    }
}

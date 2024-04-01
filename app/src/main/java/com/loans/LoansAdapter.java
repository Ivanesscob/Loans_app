package com.loans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loans.databinding.LoanItemBinding;

import java.util.List;

public class LoansAdapter extends RecyclerView.Adapter<LoansAdapter.LoansViewHolder> {

    private Context context;

    public LoansAdapter(Context context, List<DataLoans> dataText) {
        this.context = context;
        this.dataText = dataText;
    }

    private List<DataLoans> dataText;
    public LoansAdapter(List<DataLoans> dataText) {
        this.dataText = dataText;
    }

    @NonNull
    @Override
    public LoansViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var binding = LayoutInflater.from(parent.getContext()).inflate(R.layout.loan_item, parent, false);
        LoansViewHolder holder = new LoansViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoansViewHolder holder, int position) {
        var text = dataText.get(position);
        holder.binding.firstNameText.setText(text.getFirst_name());
        holder.binding.lastNameText.setText(text.getLast_name());
        holder.binding.moneyText.setText(text.getMoney());
        holder.binding.dateText.setText(text.getDate());
    }

    @Override
    public int getItemCount() {
        return dataText.size();
    }

    class LoansViewHolder extends RecyclerView.ViewHolder{

        public LoanItemBinding binding;



        public LoansViewHolder(View view) {
            super(view);
            binding = LoanItemBinding.bind(view);

        }
    }
}

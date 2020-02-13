package com.parity.assignment.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.parity.assignment.R;
import com.parity.assignment.model.DealsData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DealsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DealsData> dealsList;
    private Context context;
    private SimpleDateFormat sdf;
    private final int VIEW_TYPE_LOADING = 0;
    private final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoadingVisible;

    public DealsAdapter(Context context, ArrayList<DealsData> dealsList) {
        this.context = context;
        this.dealsList = dealsList;
        sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_LOADING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_progressbar, parent, false);
                return new ProgressViewHolder(view);

            case VIEW_TYPE_NORMAL:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deals, parent, false);
                return new DealsViewHolder(view);
        }
        return new DealsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_LOADING:
                ProgressViewHolder progressViewHolder = (ProgressViewHolder) holder;
                break;

            case VIEW_TYPE_NORMAL:
                DealsViewHolder dealsViewHolder = (DealsViewHolder) holder;
                Glide.with(context)
                        .load(dealsList.get(position).getImage())
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .into(dealsViewHolder.ivPicture);

                dealsViewHolder.tvTitle.setText(dealsList.get(position).getTitle());
                dealsViewHolder.tvNoOfLikes.setText(String.valueOf(dealsList.get(position).getVoteCount()));
                dealsViewHolder.tvComments.setText(String.valueOf(dealsList.get(position).getCommentsCount()));
                dealsViewHolder.tvDate.setText(sdf.format(dealsList.get(position).getCreatedAt()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dealsList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (isLoadingVisible) {
            return position == dealsList.size() - 1 && isLoadingVisible? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
//        } else {
//            return VIEW_TYPE_NORMAL;
//        }
    }

    public void showLoading() {
        isLoadingVisible = true;
        dealsList.add(new DealsData());
        notifyItemInserted(dealsList.size() - 1);
    }

    public void hideLoading() {
        isLoadingVisible = false;
        int position = dealsList.size() - 1;
        DealsData item = getItem(position);
        if (item != null) {
            dealsList.remove(position);
            notifyItemRemoved(position);
        }
    }

    private DealsData getItem(int position) {
        return dealsList.get(position);
    }

    protected class DealsViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPicture;
        private TextView tvTitle, tvNoOfLikes, tvComments, tvDate;

        DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.ivPicture);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvNoOfLikes = itemView.findViewById(R.id.tvNoOfLikes);
            tvComments = itemView.findViewById(R.id.tvComments);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }

    protected class ProgressViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;

        ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}

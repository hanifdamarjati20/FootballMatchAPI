package com.hanip.footballmatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hanip.footballmatch.R;
import com.hanip.footballmatch.model.ModelPastEvent;
import com.hanip.footballmatch.networking.ApiEndPoint2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class PastEventAdapter extends RecyclerView.Adapter<PastEventAdapter.ViewHolder> {

    private List<ModelPastEvent> items;
    private PastEventAdapter.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelPastEvent modelNextEvent);
    }

    public PastEventAdapter(Context context, List<ModelPastEvent> items, PastEventAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public PastEventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_film, parent, false);
        return new PastEventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PastEventAdapter.ViewHolder holder, int position) {
        final ModelPastEvent data = items.get(position);

        holder.tvEvent.setText(data.getEvent());
        holder.tvVenue.setText(data.getVenue());
        holder.tvFileName.setText(data.getFileName());

        Glide.with(mContext)
                .load(ApiEndPoint2.URLIMAGE + data.getThumb())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_image)
                        .transform(new RoundedCorners(16)))
                .into(holder.imgPhoto);

        holder.cvFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Class Holder
    class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cvFootball;
        public ImageView imgPhoto;
        public TextView tvEvent;
        public TextView tvVenue;
        public TextView tvFileName;

        public ViewHolder(View itemView) {
            super(itemView);
            cvFootball = itemView.findViewById(R.id.cvFootball);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            tvEvent = itemView.findViewById(R.id.tvEvent);
            tvVenue = itemView.findViewById(R.id.tvVenue);
            tvFileName = itemView.findViewById(R.id.tvFileName);
        }
    }
}
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
import com.hanip.footballmatch.model.ModelNextEvent;
import com.hanip.footballmatch.networking.ApiEndPoint2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class NextEventAdapter extends RecyclerView.Adapter<NextEventAdapter.ViewHolder> {

    private List<ModelNextEvent> items;
    private NextEventAdapter.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelNextEvent modelNextEvent);
    }

    public NextEventAdapter(Context context, List<ModelNextEvent> items, NextEventAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public NextEventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_film, parent, false);
        return new NextEventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NextEventAdapter.ViewHolder holder, int position) {
        final ModelNextEvent data = items.get(position);

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
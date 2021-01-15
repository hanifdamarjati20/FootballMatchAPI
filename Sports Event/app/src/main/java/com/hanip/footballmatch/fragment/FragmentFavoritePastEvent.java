package com.hanip.footballmatch.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hanip.footballmatch.R;
import com.hanip.footballmatch.activities.DetailPastEventActivity;
import com.hanip.footballmatch.adapter.PastEventAdapter;
import com.hanip.footballmatch.model.ModelPastEvent;
import com.hanip.footballmatch.realm.RealmHelper2;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoritePastEvent extends Fragment implements PastEventAdapter.onSelectData {

    private RecyclerView rvEventFav;
    private List<ModelPastEvent> modelPastEvent = new ArrayList<>();
    private RealmHelper2 helper;
    private TextView txtNoData;

    public FragmentFavoritePastEvent() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite_film, container, false);

        helper = new RealmHelper2(getActivity());

        txtNoData = rootView.findViewById(R.id.tvNotFound);
        rvEventFav = rootView.findViewById(R.id.rvEventFav);
        rvEventFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvEventFav.setAdapter(new PastEventAdapter(getActivity(), modelPastEvent, this));
        rvEventFav.setHasFixedSize(true);

        setData();

        return rootView;
    }

    private void setData() {
        modelPastEvent = helper.showFavoritePastEvent();
        if (modelPastEvent.size() == 0) {
            txtNoData.setVisibility(View.VISIBLE);
            rvEventFav.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            rvEventFav.setVisibility(View.VISIBLE);
            rvEventFav.setAdapter(new PastEventAdapter(getActivity(), modelPastEvent, this));
        }
    }

    @Override
    public void onSelected(ModelPastEvent modelPastEvent) {
        Intent intent = new Intent(getActivity(), DetailPastEventActivity.class);
        intent.putExtra("detailPastEvent", modelPastEvent);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }
}
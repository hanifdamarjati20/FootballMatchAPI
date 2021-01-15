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
import com.hanip.footballmatch.activities.DetailNextEventActivity;
import com.hanip.footballmatch.adapter.NextEventAdapter;
import com.hanip.footballmatch.model.ModelNextEvent;
import com.hanip.footballmatch.realm.RealmHelper2;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoriteNextEvent extends Fragment implements NextEventAdapter.onSelectData {

    private RecyclerView rvEventFav;
    private List<ModelNextEvent> modelNextEvent = new ArrayList<>();
    private RealmHelper2 helper;
    private TextView txtNoData;

    public FragmentFavoriteNextEvent() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite_film, container, false);

        helper = new RealmHelper2(getActivity());

        txtNoData = rootView.findViewById(R.id.tvNotFound);
        rvEventFav = rootView.findViewById(R.id.rvEventFav);
        rvEventFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvEventFav.setAdapter(new NextEventAdapter(getActivity(), modelNextEvent, this));
        rvEventFav.setHasFixedSize(true);

        setData();

        return rootView;
    }

    private void setData() {
        modelNextEvent = helper.showFavoriteNextEvent();
        if (modelNextEvent.size() == 0) {
            txtNoData.setVisibility(View.VISIBLE);
            rvEventFav.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            rvEventFav.setVisibility(View.VISIBLE);
            rvEventFav.setAdapter(new NextEventAdapter(getActivity(), modelNextEvent, this));
        }
    }

    @Override
    public void onSelected(ModelNextEvent modelNextEvent) {
        Intent intent = new Intent(getActivity(), DetailNextEventActivity.class);
        intent.putExtra("detailNextEvent", modelNextEvent);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }
}
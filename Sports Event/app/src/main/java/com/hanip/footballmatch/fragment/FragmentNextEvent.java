package com.hanip.footballmatch.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.hanip.footballmatch.R;
import com.hanip.footballmatch.activities.DetailNextEventActivity;
import com.hanip.footballmatch.adapter.NextEventAdapter;
import com.hanip.footballmatch.model.ModelNextEvent;
import com.hanip.footballmatch.networking.ApiEndPoint2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentNextEvent extends Fragment implements NextEventAdapter.onSelectData {

    private RecyclerView rvFilmRecommend;
    private NextEventAdapter nextEventAdapter;
    private ProgressDialog progressDialog;
    private SearchView searchFilm;
    private List<ModelNextEvent> nextEvent = new ArrayList<>();

    public FragmentNextEvent() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data");

        searchFilm = rootView.findViewById(R.id.searchEvent);
        searchFilm.setQueryHint(getString(R.string.search_film));
        searchFilm.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                setSearchNextEvent(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equals(""))
                    getNextEvent();
                return false;
            }
        });

        int searchPlateId = searchFilm.getContext().getResources()
                .getIdentifier("android:id/search_plate", null, null);
        View searchPlate = searchFilm.findViewById(searchPlateId);
        if (searchPlate != null) {
            searchPlate.setBackgroundColor(Color.TRANSPARENT);
        }

        rvFilmRecommend = rootView.findViewById(R.id.rvEvent);
        rvFilmRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilmRecommend.setHasFixedSize(true);

        getNextEvent();

        return rootView;
    }

    private void setSearchNextEvent(String query) {
        progressDialog.show();
        AndroidNetworking.get(ApiEndPoint2.BASEURL + ApiEndPoint2.SEARCH_EVENT + ApiEndPoint2.QUERY + query)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                            nextEvent = new ArrayList<>();
                            JSONArray jsonArray = response.getJSONArray("event");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                ModelNextEvent dataApi = new ModelNextEvent();

                                dataApi.setIdEvent(jsonObject.getInt("idEvent"));
                                dataApi.setEvent(jsonObject.getString("strEvent"));
                                dataApi.setFileName(jsonObject.getString("strFileName"));
                                dataApi.setVenue(jsonObject.getString("strVenue"));
                                dataApi.setThumb(jsonObject.getString("strThumb"));
                                dataApi.setCountry(jsonObject.getString("strCountry"));
                                nextEvent.add(dataApi);
                                showNextEvent();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getNextEvent() {
        progressDialog.show();
        AndroidNetworking.get(ApiEndPoint2.BASEURL + ApiEndPoint2.NEXT_EVENT)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                            nextEvent = new ArrayList<>();
                            JSONArray jsonArray = response.getJSONArray("events");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                ModelNextEvent dataApi = new ModelNextEvent();

                                dataApi.setIdEvent(jsonObject.getInt("idEvent"));
                                dataApi.setEvent(jsonObject.getString("strEvent"));
                                dataApi.setFileName(jsonObject.getString("strFileName"));
                                dataApi.setVenue(jsonObject.getString("strVenue"));
                                dataApi.setThumb(jsonObject.getString("strThumb"));
                                dataApi.setCountry(jsonObject.getString("strCountry"));
                                nextEvent.add(dataApi);
                                showNextEvent();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showNextEvent() {
        nextEventAdapter = new NextEventAdapter(getActivity(), nextEvent, this);
        rvFilmRecommend.setAdapter(nextEventAdapter);
        nextEventAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSelected(ModelNextEvent modelNextEvent) {
        Intent intent = new Intent(getActivity(), DetailNextEventActivity.class);
        intent.putExtra("detailNextActivity", modelNextEvent);
        startActivity(intent);
    }
}
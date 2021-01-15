package com.hanip.footballmatch.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hanip.footballmatch.R;
import com.hanip.footballmatch.model.ModelNextEvent;
import com.hanip.footballmatch.networking.ApiEndPoint2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.snackbar.Snackbar;
import com.hanip.footballmatch.realm.RealmHelper2;

public class DetailNextEventActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvEvent, tvName, tvStadion2, tvNegara2, tvOverview;
    ImageView imgPhoto;
    MaterialFavoriteButton imgFavorite;
    String NameFilm, Venue, Country, Overview, Thumbnail, movieURL;
    int IdEvent;
    ModelNextEvent modelNextEvent;
    ProgressDialog progressDialog;
    RealmHelper2 helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Mohon Tunggu Sebentar");

        imgPhoto = findViewById(R.id.imgPhoto);
        imgFavorite = findViewById(R.id.imgFavorite);
        tvEvent = findViewById(R.id.tvEvent);
        tvName = findViewById(R.id.tvName);
        tvStadion2 = findViewById(R.id.tvStadion2);
        tvNegara2 = findViewById(R.id.tvNegara2);
        tvOverview = findViewById(R.id.tvOverview);

        helper = new RealmHelper2(this);

        modelNextEvent = (ModelNextEvent) getIntent().getSerializableExtra("detailNextEvent");
        if (modelNextEvent != null) {

            IdEvent = modelNextEvent.getIdEvent();
            NameFilm = modelNextEvent.getEvent();
            Venue = modelNextEvent.getVenue();
            Country = modelNextEvent.getCountry();
            Overview = modelNextEvent.getFileName();
            Thumbnail = modelNextEvent.getThumb();
            movieURL = ApiEndPoint2.URLFILM + "" + IdEvent;

            tvEvent.setText(NameFilm);
            tvName.setText(NameFilm);
            tvStadion2.setText(Venue);
            tvNegara2.setText(Country);
            tvOverview.setText(Overview);
            tvEvent.setSelected(true);
            tvName.setSelected(true);

            Glide.with(this)
                    .load(ApiEndPoint2.URLIMAGE + Thumbnail)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgPhoto);
        }

        imgFavorite.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            IdEvent = modelNextEvent.getIdEvent();
                            NameFilm = modelNextEvent.getEvent();
                            Overview = modelNextEvent.getFileName();
                            Venue = modelNextEvent.getVenue();
                            Thumbnail = modelNextEvent.getThumb();
                            Country = modelNextEvent.getCountry();
                            helper.addFavoriteNextEvent(IdEvent, NameFilm, Overview, Venue, Thumbnail, Country);
                            Snackbar.make(buttonView, modelNextEvent.getEvent() + " Added to Favorite",
                                    Snackbar.LENGTH_SHORT).show();
                        } else {
                            helper.deleteFavoriteNextEvent(modelNextEvent.getIdEvent());
                            Snackbar.make(buttonView, modelNextEvent.getIdEvent() + " Removed from Favorite",
                                    Snackbar.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        window.setAttributes(winParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

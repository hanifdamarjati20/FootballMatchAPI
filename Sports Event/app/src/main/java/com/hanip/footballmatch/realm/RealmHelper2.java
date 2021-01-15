package com.hanip.footballmatch.realm;

import android.content.Context;

import com.hanip.footballmatch.model.ModelNextEvent;
import com.hanip.footballmatch.model.ModelPastEvent;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmHelper2 {

    private Context mContext;
    private Realm realm;
    private RealmResults<ModelNextEvent> modelNextEvent;
    private RealmResults<ModelPastEvent> modelPastEvent;

    public RealmHelper2(Context mContext) {
        this.mContext = mContext;
        Realm.init(mContext);
        realm = Realm.getDefaultInstance();
    }

    public ArrayList<ModelNextEvent> showFavoriteNextEvent() {
        ArrayList<ModelNextEvent> data = new ArrayList<>();
        modelNextEvent = realm.where(ModelNextEvent.class).findAll();

        if (modelNextEvent.size() > 0) {
            for (int i = 0; i < modelNextEvent.size(); i++) {
                ModelNextEvent next = new ModelNextEvent();
                next.setIdEvent(modelNextEvent.get(i).getIdEvent());
                next.setEvent(modelNextEvent.get(i).getEvent());
                next.setFileName(modelNextEvent.get(i).getFileName());
                next.setVenue(modelNextEvent.get(i).getVenue());
                next.setThumb(modelNextEvent.get(i).getThumb());
                next.setCountry(modelNextEvent.get(i).getCountry());
                data.add(next);
            }
        }
        return data;
    }

    public ArrayList<ModelPastEvent> showFavoritePastEvent() {
        ArrayList<ModelPastEvent> data = new ArrayList<>();
        modelPastEvent = realm.where(ModelPastEvent.class).findAll();

        if (modelPastEvent.size() > 0) {
            for (int i = 0; i < modelPastEvent.size(); i++) {
                ModelPastEvent past = new ModelPastEvent();
                past.setIdEvent(modelPastEvent.get(i).getIdEvent());
                past.setEvent(modelPastEvent.get(i).getEvent());
                past.setFileName(modelPastEvent.get(i).getFileName());
                past.setVenue(modelPastEvent.get(i).getVenue());
                past.setThumb(modelPastEvent.get(i).getThumb());
                past.setCountry(modelPastEvent.get(i).getCountry());
                data.add(past);
            }
        }
        return data;
    }

    public void addFavoriteNextEvent(int IdEvent, String Event, String FileName,
                                     String Venue, String Thumb, String Country) {
        ModelNextEvent next = new ModelNextEvent();
        next.setIdEvent(IdEvent);
        next.setEvent(Event);
        next.setFileName(FileName);
        next.setVenue(Venue);
        next.setThumb(Thumb);
        next.setCountry(Country);

        realm.beginTransaction();
        realm.copyToRealm(next);
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
    }

    public void addFavoritePastEvent(int IdEvent, String Event, String FileName,
                                     String Venue, String Thumb, String Country) {
        ModelPastEvent past = new ModelPastEvent();
        past.setIdEvent(IdEvent);
        past.setEvent(Event);
        past.setFileName(FileName);
        past.setVenue(Venue);
        past.setThumb(Thumb);
        past.setCountry(Country);

        realm.beginTransaction();
        realm.copyToRealm(past);
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
    }
    public void deleteFavoriteNextEvent(int idEvent) {
        realm.beginTransaction();
        RealmResults<ModelNextEvent> modelNextEvent = realm.where(ModelNextEvent.class).findAll();
        modelNextEvent.deleteAllFromRealm();
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    public void deleteFavoritePastEvent(int idEvent) {
        realm.beginTransaction();
        RealmResults<ModelPastEvent> modelPastEvent = realm.where(ModelPastEvent.class).findAll();
        modelPastEvent.deleteAllFromRealm();
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }
}
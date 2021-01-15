package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_hanip_footballmatch_model_ModelPastEventRealmProxy extends com.hanip.footballmatch.model.ModelPastEvent
    implements RealmObjectProxy, com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface {

    static final class ModelPastEventColumnInfo extends ColumnInfo {
        long IdEventIndex;
        long EventIndex;
        long FileNameIndex;
        long VenueIndex;
        long ThumbIndex;
        long CountryIndex;

        ModelPastEventColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ModelPastEvent");
            this.IdEventIndex = addColumnDetails("IdEvent", "IdEvent", objectSchemaInfo);
            this.EventIndex = addColumnDetails("Event", "Event", objectSchemaInfo);
            this.FileNameIndex = addColumnDetails("FileName", "FileName", objectSchemaInfo);
            this.VenueIndex = addColumnDetails("Venue", "Venue", objectSchemaInfo);
            this.ThumbIndex = addColumnDetails("Thumb", "Thumb", objectSchemaInfo);
            this.CountryIndex = addColumnDetails("Country", "Country", objectSchemaInfo);
        }

        ModelPastEventColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ModelPastEventColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ModelPastEventColumnInfo src = (ModelPastEventColumnInfo) rawSrc;
            final ModelPastEventColumnInfo dst = (ModelPastEventColumnInfo) rawDst;
            dst.IdEventIndex = src.IdEventIndex;
            dst.EventIndex = src.EventIndex;
            dst.FileNameIndex = src.FileNameIndex;
            dst.VenueIndex = src.VenueIndex;
            dst.ThumbIndex = src.ThumbIndex;
            dst.CountryIndex = src.CountryIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ModelPastEventColumnInfo columnInfo;
    private ProxyState<com.hanip.footballmatch.model.ModelPastEvent> proxyState;

    com_hanip_footballmatch_model_ModelPastEventRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ModelPastEventColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.hanip.footballmatch.model.ModelPastEvent>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$IdEvent() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.IdEventIndex);
    }

    @Override
    public void realmSet$IdEvent(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.IdEventIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.IdEventIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Event() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EventIndex);
    }

    @Override
    public void realmSet$Event(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EventIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EventIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EventIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EventIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FileName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FileNameIndex);
    }

    @Override
    public void realmSet$FileName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FileNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FileNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FileNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FileNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Venue() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VenueIndex);
    }

    @Override
    public void realmSet$Venue(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.VenueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.VenueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.VenueIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.VenueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Thumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ThumbIndex);
    }

    @Override
    public void realmSet$Thumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ThumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ThumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ThumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ThumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Country() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CountryIndex);
    }

    @Override
    public void realmSet$Country(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CountryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CountryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CountryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CountryIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ModelPastEvent", 6, 0);
        builder.addPersistedProperty("IdEvent", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Event", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FileName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Venue", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Thumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Country", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ModelPastEventColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ModelPastEventColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ModelPastEvent";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ModelPastEvent";
    }

    @SuppressWarnings("cast")
    public static com.hanip.footballmatch.model.ModelPastEvent createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.hanip.footballmatch.model.ModelPastEvent obj = realm.createObjectInternal(com.hanip.footballmatch.model.ModelPastEvent.class, true, excludeFields);

        final com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface objProxy = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) obj;
        if (json.has("IdEvent")) {
            if (json.isNull("IdEvent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'IdEvent' to null.");
            } else {
                objProxy.realmSet$IdEvent((int) json.getInt("IdEvent"));
            }
        }
        if (json.has("Event")) {
            if (json.isNull("Event")) {
                objProxy.realmSet$Event(null);
            } else {
                objProxy.realmSet$Event((String) json.getString("Event"));
            }
        }
        if (json.has("FileName")) {
            if (json.isNull("FileName")) {
                objProxy.realmSet$FileName(null);
            } else {
                objProxy.realmSet$FileName((String) json.getString("FileName"));
            }
        }
        if (json.has("Venue")) {
            if (json.isNull("Venue")) {
                objProxy.realmSet$Venue(null);
            } else {
                objProxy.realmSet$Venue((String) json.getString("Venue"));
            }
        }
        if (json.has("Thumb")) {
            if (json.isNull("Thumb")) {
                objProxy.realmSet$Thumb(null);
            } else {
                objProxy.realmSet$Thumb((String) json.getString("Thumb"));
            }
        }
        if (json.has("Country")) {
            if (json.isNull("Country")) {
                objProxy.realmSet$Country(null);
            } else {
                objProxy.realmSet$Country((String) json.getString("Country"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.hanip.footballmatch.model.ModelPastEvent createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.hanip.footballmatch.model.ModelPastEvent obj = new com.hanip.footballmatch.model.ModelPastEvent();
        final com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface objProxy = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("IdEvent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IdEvent((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'IdEvent' to null.");
                }
            } else if (name.equals("Event")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Event((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Event(null);
                }
            } else if (name.equals("FileName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FileName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FileName(null);
                }
            } else if (name.equals("Venue")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Venue((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Venue(null);
                }
            } else if (name.equals("Thumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Thumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Thumb(null);
                }
            } else if (name.equals("Country")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Country((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Country(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.hanip.footballmatch.model.ModelPastEvent copyOrUpdate(Realm realm, com.hanip.footballmatch.model.ModelPastEvent object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.hanip.footballmatch.model.ModelPastEvent) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.hanip.footballmatch.model.ModelPastEvent copy(Realm realm, com.hanip.footballmatch.model.ModelPastEvent newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.hanip.footballmatch.model.ModelPastEvent) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.hanip.footballmatch.model.ModelPastEvent realmObject = realm.createObjectInternal(com.hanip.footballmatch.model.ModelPastEvent.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface realmObjectSource = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) newObject;
        com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface realmObjectCopy = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$IdEvent(realmObjectSource.realmGet$IdEvent());
        realmObjectCopy.realmSet$Event(realmObjectSource.realmGet$Event());
        realmObjectCopy.realmSet$FileName(realmObjectSource.realmGet$FileName());
        realmObjectCopy.realmSet$Venue(realmObjectSource.realmGet$Venue());
        realmObjectCopy.realmSet$Thumb(realmObjectSource.realmGet$Thumb());
        realmObjectCopy.realmSet$Country(realmObjectSource.realmGet$Country());
        return realmObject;
    }

    public static long insert(Realm realm, com.hanip.footballmatch.model.ModelPastEvent object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.hanip.footballmatch.model.ModelPastEvent.class);
        long tableNativePtr = table.getNativePtr();
        ModelPastEventColumnInfo columnInfo = (ModelPastEventColumnInfo) realm.getSchema().getColumnInfo(com.hanip.footballmatch.model.ModelPastEvent.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.IdEventIndex, rowIndex, ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$IdEvent(), false);
        String realmGet$Event = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Event();
        if (realmGet$Event != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EventIndex, rowIndex, realmGet$Event, false);
        }
        String realmGet$FileName = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$FileName();
        if (realmGet$FileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FileNameIndex, rowIndex, realmGet$FileName, false);
        }
        String realmGet$Venue = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Venue();
        if (realmGet$Venue != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VenueIndex, rowIndex, realmGet$Venue, false);
        }
        String realmGet$Thumb = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Thumb();
        if (realmGet$Thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ThumbIndex, rowIndex, realmGet$Thumb, false);
        }
        String realmGet$Country = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Country();
        if (realmGet$Country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CountryIndex, rowIndex, realmGet$Country, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.hanip.footballmatch.model.ModelPastEvent.class);
        long tableNativePtr = table.getNativePtr();
        ModelPastEventColumnInfo columnInfo = (ModelPastEventColumnInfo) realm.getSchema().getColumnInfo(com.hanip.footballmatch.model.ModelPastEvent.class);
        com.hanip.footballmatch.model.ModelPastEvent object = null;
        while (objects.hasNext()) {
            object = (com.hanip.footballmatch.model.ModelPastEvent) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.IdEventIndex, rowIndex, ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$IdEvent(), false);
            String realmGet$Event = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Event();
            if (realmGet$Event != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EventIndex, rowIndex, realmGet$Event, false);
            }
            String realmGet$FileName = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$FileName();
            if (realmGet$FileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FileNameIndex, rowIndex, realmGet$FileName, false);
            }
            String realmGet$Venue = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Venue();
            if (realmGet$Venue != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VenueIndex, rowIndex, realmGet$Venue, false);
            }
            String realmGet$Thumb = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Thumb();
            if (realmGet$Thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ThumbIndex, rowIndex, realmGet$Thumb, false);
            }
            String realmGet$Country = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Country();
            if (realmGet$Country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CountryIndex, rowIndex, realmGet$Country, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.hanip.footballmatch.model.ModelPastEvent object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.hanip.footballmatch.model.ModelPastEvent.class);
        long tableNativePtr = table.getNativePtr();
        ModelPastEventColumnInfo columnInfo = (ModelPastEventColumnInfo) realm.getSchema().getColumnInfo(com.hanip.footballmatch.model.ModelPastEvent.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.IdEventIndex, rowIndex, ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$IdEvent(), false);
        String realmGet$Event = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Event();
        if (realmGet$Event != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EventIndex, rowIndex, realmGet$Event, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EventIndex, rowIndex, false);
        }
        String realmGet$FileName = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$FileName();
        if (realmGet$FileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FileNameIndex, rowIndex, realmGet$FileName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FileNameIndex, rowIndex, false);
        }
        String realmGet$Venue = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Venue();
        if (realmGet$Venue != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VenueIndex, rowIndex, realmGet$Venue, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.VenueIndex, rowIndex, false);
        }
        String realmGet$Thumb = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Thumb();
        if (realmGet$Thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ThumbIndex, rowIndex, realmGet$Thumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ThumbIndex, rowIndex, false);
        }
        String realmGet$Country = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Country();
        if (realmGet$Country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CountryIndex, rowIndex, realmGet$Country, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CountryIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.hanip.footballmatch.model.ModelPastEvent.class);
        long tableNativePtr = table.getNativePtr();
        ModelPastEventColumnInfo columnInfo = (ModelPastEventColumnInfo) realm.getSchema().getColumnInfo(com.hanip.footballmatch.model.ModelPastEvent.class);
        com.hanip.footballmatch.model.ModelPastEvent object = null;
        while (objects.hasNext()) {
            object = (com.hanip.footballmatch.model.ModelPastEvent) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.IdEventIndex, rowIndex, ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$IdEvent(), false);
            String realmGet$Event = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Event();
            if (realmGet$Event != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EventIndex, rowIndex, realmGet$Event, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EventIndex, rowIndex, false);
            }
            String realmGet$FileName = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$FileName();
            if (realmGet$FileName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FileNameIndex, rowIndex, realmGet$FileName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FileNameIndex, rowIndex, false);
            }
            String realmGet$Venue = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Venue();
            if (realmGet$Venue != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VenueIndex, rowIndex, realmGet$Venue, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.VenueIndex, rowIndex, false);
            }
            String realmGet$Thumb = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Thumb();
            if (realmGet$Thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ThumbIndex, rowIndex, realmGet$Thumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ThumbIndex, rowIndex, false);
            }
            String realmGet$Country = ((com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) object).realmGet$Country();
            if (realmGet$Country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CountryIndex, rowIndex, realmGet$Country, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CountryIndex, rowIndex, false);
            }
        }
    }

    public static com.hanip.footballmatch.model.ModelPastEvent createDetachedCopy(com.hanip.footballmatch.model.ModelPastEvent realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.hanip.footballmatch.model.ModelPastEvent unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.hanip.footballmatch.model.ModelPastEvent();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.hanip.footballmatch.model.ModelPastEvent) cachedObject.object;
            }
            unmanagedObject = (com.hanip.footballmatch.model.ModelPastEvent) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface unmanagedCopy = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) unmanagedObject;
        com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface realmSource = (com_hanip_footballmatch_model_ModelPastEventRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$IdEvent(realmSource.realmGet$IdEvent());
        unmanagedCopy.realmSet$Event(realmSource.realmGet$Event());
        unmanagedCopy.realmSet$FileName(realmSource.realmGet$FileName());
        unmanagedCopy.realmSet$Venue(realmSource.realmGet$Venue());
        unmanagedCopy.realmSet$Thumb(realmSource.realmGet$Thumb());
        unmanagedCopy.realmSet$Country(realmSource.realmGet$Country());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ModelPastEvent = proxy[");
        stringBuilder.append("{IdEvent:");
        stringBuilder.append(realmGet$IdEvent());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Event:");
        stringBuilder.append(realmGet$Event() != null ? realmGet$Event() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FileName:");
        stringBuilder.append(realmGet$FileName() != null ? realmGet$FileName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Venue:");
        stringBuilder.append(realmGet$Venue() != null ? realmGet$Venue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Thumb:");
        stringBuilder.append(realmGet$Thumb() != null ? realmGet$Thumb() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Country:");
        stringBuilder.append(realmGet$Country() != null ? realmGet$Country() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_hanip_footballmatch_model_ModelPastEventRealmProxy aModelPastEvent = (com_hanip_footballmatch_model_ModelPastEventRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aModelPastEvent.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aModelPastEvent.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aModelPastEvent.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

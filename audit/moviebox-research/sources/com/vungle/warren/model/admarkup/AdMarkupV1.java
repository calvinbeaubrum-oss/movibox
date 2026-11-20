package com.vungle.warren.model.admarkup;

import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.vungle.warren.model.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class AdMarkupV1 extends AdMarkup {
    private final String eventId;

    private AdMarkupV1(String str, String[] strArr) {
        this.eventId = str;
        this.impressions = strArr;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004b  */
    @Nullable
    public static AdMarkupV1 fromString(String str) {
        ArrayList arrayList;
        if (str == null) {
            return null;
        }
        try {
            JsonObject jsonObject = (JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class);
            if (jsonObject == null) {
                return null;
            }
            if (l.e(jsonObject, "impression")) {
                JsonArray asJsonArray = jsonObject.getAsJsonArray("impression");
                if (asJsonArray.isJsonArray()) {
                    arrayList = new ArrayList();
                    Iterator<JsonElement> it = asJsonArray.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getAsString());
                    }
                } else {
                    arrayList = null;
                }
            } else {
                arrayList = null;
            }
            return new AdMarkupV1(l.d(jsonObject, "event_id", null), arrayList != null ? (String[]) arrayList.toArray(new String[0]) : null);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdMarkupV1.class != obj.getClass()) {
            return false;
        }
        String str = this.eventId;
        String str2 = ((AdMarkupV1) obj).eventId;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    @Override // com.vungle.warren.model.admarkup.AdMarkup
    public String getEventId() {
        return this.eventId;
    }

    @Override // com.vungle.warren.model.admarkup.AdMarkup
    public int getVersion() {
        return 1;
    }

    public int hashCode() {
        String str = this.eventId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "    AdMarkup {eventId='" + this.eventId + "', impression=" + Arrays.toString(this.impressions) + '}';
    }
}

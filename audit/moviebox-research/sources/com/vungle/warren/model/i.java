package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i implements com.vungle.warren.persistence.c<h> {
    public static String d(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb2 = new StringBuilder(strArr[0]);
        for (int i11 = 1; i11 < strArr.length; i11++) {
            sb2.append(";");
            sb2.append(strArr[i11]);
        }
        return sb2.toString();
    }

    public static String[] f(String str) {
        return str.isEmpty() ? new String[0] : str.split(";");
    }

    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "cache_bust";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public h c(ContentValues contentValues) {
        h hVar = new h();
        hVar.f62168a = contentValues.getAsString("id");
        hVar.f62169b = contentValues.getAsLong("time_window_end").longValue();
        hVar.f62170c = contentValues.getAsInteger("id_type").intValue();
        hVar.f62171d = f(contentValues.getAsString("event_ids"));
        hVar.f62172e = contentValues.getAsLong("timestamp_processed").longValue();
        return hVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ContentValues a(h hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", hVar.a());
        contentValues.put("id", hVar.f62168a);
        contentValues.put("time_window_end", Long.valueOf(hVar.f62169b));
        contentValues.put("id_type", Integer.valueOf(hVar.f62170c));
        contentValues.put("event_ids", d(hVar.f62171d));
        contentValues.put("timestamp_processed", Long.valueOf(hVar.f62172e));
        return contentValues;
    }
}

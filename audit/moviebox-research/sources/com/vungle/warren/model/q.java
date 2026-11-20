package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q implements com.vungle.warren.persistence.c<p> {
    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "session_data";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public p c(ContentValues contentValues) {
        return new p(contentValues.getAsString("json_string"), contentValues.getAsInteger("send_attempts").intValue());
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(p pVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", pVar.c());
        contentValues.put("json_string", pVar.b());
        contentValues.put("send_attempts", Integer.valueOf(pVar.d()));
        return contentValues;
    }
}

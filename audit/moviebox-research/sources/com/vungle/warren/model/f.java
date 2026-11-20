package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements com.vungle.warren.persistence.c<e> {
    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "analytic_url";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e c(ContentValues contentValues) {
        return new e(contentValues.getAsString("item_id"));
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", eVar.f62164a);
        return contentValues;
    }
}

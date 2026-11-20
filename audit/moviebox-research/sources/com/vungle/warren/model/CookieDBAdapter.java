package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class CookieDBAdapter implements com.vungle.warren.persistence.c<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f62111a = new GsonBuilder().create();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Type f62112b = new TypeToken<Map<String, Boolean>>() { // from class: com.vungle.warren.model.CookieDBAdapter.1
    }.getType();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Type f62113c = new TypeToken<Map<String, Integer>>() { // from class: com.vungle.warren.model.CookieDBAdapter.2
    }.getType();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f62114d = new TypeToken<Map<String, Long>>() { // from class: com.vungle.warren.model.CookieDBAdapter.3
    }.getType();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f62115e = new TypeToken<Map<String, String>>() { // from class: com.vungle.warren.model.CookieDBAdapter.4
    }.getType();

    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "cookie";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j c(ContentValues contentValues) {
        j jVar = new j(contentValues.getAsString("item_id"));
        jVar.f62174b = (Map) this.f62111a.fromJson(contentValues.getAsString("bools"), this.f62112b);
        jVar.f62176d = (Map) this.f62111a.fromJson(contentValues.getAsString("longs"), this.f62114d);
        jVar.f62175c = (Map) this.f62111a.fromJson(contentValues.getAsString("ints"), this.f62113c);
        jVar.f62173a = (Map) this.f62111a.fromJson(contentValues.getAsString("strings"), this.f62115e);
        return jVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", jVar.f62177e);
        contentValues.put("bools", this.f62111a.toJson(jVar.f62174b, this.f62112b));
        contentValues.put("ints", this.f62111a.toJson(jVar.f62175c, this.f62113c));
        contentValues.put("longs", this.f62111a.toJson(jVar.f62176d, this.f62114d));
        contentValues.put("strings", this.f62111a.toJson(jVar.f62173a, this.f62115e));
        return contentValues;
    }
}

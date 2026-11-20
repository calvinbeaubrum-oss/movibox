package com.android.volley;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final T f16521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final c.a f16522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final VolleyError f16523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16524d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void onResponse(T t11);
    }

    public i(VolleyError volleyError) {
        this.f16524d = false;
        this.f16521a = null;
        this.f16522b = null;
        this.f16523c = volleyError;
    }

    public i(@Nullable T t11, @Nullable c.a aVar) {
        this.f16524d = false;
        this.f16521a = t11;
        this.f16522b = aVar;
        this.f16523c = null;
    }

    public static <T> i<T> a(VolleyError volleyError) {
        return new i<>(volleyError);
    }

    public static <T> i<T> c(@Nullable T t11, @Nullable c.a aVar) {
        return new i<>(t11, aVar);
    }

    public boolean b() {
        return this.f16523c == null;
    }
}

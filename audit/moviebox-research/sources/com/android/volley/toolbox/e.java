package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.android.volley.e> f16572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final InputStream f16574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f16575e;

    public e(int i11, List<com.android.volley.e> list) {
        this(i11, list, -1, null);
    }

    public e(int i11, List<com.android.volley.e> list, int i12, InputStream inputStream) {
        this.f16571a = i11;
        this.f16572b = list;
        this.f16573c = i12;
        this.f16574d = inputStream;
        this.f16575e = null;
    }

    @Nullable
    public final InputStream a() {
        InputStream inputStream = this.f16574d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f16575e != null) {
            return new ByteArrayInputStream(this.f16575e);
        }
        return null;
    }

    public final int b() {
        return this.f16573c;
    }

    public final List<com.android.volley.e> c() {
        return Collections.unmodifiableList(this.f16572b);
    }

    public final int d() {
        return this.f16571a;
    }
}

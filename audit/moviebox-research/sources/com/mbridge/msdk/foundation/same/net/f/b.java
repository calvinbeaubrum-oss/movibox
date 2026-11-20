package com.mbridge.msdk.foundation.same.net.f;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f44602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.foundation.same.net.d.b> f44603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f44604c;

    public b(int i11, List<com.mbridge.msdk.foundation.same.net.d.b> list, InputStream inputStream) {
        this.f44604c = i11;
        this.f44603b = list;
        this.f44602a = inputStream;
    }

    public final InputStream a() {
        return this.f44602a;
    }

    public final List<com.mbridge.msdk.foundation.same.net.d.b> b() {
        return Collections.unmodifiableList(this.f44603b);
    }

    public final int c() {
        return this.f44604c;
    }
}

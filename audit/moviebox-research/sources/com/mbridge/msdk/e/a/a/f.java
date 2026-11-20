package com.mbridge.msdk.e.a.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f43746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.e.a.i> f43747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f43748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f43749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f43750e;

    public f(int i11, List<com.mbridge.msdk.e.a.i> list) {
        this(i11, list, -1, null);
    }

    public f(int i11, List<com.mbridge.msdk.e.a.i> list, int i12, InputStream inputStream) {
        this.f43746a = i11;
        this.f43747b = list;
        this.f43748c = i12;
        this.f43749d = inputStream;
        this.f43750e = null;
    }

    public final int a() {
        return this.f43746a;
    }

    public final List<com.mbridge.msdk.e.a.i> b() {
        return Collections.unmodifiableList(this.f43747b);
    }

    public final int c() {
        return this.f43748c;
    }

    public final InputStream d() {
        InputStream inputStream = this.f43749d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f43750e != null) {
            return new ByteArrayInputStream(this.f43750e);
        }
        return null;
    }
}

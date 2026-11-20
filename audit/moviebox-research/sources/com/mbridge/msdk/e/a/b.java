package com.mbridge.msdk.e.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f43769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f43770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f43771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f43772d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f43773e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f43774f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f43775g = Collections.emptyMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<i> f43776h;

        public final boolean a(long j11) {
            return this.f43773e < j11;
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);

    void a(String str, boolean z11);
}

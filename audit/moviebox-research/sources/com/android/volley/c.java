package com.android.volley;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f16490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f16492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f16493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f16494e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f16495f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f16496g = Collections.emptyMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<e> f16497h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        public boolean b(long j11) {
            return this.f16494e < j11;
        }

        public boolean c(long j11) {
            return this.f16495f < j11;
        }
    }

    @Nullable
    a a(String str);

    void b(String str, boolean z11);

    void c(String str, a aVar);

    void initialize();
}

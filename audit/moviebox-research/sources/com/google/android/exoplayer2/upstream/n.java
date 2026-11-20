package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.k1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f35422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f35425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f35426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f35427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f35428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f35429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f35430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f35431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Object f35432k;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f35433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f35434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f35436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f35437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f35438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f35439g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f35440h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f35441i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public Object f35442j;

        public b() {
            this.f35435c = 1;
            this.f35437e = Collections.emptyMap();
            this.f35439g = -1L;
        }

        public b(n nVar) {
            this.f35433a = nVar.f35422a;
            this.f35434b = nVar.f35423b;
            this.f35435c = nVar.f35424c;
            this.f35436d = nVar.f35425d;
            this.f35437e = nVar.f35426e;
            this.f35438f = nVar.f35428g;
            this.f35439g = nVar.f35429h;
            this.f35440h = nVar.f35430i;
            this.f35441i = nVar.f35431j;
            this.f35442j = nVar.f35432k;
        }

        public n a() {
            com.google.android.exoplayer2.util.a.j(this.f35433a, "The uri must be set.");
            return new n(this.f35433a, this.f35434b, this.f35435c, this.f35436d, this.f35437e, this.f35438f, this.f35439g, this.f35440h, this.f35441i, this.f35442j);
        }

        public b b(int i11) {
            this.f35441i = i11;
            return this;
        }

        public b c(@Nullable byte[] bArr) {
            this.f35436d = bArr;
            return this;
        }

        public b d(int i11) {
            this.f35435c = i11;
            return this;
        }

        public b e(Map<String, String> map) {
            this.f35437e = map;
            return this;
        }

        public b f(@Nullable String str) {
            this.f35440h = str;
            return this;
        }

        public b g(long j11) {
            this.f35439g = j11;
            return this;
        }

        public b h(long j11) {
            this.f35438f = j11;
            return this;
        }

        public b i(Uri uri) {
            this.f35433a = uri;
            return this;
        }

        public b j(String str) {
            this.f35433a = Uri.parse(str);
            return this;
        }

        public b k(long j11) {
            this.f35434b = j11;
            return this;
        }
    }

    static {
        k1.a("goog.exo.datasource");
    }

    public n(Uri uri) {
        this(uri, 0L, -1L);
    }

    public n(Uri uri, long j11, int i11, @Nullable byte[] bArr, Map<String, String> map, long j12, long j13, @Nullable String str, int i12, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j14 = j11 + j12;
        boolean z11 = true;
        com.google.android.exoplayer2.util.a.a(j14 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        if (j13 <= 0 && j13 != -1) {
            z11 = false;
        }
        com.google.android.exoplayer2.util.a.a(z11);
        this.f35422a = uri;
        this.f35423b = j11;
        this.f35424c = i11;
        this.f35425d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f35426e = Collections.unmodifiableMap(new HashMap(map));
        this.f35428g = j12;
        this.f35427f = j14;
        this.f35429h = j13;
        this.f35430i = str;
        this.f35431j = i12;
        this.f35432k = obj;
    }

    public n(Uri uri, long j11, long j12) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j11, j12, null, 0, null);
    }

    public static String c(int i11) {
        if (i11 == 1) {
            return "GET";
        }
        if (i11 == 2) {
            return "POST";
        }
        if (i11 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f35424c);
    }

    public boolean d(int i11) {
        return (this.f35431j & i11) == i11;
    }

    public n e(long j11) {
        long j12 = this.f35429h;
        return f(j11, j12 != -1 ? j12 - j11 : -1L);
    }

    public n f(long j11, long j12) {
        return (j11 == 0 && this.f35429h == j12) ? this : new n(this.f35422a, this.f35423b, this.f35424c, this.f35425d, this.f35426e, this.f35428g + j11, j12, this.f35430i, this.f35431j, this.f35432k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f35422a + ", " + this.f35428g + ", " + this.f35429h + ", " + this.f35430i + ", " + this.f35431j + "]";
    }
}

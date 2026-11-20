package c4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.c0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f14598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f14601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f14602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f14603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f14604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f14605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f14606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Object f14608k;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f14609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f14610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f14612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f14613e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f14614f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f14615g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f14616h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14617i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public Object f14618j;

        public b() {
            this.f14611c = 1;
            this.f14613e = Collections.emptyMap();
            this.f14615g = -1L;
        }

        public b(g gVar) {
            this.f14609a = gVar.f14598a;
            this.f14610b = gVar.f14599b;
            this.f14611c = gVar.f14600c;
            this.f14612d = gVar.f14601d;
            this.f14613e = gVar.f14602e;
            this.f14614f = gVar.f14604g;
            this.f14615g = gVar.f14605h;
            this.f14616h = gVar.f14606i;
            this.f14617i = gVar.f14607j;
            this.f14618j = gVar.f14608k;
        }

        public g a() {
            z3.a.j(this.f14609a, "The uri must be set.");
            return new g(this.f14609a, this.f14610b, this.f14611c, this.f14612d, this.f14613e, this.f14614f, this.f14615g, this.f14616h, this.f14617i, this.f14618j);
        }

        public b b(int i11) {
            this.f14617i = i11;
            return this;
        }

        public b c(@Nullable byte[] bArr) {
            this.f14612d = bArr;
            return this;
        }

        public b d(int i11) {
            this.f14611c = i11;
            return this;
        }

        public b e(Map<String, String> map) {
            this.f14613e = map;
            return this;
        }

        public b f(@Nullable String str) {
            this.f14616h = str;
            return this;
        }

        public b g(long j11) {
            this.f14615g = j11;
            return this;
        }

        public b h(long j11) {
            this.f14614f = j11;
            return this;
        }

        public b i(Uri uri) {
            this.f14609a = uri;
            return this;
        }

        public b j(String str) {
            this.f14609a = Uri.parse(str);
            return this;
        }

        public b k(long j11) {
            this.f14610b = j11;
            return this;
        }
    }

    static {
        c0.a("media3.datasource");
    }

    public g(Uri uri, long j11, int i11, @Nullable byte[] bArr, Map<String, String> map, long j12, long j13, @Nullable String str, int i12, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j14 = j11 + j12;
        boolean z11 = true;
        z3.a.a(j14 >= 0);
        z3.a.a(j12 >= 0);
        if (j13 <= 0 && j13 != -1) {
            z11 = false;
        }
        z3.a.a(z11);
        this.f14598a = uri;
        this.f14599b = j11;
        this.f14600c = i11;
        this.f14601d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f14602e = Collections.unmodifiableMap(new HashMap(map));
        this.f14604g = j12;
        this.f14603f = j14;
        this.f14605h = j13;
        this.f14606i = str;
        this.f14607j = i12;
        this.f14608k = obj;
    }

    public g(Uri uri, long j11, long j12) {
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
        return c(this.f14600c);
    }

    public boolean d(int i11) {
        return (this.f14607j & i11) == i11;
    }

    public g e(long j11) {
        long j12 = this.f14605h;
        return f(j11, j12 != -1 ? j12 - j11 : -1L);
    }

    public g f(long j11, long j12) {
        return (j11 == 0 && this.f14605h == j12) ? this : new g(this.f14598a, this.f14599b, this.f14600c, this.f14601d, this.f14602e, this.f14604g + j11, j12, this.f14606i, this.f14607j, this.f14608k);
    }

    public g g(Uri uri) {
        return new g(uri, this.f14599b, this.f14600c, this.f14601d, this.f14602e, this.f14604g, this.f14605h, this.f14606i, this.f14607j, this.f14608k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f14598a + ", " + this.f14604g + ", " + this.f14605h + ", " + this.f14606i + ", " + this.f14607j + "]";
    }
}

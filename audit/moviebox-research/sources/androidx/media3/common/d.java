package androidx.media3.common;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f9123g = new e().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9124h = u0.E0(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9125i = u0.E0(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9126j = u0.E0(2);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9127k = u0.E0(3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9128l = u0.E0(4);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final i<d> f9129m = new androidx.media3.common.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public C0088d f9135f;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class b {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setAllowedCapturePolicy(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(32)
    public static final class c {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setSpatializationBehavior(i11);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.common.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class C0088d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f9136a;

        public C0088d(d dVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(dVar.f9130a).setFlags(dVar.f9131b).setUsage(dVar.f9132c);
            int i11 = u0.f81838a;
            if (i11 >= 29) {
                b.a(usage, dVar.f9133d);
            }
            if (i11 >= 32) {
                c.a(usage, dVar.f9134e);
            }
            this.f9136a = usage.build();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9137a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9138b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9139c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9140d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9141e = 0;

        public d a() {
            return new d(this.f9137a, this.f9138b, this.f9139c, this.f9140d, this.f9141e);
        }
    }

    public d(int i11, int i12, int i13, int i14, int i15) {
        this.f9130a = i11;
        this.f9131b = i12;
        this.f9132c = i13;
        this.f9133d = i14;
        this.f9134e = i15;
    }

    @RequiresApi(21)
    public C0088d a() {
        if (this.f9135f == null) {
            this.f9135f = new C0088d();
        }
        return this.f9135f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9130a == dVar.f9130a && this.f9131b == dVar.f9131b && this.f9132c == dVar.f9132c && this.f9133d == dVar.f9133d && this.f9134e == dVar.f9134e;
    }

    public int hashCode() {
        return ((((((((527 + this.f9130a) * 31) + this.f9131b) * 31) + this.f9132c) * 31) + this.f9133d) * 31) + this.f9134e;
    }
}

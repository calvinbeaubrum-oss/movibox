package androidx.media3.common;

import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o f9335e = new b(0).e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9336f = u0.E0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9337g = u0.E0(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9338h = u0.E0(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9339i = u0.E0(3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final i<o> f9340j = new androidx.media3.common.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f9344d;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f9348d;

        public b(int i11) {
            this.f9345a = i11;
        }

        public o e() {
            z3.a.a(this.f9346b <= this.f9347c);
            return new o(this);
        }

        public b f(int i11) {
            this.f9347c = i11;
            return this;
        }

        public b g(int i11) {
            this.f9346b = i11;
            return this;
        }
    }

    public o(b bVar) {
        this.f9341a = bVar.f9345a;
        this.f9342b = bVar.f9346b;
        this.f9343c = bVar.f9347c;
        this.f9344d = bVar.f9348d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f9341a == oVar.f9341a && this.f9342b == oVar.f9342b && this.f9343c == oVar.f9343c && u0.c(this.f9344d, oVar.f9344d);
    }

    public int hashCode() {
        int i11 = (((((527 + this.f9341a) * 31) + this.f9342b) * 31) + this.f9343c) * 31;
        String str = this.f9344d;
        return i11 + (str == null ? 0 : str.hashCode());
    }
}

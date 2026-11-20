package bh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f14245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14250f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14256l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public p f14258n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f14261q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14262r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f14251g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14252h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f14253i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f14254j = new long[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f14255k = new boolean[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean[] f14257m = new boolean[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f14259o = new c0();

    public void a(c0 c0Var) {
        c0Var.j(this.f14259o.d(), 0, this.f14259o.f());
        this.f14259o.P(0);
        this.f14260p = false;
    }

    public void b(tg.m mVar) throws IOException {
        mVar.readFully(this.f14259o.d(), 0, this.f14259o.f());
        this.f14259o.P(0);
        this.f14260p = false;
    }

    public long c(int i11) {
        return this.f14254j[i11];
    }

    public void d(int i11) {
        this.f14259o.L(i11);
        this.f14256l = true;
        this.f14260p = true;
    }

    public void e(int i11, int i12) {
        this.f14249e = i11;
        this.f14250f = i12;
        if (this.f14252h.length < i11) {
            this.f14251g = new long[i11];
            this.f14252h = new int[i11];
        }
        if (this.f14253i.length < i12) {
            int i13 = (i12 * 125) / 100;
            this.f14253i = new int[i13];
            this.f14254j = new long[i13];
            this.f14255k = new boolean[i13];
            this.f14257m = new boolean[i13];
        }
    }

    public void f() {
        this.f14249e = 0;
        this.f14261q = 0L;
        this.f14262r = false;
        this.f14256l = false;
        this.f14260p = false;
        this.f14258n = null;
    }

    public boolean g(int i11) {
        return this.f14256l && this.f14257m[i11];
    }
}

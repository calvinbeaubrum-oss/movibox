package l5;

import androidx.annotation.Nullable;
import java.io.IOException;
import u4.t;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f69944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f69945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f69946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f69947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f69948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f69949f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f69955l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public q f69957n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f69959p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f69960q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f69961r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f69950g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f69951h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f69952i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f69953j = new long[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f69954k = new boolean[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean[] f69956m = new boolean[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f69958o = new c0();

    public void a(t tVar) throws IOException {
        tVar.readFully(this.f69958o.e(), 0, this.f69958o.g());
        this.f69958o.U(0);
        this.f69959p = false;
    }

    public void b(c0 c0Var) {
        c0Var.l(this.f69958o.e(), 0, this.f69958o.g());
        this.f69958o.U(0);
        this.f69959p = false;
    }

    public long c(int i11) {
        return this.f69953j[i11];
    }

    public void d(int i11) {
        this.f69958o.Q(i11);
        this.f69955l = true;
        this.f69959p = true;
    }

    public void e(int i11, int i12) {
        this.f69948e = i11;
        this.f69949f = i12;
        if (this.f69951h.length < i11) {
            this.f69950g = new long[i11];
            this.f69951h = new int[i11];
        }
        if (this.f69952i.length < i12) {
            int i13 = (i12 * 125) / 100;
            this.f69952i = new int[i13];
            this.f69953j = new long[i13];
            this.f69954k = new boolean[i13];
            this.f69956m = new boolean[i13];
        }
    }

    public void f() {
        this.f69948e = 0;
        this.f69960q = 0L;
        this.f69961r = false;
        this.f69955l = false;
        this.f69959p = false;
        this.f69957n = null;
    }

    public boolean g(int i11) {
        return this.f69955l && this.f69956m[i11];
    }
}

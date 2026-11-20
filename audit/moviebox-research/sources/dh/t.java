package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.b0.a f63371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f63372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tg.e0 f63373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f63374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f63377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f63378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f63379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f63380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f63381l;

    public t() {
        this(null);
    }

    public t(@Nullable String str) {
        this.f63375f = 0;
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(4);
        this.f63370a = c0Var;
        c0Var.d()[0] = -1;
        this.f63371b = new com.google.android.exoplayer2.audio.b0.a();
        this.f63381l = C.TIME_UNSET;
        this.f63372c = str;
    }

    public final void a(com.google.android.exoplayer2.util.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            byte b11 = bArrD[iE];
            boolean z11 = (b11 & 255) == 255;
            boolean z12 = this.f63378i && (b11 & 224) == 224;
            this.f63378i = z11;
            if (z12) {
                c0Var.P(iE + 1);
                this.f63378i = false;
                this.f63370a.d()[1] = bArrD[iE];
                this.f63376g = 2;
                this.f63375f = 1;
                return;
            }
        }
        c0Var.P(iF);
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63373d);
        while (c0Var.a() > 0) {
            int i11 = this.f63375f;
            if (i11 == 0) {
                a(c0Var);
            } else if (i11 == 1) {
                f(c0Var);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                e(c0Var);
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63381l = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63374e = dVar.b();
        this.f63373d = nVar.track(dVar.c(), 1);
    }

    public final void e(com.google.android.exoplayer2.util.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f63380k - this.f63376g);
        this.f63373d.c(c0Var, iMin);
        int i11 = this.f63376g + iMin;
        this.f63376g = i11;
        int i12 = this.f63380k;
        if (i11 < i12) {
            return;
        }
        long j11 = this.f63381l;
        if (j11 != C.TIME_UNSET) {
            this.f63373d.d(j11, 1, i12, 0, null);
            this.f63381l += this.f63379j;
        }
        this.f63376g = 0;
        this.f63375f = 0;
    }

    public final void f(com.google.android.exoplayer2.util.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), 4 - this.f63376g);
        c0Var.j(this.f63370a.d(), this.f63376g, iMin);
        int i11 = this.f63376g + iMin;
        this.f63376g = i11;
        if (i11 < 4) {
            return;
        }
        this.f63370a.P(0);
        if (!this.f63371b.a(this.f63370a.n())) {
            this.f63376g = 0;
            this.f63375f = 1;
            return;
        }
        com.google.android.exoplayer2.audio.b0.a aVar = this.f63371b;
        this.f63380k = aVar.f32795c;
        if (!this.f63377h) {
            this.f63379j = (((long) aVar.f32799g) * 1000000) / ((long) aVar.f32796d);
            this.f63373d.e(new m1.b().S(this.f63374e).e0(this.f63371b.f32794b).W(4096).H(this.f63371b.f32797e).f0(this.f63371b.f32796d).V(this.f63372c).E());
            this.f63377h = true;
        }
        this.f63370a.P(0);
        this.f63373d.c(this.f63370a, 4);
        this.f63375f = 2;
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63375f = 0;
        this.f63376g = 0;
        this.f63378i = false;
        this.f63381l = C.TIME_UNSET;
    }
}

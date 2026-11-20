package x5;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.c0 f80225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.j0.a f80226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f80227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f80228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r0 f80229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f80231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f80232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f80233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f80234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f80235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f80236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f80237m;

    public t() {
        this(null, 0);
    }

    public t(@Nullable String str, int i11) {
        this.f80231g = 0;
        z3.c0 c0Var = new z3.c0(4);
        this.f80225a = c0Var;
        c0Var.e()[0] = -1;
        this.f80226b = new u4.j0.a();
        this.f80237m = C.TIME_UNSET;
        this.f80227c = str;
        this.f80228d = i11;
    }

    public final void a(z3.c0 c0Var) {
        byte[] bArrE = c0Var.e();
        int iG = c0Var.g();
        for (int iF = c0Var.f(); iF < iG; iF++) {
            byte b11 = bArrE[iF];
            boolean z11 = (b11 & 255) == 255;
            boolean z12 = this.f80234j && (b11 & 224) == 224;
            this.f80234j = z11;
            if (z12) {
                c0Var.U(iF + 1);
                this.f80234j = false;
                this.f80225a.e()[1] = bArrE[iF];
                this.f80232h = 2;
                this.f80231g = 1;
                return;
            }
        }
        c0Var.U(iG);
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        z3.a.i(this.f80229e);
        while (c0Var.a() > 0) {
            int i11 = this.f80231g;
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

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80237m = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80230f = dVar.b();
        this.f80229e = uVar.track(dVar.c(), 1);
    }

    public final void e(z3.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f80236l - this.f80232h);
        this.f80229e.c(c0Var, iMin);
        int i11 = this.f80232h + iMin;
        this.f80232h = i11;
        if (i11 < this.f80236l) {
            return;
        }
        z3.a.g(this.f80237m != C.TIME_UNSET);
        this.f80229e.f(this.f80237m, 1, this.f80236l, 0, null);
        this.f80237m += this.f80235k;
        this.f80232h = 0;
        this.f80231g = 0;
    }

    public final void f(z3.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), 4 - this.f80232h);
        c0Var.l(this.f80225a.e(), this.f80232h, iMin);
        int i11 = this.f80232h + iMin;
        this.f80232h = i11;
        if (i11 < 4) {
            return;
        }
        this.f80225a.U(0);
        if (!this.f80226b.a(this.f80225a.q())) {
            this.f80232h = 0;
            this.f80231g = 1;
            return;
        }
        u4.j0.a aVar = this.f80226b;
        this.f80236l = aVar.f78317c;
        if (!this.f80233i) {
            this.f80235k = (((long) aVar.f78321g) * 1000000) / ((long) aVar.f78318d);
            this.f80229e.b(new androidx.media3.common.y.b().X(this.f80230f).k0(this.f80226b.f78316b).c0(4096).L(this.f80226b.f78319e).l0(this.f80226b.f78318d).b0(this.f80227c).i0(this.f80228d).I());
            this.f80233i = true;
        }
        this.f80225a.U(0);
        this.f80229e.c(this.f80225a, 4);
        this.f80231g = 2;
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f80231g = 0;
        this.f80232h = 0;
        this.f80234j = false;
        this.f80237m = C.TIME_UNSET;
    }
}

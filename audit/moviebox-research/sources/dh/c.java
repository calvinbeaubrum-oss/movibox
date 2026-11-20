package dh;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f63076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f63077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public tg.e0 f63078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f63081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f63082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1 f63083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f63084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f63085l;

    public c() {
        this(null);
    }

    public c(@Nullable String str) {
        com.google.android.exoplayer2.util.b0 b0Var = new com.google.android.exoplayer2.util.b0(new byte[128]);
        this.f63074a = b0Var;
        this.f63075b = new com.google.android.exoplayer2.util.c0(b0Var.f35543a);
        this.f63079f = 0;
        this.f63085l = C.TIME_UNSET;
        this.f63076c = str;
    }

    public final boolean a(com.google.android.exoplayer2.util.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f63080g);
        c0Var.j(bArr, this.f63080g, iMin);
        int i12 = this.f63080g + iMin;
        this.f63080g = i12;
        return i12 == i11;
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63078e);
        while (c0Var.a() > 0) {
            int i11 = this.f63079f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f63084k - this.f63080g);
                        this.f63078e.c(c0Var, iMin);
                        int i12 = this.f63080g + iMin;
                        this.f63080g = i12;
                        int i13 = this.f63084k;
                        if (i12 == i13) {
                            long j11 = this.f63085l;
                            if (j11 != C.TIME_UNSET) {
                                this.f63078e.d(j11, 1, i13, 0, null);
                                this.f63085l += this.f63082i;
                            }
                            this.f63079f = 0;
                        }
                    }
                } else if (a(c0Var, this.f63075b.d(), 128)) {
                    e();
                    this.f63075b.P(0);
                    this.f63078e.c(this.f63075b, 128);
                    this.f63079f = 2;
                }
            } else if (f(c0Var)) {
                this.f63079f = 1;
                this.f63075b.d()[0] = Ascii.VT;
                this.f63075b.d()[1] = 119;
                this.f63080g = 2;
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63085l = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63077d = dVar.b();
        this.f63078e = nVar.track(dVar.c(), 1);
    }

    public final void e() {
        this.f63074a.p(0);
        com.google.android.exoplayer2.audio.b.C0358b c0358bE = com.google.android.exoplayer2.audio.b.e(this.f63074a);
        m1 m1Var = this.f63083j;
        if (m1Var == null || c0358bE.f32783d != m1Var.f33458z || c0358bE.f32782c != m1Var.A || !o0.c(c0358bE.f32780a, m1Var.f33445m)) {
            m1 m1VarE = new m1.b().S(this.f63077d).e0(c0358bE.f32780a).H(c0358bE.f32783d).f0(c0358bE.f32782c).V(this.f63076c).E();
            this.f63083j = m1VarE;
            this.f63078e.e(m1VarE);
        }
        this.f63084k = c0358bE.f32784e;
        this.f63082i = (((long) c0358bE.f32785f) * 1000000) / ((long) this.f63083j.A);
    }

    public final boolean f(com.google.android.exoplayer2.util.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f63081h) {
                int iD = c0Var.D();
                if (iD == 119) {
                    this.f63081h = false;
                    return true;
                }
                this.f63081h = iD == 11;
            } else {
                this.f63081h = c0Var.D() == 11;
            }
        }
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63079f = 0;
        this.f63080g = 0;
        this.f63081h = false;
        this.f63085l = C.TIME_UNSET;
    }
}

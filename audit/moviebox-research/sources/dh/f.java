package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f63104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f63105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public tg.e0 f63106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f63109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f63110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f63111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m1 f63112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f63113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f63114m;

    public f() {
        this(null);
    }

    public f(@Nullable String str) {
        com.google.android.exoplayer2.util.b0 b0Var = new com.google.android.exoplayer2.util.b0(new byte[16]);
        this.f63102a = b0Var;
        this.f63103b = new com.google.android.exoplayer2.util.c0(b0Var.f35543a);
        this.f63107f = 0;
        this.f63108g = 0;
        this.f63109h = false;
        this.f63110i = false;
        this.f63114m = C.TIME_UNSET;
        this.f63104c = str;
    }

    private boolean a(com.google.android.exoplayer2.util.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f63108g);
        c0Var.j(bArr, this.f63108g, iMin);
        int i12 = this.f63108g + iMin;
        this.f63108g = i12;
        return i12 == i11;
    }

    private void e() {
        this.f63102a.p(0);
        com.google.android.exoplayer2.audio.c.b bVarD = com.google.android.exoplayer2.audio.c.d(this.f63102a);
        m1 m1Var = this.f63112k;
        if (m1Var == null || bVarD.f32803c != m1Var.f33458z || bVarD.f32802b != m1Var.A || !"audio/ac4".equals(m1Var.f33445m)) {
            m1 m1VarE = new m1.b().S(this.f63105d).e0("audio/ac4").H(bVarD.f32803c).f0(bVarD.f32802b).V(this.f63104c).E();
            this.f63112k = m1VarE;
            this.f63106e.e(m1VarE);
        }
        this.f63113l = bVarD.f32804d;
        this.f63111j = (((long) bVarD.f32805e) * 1000000) / ((long) this.f63112k.A);
    }

    private boolean f(com.google.android.exoplayer2.util.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f63109h) {
                int iD = c0Var.D();
                this.f63109h = iD == 172;
                if (iD == 64 || iD == 65) {
                    this.f63110i = iD == 65;
                    return true;
                }
            } else {
                this.f63109h = c0Var.D() == 172;
            }
        }
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63106e);
        while (c0Var.a() > 0) {
            int i11 = this.f63107f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f63113l - this.f63108g);
                        this.f63106e.c(c0Var, iMin);
                        int i12 = this.f63108g + iMin;
                        this.f63108g = i12;
                        int i13 = this.f63113l;
                        if (i12 == i13) {
                            long j11 = this.f63114m;
                            if (j11 != C.TIME_UNSET) {
                                this.f63106e.d(j11, 1, i13, 0, null);
                                this.f63114m += this.f63111j;
                            }
                            this.f63107f = 0;
                        }
                    }
                } else if (a(c0Var, this.f63103b.d(), 16)) {
                    e();
                    this.f63103b.P(0);
                    this.f63106e.c(this.f63103b, 16);
                    this.f63107f = 2;
                }
            } else if (f(c0Var)) {
                this.f63107f = 1;
                this.f63103b.d()[0] = -84;
                this.f63103b.d()[1] = (byte) (this.f63110i ? 65 : 64);
                this.f63108g = 2;
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63114m = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63105d = dVar.b();
        this.f63106e = nVar.track(dVar.c(), 1);
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63107f = 0;
        this.f63108g = 0;
        this.f63109h = false;
        this.f63110i = false;
        this.f63114m = C.TIME_UNSET;
    }
}

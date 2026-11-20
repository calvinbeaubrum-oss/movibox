package x5;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.b0 f79945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.c0 f79946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f79947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f79949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f79950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f79952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f79953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f79954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f79955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.media3.common.y f79956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f79957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f79958n;

    public f() {
        this(null, 0);
    }

    public f(@Nullable String str, int i11) {
        z3.b0 b0Var = new z3.b0(new byte[16]);
        this.f79945a = b0Var;
        this.f79946b = new z3.c0(b0Var.f81757a);
        this.f79951g = 0;
        this.f79952h = 0;
        this.f79953i = false;
        this.f79954j = false;
        this.f79958n = C.TIME_UNSET;
        this.f79947c = str;
        this.f79948d = i11;
    }

    private boolean a(z3.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f79952h);
        c0Var.l(bArr, this.f79952h, iMin);
        int i12 = this.f79952h + iMin;
        this.f79952h = i12;
        return i12 == i11;
    }

    private void e() {
        this.f79945a.p(0);
        u4.c.b bVarD = u4.c.d(this.f79945a);
        androidx.media3.common.y yVar = this.f79956l;
        if (yVar == null || bVarD.f78216c != yVar.f9514z || bVarD.f78215b != yVar.A || !"audio/ac4".equals(yVar.f9501m)) {
            androidx.media3.common.y yVarI = new androidx.media3.common.y.b().X(this.f79949e).k0("audio/ac4").L(bVarD.f78216c).l0(bVarD.f78215b).b0(this.f79947c).i0(this.f79948d).I();
            this.f79956l = yVarI;
            this.f79950f.b(yVarI);
        }
        this.f79957m = bVarD.f78217d;
        this.f79955k = (((long) bVarD.f78218e) * 1000000) / ((long) this.f79956l.A);
    }

    private boolean f(z3.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f79953i) {
                int iH = c0Var.H();
                this.f79953i = iH == 172;
                if (iH == 64 || iH == 65) {
                    this.f79954j = iH == 65;
                    return true;
                }
            } else {
                this.f79953i = c0Var.H() == 172;
            }
        }
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        z3.a.i(this.f79950f);
        while (c0Var.a() > 0) {
            int i11 = this.f79951g;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f79957m - this.f79952h);
                        this.f79950f.c(c0Var, iMin);
                        int i12 = this.f79952h + iMin;
                        this.f79952h = i12;
                        if (i12 == this.f79957m) {
                            z3.a.g(this.f79958n != C.TIME_UNSET);
                            this.f79950f.f(this.f79958n, 1, this.f79957m, 0, null);
                            this.f79958n += this.f79955k;
                            this.f79951g = 0;
                        }
                    }
                } else if (a(c0Var, this.f79946b.e(), 16)) {
                    e();
                    this.f79946b.U(0);
                    this.f79950f.c(this.f79946b, 16);
                    this.f79951g = 2;
                }
            } else if (f(c0Var)) {
                this.f79951g = 1;
                this.f79946b.e()[0] = -84;
                this.f79946b.e()[1] = (byte) (this.f79954j ? 65 : 64);
                this.f79952h = 2;
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f79958n = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f79949e = dVar.b();
        this.f79950f = uVar.track(dVar.c(), 1);
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f79951g = 0;
        this.f79952h = 0;
        this.f79953i = false;
        this.f79954j = false;
        this.f79958n = C.TIME_UNSET;
    }
}

package x5;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.b0 f79916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.c0 f79917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f79918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f79920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f79921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f79923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f79924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f79925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.media3.common.y f79926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f79927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f79928m;

    public c() {
        this(null, 0);
    }

    public c(@Nullable String str, int i11) {
        z3.b0 b0Var = new z3.b0(new byte[128]);
        this.f79916a = b0Var;
        this.f79917b = new z3.c0(b0Var.f81757a);
        this.f79922g = 0;
        this.f79928m = C.TIME_UNSET;
        this.f79918c = str;
        this.f79919d = i11;
    }

    public final boolean a(z3.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f79923h);
        c0Var.l(bArr, this.f79923h, iMin);
        int i12 = this.f79923h + iMin;
        this.f79923h = i12;
        return i12 == i11;
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        z3.a.i(this.f79921f);
        while (c0Var.a() > 0) {
            int i11 = this.f79922g;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f79927l - this.f79923h);
                        this.f79921f.c(c0Var, iMin);
                        int i12 = this.f79923h + iMin;
                        this.f79923h = i12;
                        if (i12 == this.f79927l) {
                            z3.a.g(this.f79928m != C.TIME_UNSET);
                            this.f79921f.f(this.f79928m, 1, this.f79927l, 0, null);
                            this.f79928m += this.f79925j;
                            this.f79922g = 0;
                        }
                    }
                } else if (a(c0Var, this.f79917b.e(), 128)) {
                    e();
                    this.f79917b.U(0);
                    this.f79921f.c(this.f79917b, 128);
                    this.f79922g = 2;
                }
            } else if (f(c0Var)) {
                this.f79922g = 1;
                this.f79917b.e()[0] = Ascii.VT;
                this.f79917b.e()[1] = 119;
                this.f79923h = 2;
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f79928m = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f79920e = dVar.b();
        this.f79921f = uVar.track(dVar.c(), 1);
    }

    public final void e() {
        this.f79916a.p(0);
        u4.b.C0861b c0861bF = u4.b.f(this.f79916a);
        androidx.media3.common.y yVar = this.f79926k;
        if (yVar == null || c0861bF.f78207d != yVar.f9514z || c0861bF.f78206c != yVar.A || !u0.c(c0861bF.f78204a, yVar.f9501m)) {
            androidx.media3.common.y.b bVarF0 = new androidx.media3.common.y.b().X(this.f79920e).k0(c0861bF.f78204a).L(c0861bF.f78207d).l0(c0861bF.f78206c).b0(this.f79918c).i0(this.f79919d).f0(c0861bF.f78210g);
            if (MimeTypes.AUDIO_AC3.equals(c0861bF.f78204a)) {
                bVarF0.K(c0861bF.f78210g);
            }
            androidx.media3.common.y yVarI = bVarF0.I();
            this.f79926k = yVarI;
            this.f79921f.b(yVarI);
        }
        this.f79927l = c0861bF.f78208e;
        this.f79925j = (((long) c0861bF.f78209f) * 1000000) / ((long) this.f79926k.A);
    }

    public final boolean f(z3.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f79924i) {
                int iH = c0Var.H();
                if (iH == 119) {
                    this.f79924i = false;
                    return true;
                }
                this.f79924i = iH == 11;
            } else {
                this.f79924i = c0Var.H() == 11;
            }
        }
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f79922g = 0;
        this.f79923h = 0;
        this.f79924i = false;
        this.f79928m = C.TIME_UNSET;
    }
}

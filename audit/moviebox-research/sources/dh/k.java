package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f63201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f63202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tg.e0 f63203d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m1 f63208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f63209j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63200a = new com.google.android.exoplayer2.util.c0(new byte[18]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f63204e = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f63210k = C.TIME_UNSET;

    public k(@Nullable String str) {
        this.f63201b = str;
    }

    private boolean a(com.google.android.exoplayer2.util.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f63205f);
        c0Var.j(bArr, this.f63205f, iMin);
        int i12 = this.f63205f + iMin;
        this.f63205f = i12;
        return i12 == i11;
    }

    private void e() {
        byte[] bArrD = this.f63200a.d();
        if (this.f63208i == null) {
            m1 m1VarG = com.google.android.exoplayer2.audio.y.g(bArrD, this.f63202c, this.f63201b, null);
            this.f63208i = m1VarG;
            this.f63203d.e(m1VarG);
        }
        this.f63209j = com.google.android.exoplayer2.audio.y.a(bArrD);
        this.f63207h = (int) ((((long) com.google.android.exoplayer2.audio.y.f(bArrD)) * 1000000) / ((long) this.f63208i.A));
    }

    private boolean f(com.google.android.exoplayer2.util.c0 c0Var) {
        while (c0Var.a() > 0) {
            int i11 = this.f63206g << 8;
            this.f63206g = i11;
            int iD = i11 | c0Var.D();
            this.f63206g = iD;
            if (com.google.android.exoplayer2.audio.y.d(iD)) {
                byte[] bArrD = this.f63200a.d();
                int i12 = this.f63206g;
                bArrD[0] = (byte) ((i12 >> 24) & 255);
                bArrD[1] = (byte) ((i12 >> 16) & 255);
                bArrD[2] = (byte) ((i12 >> 8) & 255);
                bArrD[3] = (byte) (i12 & 255);
                this.f63205f = 4;
                this.f63206g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63203d);
        while (c0Var.a() > 0) {
            int i11 = this.f63204e;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f63209j - this.f63205f);
                    this.f63203d.c(c0Var, iMin);
                    int i12 = this.f63205f + iMin;
                    this.f63205f = i12;
                    int i13 = this.f63209j;
                    if (i12 == i13) {
                        long j11 = this.f63210k;
                        if (j11 != C.TIME_UNSET) {
                            this.f63203d.d(j11, 1, i13, 0, null);
                            this.f63210k += this.f63207h;
                        }
                        this.f63204e = 0;
                    }
                } else if (a(c0Var, this.f63200a.d(), 18)) {
                    e();
                    this.f63200a.P(0);
                    this.f63203d.c(this.f63200a, 18);
                    this.f63204e = 2;
                }
            } else if (f(c0Var)) {
                this.f63204e = 1;
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63210k = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63202c = dVar.b();
        this.f63203d = nVar.track(dVar.c(), 1);
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63204e = 0;
        this.f63205f = 0;
        this.f63206g = 0;
        this.f63210k = C.TIME_UNSET;
    }
}

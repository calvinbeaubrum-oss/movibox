package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f63390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63391b = new com.google.android.exoplayer2.util.b0(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f63392c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f63393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.util.k0 f63394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f63395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f63396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f63397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f63398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f63399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f63400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f63401l;

    public w(m mVar) {
        this.f63390a = mVar;
    }

    @Override // dh.i0
    public void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, i0.d dVar) {
        this.f63394e = k0Var;
        this.f63390a.d(nVar, dVar);
    }

    @Override // dh.i0
    public final void b(com.google.android.exoplayer2.util.c0 c0Var, int i11) throws ParserException {
        com.google.android.exoplayer2.util.a.i(this.f63394e);
        if ((i11 & 1) != 0) {
            int i12 = this.f63392c;
            if (i12 != 0 && i12 != 1) {
                if (i12 == 2) {
                    com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f63399j != -1) {
                        com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator: expected " + this.f63399j + " more bytes");
                    }
                    this.f63390a.packetFinished();
                }
            }
            f(1);
        }
        while (c0Var.a() > 0) {
            int i13 = this.f63392c;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        if (c(c0Var, this.f63391b.f35543a, Math.min(10, this.f63398i)) && c(c0Var, null, this.f63398i)) {
                            e();
                            i11 |= this.f63400k ? 4 : 0;
                            this.f63390a.c(this.f63401l, i11);
                            f(3);
                        }
                    } else {
                        if (i13 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = c0Var.a();
                        int i14 = this.f63399j;
                        int i15 = i14 != -1 ? iA - i14 : 0;
                        if (i15 > 0) {
                            iA -= i15;
                            c0Var.O(c0Var.e() + iA);
                        }
                        this.f63390a.b(c0Var);
                        int i16 = this.f63399j;
                        if (i16 != -1) {
                            int i17 = i16 - iA;
                            this.f63399j = i17;
                            if (i17 == 0) {
                                this.f63390a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(c0Var, this.f63391b.f35543a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                c0Var.Q(c0Var.a());
            }
        }
    }

    public final boolean c(com.google.android.exoplayer2.util.c0 c0Var, @Nullable byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f63393d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c0Var.Q(iMin);
        } else {
            c0Var.j(bArr, this.f63393d, iMin);
        }
        int i12 = this.f63393d + iMin;
        this.f63393d = i12;
        return i12 == i11;
    }

    public final boolean d() {
        this.f63391b.p(0);
        int iH = this.f63391b.h(24);
        if (iH != 1) {
            com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start code prefix: " + iH);
            this.f63399j = -1;
            return false;
        }
        this.f63391b.r(8);
        int iH2 = this.f63391b.h(16);
        this.f63391b.r(5);
        this.f63400k = this.f63391b.g();
        this.f63391b.r(2);
        this.f63395f = this.f63391b.g();
        this.f63396g = this.f63391b.g();
        this.f63391b.r(6);
        int iH3 = this.f63391b.h(8);
        this.f63398i = iH3;
        if (iH2 == 0) {
            this.f63399j = -1;
        } else {
            int i11 = (iH2 - 3) - iH3;
            this.f63399j = i11;
            if (i11 < 0) {
                com.google.android.exoplayer2.util.s.i("PesReader", "Found negative packet payload size: " + this.f63399j);
                this.f63399j = -1;
            }
        }
        return true;
    }

    public final void e() {
        this.f63391b.p(0);
        this.f63401l = C.TIME_UNSET;
        if (this.f63395f) {
            this.f63391b.r(4);
            long jH = ((long) this.f63391b.h(3)) << 30;
            this.f63391b.r(1);
            long jH2 = jH | ((long) (this.f63391b.h(15) << 15));
            this.f63391b.r(1);
            long jH3 = jH2 | ((long) this.f63391b.h(15));
            this.f63391b.r(1);
            if (!this.f63397h && this.f63396g) {
                this.f63391b.r(4);
                long jH4 = ((long) this.f63391b.h(3)) << 30;
                this.f63391b.r(1);
                long jH5 = jH4 | ((long) (this.f63391b.h(15) << 15));
                this.f63391b.r(1);
                long jH6 = jH5 | ((long) this.f63391b.h(15));
                this.f63391b.r(1);
                this.f63394e.b(jH6);
                this.f63397h = true;
            }
            this.f63401l = this.f63394e.b(jH3);
        }
    }

    public final void f(int i11) {
        this.f63392c = i11;
        this.f63393d = 0;
    }

    @Override // dh.i0
    public final void seek() {
        this.f63392c = 0;
        this.f63393d = 0;
        this.f63397h = false;
        this.f63390a.seek();
    }
}

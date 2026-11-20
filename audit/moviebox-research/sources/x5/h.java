package x5;

import android.net.Uri;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import u4.l0;
import u4.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements u4.s {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u4.y f79968m = new u4.y() { // from class: x5.g
        @Override // u4.y
        public /* synthetic */ u4.y a(o5.s.a aVar) {
            return u4.x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
            return u4.x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ u4.y c(boolean z11) {
            return u4.x.b(this, z11);
        }

        @Override // u4.y
        public final u4.s[] createExtractors() {
            return h.i();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f79970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.c0 f79971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z3.c0 f79972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z3.b0 f79973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u4.u f79974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f79975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f79976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f79977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f79978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f79979k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f79980l;

    public h() {
        this(0);
    }

    public h(int i11) {
        this.f79969a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f79970b = new i(true);
        this.f79971c = new z3.c0(2048);
        this.f79977i = -1;
        this.f79976h = -1L;
        z3.c0 c0Var = new z3.c0(10);
        this.f79972d = c0Var;
        this.f79973e = new z3.b0(c0Var.e());
    }

    private static int g(int i11, long j11) {
        return (int) ((((long) i11) * 8000000) / j11);
    }

    private m0 h(long j11, boolean z11) {
        return new u4.i(j11, this.f79976h, g(this.f79977i, this.f79970b.i()), this.f79977i, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u4.s[] i() {
        return new u4.s[]{new h()};
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        int iK = k(tVar);
        int i11 = iK;
        int i12 = 0;
        int i13 = 0;
        do {
            tVar.peekFully(this.f79972d.e(), 0, 2);
            this.f79972d.U(0);
            if (i.k(this.f79972d.N())) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                tVar.peekFully(this.f79972d.e(), 0, 4);
                this.f79973e.p(14);
                int iH = this.f79973e.h(13);
                if (iH <= 6) {
                    i11++;
                    tVar.resetPeekPosition();
                    tVar.advancePeekPosition(i11);
                } else {
                    tVar.advancePeekPosition(iH - 6);
                    i13 += iH;
                }
            } else {
                i11++;
                tVar.resetPeekPosition();
                tVar.advancePeekPosition(i11);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - iK < 8192);
        return false;
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        z3.a.i(this.f79974f);
        long length = tVar.getLength();
        int i11 = this.f79969a;
        if ((i11 & 2) != 0 || ((i11 & 1) != 0 && length != -1)) {
            e(tVar);
        }
        int i12 = tVar.read(this.f79971c.e(), 0, 2048);
        boolean z11 = i12 == -1;
        j(length, z11);
        if (z11) {
            return -1;
        }
        this.f79971c.U(0);
        this.f79971c.T(i12);
        if (!this.f79979k) {
            this.f79970b.c(this.f79975g, 4);
            this.f79979k = true;
        }
        this.f79970b.b(this.f79971c);
        return 0;
    }

    public final void e(u4.t tVar) throws IOException {
        if (this.f79978j) {
            return;
        }
        this.f79977i = -1;
        tVar.resetPeekPosition();
        long j11 = 0;
        if (tVar.getPosition() == 0) {
            k(tVar);
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            try {
                if (tVar.peekFully(this.f79972d.e(), 0, 2, true)) {
                    this.f79972d.U(0);
                    if (!i.k(this.f79972d.N())) {
                        break;
                    }
                    if (tVar.peekFully(this.f79972d.e(), 0, 4, true)) {
                        this.f79973e.p(14);
                        int iH = this.f79973e.h(13);
                        if (iH <= 6) {
                            this.f79978j = true;
                            throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                        }
                        j11 += (long) iH;
                        i12++;
                        if (i12 != 1000 && tVar.advancePeekPosition(iH - 6, true)) {
                        }
                    }
                }
            } catch (EOFException unused) {
            }
            i11 = i12;
            break;
        }
        tVar.resetPeekPosition();
        if (i11 > 0) {
            this.f79977i = (int) (j11 / ((long) i11));
        } else {
            this.f79977i = -1;
        }
        this.f79978j = true;
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        this.f79974f = uVar;
        this.f79970b.d(uVar, new i0.d(0, 1));
        uVar.endTracks();
    }

    public final void j(long j11, boolean z11) {
        if (this.f79980l) {
            return;
        }
        boolean z12 = (this.f79969a & 1) != 0 && this.f79977i > 0;
        if (z12 && this.f79970b.i() == C.TIME_UNSET && !z11) {
            return;
        }
        if (!z12 || this.f79970b.i() == C.TIME_UNSET) {
            this.f79974f.f(new m0.b(C.TIME_UNSET));
        } else {
            this.f79974f.f(h(j11, (this.f79969a & 2) != 0));
        }
        this.f79980l = true;
    }

    public final int k(u4.t tVar) throws IOException {
        int i11 = 0;
        while (true) {
            tVar.peekFully(this.f79972d.e(), 0, 10);
            this.f79972d.U(0);
            if (this.f79972d.K() != 4801587) {
                break;
            }
            this.f79972d.V(3);
            int iG = this.f79972d.G();
            i11 += iG + 10;
            tVar.advancePeekPosition(iG);
        }
        tVar.resetPeekPosition();
        tVar.advancePeekPosition(i11);
        if (this.f79976h == -1) {
            this.f79976h = i11;
        }
        return i11;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f79979k = false;
        this.f79970b.seek();
        this.f79975g = j12;
    }
}

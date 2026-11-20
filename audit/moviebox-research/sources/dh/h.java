package dh;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements tg.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final tg.r f63124m = new tg.r() { // from class: dh.g
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return h.h();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f63126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public tg.n f63130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f63131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f63133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f63134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f63135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f63136l;

    public h() {
        this(0);
    }

    public h(int i11) {
        this.f63125a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f63126b = new i(true);
        this.f63127c = new com.google.android.exoplayer2.util.c0(2048);
        this.f63133i = -1;
        this.f63132h = -1L;
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(10);
        this.f63128d = c0Var;
        this.f63129e = new com.google.android.exoplayer2.util.b0(c0Var.d());
    }

    private static int f(int i11, long j11) {
        return (int) ((((long) i11) * 8000000) / j11);
    }

    private tg.b0 g(long j11, boolean z11) {
        return new tg.e(j11, this.f63132h, f(this.f63133i, this.f63126b.i()), this.f63133i, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tg.l[] h() {
        return new tg.l[]{new h()};
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        int iJ = j(mVar);
        int i11 = iJ;
        int i12 = 0;
        int i13 = 0;
        do {
            mVar.peekFully(this.f63128d.d(), 0, 2);
            this.f63128d.P(0);
            if (i.k(this.f63128d.J())) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                mVar.peekFully(this.f63128d.d(), 0, 4);
                this.f63129e.p(14);
                int iH = this.f63129e.h(13);
                if (iH <= 6) {
                    i11++;
                    mVar.resetPeekPosition();
                    mVar.advancePeekPosition(i11);
                } else {
                    mVar.advancePeekPosition(iH - 6);
                    i13 += iH;
                }
            } else {
                i11++;
                mVar.resetPeekPosition();
                mVar.advancePeekPosition(i11);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - iJ < 8192);
        return false;
    }

    @Override // tg.l
    public int c(tg.m mVar, tg.a0 a0Var) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f63130f);
        long length = mVar.getLength();
        int i11 = this.f63125a;
        if ((i11 & 2) != 0 || ((i11 & 1) != 0 && length != -1)) {
            e(mVar);
        }
        int i12 = mVar.read(this.f63127c.d(), 0, 2048);
        boolean z11 = i12 == -1;
        i(length, z11);
        if (z11) {
            return -1;
        }
        this.f63127c.P(0);
        this.f63127c.O(i12);
        if (!this.f63135k) {
            this.f63126b.c(this.f63131g, 4);
            this.f63135k = true;
        }
        this.f63126b.b(this.f63127c);
        return 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f63130f = nVar;
        this.f63126b.d(nVar, new i0.d(0, 1));
        nVar.endTracks();
    }

    public final void e(tg.m mVar) throws IOException {
        if (this.f63134j) {
            return;
        }
        this.f63133i = -1;
        mVar.resetPeekPosition();
        long j11 = 0;
        if (mVar.getPosition() == 0) {
            j(mVar);
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            try {
                if (mVar.peekFully(this.f63128d.d(), 0, 2, true)) {
                    this.f63128d.P(0);
                    if (!i.k(this.f63128d.J())) {
                        break;
                    }
                    if (mVar.peekFully(this.f63128d.d(), 0, 4, true)) {
                        this.f63129e.p(14);
                        int iH = this.f63129e.h(13);
                        if (iH <= 6) {
                            this.f63134j = true;
                            throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                        }
                        j11 += (long) iH;
                        i12++;
                        if (i12 != 1000 && mVar.advancePeekPosition(iH - 6, true)) {
                        }
                    }
                }
            } catch (EOFException unused) {
            }
            i11 = i12;
            break;
        }
        mVar.resetPeekPosition();
        if (i11 > 0) {
            this.f63133i = (int) (j11 / ((long) i11));
        } else {
            this.f63133i = -1;
        }
        this.f63134j = true;
    }

    public final void i(long j11, boolean z11) {
        if (this.f63136l) {
            return;
        }
        boolean z12 = (this.f63125a & 1) != 0 && this.f63133i > 0;
        if (z12 && this.f63126b.i() == C.TIME_UNSET && !z11) {
            return;
        }
        if (!z12 || this.f63126b.i() == C.TIME_UNSET) {
            this.f63130f.g(new tg.b0.b(C.TIME_UNSET));
        } else {
            this.f63130f.g(g(j11, (this.f63125a & 2) != 0));
        }
        this.f63136l = true;
    }

    public final int j(tg.m mVar) throws IOException {
        int i11 = 0;
        while (true) {
            mVar.peekFully(this.f63128d.d(), 0, 10);
            this.f63128d.P(0);
            if (this.f63128d.G() != 4801587) {
                break;
            }
            this.f63128d.Q(3);
            int iC = this.f63128d.C();
            i11 += iC + 10;
            mVar.advancePeekPosition(iC);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        if (this.f63132h == -1) {
            this.f63132h = i11;
        }
        return i11;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f63135k = false;
        this.f63126b.seek();
        this.f63131g = j12;
    }
}

package ah;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import tg.a0;
import tg.e0;
import tg.k;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;
import tg.x;
import tg.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f503u = new r() { // from class: ah.d
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return f.n();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final kh.b.a f504v = new kh.b.a() { // from class: ah.e
        @Override // kh.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            return f.o(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0.a f508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e0 f511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e0 f513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e0 f514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Metadata f516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f522r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f523s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f524t;

    public f() {
        this(0);
    }

    public f(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public f(int i11, long j11) {
        this.f505a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f506b = j11;
        this.f507c = new c0(10);
        this.f508d = new b0.a();
        this.f509e = new x();
        this.f517m = C.TIME_UNSET;
        this.f510f = new y();
        k kVar = new k();
        this.f511g = kVar;
        this.f514j = kVar;
    }

    private void f() {
        com.google.android.exoplayer2.util.a.i(this.f513i);
        o0.j(this.f512h);
    }

    public static long k(@Nullable Metadata metadata) {
        if (metadata == null) {
            return C.TIME_UNSET;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.f33579id.equals("TLEN")) {
                    return o0.C0(Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static int l(c0 c0Var, int i11) {
        if (c0Var.f() >= i11 + 4) {
            c0Var.P(i11);
            int iN = c0Var.n();
            if (iN == 1483304551 || iN == 1231971951) {
                return iN;
            }
        }
        if (c0Var.f() < 40) {
            return 0;
        }
        c0Var.P(36);
        return c0Var.n() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean m(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] n() {
        return new l[]{new f()};
    }

    public static /* synthetic */ boolean o(int i11, int i12, int i13, int i14, int i15) {
        return (i12 == 67 && i13 == 79 && i14 == 77 && (i15 == 77 || i11 == 2)) || (i12 == 77 && i13 == 76 && i14 == 76 && (i15 == 84 || i11 == 2));
    }

    @Nullable
    public static c p(@Nullable Metadata metadata, long j11) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof MlltFrame) {
                return c.b(j11, (MlltFrame) entry, k(metadata));
            }
        }
        return null;
    }

    private int t(m mVar) throws IOException {
        if (this.f520p == 0) {
            mVar.resetPeekPosition();
            if (r(mVar)) {
                return -1;
            }
            this.f507c.P(0);
            int iN = this.f507c.n();
            if (!m(iN, this.f515k) || b0.j(iN) == -1) {
                mVar.skipFully(1);
                this.f515k = 0;
                return 0;
            }
            this.f508d.a(iN);
            if (this.f517m == C.TIME_UNSET) {
                this.f517m = this.f521q.getTimeUs(mVar.getPosition());
                if (this.f506b != C.TIME_UNSET) {
                    this.f517m += this.f506b - this.f521q.getTimeUs(0L);
                }
            }
            b0.a aVar = this.f508d;
            this.f520p = aVar.f32795c;
            g gVar = this.f521q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(h(this.f518n + ((long) aVar.f32799g)), mVar.getPosition() + ((long) this.f508d.f32795c));
                if (this.f523s && bVar.b(this.f524t)) {
                    this.f523s = false;
                    this.f514j = this.f513i;
                }
            }
        }
        int iB = this.f514j.b(mVar, this.f520p, true);
        if (iB == -1) {
            return -1;
        }
        int i11 = this.f520p - iB;
        this.f520p = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f514j.d(h(this.f518n), 1, this.f508d.f32795c, 0, null);
        this.f518n += (long) this.f508d.f32799g;
        this.f520p = 0;
        return 0;
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        return u(mVar, true);
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        f();
        int iS = s(mVar);
        if (iS == -1 && (this.f521q instanceof b)) {
            long jH = h(this.f518n);
            if (this.f521q.getDurationUs() != jH) {
                ((b) this.f521q).d(jH);
                this.f512h.g(this.f521q);
            }
        }
        return iS;
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f512h = nVar;
        e0 e0VarTrack = nVar.track(0, 1);
        this.f513i = e0VarTrack;
        this.f514j = e0VarTrack;
        this.f512h.endTracks();
    }

    public final g g(m mVar) throws IOException {
        long jK;
        long jA;
        g gVarQ = q(mVar);
        c cVarP = p(this.f516l, mVar.getPosition());
        if (this.f522r) {
            return new g.a();
        }
        if ((this.f505a & 4) != 0) {
            if (cVarP != null) {
                jK = cVarP.getDurationUs();
                jA = cVarP.a();
            } else if (gVarQ != null) {
                jK = gVarQ.getDurationUs();
                jA = gVarQ.a();
            } else {
                jK = k(this.f516l);
                jA = -1;
            }
            gVarQ = new b(jK, mVar.getPosition(), jA);
        } else if (cVarP != null) {
            gVarQ = cVarP;
        } else if (gVarQ == null) {
            gVarQ = null;
        }
        if (gVarQ == null || !(gVarQ.isSeekable() || (this.f505a & 1) == 0)) {
            return j(mVar, (this.f505a & 2) != 0);
        }
        return gVarQ;
    }

    public final long h(long j11) {
        return this.f517m + ((j11 * 1000000) / ((long) this.f508d.f32796d));
    }

    public void i() {
        this.f522r = true;
    }

    public final g j(m mVar, boolean z11) throws IOException {
        mVar.peekFully(this.f507c.d(), 0, 4);
        this.f507c.P(0);
        this.f508d.a(this.f507c.n());
        return new a(mVar.getLength(), mVar.getPosition(), this.f508d, z11);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0028  */
    @Nullable
    public final g q(m mVar) throws IOException {
        int i11;
        c0 c0Var = new c0(this.f508d.f32795c);
        mVar.peekFully(c0Var.d(), 0, this.f508d.f32795c);
        b0.a aVar = this.f508d;
        if ((aVar.f32793a & 1) != 0) {
            if (aVar.f32797e != 1) {
                i11 = 36;
            } else {
                i11 = 21;
            }
        } else if (aVar.f32797e != 1) {
            i11 = 21;
        } else {
            i11 = 13;
        }
        int iL = l(c0Var, i11);
        if (iL != 1483304551 && iL != 1231971951) {
            if (iL != 1447187017) {
                mVar.resetPeekPosition();
                return null;
            }
            h hVarB = h.b(mVar.getLength(), mVar.getPosition(), this.f508d, c0Var);
            mVar.skipFully(this.f508d.f32795c);
            return hVarB;
        }
        i iVarB = i.b(mVar.getLength(), mVar.getPosition(), this.f508d, c0Var);
        if (iVarB != null && !this.f509e.a()) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition(i11 + 141);
            mVar.peekFully(this.f507c.d(), 0, 3);
            this.f507c.P(0);
            this.f509e.d(this.f507c.G());
        }
        mVar.skipFully(this.f508d.f32795c);
        return (iVarB == null || iVarB.isSeekable() || iL != 1231971951) ? iVarB : j(mVar, false);
    }

    public final boolean r(m mVar) throws IOException {
        g gVar = this.f521q;
        if (gVar != null) {
            long jA = gVar.a();
            if (jA != -1 && mVar.getPeekPosition() > jA - 4) {
                return true;
            }
        }
        try {
            return !mVar.peekFully(this.f507c.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @Override // tg.l
    public void release() {
    }

    public final int s(m mVar) throws IOException {
        if (this.f515k == 0) {
            try {
                u(mVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f521q == null) {
            g gVarG = g(mVar);
            this.f521q = gVarG;
            this.f512h.g(gVarG);
            this.f514j.e(new m1.b().e0(this.f508d.f32794b).W(4096).H(this.f508d.f32797e).f0(this.f508d.f32796d).N(this.f509e.f77096a).O(this.f509e.f77097b).X((this.f505a & 8) != 0 ? null : this.f516l).E());
            this.f519o = mVar.getPosition();
        } else if (this.f519o != 0) {
            long position = mVar.getPosition();
            long j11 = this.f519o;
            if (position < j11) {
                mVar.skipFully((int) (j11 - position));
            }
        }
        return t(mVar);
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f515k = 0;
        this.f517m = C.TIME_UNSET;
        this.f518n = 0L;
        this.f520p = 0;
        this.f524t = j12;
        g gVar = this.f521q;
        if (!(gVar instanceof b) || ((b) gVar).b(j12)) {
            return;
        }
        this.f523s = true;
        this.f514j = this.f511g;
    }

    public final boolean u(m mVar, boolean z11) throws IOException {
        int i11;
        int peekPosition;
        int iJ;
        int i12 = z11 ? 32768 : 131072;
        mVar.resetPeekPosition();
        if (mVar.getPosition() == 0) {
            Metadata metadataA = this.f510f.a(mVar, (this.f505a & 8) == 0 ? null : f504v);
            this.f516l = metadataA;
            if (metadataA != null) {
                this.f509e.c(metadataA);
            }
            peekPosition = (int) mVar.getPeekPosition();
            if (!z11) {
                mVar.skipFully(peekPosition);
            }
            i11 = 0;
        } else {
            i11 = 0;
            peekPosition = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (r(mVar)) {
                if (i13 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.f507c.P(0);
            int iN = this.f507c.n();
            if ((i11 == 0 || m(iN, i11)) && (iJ = b0.j(iN)) != -1) {
                i13++;
                if (i13 != 1) {
                    if (i13 == 4) {
                        break;
                    }
                } else {
                    this.f508d.a(iN);
                    i11 = iN;
                }
                mVar.advancePeekPosition(iJ - 4);
            } else {
                int i15 = i14 + 1;
                if (i14 == i12) {
                    if (z11) {
                        return false;
                    }
                    throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                }
                if (z11) {
                    mVar.resetPeekPosition();
                    mVar.advancePeekPosition(peekPosition + i15);
                } else {
                    mVar.skipFully(1);
                }
                i14 = i15;
                i11 = 0;
                i13 = 0;
            }
        }
        if (z11) {
            mVar.skipFully(peekPosition + i14);
        } else {
            mVar.resetPeekPosition();
        }
        this.f515k = i11;
        return true;
    }
}

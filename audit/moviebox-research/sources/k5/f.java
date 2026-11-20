package k5;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import u4.f0;
import u4.h0;
import u4.j0;
import u4.l0;
import u4.q;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements s {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final y f68251u = new y() { // from class: k5.d
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return f.p();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final g5.b.a f68252v = new g5.b.a() { // from class: k5.e
        @Override // g5.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            return f.q(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f68255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0.a f68256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0 f68257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f68258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r0 f68259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u f68260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0 f68261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r0 f68262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f68263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Metadata f68264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f68265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f68266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f68267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f68268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f68269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f68270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f68271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f68272t;

    public f() {
        this(0);
    }

    public f(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public f(int i11, long j11) {
        this.f68253a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f68254b = j11;
        this.f68255c = new c0(10);
        this.f68256d = new j0.a();
        this.f68257e = new f0();
        this.f68265m = C.TIME_UNSET;
        this.f68258f = new h0();
        q qVar = new q();
        this.f68259g = qVar;
        this.f68262j = qVar;
    }

    private void g() {
        z3.a.i(this.f68261i);
        u0.i(this.f68260h);
    }

    public static long m(@Nullable Metadata metadata) {
        if (metadata == null) {
            return C.TIME_UNSET;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.f11800id.equals("TLEN")) {
                    return u0.S0(Long.parseLong(textInformationFrame.values.get(0)));
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static int n(c0 c0Var, int i11) {
        if (c0Var.g() >= i11 + 4) {
            c0Var.U(i11);
            int iQ = c0Var.q();
            if (iQ == 1483304551 || iQ == 1231971951) {
                return iQ;
            }
        }
        if (c0Var.g() < 40) {
            return 0;
        }
        c0Var.U(36);
        return c0Var.q() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean o(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] p() {
        return new s[]{new f()};
    }

    public static /* synthetic */ boolean q(int i11, int i12, int i13, int i14, int i15) {
        return (i12 == 67 && i13 == 79 && i14 == 77 && (i15 == 77 || i11 == 2)) || (i12 == 77 && i13 == 76 && i14 == 76 && (i15 == 84 || i11 == 2));
    }

    @Nullable
    public static c r(@Nullable Metadata metadata, long j11) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i11 = 0; i11 < length; i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof MlltFrame) {
                return c.b(j11, (MlltFrame) entry, m(metadata));
            }
        }
        return null;
    }

    private int v(t tVar) throws IOException {
        if (this.f68268p == 0) {
            tVar.resetPeekPosition();
            if (t(tVar)) {
                return -1;
            }
            this.f68255c.U(0);
            int iQ = this.f68255c.q();
            if (!o(iQ, this.f68263k) || j0.j(iQ) == -1) {
                tVar.skipFully(1);
                this.f68263k = 0;
                return 0;
            }
            this.f68256d.a(iQ);
            if (this.f68265m == C.TIME_UNSET) {
                this.f68265m = this.f68269q.getTimeUs(tVar.getPosition());
                if (this.f68254b != C.TIME_UNSET) {
                    this.f68265m += this.f68254b - this.f68269q.getTimeUs(0L);
                }
            }
            j0.a aVar = this.f68256d;
            this.f68268p = aVar.f78317c;
            g gVar = this.f68269q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(i(this.f68266n + ((long) aVar.f78321g)), tVar.getPosition() + ((long) this.f68256d.f78317c));
                if (this.f68271s && bVar.b(this.f68272t)) {
                    this.f68271s = false;
                    this.f68262j = this.f68261i;
                }
            }
        }
        int iD = this.f68262j.d(tVar, this.f68268p, true);
        if (iD == -1) {
            return -1;
        }
        int i11 = this.f68268p - iD;
        this.f68268p = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f68262j.f(i(this.f68266n), 1, this.f68256d.f78317c, 0, null);
        this.f68266n += (long) this.f68256d.f78321g;
        this.f68268p = 0;
        return 0;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return w(tVar, true);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        g();
        int iU = u(tVar);
        if (iU == -1 && (this.f68269q instanceof b)) {
            long jI = i(this.f68266n);
            if (this.f68269q.getDurationUs() != jI) {
                ((b) this.f68269q).d(jI);
                this.f68260h.f(this.f68269q);
            }
        }
        return iU;
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f68260h = uVar;
        r0 r0VarTrack = uVar.track(0, 1);
        this.f68261i = r0VarTrack;
        this.f68262j = r0VarTrack;
        this.f68260h.endTracks();
    }

    public final g h(t tVar) throws IOException {
        long jM;
        long jA;
        g gVarS = s(tVar);
        c cVarR = r(this.f68264l, tVar.getPosition());
        if (this.f68270r) {
            return new g.a();
        }
        if ((this.f68253a & 4) != 0) {
            if (cVarR != null) {
                jM = cVarR.getDurationUs();
                jA = cVarR.a();
            } else if (gVarS != null) {
                jM = gVarS.getDurationUs();
                jA = gVarS.a();
            } else {
                jM = m(this.f68264l);
                jA = -1;
            }
            gVarS = new b(jM, tVar.getPosition(), jA);
        } else if (cVarR != null) {
            gVarS = cVarR;
        } else if (gVarS == null) {
            gVarS = null;
        }
        if (gVarS == null || !(gVarS.isSeekable() || (this.f68253a & 1) == 0)) {
            return l(tVar, (this.f68253a & 2) != 0);
        }
        return gVarS;
    }

    public final long i(long j11) {
        return this.f68265m + ((j11 * 1000000) / ((long) this.f68256d.f78318d));
    }

    public void j() {
        this.f68270r = true;
    }

    public final g k(t tVar, long j11, boolean z11) throws IOException {
        tVar.peekFully(this.f68255c.e(), 0, 4);
        this.f68255c.U(0);
        this.f68256d.a(this.f68255c.q());
        if (tVar.getLength() != -1) {
            j11 = tVar.getLength();
        }
        return new a(j11, tVar.getPosition(), this.f68256d, z11);
    }

    public final g l(t tVar, boolean z11) throws IOException {
        return k(tVar, -1L, z11);
    }

    @Override // u4.s
    public void release() {
    }

    @Nullable
    public final g s(t tVar) throws IOException {
        int i11;
        int i12;
        c0 c0Var = new c0(this.f68256d.f78317c);
        tVar.peekFully(c0Var.e(), 0, this.f68256d.f78317c);
        j0.a aVar = this.f68256d;
        int i13 = 21;
        if ((aVar.f78315a & 1) != 0) {
            if (aVar.f78319e != 1) {
                i13 = 36;
            }
        } else if (aVar.f78319e == 1) {
            i13 = 13;
        }
        int iN = n(c0Var, i13);
        if (iN != 1231971951) {
            if (iN == 1447187017) {
                h hVarB = h.b(tVar.getLength(), tVar.getPosition(), this.f68256d, c0Var);
                tVar.skipFully(this.f68256d.f78317c);
                return hVarB;
            }
            if (iN != 1483304551) {
                tVar.resetPeekPosition();
                return null;
            }
        }
        i iVarA = i.a(this.f68256d, c0Var);
        if (!this.f68257e.a() && (i11 = iVarA.f68281d) != -1 && (i12 = iVarA.f68282e) != -1) {
            f0 f0Var = this.f68257e;
            f0Var.f78270a = i11;
            f0Var.f78271b = i12;
        }
        long position = tVar.getPosition();
        tVar.skipFully(this.f68256d.f78317c);
        if (iN == 1483304551) {
            return j.b(tVar.getLength(), iVarA, position);
        }
        long j11 = iVarA.f68280c;
        return k(tVar, j11 != -1 ? position + j11 : -1L, false);
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f68263k = 0;
        this.f68265m = C.TIME_UNSET;
        this.f68266n = 0L;
        this.f68268p = 0;
        this.f68272t = j12;
        g gVar = this.f68269q;
        if (!(gVar instanceof b) || ((b) gVar).b(j12)) {
            return;
        }
        this.f68271s = true;
        this.f68262j = this.f68259g;
    }

    public final boolean t(t tVar) throws IOException {
        g gVar = this.f68269q;
        if (gVar != null) {
            long jA = gVar.a();
            if (jA != -1 && tVar.getPeekPosition() > jA - 4) {
                return true;
            }
        }
        try {
            return !tVar.peekFully(this.f68255c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final int u(t tVar) throws IOException {
        if (this.f68263k == 0) {
            try {
                w(tVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f68269q == null) {
            g gVarH = h(tVar);
            this.f68269q = gVarH;
            this.f68260h.f(gVarH);
            androidx.media3.common.y.b bVarD0 = new androidx.media3.common.y.b().k0(this.f68256d.f78316b).c0(4096).L(this.f68256d.f78319e).l0(this.f68256d.f78318d).S(this.f68257e.f78270a).T(this.f68257e.f78271b).d0((this.f68253a & 8) != 0 ? null : this.f68264l);
            if (this.f68269q.e() != -2147483647) {
                bVarD0.K(this.f68269q.e());
            }
            this.f68262j.b(bVarD0.I());
            this.f68267o = tVar.getPosition();
        } else if (this.f68267o != 0) {
            long position = tVar.getPosition();
            long j11 = this.f68267o;
            if (position < j11) {
                tVar.skipFully((int) (j11 - position));
            }
        }
        return v(tVar);
    }

    public final boolean w(t tVar, boolean z11) throws IOException {
        int i11;
        int peekPosition;
        int iJ;
        int i12 = z11 ? 32768 : 131072;
        tVar.resetPeekPosition();
        if (tVar.getPosition() == 0) {
            Metadata metadataA = this.f68258f.a(tVar, (this.f68253a & 8) == 0 ? null : f68252v);
            this.f68264l = metadataA;
            if (metadataA != null) {
                this.f68257e.c(metadataA);
            }
            peekPosition = (int) tVar.getPeekPosition();
            if (!z11) {
                tVar.skipFully(peekPosition);
            }
            i11 = 0;
        } else {
            i11 = 0;
            peekPosition = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (t(tVar)) {
                if (i13 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.f68255c.U(0);
            int iQ = this.f68255c.q();
            if ((i11 == 0 || o(iQ, i11)) && (iJ = j0.j(iQ)) != -1) {
                i13++;
                if (i13 != 1) {
                    if (i13 == 4) {
                        break;
                    }
                } else {
                    this.f68256d.a(iQ);
                    i11 = iQ;
                }
                tVar.advancePeekPosition(iJ - 4);
            } else {
                int i15 = i14 + 1;
                if (i14 == i12) {
                    if (z11) {
                        return false;
                    }
                    throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                }
                if (z11) {
                    tVar.resetPeekPosition();
                    tVar.advancePeekPosition(peekPosition + i15);
                } else {
                    tVar.skipFully(1);
                }
                i14 = i15;
                i11 = 0;
                i13 = 0;
            }
        }
        if (z11) {
            tVar.skipFully(peekPosition + i14);
        } else {
            tVar.resetPeekPosition();
        }
        this.f68263k = i11;
        return true;
    }
}

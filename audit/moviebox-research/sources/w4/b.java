package w4;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import u4.l0;
import u4.m0;
import u4.p;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import z3.c0;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f79241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f79242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f79243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o5.s.a f79244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f79245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f79246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w4.c f79247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f79248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e[] f79249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f79250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public e f79251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f79252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f79253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f79254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f79255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f79256p;

    /* JADX INFO: renamed from: w4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0882b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f79257a;

        public C0882b(long j11) {
            this.f79257a = j11;
        }

        @Override // u4.m0
        public long getDurationUs() {
            return this.f79257a;
        }

        @Override // u4.m0
        public m0.a getSeekPoints(long j11) {
            m0.a aVarI = b.this.f79249i[0].i(j11);
            for (int i11 = 1; i11 < b.this.f79249i.length; i11++) {
                m0.a aVarI2 = b.this.f79249i[i11].i(j11);
                if (aVarI2.f78345a.f78354b < aVarI.f78345a.f78354b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // u4.m0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f79259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f79260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f79261c;

        public c() {
        }

        public void a(c0 c0Var) {
            this.f79259a = c0Var.u();
            this.f79260b = c0Var.u();
            this.f79261c = 0;
        }

        public void b(c0 c0Var) throws ParserException {
            a(c0Var);
            if (this.f79259a == 1414744396) {
                this.f79261c = c0Var.u();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f79259a, null);
        }
    }

    public b(int i11, o5.s.a aVar) {
        this.f79244d = aVar;
        this.f79243c = (i11 & 1) == 0;
        this.f79241a = new c0(12);
        this.f79242b = new c();
        this.f79246f = new p();
        this.f79249i = new e[0];
        this.f79253m = -1L;
        this.f79254n = -1L;
        this.f79252l = -1;
        this.f79248h = C.TIME_UNSET;
    }

    public static void e(t tVar) throws IOException {
        if ((tVar.getPosition() & 1) == 1) {
            tVar.skipFully(1);
        }
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        tVar.peekFully(this.f79241a.e(), 0, 12);
        this.f79241a.U(0);
        if (this.f79241a.u() != 1179011410) {
            return false;
        }
        this.f79241a.V(4);
        return this.f79241a.u() == 541677121;
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        if (m(tVar, l0Var)) {
            return 1;
        }
        switch (this.f79245e) {
            case 0:
                if (!b(tVar)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                tVar.skipFully(12);
                this.f79245e = 1;
                return 0;
            case 1:
                tVar.readFully(this.f79241a.e(), 0, 12);
                this.f79241a.U(0);
                this.f79242b.b(this.f79241a);
                c cVar = this.f79242b;
                if (cVar.f79261c == 1819436136) {
                    this.f79252l = cVar.f79260b;
                    this.f79245e = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.f79242b.f79261c, null);
            case 2:
                int i11 = this.f79252l - 4;
                c0 c0Var = new c0(i11);
                tVar.readFully(c0Var.e(), 0, i11);
                h(c0Var);
                this.f79245e = 3;
                return 0;
            case 3:
                if (this.f79253m != -1) {
                    long position = tVar.getPosition();
                    long j11 = this.f79253m;
                    if (position != j11) {
                        this.f79250j = j11;
                        return 0;
                    }
                }
                tVar.peekFully(this.f79241a.e(), 0, 12);
                tVar.resetPeekPosition();
                this.f79241a.U(0);
                this.f79242b.a(this.f79241a);
                int iU = this.f79241a.u();
                int i12 = this.f79242b.f79259a;
                if (i12 == 1179011410) {
                    tVar.skipFully(12);
                    return 0;
                }
                if (i12 != 1414744396 || iU != 1769369453) {
                    this.f79250j = tVar.getPosition() + ((long) this.f79242b.f79260b) + 8;
                    return 0;
                }
                long position2 = tVar.getPosition();
                this.f79253m = position2;
                this.f79254n = position2 + ((long) this.f79242b.f79260b) + 8;
                if (!this.f79256p) {
                    if (((w4.c) z3.a.e(this.f79247g)).a()) {
                        this.f79245e = 4;
                        this.f79250j = this.f79254n;
                        return 0;
                    }
                    this.f79246f.f(new m0.b(this.f79248h));
                    this.f79256p = true;
                }
                this.f79250j = tVar.getPosition() + 12;
                this.f79245e = 6;
                return 0;
            case 4:
                tVar.readFully(this.f79241a.e(), 0, 8);
                this.f79241a.U(0);
                int iU2 = this.f79241a.u();
                int iU3 = this.f79241a.u();
                if (iU2 == 829973609) {
                    this.f79245e = 5;
                    this.f79255o = iU3;
                } else {
                    this.f79250j = tVar.getPosition() + ((long) iU3);
                }
                return 0;
            case 5:
                c0 c0Var2 = new c0(this.f79255o);
                tVar.readFully(c0Var2.e(), 0, this.f79255o);
                i(c0Var2);
                this.f79245e = 6;
                this.f79250j = this.f79253m;
                return 0;
            case 6:
                return l(tVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f79245e = 0;
        if (this.f79243c) {
            uVar = new o5.u(uVar, this.f79244d);
        }
        this.f79246f = uVar;
        this.f79250j = -1L;
    }

    @Nullable
    public final e g(int i11) {
        for (e eVar : this.f79249i) {
            if (eVar.j(i11)) {
                return eVar;
            }
        }
        return null;
    }

    public final void h(c0 c0Var) throws IOException {
        f fVarC = f.c(1819436136, c0Var);
        if (fVarC.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + fVarC.getType(), null);
        }
        w4.c cVar = (w4.c) fVarC.b(w4.c.class);
        if (cVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.f79247g = cVar;
        this.f79248h = ((long) cVar.f79264c) * ((long) cVar.f79262a);
        ArrayList arrayList = new ArrayList();
        g1<w4.a> it = fVarC.f79284a.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            w4.a next = it.next();
            if (next.getType() == 1819440243) {
                int i12 = i11 + 1;
                e eVarK = k((f) next, i11);
                if (eVarK != null) {
                    arrayList.add(eVarK);
                }
                i11 = i12;
            }
        }
        this.f79249i = (e[]) arrayList.toArray(new e[0]);
        this.f79246f.endTracks();
    }

    public final void i(c0 c0Var) {
        long j11 = j(c0Var);
        while (c0Var.a() >= 16) {
            int iU = c0Var.u();
            int iU2 = c0Var.u();
            long jU = ((long) c0Var.u()) + j11;
            c0Var.u();
            e eVarG = g(iU);
            if (eVarG != null) {
                if ((iU2 & 16) == 16) {
                    eVarG.b(jU);
                }
                eVarG.k();
            }
        }
        for (e eVar : this.f79249i) {
            eVar.c();
        }
        this.f79256p = true;
        this.f79246f.f(new C0882b(this.f79248h));
    }

    public final long j(c0 c0Var) {
        if (c0Var.a() < 16) {
            return 0L;
        }
        int iF = c0Var.f();
        c0Var.V(8);
        long jU = c0Var.u();
        long j11 = this.f79253m;
        long j12 = jU <= j11 ? j11 + 8 : 0L;
        c0Var.U(iF);
        return j12;
    }

    @Nullable
    public final e k(f fVar, int i11) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            o.h("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            o.h("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = dVar.a();
        y yVar = gVar.f79286a;
        y.b bVarB = yVar.b();
        bVarB.W(i11);
        int i12 = dVar.f79271f;
        if (i12 != 0) {
            bVarB.c0(i12);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            bVarB.Z(hVar.f79287a);
        }
        int iK = f0.k(yVar.f9501m);
        if (iK != 1 && iK != 2) {
            return null;
        }
        r0 r0VarTrack = this.f79246f.track(i11, iK);
        r0VarTrack.b(bVarB.I());
        e eVar = new e(i11, iK, jA, dVar.f79270e, r0VarTrack);
        this.f79248h = jA;
        return eVar;
    }

    public final int l(t tVar) throws IOException {
        if (tVar.getPosition() >= this.f79254n) {
            return -1;
        }
        e eVar = this.f79251k;
        if (eVar == null) {
            e(tVar);
            tVar.peekFully(this.f79241a.e(), 0, 12);
            this.f79241a.U(0);
            int iU = this.f79241a.u();
            if (iU == 1414744396) {
                this.f79241a.U(8);
                tVar.skipFully(this.f79241a.u() != 1769369453 ? 8 : 12);
                tVar.resetPeekPosition();
                return 0;
            }
            int iU2 = this.f79241a.u();
            if (iU == 1263424842) {
                this.f79250j = tVar.getPosition() + ((long) iU2) + 8;
                return 0;
            }
            tVar.skipFully(8);
            tVar.resetPeekPosition();
            e eVarG = g(iU);
            if (eVarG == null) {
                this.f79250j = tVar.getPosition() + ((long) iU2);
                return 0;
            }
            eVarG.n(iU2);
            this.f79251k = eVarG;
        } else if (eVar.m(tVar)) {
            this.f79251k = null;
        }
        return 0;
    }

    public final boolean m(t tVar, l0 l0Var) throws IOException {
        boolean z11;
        if (this.f79250j != -1) {
            long position = tVar.getPosition();
            long j11 = this.f79250j;
            if (j11 < position || j11 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                l0Var.f78322a = j11;
                z11 = true;
            } else {
                tVar.skipFully((int) (j11 - position));
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.f79250j = -1L;
        return z11;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f79250j = -1L;
        this.f79251k = null;
        for (e eVar : this.f79249i) {
            eVar.o(j11);
        }
        if (j11 != 0) {
            this.f79245e = 6;
        } else if (this.f79249i.length == 0) {
            this.f79245e = 0;
        } else {
            this.f79245e = 3;
        }
    }
}

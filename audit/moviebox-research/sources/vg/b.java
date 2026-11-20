package vg;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import tg.a0;
import tg.b0;
import tg.e0;
import tg.j;
import tg.l;
import tg.m;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78773c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vg.c f78775e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f78778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public e f78779i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f78783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f78784n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f78771a = new c0(12);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f78772b = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f78774d = new j();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e[] f78777g = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f78781k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f78782l = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78780j = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f78776f = C.TIME_UNSET;

    /* JADX INFO: renamed from: vg.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0874b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f78785a;

        public C0874b(long j11) {
            this.f78785a = j11;
        }

        @Override // tg.b0
        public long getDurationUs() {
            return this.f78785a;
        }

        @Override // tg.b0
        public b0.a getSeekPoints(long j11) {
            b0.a aVarI = b.this.f78777g[0].i(j11);
            for (int i11 = 1; i11 < b.this.f78777g.length; i11++) {
                b0.a aVarI2 = b.this.f78777g[i11].i(j11);
                if (aVarI2.f76991a.f76997b < aVarI.f76991a.f76997b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // tg.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f78787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f78788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f78789c;

        public c() {
        }

        public void a(c0 c0Var) {
            this.f78787a = c0Var.q();
            this.f78788b = c0Var.q();
            this.f78789c = 0;
        }

        public void b(c0 c0Var) throws ParserException {
            a(c0Var);
            if (this.f78787a == 1414744396) {
                this.f78789c = c0Var.q();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f78787a, null);
        }
    }

    public static void e(m mVar) throws IOException {
        if ((mVar.getPosition() & 1) == 1) {
            mVar.skipFully(1);
        }
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        mVar.peekFully(this.f78771a.d(), 0, 12);
        this.f78771a.P(0);
        if (this.f78771a.q() != 1179011410) {
            return false;
        }
        this.f78771a.Q(4);
        return this.f78771a.q() == 541677121;
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        if (l(mVar, a0Var)) {
            return 1;
        }
        switch (this.f78773c) {
            case 0:
                if (!b(mVar)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                mVar.skipFully(12);
                this.f78773c = 1;
                return 0;
            case 1:
                mVar.readFully(this.f78771a.d(), 0, 12);
                this.f78771a.P(0);
                this.f78772b.b(this.f78771a);
                c cVar = this.f78772b;
                if (cVar.f78789c == 1819436136) {
                    this.f78780j = cVar.f78788b;
                    this.f78773c = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.f78772b.f78789c, null);
            case 2:
                int i11 = this.f78780j - 4;
                c0 c0Var = new c0(i11);
                mVar.readFully(c0Var.d(), 0, i11);
                g(c0Var);
                this.f78773c = 3;
                return 0;
            case 3:
                if (this.f78781k != -1) {
                    long position = mVar.getPosition();
                    long j11 = this.f78781k;
                    if (position != j11) {
                        this.f78778h = j11;
                        return 0;
                    }
                }
                mVar.peekFully(this.f78771a.d(), 0, 12);
                mVar.resetPeekPosition();
                this.f78771a.P(0);
                this.f78772b.a(this.f78771a);
                int iQ = this.f78771a.q();
                int i12 = this.f78772b.f78787a;
                if (i12 == 1179011410) {
                    mVar.skipFully(12);
                    return 0;
                }
                if (i12 != 1414744396 || iQ != 1769369453) {
                    this.f78778h = mVar.getPosition() + ((long) this.f78772b.f78788b) + 8;
                    return 0;
                }
                long position2 = mVar.getPosition();
                this.f78781k = position2;
                this.f78782l = position2 + ((long) this.f78772b.f78788b) + 8;
                if (!this.f78784n) {
                    if (((vg.c) com.google.android.exoplayer2.util.a.e(this.f78775e)).a()) {
                        this.f78773c = 4;
                        this.f78778h = this.f78782l;
                        return 0;
                    }
                    this.f78774d.g(new b0.b(this.f78776f));
                    this.f78784n = true;
                }
                this.f78778h = mVar.getPosition() + 12;
                this.f78773c = 6;
                return 0;
            case 4:
                mVar.readFully(this.f78771a.d(), 0, 8);
                this.f78771a.P(0);
                int iQ2 = this.f78771a.q();
                int iQ3 = this.f78771a.q();
                if (iQ2 == 829973609) {
                    this.f78773c = 5;
                    this.f78783m = iQ3;
                } else {
                    this.f78778h = mVar.getPosition() + ((long) iQ3);
                }
                return 0;
            case 5:
                c0 c0Var2 = new c0(this.f78783m);
                mVar.readFully(c0Var2.d(), 0, this.f78783m);
                h(c0Var2);
                this.f78773c = 6;
                this.f78778h = this.f78781k;
                return 0;
            case 6:
                return k(mVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f78773c = 0;
        this.f78774d = nVar;
        this.f78778h = -1L;
    }

    @Nullable
    public final e f(int i11) {
        for (e eVar : this.f78777g) {
            if (eVar.j(i11)) {
                return eVar;
            }
        }
        return null;
    }

    public final void g(c0 c0Var) throws IOException {
        f fVarC = f.c(1819436136, c0Var);
        if (fVarC.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + fVarC.getType(), null);
        }
        vg.c cVar = (vg.c) fVarC.b(vg.c.class);
        if (cVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.f78775e = cVar;
        this.f78776f = ((long) cVar.f78792c) * ((long) cVar.f78790a);
        ArrayList arrayList = new ArrayList();
        g1<vg.a> it = fVarC.f78812a.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            vg.a next = it.next();
            if (next.getType() == 1819440243) {
                int i12 = i11 + 1;
                e eVarJ = j((f) next, i11);
                if (eVarJ != null) {
                    arrayList.add(eVarJ);
                }
                i11 = i12;
            }
        }
        this.f78777g = (e[]) arrayList.toArray(new e[0]);
        this.f78774d.endTracks();
    }

    public final void h(c0 c0Var) {
        long jI = i(c0Var);
        while (c0Var.a() >= 16) {
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            long jQ = ((long) c0Var.q()) + jI;
            c0Var.q();
            e eVarF = f(iQ);
            if (eVarF != null) {
                if ((iQ2 & 16) == 16) {
                    eVarF.b(jQ);
                }
                eVarF.k();
            }
        }
        for (e eVar : this.f78777g) {
            eVar.c();
        }
        this.f78784n = true;
        this.f78774d.g(new C0874b(this.f78776f));
    }

    public final long i(c0 c0Var) {
        if (c0Var.a() < 16) {
            return 0L;
        }
        int iE = c0Var.e();
        c0Var.Q(8);
        long jQ = c0Var.q();
        long j11 = this.f78781k;
        long j12 = jQ <= j11 ? j11 + 8 : 0L;
        c0Var.P(iE);
        return j12;
    }

    @Nullable
    public final e j(f fVar, int i11) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            s.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            s.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = dVar.a();
        m1 m1Var = gVar.f78814a;
        m1.b bVarB = m1Var.b();
        bVarB.R(i11);
        int i12 = dVar.f78799f;
        if (i12 != 0) {
            bVarB.W(i12);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            bVarB.U(hVar.f78815a);
        }
        int iK = w.k(m1Var.f33445m);
        if (iK != 1 && iK != 2) {
            return null;
        }
        e0 e0VarTrack = this.f78774d.track(i11, iK);
        e0VarTrack.e(bVarB.E());
        e eVar = new e(i11, iK, jA, dVar.f78798e, e0VarTrack);
        this.f78776f = jA;
        return eVar;
    }

    public final int k(m mVar) throws IOException {
        if (mVar.getPosition() >= this.f78782l) {
            return -1;
        }
        e eVar = this.f78779i;
        if (eVar == null) {
            e(mVar);
            mVar.peekFully(this.f78771a.d(), 0, 12);
            this.f78771a.P(0);
            int iQ = this.f78771a.q();
            if (iQ == 1414744396) {
                this.f78771a.P(8);
                mVar.skipFully(this.f78771a.q() != 1769369453 ? 8 : 12);
                mVar.resetPeekPosition();
                return 0;
            }
            int iQ2 = this.f78771a.q();
            if (iQ == 1263424842) {
                this.f78778h = mVar.getPosition() + ((long) iQ2) + 8;
                return 0;
            }
            mVar.skipFully(8);
            mVar.resetPeekPosition();
            e eVarF = f(iQ);
            if (eVarF == null) {
                this.f78778h = mVar.getPosition() + ((long) iQ2);
                return 0;
            }
            eVarF.n(iQ2);
            this.f78779i = eVarF;
        } else if (eVar.m(mVar)) {
            this.f78779i = null;
        }
        return 0;
    }

    public final boolean l(m mVar, a0 a0Var) throws IOException {
        boolean z11;
        if (this.f78778h != -1) {
            long position = mVar.getPosition();
            long j11 = this.f78778h;
            if (j11 < position || j11 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                a0Var.f76990a = j11;
                z11 = true;
            } else {
                mVar.skipFully((int) (j11 - position));
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.f78778h = -1L;
        return z11;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f78778h = -1L;
        this.f78779i = null;
        for (e eVar : this.f78777g) {
            eVar.o(j11);
        }
        if (j11 != 0) {
            this.f78773c = 6;
        } else if (this.f78777g.length == 0) {
            this.f78773c = 0;
        } else {
            this.f78773c = 3;
        }
    }
}

package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.n;
import androidx.media3.exoplayer.w1;
import c4.o;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import h4.i;
import h4.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import o5.s;
import q4.e;
import q4.f;
import q4.g;
import q4.l;
import s4.z;
import u4.h;
import z3.k0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements androidx.media3.exoplayer.dash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f10163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g4.b f10164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f10165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.media3.datasource.a f10167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f10168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final d.c f10170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b[] f10171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f10172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h4.c f10173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public IOException f10175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f10177o = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements androidx.media3.exoplayer.dash.a.InterfaceC0095a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.datasource.a.InterfaceC0090a f10178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f.a f10180c;

        public a(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this(interfaceC0090a, 1);
        }

        public a(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, int i11) {
            this(q4.d.f74302k, interfaceC0090a, i11);
        }

        public a(f.a aVar, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, int i11) {
            this.f10180c = aVar;
            this.f10178a = interfaceC0090a;
            this.f10179b = i11;
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0095a
        public y c(y yVar) {
            return this.f10180c.c(yVar);
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0095a
        public androidx.media3.exoplayer.dash.a d(n nVar, h4.c cVar, g4.b bVar, int i11, int[] iArr, z zVar, int i12, long j11, boolean z11, List<y> list, @Nullable d.c cVar2, @Nullable o oVar, x3 x3Var, @Nullable androidx.media3.exoplayer.upstream.f fVar) {
            androidx.media3.datasource.a aVarCreateDataSource = this.f10178a.createDataSource();
            if (oVar != null) {
                aVarCreateDataSource.c(oVar);
            }
            return new c(this.f10180c, nVar, cVar, bVar, i11, iArr, zVar, i12, aVarCreateDataSource, j11, this.f10179b, z11, list, cVar2, x3Var, fVar);
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0095a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(boolean z11) {
            this.f10180c.b(z11);
            return this;
        }

        @Override // androidx.media3.exoplayer.dash.a.InterfaceC0095a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(s.a aVar) {
            this.f10180c.a(aVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final f f10181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f10182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h4.b f10183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final g4.f f10184d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f10185e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f10186f;

        public b(long j11, j jVar, h4.b bVar, @Nullable f fVar, long j12, @Nullable g4.f fVar2) {
            this.f10185e = j11;
            this.f10182b = jVar;
            this.f10183c = bVar;
            this.f10186f = j12;
            this.f10181a = fVar;
            this.f10184d = fVar2;
        }

        @CheckResult
        public b b(long j11, j jVar) throws BehindLiveWindowException {
            long jE;
            g4.f fVarK = this.f10182b.k();
            g4.f fVarK2 = jVar.k();
            if (fVarK == null) {
                return new b(j11, jVar, this.f10183c, this.f10181a, this.f10186f, fVarK);
            }
            if (!fVarK.g()) {
                return new b(j11, jVar, this.f10183c, this.f10181a, this.f10186f, fVarK2);
            }
            long jF = fVarK.f(j11);
            if (jF == 0) {
                return new b(j11, jVar, this.f10183c, this.f10181a, this.f10186f, fVarK2);
            }
            z3.a.i(fVarK2);
            long jH = fVarK.h();
            long timeUs = fVarK.getTimeUs(jH);
            long jE2 = jF + jH;
            long j12 = jE2 - 1;
            long timeUs2 = fVarK.getTimeUs(j12) + fVarK.a(j12, j11);
            long jH2 = fVarK2.h();
            long timeUs3 = fVarK2.getTimeUs(jH2);
            long j13 = this.f10186f;
            if (timeUs2 == timeUs3) {
                jE = j13 + (jE2 - jH2);
            } else {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    jE = j13 - (fVarK2.e(timeUs, j11) - jH);
                } else {
                    jE2 = fVarK.e(timeUs3, j11);
                    jE = j13 + (jE2 - jH2);
                }
            }
            return new b(j11, jVar, this.f10183c, this.f10181a, jE, fVarK2);
        }

        @CheckResult
        public b c(g4.f fVar) {
            return new b(this.f10185e, this.f10182b, this.f10183c, this.f10181a, this.f10186f, fVar);
        }

        @CheckResult
        public b d(h4.b bVar) {
            return new b(this.f10185e, this.f10182b, bVar, this.f10181a, this.f10186f, this.f10184d);
        }

        public long e(long j11) {
            return ((g4.f) z3.a.i(this.f10184d)).b(this.f10185e, j11) + this.f10186f;
        }

        public long f() {
            return ((g4.f) z3.a.i(this.f10184d)).h() + this.f10186f;
        }

        public long g(long j11) {
            return (e(j11) + ((g4.f) z3.a.i(this.f10184d)).i(this.f10185e, j11)) - 1;
        }

        public long h() {
            return ((g4.f) z3.a.i(this.f10184d)).f(this.f10185e);
        }

        public long i(long j11) {
            return k(j11) + ((g4.f) z3.a.i(this.f10184d)).a(j11 - this.f10186f, this.f10185e);
        }

        public long j(long j11) {
            return ((g4.f) z3.a.i(this.f10184d)).e(j11, this.f10185e) + this.f10186f;
        }

        public long k(long j11) {
            return ((g4.f) z3.a.i(this.f10184d)).getTimeUs(j11 - this.f10186f);
        }

        public i l(long j11) {
            return ((g4.f) z3.a.i(this.f10184d)).d(j11 - this.f10186f);
        }

        public boolean m(long j11, long j12) {
            return ((g4.f) z3.a.i(this.f10184d)).g() || j12 == C.TIME_UNSET || i(j11) <= j12;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.dash.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0096c extends q4.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f10187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f10188f;

        public C0096c(b bVar, long j11, long j12, long j13) {
            super(j11, j12);
            this.f10187e = bVar;
            this.f10188f = j13;
        }

        @Override // q4.n
        public long a() {
            c();
            return this.f10187e.k(d());
        }

        @Override // q4.n
        public long b() {
            c();
            return this.f10187e.i(d());
        }
    }

    public c(f.a aVar, n nVar, h4.c cVar, g4.b bVar, int i11, int[] iArr, z zVar, int i12, androidx.media3.datasource.a aVar2, long j11, int i13, boolean z11, List<y> list, @Nullable d.c cVar2, x3 x3Var, @Nullable androidx.media3.exoplayer.upstream.f fVar) {
        this.f10163a = nVar;
        this.f10173k = cVar;
        this.f10164b = bVar;
        this.f10165c = iArr;
        this.f10172j = zVar;
        this.f10166d = i12;
        this.f10167e = aVar2;
        this.f10174l = i11;
        this.f10168f = j11;
        this.f10169g = i13;
        this.f10170h = cVar2;
        long jF = cVar.f(i11);
        ArrayList<j> arrayListL = l();
        this.f10171i = new b[zVar.length()];
        int i14 = 0;
        while (i14 < this.f10171i.length) {
            j jVar = arrayListL.get(zVar.getIndexInTrackGroup(i14));
            h4.b bVarJ = bVar.j(jVar.f66303c);
            int i15 = i14;
            this.f10171i[i15] = new b(jF, jVar, bVarJ == null ? jVar.f66303c.get(0) : bVarJ, aVar.d(i12, jVar.f66302b, z11, list, cVar2, x3Var), 0L, jVar.k());
            i14 = i15 + 1;
        }
    }

    @Override // androidx.media3.exoplayer.dash.a
    public void a(h4.c cVar, int i11) {
        try {
            this.f10173k = cVar;
            this.f10174l = i11;
            long jF = cVar.f(i11);
            ArrayList<j> arrayListL = l();
            for (int i12 = 0; i12 < this.f10171i.length; i12++) {
                j jVar = arrayListL.get(this.f10172j.getIndexInTrackGroup(i12));
                b[] bVarArr = this.f10171i;
                bVarArr[i12] = bVarArr[i12].b(jF, jVar);
            }
        } catch (BehindLiveWindowException e11) {
            this.f10175m = e11;
        }
    }

    @Override // q4.i
    public long b(long j11, b3 b3Var) {
        for (b bVar : this.f10171i) {
            if (bVar.f10184d != null) {
                long jH = bVar.h();
                if (jH != 0) {
                    long j12 = bVar.j(j11);
                    long jK = bVar.k(j12);
                    return b3Var.a(j11, jK, (jK >= j11 || (jH != -1 && j12 >= (bVar.f() + jH) - 1)) ? jK : bVar.k(j12 + 1));
                }
            }
        }
        return j11;
    }

    @Override // q4.i
    public boolean c(e eVar, boolean z11, m.c cVar, m mVar) {
        m.b bVarD;
        if (!z11) {
            return false;
        }
        d.c cVar2 = this.f10170h;
        if (cVar2 != null && cVar2.j(eVar)) {
            return true;
        }
        if (!this.f10173k.f66255d && (eVar instanceof q4.m)) {
            IOException iOException = cVar.f11498c;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.f10171i[this.f10172j.e(eVar.f74325d)];
                long jH = bVar.h();
                if (jH != -1 && jH != 0) {
                    if (((q4.m) eVar).e() > (bVar.f() + jH) - 1) {
                        this.f10176n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f10171i[this.f10172j.e(eVar.f74325d)];
        h4.b bVarJ = this.f10164b.j(bVar2.f10182b.f66303c);
        if (bVarJ != null && !bVar2.f10183c.equals(bVarJ)) {
            return true;
        }
        m.a aVarH = h(this.f10172j, bVar2.f10182b.f66303c);
        if ((!aVarH.a(2) && !aVarH.a(1)) || (bVarD = mVar.d(aVarH, cVar)) == null || !aVarH.a(bVarD.f11494a)) {
            return false;
        }
        int i11 = bVarD.f11494a;
        if (i11 == 2) {
            z zVar = this.f10172j;
            return zVar.f(zVar.e(eVar.f74325d), bVarD.f11495b);
        }
        if (i11 != 1) {
            return false;
        }
        this.f10164b.e(bVar2.f10183c, bVarD.f11495b);
        return true;
    }

    @Override // q4.i
    public boolean d(long j11, e eVar, List<? extends q4.m> list) {
        if (this.f10175m != null) {
            return false;
        }
        return this.f10172j.g(j11, eVar, list);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0150  */
    /* JADX WARN: Code duplicated, block: B:54:0x015b  */
    /* JADX WARN: Code duplicated, block: B:56:0x015e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0168  */
    /* JADX WARN: Code duplicated, block: B:60:0x0177  */
    /* JADX WARN: Code duplicated, block: B:61:0x0179  */
    /* JADX WARN: Code duplicated, block: B:65:0x018e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0196  */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Override // q4.i
    public void e(w1 w1Var, long j11, List<? extends q4.m> list, g gVar) {
        boolean z11;
        ?? r11;
        boolean z12;
        boolean z13;
        long jE;
        long jG;
        boolean z14;
        long jM;
        long jI;
        boolean z15;
        int i11;
        int i12;
        q4.n[] nVarArr;
        long j12;
        long j13;
        if (this.f10175m != null) {
            return;
        }
        long j14 = w1Var.f11756a;
        long j15 = j11 - j14;
        long jS0 = u0.S0(this.f10173k.f66252a) + u0.S0(this.f10173k.c(this.f10174l).f66288b) + j11;
        d.c cVar = this.f10170h;
        if (cVar == null || !cVar.h(jS0)) {
            long jS1 = u0.S0(u0.i0(this.f10168f));
            long jK = k(jS1);
            q4.m mVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f10172j.length();
            q4.n[] nVarArr2 = new q4.n[length];
            int i13 = 0;
            while (i13 < length) {
                b bVar = this.f10171i[i13];
                if (bVar.f10184d == null) {
                    nVarArr2[i13] = q4.n.f74374a;
                    i11 = i13;
                    i12 = length;
                    nVarArr = nVarArr2;
                    j12 = j15;
                    j13 = jS1;
                } else {
                    long jE2 = bVar.e(jS1);
                    long jG2 = bVar.g(jS1);
                    i11 = i13;
                    i12 = length;
                    nVarArr = nVarArr2;
                    j12 = j15;
                    j13 = jS1;
                    long jM2 = m(bVar, mVar, j11, jE2, jG2);
                    if (jM2 < jE2) {
                        nVarArr[i11] = q4.n.f74374a;
                    } else {
                        nVarArr[i11] = new C0096c(p(i11), jM2, jG2, jK);
                    }
                }
                i13 = i11 + 1;
                jS1 = j13;
                length = i12;
                nVarArr2 = nVarArr;
                j15 = j12;
            }
            long j16 = j15;
            long j17 = jS1;
            this.f10172j.h(j14, j16, i(j17, j14), list, nVarArr2);
            int selectedIndex = this.f10172j.getSelectedIndex();
            this.f10177o = SystemClock.elapsedRealtime();
            b bVarP = p(selectedIndex);
            f fVar = bVarP.f10181a;
            if (fVar != null) {
                j jVar = bVarP.f10182b;
                i iVarM = fVar.c() == null ? jVar.m() : null;
                i iVarL = bVarP.f10184d == null ? jVar.l() : null;
                if (iVarM != null || iVarL != null) {
                    gVar.f74331a = n(bVarP, this.f10167e, this.f10172j.getSelectedFormat(), this.f10172j.getSelectionReason(), this.f10172j.getSelectionData(), iVarM, iVarL, null);
                    return;
                }
            }
            long j18 = bVarP.f10185e;
            h4.c cVar2 = this.f10173k;
            if (cVar2.f66255d) {
                z11 = true;
                r11 = 1;
                z12 = this.f10174l == cVar2.d() - 1;
                long j19 = C.TIME_UNSET;
                if (z12 || j18 != C.TIME_UNSET) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (bVarP.h() == 0) {
                    gVar.f74332b = z13;
                    return;
                }
                jE = bVarP.e(j17);
                jG = bVarP.g(j17);
                if (z12) {
                    jI = bVarP.i(jG);
                    if (jI + (jI - bVarP.k(jG)) >= j18) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z13 &= z15;
                }
                z14 = z13;
                jM = m(bVarP, mVar, j11, jE, jG);
                if (jM < jE) {
                    this.f10175m = new BehindLiveWindowException();
                }
                if (jM <= jG || (this.f10176n && jM >= jG)) {
                    gVar.f74332b = z14;
                }
                if (z14 && bVarP.k(jM) >= j18) {
                    gVar.f74332b = r11;
                    return;
                }
                int iMin = (int) Math.min(this.f10169g, (jG - jM) + 1);
                if (j18 != C.TIME_UNSET) {
                    while (iMin > r11 && bVarP.k((((long) iMin) + jM) - 1) >= j18) {
                        iMin--;
                    }
                }
                int i14 = iMin;
                if (list.isEmpty()) {
                    j19 = j11;
                }
                gVar.f74331a = o(bVarP, this.f10167e, this.f10166d, this.f10172j.getSelectedFormat(), this.f10172j.getSelectionReason(), this.f10172j.getSelectionData(), jM, i14, j19, jK, null);
                return;
            }
            z11 = true;
            r11 = z11;
            long j110 = C.TIME_UNSET;
            if (z12) {
                z13 = true;
            } else {
                z13 = true;
            }
            if (bVarP.h() == 0) {
                gVar.f74332b = z13;
                return;
            }
            jE = bVarP.e(j17);
            jG = bVarP.g(j17);
            if (z12) {
                jI = bVarP.i(jG);
                if (jI + (jI - bVarP.k(jG)) >= j18) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z13 &= z15;
            }
            z14 = z13;
            jM = m(bVarP, mVar, j11, jE, jG);
            if (jM < jE) {
                this.f10175m = new BehindLiveWindowException();
            } else {
                if (jM <= jG) {
                }
                gVar.f74332b = z14;
            }
        }
    }

    @Override // q4.i
    public void f(e eVar) {
        h hVarB;
        if (eVar instanceof l) {
            int iE = this.f10172j.e(((l) eVar).f74325d);
            b bVar = this.f10171i[iE];
            if (bVar.f10184d == null && (hVarB = ((f) z3.a.i(bVar.f10181a)).b()) != null) {
                this.f10171i[iE] = bVar.c(new g4.h(hVarB, bVar.f10182b.f66304d));
            }
        }
        d.c cVar = this.f10170h;
        if (cVar != null) {
            cVar.i(eVar);
        }
    }

    @Override // androidx.media3.exoplayer.dash.a
    public void g(z zVar) {
        this.f10172j = zVar;
    }

    @Override // q4.i
    public int getPreferredQueueSize(long j11, List<? extends q4.m> list) {
        return (this.f10175m != null || this.f10172j.length() < 2) ? list.size() : this.f10172j.evaluateQueueSize(j11, list);
    }

    public final m.a h(z zVar, List<h4.b> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = zVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (zVar.d(i12, jElapsedRealtime)) {
                i11++;
            }
        }
        int iF = g4.b.f(list);
        return new m.a(iF, iF - this.f10164b.g(list), length, i11);
    }

    public final long i(long j11, long j12) {
        if (!this.f10173k.f66255d || this.f10171i[0].h() == 0) {
            return C.TIME_UNSET;
        }
        return Math.max(0L, Math.min(k(j11), this.f10171i[0].i(this.f10171i[0].g(j11))) - j12);
    }

    @Nullable
    public final Pair<String, String> j(long j11, i iVar, b bVar) {
        long j12 = j11 + 1;
        if (j12 >= bVar.h()) {
            return null;
        }
        i iVarL = bVar.l(j12);
        String strA = k0.a(iVar.b(bVar.f10183c.f66248a), iVarL.b(bVar.f10183c.f66248a));
        String str = iVarL.f66297a + "-";
        if (iVarL.f66298b != -1) {
            str = str + (iVarL.f66297a + iVarL.f66298b);
        }
        return new Pair<>(strA, str);
    }

    public final long k(long j11) {
        h4.c cVar = this.f10173k;
        long j12 = cVar.f66252a;
        return j12 == C.TIME_UNSET ? C.TIME_UNSET : j11 - u0.S0(j12 + cVar.c(this.f10174l).f66288b);
    }

    public final ArrayList<j> l() {
        List<h4.a> list = this.f10173k.c(this.f10174l).f66289c;
        ArrayList<j> arrayList = new ArrayList<>();
        for (int i11 : this.f10165c) {
            arrayList.addAll(list.get(i11).f66244c);
        }
        return arrayList;
    }

    public final long m(b bVar, @Nullable q4.m mVar, long j11, long j12, long j13) {
        return mVar != null ? mVar.e() : u0.q(bVar.j(j11), j12, j13);
    }

    @Override // q4.i
    public void maybeThrowError() throws IOException {
        IOException iOException = this.f10175m;
        if (iOException != null) {
            throw iOException;
        }
        this.f10163a.maybeThrowError();
    }

    public e n(b bVar, androidx.media3.datasource.a aVar, y yVar, int i11, @Nullable Object obj, @Nullable i iVar, @Nullable i iVar2, @Nullable androidx.media3.exoplayer.upstream.g.a aVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f10182b;
        if (iVar3 != null) {
            i iVarA = iVar3.a(iVar2, bVar.f10183c.f66248a);
            if (iVarA != null) {
                iVar3 = iVarA;
            }
        } else {
            iVar3 = (i) z3.a.e(iVar2);
        }
        return new l(aVar, g4.g.a(jVar, bVar.f10183c.f66248a, iVar3, 0, ImmutableMap.of()), yVar, i11, obj, bVar.f10181a);
    }

    public e o(b bVar, androidx.media3.datasource.a aVar, int i11, y yVar, int i12, @Nullable Object obj, long j11, int i13, long j12, long j13, @Nullable androidx.media3.exoplayer.upstream.g.a aVar2) {
        j jVar = bVar.f10182b;
        long jK = bVar.k(j11);
        i iVarL = bVar.l(j11);
        if (bVar.f10181a == null) {
            return new q4.o(aVar, g4.g.a(jVar, bVar.f10183c.f66248a, iVarL, bVar.m(j11, j13) ? 0 : 8, ImmutableMap.of()), yVar, i12, obj, jK, bVar.i(j11), j11, i11, yVar);
        }
        int i14 = 1;
        int i15 = 1;
        while (i14 < i13) {
            i iVarA = iVarL.a(bVar.l(((long) i14) + j11), bVar.f10183c.f66248a);
            if (iVarA == null) {
                break;
            }
            i15++;
            i14++;
            iVarL = iVarA;
        }
        long j14 = (((long) i15) + j11) - 1;
        long jI = bVar.i(j14);
        long j15 = bVar.f10185e;
        if (j15 == C.TIME_UNSET || j15 > jI) {
            j15 = -9223372036854775807L;
        }
        c4.g gVarA = g4.g.a(jVar, bVar.f10183c.f66248a, iVarL, bVar.m(j14, j13) ? 0 : 8, ImmutableMap.of());
        long j16 = -jVar.f66304d;
        if (f0.p(yVar.f9501m)) {
            j16 += jK;
        }
        return new q4.j(aVar, gVarA, yVar, i12, obj, jK, jI, j12, j15, j11, i15, j16, bVar.f10181a);
    }

    public final b p(int i11) {
        b bVar = this.f10171i[i11];
        h4.b bVarJ = this.f10164b.j(bVar.f10182b.f66303c);
        if (bVarJ == null || bVarJ.equals(bVar.f10183c)) {
            return bVar;
        }
        b bVarD = bVar.d(bVarJ);
        this.f10171i[i11] = bVarD;
        return bVarD;
    }

    @Override // q4.i
    public void release() {
        for (b bVar : this.f10171i) {
            f fVar = bVar.f10181a;
            if (fVar != null) {
                fVar.release();
            }
        }
    }
}

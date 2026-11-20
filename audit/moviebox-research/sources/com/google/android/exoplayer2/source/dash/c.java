package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import fi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ph.e;
import ph.f;
import ph.g;
import ph.h;
import ph.m;
import ph.n;
import ph.o;
import ph.p;
import qg.u1;
import rh.i;
import rh.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f33880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh.b f33881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f33882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f33884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f33885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f33886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final d.c f33887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b[] f33888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f33889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rh.c f33890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f33891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public IOException f33892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f33893n;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.google.android.exoplayer2.source.dash.a.InterfaceC0363a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k.a f33894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g.a f33896c;

        public a(k.a aVar) {
            this(aVar, 1);
        }

        public a(k.a aVar, int i11) {
            this(e.f73788k, aVar, i11);
        }

        public a(g.a aVar, k.a aVar2, int i11) {
            this.f33896c = aVar;
            this.f33894a = aVar2;
            this.f33895b = i11;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0363a
        public com.google.android.exoplayer2.source.dash.a a(a0 a0Var, rh.c cVar, qh.b bVar, int i11, int[] iArr, s sVar, int i12, long j11, boolean z11, List<m1> list, @Nullable d.c cVar2, @Nullable k0 k0Var, u1 u1Var) {
            k kVarCreateDataSource = this.f33894a.createDataSource();
            if (k0Var != null) {
                kVarCreateDataSource.e(k0Var);
            }
            return new c(this.f33896c, a0Var, cVar, bVar, i11, iArr, sVar, i12, kVarCreateDataSource, j11, this.f33895b, z11, list, cVar2, u1Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final g f33897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f33898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rh.b f33899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final qh.e f33900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f33901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f33902f;

        public b(long j11, j jVar, rh.b bVar, @Nullable g gVar, long j12, @Nullable qh.e eVar) {
            this.f33901e = j11;
            this.f33898b = jVar;
            this.f33899c = bVar;
            this.f33902f = j12;
            this.f33897a = gVar;
            this.f33900d = eVar;
        }

        @CheckResult
        public b b(long j11, j jVar) throws BehindLiveWindowException {
            long jE;
            qh.e eVarK = this.f33898b.k();
            qh.e eVarK2 = jVar.k();
            if (eVarK == null) {
                return new b(j11, jVar, this.f33899c, this.f33897a, this.f33902f, eVarK);
            }
            if (!eVarK.g()) {
                return new b(j11, jVar, this.f33899c, this.f33897a, this.f33902f, eVarK2);
            }
            long jF = eVarK.f(j11);
            if (jF == 0) {
                return new b(j11, jVar, this.f33899c, this.f33897a, this.f33902f, eVarK2);
            }
            long jH = eVarK.h();
            long timeUs = eVarK.getTimeUs(jH);
            long jE2 = jF + jH;
            long j12 = jE2 - 1;
            long timeUs2 = eVarK.getTimeUs(j12) + eVarK.a(j12, j11);
            long jH2 = eVarK2.h();
            long timeUs3 = eVarK2.getTimeUs(jH2);
            long j13 = this.f33902f;
            if (timeUs2 == timeUs3) {
                jE = j13 + (jE2 - jH2);
            } else {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    jE = j13 - (eVarK2.e(timeUs, j11) - jH);
                } else {
                    jE2 = eVarK.e(timeUs3, j11);
                    jE = j13 + (jE2 - jH2);
                }
            }
            return new b(j11, jVar, this.f33899c, this.f33897a, jE, eVarK2);
        }

        @CheckResult
        public b c(qh.e eVar) {
            return new b(this.f33901e, this.f33898b, this.f33899c, this.f33897a, this.f33902f, eVar);
        }

        @CheckResult
        public b d(rh.b bVar) {
            return new b(this.f33901e, this.f33898b, bVar, this.f33897a, this.f33902f, this.f33900d);
        }

        public long e(long j11) {
            return this.f33900d.b(this.f33901e, j11) + this.f33902f;
        }

        public long f() {
            return this.f33900d.h() + this.f33902f;
        }

        public long g(long j11) {
            return (e(j11) + this.f33900d.i(this.f33901e, j11)) - 1;
        }

        public long h() {
            return this.f33900d.f(this.f33901e);
        }

        public long i(long j11) {
            return k(j11) + this.f33900d.a(j11 - this.f33902f, this.f33901e);
        }

        public long j(long j11) {
            return this.f33900d.e(j11, this.f33901e) + this.f33902f;
        }

        public long k(long j11) {
            return this.f33900d.getTimeUs(j11 - this.f33902f);
        }

        public i l(long j11) {
            return this.f33900d.d(j11 - this.f33902f);
        }

        public boolean m(long j11, long j12) {
            return this.f33900d.g() || j12 == C.TIME_UNSET || i(j11) <= j12;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0364c extends ph.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f33903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f33904f;

        public C0364c(b bVar, long j11, long j12, long j13) {
            super(j11, j12);
            this.f33903e = bVar;
            this.f33904f = j13;
        }

        @Override // ph.o
        public long a() {
            c();
            return this.f33903e.k(d());
        }

        @Override // ph.o
        public long b() {
            c();
            return this.f33903e.i(d());
        }
    }

    public c(g.a aVar, a0 a0Var, rh.c cVar, qh.b bVar, int i11, int[] iArr, s sVar, int i12, k kVar, long j11, int i13, boolean z11, List<m1> list, @Nullable d.c cVar2, u1 u1Var) {
        this.f33880a = a0Var;
        this.f33890k = cVar;
        this.f33881b = bVar;
        this.f33882c = iArr;
        this.f33889j = sVar;
        this.f33883d = i12;
        this.f33884e = kVar;
        this.f33891l = i11;
        this.f33885f = j11;
        this.f33886g = i13;
        this.f33887h = cVar2;
        long jF = cVar.f(i11);
        ArrayList<j> arrayListL = l();
        this.f33888i = new b[sVar.length()];
        int i14 = 0;
        while (i14 < this.f33888i.length) {
            j jVar = arrayListL.get(sVar.getIndexInTrackGroup(i14));
            rh.b bVarJ = bVar.j(jVar.f75445c);
            int i15 = i14;
            this.f33888i[i15] = new b(jF, jVar, bVarJ == null ? jVar.f75445c.get(0) : bVarJ, aVar.a(i12, jVar.f75444b, z11, list, cVar2, u1Var), 0L, jVar.k());
            i14 = i15 + 1;
        }
    }

    @Override // ph.j
    public long a(long j11, b3 b3Var) {
        for (b bVar : this.f33888i) {
            if (bVar.f33900d != null) {
                long j12 = bVar.j(j11);
                long jK = bVar.k(j12);
                long jH = bVar.h();
                return b3Var.a(j11, jK, (jK >= j11 || (jH != -1 && j12 >= (bVar.f() + jH) - 1)) ? jK : bVar.k(j12 + 1));
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void b(s sVar) {
        this.f33889j = sVar;
    }

    @Override // ph.j
    public void d(f fVar) {
        tg.d dVarB;
        if (fVar instanceof m) {
            int iG = this.f33889j.g(((m) fVar).f73809d);
            b bVar = this.f33888i[iG];
            if (bVar.f33900d == null && (dVarB = bVar.f33897a.b()) != null) {
                this.f33888i[iG] = bVar.c(new qh.g(dVarB, bVar.f33898b.f75446d));
            }
        }
        d.c cVar = this.f33887h;
        if (cVar != null) {
            cVar.i(fVar);
        }
    }

    @Override // ph.j
    public boolean e(f fVar, boolean z11, z.c cVar, z zVar) {
        z.b bVarD;
        if (!z11) {
            return false;
        }
        d.c cVar2 = this.f33887h;
        if (cVar2 != null && cVar2.j(fVar)) {
            return true;
        }
        if (!this.f33890k.f75397d && (fVar instanceof n)) {
            IOException iOException = cVar.f35529c;
            if ((iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.f33888i[this.f33889j.g(fVar.f73809d)];
                long jH = bVar.h();
                if (jH != -1 && jH != 0) {
                    if (((n) fVar).e() > (bVar.f() + jH) - 1) {
                        this.f33893n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f33888i[this.f33889j.g(fVar.f73809d)];
        rh.b bVarJ = this.f33881b.j(bVar2.f33898b.f75445c);
        if (bVarJ != null && !bVar2.f33899c.equals(bVarJ)) {
            return true;
        }
        z.a aVarI = i(this.f33889j, bVar2.f33898b.f75445c);
        if ((!aVarI.a(2) && !aVarI.a(1)) || (bVarD = zVar.d(aVarI, cVar)) == null || !aVarI.a(bVarD.f35525a)) {
            return false;
        }
        int i11 = bVarD.f35525a;
        if (i11 == 2) {
            s sVar = this.f33889j;
            return sVar.blacklist(sVar.g(fVar.f73809d), bVarD.f35526b);
        }
        if (i11 != 1) {
            return false;
        }
        this.f33881b.e(bVar2.f33899c, bVarD.f35526b);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void f(rh.c cVar, int i11) {
        try {
            this.f33890k = cVar;
            this.f33891l = i11;
            long jF = cVar.f(i11);
            ArrayList<j> arrayListL = l();
            for (int i12 = 0; i12 < this.f33888i.length; i12++) {
                j jVar = arrayListL.get(this.f33889j.getIndexInTrackGroup(i12));
                b[] bVarArr = this.f33888i;
                bVarArr[i12] = bVarArr[i12].b(jF, jVar);
            }
        } catch (BehindLiveWindowException e11) {
            this.f33892m = e11;
        }
    }

    @Override // ph.j
    public void g(long j11, long j12, List<? extends n> list, h hVar) {
        int i11;
        int i12;
        o[] oVarArr;
        long j13;
        long j14;
        if (this.f33892m != null) {
            return;
        }
        long j15 = j12 - j11;
        long jC0 = o0.C0(this.f33890k.f75394a) + o0.C0(this.f33890k.c(this.f33891l).f75430b) + j12;
        d.c cVar = this.f33887h;
        if (cVar == null || !cVar.h(jC0)) {
            long jC1 = o0.C0(o0.b0(this.f33885f));
            long jK = k(jC1);
            n nVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f33889j.length();
            o[] oVarArr2 = new o[length];
            int i13 = 0;
            while (i13 < length) {
                b bVar = this.f33888i[i13];
                if (bVar.f33900d == null) {
                    oVarArr2[i13] = o.f73858a;
                    i11 = i13;
                    i12 = length;
                    oVarArr = oVarArr2;
                    j13 = j15;
                    j14 = jC1;
                } else {
                    long jE = bVar.e(jC1);
                    long jG = bVar.g(jC1);
                    i11 = i13;
                    i12 = length;
                    oVarArr = oVarArr2;
                    j13 = j15;
                    j14 = jC1;
                    long jM = m(bVar, nVar, j12, jE, jG);
                    if (jM < jE) {
                        oVarArr[i11] = o.f73858a;
                    } else {
                        oVarArr[i11] = new C0364c(p(i11), jM, jG, jK);
                    }
                }
                i13 = i11 + 1;
                jC1 = j14;
                length = i12;
                oVarArr2 = oVarArr;
                j15 = j13;
            }
            long j16 = j15;
            long j17 = jC1;
            this.f33889j.d(j11, j16, j(j17, j11), list, oVarArr2);
            b bVarP = p(this.f33889j.getSelectedIndex());
            g gVar = bVarP.f33897a;
            if (gVar != null) {
                j jVar = bVarP.f33898b;
                i iVarM = gVar.c() == null ? jVar.m() : null;
                i iVarL = bVarP.f33900d == null ? jVar.l() : null;
                if (iVarM != null || iVarL != null) {
                    hVar.f73815a = n(bVarP, this.f33884e, this.f33889j.getSelectedFormat(), this.f33889j.getSelectionReason(), this.f33889j.getSelectionData(), iVarM, iVarL);
                    return;
                }
            }
            long j18 = bVarP.f33901e;
            long j19 = C.TIME_UNSET;
            boolean z11 = j18 != C.TIME_UNSET;
            if (bVarP.h() == 0) {
                hVar.f73816b = z11;
                return;
            }
            long jE2 = bVarP.e(j17);
            long jG2 = bVarP.g(j17);
            long jM2 = m(bVarP, nVar, j12, jE2, jG2);
            if (jM2 < jE2) {
                this.f33892m = new BehindLiveWindowException();
                return;
            }
            if (jM2 > jG2 || (this.f33893n && jM2 >= jG2)) {
                hVar.f73816b = z11;
                return;
            }
            if (z11 && bVarP.k(jM2) >= j18) {
                hVar.f73816b = true;
                return;
            }
            int iMin = (int) Math.min(this.f33886g, (jG2 - jM2) + 1);
            if (j18 != C.TIME_UNSET) {
                while (iMin > 1 && bVarP.k((((long) iMin) + jM2) - 1) >= j18) {
                    iMin--;
                }
            }
            int i14 = iMin;
            if (list.isEmpty()) {
                j19 = j12;
            }
            hVar.f73815a = o(bVarP, this.f33884e, this.f33883d, this.f33889j.getSelectedFormat(), this.f33889j.getSelectionReason(), this.f33889j.getSelectionData(), jM2, i14, j19, jK);
        }
    }

    @Override // ph.j
    public int getPreferredQueueSize(long j11, List<? extends n> list) {
        return (this.f33892m != null || this.f33889j.length() < 2) ? list.size() : this.f33889j.evaluateQueueSize(j11, list);
    }

    @Override // ph.j
    public boolean h(long j11, f fVar, List<? extends n> list) {
        if (this.f33892m != null) {
            return false;
        }
        return this.f33889j.f(j11, fVar, list);
    }

    public final z.a i(s sVar, List<rh.b> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (sVar.e(i12, jElapsedRealtime)) {
                i11++;
            }
        }
        int iF = qh.b.f(list);
        return new z.a(iF, iF - this.f33881b.g(list), length, i11);
    }

    public final long j(long j11, long j12) {
        if (!this.f33890k.f75397d) {
            return C.TIME_UNSET;
        }
        return Math.max(0L, Math.min(k(j11), this.f33888i[0].i(this.f33888i[0].g(j11))) - j12);
    }

    public final long k(long j11) {
        rh.c cVar = this.f33890k;
        long j12 = cVar.f75394a;
        return j12 == C.TIME_UNSET ? C.TIME_UNSET : j11 - o0.C0(j12 + cVar.c(this.f33891l).f75430b);
    }

    public final ArrayList<j> l() {
        List<rh.a> list = this.f33890k.c(this.f33891l).f75431c;
        ArrayList<j> arrayList = new ArrayList<>();
        for (int i11 : this.f33882c) {
            arrayList.addAll(list.get(i11).f75386c);
        }
        return arrayList;
    }

    public final long m(b bVar, @Nullable n nVar, long j11, long j12, long j13) {
        return nVar != null ? nVar.e() : o0.r(bVar.j(j11), j12, j13);
    }

    @Override // ph.j
    public void maybeThrowError() throws IOException {
        IOException iOException = this.f33892m;
        if (iOException != null) {
            throw iOException;
        }
        this.f33880a.maybeThrowError();
    }

    public f n(b bVar, k kVar, m1 m1Var, int i11, @Nullable Object obj, @Nullable i iVar, @Nullable i iVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f33898b;
        if (iVar3 != null) {
            i iVarA = iVar3.a(iVar2, bVar.f33899c.f75390a);
            if (iVarA != null) {
                iVar3 = iVarA;
            }
        } else {
            iVar3 = iVar2;
        }
        return new m(kVar, qh.f.a(jVar, bVar.f33899c.f75390a, iVar3, 0), m1Var, i11, obj, bVar.f33897a);
    }

    public f o(b bVar, k kVar, int i11, m1 m1Var, int i12, Object obj, long j11, int i13, long j12, long j13) {
        j jVar = bVar.f33898b;
        long jK = bVar.k(j11);
        i iVarL = bVar.l(j11);
        if (bVar.f33897a == null) {
            return new p(kVar, qh.f.a(jVar, bVar.f33899c.f75390a, iVarL, bVar.m(j11, j13) ? 0 : 8), m1Var, i12, obj, jK, bVar.i(j11), j11, i11, m1Var);
        }
        int i14 = 1;
        int i15 = 1;
        while (i14 < i13) {
            i iVarA = iVarL.a(bVar.l(((long) i14) + j11), bVar.f33899c.f75390a);
            if (iVarA == null) {
                break;
            }
            i15++;
            i14++;
            iVarL = iVarA;
        }
        long j14 = (((long) i15) + j11) - 1;
        long jI = bVar.i(j14);
        long j15 = bVar.f33901e;
        return new ph.k(kVar, qh.f.a(jVar, bVar.f33899c.f75390a, iVarL, bVar.m(j14, j13) ? 0 : 8), m1Var, i12, obj, jK, jI, j12, (j15 == C.TIME_UNSET || j15 > jI) ? -9223372036854775807L : j15, j11, i15, -jVar.f75446d, bVar.f33897a);
    }

    public final b p(int i11) {
        b bVar = this.f33888i[i11];
        rh.b bVarJ = this.f33881b.j(bVar.f33898b.f75445c);
        if (bVarJ == null || bVarJ.equals(bVar.f33899c)) {
            return bVar;
        }
        b bVarD = bVar.d(bVarJ);
        this.f33888i[i11] = bVarD;
        return bVarD;
    }

    @Override // ph.j
    public void release() {
        for (b bVar : this.f33888i) {
            g gVar = bVar.f33897a;
            if (gVar != null) {
                gVar.release();
            }
        }
    }
}

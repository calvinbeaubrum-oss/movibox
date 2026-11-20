package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import fi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nh.d0;
import nh.i0;
import nh.l;
import ph.i;
import qg.u1;
import rh.e;
import rh.f;
import rh.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements h, q.a<i<com.google.android.exoplayer2.source.dash.a>>, i.b<com.google.android.exoplayer2.source.dash.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.dash.a.InterfaceC0363a f33850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final k0 f33851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f33852d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f33853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qh.b f33854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f33855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a0 f33856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f33857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final nh.k0 f33858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a[] f33859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final nh.d f33860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f33861n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j.a f33863p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f33864q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final u1 f33865r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public h.a f33866s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public q f33869v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public rh.c f33870w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f33871x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<f> f33872y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f33848z = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i<com.google.android.exoplayer2.source.dash.a>[] f33867t = u(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public qh.h[] f33868u = new qh.h[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IdentityHashMap<i<com.google.android.exoplayer2.source.dash.a>, d.c> f33862o = new IdentityHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f33873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f33876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f33877e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f33878f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f33879g;

        public a(int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16) {
            this.f33874b = i11;
            this.f33873a = iArr;
            this.f33875c = i12;
            this.f33877e = i13;
            this.f33878f = i14;
            this.f33879g = i15;
            this.f33876d = i16;
        }

        public static a a(int[] iArr, int i11) {
            return new a(3, 1, iArr, i11, -1, -1, -1);
        }

        public static a b(int[] iArr, int i11) {
            return new a(5, 1, iArr, i11, -1, -1, -1);
        }

        public static a c(int i11) {
            return new a(5, 2, new int[0], -1, -1, -1, i11);
        }

        public static a d(int i11, int[] iArr, int i12, int i13, int i14) {
            return new a(i11, 0, iArr, i12, i13, i14, -1);
        }
    }

    public b(int i11, rh.c cVar, qh.b bVar, int i12, com.google.android.exoplayer2.source.dash.a.InterfaceC0363a interfaceC0363a, @Nullable k0 k0Var, com.google.android.exoplayer2.drm.c cVar2, com.google.android.exoplayer2.drm.b.a aVar, z zVar, j.a aVar2, long j11, a0 a0Var, com.google.android.exoplayer2.upstream.b bVar2, nh.d dVar, d.b bVar3, u1 u1Var) {
        this.f33849a = i11;
        this.f33870w = cVar;
        this.f33854g = bVar;
        this.f33871x = i12;
        this.f33850b = interfaceC0363a;
        this.f33851c = k0Var;
        this.f33852d = cVar2;
        this.f33864q = aVar;
        this.f33853f = zVar;
        this.f33863p = aVar2;
        this.f33855h = j11;
        this.f33856i = a0Var;
        this.f33857j = bVar2;
        this.f33860m = dVar;
        this.f33865r = u1Var;
        this.f33861n = new d(cVar, bVar3, bVar2);
        this.f33869v = dVar.a(this.f33867t);
        g gVarC = cVar.c(i12);
        List<f> list = gVarC.f75432d;
        this.f33872y = list;
        Pair<nh.k0, a[]> pairK = k(cVar2, gVarC.f75431c, list);
        this.f33858k = (nh.k0) pairK.first;
        this.f33859l = (a[]) pairK.second;
    }

    public static void c(List<f> list, i0[] i0VarArr, a[] aVarArr, int i11) {
        int i12 = 0;
        while (i12 < list.size()) {
            f fVar = list.get(i12);
            i0VarArr[i11] = new i0(fVar.a() + ":" + i12, new m1.b().S(fVar.a()).e0(MimeTypes.APPLICATION_EMSG).E());
            aVarArr[i11] = a.c(i12);
            i12++;
            i11++;
        }
    }

    public static int i(com.google.android.exoplayer2.drm.c cVar, List<rh.a> list, int[][] iArr, int i11, boolean[] zArr, m1[][] m1VarArr, i0[] i0VarArr, a[] aVarArr) {
        int i12;
        int i13;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            int[] iArr2 = iArr[i14];
            ArrayList arrayList = new ArrayList();
            for (int i16 : iArr2) {
                arrayList.addAll(list.get(i16).f75386c);
            }
            int size = arrayList.size();
            m1[] m1VarArr2 = new m1[size];
            for (int i17 = 0; i17 < size; i17++) {
                m1 m1Var = ((rh.j) arrayList.get(i17)).f75444b;
                m1VarArr2[i17] = m1Var.c(cVar.a(m1Var));
            }
            rh.a aVar = list.get(iArr2[0]);
            int i18 = aVar.f75384a;
            String string = i18 != -1 ? Integer.toString(i18) : "unset:" + i14;
            int i19 = i15 + 1;
            if (zArr[i14]) {
                i12 = i15 + 2;
            } else {
                i12 = i19;
                i19 = -1;
            }
            if (m1VarArr[i14].length != 0) {
                i13 = i12 + 1;
            } else {
                i13 = i12;
                i12 = -1;
            }
            i0VarArr[i15] = new i0(string, m1VarArr2);
            aVarArr[i15] = a.d(aVar.f75385b, iArr2, i15, i19, i12);
            if (i19 != -1) {
                String str = string + ":emsg";
                i0VarArr[i19] = new i0(str, new m1.b().S(str).e0(MimeTypes.APPLICATION_EMSG).E());
                aVarArr[i19] = a.b(iArr2, i15);
            }
            if (i12 != -1) {
                i0VarArr[i12] = new i0(string + ":cc", m1VarArr[i14]);
                aVarArr[i12] = a.a(iArr2, i15);
            }
            i14++;
            i15 = i13;
        }
        return i15;
    }

    public static Pair<nh.k0, a[]> k(com.google.android.exoplayer2.drm.c cVar, List<rh.a> list, List<f> list2) {
        int[][] iArrP = p(list);
        int length = iArrP.length;
        boolean[] zArr = new boolean[length];
        m1[][] m1VarArr = new m1[length][];
        int iT = t(length, list, iArrP, zArr, m1VarArr) + length + list2.size();
        i0[] i0VarArr = new i0[iT];
        a[] aVarArr = new a[iT];
        c(list2, i0VarArr, aVarArr, i(cVar, list, iArrP, length, zArr, m1VarArr, i0VarArr, aVarArr));
        return Pair.create(new nh.k0(i0VarArr), aVarArr);
    }

    @Nullable
    public static e l(List<e> list) {
        return m(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    public static e m(List<e> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (str.equals(eVar.f75421a)) {
                return eVar;
            }
        }
        return null;
    }

    @Nullable
    public static e n(List<e> list) {
        return m(list, "http://dashif.org/guidelines/trickmode");
    }

    public static m1[] o(List<rh.a> list, int[] iArr) {
        for (int i11 : iArr) {
            rh.a aVar = list.get(i11);
            List<e> list2 = list.get(i11).f75387d;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                e eVar = list2.get(i12);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f75421a)) {
                    return w(eVar, f33848z, new m1.b().e0(MimeTypes.APPLICATION_CEA608).S(aVar.f75384a + ":cea608").E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f75421a)) {
                    return w(eVar, A, new m1.b().e0(MimeTypes.APPLICATION_CEA708).S(aVar.f75384a + ":cea708").E());
                }
            }
        }
        return new m1[0];
    }

    public static int[][] p(List<rh.a> list) {
        int iMin;
        e eVarL;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i11 = 0; i11 < size; i11++) {
            sparseIntArray.put(list.get(i11).f75384a, i11);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i11));
            arrayList.add(arrayList2);
            sparseArray.put(i11, arrayList2);
        }
        for (int i12 = 0; i12 < size; i12++) {
            rh.a aVar = list.get(i12);
            e eVarN = n(aVar.f75388e);
            if (eVarN == null) {
                eVarN = n(aVar.f75389f);
            }
            if (eVarN == null || (iMin = sparseIntArray.get(Integer.parseInt(eVarN.f75422b), -1)) == -1) {
                iMin = i12;
            }
            if (iMin == i12 && (eVarL = l(aVar.f75389f)) != null) {
                for (String str : o0.T0(eVarL.f75422b, ",")) {
                    int i13 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i13 != -1) {
                        iMin = Math.min(iMin, i13);
                    }
                }
            }
            if (iMin != i12) {
                List list2 = (List) sparseArray.get(i12);
                List list3 = (List) sparseArray.get(iMin);
                list3.addAll(list2);
                sparseArray.put(i12, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i14 = 0; i14 < size2; i14++) {
            int[] iArrM = Ints.m((Collection) arrayList.get(i14));
            iArr[i14] = iArrM;
            Arrays.sort(iArrM);
        }
        return iArr;
    }

    public static boolean s(List<rh.a> list, int[] iArr) {
        for (int i11 : iArr) {
            List<rh.j> list2 = list.get(i11).f75386c;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (!list2.get(i12).f75447e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int t(int i11, List<rh.a> list, int[][] iArr, boolean[] zArr, m1[][] m1VarArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (s(list, iArr[i13])) {
                zArr[i13] = true;
                i12++;
            }
            m1[] m1VarArrO = o(list, iArr[i13]);
            m1VarArr[i13] = m1VarArrO;
            if (m1VarArrO.length != 0) {
                i12++;
            }
        }
        return i12;
    }

    public static i<com.google.android.exoplayer2.source.dash.a>[] u(int i11) {
        return new i[i11];
    }

    public static m1[] w(e eVar, Pattern pattern, m1 m1Var) {
        String str = eVar.f75422b;
        if (str == null) {
            return new m1[]{m1Var};
        }
        String[] strArrT0 = o0.T0(str, ";");
        m1[] m1VarArr = new m1[strArrT0.length];
        for (int i11 = 0; i11 < strArrT0.length; i11++) {
            Matcher matcher = pattern.matcher(strArrT0[i11]);
            if (!matcher.matches()) {
                return new m1[]{m1Var};
            }
            int i12 = Integer.parseInt(matcher.group(1));
            m1VarArr[i11] = m1Var.b().S(m1Var.f33434a + ":" + i12).F(i12).V(matcher.group(2)).E();
        }
        return m1VarArr;
    }

    public final void A(s[] sVarArr, d0[] d0VarArr, boolean[] zArr, long j11, int[] iArr) {
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            s sVar = sVarArr[i11];
            if (sVar != null) {
                d0 d0Var = d0VarArr[i11];
                if (d0Var == null) {
                    zArr[i11] = true;
                    a aVar = this.f33859l[iArr[i11]];
                    int i12 = aVar.f33875c;
                    if (i12 == 0) {
                        d0VarArr[i11] = j(aVar, sVar, j11);
                    } else if (i12 == 2) {
                        d0VarArr[i11] = new qh.h(this.f33872y.get(aVar.f33876d), sVar.getTrackGroup().c(0), this.f33870w.f75397d);
                    }
                } else if (d0Var instanceof i) {
                    ((com.google.android.exoplayer2.source.dash.a) ((i) d0Var).q()).b(sVar);
                }
            }
        }
        for (int i13 = 0; i13 < sVarArr.length; i13++) {
            if (d0VarArr[i13] == null && sVarArr[i13] != null) {
                a aVar2 = this.f33859l[iArr[i13]];
                if (aVar2.f33875c == 1) {
                    int iQ = q(i13, iArr);
                    if (iQ == -1) {
                        d0VarArr[i13] = new l();
                    } else {
                        d0VarArr[i13] = ((i) d0VarArr[iQ]).F(j11, aVar2.f33874b);
                    }
                }
            }
        }
    }

    public void B(rh.c cVar, int i11) {
        this.f33870w = cVar;
        this.f33871x = i11;
        this.f33861n.q(cVar);
        i<com.google.android.exoplayer2.source.dash.a>[] iVarArr = this.f33867t;
        if (iVarArr != null) {
            for (i<com.google.android.exoplayer2.source.dash.a> iVar : iVarArr) {
                ((com.google.android.exoplayer2.source.dash.a) iVar.q()).f(cVar, i11);
            }
            this.f33866s.g(this);
        }
        this.f33872y = cVar.c(i11).f75432d;
        for (qh.h hVar : this.f33868u) {
            for (f fVar : this.f33872y) {
                if (fVar.a().equals(hVar.a())) {
                    hVar.d(fVar, cVar.f75397d && i11 == cVar.d() - 1);
                    break;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f33867t) {
            if (iVar.f73817a == 2) {
                return iVar.a(j11, b3Var);
            }
        }
        return j11;
    }

    @Override // ph.i.b
    public synchronized void b(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        d.c cVarRemove = this.f33862o.remove(iVar);
        if (cVarRemove != null) {
            cVarRemove.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        return this.f33869v.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f33867t) {
            iVar.discardBuffer(j11, z11);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        int[] iArrR = r(sVarArr);
        y(sVarArr, zArr, d0VarArr);
        z(sVarArr, d0VarArr, iArrR);
        A(sVarArr, d0VarArr, zArr2, j11, iArrR);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d0 d0Var : d0VarArr) {
            if (d0Var instanceof i) {
                arrayList.add((i) d0Var);
            } else if (d0Var instanceof qh.h) {
                arrayList2.add((qh.h) d0Var);
            }
        }
        i<com.google.android.exoplayer2.source.dash.a>[] iVarArrU = u(arrayList.size());
        this.f33867t = iVarArrU;
        arrayList.toArray(iVarArrU);
        qh.h[] hVarArr = new qh.h[arrayList2.size()];
        this.f33868u = hVarArr;
        arrayList2.toArray(hVarArr);
        this.f33869v = this.f33860m.a(this.f33867t);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f33866s = aVar;
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.f33869v.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.f33869v.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public nh.k0 getTrackGroups() {
        return this.f33858k;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f33869v.isLoading();
    }

    public final i<com.google.android.exoplayer2.source.dash.a> j(a aVar, s sVar, long j11) {
        i0 i0VarB;
        int i11;
        i0 i0VarB2;
        int i12;
        int i13 = aVar.f33878f;
        boolean z11 = i13 != -1;
        d.c cVarK = null;
        if (z11) {
            i0VarB = this.f33858k.b(i13);
            i11 = 1;
        } else {
            i0VarB = null;
            i11 = 0;
        }
        int i14 = aVar.f33879g;
        boolean z12 = i14 != -1;
        if (z12) {
            i0VarB2 = this.f33858k.b(i14);
            i11 += i0VarB2.f71931a;
        } else {
            i0VarB2 = null;
        }
        m1[] m1VarArr = new m1[i11];
        int[] iArr = new int[i11];
        if (z11) {
            m1VarArr[0] = i0VarB.c(0);
            iArr[0] = 5;
            i12 = 1;
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z12) {
            for (int i15 = 0; i15 < i0VarB2.f71931a; i15++) {
                m1 m1VarC = i0VarB2.c(i15);
                m1VarArr[i12] = m1VarC;
                iArr[i12] = 3;
                arrayList.add(m1VarC);
                i12++;
            }
        }
        if (this.f33870w.f75397d && z11) {
            cVarK = this.f33861n.k();
        }
        d.c cVar = cVarK;
        i<com.google.android.exoplayer2.source.dash.a> iVar = new i<>(aVar.f33874b, iArr, m1VarArr, this.f33850b.a(this.f33856i, this.f33870w, this.f33854g, this.f33871x, aVar.f33873a, sVar, aVar.f33874b, this.f33855h, z11, arrayList, cVar, this.f33851c, this.f33865r), this, this.f33857j, j11, this.f33852d, this.f33864q, this.f33853f, this.f33863p);
        synchronized (this) {
            this.f33862o.put(iVar, cVar);
        }
        return iVar;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        this.f33856i.maybeThrowError();
    }

    public final int q(int i11, int[] iArr) {
        int i12 = iArr[i11];
        if (i12 == -1) {
            return -1;
        }
        int i13 = this.f33859l[i12].f33877e;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 == i13 && this.f33859l[i15].f33875c == 0) {
                return i14;
            }
        }
        return -1;
    }

    public final int[] r(s[] sVarArr) {
        int[] iArr = new int[sVarArr.length];
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            s sVar = sVarArr[i11];
            if (sVar != null) {
                iArr[i11] = this.f33858k.c(sVar.getTrackGroup());
            } else {
                iArr[i11] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        this.f33869v.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f33867t) {
            iVar.E(j11);
        }
        for (qh.h hVar : this.f33868u) {
            hVar.c(j11);
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void g(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        this.f33866s.g(this);
    }

    public void x() {
        this.f33861n.o();
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f33867t) {
            iVar.C(this);
        }
        this.f33866s = null;
    }

    public final void y(s[] sVarArr, boolean[] zArr, d0[] d0VarArr) {
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            if (sVarArr[i11] == null || !zArr[i11]) {
                d0 d0Var = d0VarArr[i11];
                if (d0Var instanceof i) {
                    ((i) d0Var).C(this);
                } else if (d0Var instanceof i.a) {
                    ((i.a) d0Var).c();
                }
                d0VarArr[i11] = null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    public final void z(s[] sVarArr, d0[] d0VarArr, int[] iArr) {
        d0 d0Var;
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            d0 d0Var2 = d0VarArr[i11];
            if ((d0Var2 instanceof l) || (d0Var2 instanceof i.a)) {
                int iQ = q(i11, iArr);
                if (iQ != -1) {
                    d0 d0Var3 = d0VarArr[i11];
                    if (!(d0Var3 instanceof i.a) || ((i.a) d0Var3).f73840a != d0VarArr[iQ]) {
                        d0Var = d0VarArr[i11];
                        if (d0Var instanceof i.a) {
                            ((i.a) d0Var).c();
                        }
                        d0VarArr[i11] = null;
                    }
                } else if (!(d0VarArr[i11] instanceof l)) {
                    d0Var = d0VarArr[i11];
                    if (d0Var instanceof i.a) {
                        ((i.a) d0Var).c();
                    }
                    d0VarArr[i11] = null;
                }
            }
        }
    }
}

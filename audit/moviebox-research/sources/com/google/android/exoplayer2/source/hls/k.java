package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import fi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import nh.d0;
import nh.i0;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements com.google.android.exoplayer2.source.h, p.b, HlsPlaylistTracker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f34039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HlsPlaylistTracker f34040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f34041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final k0 f34042d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f34044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f34045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.j.a f34046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34047j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final nh.d f34050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f34052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f34053p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u1 f34054q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.h.a f34055r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f34056s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public nh.k0 f34057t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f34061x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.google.android.exoplayer2.source.q f34062y;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IdentityHashMap<d0, Integer> f34048k = new IdentityHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q f34049l = new q();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p[] f34058u = new p[0];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p[] f34059v = new p[0];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[][] f34060w = new int[0][];

    public k(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, @Nullable k0 k0Var, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar, z zVar, com.google.android.exoplayer2.source.j.a aVar2, com.google.android.exoplayer2.upstream.b bVar, nh.d dVar, boolean z11, int i11, boolean z12, u1 u1Var) {
        this.f34039a = gVar;
        this.f34040b = hlsPlaylistTracker;
        this.f34041c = fVar;
        this.f34042d = k0Var;
        this.f34043f = cVar;
        this.f34044g = aVar;
        this.f34045h = zVar;
        this.f34046i = aVar2;
        this.f34047j = bVar;
        this.f34050m = dVar;
        this.f34051n = z11;
        this.f34052o = i11;
        this.f34053p = z12;
        this.f34054q = u1Var;
        this.f34062y = dVar.a(new com.google.android.exoplayer2.source.q[0]);
    }

    public static m1 m(m1 m1Var, @Nullable m1 m1Var2, boolean z11) {
        String strL;
        Metadata metadata;
        int i11;
        String str;
        String str2;
        int i12;
        int i13;
        if (m1Var2 != null) {
            strL = m1Var2.f33442j;
            metadata = m1Var2.f33443k;
            i12 = m1Var2.f33458z;
            i11 = m1Var2.f33437d;
            i13 = m1Var2.f33438f;
            str = m1Var2.f33436c;
            str2 = m1Var2.f33435b;
        } else {
            strL = o0.L(m1Var.f33442j, 1);
            metadata = m1Var.f33443k;
            if (z11) {
                i12 = m1Var.f33458z;
                i11 = m1Var.f33437d;
                i13 = m1Var.f33438f;
                str = m1Var.f33436c;
                str2 = m1Var.f33435b;
            } else {
                i11 = 0;
                str = null;
                str2 = null;
                i12 = -1;
                i13 = 0;
            }
        }
        return new m1.b().S(m1Var.f33434a).U(str2).K(m1Var.f33444l).e0(w.g(strL)).I(strL).X(metadata).G(z11 ? m1Var.f33439g : -1).Z(z11 ? m1Var.f33440h : -1).H(i12).g0(i11).c0(i13).V(str).E();
    }

    public static Map<String, DrmInitData> n(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            DrmInitData drmInitDataMerge = list.get(i11);
            String str = drmInitDataMerge.schemeType;
            i11++;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i12);
                if (TextUtils.equals(drmInitData.schemeType, str)) {
                    drmInitDataMerge = drmInitDataMerge.merge(drmInitData);
                    arrayList.remove(i12);
                } else {
                    i12++;
                }
            }
            map.put(str, drmInitDataMerge);
        }
        return map;
    }

    public static m1 o(m1 m1Var) {
        String strL = o0.L(m1Var.f33442j, 2);
        return new m1.b().S(m1Var.f33434a).U(m1Var.f33435b).K(m1Var.f33444l).e0(w.g(strL)).I(strL).X(m1Var.f33443k).G(m1Var.f33439g).Z(m1Var.f33440h).j0(m1Var.f33450r).Q(m1Var.f33451s).P(m1Var.f33452t).g0(m1Var.f33437d).c0(m1Var.f33438f).E();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        for (p pVar : this.f34059v) {
            if (pVar.E()) {
                return pVar.a(j11, b3Var);
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean b(Uri uri, z.c cVar, boolean z11) {
        boolean zN = true;
        for (p pVar : this.f34058u) {
            zN &= pVar.N(uri, cVar, z11);
        }
        this.f34055r.g(this);
        return zN;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void c() {
        for (p pVar : this.f34058u) {
            pVar.O();
        }
        this.f34055r.g(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        if (this.f34057t != null) {
            return this.f34062y.continueLoading(j11);
        }
        for (p pVar : this.f34058u) {
            pVar.o();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void d(Uri uri) {
        this.f34040b.d(uri);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        for (p pVar : this.f34059v) {
            pVar.discardBuffer(j11, z11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00df  */
    @Override // com.google.android.exoplayer2.source.h
    public long e(s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        d0[] d0VarArr2 = d0VarArr;
        int[] iArr = new int[sVarArr.length];
        int[] iArr2 = new int[sVarArr.length];
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            d0 d0Var = d0VarArr2[i11];
            iArr[i11] = d0Var == null ? -1 : this.f34048k.get(d0Var).intValue();
            iArr2[i11] = -1;
            s sVar = sVarArr[i11];
            if (sVar != null) {
                i0 trackGroup = sVar.getTrackGroup();
                int i12 = 0;
                while (true) {
                    p[] pVarArr = this.f34058u;
                    if (i12 >= pVarArr.length) {
                        break;
                    }
                    if (pVarArr[i12].getTrackGroups().c(trackGroup) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
        }
        this.f34048k.clear();
        int length = sVarArr.length;
        d0[] d0VarArr3 = new d0[length];
        d0[] d0VarArr4 = new d0[sVarArr.length];
        s[] sVarArr2 = new s[sVarArr.length];
        p[] pVarArr2 = new p[this.f34058u.length];
        int i13 = 0;
        int i14 = 0;
        boolean z11 = false;
        while (i14 < this.f34058u.length) {
            for (int i15 = 0; i15 < sVarArr.length; i15++) {
                s sVar2 = null;
                d0VarArr4[i15] = iArr[i15] == i14 ? d0VarArr2[i15] : null;
                if (iArr2[i15] == i14) {
                    sVar2 = sVarArr[i15];
                }
                sVarArr2[i15] = sVar2;
            }
            p pVar = this.f34058u[i14];
            int i16 = i13;
            int i17 = length;
            int i18 = i14;
            s[] sVarArr3 = sVarArr2;
            p[] pVarArr3 = pVarArr2;
            boolean zW = pVar.W(sVarArr2, zArr, d0VarArr4, zArr2, j11, z11);
            int i19 = 0;
            boolean z12 = false;
            while (true) {
                if (i19 >= sVarArr.length) {
                    break;
                }
                d0 d0Var2 = d0VarArr4[i19];
                if (iArr2[i19] == i18) {
                    com.google.android.exoplayer2.util.a.e(d0Var2);
                    d0VarArr3[i19] = d0Var2;
                    this.f34048k.put(d0Var2, Integer.valueOf(i18));
                    z12 = true;
                } else if (iArr[i19] == i18) {
                    com.google.android.exoplayer2.util.a.g(d0Var2 == null);
                }
                i19++;
            }
            if (z12) {
                pVarArr3[i16] = pVar;
                i13 = i16 + 1;
                if (i16 == 0) {
                    pVar.Z(true);
                    if (zW) {
                        this.f34049l.b();
                        z11 = true;
                    } else {
                        p[] pVarArr4 = this.f34059v;
                        if (pVarArr4.length == 0 || pVar != pVarArr4[0]) {
                            this.f34049l.b();
                            z11 = true;
                        }
                    }
                } else {
                    pVar.Z(i18 < this.f34061x);
                }
            } else {
                i13 = i16;
            }
            i14 = i18 + 1;
            d0VarArr2 = d0VarArr;
            pVarArr2 = pVarArr3;
            length = i17;
            sVarArr2 = sVarArr3;
        }
        System.arraycopy(d0VarArr3, 0, d0VarArr2, 0, length);
        p[] pVarArr5 = (p[]) o0.H0(pVarArr2, i13);
        this.f34059v = pVarArr5;
        this.f34062y = this.f34050m.a(pVarArr5);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(com.google.android.exoplayer2.source.h.a aVar, long j11) {
        this.f34055r = aVar;
        this.f34040b.m(this);
        k(j11);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.f34062y.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.f34062y.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public nh.k0 getTrackGroups() {
        return (nh.k0) com.google.android.exoplayer2.util.a.e(this.f34057t);
    }

    public final void i(long j11, List<com.google.android.exoplayer2.source.hls.playlist.d.a> list, List<p> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11).f34217d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z11 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (o0.c(str, list.get(i12).f34217d)) {
                        com.google.android.exoplayer2.source.hls.playlist.d.a aVar = list.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(aVar.f34214a);
                        arrayList2.add(aVar.f34215b);
                        z11 &= o0.K(aVar.f34215b.f33442j, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                p pVarL = l(str2, 1, (Uri[]) arrayList.toArray((Uri[]) o0.k(new Uri[0])), (m1[]) arrayList2.toArray(new m1[0]), null, Collections.emptyList(), map, j11);
                list3.add(Ints.m(arrayList3));
                list2.add(pVarL);
                if (this.f34051n && z11) {
                    pVarL.Q(new i0[]{new i0(str2, (m1[]) arrayList2.toArray(new m1[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34062y.isLoading();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b0  */
    public final void j(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, List<p> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z11;
        boolean z12;
        Uri[] uriArr;
        m1[] m1VarArr;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int size = dVar.f34205e.size();
        int[] iArr2 = new int[size];
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < dVar.f34205e.size(); i16++) {
            m1 m1Var = dVar.f34205e.get(i16).f34219b;
            if (m1Var.f33451s > 0 || o0.L(m1Var.f33442j, 2) != null) {
                iArr2[i16] = 2;
                i14++;
            } else if (o0.L(m1Var.f33442j, 1) != null) {
                iArr2[i16] = 1;
                i15++;
            } else {
                iArr2[i16] = -1;
            }
        }
        if (i14 <= 0) {
            if (i15 < size) {
                size -= i15;
                z11 = false;
                z12 = true;
            } else {
                z11 = false;
            }
            uriArr = new Uri[size];
            m1VarArr = new m1[size];
            iArr = new int[size];
            i12 = 0;
            for (i11 = 0; i11 < dVar.f34205e.size(); i11++) {
                if ((z11 || iArr2[i11] == 2) && (!z12 || iArr2[i11] != 1)) {
                    com.google.android.exoplayer2.source.hls.playlist.d.b bVar = dVar.f34205e.get(i11);
                    uriArr[i12] = bVar.f34218a;
                    m1VarArr[i12] = bVar.f34219b;
                    iArr[i12] = i11;
                    i12++;
                }
            }
            String str = m1VarArr[0].f33442j;
            int iK = o0.K(str, 2);
            int iK2 = o0.K(str, 1);
            boolean z13 = (iK2 != 1 || (iK2 == 0 && dVar.f34207g.isEmpty())) && iK <= 1 && iK2 + iK > 0;
            if (!z11 || iK2 <= 0) {
                i13 = 0;
            } else {
                i13 = 1;
            }
            p pVarL = l("main", i13, uriArr, m1VarArr, dVar.f34210j, dVar.f34211k, map, j11);
            list.add(pVarL);
            list2.add(iArr);
            if (this.f34051n || !z13) {
            }
            ArrayList arrayList = new ArrayList();
            if (iK > 0) {
                m1[] m1VarArr2 = new m1[size];
                for (int i17 = 0; i17 < size; i17++) {
                    m1VarArr2[i17] = o(m1VarArr[i17]);
                }
                arrayList.add(new i0("main", m1VarArr2));
                if (iK2 > 0 && (dVar.f34210j != null || dVar.f34207g.isEmpty())) {
                    arrayList.add(new i0("main:audio", m(m1VarArr[0], dVar.f34210j, false)));
                }
                List<m1> list3 = dVar.f34211k;
                if (list3 != null) {
                    for (int i18 = 0; i18 < list3.size(); i18++) {
                        arrayList.add(new i0("main:cc:" + i18, list3.get(i18)));
                    }
                }
            } else {
                m1[] m1VarArr3 = new m1[size];
                for (int i19 = 0; i19 < size; i19++) {
                    m1VarArr3[i19] = m(m1VarArr[i19], dVar.f34210j, true);
                }
                arrayList.add(new i0("main", m1VarArr3));
            }
            i0 i0Var = new i0("main:id3", new m1.b().S("ID3").e0(MimeTypes.APPLICATION_ID3).E());
            arrayList.add(i0Var);
            pVarL.Q((i0[]) arrayList.toArray(new i0[0]), 0, arrayList.indexOf(i0Var));
            return;
        }
        size = i14;
        z11 = true;
        z12 = false;
        uriArr = new Uri[size];
        m1VarArr = new m1[size];
        iArr = new int[size];
        i12 = 0;
        while (i11 < dVar.f34205e.size()) {
            if (z11) {
                com.google.android.exoplayer2.source.hls.playlist.d.b bVar2 = dVar.f34205e.get(i11);
                uriArr[i12] = bVar2.f34218a;
                m1VarArr[i12] = bVar2.f34219b;
                iArr[i12] = i11;
                i12++;
            } else {
                com.google.android.exoplayer2.source.hls.playlist.d.b bVar3 = dVar.f34205e.get(i11);
                uriArr[i12] = bVar3.f34218a;
                m1VarArr[i12] = bVar3.f34219b;
                iArr[i12] = i11;
                i12++;
            }
        }
        String str2 = m1VarArr[0].f33442j;
        int iK3 = o0.K(str2, 2);
        int iK4 = o0.K(str2, 1);
        if (iK4 != 1) {
        }
        if (z11) {
            i13 = 0;
        } else {
            i13 = 0;
        }
        p pVarL2 = l("main", i13, uriArr, m1VarArr, dVar.f34210j, dVar.f34211k, map, j11);
        list.add(pVarL2);
        list2.add(iArr);
        if (this.f34051n) {
        }
    }

    public final void k(long j11) {
        com.google.android.exoplayer2.source.hls.playlist.d dVar = (com.google.android.exoplayer2.source.hls.playlist.d) com.google.android.exoplayer2.util.a.e(this.f34040b.c());
        Map<String, DrmInitData> mapN = this.f34053p ? n(dVar.f34213m) : Collections.emptyMap();
        int i11 = 1;
        boolean z11 = !dVar.f34205e.isEmpty();
        List<com.google.android.exoplayer2.source.hls.playlist.d.a> list = dVar.f34207g;
        List<com.google.android.exoplayer2.source.hls.playlist.d.a> list2 = dVar.f34208h;
        char c11 = 0;
        this.f34056s = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z11) {
            j(dVar, j11, arrayList, arrayList2, mapN);
        }
        i(j11, list, arrayList, arrayList2, mapN);
        this.f34061x = arrayList.size();
        int i12 = 0;
        while (i12 < list2.size()) {
            com.google.android.exoplayer2.source.hls.playlist.d.a aVar = list2.get(i12);
            String str = "subtitle:" + i12 + ":" + aVar.f34217d;
            Uri[] uriArr = new Uri[i11];
            uriArr[c11] = aVar.f34214a;
            m1[] m1VarArr = new m1[i11];
            m1VarArr[c11] = aVar.f34215b;
            ArrayList arrayList3 = arrayList2;
            int i13 = i12;
            p pVarL = l(str, 3, uriArr, m1VarArr, null, Collections.emptyList(), mapN, j11);
            arrayList3.add(new int[]{i13});
            arrayList.add(pVarL);
            pVarL.Q(new i0[]{new i0(str, aVar.f34215b)}, 0, new int[0]);
            i12 = i13 + 1;
            arrayList2 = arrayList3;
            i11 = 1;
            c11 = 0;
        }
        this.f34058u = (p[]) arrayList.toArray(new p[0]);
        this.f34060w = (int[][]) arrayList2.toArray(new int[0][]);
        this.f34056s = this.f34058u.length;
        for (int i14 = 0; i14 < this.f34061x; i14++) {
            this.f34058u[i14].Z(true);
        }
        for (p pVar : this.f34058u) {
            pVar.o();
        }
        this.f34059v = this.f34058u;
    }

    public final p l(String str, int i11, Uri[] uriArr, m1[] m1VarArr, @Nullable m1 m1Var, @Nullable List<m1> list, Map<String, DrmInitData> map, long j11) {
        return new p(str, i11, this, new e(this.f34039a, this.f34040b, uriArr, m1VarArr, this.f34041c, this.f34042d, this.f34049l, list, this.f34054q), map, this.f34047j, j11, m1Var, this.f34043f, this.f34044g, this.f34045h, this.f34046i, this.f34052o);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        for (p pVar : this.f34058u) {
            pVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void onPrepared() {
        int i11 = this.f34056s - 1;
        this.f34056s = i11;
        if (i11 > 0) {
            return;
        }
        int i12 = 0;
        for (p pVar : this.f34058u) {
            i12 += pVar.getTrackGroups().f71941a;
        }
        i0[] i0VarArr = new i0[i12];
        int i13 = 0;
        for (p pVar2 : this.f34058u) {
            int i14 = pVar2.getTrackGroups().f71941a;
            int i15 = 0;
            while (i15 < i14) {
                i0VarArr[i13] = pVar2.getTrackGroups().b(i15);
                i15++;
                i13++;
            }
        }
        this.f34057t = new nh.k0(i0VarArr);
        this.f34055r.h(this);
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void g(p pVar) {
        this.f34055r.g(this);
    }

    public void q() {
        this.f34040b.k(this);
        for (p pVar : this.f34058u) {
            pVar.S();
        }
        this.f34055r = null;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        this.f34062y.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        p[] pVarArr = this.f34059v;
        if (pVarArr.length > 0) {
            boolean zV = pVarArr[0].V(j11, false);
            int i11 = 1;
            while (true) {
                p[] pVarArr2 = this.f34059v;
                if (i11 >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i11].V(j11, zV);
                i11++;
            }
            if (zV) {
                this.f34049l.b();
            }
        }
        return j11;
    }
}

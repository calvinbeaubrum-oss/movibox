package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.e0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import fi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import nh.i0;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f33988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f33989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f33990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f33991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri[] f33992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m1[] f33993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HlsPlaylistTracker f33994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f33995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final List<m1> f33996i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u1 f33998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f33999l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public IOException f34001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public Uri f34002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f34003p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s f34004q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f34006s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FullSegmentEncryptionKeyCache f33997j = new FullSegmentEncryptionKeyCache(4);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f34000m = o0.f35613f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f34005r = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends ph.l {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public byte[] f34007l;

        public a(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, byte[] bArr) {
            super(kVar, nVar, 3, m1Var, i11, obj, bArr);
        }

        @Override // ph.l
        public void e(byte[] bArr, int i11) {
            this.f34007l = Arrays.copyOf(bArr, i11);
        }

        @Nullable
        public byte[] h() {
            return this.f34007l;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public ph.f f34008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f34009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Uri f34010c;

        public b() {
            a();
        }

        public void a() {
            this.f34008a = null;
            this.f34009b = false;
            this.f34010c = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends ph.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<com.google.android.exoplayer2.source.hls.playlist.c.e> f34011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f34012f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f34013g;

        public c(String str, long j11, List<com.google.android.exoplayer2.source.hls.playlist.c.e> list) {
            super(0L, list.size() - 1);
            this.f34013g = str;
            this.f34012f = j11;
            this.f34011e = list;
        }

        @Override // ph.o
        public long a() {
            c();
            return this.f34012f + this.f34011e.get((int) d()).f34191f;
        }

        @Override // ph.o
        public long b() {
            c();
            com.google.android.exoplayer2.source.hls.playlist.c.e eVar = this.f34011e.get((int) d());
            return this.f34012f + eVar.f34191f + eVar.f34189c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends fi.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f34014h;

        public d(i0 i0Var, int[] iArr) {
            super(i0Var, iArr);
            this.f34014h = g(i0Var.c(iArr[0]));
        }

        @Override // fi.s
        public void d(long j11, long j12, long j13, List<? extends ph.n> list, ph.o[] oVarArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (e(this.f34014h, jElapsedRealtime)) {
                for (int i11 = this.f64956b - 1; i11 >= 0; i11--) {
                    if (!e(i11, jElapsedRealtime)) {
                        this.f34014h = i11;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // fi.s
        public int getSelectedIndex() {
            return this.f34014h;
        }

        @Override // fi.s
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // fi.s
        public int getSelectionReason() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0365e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.hls.playlist.c.e f34015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f34018d;

        public C0365e(com.google.android.exoplayer2.source.hls.playlist.c.e eVar, long j11, int i11) {
            this.f34015a = eVar;
            this.f34016b = j11;
            this.f34017c = i11;
            this.f34018d = (eVar instanceof com.google.android.exoplayer2.source.hls.playlist.c.b) && ((com.google.android.exoplayer2.source.hls.playlist.c.b) eVar).f34181n;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, m1[] m1VarArr, f fVar, @Nullable k0 k0Var, q qVar, @Nullable List<m1> list, u1 u1Var) {
        this.f33988a = gVar;
        this.f33994g = hlsPlaylistTracker;
        this.f33992e = uriArr;
        this.f33993f = m1VarArr;
        this.f33991d = qVar;
        this.f33996i = list;
        this.f33998k = u1Var;
        com.google.android.exoplayer2.upstream.k kVarA = fVar.a(1);
        this.f33989b = kVarA;
        if (k0Var != null) {
            kVarA.e(k0Var);
        }
        this.f33990c = fVar.a(3);
        this.f33995h = new i0(m1VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((m1VarArr[i11].f33438f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        this.f34004q = new d(this.f33995h, Ints.m(arrayList));
    }

    @Nullable
    public static Uri d(com.google.android.exoplayer2.source.hls.playlist.c cVar, @Nullable com.google.android.exoplayer2.source.hls.playlist.c.e eVar) {
        String str;
        if (eVar == null || (str = eVar.f34193h) == null) {
            return null;
        }
        return m0.e(cVar.f76359a, str);
    }

    @Nullable
    public static C0365e g(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11, int i11) {
        int i12 = (int) (j11 - cVar.f34168k);
        if (i12 == cVar.f34175r.size()) {
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 < cVar.f34176s.size()) {
                return new C0365e(cVar.f34176s.get(i11), j11, i11);
            }
            return null;
        }
        com.google.android.exoplayer2.source.hls.playlist.c.d dVar = cVar.f34175r.get(i12);
        if (i11 == -1) {
            return new C0365e(dVar, j11, -1);
        }
        if (i11 < dVar.f34186n.size()) {
            return new C0365e(dVar.f34186n.get(i11), j11, i11);
        }
        int i13 = i12 + 1;
        if (i13 < cVar.f34175r.size()) {
            return new C0365e(cVar.f34175r.get(i13), j11 + 1, -1);
        }
        if (cVar.f34176s.isEmpty()) {
            return null;
        }
        return new C0365e(cVar.f34176s.get(0), j11 + 1, 0);
    }

    public static List<com.google.android.exoplayer2.source.hls.playlist.c.e> i(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11, int i11) {
        int i12 = (int) (j11 - cVar.f34168k);
        if (i12 < 0 || cVar.f34175r.size() < i12) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i12 < cVar.f34175r.size()) {
            if (i11 != -1) {
                com.google.android.exoplayer2.source.hls.playlist.c.d dVar = cVar.f34175r.get(i12);
                if (i11 == 0) {
                    arrayList.add(dVar);
                } else if (i11 < dVar.f34186n.size()) {
                    List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = dVar.f34186n;
                    arrayList.addAll(list.subList(i11, list.size()));
                }
                i12++;
            }
            List<com.google.android.exoplayer2.source.hls.playlist.c.d> list2 = cVar.f34175r;
            arrayList.addAll(list2.subList(i12, list2.size()));
            i11 = 0;
        }
        if (cVar.f34171n != C.TIME_UNSET) {
            int i13 = i11 != -1 ? i11 : 0;
            if (i13 < cVar.f34176s.size()) {
                List<com.google.android.exoplayer2.source.hls.playlist.c.b> list3 = cVar.f34176s;
                arrayList.addAll(list3.subList(i13, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public ph.o[] a(@Nullable i iVar, long j11) {
        int i11;
        int iD = iVar == null ? -1 : this.f33995h.d(iVar.f73809d);
        int length = this.f34004q.length();
        ph.o[] oVarArr = new ph.o[length];
        boolean z11 = false;
        int i12 = 0;
        while (i12 < length) {
            int indexInTrackGroup = this.f34004q.getIndexInTrackGroup(i12);
            Uri uri = this.f33992e[indexInTrackGroup];
            if (this.f33994g.e(uri)) {
                com.google.android.exoplayer2.source.hls.playlist.c cVarI = this.f33994g.i(uri, z11);
                com.google.android.exoplayer2.util.a.e(cVarI);
                long jB = cVarI.f34165h - this.f33994g.b();
                i11 = i12;
                Pair<Long, Integer> pairF = f(iVar, indexInTrackGroup != iD, cVarI, jB, j11);
                oVarArr[i11] = new c(cVarI.f76359a, jB, i(cVarI, ((Long) pairF.first).longValue(), ((Integer) pairF.second).intValue()));
            } else {
                oVarArr[i12] = ph.o.f73858a;
                i11 = i12;
            }
            i12 = i11 + 1;
            z11 = false;
        }
        return oVarArr;
    }

    public long b(long j11, b3 b3Var) {
        int selectedIndex = this.f34004q.getSelectedIndex();
        Uri[] uriArr = this.f33992e;
        com.google.android.exoplayer2.source.hls.playlist.c cVarI = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.f33994g.i(uriArr[this.f34004q.getSelectedIndexInTrackGroup()], true);
        if (cVarI == null || cVarI.f34175r.isEmpty() || !cVarI.f76361c) {
            return j11;
        }
        long jB = cVarI.f34165h - this.f33994g.b();
        long j12 = j11 - jB;
        int iG = o0.g(cVarI.f34175r, Long.valueOf(j12), true, true);
        long j13 = cVarI.f34175r.get(iG).f34191f;
        return b3Var.a(j12, j13, iG != cVarI.f34175r.size() - 1 ? cVarI.f34175r.get(iG + 1).f34191f : j13) + jB;
    }

    public int c(i iVar) {
        if (iVar.f34027o == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar = (com.google.android.exoplayer2.source.hls.playlist.c) com.google.android.exoplayer2.util.a.e(this.f33994g.i(this.f33992e[this.f33995h.d(iVar.f73809d)], false));
        int i11 = (int) (iVar.f73857j - cVar.f34168k);
        if (i11 < 0) {
            return 1;
        }
        List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = i11 < cVar.f34175r.size() ? cVar.f34175r.get(i11).f34186n : cVar.f34176s;
        if (iVar.f34027o >= list.size()) {
            return 2;
        }
        com.google.android.exoplayer2.source.hls.playlist.c.b bVar = list.get(iVar.f34027o);
        if (bVar.f34181n) {
            return 0;
        }
        return o0.c(Uri.parse(m0.d(cVar.f76359a, bVar.f34187a)), iVar.f73807b.f35422a) ? 1 : 2;
    }

    public void e(long j11, long j12, List<i> list, boolean z11, b bVar) {
        com.google.android.exoplayer2.source.hls.playlist.c cVar;
        long jB;
        Uri uri;
        int i11;
        i iVar = list.isEmpty() ? null : (i) e0.g(list);
        int iD = iVar == null ? -1 : this.f33995h.d(iVar.f73809d);
        long jMax = j12 - j11;
        long jS = s(j11);
        if (iVar != null && !this.f34003p) {
            long jB2 = iVar.b();
            jMax = Math.max(0L, jMax - jB2);
            if (jS != C.TIME_UNSET) {
                jS = Math.max(0L, jS - jB2);
            }
        }
        this.f34004q.d(j11, jMax, jS, list, a(iVar, j12));
        int selectedIndexInTrackGroup = this.f34004q.getSelectedIndexInTrackGroup();
        boolean z12 = iD != selectedIndexInTrackGroup;
        Uri uri2 = this.f33992e[selectedIndexInTrackGroup];
        if (!this.f33994g.e(uri2)) {
            bVar.f34010c = uri2;
            this.f34006s &= uri2.equals(this.f34002o);
            this.f34002o = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVarI = this.f33994g.i(uri2, true);
        com.google.android.exoplayer2.util.a.e(cVarI);
        this.f34003p = cVarI.f76361c;
        w(cVarI);
        long jB3 = cVarI.f34165h - this.f33994g.b();
        Pair<Long, Integer> pairF = f(iVar, z12, cVarI, jB3, j12);
        long jLongValue = ((Long) pairF.first).longValue();
        int iIntValue = ((Integer) pairF.second).intValue();
        if (jLongValue >= cVarI.f34168k || iVar == null || !z12) {
            cVar = cVarI;
            jB = jB3;
            uri = uri2;
            i11 = selectedIndexInTrackGroup;
        } else {
            Uri uri3 = this.f33992e[iD];
            com.google.android.exoplayer2.source.hls.playlist.c cVarI2 = this.f33994g.i(uri3, true);
            com.google.android.exoplayer2.util.a.e(cVarI2);
            jB = cVarI2.f34165h - this.f33994g.b();
            Pair<Long, Integer> pairF2 = f(iVar, false, cVarI2, jB, j12);
            jLongValue = ((Long) pairF2.first).longValue();
            iIntValue = ((Integer) pairF2.second).intValue();
            i11 = iD;
            uri = uri3;
            cVar = cVarI2;
        }
        if (jLongValue < cVar.f34168k) {
            this.f34001n = new BehindLiveWindowException();
            return;
        }
        C0365e c0365eG = g(cVar, jLongValue, iIntValue);
        if (c0365eG == null) {
            if (!cVar.f34172o) {
                bVar.f34010c = uri;
                this.f34006s &= uri.equals(this.f34002o);
                this.f34002o = uri;
                return;
            } else {
                if (z11 || cVar.f34175r.isEmpty()) {
                    bVar.f34009b = true;
                    return;
                }
                c0365eG = new C0365e((com.google.android.exoplayer2.source.hls.playlist.c.e) e0.g(cVar.f34175r), (cVar.f34168k + ((long) cVar.f34175r.size())) - 1, -1);
            }
        }
        this.f34006s = false;
        this.f34002o = null;
        Uri uriD = d(cVar, c0365eG.f34015a.f34188b);
        ph.f fVarL = l(uriD, i11);
        bVar.f34008a = fVarL;
        if (fVarL != null) {
            return;
        }
        Uri uriD2 = d(cVar, c0365eG.f34015a);
        ph.f fVarL2 = l(uriD2, i11);
        bVar.f34008a = fVarL2;
        if (fVarL2 != null) {
            return;
        }
        boolean zU = i.u(iVar, uri, cVar, c0365eG, jB);
        if (zU && c0365eG.f34018d) {
            return;
        }
        bVar.f34008a = i.h(this.f33988a, this.f33989b, this.f33993f[i11], jB, cVar, c0365eG, uri, this.f33996i, this.f34004q.getSelectionReason(), this.f34004q.getSelectionData(), this.f33999l, this.f33991d, iVar, this.f33997j.a(uriD2), this.f33997j.a(uriD), zU, this.f33998k);
    }

    public final Pair<Long, Integer> f(@Nullable i iVar, boolean z11, com.google.android.exoplayer2.source.hls.playlist.c cVar, long j11, long j12) {
        int i11 = -1;
        if (iVar != null && !z11) {
            if (!iVar.f()) {
                return new Pair<>(Long.valueOf(iVar.f73857j), Integer.valueOf(iVar.f34027o));
            }
            Long lValueOf = Long.valueOf(iVar.f34027o == -1 ? iVar.e() : iVar.f73857j);
            int i12 = iVar.f34027o;
            return new Pair<>(lValueOf, Integer.valueOf(i12 != -1 ? i12 + 1 : -1));
        }
        long j13 = cVar.f34178u + j11;
        if (iVar != null && !this.f34003p) {
            j12 = iVar.f73812g;
        }
        if (!cVar.f34172o && j12 >= j13) {
            return new Pair<>(Long.valueOf(cVar.f34168k + ((long) cVar.f34175r.size())), -1);
        }
        long j14 = j12 - j11;
        int iG = o0.g(cVar.f34175r, Long.valueOf(j14), true, !this.f33994g.f() || iVar == null);
        long j15 = ((long) iG) + cVar.f34168k;
        if (iG >= 0) {
            com.google.android.exoplayer2.source.hls.playlist.c.d dVar = cVar.f34175r.get(iG);
            List<com.google.android.exoplayer2.source.hls.playlist.c.b> list = j14 < dVar.f34191f + dVar.f34189c ? dVar.f34186n : cVar.f34176s;
            for (int i13 = 0; i13 < list.size(); i13++) {
                com.google.android.exoplayer2.source.hls.playlist.c.b bVar = list.get(i13);
                if (j14 < bVar.f34191f + bVar.f34189c) {
                    if (!bVar.f34180m) {
                        break;
                    }
                    j15 += list == cVar.f34176s ? 1L : 0L;
                    i11 = i13;
                    break;
                }
            }
        }
        return new Pair<>(Long.valueOf(j15), Integer.valueOf(i11));
    }

    public int h(long j11, List<? extends ph.n> list) {
        return (this.f34001n != null || this.f34004q.length() < 2) ? list.size() : this.f34004q.evaluateQueueSize(j11, list);
    }

    public i0 j() {
        return this.f33995h;
    }

    public s k() {
        return this.f34004q;
    }

    @Nullable
    public final ph.f l(@Nullable Uri uri, int i11) {
        if (uri == null) {
            return null;
        }
        byte[] bArrC = this.f33997j.c(uri);
        if (bArrC != null) {
            this.f33997j.b(uri, bArrC);
            return null;
        }
        return new a(this.f33990c, new com.google.android.exoplayer2.upstream.n.b().i(uri).b(1).a(), this.f33993f[i11], this.f34004q.getSelectionReason(), this.f34004q.getSelectionData(), this.f34000m);
    }

    public boolean m(ph.f fVar, long j11) {
        s sVar = this.f34004q;
        return sVar.blacklist(sVar.indexOf(this.f33995h.d(fVar.f73809d)), j11);
    }

    public void n() throws IOException {
        IOException iOException = this.f34001n;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f34002o;
        if (uri == null || !this.f34006s) {
            return;
        }
        this.f33994g.a(uri);
    }

    public boolean o(Uri uri) {
        return o0.s(this.f33992e, uri);
    }

    public void p(ph.f fVar) {
        if (fVar instanceof a) {
            a aVar = (a) fVar;
            this.f34000m = aVar.f();
            this.f33997j.b(aVar.f73807b.f35422a, (byte[]) com.google.android.exoplayer2.util.a.e(aVar.h()));
        }
    }

    public boolean q(Uri uri, long j11) {
        int iIndexOf;
        int i11 = 0;
        while (true) {
            Uri[] uriArr = this.f33992e;
            if (i11 >= uriArr.length) {
                i11 = -1;
                break;
            }
            if (uriArr[i11].equals(uri)) {
                break;
            }
            i11++;
        }
        if (i11 == -1 || (iIndexOf = this.f34004q.indexOf(i11)) == -1) {
            return true;
        }
        this.f34006s |= uri.equals(this.f34002o);
        return j11 == C.TIME_UNSET || (this.f34004q.blacklist(iIndexOf, j11) && this.f33994g.g(uri, j11));
    }

    public void r() {
        this.f34001n = null;
    }

    public final long s(long j11) {
        long j12 = this.f34005r;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    public void t(boolean z11) {
        this.f33999l = z11;
    }

    public void u(s sVar) {
        this.f34004q = sVar;
    }

    public boolean v(long j11, ph.f fVar, List<? extends ph.n> list) {
        if (this.f34001n != null) {
            return false;
        }
        return this.f34004q.f(j11, fVar, list);
    }

    public final void w(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        this.f34005r = cVar.f34172o ? C.TIME_UNSET : cVar.d() - this.f33994g.b();
    }
}

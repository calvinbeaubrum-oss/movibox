package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.w1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.e0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s4.z;
import z3.k0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f10381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.datasource.a f10382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.datasource.a f10383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f10384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri[] f10385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y[] f10386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HlsPlaylistTracker f10387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n0 f10388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final List<y> f10389i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x3 f10391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f10392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10393m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public IOException f10395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public Uri f10396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z f10398r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f10401u = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FullSegmentEncryptionKeyCache f10390j = new FullSegmentEncryptionKeyCache(4);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f10394n = u0.f81843f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f10399s = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends q4.k {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public byte[] f10402l;

        public a(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, byte[] bArr) {
            super(aVar, gVar, 3, yVar, i11, obj, bArr);
        }

        @Override // q4.k
        public void e(byte[] bArr, int i11) {
            this.f10402l = Arrays.copyOf(bArr, i11);
        }

        @Nullable
        public byte[] h() {
            return this.f10402l;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public q4.e f10403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Uri f10405c;

        public b() {
            a();
        }

        public void a() {
            this.f10403a = null;
            this.f10404b = false;
            this.f10405c = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends q4.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<androidx.media3.exoplayer.hls.playlist.b.e> f10406e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f10407f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f10408g;

        public c(String str, long j11, List<androidx.media3.exoplayer.hls.playlist.b.e> list) {
            super(0L, list.size() - 1);
            this.f10408g = str;
            this.f10407f = j11;
            this.f10406e = list;
        }

        @Override // q4.n
        public long a() {
            c();
            return this.f10407f + this.f10406e.get((int) d()).f10554f;
        }

        @Override // q4.n
        public long b() {
            c();
            androidx.media3.exoplayer.hls.playlist.b.e eVar = this.f10406e.get((int) d());
            return this.f10407f + eVar.f10554f + eVar.f10552c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends s4.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10409h;

        public d(n0 n0Var, int[] iArr) {
            super(n0Var, iArr);
            this.f10409h = e(n0Var.a(iArr[0]));
        }

        @Override // s4.z
        public int getSelectedIndex() {
            return this.f10409h;
        }

        @Override // s4.z
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // s4.z
        public int getSelectionReason() {
            return 0;
        }

        @Override // s4.z
        public void h(long j11, long j12, long j13, List<? extends q4.m> list, q4.n[] nVarArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (d(this.f10409h, jElapsedRealtime)) {
                for (int i11 = this.f75995b - 1; i11 >= 0; i11--) {
                    if (!d(i11, jElapsedRealtime)) {
                        this.f10409h = i11;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.hls.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0098e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.hls.playlist.b.e f10410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f10413d;

        public C0098e(androidx.media3.exoplayer.hls.playlist.b.e eVar, long j11, int i11) {
            this.f10410a = eVar;
            this.f10411b = j11;
            this.f10412c = i11;
            this.f10413d = (eVar instanceof androidx.media3.exoplayer.hls.playlist.b.C0100b) && ((androidx.media3.exoplayer.hls.playlist.b.C0100b) eVar).f10544n;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, y[] yVarArr, f fVar, @Nullable c4.o oVar, r rVar, long j11, @Nullable List<y> list, x3 x3Var, @Nullable androidx.media3.exoplayer.upstream.f fVar2) {
        this.f10381a = gVar;
        this.f10387g = hlsPlaylistTracker;
        this.f10385e = uriArr;
        this.f10386f = yVarArr;
        this.f10384d = rVar;
        this.f10392l = j11;
        this.f10389i = list;
        this.f10391k = x3Var;
        androidx.media3.datasource.a aVarA = fVar.a(1);
        this.f10382b = aVarA;
        if (oVar != null) {
            aVarA.c(oVar);
        }
        this.f10383c = fVar.a(3);
        this.f10388h = new n0(yVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((yVarArr[i11].f9494f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        this.f10398r = new d(this.f10388h, Ints.m(arrayList));
    }

    @Nullable
    public static Uri d(androidx.media3.exoplayer.hls.playlist.b bVar, @Nullable androidx.media3.exoplayer.hls.playlist.b.e eVar) {
        String str;
        if (eVar == null || (str = eVar.f10556h) == null) {
            return null;
        }
        return k0.f(bVar.f68239a, str);
    }

    @Nullable
    public static C0098e g(androidx.media3.exoplayer.hls.playlist.b bVar, long j11, int i11) {
        int i12 = (int) (j11 - bVar.f10531k);
        if (i12 == bVar.f10538r.size()) {
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 < bVar.f10539s.size()) {
                return new C0098e(bVar.f10539s.get(i11), j11, i11);
            }
            return null;
        }
        androidx.media3.exoplayer.hls.playlist.b.d dVar = bVar.f10538r.get(i12);
        if (i11 == -1) {
            return new C0098e(dVar, j11, -1);
        }
        if (i11 < dVar.f10549n.size()) {
            return new C0098e(dVar.f10549n.get(i11), j11, i11);
        }
        int i13 = i12 + 1;
        if (i13 < bVar.f10538r.size()) {
            return new C0098e(bVar.f10538r.get(i13), j11 + 1, -1);
        }
        if (bVar.f10539s.isEmpty()) {
            return null;
        }
        return new C0098e(bVar.f10539s.get(0), j11 + 1, 0);
    }

    public static List<androidx.media3.exoplayer.hls.playlist.b.e> i(androidx.media3.exoplayer.hls.playlist.b bVar, long j11, int i11) {
        int i12 = (int) (j11 - bVar.f10531k);
        if (i12 < 0 || bVar.f10538r.size() < i12) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i12 < bVar.f10538r.size()) {
            if (i11 != -1) {
                androidx.media3.exoplayer.hls.playlist.b.d dVar = bVar.f10538r.get(i12);
                if (i11 == 0) {
                    arrayList.add(dVar);
                } else if (i11 < dVar.f10549n.size()) {
                    List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list = dVar.f10549n;
                    arrayList.addAll(list.subList(i11, list.size()));
                }
                i12++;
            }
            List<androidx.media3.exoplayer.hls.playlist.b.d> list2 = bVar.f10538r;
            arrayList.addAll(list2.subList(i12, list2.size()));
            i11 = 0;
        }
        if (bVar.f10534n != C.TIME_UNSET) {
            int i13 = i11 != -1 ? i11 : 0;
            if (i13 < bVar.f10539s.size()) {
                List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list3 = bVar.f10539s;
                arrayList.addAll(list3.subList(i13, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public q4.n[] a(@Nullable i iVar, long j11) {
        int i11;
        int iB = iVar == null ? -1 : this.f10388h.b(iVar.f74325d);
        int length = this.f10398r.length();
        q4.n[] nVarArr = new q4.n[length];
        boolean z11 = false;
        int i12 = 0;
        while (i12 < length) {
            int indexInTrackGroup = this.f10398r.getIndexInTrackGroup(i12);
            Uri uri = this.f10385e[indexInTrackGroup];
            if (this.f10387g.e(uri)) {
                androidx.media3.exoplayer.hls.playlist.b bVarI = this.f10387g.i(uri, z11);
                z3.a.e(bVarI);
                long jB = bVarI.f10528h - this.f10387g.b();
                i11 = i12;
                Pair<Long, Integer> pairF = f(iVar, indexInTrackGroup != iB, bVarI, jB, j11);
                nVarArr[i11] = new c(bVarI.f68239a, jB, i(bVarI, ((Long) pairF.first).longValue(), ((Integer) pairF.second).intValue()));
            } else {
                nVarArr[i12] = q4.n.f74374a;
                i11 = i12;
            }
            i12 = i11 + 1;
            z11 = false;
        }
        return nVarArr;
    }

    public long b(long j11, b3 b3Var) {
        int selectedIndex = this.f10398r.getSelectedIndex();
        Uri[] uriArr = this.f10385e;
        androidx.media3.exoplayer.hls.playlist.b bVarI = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.f10387g.i(uriArr[this.f10398r.getSelectedIndexInTrackGroup()], true);
        if (bVarI == null || bVarI.f10538r.isEmpty() || !bVarI.f68241c) {
            return j11;
        }
        long jB = bVarI.f10528h - this.f10387g.b();
        long j12 = j11 - jB;
        int iE = u0.e(bVarI.f10538r, Long.valueOf(j12), true, true);
        long j13 = bVarI.f10538r.get(iE).f10554f;
        return b3Var.a(j12, j13, iE != bVarI.f10538r.size() - 1 ? bVarI.f10538r.get(iE + 1).f10554f : j13) + jB;
    }

    public int c(i iVar) {
        if (iVar.f10421o == -1) {
            return 1;
        }
        androidx.media3.exoplayer.hls.playlist.b bVar = (androidx.media3.exoplayer.hls.playlist.b) z3.a.e(this.f10387g.i(this.f10385e[this.f10388h.b(iVar.f74325d)], false));
        int i11 = (int) (iVar.f74373j - bVar.f10531k);
        if (i11 < 0) {
            return 1;
        }
        List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list = i11 < bVar.f10538r.size() ? bVar.f10538r.get(i11).f10549n : bVar.f10539s;
        if (iVar.f10421o >= list.size()) {
            return 2;
        }
        androidx.media3.exoplayer.hls.playlist.b.C0100b c0100b = list.get(iVar.f10421o);
        if (c0100b.f10544n) {
            return 0;
        }
        return u0.c(Uri.parse(k0.e(bVar.f68239a, c0100b.f10550a)), iVar.f74323b.f14598a) ? 1 : 2;
    }

    public void e(w1 w1Var, long j11, List<i> list, boolean z11, b bVar) {
        androidx.media3.exoplayer.hls.playlist.b bVar2;
        long jB;
        i iVar = list.isEmpty() ? null : (i) e0.g(list);
        int iB = iVar == null ? -1 : this.f10388h.b(iVar.f74325d);
        long j12 = w1Var.f11756a;
        long jMax = j11 - j12;
        long jT = t(j12);
        if (iVar != null && !this.f10397q) {
            long jB2 = iVar.b();
            jMax = Math.max(0L, jMax - jB2);
            if (jT != C.TIME_UNSET) {
                jT = Math.max(0L, jT - jB2);
            }
        }
        this.f10398r.h(j12, jMax, jT, list, a(iVar, j11));
        int selectedIndexInTrackGroup = this.f10398r.getSelectedIndexInTrackGroup();
        boolean z12 = iB != selectedIndexInTrackGroup;
        Uri uri = this.f10385e[selectedIndexInTrackGroup];
        if (!this.f10387g.e(uri)) {
            bVar.f10405c = uri;
            this.f10400t &= uri.equals(this.f10396p);
            this.f10396p = uri;
            return;
        }
        androidx.media3.exoplayer.hls.playlist.b bVarI = this.f10387g.i(uri, true);
        z3.a.e(bVarI);
        this.f10397q = bVarI.f68241c;
        x(bVarI);
        long jB3 = bVarI.f10528h - this.f10387g.b();
        Uri uri2 = uri;
        Pair<Long, Integer> pairF = f(iVar, z12, bVarI, jB3, j11);
        long jLongValue = ((Long) pairF.first).longValue();
        int iIntValue = ((Integer) pairF.second).intValue();
        if (jLongValue >= bVarI.f10531k || iVar == null || !z12) {
            bVar2 = bVarI;
            jB = jB3;
        } else {
            uri2 = this.f10385e[iB];
            androidx.media3.exoplayer.hls.playlist.b bVarI2 = this.f10387g.i(uri2, true);
            z3.a.e(bVarI2);
            jB = bVarI2.f10528h - this.f10387g.b();
            Pair<Long, Integer> pairF2 = f(iVar, false, bVarI2, jB, j11);
            jLongValue = ((Long) pairF2.first).longValue();
            iIntValue = ((Integer) pairF2.second).intValue();
            bVar2 = bVarI2;
            selectedIndexInTrackGroup = iB;
        }
        if (jLongValue < bVar2.f10531k) {
            this.f10395o = new BehindLiveWindowException();
            return;
        }
        C0098e c0098eG = g(bVar2, jLongValue, iIntValue);
        if (c0098eG == null) {
            if (!bVar2.f10535o) {
                bVar.f10405c = uri2;
                this.f10400t &= uri2.equals(this.f10396p);
                this.f10396p = uri2;
                return;
            } else {
                if (z11 || bVar2.f10538r.isEmpty()) {
                    bVar.f10404b = true;
                    return;
                }
                c0098eG = new C0098e((androidx.media3.exoplayer.hls.playlist.b.e) e0.g(bVar2.f10538r), (bVar2.f10531k + ((long) bVar2.f10538r.size())) - 1, -1);
            }
        }
        this.f10400t = false;
        this.f10396p = null;
        this.f10401u = SystemClock.elapsedRealtime();
        Uri uriD = d(bVar2, c0098eG.f10410a.f10551b);
        q4.e eVarM = m(uriD, selectedIndexInTrackGroup, true, null);
        bVar.f10403a = eVarM;
        if (eVarM != null) {
            return;
        }
        Uri uriD2 = d(bVar2, c0098eG.f10410a);
        q4.e eVarM2 = m(uriD2, selectedIndexInTrackGroup, false, null);
        bVar.f10403a = eVarM2;
        if (eVarM2 != null) {
            return;
        }
        boolean zU = i.u(iVar, uri2, bVar2, c0098eG, jB);
        if (zU && c0098eG.f10413d) {
            return;
        }
        bVar.f10403a = i.h(this.f10381a, this.f10382b, this.f10386f[selectedIndexInTrackGroup], jB, bVar2, c0098eG, uri2, this.f10389i, this.f10398r.getSelectionReason(), this.f10398r.getSelectionData(), this.f10393m, this.f10384d, this.f10392l, iVar, this.f10390j.a(uriD2), this.f10390j.a(uriD), zU, this.f10391k, null);
    }

    public final Pair<Long, Integer> f(@Nullable i iVar, boolean z11, androidx.media3.exoplayer.hls.playlist.b bVar, long j11, long j12) {
        int i11 = -1;
        if (iVar != null && !z11) {
            if (!iVar.f()) {
                return new Pair<>(Long.valueOf(iVar.f74373j), Integer.valueOf(iVar.f10421o));
            }
            Long lValueOf = Long.valueOf(iVar.f10421o == -1 ? iVar.e() : iVar.f74373j);
            int i12 = iVar.f10421o;
            return new Pair<>(lValueOf, Integer.valueOf(i12 != -1 ? i12 + 1 : -1));
        }
        long j13 = bVar.f10541u + j11;
        if (iVar != null && !this.f10397q) {
            j12 = iVar.f74328g;
        }
        if (!bVar.f10535o && j12 >= j13) {
            return new Pair<>(Long.valueOf(bVar.f10531k + ((long) bVar.f10538r.size())), -1);
        }
        long j14 = j12 - j11;
        int iE = u0.e(bVar.f10538r, Long.valueOf(j14), true, !this.f10387g.f() || iVar == null);
        long j15 = ((long) iE) + bVar.f10531k;
        if (iE >= 0) {
            androidx.media3.exoplayer.hls.playlist.b.d dVar = bVar.f10538r.get(iE);
            List<androidx.media3.exoplayer.hls.playlist.b.C0100b> list = j14 < dVar.f10554f + dVar.f10552c ? dVar.f10549n : bVar.f10539s;
            for (int i13 = 0; i13 < list.size(); i13++) {
                androidx.media3.exoplayer.hls.playlist.b.C0100b c0100b = list.get(i13);
                if (j14 < c0100b.f10554f + c0100b.f10552c) {
                    if (!c0100b.f10543m) {
                        break;
                    }
                    j15 += list == bVar.f10539s ? 1L : 0L;
                    i11 = i13;
                    break;
                }
            }
        }
        return new Pair<>(Long.valueOf(j15), Integer.valueOf(i11));
    }

    public int h(long j11, List<? extends q4.m> list) {
        return (this.f10395o != null || this.f10398r.length() < 2) ? list.size() : this.f10398r.evaluateQueueSize(j11, list);
    }

    public n0 j() {
        return this.f10388h;
    }

    public z k() {
        return this.f10398r;
    }

    public boolean l() {
        return this.f10397q;
    }

    @Nullable
    public final q4.e m(@Nullable Uri uri, int i11, boolean z11, @Nullable androidx.media3.exoplayer.upstream.g.a aVar) {
        if (uri == null) {
            return null;
        }
        byte[] bArrC = this.f10390j.c(uri);
        if (bArrC != null) {
            this.f10390j.b(uri, bArrC);
            return null;
        }
        return new a(this.f10383c, new c4.g.b().i(uri).b(1).a(), this.f10386f[i11], this.f10398r.getSelectionReason(), this.f10398r.getSelectionData(), this.f10394n);
    }

    public boolean n(q4.e eVar, long j11) {
        z zVar = this.f10398r;
        return zVar.f(zVar.indexOf(this.f10388h.b(eVar.f74325d)), j11);
    }

    public void o() throws IOException {
        IOException iOException = this.f10395o;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f10396p;
        if (uri == null || !this.f10400t) {
            return;
        }
        this.f10387g.a(uri);
    }

    public boolean p(Uri uri) {
        return u0.s(this.f10385e, uri);
    }

    public void q(q4.e eVar) {
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            this.f10394n = aVar.f();
            this.f10390j.b(aVar.f74323b.f14598a, (byte[]) z3.a.e(aVar.h()));
        }
    }

    public boolean r(Uri uri, long j11) {
        int iIndexOf;
        int i11 = 0;
        while (true) {
            Uri[] uriArr = this.f10385e;
            if (i11 >= uriArr.length) {
                i11 = -1;
                break;
            }
            if (uriArr[i11].equals(uri)) {
                break;
            }
            i11++;
        }
        if (i11 == -1 || (iIndexOf = this.f10398r.indexOf(i11)) == -1) {
            return true;
        }
        this.f10400t |= uri.equals(this.f10396p);
        return j11 == C.TIME_UNSET || (this.f10398r.f(iIndexOf, j11) && this.f10387g.g(uri, j11));
    }

    public void s() {
        this.f10395o = null;
    }

    public final long t(long j11) {
        long j12 = this.f10399s;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    public void u(boolean z11) {
        this.f10393m = z11;
    }

    public void v(z zVar) {
        this.f10398r = zVar;
    }

    public boolean w(long j11, q4.e eVar, List<? extends q4.m> list) {
        if (this.f10395o != null) {
            return false;
        }
        return this.f10398r.g(j11, eVar, list);
    }

    public final void x(androidx.media3.exoplayer.hls.playlist.b bVar) {
        this.f10399s = bVar.f10535o ? C.TIME_UNSET : bVar.d() - this.f10387g.b();
    }
}

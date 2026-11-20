package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.a0;
import androidx.media3.common.f0;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.t;
import androidx.media3.exoplayer.w1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e4.x3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import p4.e0;
import p4.k0;
import s4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements androidx.media3.exoplayer.source.k, HlsPlaylistTracker.b {
    public t A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f10433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HlsPlaylistTracker f10434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f10435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final c4.o f10436d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f10437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.b.a f10438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f10439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.m.a f10440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f10441j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p4.d f10444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f10445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x3 f10448q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f10450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public androidx.media3.exoplayer.source.k.a f10451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k0 f10453v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10457z;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final q.b f10449r = new b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IdentityHashMap<e0, Integer> f10442k = new IdentityHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r f10443l = new r();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public q[] f10454w = new q[0];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public q[] f10455x = new q[0];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[][] f10456y = new int[0][];

    /* JADX INFO: compiled from: source.java */
    public class b implements q.b {
        public b() {
        }

        @Override // androidx.media3.exoplayer.source.t.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void h(q qVar) {
            l.this.f10451t.h(l.this);
        }

        @Override // androidx.media3.exoplayer.hls.q.b
        public void d(Uri uri) {
            l.this.f10434b.d(uri);
        }

        @Override // androidx.media3.exoplayer.hls.q.b
        public void onPrepared() {
            if (l.h(l.this) > 0) {
                return;
            }
            int i11 = 0;
            for (q qVar : l.this.f10454w) {
                i11 += qVar.getTrackGroups().f73574a;
            }
            n0[] n0VarArr = new n0[i11];
            int i12 = 0;
            for (q qVar2 : l.this.f10454w) {
                int i13 = qVar2.getTrackGroups().f73574a;
                int i14 = 0;
                while (i14 < i13) {
                    n0VarArr[i12] = qVar2.getTrackGroups().b(i14);
                    i14++;
                    i12++;
                }
            }
            l.this.f10453v = new k0(n0VarArr);
            l.this.f10451t.f(l.this);
        }
    }

    public l(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, @Nullable c4.o oVar, @Nullable androidx.media3.exoplayer.upstream.f fVar2, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar, androidx.media3.exoplayer.upstream.m mVar, androidx.media3.exoplayer.source.m.a aVar2, androidx.media3.exoplayer.upstream.b bVar, p4.d dVar, boolean z11, int i11, boolean z12, x3 x3Var, long j11) {
        this.f10433a = gVar;
        this.f10434b = hlsPlaylistTracker;
        this.f10435c = fVar;
        this.f10436d = oVar;
        this.f10437f = cVar;
        this.f10438g = aVar;
        this.f10439h = mVar;
        this.f10440i = aVar2;
        this.f10441j = bVar;
        this.f10444m = dVar;
        this.f10445n = z11;
        this.f10446o = i11;
        this.f10447p = z12;
        this.f10448q = x3Var;
        this.f10450s = j11;
        this.A = dVar.b();
    }

    public static /* synthetic */ int h(l lVar) {
        int i11 = lVar.f10452u - 1;
        lVar.f10452u = i11;
        return i11;
    }

    public static y q(y yVar, @Nullable y yVar2, boolean z11) {
        Metadata metadata;
        int i11;
        String str;
        String str2;
        int i12;
        int i13;
        String str3;
        List<a0> list;
        List<a0> listOf = ImmutableList.of();
        if (yVar2 != null) {
            str3 = yVar2.f9498j;
            metadata = yVar2.f9499k;
            i12 = yVar2.f9514z;
            i11 = yVar2.f9493e;
            i13 = yVar2.f9494f;
            str = yVar2.f9492d;
            str2 = yVar2.f9490b;
            list = yVar2.f9491c;
        } else {
            String strQ = u0.Q(yVar.f9498j, 1);
            metadata = yVar.f9499k;
            if (z11) {
                i12 = yVar.f9514z;
                i11 = yVar.f9493e;
                i13 = yVar.f9494f;
                str = yVar.f9492d;
                str2 = yVar.f9490b;
                listOf = yVar.f9491c;
            } else {
                i11 = 0;
                str = null;
                str2 = null;
                i12 = -1;
                i13 = 0;
            }
            List<a0> list2 = listOf;
            str3 = strQ;
            list = list2;
        }
        return new y.b().X(yVar.f9489a).Z(str2).a0(list).O(yVar.f9500l).k0(f0.g(str3)).M(str3).d0(metadata).K(z11 ? yVar.f9495g : -1).f0(z11 ? yVar.f9496h : -1).L(i12).m0(i11).i0(i13).b0(str).I();
    }

    public static Map<String, DrmInitData> r(List<DrmInitData> list) {
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

    public static y s(y yVar) {
        String strQ = u0.Q(yVar.f9498j, 2);
        return new y.b().X(yVar.f9489a).Z(yVar.f9490b).a0(yVar.f9491c).O(yVar.f9500l).k0(f0.g(strQ)).M(strQ).d0(yVar.f9499k).K(yVar.f9495g).f0(yVar.f9496h).r0(yVar.f9506r).V(yVar.f9507s).U(yVar.f9508t).m0(yVar.f9493e).i0(yVar.f9494f).I();
    }

    public static /* synthetic */ List t(q qVar) {
        return qVar.getTrackGroups().c();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        if (this.f10453v != null) {
            return this.A.a(w1Var);
        }
        for (q qVar : this.f10454w) {
            qVar.p();
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        for (q qVar : this.f10455x) {
            if (qVar.F()) {
                return qVar.b(j11, b3Var);
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
    public void c() {
        for (q qVar : this.f10454w) {
            qVar.P();
        }
        this.f10451t.h(this);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
    public boolean d(Uri uri, androidx.media3.exoplayer.upstream.m.c cVar, boolean z11) {
        boolean zO = true;
        for (q qVar : this.f10454w) {
            zO &= qVar.O(uri, cVar, z11);
        }
        this.f10451t.h(this);
        return zO;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        for (q qVar : this.f10455x) {
            qVar.discardBuffer(j11, z11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00df  */
    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        e0[] e0VarArr2 = e0VarArr;
        int[] iArr = new int[zVarArr.length];
        int[] iArr2 = new int[zVarArr.length];
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            e0 e0Var = e0VarArr2[i11];
            iArr[i11] = e0Var == null ? -1 : this.f10442k.get(e0Var).intValue();
            iArr2[i11] = -1;
            z zVar = zVarArr[i11];
            if (zVar != null) {
                n0 trackGroup = zVar.getTrackGroup();
                int i12 = 0;
                while (true) {
                    q[] qVarArr = this.f10454w;
                    if (i12 >= qVarArr.length) {
                        break;
                    }
                    if (qVarArr[i12].getTrackGroups().d(trackGroup) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
        }
        this.f10442k.clear();
        int length = zVarArr.length;
        e0[] e0VarArr3 = new e0[length];
        e0[] e0VarArr4 = new e0[zVarArr.length];
        z[] zVarArr2 = new z[zVarArr.length];
        q[] qVarArr2 = new q[this.f10454w.length];
        int i13 = 0;
        int i14 = 0;
        boolean z11 = false;
        while (i14 < this.f10454w.length) {
            for (int i15 = 0; i15 < zVarArr.length; i15++) {
                z zVar2 = null;
                e0VarArr4[i15] = iArr[i15] == i14 ? e0VarArr2[i15] : null;
                if (iArr2[i15] == i14) {
                    zVar2 = zVarArr[i15];
                }
                zVarArr2[i15] = zVar2;
            }
            q qVar = this.f10454w[i14];
            int i16 = i13;
            int i17 = length;
            int i18 = i14;
            z[] zVarArr3 = zVarArr2;
            q[] qVarArr3 = qVarArr2;
            boolean zX = qVar.X(zVarArr2, zArr, e0VarArr4, zArr2, j11, z11);
            int i19 = 0;
            boolean z12 = false;
            while (true) {
                if (i19 >= zVarArr.length) {
                    break;
                }
                e0 e0Var2 = e0VarArr4[i19];
                if (iArr2[i19] == i18) {
                    z3.a.e(e0Var2);
                    e0VarArr3[i19] = e0Var2;
                    this.f10442k.put(e0Var2, Integer.valueOf(i18));
                    z12 = true;
                } else if (iArr[i19] == i18) {
                    z3.a.g(e0Var2 == null);
                }
                i19++;
            }
            if (z12) {
                qVarArr3[i16] = qVar;
                i13 = i16 + 1;
                if (i16 == 0) {
                    qVar.a0(true);
                    if (zX) {
                        this.f10443l.b();
                        z11 = true;
                    } else {
                        q[] qVarArr4 = this.f10455x;
                        if (qVarArr4.length == 0 || qVar != qVarArr4[0]) {
                            this.f10443l.b();
                            z11 = true;
                        }
                    }
                } else {
                    qVar.a0(i18 < this.f10457z);
                }
            } else {
                i13 = i16;
            }
            i14 = i18 + 1;
            e0VarArr2 = e0VarArr;
            qVarArr2 = qVarArr3;
            length = i17;
            zVarArr2 = zVarArr3;
        }
        System.arraycopy(e0VarArr3, 0, e0VarArr2, 0, length);
        q[] qVarArr5 = (q[]) u0.X0(qVarArr2, i13);
        this.f10455x = qVarArr5;
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(qVarArr5);
        this.A = this.f10444m.a(immutableListCopyOf, Lists.o(immutableListCopyOf, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.hls.k
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return l.t((q) obj);
            }
        }));
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(androidx.media3.exoplayer.source.k.a aVar, long j11) {
        this.f10451t = aVar;
        this.f10434b.m(this);
        o(j11);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return this.A.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return this.A.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return (k0) z3.a.e(this.f10453v);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.A.isLoading();
    }

    public final void m(long j11, List<androidx.media3.exoplayer.hls.playlist.c.a> list, List<q> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11).f10580d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z11 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (u0.c(str, list.get(i12).f10580d)) {
                        androidx.media3.exoplayer.hls.playlist.c.a aVar = list.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(aVar.f10577a);
                        arrayList2.add(aVar.f10578b);
                        z11 &= u0.P(aVar.f10578b.f9498j, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                q qVarP = p(str2, 1, (Uri[]) arrayList.toArray((Uri[]) u0.j(new Uri[0])), (y[]) arrayList2.toArray(new y[0]), null, Collections.emptyList(), map, j11);
                list3.add(Ints.m(arrayList3));
                list2.add(qVarP);
                if (this.f10445n && z11) {
                    qVarP.R(new n0[]{new n0(str2, (y[]) arrayList2.toArray(new y[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        for (q qVar : this.f10454w) {
            qVar.maybeThrowPrepareError();
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b6  */
    public final void n(androidx.media3.exoplayer.hls.playlist.c cVar, long j11, List<q> list, List<int[]> list2, Map<String, DrmInitData> map) {
        int i11;
        boolean z11;
        boolean z12;
        Uri[] uriArr;
        y[] yVarArr;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int size = cVar.f10568e.size();
        int[] iArr2 = new int[size];
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < cVar.f10568e.size(); i17++) {
            y yVar = cVar.f10568e.get(i17).f10582b;
            if (yVar.f9507s > 0 || u0.Q(yVar.f9498j, 2) != null) {
                iArr2[i17] = 2;
                i15++;
            } else if (u0.Q(yVar.f9498j, 1) != null) {
                iArr2[i17] = 1;
                i16++;
            } else {
                iArr2[i17] = -1;
            }
        }
        if (i15 <= 0) {
            if (i16 < size) {
                i11 = size - i16;
                z11 = false;
                z12 = true;
            } else {
                i11 = size;
                z11 = false;
            }
            uriArr = new Uri[i11];
            yVarArr = new y[i11];
            iArr = new int[i11];
            i13 = 0;
            for (i12 = 0; i12 < cVar.f10568e.size(); i12++) {
                if ((z11 || iArr2[i12] == 2) && (!z12 || iArr2[i12] != 1)) {
                    androidx.media3.exoplayer.hls.playlist.c.b bVar = cVar.f10568e.get(i12);
                    uriArr[i13] = bVar.f10581a;
                    yVarArr[i13] = bVar.f10582b;
                    iArr[i13] = i12;
                    i13++;
                }
            }
            String str = yVarArr[0].f9498j;
            int iP = u0.P(str, 2);
            int iP2 = u0.P(str, 1);
            boolean z13 = (iP2 != 1 || (iP2 == 0 && cVar.f10570g.isEmpty())) && iP <= 1 && iP2 + iP > 0;
            if (!z11 || iP2 <= 0) {
                i14 = 0;
            } else {
                i14 = 1;
            }
            q qVarP = p("main", i14, uriArr, yVarArr, cVar.f10573j, cVar.f10574k, map, j11);
            list.add(qVarP);
            list2.add(iArr);
            if (this.f10445n || !z13) {
            }
            ArrayList arrayList = new ArrayList();
            if (iP > 0) {
                y[] yVarArr2 = new y[i11];
                for (int i18 = 0; i18 < i11; i18++) {
                    yVarArr2[i18] = s(yVarArr[i18]);
                }
                arrayList.add(new n0("main", yVarArr2));
                if (iP2 > 0 && (cVar.f10573j != null || cVar.f10570g.isEmpty())) {
                    arrayList.add(new n0("main:audio", q(yVarArr[0], cVar.f10573j, false)));
                }
                List<y> list3 = cVar.f10574k;
                if (list3 != null) {
                    for (int i19 = 0; i19 < list3.size(); i19++) {
                        arrayList.add(new n0("main:cc:" + i19, this.f10433a.c(list3.get(i19))));
                    }
                }
            } else {
                y[] yVarArr3 = new y[i11];
                for (int i21 = 0; i21 < i11; i21++) {
                    yVarArr3[i21] = q(yVarArr[i21], cVar.f10573j, true);
                }
                arrayList.add(new n0("main", yVarArr3));
            }
            n0 n0Var = new n0("main:id3", new y.b().X("ID3").k0(MimeTypes.APPLICATION_ID3).I());
            arrayList.add(n0Var);
            qVarP.R((n0[]) arrayList.toArray(new n0[0]), 0, arrayList.indexOf(n0Var));
            return;
        }
        i11 = i15;
        z11 = true;
        z12 = false;
        uriArr = new Uri[i11];
        yVarArr = new y[i11];
        iArr = new int[i11];
        i13 = 0;
        while (i12 < cVar.f10568e.size()) {
            if (z11) {
                androidx.media3.exoplayer.hls.playlist.c.b bVar2 = cVar.f10568e.get(i12);
                uriArr[i13] = bVar2.f10581a;
                yVarArr[i13] = bVar2.f10582b;
                iArr[i13] = i12;
                i13++;
            } else {
                androidx.media3.exoplayer.hls.playlist.c.b bVar3 = cVar.f10568e.get(i12);
                uriArr[i13] = bVar3.f10581a;
                yVarArr[i13] = bVar3.f10582b;
                iArr[i13] = i12;
                i13++;
            }
        }
        String str2 = yVarArr[0].f9498j;
        int iP3 = u0.P(str2, 2);
        int iP4 = u0.P(str2, 1);
        if (iP4 != 1) {
        }
        if (z11) {
            i14 = 0;
        } else {
            i14 = 0;
        }
        q qVarP2 = p("main", i14, uriArr, yVarArr, cVar.f10573j, cVar.f10574k, map, j11);
        list.add(qVarP2);
        list2.add(iArr);
        if (this.f10445n) {
        }
    }

    public final void o(long j11) {
        androidx.media3.exoplayer.hls.playlist.c cVar = (androidx.media3.exoplayer.hls.playlist.c) z3.a.e(this.f10434b.c());
        Map<String, DrmInitData> mapR = this.f10447p ? r(cVar.f10576m) : Collections.emptyMap();
        int i11 = 1;
        boolean z11 = !cVar.f10568e.isEmpty();
        List<androidx.media3.exoplayer.hls.playlist.c.a> list = cVar.f10570g;
        List<androidx.media3.exoplayer.hls.playlist.c.a> list2 = cVar.f10571h;
        char c11 = 0;
        this.f10452u = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z11) {
            n(cVar, j11, arrayList, arrayList2, mapR);
        }
        m(j11, list, arrayList, arrayList2, mapR);
        this.f10457z = arrayList.size();
        int i12 = 0;
        while (i12 < list2.size()) {
            androidx.media3.exoplayer.hls.playlist.c.a aVar = list2.get(i12);
            String str = "subtitle:" + i12 + ":" + aVar.f10580d;
            y yVar = aVar.f10578b;
            Uri[] uriArr = new Uri[i11];
            uriArr[c11] = aVar.f10577a;
            y[] yVarArr = new y[i11];
            yVarArr[c11] = yVar;
            ArrayList arrayList3 = arrayList2;
            int i13 = i12;
            q qVarP = p(str, 3, uriArr, yVarArr, null, Collections.emptyList(), mapR, j11);
            arrayList3.add(new int[]{i13});
            arrayList.add(qVarP);
            qVarP.R(new n0[]{new n0(str, this.f10433a.c(yVar))}, 0, new int[0]);
            i12 = i13 + 1;
            arrayList2 = arrayList3;
            i11 = 1;
            c11 = 0;
        }
        this.f10454w = (q[]) arrayList.toArray(new q[0]);
        this.f10456y = (int[][]) arrayList2.toArray(new int[0][]);
        this.f10452u = this.f10454w.length;
        for (int i14 = 0; i14 < this.f10457z; i14++) {
            this.f10454w[i14].a0(true);
        }
        for (q qVar : this.f10454w) {
            qVar.p();
        }
        this.f10455x = this.f10454w;
    }

    public final q p(String str, int i11, Uri[] uriArr, y[] yVarArr, @Nullable y yVar, @Nullable List<y> list, Map<String, DrmInitData> map, long j11) {
        return new q(str, i11, this.f10449r, new e(this.f10433a, this.f10434b, uriArr, yVarArr, this.f10435c, this.f10436d, this.f10443l, this.f10450s, list, this.f10448q, null), map, this.f10441j, j11, yVar, this.f10437f, this.f10438g, this.f10439h, this.f10440i, this.f10446o);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        this.A.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        q[] qVarArr = this.f10455x;
        if (qVarArr.length > 0) {
            boolean zW = qVarArr[0].W(j11, false);
            int i11 = 1;
            while (true) {
                q[] qVarArr2 = this.f10455x;
                if (i11 >= qVarArr2.length) {
                    break;
                }
                qVarArr2[i11].W(j11, zW);
                i11++;
            }
            if (zW) {
                this.f10443l.b();
            }
        }
        return j11;
    }

    public void u() {
        this.f10434b.l(this);
        for (q qVar : this.f10454w) {
            qVar.T();
        }
        this.f10451t = null;
    }
}

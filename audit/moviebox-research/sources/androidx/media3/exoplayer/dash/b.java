package androidx.media3.exoplayer.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.source.k;
import androidx.media3.exoplayer.source.t;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.n;
import androidx.media3.exoplayer.w1;
import c4.o;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e4.x3;
import g4.i;
import h4.e;
import h4.f;
import h4.g;
import h4.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p4.e0;
import p4.k0;
import p4.l;
import q4.h;
import s4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements k, t.a<h<androidx.media3.exoplayer.dash.a>>, h.b<androidx.media3.exoplayer.dash.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.exoplayer.dash.a.InterfaceC0095a f10132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final o f10133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f10134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f10135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g4.b f10136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f10138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f10139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k0 f10140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a[] f10141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p4.d f10142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f10143n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.m.a f10145p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.b.a f10146q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x3 f10147r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public k.a f10148s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public t f10151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h4.c f10152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<f> f10154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f10130z = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h<androidx.media3.exoplayer.dash.a>[] f10149t = y(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i[] f10150u = new i[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IdentityHashMap<h<androidx.media3.exoplayer.dash.a>, d.c> f10144o = new IdentityHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f10155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f10158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f10159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f10160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f10161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImmutableList<y> f10162h;

        public a(int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16, ImmutableList<y> immutableList) {
            this.f10156b = i11;
            this.f10155a = iArr;
            this.f10157c = i12;
            this.f10159e = i13;
            this.f10160f = i14;
            this.f10161g = i15;
            this.f10158d = i16;
            this.f10162h = immutableList;
        }

        public static a a(int[] iArr, int i11, ImmutableList<y> immutableList) {
            return new a(3, 1, iArr, i11, -1, -1, -1, immutableList);
        }

        public static a b(int[] iArr, int i11) {
            return new a(5, 1, iArr, i11, -1, -1, -1, ImmutableList.of());
        }

        public static a c(int i11) {
            return new a(5, 2, new int[0], -1, -1, -1, i11, ImmutableList.of());
        }

        public static a d(int i11, int[] iArr, int i12, int i13, int i14) {
            return new a(i11, 0, iArr, i12, i13, i14, -1, ImmutableList.of());
        }
    }

    public b(int i11, h4.c cVar, g4.b bVar, int i12, androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, @Nullable o oVar, @Nullable androidx.media3.exoplayer.upstream.f fVar, androidx.media3.exoplayer.drm.c cVar2, androidx.media3.exoplayer.drm.b.a aVar, m mVar, androidx.media3.exoplayer.source.m.a aVar2, long j11, n nVar, androidx.media3.exoplayer.upstream.b bVar2, p4.d dVar, d.b bVar3, x3 x3Var) {
        this.f10131a = i11;
        this.f10152w = cVar;
        this.f10136g = bVar;
        this.f10153x = i12;
        this.f10132b = interfaceC0095a;
        this.f10133c = oVar;
        this.f10134d = cVar2;
        this.f10146q = aVar;
        this.f10135f = mVar;
        this.f10145p = aVar2;
        this.f10137h = j11;
        this.f10138i = nVar;
        this.f10139j = bVar2;
        this.f10142m = dVar;
        this.f10147r = x3Var;
        this.f10143n = new d(cVar, bVar3, bVar2);
        this.f10151v = dVar.b();
        g gVarC = cVar.c(i12);
        List<f> list = gVarC.f66290d;
        this.f10154y = list;
        Pair<k0, a[]> pairM = m(cVar2, interfaceC0095a, gVarC.f66289c, list);
        this.f10140k = (k0) pairM.first;
        this.f10141l = (a[]) pairM.second;
    }

    public static y[] A(e eVar, Pattern pattern, y yVar) {
        String str = eVar.f66280b;
        if (str == null) {
            return new y[]{yVar};
        }
        String[] strArrO1 = u0.o1(str, ";");
        y[] yVarArr = new y[strArrO1.length];
        for (int i11 = 0; i11 < strArrO1.length; i11++) {
            Matcher matcher = pattern.matcher(strArrO1[i11]);
            if (!matcher.matches()) {
                return new y[]{yVar};
            }
            int i12 = Integer.parseInt(matcher.group(1));
            yVarArr[i11] = yVar.b().X(yVar.f9489a + ":" + i12).J(i12).b0(matcher.group(2)).I();
        }
        return yVarArr;
    }

    public static void j(List<f> list, n0[] n0VarArr, a[] aVarArr, int i11) {
        int i12 = 0;
        while (i12 < list.size()) {
            f fVar = list.get(i12);
            n0VarArr[i11] = new n0(fVar.a() + ":" + i12, new y.b().X(fVar.a()).k0(MimeTypes.APPLICATION_EMSG).I());
            aVarArr[i11] = a.c(i12);
            i12++;
            i11++;
        }
    }

    public static int k(androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, List<h4.a> list, int[][] iArr, int i11, boolean[] zArr, y[][] yVarArr, n0[] n0VarArr, a[] aVarArr) {
        int i12;
        int i13;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            int[] iArr2 = iArr[i14];
            ArrayList arrayList = new ArrayList();
            for (int i16 : iArr2) {
                arrayList.addAll(list.get(i16).f66244c);
            }
            int size = arrayList.size();
            y[] yVarArr2 = new y[size];
            for (int i17 = 0; i17 < size; i17++) {
                y yVar = ((j) arrayList.get(i17)).f66302b;
                yVarArr2[i17] = yVar.b().P(cVar.c(yVar)).I();
            }
            h4.a aVar = list.get(iArr2[0]);
            long j11 = aVar.f66242a;
            String string = j11 != -1 ? Long.toString(j11) : "unset:" + i14;
            int i18 = i15 + 1;
            if (zArr[i14]) {
                i12 = i15 + 2;
            } else {
                i12 = i18;
                i18 = -1;
            }
            if (yVarArr[i14].length != 0) {
                i13 = i12 + 1;
            } else {
                i13 = i12;
                i12 = -1;
            }
            x(interfaceC0095a, yVarArr2);
            n0VarArr[i15] = new n0(string, yVarArr2);
            aVarArr[i15] = a.d(aVar.f66243b, iArr2, i15, i18, i12);
            if (i18 != -1) {
                String str = string + ":emsg";
                n0VarArr[i18] = new n0(str, new y.b().X(str).k0(MimeTypes.APPLICATION_EMSG).I());
                aVarArr[i18] = a.b(iArr2, i15);
            }
            if (i12 != -1) {
                aVarArr[i12] = a.a(iArr2, i15, ImmutableList.copyOf(yVarArr[i14]));
                x(interfaceC0095a, yVarArr[i14]);
                n0VarArr[i12] = new n0(string + ":cc", yVarArr[i14]);
            }
            i14++;
            i15 = i13;
        }
        return i15;
    }

    public static Pair<k0, a[]> m(androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, List<h4.a> list, List<f> list2) {
        int[][] iArrR = r(list);
        int length = iArrR.length;
        boolean[] zArr = new boolean[length];
        y[][] yVarArr = new y[length][];
        int iV = v(length, list, iArrR, zArr, yVarArr) + length + list2.size();
        n0[] n0VarArr = new n0[iV];
        a[] aVarArr = new a[iV];
        j(list2, n0VarArr, aVarArr, k(cVar, interfaceC0095a, list, iArrR, length, zArr, yVarArr, n0VarArr, aVarArr));
        return Pair.create(new k0(n0VarArr), aVarArr);
    }

    @Nullable
    public static e n(List<e> list) {
        return o(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    public static e o(List<e> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (str.equals(eVar.f66279a)) {
                return eVar;
            }
        }
        return null;
    }

    @Nullable
    public static e p(List<e> list) {
        return o(list, "http://dashif.org/guidelines/trickmode");
    }

    public static y[] q(List<h4.a> list, int[] iArr) {
        for (int i11 : iArr) {
            h4.a aVar = list.get(i11);
            List<e> list2 = list.get(i11).f66245d;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                e eVar = list2.get(i12);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f66279a)) {
                    return A(eVar, f10130z, new y.b().k0(MimeTypes.APPLICATION_CEA608).X(aVar.f66242a + ":cea608").I());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f66279a)) {
                    return A(eVar, A, new y.b().k0(MimeTypes.APPLICATION_CEA708).X(aVar.f66242a + ":cea708").I());
                }
            }
        }
        return new y[0];
    }

    public static int[][] r(List<h4.a> list) {
        e eVarN;
        Integer num;
        int size = list.size();
        HashMap mapP = Maps.p(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i11 = 0; i11 < size; i11++) {
            mapP.put(Long.valueOf(list.get(i11).f66242a), Integer.valueOf(i11));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i11));
            arrayList.add(arrayList2);
            sparseArray.put(i11, arrayList2);
        }
        for (int i12 = 0; i12 < size; i12++) {
            h4.a aVar = list.get(i12);
            e eVarP = p(aVar.f66246e);
            if (eVarP == null) {
                eVarP = p(aVar.f66247f);
            }
            int iIntValue = (eVarP == null || (num = (Integer) mapP.get(Long.valueOf(Long.parseLong(eVarP.f66280b)))) == null) ? i12 : num.intValue();
            if (iIntValue == i12 && (eVarN = n(aVar.f66247f)) != null) {
                for (String str : u0.o1(eVarN.f66280b, ",")) {
                    Integer num2 = (Integer) mapP.get(Long.valueOf(Long.parseLong(str)));
                    if (num2 != null) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                }
            }
            if (iIntValue != i12) {
                List list2 = (List) sparseArray.get(i12);
                List list3 = (List) sparseArray.get(iIntValue);
                list3.addAll(list2);
                sparseArray.put(i12, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i13 = 0; i13 < size2; i13++) {
            int[] iArrM = Ints.m((Collection) arrayList.get(i13));
            iArr[i13] = iArrM;
            Arrays.sort(iArrM);
        }
        return iArr;
    }

    public static boolean u(List<h4.a> list, int[] iArr) {
        for (int i11 : iArr) {
            List<j> list2 = list.get(i11).f66244c;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (!list2.get(i12).f66305e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int v(int i11, List<h4.a> list, int[][] iArr, boolean[] zArr, y[][] yVarArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (u(list, iArr[i13])) {
                zArr[i13] = true;
                i12++;
            }
            y[] yVarArrQ = q(list, iArr[i13]);
            yVarArr[i13] = yVarArrQ;
            if (yVarArrQ.length != 0) {
                i12++;
            }
        }
        return i12;
    }

    public static /* synthetic */ List w(h hVar) {
        return ImmutableList.of(Integer.valueOf(hVar.f74333a));
    }

    public static void x(androidx.media3.exoplayer.dash.a.InterfaceC0095a interfaceC0095a, y[] yVarArr) {
        for (int i11 = 0; i11 < yVarArr.length; i11++) {
            yVarArr[i11] = interfaceC0095a.c(yVarArr[i11]);
        }
    }

    public static h<androidx.media3.exoplayer.dash.a>[] y(int i11) {
        return new h[i11];
    }

    public void B() {
        this.f10143n.o();
        for (h<androidx.media3.exoplayer.dash.a> hVar : this.f10149t) {
            hVar.C(this);
        }
        this.f10148s = null;
    }

    public final void C(z[] zVarArr, boolean[] zArr, e0[] e0VarArr) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            if (zVarArr[i11] == null || !zArr[i11]) {
                e0 e0Var = e0VarArr[i11];
                if (e0Var instanceof h) {
                    ((h) e0Var).C(this);
                } else if (e0Var instanceof h.a) {
                    ((h.a) e0Var).b();
                }
                e0VarArr[i11] = null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    public final void D(z[] zVarArr, e0[] e0VarArr, int[] iArr) {
        e0 e0Var;
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            e0 e0Var2 = e0VarArr[i11];
            if ((e0Var2 instanceof l) || (e0Var2 instanceof h.a)) {
                int iS = s(i11, iArr);
                if (iS != -1) {
                    e0 e0Var3 = e0VarArr[i11];
                    if (!(e0Var3 instanceof h.a) || ((h.a) e0Var3).f74356a != e0VarArr[iS]) {
                        e0Var = e0VarArr[i11];
                        if (e0Var instanceof h.a) {
                            ((h.a) e0Var).b();
                        }
                        e0VarArr[i11] = null;
                    }
                } else if (!(e0VarArr[i11] instanceof l)) {
                    e0Var = e0VarArr[i11];
                    if (e0Var instanceof h.a) {
                        ((h.a) e0Var).b();
                    }
                    e0VarArr[i11] = null;
                }
            }
        }
    }

    public final void E(z[] zVarArr, e0[] e0VarArr, boolean[] zArr, long j11, int[] iArr) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            z zVar = zVarArr[i11];
            if (zVar != null) {
                e0 e0Var = e0VarArr[i11];
                if (e0Var == null) {
                    zArr[i11] = true;
                    a aVar = this.f10141l[iArr[i11]];
                    int i12 = aVar.f10157c;
                    if (i12 == 0) {
                        e0VarArr[i11] = l(aVar, zVar, j11);
                    } else if (i12 == 2) {
                        e0VarArr[i11] = new i(this.f10154y.get(aVar.f10158d), zVar.getTrackGroup().a(0), this.f10152w.f66255d);
                    }
                } else if (e0Var instanceof h) {
                    ((androidx.media3.exoplayer.dash.a) ((h) e0Var).r()).g(zVar);
                }
            }
        }
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            if (e0VarArr[i13] == null && zVarArr[i13] != null) {
                a aVar2 = this.f10141l[iArr[i13]];
                if (aVar2.f10157c == 1) {
                    int iS = s(i13, iArr);
                    if (iS == -1) {
                        e0VarArr[i13] = new l();
                    } else {
                        e0VarArr[i13] = ((h) e0VarArr[iS]).F(j11, aVar2.f10156b);
                    }
                }
            }
        }
    }

    public void F(h4.c cVar, int i11) {
        this.f10152w = cVar;
        this.f10153x = i11;
        this.f10143n.q(cVar);
        h<androidx.media3.exoplayer.dash.a>[] hVarArr = this.f10149t;
        if (hVarArr != null) {
            for (h<androidx.media3.exoplayer.dash.a> hVar : hVarArr) {
                ((androidx.media3.exoplayer.dash.a) hVar.r()).a(cVar, i11);
            }
            this.f10148s.h(this);
        }
        this.f10154y = cVar.c(i11).f66290d;
        for (i iVar : this.f10150u) {
            for (f fVar : this.f10154y) {
                if (fVar.a().equals(iVar.a())) {
                    iVar.d(fVar, cVar.f66255d && i11 == cVar.d() - 1);
                    break;
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        return this.f10151v.a(w1Var);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        for (h<androidx.media3.exoplayer.dash.a> hVar : this.f10149t) {
            if (hVar.f74333a == 2) {
                return hVar.b(j11, b3Var);
            }
        }
        return j11;
    }

    @Override // q4.h.b
    public synchronized void c(h<androidx.media3.exoplayer.dash.a> hVar) {
        d.c cVarRemove = this.f10144o.remove(hVar);
        if (cVarRemove != null) {
            cVarRemove.n();
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        for (h<androidx.media3.exoplayer.dash.a> hVar : this.f10149t) {
            hVar.discardBuffer(j11, z11);
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        int[] iArrT = t(zVarArr);
        C(zVarArr, zArr, e0VarArr);
        D(zVarArr, e0VarArr, iArrT);
        E(zVarArr, e0VarArr, zArr2, j11, iArrT);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (e0 e0Var : e0VarArr) {
            if (e0Var instanceof h) {
                arrayList.add((h) e0Var);
            } else if (e0Var instanceof i) {
                arrayList2.add((i) e0Var);
            }
        }
        h<androidx.media3.exoplayer.dash.a>[] hVarArrY = y(arrayList.size());
        this.f10149t = hVarArrY;
        arrayList.toArray(hVarArrY);
        i[] iVarArr = new i[arrayList2.size()];
        this.f10150u = iVarArr;
        arrayList2.toArray(iVarArr);
        this.f10151v = this.f10142m.a(arrayList, Lists.o(arrayList, new com.google.common.base.f() { // from class: g4.c
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return androidx.media3.exoplayer.dash.b.w((q4.h) obj);
            }
        }));
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f10148s = aVar;
        aVar.f(this);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return this.f10151v.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return this.f10151v.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return this.f10140k;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f10151v.isLoading();
    }

    public final h<androidx.media3.exoplayer.dash.a> l(a aVar, z zVar, long j11) {
        n0 n0VarB;
        int i11;
        int i12;
        int i13 = aVar.f10160f;
        boolean z11 = i13 != -1;
        d.c cVarK = null;
        if (z11) {
            n0VarB = this.f10140k.b(i13);
            i11 = 1;
        } else {
            n0VarB = null;
            i11 = 0;
        }
        int i14 = aVar.f10161g;
        ImmutableList<y> immutableListOf = i14 != -1 ? this.f10141l[i14].f10162h : ImmutableList.of();
        int size = i11 + immutableListOf.size();
        y[] yVarArr = new y[size];
        int[] iArr = new int[size];
        if (z11) {
            yVarArr[0] = n0VarB.a(0);
            iArr[0] = 5;
            i12 = 1;
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i15 = 0; i15 < immutableListOf.size(); i15++) {
            y yVar = immutableListOf.get(i15);
            yVarArr[i12] = yVar;
            iArr[i12] = 3;
            arrayList.add(yVar);
            i12++;
        }
        if (this.f10152w.f66255d && z11) {
            cVarK = this.f10143n.k();
        }
        d.c cVar = cVarK;
        h<androidx.media3.exoplayer.dash.a> hVar = new h<>(aVar.f10156b, iArr, yVarArr, this.f10132b.d(this.f10138i, this.f10152w, this.f10136g, this.f10153x, aVar.f10155a, zVar, aVar.f10156b, this.f10137h, z11, arrayList, cVar, this.f10133c, this.f10147r, null), this, this.f10139j, j11, this.f10134d, this.f10146q, this.f10135f, this.f10145p);
        synchronized (this) {
            this.f10144o.put(hVar, cVar);
        }
        return hVar;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        this.f10138i.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        this.f10151v.reevaluateBuffer(j11);
    }

    public final int s(int i11, int[] iArr) {
        int i12 = iArr[i11];
        if (i12 == -1) {
            return -1;
        }
        int i13 = this.f10141l[i12].f10159e;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 == i13 && this.f10141l[i15].f10157c == 0) {
                return i14;
            }
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        for (h<androidx.media3.exoplayer.dash.a> hVar : this.f10149t) {
            hVar.E(j11);
        }
        for (i iVar : this.f10150u) {
            iVar.b(j11);
        }
        return j11;
    }

    public final int[] t(z[] zVarArr) {
        int[] iArr = new int[zVarArr.length];
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            z zVar = zVarArr[i11];
            if (zVar != null) {
                iArr[i11] = this.f10140k.d(zVar.getTrackGroup());
            } else {
                iArr[i11] = -1;
            }
        }
        return iArr;
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void h(h<androidx.media3.exoplayer.dash.a> hVar) {
        this.f10148s.h(this);
    }
}

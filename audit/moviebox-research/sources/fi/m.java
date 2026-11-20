package fi;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.x2;
import com.google.android.exoplayer2.z2;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import f4.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import nh.i0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m extends u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Ordering<Integer> f64975k = Ordering.from(new Comparator() { // from class: fi.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m.P((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Ordering<Integer> f64976l = Ordering.from(new Comparator() { // from class: fi.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m.Q((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f64977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Context f64978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s.b f64979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f64980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f64981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public f f64982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.google.android.exoplayer2.audio.e f64983j;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends h<b> implements Comparable<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f64984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f64985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final String f64986h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final d f64987i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f64988j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f64989k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f64990l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f64991m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f64992n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f64993o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f64994p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f64995q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f64996r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f64997s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f64998t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f64999u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f65000v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f65001w;

        public b(int i11, i0 i0Var, int i12, d dVar, int i13, boolean z11, com.google.common.base.n<m1> nVar) {
            int i14;
            int iD;
            int iD2;
            super(i11, i0Var, i12);
            this.f64987i = dVar;
            this.f64986h = m.T(this.f65026d.f33436c);
            this.f64988j = m.L(i13, false);
            int i15 = 0;
            while (true) {
                int size = dVar.f65070o.size();
                i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i15 >= size) {
                    i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iD = 0;
                    break;
                } else {
                    iD = m.D(this.f65026d, dVar.f65070o.get(i15), false);
                    if (iD > 0) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f64990l = i15;
            this.f64989k = iD;
            this.f64991m = m.H(this.f65026d.f33438f, dVar.f65071p);
            m1 m1Var = this.f65026d;
            int i16 = m1Var.f33438f;
            this.f64992n = i16 == 0 || (i16 & 1) != 0;
            this.f64995q = (m1Var.f33437d & 1) != 0;
            int i17 = m1Var.f33458z;
            this.f64996r = i17;
            this.f64997s = m1Var.A;
            int i18 = m1Var.f33441i;
            this.f64998t = i18;
            this.f64985g = (i18 == -1 || i18 <= dVar.f65073r) && (i17 == -1 || i17 <= dVar.f65072q) && nVar.apply(m1Var);
            String[] strArrI0 = o0.i0();
            int i19 = 0;
            while (true) {
                if (i19 >= strArrI0.length) {
                    i19 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iD2 = 0;
                    break;
                } else {
                    iD2 = m.D(this.f65026d, strArrI0[i19], false);
                    if (iD2 > 0) {
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            this.f64993o = i19;
            this.f64994p = iD2;
            for (int i21 = 0; i21 < dVar.f65074s.size(); i21++) {
                String str = this.f65026d.f33445m;
                if (str != null && str.equals(dVar.f65074s.get(i21))) {
                    i14 = i21;
                    break;
                }
            }
            this.f64999u = i14;
            this.f65000v = x2.e(i13) == 128;
            this.f65001w = x2.g(i13) == 64;
            this.f64984f = h(i13, z11);
        }

        public static int c(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList<b> e(int i11, i0 i0Var, d dVar, int[] iArr, boolean z11, com.google.common.base.n<m1> nVar) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i12 = 0; i12 < i0Var.f71931a; i12++) {
                aVarBuilder.a(new b(i11, i0Var, i12, dVar, iArr[i12], z11, nVar));
            }
            return aVarBuilder.m();
        }

        @Override // fi.m.h
        public int a() {
            return this.f64984f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering orderingReverse = (this.f64985g && this.f64988j) ? m.f64975k : m.f64975k.reverse();
            com.google.common.collect.o oVarG = com.google.common.collect.o.k().h(this.f64988j, bVar.f64988j).g(Integer.valueOf(this.f64990l), Integer.valueOf(bVar.f64990l), Ordering.natural().reverse()).d(this.f64989k, bVar.f64989k).d(this.f64991m, bVar.f64991m).h(this.f64995q, bVar.f64995q).h(this.f64992n, bVar.f64992n).g(Integer.valueOf(this.f64993o), Integer.valueOf(bVar.f64993o), Ordering.natural().reverse()).d(this.f64994p, bVar.f64994p).h(this.f64985g, bVar.f64985g).g(Integer.valueOf(this.f64999u), Integer.valueOf(bVar.f64999u), Ordering.natural().reverse()).g(Integer.valueOf(this.f64998t), Integer.valueOf(bVar.f64998t), this.f64987i.f65079x ? m.f64975k.reverse() : m.f64976l).h(this.f65000v, bVar.f65000v).h(this.f65001w, bVar.f65001w).g(Integer.valueOf(this.f64996r), Integer.valueOf(bVar.f64996r), orderingReverse).g(Integer.valueOf(this.f64997s), Integer.valueOf(bVar.f64997s), orderingReverse);
            Integer numValueOf = Integer.valueOf(this.f64998t);
            Integer numValueOf2 = Integer.valueOf(bVar.f64998t);
            if (!o0.c(this.f64986h, bVar.f64986h)) {
                orderingReverse = m.f64976l;
            }
            return oVarG.g(numValueOf, numValueOf2, orderingReverse).j();
        }

        public final int h(int i11, boolean z11) {
            if (!m.L(i11, this.f64987i.O)) {
                return 0;
            }
            if (!this.f64985g && !this.f64987i.I) {
                return 0;
            }
            if (m.L(i11, false) && this.f64985g && this.f65026d.f33441i != -1) {
                d dVar = this.f64987i;
                if (!dVar.f65080y && !dVar.f65079x && (dVar.Q || !z11)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // fi.m.h
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i11;
            String str;
            int i12;
            d dVar = this.f64987i;
            if ((dVar.L || ((i12 = this.f65026d.f33458z) != -1 && i12 == bVar.f65026d.f33458z)) && (dVar.J || ((str = this.f65026d.f33445m) != null && TextUtils.equals(str, bVar.f65026d.f33445m)))) {
                d dVar2 = this.f64987i;
                if ((dVar2.K || ((i11 = this.f65026d.A) != -1 && i11 == bVar.f65026d.A)) && (dVar2.M || (this.f65000v == bVar.f65000v && this.f65001w == bVar.f65001w))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f65002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65003b;

        public c(m1 m1Var, int i11) {
            this.f65002a = (m1Var.f33437d & 1) != 0;
            this.f65003b = m.L(i11, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return com.google.common.collect.o.k().h(this.f65003b, cVar.f65003b).h(this.f65002a, cVar.f65002a).j();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends z {
        public static final d T;

        @Deprecated
        public static final d U;
        public static final com.google.android.exoplayer2.g.a<d> V;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        public final boolean P;
        public final boolean Q;
        public final SparseArray<Map<k0, e>> R;
        public final SparseBooleanArray S;

        /* JADX INFO: compiled from: source.java */
        public static final class a extends z.a {
            public boolean A;
            public boolean B;
            public boolean C;
            public boolean D;
            public boolean E;
            public boolean F;
            public boolean G;
            public boolean H;
            public boolean I;
            public boolean J;
            public boolean K;
            public boolean L;
            public boolean M;
            public final SparseArray<Map<k0, e>> N;
            public final SparseBooleanArray O;

            @Deprecated
            public a() {
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            public a(Bundle bundle) {
                super(bundle);
                e0();
                d dVar = d.T;
                s0(bundle.getBoolean(z.c(1000), dVar.E));
                n0(bundle.getBoolean(z.c(1001), dVar.F));
                o0(bundle.getBoolean(z.c(1002), dVar.G));
                m0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW), dVar.H));
                q0(bundle.getBoolean(z.c(1003), dVar.I));
                j0(bundle.getBoolean(z.c(1004), dVar.J));
                k0(bundle.getBoolean(z.c(1005), dVar.K));
                h0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_CELL), dVar.L));
                i0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), dVar.M));
                p0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), dVar.N));
                r0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_CROSSHAIR), dVar.O));
                z0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_TEXT), dVar.P));
                l0(bundle.getBoolean(z.c(PointerIconCompat.TYPE_VERTICAL_TEXT), dVar.Q));
                this.N = new SparseArray<>();
                x0(bundle);
                this.O = f0(bundle.getIntArray(z.c(PointerIconCompat.TYPE_ALL_SCROLL)));
            }

            public a(d dVar) {
                super(dVar);
                this.A = dVar.E;
                this.B = dVar.F;
                this.C = dVar.G;
                this.D = dVar.H;
                this.E = dVar.I;
                this.F = dVar.J;
                this.G = dVar.K;
                this.H = dVar.L;
                this.I = dVar.M;
                this.J = dVar.N;
                this.K = dVar.O;
                this.L = dVar.P;
                this.M = dVar.Q;
                this.N = d0(dVar.R);
                this.O = dVar.S.clone();
            }

            public static SparseArray<Map<k0, e>> d0(SparseArray<Map<k0, e>> sparseArray) {
                SparseArray<Map<k0, e>> sparseArray2 = new SparseArray<>();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    sparseArray2.put(sparseArray.keyAt(i11), new HashMap(sparseArray.valueAt(i11)));
                }
                return sparseArray2;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a K(int i11, int i12, boolean z11) {
                super.K(i11, i12, z11);
                return this;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
            public a L(Context context, boolean z11) {
                super.L(context, z11);
                return this;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
            public a B(int i11) {
                super.B(i11);
                return this;
            }

            public final void e0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            public final SparseBooleanArray f0(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i11 : iArr) {
                    sparseBooleanArray.append(i11, true);
                }
                return sparseBooleanArray;
            }

            public a g0(z zVar) {
                super.E(zVar);
                return this;
            }

            public a h0(boolean z11) {
                this.H = z11;
                return this;
            }

            public a i0(boolean z11) {
                this.I = z11;
                return this;
            }

            public a j0(boolean z11) {
                this.F = z11;
                return this;
            }

            public a k0(boolean z11) {
                this.G = z11;
                return this;
            }

            public a l0(boolean z11) {
                this.M = z11;
                return this;
            }

            public a m0(boolean z11) {
                this.D = z11;
                return this;
            }

            public a n0(boolean z11) {
                this.B = z11;
                return this;
            }

            public a o0(boolean z11) {
                this.C = z11;
                return this;
            }

            public a p0(boolean z11) {
                this.J = z11;
                return this;
            }

            public a q0(boolean z11) {
                this.E = z11;
                return this;
            }

            public a r0(boolean z11) {
                this.K = z11;
                return this;
            }

            public a s0(boolean z11) {
                this.A = z11;
                return this;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
            public a F(int i11) {
                super.F(i11);
                return this;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a G(x xVar) {
                super.G(xVar);
                return this;
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            @Deprecated
            public a w0(int i11, k0 k0Var, @Nullable e eVar) {
                Map<k0, e> map = this.N.get(i11);
                if (map == null) {
                    map = new HashMap<>();
                    this.N.put(i11, map);
                }
                if (map.containsKey(k0Var) && o0.c(map.get(k0Var), eVar)) {
                    return this;
                }
                map.put(k0Var, eVar);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void x0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(z.c(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(1011));
                ImmutableList immutableListOf = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(k0.f71940f, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(z.c(1012));
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : com.google.android.exoplayer2.util.d.c(e.f65004f, sparseParcelableArray);
                if (intArray == null || intArray.length != immutableListOf.size()) {
                    return;
                }
                for (int i11 = 0; i11 < intArray.length; i11++) {
                    w0(intArray[i11], (k0) immutableListOf.get(i11), (e) sparseArray.get(i11));
                }
            }

            @Override // fi.z.a
            /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
            public a J(int i11, boolean z11) {
                super.J(i11, z11);
                return this;
            }

            public a z0(boolean z11) {
                this.L = z11;
                return this;
            }
        }

        static {
            d dVarA = new a().A();
            T = dVarA;
            U = dVarA;
            V = new com.google.android.exoplayer2.g.a() { // from class: fi.n
                @Override // com.google.android.exoplayer2.g.a
                public final com.google.android.exoplayer2.g a(Bundle bundle) {
                    return m.d.p(bundle);
                }
            };
        }

        public d(a aVar) {
            super(aVar);
            this.E = aVar.A;
            this.F = aVar.B;
            this.G = aVar.C;
            this.H = aVar.D;
            this.I = aVar.E;
            this.J = aVar.F;
            this.K = aVar.G;
            this.L = aVar.H;
            this.M = aVar.I;
            this.N = aVar.J;
            this.O = aVar.K;
            this.P = aVar.L;
            this.Q = aVar.M;
            this.R = aVar.N;
            this.S = aVar.O;
        }

        public static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i11)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean h(SparseArray<Map<k0, e>> sparseArray, SparseArray<Map<k0, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (iIndexOfKey < 0 || !i(sparseArray.valueAt(i11), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean i(Map<k0, e> map, Map<k0, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<k0, e> entry : map.entrySet()) {
                k0 key = entry.getKey();
                if (!map2.containsKey(key) || !o0.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static d k(Context context) {
            return new a(context).A();
        }

        public static int[] l(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i11 = 0; i11 < sparseBooleanArray.size(); i11++) {
                iArr[i11] = sparseBooleanArray.keyAt(i11);
            }
            return iArr;
        }

        public static /* synthetic */ d p(Bundle bundle) {
            return new a(bundle).A();
        }

        public static void q(Bundle bundle, SparseArray<Map<k0, e>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                int iKeyAt = sparseArray.keyAt(i11);
                for (Map.Entry<k0, e> entry : sparseArray.valueAt(i11).entrySet()) {
                    e value = entry.getValue();
                    if (value != null) {
                        sparseArray2.put(arrayList2.size(), value);
                    }
                    arrayList2.add(entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(z.c(1010), Ints.m(arrayList));
                bundle.putParcelableArrayList(z.c(1011), com.google.android.exoplayer2.util.d.d(arrayList2));
                bundle.putSparseParcelableArray(z.c(1012), com.google.android.exoplayer2.util.d.e(sparseArray2));
            }
        }

        @Override // fi.z
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.O == dVar.O && this.P == dVar.P && this.Q == dVar.Q && g(this.S, dVar.S) && h(this.R, dVar.R);
        }

        @Override // fi.z
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0)) * 31) + (this.Q ? 1 : 0);
        }

        @Override // fi.z
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean m(int i11) {
            return this.S.get(i11);
        }

        @Nullable
        @Deprecated
        public e n(int i11, k0 k0Var) {
            Map<k0, e> map = this.R.get(i11);
            if (map != null) {
                return map.get(k0Var);
            }
            return null;
        }

        @Deprecated
        public boolean o(int i11, k0 k0Var) {
            Map<k0, e> map = this.R.get(i11);
            return map != null && map.containsKey(k0Var);
        }

        @Override // fi.z, com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(z.c(1000), this.E);
            bundle.putBoolean(z.c(1001), this.F);
            bundle.putBoolean(z.c(1002), this.G);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW), this.H);
            bundle.putBoolean(z.c(1003), this.I);
            bundle.putBoolean(z.c(1004), this.J);
            bundle.putBoolean(z.c(1005), this.K);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_CELL), this.L);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), this.M);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), this.N);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_CROSSHAIR), this.O);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_TEXT), this.P);
            bundle.putBoolean(z.c(PointerIconCompat.TYPE_VERTICAL_TEXT), this.Q);
            q(bundle, this.R);
            bundle.putIntArray(z.c(PointerIconCompat.TYPE_ALL_SCROLL), l(this.S));
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements com.google.android.exoplayer2.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g.a<e> f65004f = new com.google.android.exoplayer2.g.a() { // from class: fi.o
            @Override // com.google.android.exoplayer2.g.a
            public final com.google.android.exoplayer2.g a(Bundle bundle) {
                return m.e.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f65006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f65008d;

        public e(int i11, int[] iArr, int i12) {
            this.f65005a = i11;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f65006b = iArrCopyOf;
            this.f65007c = iArr.length;
            this.f65008d = i12;
            Arrays.sort(iArrCopyOf);
        }

        private static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        public static /* synthetic */ e c(Bundle bundle) {
            boolean z11 = false;
            int i11 = bundle.getInt(b(0), -1);
            int[] intArray = bundle.getIntArray(b(1));
            int i12 = bundle.getInt(b(2), -1);
            if (i11 >= 0 && i12 >= 0) {
                z11 = true;
            }
            com.google.android.exoplayer2.util.a.a(z11);
            com.google.android.exoplayer2.util.a.e(intArray);
            return new e(i11, intArray, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f65005a == eVar.f65005a && Arrays.equals(this.f65006b, eVar.f65006b) && this.f65008d == eVar.f65008d;
        }

        public int hashCode() {
            return (((this.f65005a * 31) + Arrays.hashCode(this.f65006b)) * 31) + this.f65008d;
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(b(0), this.f65005a);
            bundle.putIntArray(b(1), this.f65006b);
            bundle.putInt(b(2), this.f65008d);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(32)
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Spatializer f65009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Handler f65011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Spatializer.OnSpatializerStateChangedListener f65012d;

        /* JADX INFO: compiled from: source.java */
        public class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f65013a;

            public a(f fVar, m mVar) {
                this.f65013a = mVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z11) {
                this.f65013a.S();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z11) {
                this.f65013a.S();
            }
        }

        public f(Spatializer spatializer) {
            this.f65009a = spatializer;
            this.f65010b = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                return null;
            }
            return new f(audioManager.getSpatializer());
        }

        public boolean a(com.google.android.exoplayer2.audio.e eVar, m1 m1Var) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(o0.G((MimeTypes.AUDIO_E_AC3_JOC.equals(m1Var.f33445m) && m1Var.f33458z == 16) ? 12 : m1Var.f33458z));
            int i11 = m1Var.A;
            if (i11 != -1) {
                channelMask.setSampleRate(i11);
            }
            return this.f65009a.canBeSpatialized(eVar.b().f32814a, channelMask.build());
        }

        public void b(m mVar, Looper looper) {
            if (this.f65012d == null && this.f65011c == null) {
                this.f65012d = new a(this, mVar);
                Handler handler = new Handler(looper);
                this.f65011c = handler;
                Spatializer spatializer = this.f65009a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new n1(handler), this.f65012d);
            }
        }

        public boolean c() {
            return this.f65009a.isAvailable();
        }

        public boolean d() {
            return this.f65009a.isEnabled();
        }

        public boolean e() {
            return this.f65010b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f65012d;
            if (onSpatializerStateChangedListener == null || this.f65011c == null) {
                return;
            }
            this.f65009a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) o0.j(this.f65011c)).removeCallbacksAndMessages(null);
            this.f65011c = null;
            this.f65012d = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends h<g> implements Comparable<g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f65014f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f65015g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f65016h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f65017i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f65018j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f65019k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f65020l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f65021m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f65022n;

        public g(int i11, i0 i0Var, int i12, d dVar, int i13, @Nullable String str) {
            int iD;
            super(i11, i0Var, i12);
            int i14 = 0;
            this.f65015g = m.L(i13, false);
            int i15 = this.f65026d.f33437d & (~dVar.f65077v);
            this.f65016h = (i15 & 1) != 0;
            this.f65017i = (i15 & 2) != 0;
            ImmutableList<String> immutableListOf = dVar.f65075t.isEmpty() ? ImmutableList.of("") : dVar.f65075t;
            int i16 = 0;
            while (true) {
                if (i16 >= immutableListOf.size()) {
                    i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iD = 0;
                    break;
                } else {
                    iD = m.D(this.f65026d, immutableListOf.get(i16), dVar.f65078w);
                    if (iD > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            this.f65018j = i16;
            this.f65019k = iD;
            int iH = m.H(this.f65026d.f33438f, dVar.f65076u);
            this.f65020l = iH;
            this.f65022n = (this.f65026d.f33438f & 1088) != 0;
            int iD2 = m.D(this.f65026d, str, m.T(str) == null);
            this.f65021m = iD2;
            boolean z11 = iD > 0 || (dVar.f65075t.isEmpty() && iH > 0) || this.f65016h || (this.f65017i && iD2 > 0);
            if (m.L(i13, dVar.O) && z11) {
                i14 = 1;
            }
            this.f65014f = i14;
        }

        public static int c(List<g> list, List<g> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<g> e(int i11, i0 i0Var, d dVar, int[] iArr, @Nullable String str) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i12 = 0; i12 < i0Var.f71931a; i12++) {
                aVarBuilder.a(new g(i11, i0Var, i12, dVar, iArr[i12], str));
            }
            return aVarBuilder.m();
        }

        @Override // fi.m.h
        public int a() {
            return this.f65014f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            com.google.common.collect.o oVarD = com.google.common.collect.o.k().h(this.f65015g, gVar.f65015g).g(Integer.valueOf(this.f65018j), Integer.valueOf(gVar.f65018j), Ordering.natural().reverse()).d(this.f65019k, gVar.f65019k).d(this.f65020l, gVar.f65020l).h(this.f65016h, gVar.f65016h).g(Boolean.valueOf(this.f65017i), Boolean.valueOf(gVar.f65017i), this.f65019k == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.f65021m, gVar.f65021m);
            if (this.f65020l == 0) {
                oVarD = oVarD.i(this.f65022n, gVar.f65022n);
            }
            return oVarD.j();
        }

        @Override // fi.m.h
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class h<T extends h<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0 f65024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final m1 f65026d;

        /* JADX INFO: compiled from: source.java */
        public interface a<T extends h<T>> {
            List<T> a(int i11, i0 i0Var, int[] iArr);
        }

        public h(int i11, i0 i0Var, int i12) {
            this.f65023a = i11;
            this.f65024b = i0Var;
            this.f65025c = i12;
            this.f65026d = i0Var.c(i12);
        }

        public abstract int a();

        public abstract boolean b(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i extends h<i> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f65027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final d f65028g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f65029h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f65030i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f65031j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f65032k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f65033l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f65034m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f65035n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f65036o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f65037p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f65038q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f65039r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f65040s;

        /* JADX WARN: Code duplicated, block: B:31:0x004b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0079  */
        public i(int i11, i0 i0Var, int i12, d dVar, int i13, int i14, boolean z11) {
            boolean z12;
            boolean z13;
            m1 m1Var;
            int i15;
            int i16;
            int i17;
            m1 m1Var2;
            int i18;
            int i19;
            int i21;
            super(i11, i0Var, i12);
            this.f65028g = dVar;
            int i22 = dVar.G ? 24 : 16;
            this.f65036o = dVar.F && (i14 & i22) != 0;
            if (!z11 || (((i18 = (m1Var2 = this.f65026d).f33450r) != -1 && i18 > dVar.f65057a) || ((i19 = m1Var2.f33451s) != -1 && i19 > dVar.f65058b))) {
                z12 = false;
            } else {
                float f11 = m1Var2.f33452t;
                if ((f11 == -1.0f || f11 <= dVar.f65059c) && ((i21 = m1Var2.f33441i) == -1 || i21 <= dVar.f65060d)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            }
            this.f65027f = z12;
            if (!z11 || (((i15 = (m1Var = this.f65026d).f33450r) != -1 && i15 < dVar.f65061f) || ((i16 = m1Var.f33451s) != -1 && i16 < dVar.f65062g))) {
                z13 = false;
            } else {
                float f12 = m1Var.f33452t;
                if ((f12 == -1.0f || f12 >= dVar.f65063h) && ((i17 = m1Var.f33441i) == -1 || i17 >= dVar.f65064i)) {
                    z13 = true;
                } else {
                    z13 = false;
                }
            }
            this.f65029h = z13;
            this.f65030i = m.L(i13, false);
            m1 m1Var3 = this.f65026d;
            this.f65031j = m1Var3.f33441i;
            this.f65032k = m1Var3.f();
            this.f65034m = m.H(this.f65026d.f33438f, dVar.f65069n);
            int i23 = this.f65026d.f33438f;
            this.f65035n = i23 == 0 || (i23 & 1) != 0;
            int i24 = 0;
            while (true) {
                if (i24 >= dVar.f65068m.size()) {
                    i24 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    break;
                }
                String str = this.f65026d.f33445m;
                if (str != null && str.equals(dVar.f65068m.get(i24))) {
                    break;
                } else {
                    i24++;
                }
            }
            this.f65033l = i24;
            this.f65038q = x2.e(i13) == 128;
            this.f65039r = x2.g(i13) == 64;
            this.f65040s = m.I(this.f65026d.f33445m);
            this.f65037p = k(i13, i22);
        }

        public static int e(i iVar, i iVar2) {
            com.google.common.collect.o oVarH = com.google.common.collect.o.k().h(iVar.f65030i, iVar2.f65030i).d(iVar.f65034m, iVar2.f65034m).h(iVar.f65035n, iVar2.f65035n).h(iVar.f65027f, iVar2.f65027f).h(iVar.f65029h, iVar2.f65029h).g(Integer.valueOf(iVar.f65033l), Integer.valueOf(iVar2.f65033l), Ordering.natural().reverse()).h(iVar.f65038q, iVar2.f65038q).h(iVar.f65039r, iVar2.f65039r);
            if (iVar.f65038q && iVar.f65039r) {
                oVarH = oVarH.d(iVar.f65040s, iVar2.f65040s);
            }
            return oVarH.j();
        }

        public static int h(i iVar, i iVar2) {
            Ordering orderingReverse = (iVar.f65027f && iVar.f65030i) ? m.f64975k : m.f64975k.reverse();
            return com.google.common.collect.o.k().g(Integer.valueOf(iVar.f65031j), Integer.valueOf(iVar2.f65031j), iVar.f65028g.f65079x ? m.f64975k.reverse() : m.f64976l).g(Integer.valueOf(iVar.f65032k), Integer.valueOf(iVar2.f65032k), orderingReverse).g(Integer.valueOf(iVar.f65031j), Integer.valueOf(iVar2.f65031j), orderingReverse).j();
        }

        public static int i(List<i> list, List<i> list2) {
            return com.google.common.collect.o.k().g((i) Collections.max(list, new Comparator() { // from class: fi.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.e((m.i) obj, (m.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: fi.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.e((m.i) obj, (m.i) obj2);
                }
            }), new Comparator() { // from class: fi.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.e((m.i) obj, (m.i) obj2);
                }
            }).d(list.size(), list2.size()).g((i) Collections.max(list, new Comparator() { // from class: fi.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.h((m.i) obj, (m.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: fi.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.h((m.i) obj, (m.i) obj2);
                }
            }), new Comparator() { // from class: fi.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return m.i.h((m.i) obj, (m.i) obj2);
                }
            }).j();
        }

        public static ImmutableList<i> j(int i11, i0 i0Var, d dVar, int[] iArr, int i12) {
            int iE = m.E(i0Var, dVar.f65065j, dVar.f65066k, dVar.f65067l);
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i13 = 0; i13 < i0Var.f71931a; i13++) {
                int iF = i0Var.c(i13).f();
                aVarBuilder.a(new i(i11, i0Var, i13, dVar, iArr[i13], i12, iE == Integer.MAX_VALUE || (iF != -1 && iF <= iE)));
            }
            return aVarBuilder.m();
        }

        @Override // fi.m.h
        public int a() {
            return this.f65037p;
        }

        public final int k(int i11, int i12) {
            if ((this.f65026d.f33438f & 16384) != 0 || !m.L(i11, this.f65028g.O)) {
                return 0;
            }
            if (!this.f65027f && !this.f65028g.E) {
                return 0;
            }
            if (m.L(i11, false) && this.f65029h && this.f65027f && this.f65026d.f33441i != -1) {
                d dVar = this.f65028g;
                if (!dVar.f65080y && !dVar.f65079x && (i11 & i12) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // fi.m.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.f65036o || o0.c(this.f65026d.f33445m, iVar.f65026d.f33445m)) && (this.f65028g.H || (this.f65038q == iVar.f65038q && this.f65039r == iVar.f65039r));
        }
    }

    public m(Context context) {
        this(context, new fi.a.b());
    }

    public m(Context context, s.b bVar) {
        this(context, d.k(context), bVar);
    }

    public m(Context context, z zVar, s.b bVar) {
        this(zVar, bVar, context);
    }

    public m(z zVar, s.b bVar, @Nullable Context context) {
        this.f64977d = new Object();
        this.f64978e = context != null ? context.getApplicationContext() : null;
        this.f64979f = bVar;
        if (zVar instanceof d) {
            this.f64981h = (d) zVar;
        } else {
            this.f64981h = (context == null ? d.T : d.k(context)).a().g0(zVar).A();
        }
        this.f64983j = com.google.android.exoplayer2.audio.e.f32806h;
        boolean z11 = context != null && o0.x0(context);
        this.f64980g = z11;
        if (!z11 && context != null && o0.f35608a >= 32) {
            this.f64982i = f.g(context);
        }
        if (this.f64981h.N && context == null) {
            com.google.android.exoplayer2.util.s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void A(u.a aVar, d dVar, s.a[] aVarArr) {
        int iD = aVar.d();
        for (int i11 = 0; i11 < iD; i11++) {
            k0 k0VarF = aVar.f(i11);
            if (dVar.o(i11, k0VarF)) {
                e eVarN = dVar.n(i11, k0VarF);
                aVarArr[i11] = (eVarN == null || eVarN.f65006b.length == 0) ? null : new s.a(k0VarF.b(eVarN.f65005a), eVarN.f65006b, eVarN.f65008d);
            }
        }
    }

    public static void B(u.a aVar, z zVar, s.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < iD; i11++) {
            C(aVar.f(i11), zVar, map);
        }
        C(aVar.h(), zVar, map);
        for (int i12 = 0; i12 < iD; i12++) {
            x xVar = (x) map.get(Integer.valueOf(aVar.e(i12)));
            if (xVar != null) {
                aVarArr[i12] = (xVar.f65056b.isEmpty() || aVar.f(i12).c(xVar.f65055a) == -1) ? null : new s.a(xVar.f65055a, Ints.m(xVar.f65056b));
            }
        }
    }

    public static void C(k0 k0Var, z zVar, Map<Integer, x> map) {
        x xVar;
        for (int i11 = 0; i11 < k0Var.f71941a; i11++) {
            x xVar2 = zVar.f65081z.get(k0Var.b(i11));
            if (xVar2 != null && ((xVar = map.get(Integer.valueOf(xVar2.b()))) == null || (xVar.f65056b.isEmpty() && !xVar2.f65056b.isEmpty()))) {
                map.put(Integer.valueOf(xVar2.b()), xVar2);
            }
        }
    }

    public static int D(m1 m1Var, @Nullable String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(m1Var.f33436c)) {
            return 4;
        }
        String strT = T(str);
        String strT2 = T(m1Var.f33436c);
        if (strT2 == null || strT == null) {
            return (z11 && strT2 == null) ? 1 : 0;
        }
        if (strT2.startsWith(strT) || strT.startsWith(strT2)) {
            return 3;
        }
        return o0.U0(strT2, "-")[0].equals(o0.U0(strT, "-")[0]) ? 2 : 0;
    }

    public static int E(i0 i0Var, int i11, int i12, boolean z11) {
        int i13;
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
            for (int i15 = 0; i15 < i0Var.f71931a; i15++) {
                m1 m1VarC = i0Var.c(i15);
                int i16 = m1VarC.f33450r;
                if (i16 > 0 && (i13 = m1VarC.f33451s) > 0) {
                    Point pointF = F(z11, i11, i12, i16, i13);
                    int i17 = m1VarC.f33450r;
                    int i18 = m1VarC.f33451s;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (pointF.x * 0.98f)) && i18 >= ((int) (pointF.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
        }
        return i14;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x000f  */
    public static Point F(boolean z11, int i11, int i12, int i13, int i14) {
        if (z11) {
            if ((i13 > i14) == (i11 > i12)) {
                i12 = i11;
                i11 = i12;
            }
        } else {
            i12 = i11;
            i11 = i12;
        }
        int i15 = i13 * i11;
        int i16 = i14 * i12;
        return i15 >= i16 ? new Point(i12, o0.l(i16, i13)) : new Point(o0.l(i15, i14), i11);
    }

    public static int H(int i11, int i12) {
        return (i11 == 0 || i11 != i12) ? Integer.bitCount(i11 & i12) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int I(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
            case "video/av01":
                return 4;
            case "video/hevc":
                return 3;
            case "video/avc":
                return 1;
            case "video/x-vnd.on2.vp9":
                return 2;
            default:
                return 0;
        }
    }

    public static boolean K(m1 m1Var) {
        String str = m1Var.f33445m;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/ac3":
            case "audio/ac4":
            case "audio/eac3":
                return true;
            default:
                return false;
        }
    }

    public static boolean L(int i11, boolean z11) {
        int iF = x2.f(i11);
        return iF == 4 || (z11 && iF == 3);
    }

    public static /* synthetic */ List N(d dVar, String str, int i11, i0 i0Var, int[] iArr) {
        return g.e(i11, i0Var, dVar, iArr, str);
    }

    public static /* synthetic */ List O(d dVar, int[] iArr, int i11, i0 i0Var, int[] iArr2) {
        return i.j(i11, i0Var, dVar, iArr2, iArr[i11]);
    }

    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    public static void R(u.a aVar, int[][][] iArr, z2[] z2VarArr, s[] sVarArr) {
        boolean z11;
        boolean z12 = false;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            if (i11 >= aVar.d()) {
                z11 = true;
                break;
            }
            int iE = aVar.e(i11);
            s sVar = sVarArr[i11];
            if ((iE == 1 || iE == 2) && sVar != null && U(iArr[i11], aVar.f(i11), sVar)) {
                if (iE == 1) {
                    if (i13 != -1) {
                        z11 = false;
                        break;
                    }
                    i13 = i11;
                } else {
                    if (i12 != -1) {
                        z11 = false;
                        break;
                    }
                    i12 = i11;
                }
            }
            i11++;
        }
        if (i13 != -1 && i12 != -1) {
            z12 = true;
        }
        if (z11 && z12) {
            z2 z2Var = new z2(true);
            z2VarArr[i13] = z2Var;
            z2VarArr[i12] = z2Var;
        }
    }

    @Nullable
    public static String T(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public static boolean U(int[][] iArr, k0 k0Var, s sVar) {
        if (sVar == null) {
            return false;
        }
        int iC = k0Var.c(sVar.getTrackGroup());
        for (int i11 = 0; i11 < sVar.length(); i11++) {
            if (x2.h(iArr[iC][sVar.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Override // fi.b0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public d b() {
        d dVar;
        synchronized (this.f64977d) {
            dVar = this.f64981h;
        }
        return dVar;
    }

    public final boolean J(m1 m1Var) {
        boolean z11;
        f fVar;
        f fVar2;
        synchronized (this.f64977d) {
            try {
                if (this.f64981h.N && !this.f64980g && m1Var.f33458z > 2 && (!K(m1Var) || (o0.f35608a >= 32 && (fVar2 = this.f64982i) != null && fVar2.e()))) {
                    z11 = o0.f35608a >= 32 && (fVar = this.f64982i) != null && fVar.e() && this.f64982i.c() && this.f64982i.d() && this.f64982i.a(this.f64983j, m1Var);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public final /* synthetic */ List M(d dVar, boolean z11, int i11, i0 i0Var, int[] iArr) {
        return b.e(i11, i0Var, dVar, iArr, z11, new com.google.common.base.n() { // from class: fi.l
            @Override // com.google.common.base.n
            public final boolean apply(Object obj) {
                return this.f64974a.J((m1) obj);
            }
        });
    }

    public final void S() {
        boolean z11;
        f fVar;
        synchronized (this.f64977d) {
            try {
                z11 = this.f64981h.N && !this.f64980g && o0.f35608a >= 32 && (fVar = this.f64982i) != null && fVar.e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            d();
        }
    }

    public s.a[] V(u.a aVar, int[][][] iArr, int[] iArr2, d dVar) throws ExoPlaybackException {
        String str;
        int iD = aVar.d();
        s.a[] aVarArr = new s.a[iD];
        Pair<s.a, Integer> pairA0 = a0(aVar, iArr, iArr2, dVar);
        if (pairA0 != null) {
            aVarArr[((Integer) pairA0.second).intValue()] = (s.a) pairA0.first;
        }
        Pair<s.a, Integer> pairW = W(aVar, iArr, iArr2, dVar);
        if (pairW != null) {
            aVarArr[((Integer) pairW.second).intValue()] = (s.a) pairW.first;
        }
        if (pairW == null) {
            str = null;
        } else {
            Object obj = pairW.first;
            str = ((s.a) obj).f65041a.c(((s.a) obj).f65042b[0]).f33436c;
        }
        Pair<s.a, Integer> pairY = Y(aVar, iArr, dVar, str);
        if (pairY != null) {
            aVarArr[((Integer) pairY.second).intValue()] = (s.a) pairY.first;
        }
        for (int i11 = 0; i11 < iD; i11++) {
            int iE = aVar.e(i11);
            if (iE != 2 && iE != 1 && iE != 3) {
                aVarArr[i11] = X(iE, aVar.f(i11), iArr[i11], dVar);
            }
        }
        return aVarArr;
    }

    @Nullable
    public Pair<s.a, Integer> W(u.a aVar, int[][][] iArr, int[] iArr2, final d dVar) throws ExoPlaybackException {
        final boolean z11 = false;
        for (int i11 = 0; i11 < aVar.d(); i11++) {
            if (2 == aVar.e(i11) && aVar.f(i11).f71941a > 0) {
                z11 = true;
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: fi.j
            @Override // fi.m.h.a
            public final List a(int i12, i0 i0Var, int[] iArr3) {
                return this.f64971a.M(dVar, z11, i12, i0Var, iArr3);
            }
        }, new Comparator() { // from class: fi.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.b.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public s.a X(int i11, k0 k0Var, int[][] iArr, d dVar) throws ExoPlaybackException {
        i0 i0Var = null;
        c cVar = null;
        int i12 = 0;
        for (int i13 = 0; i13 < k0Var.f71941a; i13++) {
            i0 i0VarB = k0Var.b(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < i0VarB.f71931a; i14++) {
                if (L(iArr2[i14], dVar.O)) {
                    c cVar2 = new c(i0VarB.c(i14), iArr2[i14]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        i0Var = i0VarB;
                        i12 = i14;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (i0Var == null) {
            return null;
        }
        return new s.a(i0Var, i12);
    }

    @Nullable
    public Pair<s.a, Integer> Y(u.a aVar, int[][][] iArr, final d dVar, @Nullable final String str) throws ExoPlaybackException {
        return Z(3, aVar, iArr, new h.a() { // from class: fi.d
            @Override // fi.m.h.a
            public final List a(int i11, i0 i0Var, int[] iArr2) {
                return m.N(dVar, str, i11, i0Var, iArr2);
            }
        }, new Comparator() { // from class: fi.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.g.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public final <T extends h<T>> Pair<s.a, Integer> Z(int i11, u.a aVar, int[][][] iArr, h.a<T> aVar2, Comparator<List<T>> comparator) {
        int i12;
        RandomAccess randomAccessOf;
        ArrayList arrayList = new ArrayList();
        int iD = aVar.d();
        int i13 = 0;
        while (i13 < iD) {
            if (i11 == aVar.e(i13)) {
                k0 k0VarF = aVar.f(i13);
                for (int i14 = 0; i14 < k0VarF.f71941a; i14++) {
                    i0 i0VarB = k0VarF.b(i14);
                    List<T> listA = aVar2.a(i13, i0VarB, iArr[i13][i14]);
                    boolean[] zArr = new boolean[i0VarB.f71931a];
                    int i15 = 0;
                    while (i15 < i0VarB.f71931a) {
                        T t11 = listA.get(i15);
                        int iA = t11.a();
                        if (zArr[i15] || iA == 0) {
                            i12 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessOf = ImmutableList.of(t11);
                                i12 = iD;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t11);
                                int i16 = i15 + 1;
                                while (i16 < i0VarB.f71931a) {
                                    T t12 = listA.get(i16);
                                    int i17 = iD;
                                    if (t12.a() == 2 && t11.b(t12)) {
                                        arrayList2.add(t12);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    iD = i17;
                                }
                                i12 = iD;
                                randomAccessOf = arrayList2;
                            }
                            arrayList.add(randomAccessOf);
                        }
                        i15++;
                        iD = i12;
                    }
                }
            }
            i13++;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i18 = 0; i18 < list.size(); i18++) {
            iArr2[i18] = ((h) list.get(i18)).f65025c;
        }
        h hVar = (h) list.get(0);
        return Pair.create(new s.a(hVar.f65024b, iArr2), Integer.valueOf(hVar.f65023a));
    }

    @Nullable
    public Pair<s.a, Integer> a0(u.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) throws ExoPlaybackException {
        return Z(2, aVar, iArr, new h.a() { // from class: fi.h
            @Override // fi.m.h.a
            public final List a(int i11, i0 i0Var, int[] iArr3) {
                return m.O(dVar, iArr2, i11, i0Var, iArr3);
            }
        }, new Comparator() { // from class: fi.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.i.i((List) obj, (List) obj2);
            }
        });
    }

    public final void b0(d dVar) {
        boolean z11;
        com.google.android.exoplayer2.util.a.e(dVar);
        synchronized (this.f64977d) {
            z11 = !this.f64981h.equals(dVar);
            this.f64981h = dVar;
        }
        if (z11) {
            if (dVar.N && this.f64978e == null) {
                com.google.android.exoplayer2.util.s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            d();
        }
    }

    @Override // fi.b0
    public boolean e() {
        return true;
    }

    @Override // fi.b0
    public void g() {
        f fVar;
        synchronized (this.f64977d) {
            try {
                if (o0.f35608a >= 32 && (fVar = this.f64982i) != null) {
                    fVar.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        super.g();
    }

    @Override // fi.b0
    public void i(com.google.android.exoplayer2.audio.e eVar) {
        boolean z11;
        synchronized (this.f64977d) {
            z11 = !this.f64983j.equals(eVar);
            this.f64983j = eVar;
        }
        if (z11) {
            S();
        }
    }

    @Override // fi.b0
    public void j(z zVar) {
        if (zVar instanceof d) {
            b0((d) zVar);
        }
        b0(new d.a().g0(zVar).A());
    }

    @Override // fi.u
    public final Pair<z2[], s[]> n(u.a aVar, int[][][] iArr, int[] iArr2, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var) throws ExoPlaybackException {
        d dVar;
        f fVar;
        synchronized (this.f64977d) {
            try {
                dVar = this.f64981h;
                if (dVar.N && o0.f35608a >= 32 && (fVar = this.f64982i) != null) {
                    fVar.b(this, (Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int iD = aVar.d();
        s.a[] aVarArrV = V(aVar, iArr, iArr2, dVar);
        B(aVar, dVar, aVarArrV);
        A(aVar, dVar, aVarArrV);
        for (int i11 = 0; i11 < iD; i11++) {
            int iE = aVar.e(i11);
            if (dVar.m(i11) || dVar.A.contains(Integer.valueOf(iE))) {
                aVarArrV[i11] = null;
            }
        }
        s[] sVarArrA = this.f64979f.a(aVarArrV, a(), bVar, j3Var);
        z2[] z2VarArr = new z2[iD];
        for (int i12 = 0; i12 < iD; i12++) {
            z2VarArr[i12] = (dVar.m(i12) || dVar.A.contains(Integer.valueOf(aVar.e(i12))) || (aVar.e(i12) != -2 && sVarArrA[i12] == null)) ? null : z2.f35981b;
        }
        if (dVar.P) {
            R(aVar, iArr, z2VarArr, sVarArrA);
        }
        return Pair.create(z2VarArr, sVarArrA);
    }
}

package s4;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.PointerIconCompat;
import androidx.media3.common.m0;
import androidx.media3.common.n0;
import androidx.media3.common.o0;
import androidx.media3.common.p0;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.w2;
import androidx.media3.exoplayer.x2;
import androidx.media3.exoplayer.y2;
import androidx.media3.exoplayer.z2;
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
import p4.k0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends b0 implements y2.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Ordering<Integer> f76018k = Ordering.from(new Comparator() { // from class: s4.m
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o.V((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Ordering<Integer> f76019l = Ordering.from(new Comparator() { // from class: s4.n
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o.W((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f76020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Context f76021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z.b f76022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f76023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f76024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public g f76025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.media3.common.d f76026j;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends i<b> implements Comparable<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f76027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f76028g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final String f76029h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e f76030i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f76031j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f76032k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f76033l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f76034m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f76035n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f76036o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f76037p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f76038q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f76039r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f76040s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f76041t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f76042u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f76043v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f76044w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f76045x;

        public b(int i11, n0 n0Var, int i12, e eVar, int i13, boolean z11, com.google.common.base.n<androidx.media3.common.y> nVar, int i14) {
            int i15;
            int I;
            int I2;
            super(i11, n0Var, i12);
            this.f76030i = eVar;
            int i16 = eVar.f76059t0 ? 24 : 16;
            this.f76035n = eVar.f76055p0 && (i14 & i16) != 0;
            this.f76029h = o.b0(this.f76091d.f9492d);
            this.f76031j = o.Q(i13, false);
            int i17 = 0;
            while (true) {
                int size = eVar.f9377n.size();
                i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i17 >= size) {
                    i17 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    I = 0;
                    break;
                } else {
                    I = o.I(this.f76091d, eVar.f9377n.get(i17), false);
                    if (I > 0) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            this.f76033l = i17;
            this.f76032k = I;
            this.f76034m = o.M(this.f76091d.f9494f, eVar.f9378o);
            androidx.media3.common.y yVar = this.f76091d;
            int i18 = yVar.f9494f;
            this.f76036o = i18 == 0 || (i18 & 1) != 0;
            this.f76039r = (yVar.f9493e & 1) != 0;
            int i19 = yVar.f9514z;
            this.f76040s = i19;
            this.f76041t = yVar.A;
            int i21 = yVar.f9497i;
            this.f76042u = i21;
            this.f76028g = (i21 == -1 || i21 <= eVar.f9380q) && (i19 == -1 || i19 <= eVar.f9379p) && nVar.apply(yVar);
            String[] strArrR0 = u0.r0();
            int i22 = 0;
            while (true) {
                if (i22 >= strArrR0.length) {
                    i22 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    I2 = 0;
                    break;
                } else {
                    I2 = o.I(this.f76091d, strArrR0[i22], false);
                    if (I2 > 0) {
                        break;
                    } else {
                        i22++;
                    }
                }
            }
            this.f76037p = i22;
            this.f76038q = I2;
            for (int i23 = 0; i23 < eVar.f9381r.size(); i23++) {
                String str = this.f76091d.f9501m;
                if (str != null && str.equals(eVar.f9381r.get(i23))) {
                    i15 = i23;
                    break;
                }
            }
            this.f76043v = i15;
            this.f76044w = x2.h(i13) == 128;
            this.f76045x = x2.j(i13) == 64;
            this.f76027f = h(i13, z11, i16);
        }

        public static int c(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList<b> e(int i11, n0 n0Var, e eVar, int[] iArr, boolean z11, com.google.common.base.n<androidx.media3.common.y> nVar, int i12) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i13 = 0; i13 < n0Var.f9330a; i13++) {
                aVarBuilder.a(new b(i11, n0Var, i13, eVar, iArr[i13], z11, nVar, i12));
            }
            return aVarBuilder.m();
        }

        @Override // s4.o.i
        public int a() {
            return this.f76027f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering orderingReverse = (this.f76028g && this.f76031j) ? o.f76018k : o.f76018k.reverse();
            com.google.common.collect.o oVarG = com.google.common.collect.o.k().h(this.f76031j, bVar.f76031j).g(Integer.valueOf(this.f76033l), Integer.valueOf(bVar.f76033l), Ordering.natural().reverse()).d(this.f76032k, bVar.f76032k).d(this.f76034m, bVar.f76034m).h(this.f76039r, bVar.f76039r).h(this.f76036o, bVar.f76036o).g(Integer.valueOf(this.f76037p), Integer.valueOf(bVar.f76037p), Ordering.natural().reverse()).d(this.f76038q, bVar.f76038q).h(this.f76028g, bVar.f76028g).g(Integer.valueOf(this.f76043v), Integer.valueOf(bVar.f76043v), Ordering.natural().reverse()).g(Integer.valueOf(this.f76042u), Integer.valueOf(bVar.f76042u), this.f76030i.f9388y ? o.f76018k.reverse() : o.f76019l).h(this.f76044w, bVar.f76044w).h(this.f76045x, bVar.f76045x).g(Integer.valueOf(this.f76040s), Integer.valueOf(bVar.f76040s), orderingReverse).g(Integer.valueOf(this.f76041t), Integer.valueOf(bVar.f76041t), orderingReverse);
            Integer numValueOf = Integer.valueOf(this.f76042u);
            Integer numValueOf2 = Integer.valueOf(bVar.f76042u);
            if (!u0.c(this.f76029h, bVar.f76029h)) {
                orderingReverse = o.f76019l;
            }
            return oVarG.g(numValueOf, numValueOf2, orderingReverse).j();
        }

        public final int h(int i11, boolean z11, int i12) {
            if (!o.Q(i11, this.f76030i.f76061v0)) {
                return 0;
            }
            if (!this.f76028g && !this.f76030i.f76054o0) {
                return 0;
            }
            e eVar = this.f76030i;
            if (eVar.f9382s.f9394a == 2 && !o.c0(eVar, i11, this.f76091d)) {
                return 0;
            }
            if (o.Q(i11, false) && this.f76028g && this.f76091d.f9497i != -1) {
                e eVar2 = this.f76030i;
                if (!eVar2.f9389z && !eVar2.f9388y && ((eVar2.f76063x0 || !z11) && eVar2.f9382s.f9394a != 2 && (i11 & i12) != 0)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // s4.o.i
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i11;
            String str;
            int i12;
            if ((this.f76030i.f76057r0 || ((i12 = this.f76091d.f9514z) != -1 && i12 == bVar.f76091d.f9514z)) && (this.f76035n || ((str = this.f76091d.f9501m) != null && TextUtils.equals(str, bVar.f76091d.f9501m)))) {
                e eVar = this.f76030i;
                if ((eVar.f76056q0 || ((i11 = this.f76091d.A) != -1 && i11 == bVar.f76091d.A)) && (eVar.f76058s0 || (this.f76044w == bVar.f76044w && this.f76045x == bVar.f76045x))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends i<c> implements Comparable<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f76046f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f76047g;

        public c(int i11, n0 n0Var, int i12, e eVar, int i13) {
            super(i11, n0Var, i12);
            this.f76046f = o.Q(i13, eVar.f76061v0) ? 1 : 0;
            this.f76047g = this.f76091d.g();
        }

        public static int c(List<c> list, List<c> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<c> e(int i11, n0 n0Var, e eVar, int[] iArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i12 = 0; i12 < n0Var.f9330a; i12++) {
                aVarBuilder.a(new c(i11, n0Var, i12, eVar, iArr[i12]));
            }
            return aVarBuilder.m();
        }

        @Override // s4.o.i
        public int a() {
            return this.f76046f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return Integer.compare(this.f76047g, cVar.f76047g);
        }

        @Override // s4.o.i
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f76048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f76049b;

        public d(androidx.media3.common.y yVar, int i11) {
            this.f76048a = (yVar.f9493e & 1) != 0;
            this.f76049b = o.Q(i11, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return com.google.common.collect.o.k().h(this.f76049b, dVar.f76049b).h(this.f76048a, dVar.f76048a).j();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends p0 {
        public static final e B0;

        @Deprecated
        public static final e C0;
        public static final String D0;
        public static final String E0;
        public static final String F0;
        public static final String G0;
        public static final String H0;
        public static final String I0;
        public static final String J0;
        public static final String K0;
        public static final String L0;
        public static final String M0;
        public static final String N0;
        public static final String O0;
        public static final String P0;
        public static final String Q0;
        public static final String R0;
        public static final String S0;
        public static final String T0;
        public static final String U0;
        public static final String V0;

        @Deprecated
        public static final androidx.media3.common.i<e> W0;
        public final SparseBooleanArray A0;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public final boolean f76050k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public final boolean f76051l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public final boolean f76052m0;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public final boolean f76053n0;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public final boolean f76054o0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public final boolean f76055p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public final boolean f76056q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public final boolean f76057r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public final boolean f76058s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public final boolean f76059t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public final boolean f76060u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public final boolean f76061v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public final boolean f76062w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public final boolean f76063x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public final boolean f76064y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final SparseArray<Map<k0, f>> f76065z0;

        /* JADX INFO: compiled from: source.java */
        public static final class a extends p0.c {
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
            public boolean N;
            public boolean O;
            public boolean P;
            public boolean Q;
            public final SparseArray<Map<k0, f>> R;
            public final SparseBooleanArray S;

            @Deprecated
            public a() {
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                h0();
            }

            public a(Context context) {
                super(context);
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                h0();
            }

            public a(e eVar) {
                super(eVar);
                this.C = eVar.f76050k0;
                this.D = eVar.f76051l0;
                this.E = eVar.f76052m0;
                this.F = eVar.f76053n0;
                this.G = eVar.f76054o0;
                this.H = eVar.f76055p0;
                this.I = eVar.f76056q0;
                this.J = eVar.f76057r0;
                this.K = eVar.f76058s0;
                this.L = eVar.f76059t0;
                this.M = eVar.f76060u0;
                this.N = eVar.f76061v0;
                this.O = eVar.f76062w0;
                this.P = eVar.f76063x0;
                this.Q = eVar.f76064y0;
                this.R = g0(eVar.f76065z0);
                this.S = eVar.A0.clone();
            }

            public static SparseArray<Map<k0, f>> g0(SparseArray<Map<k0, f>> sparseArray) {
                SparseArray<Map<k0, f>> sparseArray2 = new SparseArray<>();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    sparseArray2.put(sparseArray.keyAt(i11), new HashMap(sparseArray.valueAt(i11)));
                }
                return sparseArray2;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public e C() {
                return new e(this);
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
            public a D(int i11) {
                super.D(i11);
                return this;
            }

            public final void h0() {
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = true;
                this.H = false;
                this.I = false;
                this.J = false;
                this.K = false;
                this.L = true;
                this.M = true;
                this.N = true;
                this.O = false;
                this.P = true;
                this.Q = false;
            }

            public a i0(p0 p0Var) {
                super.F(p0Var);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
            public a G(int i11) {
                super.G(i11);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
            public a H(o0 o0Var) {
                super.H(o0Var);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
            public a I(Context context) {
                super.I(context);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
            public a K(int i11, boolean z11) {
                super.K(i11, z11);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
            public a L(int i11, int i12, boolean z11) {
                super.L(i11, i12, z11);
                return this;
            }

            @Override // androidx.media3.common.p0.c
            /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
            public a M(Context context, boolean z11) {
                super.M(context, z11);
                return this;
            }
        }

        static {
            e eVarC = new a().C();
            B0 = eVarC;
            C0 = eVarC;
            D0 = u0.E0(1000);
            E0 = u0.E0(1001);
            F0 = u0.E0(1002);
            G0 = u0.E0(1003);
            H0 = u0.E0(1004);
            I0 = u0.E0(1005);
            J0 = u0.E0(PointerIconCompat.TYPE_CELL);
            K0 = u0.E0(PointerIconCompat.TYPE_CROSSHAIR);
            L0 = u0.E0(PointerIconCompat.TYPE_TEXT);
            M0 = u0.E0(PointerIconCompat.TYPE_VERTICAL_TEXT);
            N0 = u0.E0(1010);
            O0 = u0.E0(1011);
            P0 = u0.E0(1012);
            Q0 = u0.E0(PointerIconCompat.TYPE_ALL_SCROLL);
            R0 = u0.E0(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW);
            S0 = u0.E0(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
            T0 = u0.E0(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            U0 = u0.E0(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW);
            V0 = u0.E0(PointerIconCompat.TYPE_ZOOM_IN);
            W0 = new androidx.media3.common.b();
        }

        public e(a aVar) {
            super(aVar);
            this.f76050k0 = aVar.C;
            this.f76051l0 = aVar.D;
            this.f76052m0 = aVar.E;
            this.f76053n0 = aVar.F;
            this.f76054o0 = aVar.G;
            this.f76055p0 = aVar.H;
            this.f76056q0 = aVar.I;
            this.f76057r0 = aVar.J;
            this.f76058s0 = aVar.K;
            this.f76059t0 = aVar.L;
            this.f76060u0 = aVar.M;
            this.f76061v0 = aVar.N;
            this.f76062w0 = aVar.O;
            this.f76063x0 = aVar.P;
            this.f76064y0 = aVar.Q;
            this.f76065z0 = aVar.R;
            this.A0 = aVar.S;
        }

        public static boolean d(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
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

        public static boolean e(SparseArray<Map<k0, f>> sparseArray, SparseArray<Map<k0, f>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (iIndexOfKey < 0 || !f(sparseArray.valueAt(i11), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean f(Map<k0, f> map, Map<k0, f> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<k0, f> entry : map.entrySet()) {
                k0 key = entry.getKey();
                if (!map2.containsKey(key) || !u0.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static e h(Context context) {
            return new a(context).C();
        }

        @Override // androidx.media3.common.p0
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return super.equals(eVar) && this.f76050k0 == eVar.f76050k0 && this.f76051l0 == eVar.f76051l0 && this.f76052m0 == eVar.f76052m0 && this.f76053n0 == eVar.f76053n0 && this.f76054o0 == eVar.f76054o0 && this.f76055p0 == eVar.f76055p0 && this.f76056q0 == eVar.f76056q0 && this.f76057r0 == eVar.f76057r0 && this.f76058s0 == eVar.f76058s0 && this.f76059t0 == eVar.f76059t0 && this.f76060u0 == eVar.f76060u0 && this.f76061v0 == eVar.f76061v0 && this.f76062w0 == eVar.f76062w0 && this.f76063x0 == eVar.f76063x0 && this.f76064y0 == eVar.f76064y0 && d(this.A0, eVar.A0) && e(this.f76065z0, eVar.f76065z0);
        }

        @Override // androidx.media3.common.p0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        @Override // androidx.media3.common.p0
        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f76050k0 ? 1 : 0)) * 31) + (this.f76051l0 ? 1 : 0)) * 31) + (this.f76052m0 ? 1 : 0)) * 31) + (this.f76053n0 ? 1 : 0)) * 31) + (this.f76054o0 ? 1 : 0)) * 31) + (this.f76055p0 ? 1 : 0)) * 31) + (this.f76056q0 ? 1 : 0)) * 31) + (this.f76057r0 ? 1 : 0)) * 31) + (this.f76058s0 ? 1 : 0)) * 31) + (this.f76059t0 ? 1 : 0)) * 31) + (this.f76060u0 ? 1 : 0)) * 31) + (this.f76061v0 ? 1 : 0)) * 31) + (this.f76062w0 ? 1 : 0)) * 31) + (this.f76063x0 ? 1 : 0)) * 31) + (this.f76064y0 ? 1 : 0);
        }

        public boolean i(int i11) {
            return this.A0.get(i11);
        }

        @Nullable
        @Deprecated
        public f j(int i11, k0 k0Var) {
            Map<k0, f> map = this.f76065z0.get(i11);
            if (map != null) {
                return map.get(k0Var);
            }
            return null;
        }

        @Deprecated
        public boolean k(int i11, k0 k0Var) {
            Map<k0, f> map = this.f76065z0.get(i11);
            return map != null && map.containsKey(k0Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f76066d = u0.E0(0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f76067e = u0.E0(1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f76068f = u0.E0(2);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public static final androidx.media3.common.i<f> f76069g = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f76071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f76072c;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f76070a == fVar.f76070a && Arrays.equals(this.f76071b, fVar.f76071b) && this.f76072c == fVar.f76072c;
        }

        public int hashCode() {
            return (((this.f76070a * 31) + Arrays.hashCode(this.f76071b)) * 31) + this.f76072c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(32)
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Spatializer f76073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f76074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Handler f76075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Spatializer.OnSpatializerStateChangedListener f76076d;

        /* JADX INFO: compiled from: source.java */
        public class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f76077a;

            public a(o oVar) {
                this.f76077a = oVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z11) {
                this.f76077a.Z();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z11) {
                this.f76077a.Z();
            }
        }

        public g(Spatializer spatializer) {
            this.f76073a = spatializer;
            this.f76074b = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static g g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                return null;
            }
            return new g(audioManager.getSpatializer());
        }

        public boolean a(androidx.media3.common.d dVar, androidx.media3.common.y yVar) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(u0.M((MimeTypes.AUDIO_E_AC3_JOC.equals(yVar.f9501m) && yVar.f9514z == 16) ? 12 : yVar.f9514z));
            int i11 = yVar.A;
            if (i11 != -1) {
                channelMask.setSampleRate(i11);
            }
            return this.f76073a.canBeSpatialized(dVar.a().f9136a, channelMask.build());
        }

        public void b(o oVar, Looper looper) {
            if (this.f76076d == null && this.f76075c == null) {
                this.f76076d = new a(oVar);
                Handler handler = new Handler(looper);
                this.f76075c = handler;
                Spatializer spatializer = this.f76073a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new n1(handler), this.f76076d);
            }
        }

        public boolean c() {
            return this.f76073a.isAvailable();
        }

        public boolean d() {
            return this.f76073a.isEnabled();
        }

        public boolean e() {
            return this.f76074b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f76076d;
            if (onSpatializerStateChangedListener == null || this.f76075c == null) {
                return;
            }
            this.f76073a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) u0.i(this.f76075c)).removeCallbacksAndMessages(null);
            this.f76075c = null;
            this.f76076d = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends i<h> implements Comparable<h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f76079f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f76080g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f76081h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f76082i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f76083j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f76084k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f76085l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f76086m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f76087n;

        public h(int i11, n0 n0Var, int i12, e eVar, int i13, @Nullable String str) {
            int I;
            super(i11, n0Var, i12);
            int i14 = 0;
            this.f76080g = o.Q(i13, false);
            int i15 = this.f76091d.f9493e & (~eVar.f9385v);
            this.f76081h = (i15 & 1) != 0;
            this.f76082i = (i15 & 2) != 0;
            ImmutableList<String> immutableListOf = eVar.f9383t.isEmpty() ? ImmutableList.of("") : eVar.f9383t;
            int i16 = 0;
            while (true) {
                if (i16 >= immutableListOf.size()) {
                    i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    I = 0;
                    break;
                } else {
                    I = o.I(this.f76091d, immutableListOf.get(i16), eVar.f9386w);
                    if (I > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            this.f76083j = i16;
            this.f76084k = I;
            int iM = o.M(this.f76091d.f9494f, eVar.f9384u);
            this.f76085l = iM;
            this.f76087n = (this.f76091d.f9494f & 1088) != 0;
            int I2 = o.I(this.f76091d, str, o.b0(str) == null);
            this.f76086m = I2;
            boolean z11 = I > 0 || (eVar.f9383t.isEmpty() && iM > 0) || this.f76081h || (this.f76082i && I2 > 0);
            if (o.Q(i13, eVar.f76061v0) && z11) {
                i14 = 1;
            }
            this.f76079f = i14;
        }

        public static int c(List<h> list, List<h> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<h> e(int i11, n0 n0Var, e eVar, int[] iArr, @Nullable String str) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i12 = 0; i12 < n0Var.f9330a; i12++) {
                aVarBuilder.a(new h(i11, n0Var, i12, eVar, iArr[i12], str));
            }
            return aVarBuilder.m();
        }

        @Override // s4.o.i
        public int a() {
            return this.f76079f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            com.google.common.collect.o oVarD = com.google.common.collect.o.k().h(this.f76080g, hVar.f76080g).g(Integer.valueOf(this.f76083j), Integer.valueOf(hVar.f76083j), Ordering.natural().reverse()).d(this.f76084k, hVar.f76084k).d(this.f76085l, hVar.f76085l).h(this.f76081h, hVar.f76081h).g(Boolean.valueOf(this.f76082i), Boolean.valueOf(hVar.f76082i), this.f76084k == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.f76086m, hVar.f76086m);
            if (this.f76085l == 0) {
                oVarD = oVarD.i(this.f76087n, hVar.f76087n);
            }
            return oVarD.j();
        }

        @Override // s4.o.i
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(h hVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class i<T extends i<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n0 f76089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f76090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.media3.common.y f76091d;

        /* JADX INFO: compiled from: source.java */
        public interface a<T extends i<T>> {
            List<T> a(int i11, n0 n0Var, int[] iArr);
        }

        public i(int i11, n0 n0Var, int i12) {
            this.f76088a = i11;
            this.f76089b = n0Var;
            this.f76090c = i12;
            this.f76091d = n0Var.a(i12);
        }

        public abstract int a();

        public abstract boolean b(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j extends i<j> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f76092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e f76093g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f76094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f76095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f76096j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f76097k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f76098l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f76099m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f76100n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f76101o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f76102p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f76103q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f76104r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f76105s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f76106t;

        /* JADX WARN: Code duplicated, block: B:31:0x004b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0079  */
        public j(int i11, n0 n0Var, int i12, e eVar, int i13, int i14, boolean z11) {
            boolean z12;
            boolean z13;
            androidx.media3.common.y yVar;
            int i15;
            int i16;
            int i17;
            androidx.media3.common.y yVar2;
            int i18;
            int i19;
            int i21;
            super(i11, n0Var, i12);
            this.f76093g = eVar;
            int i22 = eVar.f76052m0 ? 24 : 16;
            this.f76102p = eVar.f76051l0 && (i14 & i22) != 0;
            if (!z11 || (((i18 = (yVar2 = this.f76091d).f9506r) != -1 && i18 > eVar.f9364a) || ((i19 = yVar2.f9507s) != -1 && i19 > eVar.f9365b))) {
                z12 = false;
            } else {
                float f11 = yVar2.f9508t;
                if ((f11 == -1.0f || f11 <= eVar.f9366c) && ((i21 = yVar2.f9497i) == -1 || i21 <= eVar.f9367d)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            }
            this.f76092f = z12;
            if (!z11 || (((i15 = (yVar = this.f76091d).f9506r) != -1 && i15 < eVar.f9368e) || ((i16 = yVar.f9507s) != -1 && i16 < eVar.f9369f))) {
                z13 = false;
            } else {
                float f12 = yVar.f9508t;
                if ((f12 == -1.0f || f12 >= eVar.f9370g) && ((i17 = yVar.f9497i) == -1 || i17 >= eVar.f9371h)) {
                    z13 = true;
                } else {
                    z13 = false;
                }
            }
            this.f76094h = z13;
            this.f76095i = o.Q(i13, false);
            androidx.media3.common.y yVar3 = this.f76091d;
            float f13 = yVar3.f9508t;
            this.f76096j = f13 != -1.0f && f13 >= 10.0f;
            this.f76097k = yVar3.f9497i;
            this.f76098l = yVar3.g();
            this.f76100n = o.M(this.f76091d.f9494f, eVar.f9376m);
            int i23 = this.f76091d.f9494f;
            this.f76101o = i23 == 0 || (i23 & 1) != 0;
            int i24 = 0;
            while (true) {
                if (i24 >= eVar.f9375l.size()) {
                    i24 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    break;
                }
                String str = this.f76091d.f9501m;
                if (str != null && str.equals(eVar.f9375l.get(i24))) {
                    break;
                } else {
                    i24++;
                }
            }
            this.f76099m = i24;
            this.f76104r = x2.h(i13) == 128;
            this.f76105s = x2.j(i13) == 64;
            this.f76106t = o.N(this.f76091d.f9501m);
            this.f76103q = k(i13, i22);
        }

        public static int e(j jVar, j jVar2) {
            com.google.common.collect.o oVarH = com.google.common.collect.o.k().h(jVar.f76095i, jVar2.f76095i).d(jVar.f76100n, jVar2.f76100n).h(jVar.f76101o, jVar2.f76101o).h(jVar.f76096j, jVar2.f76096j).h(jVar.f76092f, jVar2.f76092f).h(jVar.f76094h, jVar2.f76094h).g(Integer.valueOf(jVar.f76099m), Integer.valueOf(jVar2.f76099m), Ordering.natural().reverse()).h(jVar.f76104r, jVar2.f76104r).h(jVar.f76105s, jVar2.f76105s);
            if (jVar.f76104r && jVar.f76105s) {
                oVarH = oVarH.d(jVar.f76106t, jVar2.f76106t);
            }
            return oVarH.j();
        }

        public static int h(j jVar, j jVar2) {
            Ordering orderingReverse = (jVar.f76092f && jVar.f76095i) ? o.f76018k : o.f76018k.reverse();
            return com.google.common.collect.o.k().g(Integer.valueOf(jVar.f76097k), Integer.valueOf(jVar2.f76097k), jVar.f76093g.f9388y ? o.f76018k.reverse() : o.f76019l).g(Integer.valueOf(jVar.f76098l), Integer.valueOf(jVar2.f76098l), orderingReverse).g(Integer.valueOf(jVar.f76097k), Integer.valueOf(jVar2.f76097k), orderingReverse).j();
        }

        public static int i(List<j> list, List<j> list2) {
            return com.google.common.collect.o.k().g((j) Collections.max(list, new Comparator() { // from class: s4.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.e((o.j) obj, (o.j) obj2);
                }
            }), (j) Collections.max(list2, new Comparator() { // from class: s4.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.e((o.j) obj, (o.j) obj2);
                }
            }), new Comparator() { // from class: s4.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.e((o.j) obj, (o.j) obj2);
                }
            }).d(list.size(), list2.size()).g((j) Collections.max(list, new Comparator() { // from class: s4.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.h((o.j) obj, (o.j) obj2);
                }
            }), (j) Collections.max(list2, new Comparator() { // from class: s4.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.h((o.j) obj, (o.j) obj2);
                }
            }), new Comparator() { // from class: s4.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.j.h((o.j) obj, (o.j) obj2);
                }
            }).j();
        }

        public static ImmutableList<j> j(int i11, n0 n0Var, e eVar, int[] iArr, int i12) {
            int iJ = o.J(n0Var, eVar.f9372i, eVar.f9373j, eVar.f9374k);
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i13 = 0; i13 < n0Var.f9330a; i13++) {
                int iG = n0Var.a(i13).g();
                aVarBuilder.a(new j(i11, n0Var, i13, eVar, iArr[i13], i12, iJ == Integer.MAX_VALUE || (iG != -1 && iG <= iJ)));
            }
            return aVarBuilder.m();
        }

        @Override // s4.o.i
        public int a() {
            return this.f76103q;
        }

        public final int k(int i11, int i12) {
            if ((this.f76091d.f9494f & 16384) != 0 || !o.Q(i11, this.f76093g.f76061v0)) {
                return 0;
            }
            if (!this.f76092f && !this.f76093g.f76050k0) {
                return 0;
            }
            if (o.Q(i11, false) && this.f76094h && this.f76092f && this.f76091d.f9497i != -1) {
                e eVar = this.f76093g;
                if (!eVar.f9389z && !eVar.f9388y && (i11 & i12) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // s4.o.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean b(j jVar) {
            return (this.f76102p || u0.c(this.f76091d.f9501m, jVar.f76091d.f9501m)) && (this.f76093g.f76053n0 || (this.f76104r == jVar.f76104r && this.f76105s == jVar.f76105s));
        }
    }

    public o(Context context) {
        this(context, new s4.a.b());
    }

    public o(Context context, p0 p0Var, z.b bVar) {
        this(p0Var, bVar, context);
    }

    public o(Context context, z.b bVar) {
        this(context, e.h(context), bVar);
    }

    public o(p0 p0Var, z.b bVar, @Nullable Context context) {
        this.f76020d = new Object();
        this.f76021e = context != null ? context.getApplicationContext() : null;
        this.f76022f = bVar;
        if (p0Var instanceof e) {
            this.f76024h = (e) p0Var;
        } else {
            this.f76024h = (context == null ? e.B0 : e.h(context)).a().i0(p0Var).C();
        }
        this.f76026j = androidx.media3.common.d.f9123g;
        boolean z11 = context != null && u0.M0(context);
        this.f76023g = z11;
        if (!z11 && context != null && u0.f81838a >= 32) {
            this.f76025i = g.g(context);
        }
        if (this.f76024h.f76060u0 && context == null) {
            z3.o.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void F(b0.a aVar, e eVar, z.a[] aVarArr) {
        int iD = aVar.d();
        for (int i11 = 0; i11 < iD; i11++) {
            k0 k0VarF = aVar.f(i11);
            if (eVar.k(i11, k0VarF)) {
                f fVarJ = eVar.j(i11, k0VarF);
                aVarArr[i11] = (fVarJ == null || fVarJ.f76071b.length == 0) ? null : new z.a(k0VarF.b(fVarJ.f76070a), fVarJ.f76071b, fVarJ.f76072c);
            }
        }
    }

    public static void G(b0.a aVar, p0 p0Var, z.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < iD; i11++) {
            H(aVar.f(i11), p0Var, map);
        }
        H(aVar.h(), p0Var, map);
        for (int i12 = 0; i12 < iD; i12++) {
            o0 o0Var = (o0) map.get(Integer.valueOf(aVar.e(i12)));
            if (o0Var != null) {
                aVarArr[i12] = (o0Var.f9353b.isEmpty() || aVar.f(i12).d(o0Var.f9352a) == -1) ? null : new z.a(o0Var.f9352a, Ints.m(o0Var.f9353b));
            }
        }
    }

    public static void H(k0 k0Var, p0 p0Var, Map<Integer, o0> map) {
        o0 o0Var;
        for (int i11 = 0; i11 < k0Var.f73574a; i11++) {
            o0 o0Var2 = p0Var.A.get(k0Var.b(i11));
            if (o0Var2 != null && ((o0Var = map.get(Integer.valueOf(o0Var2.a()))) == null || (o0Var.f9353b.isEmpty() && !o0Var2.f9353b.isEmpty()))) {
                map.put(Integer.valueOf(o0Var2.a()), o0Var2);
            }
        }
    }

    public static int I(androidx.media3.common.y yVar, @Nullable String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(yVar.f9492d)) {
            return 4;
        }
        String strB0 = b0(str);
        String strB1 = b0(yVar.f9492d);
        if (strB1 == null || strB0 == null) {
            return (z11 && strB1 == null) ? 1 : 0;
        }
        if (strB1.startsWith(strB0) || strB0.startsWith(strB1)) {
            return 3;
        }
        return u0.p1(strB1, "-")[0].equals(u0.p1(strB0, "-")[0]) ? 2 : 0;
    }

    public static int J(n0 n0Var, int i11, int i12, boolean z11) {
        int i13;
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
            for (int i15 = 0; i15 < n0Var.f9330a; i15++) {
                androidx.media3.common.y yVarA = n0Var.a(i15);
                int i16 = yVarA.f9506r;
                if (i16 > 0 && (i13 = yVarA.f9507s) > 0) {
                    Point pointK = K(z11, i11, i12, i16, i13);
                    int i17 = yVarA.f9506r;
                    int i18 = yVarA.f9507s;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (pointK.x * 0.98f)) && i18 >= ((int) (pointK.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
        }
        return i14;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x000f  */
    public static Point K(boolean z11, int i11, int i12, int i13, int i14) {
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
        return i15 >= i16 ? new Point(i12, u0.k(i16, i13)) : new Point(u0.k(i15, i14), i11);
    }

    public static int M(int i11, int i12) {
        return (i11 == 0 || i11 != i12) ? Integer.bitCount(i11 & i12) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int N(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
            case "video/dolby-vision":
                return 5;
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

    public static boolean P(androidx.media3.common.y yVar) {
        String str = yVar.f9501m;
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

    public static boolean Q(int i11, boolean z11) {
        int i12 = x2.i(i11);
        return i12 == 4 || (z11 && i12 == 3);
    }

    public static /* synthetic */ List S(e eVar, int i11, n0 n0Var, int[] iArr) {
        return c.e(i11, n0Var, eVar, iArr);
    }

    public static /* synthetic */ List T(e eVar, String str, int i11, n0 n0Var, int[] iArr) {
        return h.e(i11, n0Var, eVar, iArr, str);
    }

    public static /* synthetic */ List U(e eVar, int[] iArr, int i11, n0 n0Var, int[] iArr2) {
        return j.j(i11, n0Var, eVar, iArr2, iArr[i11]);
    }

    public static /* synthetic */ int V(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int W(Integer num, Integer num2) {
        return 0;
    }

    public static void X(e eVar, b0.a aVar, int[][][] iArr, z2[] z2VarArr, z[] zVarArr) {
        int i11 = -1;
        boolean z11 = false;
        int i12 = 0;
        for (int i13 = 0; i13 < aVar.d(); i13++) {
            int iE = aVar.e(i13);
            z zVar = zVarArr[i13];
            if (iE != 1 && zVar != null) {
                return;
            }
            if (iE == 1 && zVar != null && zVar.length() == 1) {
                if (c0(eVar, iArr[i13][aVar.f(i13).d(zVar.getTrackGroup())][zVar.getIndexInTrackGroup(0)], zVar.getSelectedFormat())) {
                    i12++;
                    i11 = i13;
                }
            }
        }
        if (i12 == 1) {
            int i14 = eVar.f9382s.f9395b ? 1 : 2;
            z2 z2Var = z2VarArr[i11];
            if (z2Var != null && z2Var.f11787b) {
                z11 = true;
            }
            z2VarArr[i11] = new z2(i14, z11);
        }
    }

    public static void Y(b0.a aVar, int[][][] iArr, z2[] z2VarArr, z[] zVarArr) {
        boolean z11;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            if (i11 >= aVar.d()) {
                z11 = true;
                break;
            }
            int iE = aVar.e(i11);
            z zVar = zVarArr[i11];
            if ((iE == 1 || iE == 2) && zVar != null && d0(iArr[i11], aVar.f(i11), zVar)) {
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
        if (z11 && ((i13 == -1 || i12 == -1) ? false : true)) {
            z2 z2Var = new z2(0, true);
            z2VarArr[i13] = z2Var;
            z2VarArr[i12] = z2Var;
        }
    }

    @Nullable
    public static String b0(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public static boolean c0(e eVar, int i11, androidx.media3.common.y yVar) {
        if (x2.g(i11) == 0) {
            return false;
        }
        if (eVar.f9382s.f9396c && (x2.g(i11) & 2048) == 0) {
            return false;
        }
        if (eVar.f9382s.f9395b) {
            return !(yVar.C != 0 || yVar.D != 0) || ((x2.g(i11) & 1024) != 0);
        }
        return true;
    }

    public static boolean d0(int[][] iArr, k0 k0Var, z zVar) {
        if (zVar == null) {
            return false;
        }
        int iD = k0Var.d(zVar.getTrackGroup());
        for (int i11 = 0; i11 < zVar.length(); i11++) {
            if (x2.k(iArr[iD][zVar.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Override // s4.e0
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public e c() {
        e eVar;
        synchronized (this.f76020d) {
            eVar = this.f76024h;
        }
        return eVar;
    }

    public final boolean O(androidx.media3.common.y yVar) {
        boolean z11;
        g gVar;
        g gVar2;
        synchronized (this.f76020d) {
            try {
                if (this.f76024h.f76060u0 && !this.f76023g && yVar.f9514z > 2 && (!P(yVar) || (u0.f81838a >= 32 && (gVar2 = this.f76025i) != null && gVar2.e()))) {
                    z11 = u0.f81838a >= 32 && (gVar = this.f76025i) != null && gVar.e() && this.f76025i.c() && this.f76025i.d() && this.f76025i.a(this.f76026j, yVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public final /* synthetic */ List R(e eVar, boolean z11, int[] iArr, int i11, n0 n0Var, int[] iArr2) {
        return b.e(i11, n0Var, eVar, iArr2, z11, new com.google.common.base.n() { // from class: s4.e
            @Override // com.google.common.base.n
            public final boolean apply(Object obj) {
                return this.f76005a.O((androidx.media3.common.y) obj);
            }
        }, iArr[i11]);
    }

    public final void Z() {
        boolean z11;
        g gVar;
        synchronized (this.f76020d) {
            try {
                z11 = this.f76024h.f76060u0 && !this.f76023g && u0.f81838a >= 32 && (gVar = this.f76025i) != null && gVar.e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            f();
        }
    }

    public final void a0(w2 w2Var) {
        boolean z11;
        synchronized (this.f76020d) {
            z11 = this.f76024h.f76064y0;
        }
        if (z11) {
            g(w2Var);
        }
    }

    @Override // androidx.media3.exoplayer.y2.a
    public void b(w2 w2Var) {
        a0(w2Var);
    }

    @Override // s4.e0
    @Nullable
    public y2.a d() {
        return this;
    }

    public z.a[] e0(b0.a aVar, int[][][] iArr, int[] iArr2, e eVar) throws ExoPlaybackException {
        int iD = aVar.d();
        z.a[] aVarArr = new z.a[iD];
        Pair<z.a, Integer> pairK0 = k0(aVar, iArr, iArr2, eVar);
        String str = null;
        Pair<z.a, Integer> pairG0 = (eVar.f9387x || pairK0 == null) ? g0(aVar, iArr, eVar) : null;
        if (pairG0 != null) {
            aVarArr[((Integer) pairG0.second).intValue()] = (z.a) pairG0.first;
        } else if (pairK0 != null) {
            aVarArr[((Integer) pairK0.second).intValue()] = (z.a) pairK0.first;
        }
        Pair<z.a, Integer> pairF0 = f0(aVar, iArr, iArr2, eVar);
        if (pairF0 != null) {
            aVarArr[((Integer) pairF0.second).intValue()] = (z.a) pairF0.first;
        }
        if (pairF0 != null) {
            Object obj = pairF0.first;
            str = ((z.a) obj).f76107a.a(((z.a) obj).f76108b[0]).f9492d;
        }
        Pair<z.a, Integer> pairI0 = i0(aVar, iArr, eVar, str);
        if (pairI0 != null) {
            aVarArr[((Integer) pairI0.second).intValue()] = (z.a) pairI0.first;
        }
        for (int i11 = 0; i11 < iD; i11++) {
            int iE = aVar.e(i11);
            if (iE != 2 && iE != 1 && iE != 3 && iE != 4) {
                aVarArr[i11] = h0(iE, aVar.f(i11), iArr[i11], eVar);
            }
        }
        return aVarArr;
    }

    @Nullable
    public Pair<z.a, Integer> f0(b0.a aVar, int[][][] iArr, final int[] iArr2, final e eVar) throws ExoPlaybackException {
        final boolean z11 = false;
        for (int i11 = 0; i11 < aVar.d(); i11++) {
            if (2 == aVar.e(i11) && aVar.f(i11).f73574a > 0) {
                z11 = true;
                break;
            }
        }
        return j0(1, aVar, iArr, new i.a() { // from class: s4.d
            @Override // s4.o.i.a
            public final List a(int i12, n0 n0Var, int[] iArr3) {
                return this.f76001a.R(eVar, z11, iArr2, i12, n0Var, iArr3);
            }
        }, new Comparator() { // from class: s4.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return o.b.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public Pair<z.a, Integer> g0(b0.a aVar, int[][][] iArr, final e eVar) throws ExoPlaybackException {
        if (eVar.f9382s.f9394a == 2) {
            return null;
        }
        return j0(4, aVar, iArr, new i.a() { // from class: s4.k
            @Override // s4.o.i.a
            public final List a(int i11, n0 n0Var, int[] iArr2) {
                return o.S(eVar, i11, n0Var, iArr2);
            }
        }, new Comparator() { // from class: s4.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return o.c.c((List) obj, (List) obj2);
            }
        });
    }

    @Override // s4.e0
    public boolean h() {
        return true;
    }

    @Nullable
    public z.a h0(int i11, k0 k0Var, int[][] iArr, e eVar) throws ExoPlaybackException {
        if (eVar.f9382s.f9394a == 2) {
            return null;
        }
        n0 n0Var = null;
        d dVar = null;
        int i12 = 0;
        for (int i13 = 0; i13 < k0Var.f73574a; i13++) {
            n0 n0VarB = k0Var.b(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < n0VarB.f9330a; i14++) {
                if (Q(iArr2[i14], eVar.f76061v0)) {
                    d dVar2 = new d(n0VarB.a(i14), iArr2[i14]);
                    if (dVar == null || dVar2.compareTo(dVar) > 0) {
                        n0Var = n0VarB;
                        i12 = i14;
                        dVar = dVar2;
                    }
                }
            }
        }
        if (n0Var == null) {
            return null;
        }
        return new z.a(n0Var, i12);
    }

    @Nullable
    public Pair<z.a, Integer> i0(b0.a aVar, int[][][] iArr, final e eVar, @Nullable final String str) throws ExoPlaybackException {
        if (eVar.f9382s.f9394a == 2) {
            return null;
        }
        return j0(3, aVar, iArr, new i.a() { // from class: s4.i
            @Override // s4.o.i.a
            public final List a(int i11, n0 n0Var, int[] iArr2) {
                return o.T(eVar, str, i11, n0Var, iArr2);
            }
        }, new Comparator() { // from class: s4.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return o.h.c((List) obj, (List) obj2);
            }
        });
    }

    @Override // s4.e0
    public void j() {
        g gVar;
        synchronized (this.f76020d) {
            try {
                if (u0.f81838a >= 32 && (gVar = this.f76025i) != null) {
                    gVar.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        super.j();
    }

    @Nullable
    public final <T extends i<T>> Pair<z.a, Integer> j0(int i11, b0.a aVar, int[][][] iArr, i.a<T> aVar2, Comparator<List<T>> comparator) {
        int i12;
        RandomAccess randomAccessOf;
        ArrayList arrayList = new ArrayList();
        int iD = aVar.d();
        int i13 = 0;
        while (i13 < iD) {
            if (i11 == aVar.e(i13)) {
                k0 k0VarF = aVar.f(i13);
                for (int i14 = 0; i14 < k0VarF.f73574a; i14++) {
                    n0 n0VarB = k0VarF.b(i14);
                    List<T> listA = aVar2.a(i13, n0VarB, iArr[i13][i14]);
                    boolean[] zArr = new boolean[n0VarB.f9330a];
                    int i15 = 0;
                    while (i15 < n0VarB.f9330a) {
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
                                while (i16 < n0VarB.f9330a) {
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
            iArr2[i18] = ((i) list.get(i18)).f76090c;
        }
        i iVar = (i) list.get(0);
        return Pair.create(new z.a(iVar.f76089b, iArr2), Integer.valueOf(iVar.f76088a));
    }

    @Nullable
    public Pair<z.a, Integer> k0(b0.a aVar, int[][][] iArr, final int[] iArr2, final e eVar) throws ExoPlaybackException {
        if (eVar.f9382s.f9394a == 2) {
            return null;
        }
        return j0(2, aVar, iArr, new i.a() { // from class: s4.g
            @Override // s4.o.i.a
            public final List a(int i11, n0 n0Var, int[] iArr3) {
                return o.U(eVar, iArr2, i11, n0Var, iArr3);
            }
        }, new Comparator() { // from class: s4.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return o.j.i((List) obj, (List) obj2);
            }
        });
    }

    @Override // s4.e0
    public void l(androidx.media3.common.d dVar) {
        boolean z11;
        synchronized (this.f76020d) {
            z11 = !this.f76026j.equals(dVar);
            this.f76026j = dVar;
        }
        if (z11) {
            Z();
        }
    }

    public final void l0(e eVar) {
        boolean z11;
        z3.a.e(eVar);
        synchronized (this.f76020d) {
            z11 = !this.f76024h.equals(eVar);
            this.f76024h = eVar;
        }
        if (z11) {
            if (eVar.f76060u0 && this.f76021e == null) {
                z3.o.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            f();
        }
    }

    @Override // s4.e0
    public void m(p0 p0Var) {
        if (p0Var instanceof e) {
            l0((e) p0Var);
        }
        l0(new e.a().i0(p0Var).C());
    }

    @Override // s4.b0
    public final Pair<z2[], z[]> q(b0.a aVar, int[][][] iArr, int[] iArr2, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var) throws ExoPlaybackException {
        e eVar;
        g gVar;
        synchronized (this.f76020d) {
            try {
                eVar = this.f76024h;
                if (eVar.f76060u0 && u0.f81838a >= 32 && (gVar = this.f76025i) != null) {
                    gVar.b(this, (Looper) z3.a.i(Looper.myLooper()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int iD = aVar.d();
        z.a[] aVarArrE0 = e0(aVar, iArr, iArr2, eVar);
        G(aVar, eVar, aVarArrE0);
        F(aVar, eVar, aVarArrE0);
        for (int i11 = 0; i11 < iD; i11++) {
            int iE = aVar.e(i11);
            if (eVar.i(i11) || eVar.B.contains(Integer.valueOf(iE))) {
                aVarArrE0[i11] = null;
            }
        }
        z[] zVarArrA = this.f76022f.a(aVarArrE0, a(), bVar, m0Var);
        z2[] z2VarArr = new z2[iD];
        for (int i12 = 0; i12 < iD; i12++) {
            z2VarArr[i12] = (eVar.i(i12) || eVar.B.contains(Integer.valueOf(aVar.e(i12))) || (aVar.e(i12) != -2 && zVarArrA[i12] == null)) ? null : z2.f11785c;
        }
        if (eVar.f76062w0) {
            Y(aVar, iArr, z2VarArr, zVarArrA);
        }
        if (eVar.f9382s.f9394a != 0) {
            X(eVar, aVar, iArr, z2VarArr, zVarArrA);
        }
        return Pair.create(z2VarArr, zVarArrA);
    }
}

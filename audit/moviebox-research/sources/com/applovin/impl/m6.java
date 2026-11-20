package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m6 extends tc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f20577f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final wg f20578g = wg.a(new Comparator() { // from class: com.applovin.impl.oz
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m6.a((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final wg f20579h = wg.a(new Comparator() { // from class: com.applovin.impl.pz
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m6.b((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h8.b f20580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference f20581e;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f20584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f20585d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f20589i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f20590j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f20591k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f20592l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f20593m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f20594n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f20595o;

        public b(f9 f9Var, d dVar, int i11) {
            int i12;
            int iA;
            int iA2;
            this.f20584c = dVar;
            this.f20583b = m6.a(f9Var.f18891c);
            this.f20585d = m6.a(i11, false);
            int i13 = 0;
            while (true) {
                int size = dVar.f23664n.size();
                i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i13 >= size) {
                    i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iA = 0;
                    break;
                } else {
                    iA = m6.a(f9Var, (String) dVar.f23664n.get(i13), false);
                    if (iA > 0) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            this.f20587g = i13;
            this.f20586f = iA;
            this.f20588h = Integer.bitCount(f9Var.f18893f & dVar.f23665o);
            boolean z11 = true;
            this.f20591k = (f9Var.f18892d & 1) != 0;
            int i14 = f9Var.f18913z;
            this.f20592l = i14;
            this.f20593m = f9Var.A;
            int i15 = f9Var.f18896i;
            this.f20594n = i15;
            if ((i15 != -1 && i15 > dVar.f23667q) || (i14 != -1 && i14 > dVar.f23666p)) {
                z11 = false;
            }
            this.f20582a = z11;
            String[] strArrE = xp.e();
            int i16 = 0;
            while (true) {
                if (i16 >= strArrE.length) {
                    i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iA2 = 0;
                    break;
                } else {
                    iA2 = m6.a(f9Var, strArrE[i16], false);
                    if (iA2 > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            this.f20589i = i16;
            this.f20590j = iA2;
            for (int i17 = 0; i17 < dVar.f23668r.size(); i17++) {
                String str = f9Var.f18900m;
                if (str != null && str.equals(dVar.f23668r.get(i17))) {
                    i12 = i17;
                    break;
                }
            }
            this.f20595o = i12;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            wg wgVarC = (this.f20582a && this.f20585d) ? m6.f20578g : m6.f20578g.c();
            y3 y3VarA = y3.e().a(this.f20585d, bVar.f20585d).a(Integer.valueOf(this.f20587g), Integer.valueOf(bVar.f20587g), wg.a().c()).a(this.f20586f, bVar.f20586f).a(this.f20588h, bVar.f20588h).a(this.f20582a, bVar.f20582a).a(Integer.valueOf(this.f20595o), Integer.valueOf(bVar.f20595o), wg.a().c()).a(Integer.valueOf(this.f20594n), Integer.valueOf(bVar.f20594n), this.f20584c.f23672v ? m6.f20578g.c() : m6.f20579h).a(this.f20591k, bVar.f20591k).a(Integer.valueOf(this.f20589i), Integer.valueOf(bVar.f20589i), wg.a().c()).a(this.f20590j, bVar.f20590j).a(Integer.valueOf(this.f20592l), Integer.valueOf(bVar.f20592l), wgVarC).a(Integer.valueOf(this.f20593m), Integer.valueOf(bVar.f20593m), wgVarC);
            Integer numValueOf = Integer.valueOf(this.f20594n);
            Integer numValueOf2 = Integer.valueOf(bVar.f20594n);
            if (!xp.a((Object) this.f20583b, (Object) bVar.f20583b)) {
                wgVarC = m6.f20579h;
            }
            return y3VarA.a(numValueOf, numValueOf2, wgVarC).d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f20596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f20597b;

        public c(f9 f9Var, int i11) {
            this.f20596a = (f9Var.f18892d & 1) != 0;
            this.f20597b = m6.a(i11, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return y3.e().a(this.f20597b, cVar.f20597b).a(this.f20596a, cVar.f20596a).d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends uo {
        public static final d O;
        public static final d P;
        public static final o2.a Q;
        public final int B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        private final SparseArray M;
        private final SparseBooleanArray N;

        static {
            d dVarA = new e().a();
            O = dVarA;
            P = dVarA;
            Q = new o2.a() { // from class: com.applovin.impl.qz
                @Override // com.applovin.impl.o2.a
                public final o2 a(Bundle bundle) {
                    return m6.d.b(bundle);
                }
            };
        }

        private d(e eVar) {
            super(eVar);
            this.C = eVar.f20598x;
            this.D = eVar.f20599y;
            this.E = eVar.f20600z;
            this.F = eVar.A;
            this.G = eVar.B;
            this.H = eVar.C;
            this.I = eVar.D;
            this.B = eVar.E;
            this.J = eVar.F;
            this.K = eVar.G;
            this.L = eVar.H;
            this.M = eVar.I;
            this.N = eVar.J;
        }

        public static d a(Context context) {
            return new e(context).a();
        }

        private static boolean a(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (iIndexOfKey < 0 || !a((Map) sparseArray.valueAt(i11), (Map) sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
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

        private static boolean a(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                po poVar = (po) entry.getKey();
                if (!map2.containsKey(poVar) || !xp.a(entry.getValue(), map2.get(poVar))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d b(Bundle bundle) {
            return new e(bundle).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        public final f a(int i11, po poVar) {
            Map map = (Map) this.M.get(i11);
            if (map != null) {
                return (f) map.get(poVar);
            }
            return null;
        }

        public final boolean b(int i11, po poVar) {
            Map map = (Map) this.M.get(i11);
            return map != null && map.containsKey(poVar);
        }

        public final boolean d(int i11) {
            return this.N.get(i11);
        }

        @Override // com.applovin.impl.uo
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.C == dVar.C && this.D == dVar.D && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.B == dVar.B && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && a(this.N, dVar.N) && a(this.M, dVar.M);
        }

        @Override // com.applovin.impl.uo
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + this.B) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends uo.a {
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private int E;
        private boolean F;
        private boolean G;
        private boolean H;
        private final SparseArray I;
        private final SparseBooleanArray J;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f20598x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f20599y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f20600z;

        public e() {
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
            c();
        }

        public e(Context context) {
            super(context);
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
            c();
        }

        private e(Bundle bundle) {
            super(bundle);
            d dVar = d.O;
            i(bundle.getBoolean(d.b(1000), dVar.C));
            e(bundle.getBoolean(d.b(1001), dVar.D));
            f(bundle.getBoolean(d.b(1002), dVar.E));
            g(bundle.getBoolean(d.b(1003), dVar.F));
            b(bundle.getBoolean(d.b(1004), dVar.G));
            c(bundle.getBoolean(d.b(1005), dVar.H));
            a(bundle.getBoolean(d.b(PointerIconCompat.TYPE_CELL), dVar.I));
            a(bundle.getInt(d.b(PointerIconCompat.TYPE_CROSSHAIR), dVar.B));
            h(bundle.getBoolean(d.b(PointerIconCompat.TYPE_TEXT), dVar.J));
            j(bundle.getBoolean(d.b(PointerIconCompat.TYPE_VERTICAL_TEXT), dVar.K));
            d(bundle.getBoolean(d.b(1010), dVar.L));
            this.I = new SparseArray();
            a(bundle);
            this.J = a(bundle.getIntArray(d.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW)));
        }

        private SparseBooleanArray a(int[] iArr) {
            if (iArr == null) {
                return new SparseBooleanArray();
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
            for (int i11 : iArr) {
                sparseBooleanArray.append(i11, true);
            }
            return sparseBooleanArray;
        }

        private void a(Bundle bundle) {
            int[] intArray = bundle.getIntArray(d.b(1011));
            List listA = p2.a(po.f21809f, bundle.getParcelableArrayList(d.b(1012)), eb.h());
            SparseArray sparseArrayA = p2.a(f.f20601f, bundle.getSparseParcelableArray(d.b(PointerIconCompat.TYPE_ALL_SCROLL)), new SparseArray());
            if (intArray == null || intArray.length != listA.size()) {
                return;
            }
            for (int i11 = 0; i11 < intArray.length; i11++) {
                a(intArray[i11], (po) listA.get(i11), (f) sparseArrayA.get(i11));
            }
        }

        private void c() {
            this.f20598x = true;
            this.f20599y = false;
            this.f20600z = true;
            this.A = true;
            this.B = false;
            this.C = false;
            this.D = false;
            this.E = 0;
            this.F = true;
            this.G = false;
            this.H = true;
        }

        public e a(int i11) {
            this.E = i11;
            return this;
        }

        public final e a(int i11, po poVar, f fVar) {
            Map map = (Map) this.I.get(i11);
            if (map == null) {
                map = new HashMap();
                this.I.put(i11, map);
            }
            if (map.containsKey(poVar) && xp.a(map.get(poVar), fVar)) {
                return this;
            }
            map.put(poVar, fVar);
            return this;
        }

        public e a(boolean z11) {
            this.D = z11;
            return this;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a() {
            return new d(this);
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(int i11, int i12, boolean z11) {
            super.a(i11, i12, z11);
            return this;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(Context context, boolean z11) {
            super.a(context, z11);
            return this;
        }

        public e b(boolean z11) {
            this.B = z11;
            return this;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e a(Context context) {
            super.a(context);
            return this;
        }

        public e c(boolean z11) {
            this.C = z11;
            return this;
        }

        public e d(boolean z11) {
            this.H = z11;
            return this;
        }

        public e e(boolean z11) {
            this.f20599y = z11;
            return this;
        }

        public e f(boolean z11) {
            this.f20600z = z11;
            return this;
        }

        public e g(boolean z11) {
            this.A = z11;
            return this;
        }

        public e h(boolean z11) {
            this.F = z11;
            return this;
        }

        public e i(boolean z11) {
            this.f20598x = z11;
            return this;
        }

        public e j(boolean z11) {
            this.G = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final o2.a f20601f = new o2.a() { // from class: com.applovin.impl.rz
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return m6.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f20603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20605d;

        public f(int i11, int[] iArr, int i12) {
            this.f20602a = i11;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f20603b = iArrCopyOf;
            this.f20604c = iArr.length;
            this.f20605d = i12;
            Arrays.sort(iArrCopyOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ f a(Bundle bundle) {
            boolean z11 = false;
            int i11 = bundle.getInt(a(0), -1);
            int[] intArray = bundle.getIntArray(a(1));
            int i12 = bundle.getInt(a(2), -1);
            if (i11 >= 0 && i12 >= 0) {
                z11 = true;
            }
            b1.a(z11);
            b1.a(intArray);
            return new f(i11, intArray, i12);
        }

        private static String a(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f20602a == fVar.f20602a && Arrays.equals(this.f20603b, fVar.f20603b) && this.f20605d == fVar.f20605d;
        }

        public int hashCode() {
            return (((this.f20602a * 31) + Arrays.hashCode(this.f20603b)) * 31) + this.f20605d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f20607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f20608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f20609d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20610f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20611g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20612h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f20613i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f20614j;

        public g(f9 f9Var, d dVar, int i11, String str) {
            int iA;
            boolean z11 = false;
            this.f20607b = m6.a(i11, false);
            int i12 = f9Var.f18892d & (~dVar.B);
            this.f20608c = (i12 & 1) != 0;
            this.f20609d = (i12 & 2) != 0;
            eb ebVarA = dVar.f23669s.isEmpty() ? eb.a("") : dVar.f23669s;
            int i13 = 0;
            while (true) {
                if (i13 >= ebVarA.size()) {
                    i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iA = 0;
                    break;
                } else {
                    iA = m6.a(f9Var, (String) ebVarA.get(i13), dVar.f23671u);
                    if (iA > 0) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            this.f20610f = i13;
            this.f20611g = iA;
            int iBitCount = Integer.bitCount(f9Var.f18893f & dVar.f23670t);
            this.f20612h = iBitCount;
            this.f20614j = (f9Var.f18893f & 1088) != 0;
            int iA2 = m6.a(f9Var, str, m6.a(str) == null);
            this.f20613i = iA2;
            if (iA > 0 || ((dVar.f23669s.isEmpty() && iBitCount > 0) || this.f20608c || (this.f20609d && iA2 > 0))) {
                z11 = true;
            }
            this.f20606a = z11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            y3 y3VarA = y3.e().a(this.f20607b, gVar.f20607b).a(Integer.valueOf(this.f20610f), Integer.valueOf(gVar.f20610f), wg.a().c()).a(this.f20611g, gVar.f20611g).a(this.f20612h, gVar.f20612h).a(this.f20608c, gVar.f20608c).a(Boolean.valueOf(this.f20609d), Boolean.valueOf(gVar.f20609d), this.f20611g == 0 ? wg.a() : wg.a().c()).a(this.f20613i, gVar.f20613i);
            if (this.f20612h == 0) {
                y3VarA = y3VarA.b(this.f20614j, gVar.f20614j);
            }
            return y3VarA.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f20616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f20617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f20618d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20620g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20621h;

        /* JADX WARN: Code duplicated, block: B:21:0x0033  */
        /* JADX WARN: Code duplicated, block: B:41:0x005e  */
        public h(f9 f9Var, d dVar, int i11, boolean z11) {
            boolean z12;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            this.f20616b = dVar;
            boolean z13 = true;
            int i18 = 0;
            if (!z11 || (((i15 = f9Var.f18905r) != -1 && i15 > dVar.f23652a) || ((i16 = f9Var.f18906s) != -1 && i16 > dVar.f23653b))) {
                z12 = false;
            } else {
                float f11 = f9Var.f18907t;
                if ((f11 == -1.0f || f11 <= dVar.f23654c) && ((i17 = f9Var.f18896i) == -1 || i17 <= dVar.f23655d)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            }
            this.f20615a = z12;
            if (!z11 || (((i12 = f9Var.f18905r) != -1 && i12 < dVar.f23656f) || ((i13 = f9Var.f18906s) != -1 && i13 < dVar.f23657g))) {
                z13 = false;
            } else {
                float f12 = f9Var.f18907t;
                if ((f12 != -1.0f && f12 < dVar.f23658h) || ((i14 = f9Var.f18896i) != -1 && i14 < dVar.f23659i)) {
                    z13 = false;
                }
            }
            this.f20617c = z13;
            this.f20618d = m6.a(i11, false);
            this.f20619f = f9Var.f18896i;
            this.f20620g = f9Var.b();
            while (i18 < dVar.f23663m.size()) {
                String str = f9Var.f18900m;
                if (str != null && str.equals(dVar.f23663m.get(i18))) {
                    this.f20621h = i18;
                }
                i18++;
            }
            i18 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f20621h = i18;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            wg wgVarC = (this.f20615a && this.f20618d) ? m6.f20578g : m6.f20578g.c();
            return y3.e().a(this.f20618d, hVar.f20618d).a(this.f20615a, hVar.f20615a).a(this.f20617c, hVar.f20617c).a(Integer.valueOf(this.f20621h), Integer.valueOf(hVar.f20621h), wg.a().c()).a(Integer.valueOf(this.f20619f), Integer.valueOf(hVar.f20619f), this.f20616b.f23672v ? m6.f20578g.c() : m6.f20579h).a(Integer.valueOf(this.f20620g), Integer.valueOf(hVar.f20620g), wgVarC).a(Integer.valueOf(this.f20619f), Integer.valueOf(hVar.f20619f), wgVarC).d();
        }
    }

    public m6(Context context) {
        this(context, new i0.b());
    }

    public m6(Context context, h8.b bVar) {
        this(d.a(context), bVar);
    }

    public m6(d dVar, h8.b bVar) {
        this.f20580d = bVar;
        this.f20581e = new AtomicReference(dVar);
    }

    public static int a(f9 f9Var, String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(f9Var.f18891c)) {
            return 4;
        }
        String strA = a(str);
        String strA2 = a(f9Var.f18891c);
        if (strA2 == null || strA == null) {
            return (z11 && strA2 == null) ? 1 : 0;
        }
        if (strA2.startsWith(strA) || strA.startsWith(strA2)) {
            return 3;
        }
        return xp.b(strA2, "-")[0].equals(xp.b(strA, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x000f  */
    private static Point a(boolean z11, int i11, int i12, int i13, int i14) {
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
        return i15 >= i16 ? new Point(i12, xp.a(i16, i13)) : new Point(xp.a(i15, i14), i11);
    }

    private static h8.a a(po poVar, int[][] iArr, int i11, d dVar) {
        d dVar2 = dVar;
        int i12 = dVar2.E ? 24 : 16;
        boolean z11 = dVar2.D && (i11 & i12) != 0;
        int i13 = 0;
        while (i13 < poVar.f21810a) {
            oo ooVarA = poVar.a(i13);
            int i14 = i13;
            int[] iArrA = a(ooVarA, iArr[i13], z11, i12, dVar2.f23652a, dVar2.f23653b, dVar2.f23654c, dVar2.f23655d, dVar2.f23656f, dVar2.f23657g, dVar2.f23658h, dVar2.f23659i, dVar2.f23660j, dVar2.f23661k, dVar2.f23662l);
            if (iArrA.length > 0) {
                return new h8.a(ooVarA, iArrA);
            }
            i13 = i14 + 1;
            dVar2 = dVar;
        }
        return null;
    }

    private static h8.a a(po poVar, int[][] iArr, d dVar) {
        int i11 = -1;
        oo ooVar = null;
        h hVar = null;
        for (int i12 = 0; i12 < poVar.f21810a; i12++) {
            oo ooVarA = poVar.a(i12);
            List listA = a(ooVarA, dVar.f23660j, dVar.f23661k, dVar.f23662l);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < ooVarA.f21584a; i13++) {
                f9 f9VarA = ooVarA.a(i13);
                if ((f9VarA.f18893f & 16384) == 0 && a(iArr2[i13], dVar.J)) {
                    h hVar2 = new h(f9VarA, dVar, iArr2[i13], listA.contains(Integer.valueOf(i13)));
                    if ((hVar2.f20615a || dVar.C) && (hVar == null || hVar2.compareTo(hVar) > 0)) {
                        ooVar = ooVarA;
                        i11 = i13;
                        hVar = hVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return new h8.a(ooVar, i11);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    private static List a(oo ooVar, int i11, int i12, boolean z11) {
        int i13;
        ArrayList arrayList = new ArrayList(ooVar.f21584a);
        for (int i14 = 0; i14 < ooVar.f21584a; i14++) {
            arrayList.add(Integer.valueOf(i14));
        }
        if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
            int i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i16 = 0; i16 < ooVar.f21584a; i16++) {
                f9 f9VarA = ooVar.a(i16);
                int i17 = f9VarA.f18905r;
                if (i17 > 0 && (i13 = f9VarA.f18906s) > 0) {
                    Point pointA = a(z11, i11, i12, i17, i13);
                    int i18 = f9VarA.f18905r;
                    int i19 = f9VarA.f18906s;
                    int i21 = i18 * i19;
                    if (i18 >= ((int) (pointA.x * 0.98f)) && i19 >= ((int) (pointA.y * 0.98f)) && i21 < i15) {
                        i15 = i21;
                    }
                }
            }
            if (i15 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iB = ooVar.a(((Integer) arrayList.get(size)).intValue()).b();
                    if (iB == -1 || iB > i15) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void a(oo ooVar, int[] iArr, int i11, String str, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = ((Integer) list.get(size)).intValue();
            if (!a(ooVar.a(iIntValue), str, iArr[iIntValue], i11, i12, i13, i14, i15, i16, i17, i18, i19)) {
                list.remove(size);
            }
        }
    }

    private static void a(tc.a aVar, int[][][] iArr, si[] siVarArr, h8[] h8VarArr) {
        boolean z11;
        boolean z12 = false;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            if (i11 >= aVar.a()) {
                z11 = true;
                break;
            }
            int iA = aVar.a(i11);
            h8 h8Var = h8VarArr[i11];
            if ((iA == 1 || iA == 2) && h8Var != null && a(iArr[i11], aVar.b(i11), h8Var)) {
                if (iA == 1) {
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
            si siVar = new si(true);
            siVarArr[i13] = siVar;
            siVarArr[i12] = siVar;
        }
    }

    public static boolean a(int i11, boolean z11) {
        int iD = v40.d(i11);
        return iD == 4 || (z11 && iD == 3);
    }

    private static boolean a(f9 f9Var, int i11, f9 f9Var2, int i12, boolean z11, boolean z12, boolean z13) {
        int i13;
        int i14;
        String str;
        int i15;
        if (!a(i11, false) || (i13 = f9Var.f18896i) == -1 || i13 > i12) {
            return false;
        }
        if (!z13 && ((i15 = f9Var.f18913z) == -1 || i15 != f9Var2.f18913z)) {
            return false;
        }
        if (z11 || ((str = f9Var.f18900m) != null && TextUtils.equals(str, f9Var2.f18900m))) {
            return z12 || ((i14 = f9Var.A) != -1 && i14 == f9Var2.A);
        }
        return false;
    }

    private static boolean a(f9 f9Var, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
        int i22;
        if ((f9Var.f18893f & 16384) != 0 || !a(i11, false) || (i11 & i12) == 0) {
            return false;
        }
        if (str != null && !xp.a((Object) f9Var.f18900m, (Object) str)) {
            return false;
        }
        int i23 = f9Var.f18905r;
        if (i23 != -1 && (i17 > i23 || i23 > i13)) {
            return false;
        }
        int i24 = f9Var.f18906s;
        if (i24 != -1 && (i18 > i24 || i24 > i14)) {
            return false;
        }
        float f11 = f9Var.f18907t;
        return (f11 == -1.0f || (((float) i19) <= f11 && f11 <= ((float) i15))) && (i22 = f9Var.f18896i) != -1 && i21 <= i22 && i22 <= i16;
    }

    private static boolean a(int[][] iArr, po poVar, h8 h8Var) {
        if (h8Var == null) {
            return false;
        }
        int iA = poVar.a(h8Var.a());
        for (int i11 = 0; i11 < h8Var.b(); i11++) {
            if (v40.c(iArr[iA][h8Var.b(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(oo ooVar, int[] iArr, int i11, int i12, boolean z11, boolean z12, boolean z13) {
        f9 f9VarA = ooVar.a(i11);
        int[] iArr2 = new int[ooVar.f21584a];
        int i13 = 0;
        for (int i14 = 0; i14 < ooVar.f21584a; i14++) {
            if (i14 == i11 || a(ooVar.a(i14), iArr[i14], f9VarA, i12, z11, z12, z13)) {
                iArr2[i13] = i14;
                i13++;
            }
        }
        return Arrays.copyOf(iArr2, i13);
    }

    private static int[] a(oo ooVar, int[] iArr, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, boolean z12) {
        String str;
        int i23;
        int i24;
        HashSet hashSet;
        if (ooVar.f21584a < 2) {
            return f20577f;
        }
        List listA = a(ooVar, i21, i22, z12);
        if (listA.size() < 2) {
            return f20577f;
        }
        if (z11) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i25 = 0;
            int i26 = 0;
            while (i26 < listA.size()) {
                String str3 = ooVar.a(((Integer) listA.get(i26)).intValue()).f18900m;
                if (hashSet2.add(str3)) {
                    i23 = i25;
                    i24 = i26;
                    hashSet = hashSet2;
                    int iB = b(ooVar, iArr, i11, str3, i12, i13, i14, i15, i16, i17, i18, i19, listA);
                    if (iB > i23) {
                        i25 = iB;
                        str2 = str3;
                    }
                    i26 = i24 + 1;
                    hashSet2 = hashSet;
                } else {
                    i23 = i25;
                    i24 = i26;
                    hashSet = hashSet2;
                }
                i25 = i23;
                i26 = i24 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        a(ooVar, iArr, i11, str, i12, i13, i14, i15, i16, i17, i18, i19, listA);
        return listA.size() < 2 ? f20577f : ub.a(listA);
    }

    private static int b(oo ooVar, int[] iArr, int i11, String str, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List list) {
        int i21 = 0;
        for (int i22 = 0; i22 < list.size(); i22++) {
            int iIntValue = ((Integer) list.get(i22)).intValue();
            if (a(ooVar.a(iIntValue), str, iArr[iIntValue], i11, i12, i13, i14, i15, i16, i17, i18, i19)) {
                i21++;
            }
        }
        return i21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Integer num, Integer num2) {
        return 0;
    }

    public Pair a(po poVar, int[][] iArr, int i11, d dVar, boolean z11) {
        h8.a aVar = null;
        b bVar = null;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < poVar.f21810a; i14++) {
            oo ooVarA = poVar.a(i14);
            int[] iArr2 = iArr[i14];
            for (int i15 = 0; i15 < ooVarA.f21584a; i15++) {
                if (a(iArr2[i15], dVar.J)) {
                    b bVar2 = new b(ooVarA.a(i15), dVar, iArr2[i15]);
                    if ((bVar2.f20582a || dVar.F) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i12 = i14;
                        i13 = i15;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i12 == -1) {
            return null;
        }
        oo ooVarA2 = poVar.a(i12);
        if (!dVar.f23673w && !dVar.f23672v && z11) {
            int[] iArrA = a(ooVarA2, iArr[i12], i13, dVar.f23667q, dVar.G, dVar.H, dVar.I);
            if (iArrA.length > 1) {
                aVar = new h8.a(ooVarA2, iArrA);
            }
        }
        if (aVar == null) {
            aVar = new h8.a(ooVarA2, i13);
        }
        return Pair.create(aVar, (b) b1.a(bVar));
    }

    public Pair a(po poVar, int[][] iArr, d dVar, String str) {
        int i11 = -1;
        oo ooVar = null;
        g gVar = null;
        for (int i12 = 0; i12 < poVar.f21810a; i12++) {
            oo ooVarA = poVar.a(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < ooVarA.f21584a; i13++) {
                if (a(iArr2[i13], dVar.J)) {
                    g gVar2 = new g(ooVarA.a(i13), dVar, iArr2[i13], str);
                    if (gVar2.f20606a && (gVar == null || gVar2.compareTo(gVar) > 0)) {
                        ooVar = ooVarA;
                        i11 = i13;
                        gVar = gVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return Pair.create(new h8.a(ooVar, i11), (g) b1.a(gVar));
    }

    @Override // com.applovin.impl.tc
    public final Pair a(tc.a aVar, int[][][] iArr, int[] iArr2, be.a aVar2, fo foVar) {
        d dVar = (d) this.f20581e.get();
        int iA = aVar.a();
        h8.a[] aVarArrA = a(aVar, iArr, iArr2, dVar);
        int i11 = 0;
        while (true) {
            if (i11 >= iA) {
                break;
            }
            int iA2 = aVar.a(i11);
            if (dVar.d(i11) || dVar.f23674x.contains(Integer.valueOf(iA2))) {
                aVarArrA[i11] = null;
            } else {
                po poVarB = aVar.b(i11);
                if (dVar.b(i11, poVarB)) {
                    f fVarA = dVar.a(i11, poVarB);
                    aVarArrA[i11] = fVarA != null ? new h8.a(poVarB.a(fVarA.f20602a), fVarA.f20603b, fVarA.f20605d) : null;
                }
            }
            i11++;
        }
        h8[] h8VarArrA = this.f20580d.a(aVarArrA, a(), aVar2, foVar);
        si[] siVarArr = new si[iA];
        for (int i12 = 0; i12 < iA; i12++) {
            siVarArr[i12] = (dVar.d(i12) || dVar.f23674x.contains(Integer.valueOf(aVar.a(i12))) || (aVar.a(i12) != -2 && h8VarArrA[i12] == null)) ? null : si.f22909b;
        }
        if (dVar.K) {
            a(aVar, iArr, siVarArr, h8VarArrA);
        }
        return Pair.create(siVarArr, h8VarArrA);
    }

    public h8.a a(int i11, po poVar, int[][] iArr, d dVar) {
        oo ooVar = null;
        c cVar = null;
        int i12 = 0;
        for (int i13 = 0; i13 < poVar.f21810a; i13++) {
            oo ooVarA = poVar.a(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < ooVarA.f21584a; i14++) {
                if (a(iArr2[i14], dVar.J)) {
                    c cVar2 = new c(ooVarA.a(i14), iArr2[i14]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        ooVar = ooVarA;
                        i12 = i14;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return new h8.a(ooVar, i12);
    }

    public h8.a[] a(tc.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        int i11;
        String str;
        int i12;
        String str2;
        b bVar;
        int i13;
        int iA = aVar.a();
        h8.a[] aVarArr = new h8.a[iA];
        int i14 = 0;
        boolean z11 = false;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            i11 = 1;
            if (i15 >= iA) {
                break;
            }
            if (2 == aVar.a(i15)) {
                if (!z11) {
                    h8.a aVarB = b(aVar.b(i15), iArr[i15], iArr2[i15], dVar, true);
                    aVarArr[i15] = aVarB;
                    z11 = aVarB != null;
                }
                i16 |= aVar.b(i15).f21810a <= 0 ? 0 : 1;
            }
            i15++;
        }
        String str3 = null;
        b bVar2 = null;
        int i17 = -1;
        int i18 = 0;
        while (i18 < iA) {
            if (i11 == aVar.a(i18)) {
                i12 = i17;
                str2 = str3;
                bVar = bVar2;
                i13 = i18;
                Pair pairA = a(aVar.b(i18), iArr[i18], iArr2[i18], dVar, dVar.L || i16 == 0);
                if (pairA != null && (bVar == null || ((b) pairA.second).compareTo(bVar) > 0)) {
                    if (i12 != -1) {
                        aVarArr[i12] = null;
                    }
                    h8.a aVar2 = (h8.a) pairA.first;
                    aVarArr[i13] = aVar2;
                    str3 = aVar2.f19392a.a(aVar2.f19393b[0]).f18891c;
                    bVar2 = (b) pairA.second;
                    i17 = i13;
                }
                i18 = i13 + 1;
                i11 = 1;
            } else {
                i12 = i17;
                str2 = str3;
                bVar = bVar2;
                i13 = i18;
            }
            i17 = i12;
            bVar2 = bVar;
            str3 = str2;
            i18 = i13 + 1;
            i11 = 1;
        }
        String str4 = str3;
        g gVar = null;
        int i19 = -1;
        while (i14 < iA) {
            int iA2 = aVar.a(i14);
            if (iA2 == 1) {
                str = str4;
            } else if (iA2 == 2) {
                str = str4;
            } else if (iA2 != 3) {
                aVarArr[i14] = a(iA2, aVar.b(i14), iArr[i14], dVar);
                str = str4;
            } else {
                str = str4;
                Pair pairA2 = a(aVar.b(i14), iArr[i14], dVar, str);
                if (pairA2 != null && (gVar == null || ((g) pairA2.second).compareTo(gVar) > 0)) {
                    if (i19 != -1) {
                        aVarArr[i19] = null;
                    }
                    aVarArr[i14] = (h8.a) pairA2.first;
                    gVar = (g) pairA2.second;
                    i19 = i14;
                }
            }
            i14++;
            str4 = str;
        }
        return aVarArr;
    }

    public h8.a b(po poVar, int[][] iArr, int i11, d dVar, boolean z11) {
        h8.a aVarA = (dVar.f23673w || dVar.f23672v || !z11) ? null : a(poVar, iArr, i11, dVar);
        return aVarA == null ? a(poVar, iArr, dVar) : aVarA;
    }

    @Override // com.applovin.impl.vo
    public boolean b() {
        return true;
    }
}

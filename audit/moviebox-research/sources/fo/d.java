package fo;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.util.Pair;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.auto.value.AutoBuilder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f65159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f65161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f65162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fo.a f65163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseBooleanArray f65164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f65165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f65166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f65167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f65168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Point f65169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f65170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f65171m;

    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public static abstract class a {
        public abstract d a();

        public abstract k b(SparseBooleanArray sparseBooleanArray);

        public abstract SparseBooleanArray c();

        public abstract a d(fo.a aVar);

        public abstract a e(b bVar);

        public d f() {
            return a();
        }

        public a g(int i11, boolean z11) {
            SparseBooleanArray sparseBooleanArrayC = c();
            if (z11) {
                sparseBooleanArrayC.put(i11, true);
            } else {
                sparseBooleanArrayC.delete(i11);
            }
            return this;
        }

        public abstract a h(List<Pair<String, String>> list);

        public abstract a i(List<String> list);

        public abstract a j(String str);

        public abstract a k(String str);

        public abstract a l(float f11);

        public abstract a m(Point point);

        public abstract a n(long j11);

        public abstract a o(int i11);

        public abstract a p(int i11);
    }

    public d(long j11, int i11, String str, b bVar, fo.a aVar, SparseBooleanArray sparseBooleanArray, List list, String str2, String str3, List list2, Point point, float f11, int i12) {
        this.f65159a = j11;
        this.f65160b = i11;
        this.f65161c = str;
        this.f65162d = bVar;
        this.f65163e = aVar;
        this.f65164f = sparseBooleanArray;
        this.f65165g = list;
        this.f65166h = str2;
        this.f65167i = str3;
        this.f65168j = list2;
        this.f65169k = point;
        this.f65170l = f11;
        this.f65171m = i12;
    }

    public static a k() {
        k kVar = (k) new k().n(0L).o(0).d(fo.a.f().build()).e(b.g().build()).k("").b(new SparseBooleanArray(5)).h(Collections.emptyList());
        kVar.f65200h = "";
        kVar.f65201i = "";
        return kVar.i(Collections.emptyList()).m(new Point()).l(0.0f).p(0);
    }

    @Override // io.l
    public void a(io.r rVar) {
        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();
        for (int i11 = 0; i11 < this.f65164f.size(); i11++) {
            int iKeyAt = this.f65164f.keyAt(i11);
            if (this.f65164f.valueAt(i11)) {
                if (iKeyAt >= 500) {
                    bitSet2.set(iKeyAt + AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT);
                } else {
                    bitSet.set(iKeyAt);
                }
            }
        }
        rVar.n(1, this.f65159a).s(2, this.f65160b).h(3, bitSet.toByteArray()).q(4, this.f65162d).q(5, this.f65163e).u(7, this.f65166h).u(8, this.f65167i).n(10, c.a(this.f65169k.x) | (c.a(this.f65169k.y) << 32)).l(11, this.f65170l).u(12, this.f65161c).o(13, this.f65171m).h(500, bitSet2.toByteArray());
        Iterator it = this.f65165g.iterator();
        while (it.hasNext()) {
            rVar.v(6, (Pair) it.next());
        }
        Iterator it2 = this.f65168j.iterator();
        while (it2.hasNext()) {
            rVar.u(9, (String) it2.next());
        }
    }

    public fo.a c() {
        return this.f65163e;
    }

    public b d() {
        return this.f65162d;
    }

    public SparseBooleanArray e() {
        return this.f65164f;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f65159a == dVar.f65159a && this.f65160b == dVar.f65160b && Objects.equals(this.f65161c, dVar.f65161c) && Objects.equals(this.f65162d, dVar.f65162d) && Objects.equals(this.f65163e, dVar.f65163e) && Objects.equals(this.f65164f, dVar.f65164f) && Objects.equals(this.f65165g, dVar.f65165g) && Objects.equals(this.f65166h, dVar.f65166h) && Objects.equals(this.f65167i, dVar.f65167i) && Objects.equals(this.f65168j, dVar.f65168j) && Objects.equals(this.f65169k, dVar.f65169k) && this.f65170l == dVar.f65170l && this.f65171m == dVar.f65171m;
    }

    public List<Pair<String, String>> f() {
        return this.f65165g;
    }

    public List<String> g() {
        return this.f65168j;
    }

    public String h() {
        return this.f65167i;
    }

    public int hashCode() {
        return l.p.a(this.f65159a);
    }

    @Override // io.l
    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public d b(io.o oVar) {
        k kVarB = o().b(this.f65164f);
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN != 500) {
                switch (iN) {
                    case 1:
                        kVarB.n(oVar.j());
                        continue;
                    case 2:
                        kVarB.o(oVar.o());
                        continue;
                    case 3:
                        break;
                    case 4:
                        kVarB.e((b) oVar.l(this.f65162d));
                        continue;
                    case 5:
                        kVarB.d((fo.a) oVar.l(this.f65163e));
                        continue;
                    case 6:
                        List arrayList = kVarB.f65199g;
                        if (arrayList == null) {
                            throw new IllegalStateException("Property \"ids\" has not been set");
                        }
                        if (arrayList == this.f65165g) {
                            arrayList = new ArrayList(1);
                            kVarB.f65199g = arrayList;
                        }
                        arrayList.add(oVar.r());
                        continue;
                        break;
                    case 7:
                        kVarB.q(oVar.q());
                        continue;
                    case 8:
                        kVarB.j(oVar.q());
                        continue;
                    case 9:
                        List arrayList2 = kVarB.f65202j;
                        if (arrayList2 == null) {
                            throw new IllegalStateException("Property \"inputLocales\" has not been set");
                        }
                        if (arrayList2 == this.f65168j) {
                            arrayList2 = new ArrayList(1);
                            kVarB.f65202j = arrayList2;
                        }
                        arrayList2.add(oVar.q());
                        continue;
                        break;
                    case 10:
                        long j11 = oVar.j();
                        kVarB.f65203k = new Point((int) (4294967295L & j11), (int) (j11 >>> 32));
                        continue;
                    case 11:
                        kVarB.l(oVar.h());
                        continue;
                    case 12:
                        kVarB.k(oVar.q());
                        continue;
                    case 13:
                        kVarB.p(oVar.k());
                        continue;
                    default:
                        oVar.c();
                        continue;
                }
            }
            SparseBooleanArray sparseBooleanArrayC = kVarB.c();
            BitSet bitSetValueOf = BitSet.valueOf(oVar.f());
            if (sparseBooleanArrayC == this.f65164f) {
                kVarB.f65198f = new SparseBooleanArray();
            }
            for (int iNextSetBit = bitSetValueOf.nextSetBit(0); iNextSetBit != -1; iNextSetBit = bitSetValueOf.nextSetBit(iNextSetBit + 1)) {
                kVarB.g(iN == 500 ? iNextSetBit + 500 : iNextSetBit, true);
            }
        }
        return kVarB.f();
    }

    public String j() {
        return this.f65161c;
    }

    public float l() {
        return this.f65170l;
    }

    public Point m() {
        return this.f65169k;
    }

    public long n() {
        return this.f65159a;
    }

    public a o() {
        return new k(this).b(this.f65164f.clone());
    }

    public int p() {
        return this.f65160b;
    }

    public String q() {
        return this.f65166h;
    }

    public int r() {
        return this.f65171m;
    }

    public String toString() {
        return super.toString();
    }
}

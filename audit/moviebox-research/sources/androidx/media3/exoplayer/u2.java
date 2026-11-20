package androidx.media3.exoplayer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u2 extends androidx.media3.exoplayer.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f11427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f11428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.media3.common.m0[] f11429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object[] f11430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<Object, Integer> f11431o;

    /* JADX INFO: compiled from: source.java */
    public class a extends p4.m {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final androidx.media3.common.m0.c f11432g;

        public a(androidx.media3.common.m0 m0Var) {
            super(m0Var);
            this.f11432g = new androidx.media3.common.m0.c();
        }

        @Override // p4.m, androidx.media3.common.m0
        public androidx.media3.common.m0.b g(int i11, androidx.media3.common.m0.b bVar, boolean z11) {
            androidx.media3.common.m0.b bVarG = super.g(i11, bVar, z11);
            if (super.n(bVarG.f9295c, this.f11432g).f()) {
                bVarG.u(bVar.f9293a, bVar.f9294b, bVar.f9295c, bVar.f9296d, bVar.f9297e, androidx.media3.common.c.f9089g, true);
            } else {
                bVarG.f9298f = true;
            }
            return bVarG;
        }
    }

    public u2(Collection<? extends d2> collection, p4.f0 f0Var) {
        this(G(collection), H(collection), f0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u2(androidx.media3.common.m0[] m0VarArr, Object[] objArr, p4.f0 f0Var) {
        super(false, f0Var);
        int i11 = 0;
        int length = m0VarArr.length;
        this.f11429m = m0VarArr;
        this.f11427k = new int[length];
        this.f11428l = new int[length];
        this.f11430n = objArr;
        this.f11431o = new HashMap<>();
        int length2 = m0VarArr.length;
        int iP = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length2) {
            androidx.media3.common.m0 m0Var = m0VarArr[i11];
            this.f11429m[i13] = m0Var;
            this.f11428l[i13] = iP;
            this.f11427k[i13] = i12;
            iP += m0Var.p();
            i12 += this.f11429m[i13].i();
            this.f11431o.put(objArr[i13], Integer.valueOf(i13));
            i11++;
            i13++;
        }
        this.f11425i = iP;
        this.f11426j = i12;
    }

    public static androidx.media3.common.m0[] G(Collection<? extends d2> collection) {
        androidx.media3.common.m0[] m0VarArr = new androidx.media3.common.m0[collection.size()];
        Iterator<? extends d2> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            m0VarArr[i11] = it.next().b();
            i11++;
        }
        return m0VarArr;
    }

    public static Object[] H(Collection<? extends d2> collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator<? extends d2> it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            objArr[i11] = it.next().a();
            i11++;
        }
        return objArr;
    }

    @Override // androidx.media3.exoplayer.a
    public int A(int i11) {
        return this.f11428l[i11];
    }

    @Override // androidx.media3.exoplayer.a
    public androidx.media3.common.m0 D(int i11) {
        return this.f11429m[i11];
    }

    public u2 E(p4.f0 f0Var) {
        androidx.media3.common.m0[] m0VarArr = new androidx.media3.common.m0[this.f11429m.length];
        int i11 = 0;
        while (true) {
            androidx.media3.common.m0[] m0VarArr2 = this.f11429m;
            if (i11 >= m0VarArr2.length) {
                return new u2(m0VarArr, this.f11430n, f0Var);
            }
            m0VarArr[i11] = new a(m0VarArr2[i11]);
            i11++;
        }
    }

    public List<androidx.media3.common.m0> F() {
        return Arrays.asList(this.f11429m);
    }

    @Override // androidx.media3.common.m0
    public int i() {
        return this.f11426j;
    }

    @Override // androidx.media3.common.m0
    public int p() {
        return this.f11425i;
    }

    @Override // androidx.media3.exoplayer.a
    public int s(Object obj) {
        Integer num = this.f11431o.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // androidx.media3.exoplayer.a
    public int t(int i11) {
        return z3.u0.g(this.f11427k, i11 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.a
    public int u(int i11) {
        return z3.u0.g(this.f11428l, i11 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.a
    public Object x(int i11) {
        return this.f11430n[i11];
    }

    @Override // androidx.media3.exoplayer.a
    public int z(int i11) {
        return this.f11427k[i11];
    }
}

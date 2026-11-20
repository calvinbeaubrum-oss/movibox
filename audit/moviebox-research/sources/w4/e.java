package w4;

import java.io.IOException;
import java.util.Arrays;
import u4.m0;
import u4.n0;
import u4.r0;
import u4.t;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f79272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f79275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f79276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f79279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f79280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f79281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f79282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f79283l;

    public e(int i11, int i12, long j11, int i13, r0 r0Var) {
        boolean z11 = true;
        if (i12 != 1 && i12 != 2) {
            z11 = false;
        }
        z3.a.a(z11);
        this.f79275d = j11;
        this.f79276e = i13;
        this.f79272a = r0Var;
        this.f79273b = d(i11, i12 == 2 ? 1667497984 : 1651965952);
        this.f79274c = i12 == 2 ? d(i11, 1650720768) : -1;
        this.f79282k = new long[512];
        this.f79283l = new int[512];
    }

    public static int d(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    public void a() {
        this.f79279h++;
    }

    public void b(long j11) {
        if (this.f79281j == this.f79283l.length) {
            long[] jArr = this.f79282k;
            this.f79282k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f79283l;
            this.f79283l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f79282k;
        int i11 = this.f79281j;
        jArr2[i11] = j11;
        this.f79283l[i11] = this.f79280i;
        this.f79281j = i11 + 1;
    }

    public void c() {
        this.f79282k = Arrays.copyOf(this.f79282k, this.f79281j);
        this.f79283l = Arrays.copyOf(this.f79283l, this.f79281j);
    }

    public final long e(int i11) {
        return (this.f79275d * ((long) i11)) / ((long) this.f79276e);
    }

    public long f() {
        return e(this.f79279h);
    }

    public long g() {
        return e(1);
    }

    public final n0 h(int i11) {
        return new n0(((long) this.f79283l[i11]) * g(), this.f79282k[i11]);
    }

    public m0.a i(long j11) {
        int iG = (int) (j11 / g());
        int iG2 = u0.g(this.f79283l, iG, true, true);
        if (this.f79283l[iG2] == iG) {
            return new m0.a(h(iG2));
        }
        n0 n0VarH = h(iG2);
        int i11 = iG2 + 1;
        return i11 < this.f79282k.length ? new m0.a(n0VarH, h(i11)) : new m0.a(n0VarH);
    }

    public boolean j(int i11) {
        return this.f79273b == i11 || this.f79274c == i11;
    }

    public void k() {
        this.f79280i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f79283l, this.f79279h) >= 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean m(t tVar) throws IOException {
        int i11 = this.f79278g;
        int iD = i11 - this.f79272a.d(tVar, i11, false);
        this.f79278g = iD;
        boolean z11 = iD == 0;
        if (z11) {
            if (this.f79277f > 0) {
                this.f79272a.f(f(), l() ? 1 : 0, this.f79277f, 0, null);
            }
            a();
        }
        return z11;
    }

    public void n(int i11) {
        this.f79277f = i11;
        this.f79278g = i11;
    }

    public void o(long j11) {
        if (this.f79281j == 0) {
            this.f79279h = 0;
        } else {
            this.f79279h = this.f79283l[u0.h(this.f79282k, j11, true, true)];
        }
    }
}

package vg;

import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.Arrays;
import tg.b0;
import tg.c0;
import tg.e0;
import tg.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f78800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f78803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f78810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f78811l;

    public e(int i11, int i12, long j11, int i13, e0 e0Var) {
        boolean z11 = true;
        if (i12 != 1 && i12 != 2) {
            z11 = false;
        }
        com.google.android.exoplayer2.util.a.a(z11);
        this.f78803d = j11;
        this.f78804e = i13;
        this.f78800a = e0Var;
        this.f78801b = d(i11, i12 == 2 ? 1667497984 : 1651965952);
        this.f78802c = i12 == 2 ? d(i11, 1650720768) : -1;
        this.f78810k = new long[512];
        this.f78811l = new int[512];
    }

    public static int d(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    public void a() {
        this.f78807h++;
    }

    public void b(long j11) {
        if (this.f78809j == this.f78811l.length) {
            long[] jArr = this.f78810k;
            this.f78810k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f78811l;
            this.f78811l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f78810k;
        int i11 = this.f78809j;
        jArr2[i11] = j11;
        this.f78811l[i11] = this.f78808i;
        this.f78809j = i11 + 1;
    }

    public void c() {
        this.f78810k = Arrays.copyOf(this.f78810k, this.f78809j);
        this.f78811l = Arrays.copyOf(this.f78811l, this.f78809j);
    }

    public final long e(int i11) {
        return (this.f78803d * ((long) i11)) / ((long) this.f78804e);
    }

    public long f() {
        return e(this.f78807h);
    }

    public long g() {
        return e(1);
    }

    public final c0 h(int i11) {
        return new c0(((long) this.f78811l[i11]) * g(), this.f78810k[i11]);
    }

    public b0.a i(long j11) {
        int iG = (int) (j11 / g());
        int iH = o0.h(this.f78811l, iG, true, true);
        if (this.f78811l[iH] == iG) {
            return new b0.a(h(iH));
        }
        c0 c0VarH = h(iH);
        int i11 = iH + 1;
        return i11 < this.f78810k.length ? new b0.a(c0VarH, h(i11)) : new b0.a(c0VarH);
    }

    public boolean j(int i11) {
        return this.f78801b == i11 || this.f78802c == i11;
    }

    public void k() {
        this.f78808i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f78811l, this.f78807h) >= 0;
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
    public boolean m(m mVar) throws IOException {
        int i11 = this.f78806g;
        int iB = i11 - this.f78800a.b(mVar, i11, false);
        this.f78806g = iB;
        boolean z11 = iB == 0;
        if (z11) {
            if (this.f78805f > 0) {
                this.f78800a.d(f(), l() ? 1 : 0, this.f78805f, 0, null);
            }
            a();
        }
        return z11;
    }

    public void n(int i11) {
        this.f78805f = i11;
        this.f78806g = i11;
    }

    public void o(long j11) {
        if (this.f78809j == 0) {
            this.f78807h = 0;
        } else {
            this.f78807h = this.f78811l[o0.i(this.f78810k, j11, true, true)];
        }
    }
}

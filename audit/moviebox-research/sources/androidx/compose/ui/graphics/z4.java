package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class z4 implements e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4595a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4601h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4606m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4610q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m4 f4615v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4596b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4597c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4598d = 1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4602i = f4.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4603j = f4.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4607n = 8.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4608o = g5.f4145a.a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c5 f4609p = x4.a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4611r = y3.f4585a.a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4612s = y1.m.f81091b.a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q2.e f4613t = q2.g.b(1.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LayoutDirection f4614u = LayoutDirection.Ltr;

    public final q2.e A() {
        return this.f4613t;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float B() {
        return this.f4604k;
    }

    public final LayoutDirection C() {
        return this.f4614u;
    }

    public final int D() {
        return this.f4595a;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float E() {
        return this.f4597c;
    }

    public final m4 F() {
        return this.f4615v;
    }

    public y4 G() {
        return null;
    }

    public float H() {
        return this.f4601h;
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return q2.d.b(this, f11);
    }

    public c5 I() {
        return this.f4609p;
    }

    public long K() {
        return this.f4603j;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void K0(c5 c5Var) {
        if (Intrinsics.b(this.f4609p, c5Var)) {
            return;
        }
        this.f4595a |= 8192;
        this.f4609p = c5Var;
    }

    public final void L() {
        b(1.0f);
        h(1.0f);
        setAlpha(1.0f);
        j(0.0f);
        a(0.0f);
        w(0.0f);
        r(f4.a());
        u(f4.a());
        e(0.0f);
        f(0.0f);
        g(0.0f);
        d(8.0f);
        l0(g5.f4145a.a());
        K0(x4.a());
        t(false);
        c(null);
        n(y3.f4585a.a());
        T(y1.m.f81091b.a());
        this.f4615v = null;
        this.f4595a = 0;
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return q2.m.b(this, f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f4613t.M0();
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return q2.d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return q2.m.a(this, j11);
    }

    public final void R(q2.e eVar) {
        this.f4613t = eVar;
    }

    public final void S(LayoutDirection layoutDirection) {
        this.f4614u = layoutDirection;
    }

    public void T(long j11) {
        this.f4612s = j11;
    }

    public final void V() {
        this.f4615v = I().a(i(), this.f4614u, this.f4613t);
    }

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return q2.d.e(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return q2.d.f(this, f11);
    }

    @Override // androidx.compose.ui.graphics.e4
    public void a(float f11) {
        if (this.f4600g == f11) {
            return;
        }
        this.f4595a |= 16;
        this.f4600g = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void b(float f11) {
        if (this.f4596b == f11) {
            return;
        }
        this.f4595a |= 1;
        this.f4596b = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void c(y4 y4Var) {
        if (Intrinsics.b(null, y4Var)) {
            return;
        }
        this.f4595a |= 131072;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void d(float f11) {
        if (this.f4607n == f11) {
            return;
        }
        this.f4595a |= 2048;
        this.f4607n = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void e(float f11) {
        if (this.f4604k == f11) {
            return;
        }
        this.f4595a |= 256;
        this.f4604k = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void f(float f11) {
        if (this.f4605l == f11) {
            return;
        }
        this.f4595a |= 512;
        this.f4605l = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void g(float f11) {
        if (this.f4606m == f11) {
            return;
        }
        this.f4595a |= 1024;
        this.f4606m = f11;
    }

    @Override // q2.e
    public float getDensity() {
        return this.f4613t.getDensity();
    }

    @Override // androidx.compose.ui.graphics.e4
    public void h(float f11) {
        if (this.f4597c == f11) {
            return;
        }
        this.f4595a |= 2;
        this.f4597c = f11;
    }

    public long i() {
        return this.f4612s;
    }

    @Override // androidx.compose.ui.graphics.e4
    public long i0() {
        return this.f4608o;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void j(float f11) {
        if (this.f4599f == f11) {
            return;
        }
        this.f4595a |= 8;
        this.f4599f = f11;
    }

    public float k() {
        return this.f4598d;
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return q2.d.a(this, f11);
    }

    public long l() {
        return this.f4602i;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void l0(long j11) {
        if (g5.c(this.f4608o, j11)) {
            return;
        }
        this.f4595a |= 4096;
        this.f4608o = j11;
    }

    public boolean m() {
        return this.f4610q;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void n(int i11) {
        if (y3.e(this.f4611r, i11)) {
            return;
        }
        this.f4595a |= 32768;
        this.f4611r = i11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float o() {
        return this.f4605l;
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return q2.d.c(this, j11);
    }

    @Override // androidx.compose.ui.graphics.e4
    public float q() {
        return this.f4606m;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void r(long j11) {
        if (w1.m(this.f4602i, j11)) {
            return;
        }
        this.f4595a |= 64;
        this.f4602i = j11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float s() {
        return this.f4607n;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void setAlpha(float f11) {
        if (this.f4598d == f11) {
            return;
        }
        this.f4595a |= 4;
        this.f4598d = f11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void t(boolean z11) {
        if (this.f4610q != z11) {
            this.f4595a |= 16384;
            this.f4610q = z11;
        }
    }

    @Override // androidx.compose.ui.graphics.e4
    public void u(long j11) {
        if (w1.m(this.f4603j, j11)) {
            return;
        }
        this.f4595a |= 128;
        this.f4603j = j11;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float v() {
        return this.f4596b;
    }

    @Override // androidx.compose.ui.graphics.e4
    public void w(float f11) {
        if (this.f4601h == f11) {
            return;
        }
        this.f4595a |= 32;
        this.f4601h = f11;
    }

    public int x() {
        return this.f4611r;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float y() {
        return this.f4600g;
    }

    @Override // androidx.compose.ui.graphics.e4
    public float z() {
        return this.f4599f;
    }
}

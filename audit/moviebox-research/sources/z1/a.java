package z1;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.z3;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0925a f81699a = new C0925a(null, null, null, 0, 15, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f81700b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o4 f81701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o4 f81702d;

    /* JADX INFO: renamed from: z1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @PublishedApi
    public static final class C0925a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q2.e f81703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LayoutDirection f81704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o1 f81705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f81706d;

        public C0925a(q2.e eVar, LayoutDirection layoutDirection, o1 o1Var, long j11) {
            this.f81703a = eVar;
            this.f81704b = layoutDirection;
            this.f81705c = o1Var;
            this.f81706d = j11;
        }

        public /* synthetic */ C0925a(q2.e eVar, LayoutDirection layoutDirection, o1 o1Var, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? e.a() : eVar, (i11 & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i11 & 4) != 0 ? new k() : o1Var, (i11 & 8) != 0 ? y1.m.f81091b.b() : j11, null);
        }

        public /* synthetic */ C0925a(q2.e eVar, LayoutDirection layoutDirection, o1 o1Var, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(eVar, layoutDirection, o1Var, j11);
        }

        public final q2.e a() {
            return this.f81703a;
        }

        public final LayoutDirection b() {
            return this.f81704b;
        }

        public final o1 c() {
            return this.f81705c;
        }

        public final long d() {
            return this.f81706d;
        }

        public final o1 e() {
            return this.f81705c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0925a)) {
                return false;
            }
            C0925a c0925a = (C0925a) obj;
            return Intrinsics.b(this.f81703a, c0925a.f81703a) && this.f81704b == c0925a.f81704b && Intrinsics.b(this.f81705c, c0925a.f81705c) && y1.m.f(this.f81706d, c0925a.f81706d);
        }

        public final q2.e f() {
            return this.f81703a;
        }

        public final LayoutDirection g() {
            return this.f81704b;
        }

        public final long h() {
            return this.f81706d;
        }

        public int hashCode() {
            return (((((this.f81703a.hashCode() * 31) + this.f81704b.hashCode()) * 31) + this.f81705c.hashCode()) * 31) + y1.m.j(this.f81706d);
        }

        public final void i(o1 o1Var) {
            this.f81705c = o1Var;
        }

        public final void j(q2.e eVar) {
            this.f81703a = eVar;
        }

        public final void k(LayoutDirection layoutDirection) {
            this.f81704b = layoutDirection;
        }

        public final void l(long j11) {
            this.f81706d = j11;
        }

        public String toString() {
            return "DrawParams(density=" + this.f81703a + ", layoutDirection=" + this.f81704b + ", canvas=" + this.f81705c + ", size=" + ((Object) y1.m.l(this.f81706d)) + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f81707a = z1.b.b(this);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GraphicsLayer f81708b;

        public b() {
        }

        @Override // z1.d
        public void a(LayoutDirection layoutDirection) {
            a.this.D().k(layoutDirection);
        }

        @Override // z1.d
        public void b(q2.e eVar) {
            a.this.D().j(eVar);
        }

        @Override // z1.d
        public j c() {
            return this.f81707a;
        }

        @Override // z1.d
        public void d(GraphicsLayer graphicsLayer) {
            this.f81708b = graphicsLayer;
        }

        @Override // z1.d
        public o1 e() {
            return a.this.D().e();
        }

        @Override // z1.d
        public void f(long j11) {
            a.this.D().l(j11);
        }

        @Override // z1.d
        public GraphicsLayer g() {
            return this.f81708b;
        }

        @Override // z1.d
        public q2.e getDensity() {
            return a.this.D().f();
        }

        @Override // z1.d
        public LayoutDirection getLayoutDirection() {
            return a.this.D().g();
        }

        @Override // z1.d
        public void h(o1 o1Var) {
            a.this.D().i(o1Var);
        }

        @Override // z1.d
        public long i() {
            return a.this.D().h();
        }
    }

    public static /* synthetic */ o4 C(a aVar, long j11, float f11, float f12, int i11, int i12, r4 r4Var, float f13, x1 x1Var, int i13, int i14, int i15, Object obj) {
        return aVar.A(j11, f11, f12, i11, i12, r4Var, f13, x1Var, i13, (i15 & 512) != 0 ? g.f81712v8.b() : i14);
    }

    public static /* synthetic */ o4 l(a aVar, long j11, h hVar, float f11, x1 x1Var, int i11, int i12, int i13, Object obj) {
        return aVar.k(j11, hVar, f11, x1Var, i11, (i13 & 32) != 0 ? g.f81712v8.b() : i12);
    }

    public static /* synthetic */ o4 x(a aVar, l1 l1Var, h hVar, float f11, x1 x1Var, int i11, int i12, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            i12 = g.f81712v8.b();
        }
        return aVar.m(l1Var, hVar, f11, x1Var, i11, i12);
    }

    public final o4 A(long j11, float f11, float f12, int i11, int i12, r4 r4Var, float f13, x1 x1Var, int i13, int i14) {
        o4 o4VarH = H();
        long jF = F(j11, f13);
        if (!w1.m(o4VarH.a(), jF)) {
            o4VarH.t(jF);
        }
        if (o4VarH.z() != null) {
            o4VarH.y(null);
        }
        if (!Intrinsics.b(o4VarH.i(), x1Var)) {
            o4VarH.A(x1Var);
        }
        if (!e1.E(o4VarH.m(), i13)) {
            o4VarH.o(i13);
        }
        if (o4VarH.getStrokeWidth() != f11) {
            o4VarH.setStrokeWidth(f11);
        }
        if (o4VarH.w() != f12) {
            o4VarH.B(f12);
        }
        if (!e5.e(o4VarH.q(), i11)) {
            o4VarH.n(i11);
        }
        if (!f5.e(o4VarH.v(), i12)) {
            o4VarH.s(i12);
        }
        if (!Intrinsics.b(o4VarH.u(), r4Var)) {
            o4VarH.r(r4Var);
        }
        if (!z3.d(o4VarH.C(), i14)) {
            o4VarH.p(i14);
        }
        return o4VarH;
    }

    @Override // z1.g
    public void C0(long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().f(y1.g.m(j12), y1.g.n(j12), y1.g.m(j12) + y1.m.i(j13), y1.g.n(j12) + y1.m.g(j13), l(this, j11, hVar, f11, x1Var, i11, 0, 32, null));
    }

    public final C0925a D() {
        return this.f81699a;
    }

    public final long F(long j11, float f11) {
        return f11 == 1.0f ? j11 : w1.k(j11, w1.n(j11) * f11, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public final o4 G() {
        o4 o4Var = this.f81701c;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarA = t0.a();
        o4VarA.D(p4.f4317a.a());
        this.f81701c = o4VarA;
        return o4VarA;
    }

    @Override // z1.g
    public void G0(l1 l1Var, long j11, long j12, float f11, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().f(y1.g.m(j11), y1.g.n(j11), y1.g.m(j11) + y1.m.i(j12), y1.g.n(j11) + y1.m.g(j12), x(this, l1Var, hVar, f11, x1Var, i11, 0, 32, null));
    }

    public final o4 H() {
        o4 o4Var = this.f81702d;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarA = t0.a();
        o4VarA.D(p4.f4317a.b());
        this.f81702d = o4VarA;
        return o4VarA;
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return q2.d.b(this, f11);
    }

    public final o4 I(h hVar) {
        if (Intrinsics.b(hVar, l.f81716a)) {
            return G();
        }
        if (!(hVar instanceof m)) {
            throw new NoWhenBranchMatchedException();
        }
        o4 o4VarH = H();
        m mVar = (m) hVar;
        if (o4VarH.getStrokeWidth() != mVar.f()) {
            o4VarH.setStrokeWidth(mVar.f());
        }
        if (!e5.e(o4VarH.q(), mVar.b())) {
            o4VarH.n(mVar.b());
        }
        if (o4VarH.w() != mVar.d()) {
            o4VarH.B(mVar.d());
        }
        if (!f5.e(o4VarH.v(), mVar.c())) {
            o4VarH.s(mVar.c());
        }
        if (!Intrinsics.b(o4VarH.u(), mVar.e())) {
            o4VarH.r(mVar.e());
        }
        return o4VarH;
    }

    @Override // z1.g
    public void I0(long j11, float f11, long j12, float f12, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().q(j12, f11, l(this, j11, hVar, f12, x1Var, i11, 0, 32, null));
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return q2.m.b(this, f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f81699a.f().M0();
    }

    @Override // z1.g
    public void N(Path path, l1 l1Var, float f11, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().p(path, x(this, l1Var, hVar, f11, x1Var, i11, 0, 32, null));
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return q2.d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return q2.m.a(this, j11);
    }

    @Override // z1.g
    public void P(l1 l1Var, long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().s(y1.g.m(j11), y1.g.n(j11), y1.g.m(j11) + y1.m.i(j12), y1.g.n(j11) + y1.m.g(j12), y1.a.d(j13), y1.a.e(j13), x(this, l1Var, hVar, f11, x1Var, i11, 0, 32, null));
    }

    @Override // z1.g
    public void P0(List<y1.g> list, int i11, long j11, float f11, int i12, r4 r4Var, float f12, x1 x1Var, int i13) {
        this.f81699a.e().g(i11, list, C(this, j11, f11, 4.0f, i12, f5.f4136a.b(), r4Var, f12, x1Var, i13, 0, 512, null));
    }

    @Override // z1.g
    public d Q0() {
        return this.f81700b;
    }

    @Override // z1.g
    public /* synthetic */ long T0() {
        return f.a(this);
    }

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return q2.d.e(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return q2.d.f(this, f11);
    }

    @Override // z1.g
    public void c0(long j11, long j12, long j13, long j14, h hVar, float f11, x1 x1Var, int i11) {
        this.f81699a.e().s(y1.g.m(j12), y1.g.n(j12), y1.g.m(j12) + y1.m.i(j13), y1.g.n(j12) + y1.m.g(j13), y1.a.d(j14), y1.a.e(j14), l(this, j11, hVar, f11, x1Var, i11, 0, 32, null));
    }

    @Override // z1.g
    public void c1(g4 g4Var, long j11, long j12, long j13, long j14, float f11, h hVar, x1 x1Var, int i11, int i12) {
        this.f81699a.e().h(g4Var, j11, j12, j13, j14, m(null, hVar, f11, x1Var, i11, i12));
    }

    @Override // q2.e
    public float getDensity() {
        return this.f81699a.f().getDensity();
    }

    @Override // z1.g
    public LayoutDirection getLayoutDirection() {
        return this.f81699a.g();
    }

    @Override // z1.g
    public /* synthetic */ long i() {
        return f.b(this);
    }

    @Override // z1.g
    public void j0(Path path, long j11, float f11, h hVar, x1 x1Var, int i11) {
        this.f81699a.e().p(path, l(this, j11, hVar, f11, x1Var, i11, 0, 32, null));
    }

    public final o4 k(long j11, h hVar, float f11, x1 x1Var, int i11, int i12) {
        o4 o4VarI = I(hVar);
        long jF = F(j11, f11);
        if (!w1.m(o4VarI.a(), jF)) {
            o4VarI.t(jF);
        }
        if (o4VarI.z() != null) {
            o4VarI.y(null);
        }
        if (!Intrinsics.b(o4VarI.i(), x1Var)) {
            o4VarI.A(x1Var);
        }
        if (!e1.E(o4VarI.m(), i11)) {
            o4VarI.o(i11);
        }
        if (!z3.d(o4VarI.C(), i12)) {
            o4VarI.p(i12);
        }
        return o4VarI;
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return q2.d.a(this, f11);
    }

    public final o4 m(l1 l1Var, h hVar, float f11, x1 x1Var, int i11, int i12) {
        o4 o4VarI = I(hVar);
        if (l1Var != null) {
            l1Var.a(i(), o4VarI, f11);
        } else {
            if (o4VarI.z() != null) {
                o4VarI.y(null);
            }
            long jA = o4VarI.a();
            w1.a aVar = w1.f4564b;
            if (!w1.m(jA, aVar.a())) {
                o4VarI.t(aVar.a());
            }
            if (o4VarI.getAlpha() != f11) {
                o4VarI.setAlpha(f11);
            }
        }
        if (!Intrinsics.b(o4VarI.i(), x1Var)) {
            o4VarI.A(x1Var);
        }
        if (!e1.E(o4VarI.m(), i11)) {
            o4VarI.o(i11);
        }
        if (!z3.d(o4VarI.C(), i12)) {
            o4VarI.p(i12);
        }
        return o4VarI;
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return q2.d.c(this, j11);
    }

    @Override // z1.g
    public void z0(long j11, long j12, long j13, float f11, int i11, r4 r4Var, float f12, x1 x1Var, int i12) {
        this.f81699a.e().m(j12, j13, C(this, j11, f11, 4.0f, i11, f5.f4136a.b(), r4Var, f12, x1Var, i12, 0, 512, null));
    }
}

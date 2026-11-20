package androidx.compose.ui.graphics;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SimpleGraphicsLayerModifier extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {
    public boolean A;
    public long B;
    public long C;
    public int D;
    public Function1<? super e4, Unit> E;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3966s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f3968u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3969v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f3972y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c5 f3973z;

    public SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11) {
        this.f3962o = f11;
        this.f3963p = f12;
        this.f3964q = f13;
        this.f3965r = f14;
        this.f3966s = f15;
        this.f3967t = f16;
        this.f3968u = f17;
        this.f3969v = f18;
        this.f3970w = f19;
        this.f3971x = f21;
        this.f3972y = j11;
        this.f3973z = c5Var;
        this.A = z11;
        this.B = j12;
        this.C = j13;
        this.D = i11;
        this.E = new Function1<e4, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e4 e4Var) {
                invoke2(e4Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e4 e4Var) {
                e4Var.b(this.this$0.v());
                e4Var.h(this.this$0.E());
                e4Var.setAlpha(this.this$0.I1());
                e4Var.j(this.this$0.z());
                e4Var.a(this.this$0.y());
                e4Var.w(this.this$0.N1());
                e4Var.e(this.this$0.B());
                e4Var.f(this.this$0.o());
                e4Var.g(this.this$0.q());
                e4Var.d(this.this$0.s());
                e4Var.l0(this.this$0.i0());
                e4Var.K0(this.this$0.O1());
                e4Var.t(this.this$0.K1());
                this.this$0.M1();
                e4Var.c(null);
                e4Var.r(this.this$0.J1());
                e4Var.u(this.this$0.P1());
                e4Var.n(this.this$0.L1());
            }
        };
    }

    public /* synthetic */ SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, c5Var, z11, y4Var, j12, j13, i11);
    }

    public final float B() {
        return this.f3968u;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        final androidx.compose.ui.layout.k0 k0VarL = tVar.L(j11);
        return androidx.compose.ui.layout.x.b(yVar, k0VarL.s0(), k0VarL.g0(), null, new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.layout.k0.a aVar) {
                androidx.compose.ui.layout.k0.a.t(aVar, k0VarL, 0, 0, 0.0f, this.E, 4, null);
            }
        }, 4, null);
    }

    public final float E() {
        return this.f3963p;
    }

    public final float I1() {
        return this.f3964q;
    }

    public final long J1() {
        return this.B;
    }

    public final void K0(c5 c5Var) {
        this.f3973z = c5Var;
    }

    public final boolean K1() {
        return this.A;
    }

    public final int L1() {
        return this.D;
    }

    public final y4 M1() {
        return null;
    }

    public final float N1() {
        return this.f3967t;
    }

    public final c5 O1() {
        return this.f3973z;
    }

    public final long P1() {
        return this.C;
    }

    public final void Q1() {
        NodeCoordinator nodeCoordinatorY1 = androidx.compose.ui.node.g.h(this, androidx.compose.ui.node.s0.a(2)).Y1();
        if (nodeCoordinatorY1 != null) {
            nodeCoordinatorY1.L2(this.E, true);
        }
    }

    public final void a(float f11) {
        this.f3966s = f11;
    }

    public final void b(float f11) {
        this.f3962o = f11;
    }

    public final void c(y4 y4Var) {
    }

    public final void d(float f11) {
        this.f3971x = f11;
    }

    public final void e(float f11) {
        this.f3968u = f11;
    }

    public final void f(float f11) {
        this.f3969v = f11;
    }

    public final void g(float f11) {
        this.f3970w = f11;
    }

    public final void h(float f11) {
        this.f3963p = f11;
    }

    public final long i0() {
        return this.f3972y;
    }

    public final void j(float f11) {
        this.f3965r = f11;
    }

    public final void l0(long j11) {
        this.f3972y = j11;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return false;
    }

    public final void n(int i11) {
        this.D = i11;
    }

    public final float o() {
        return this.f3969v;
    }

    public final float q() {
        return this.f3970w;
    }

    public final void r(long j11) {
        this.B = j11;
    }

    public final float s() {
        return this.f3971x;
    }

    public final void setAlpha(float f11) {
        this.f3964q = f11;
    }

    public final void t(boolean z11) {
        this.A = z11;
    }

    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.f3962o + ", scaleY=" + this.f3963p + ", alpha = " + this.f3964q + ", translationX=" + this.f3965r + ", translationY=" + this.f3966s + ", shadowElevation=" + this.f3967t + ", rotationX=" + this.f3968u + ", rotationY=" + this.f3969v + ", rotationZ=" + this.f3970w + ", cameraDistance=" + this.f3971x + ", transformOrigin=" + ((Object) g5.g(this.f3972y)) + ", shape=" + this.f3973z + ", clip=" + this.A + ", renderEffect=" + ((Object) null) + ", ambientShadowColor=" + ((Object) w1.t(this.B)) + ", spotShadowColor=" + ((Object) w1.t(this.C)) + ", compositingStrategy=" + ((Object) y3.g(this.D)) + ')';
    }

    public final void u(long j11) {
        this.C = j11;
    }

    public final float v() {
        return this.f3962o;
    }

    public final void w(float f11) {
        this.f3967t = f11;
    }

    public final float y() {
        return this.f3966s;
    }

    public final float z() {
        return this.f3965r;
    }
}

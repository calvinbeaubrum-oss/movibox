package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class GraphicsLayerElement extends androidx.compose.ui.node.l0<SimpleGraphicsLayerModifier> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f3947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f3949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f3950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f3951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f3952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f3953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f3954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c5 f3955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f3956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f3957o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f3958p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f3959q;

    public GraphicsLayerElement(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11) {
        this.f3944b = f11;
        this.f3945c = f12;
        this.f3946d = f13;
        this.f3947e = f14;
        this.f3948f = f15;
        this.f3949g = f16;
        this.f3950h = f17;
        this.f3951i = f18;
        this.f3952j = f19;
        this.f3953k = f21;
        this.f3954l = j11;
        this.f3955m = c5Var;
        this.f3956n = z11;
        this.f3957o = j12;
        this.f3958p = j13;
        this.f3959q = i11;
    }

    public /* synthetic */ GraphicsLayerElement(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, c5Var, z11, y4Var, j12, j13, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.f3944b, graphicsLayerElement.f3944b) == 0 && Float.compare(this.f3945c, graphicsLayerElement.f3945c) == 0 && Float.compare(this.f3946d, graphicsLayerElement.f3946d) == 0 && Float.compare(this.f3947e, graphicsLayerElement.f3947e) == 0 && Float.compare(this.f3948f, graphicsLayerElement.f3948f) == 0 && Float.compare(this.f3949g, graphicsLayerElement.f3949g) == 0 && Float.compare(this.f3950h, graphicsLayerElement.f3950h) == 0 && Float.compare(this.f3951i, graphicsLayerElement.f3951i) == 0 && Float.compare(this.f3952j, graphicsLayerElement.f3952j) == 0 && Float.compare(this.f3953k, graphicsLayerElement.f3953k) == 0 && g5.c(this.f3954l, graphicsLayerElement.f3954l) && Intrinsics.b(this.f3955m, graphicsLayerElement.f3955m) && this.f3956n == graphicsLayerElement.f3956n && Intrinsics.b(null, null) && w1.m(this.f3957o, graphicsLayerElement.f3957o) && w1.m(this.f3958p, graphicsLayerElement.f3958p) && y3.e(this.f3959q, graphicsLayerElement.f3959q);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Float.floatToIntBits(this.f3944b) * 31) + Float.floatToIntBits(this.f3945c)) * 31) + Float.floatToIntBits(this.f3946d)) * 31) + Float.floatToIntBits(this.f3947e)) * 31) + Float.floatToIntBits(this.f3948f)) * 31) + Float.floatToIntBits(this.f3949g)) * 31) + Float.floatToIntBits(this.f3950h)) * 31) + Float.floatToIntBits(this.f3951i)) * 31) + Float.floatToIntBits(this.f3952j)) * 31) + Float.floatToIntBits(this.f3953k)) * 31) + g5.f(this.f3954l)) * 31) + this.f3955m.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f3956n)) * 961) + w1.s(this.f3957o)) * 31) + w1.s(this.f3958p)) * 31) + y3.f(this.f3959q);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public SimpleGraphicsLayerModifier a() {
        return new SimpleGraphicsLayerModifier(this.f3944b, this.f3945c, this.f3946d, this.f3947e, this.f3948f, this.f3949g, this.f3950h, this.f3951i, this.f3952j, this.f3953k, this.f3954l, this.f3955m, this.f3956n, null, this.f3957o, this.f3958p, this.f3959q, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        simpleGraphicsLayerModifier.b(this.f3944b);
        simpleGraphicsLayerModifier.h(this.f3945c);
        simpleGraphicsLayerModifier.setAlpha(this.f3946d);
        simpleGraphicsLayerModifier.j(this.f3947e);
        simpleGraphicsLayerModifier.a(this.f3948f);
        simpleGraphicsLayerModifier.w(this.f3949g);
        simpleGraphicsLayerModifier.e(this.f3950h);
        simpleGraphicsLayerModifier.f(this.f3951i);
        simpleGraphicsLayerModifier.g(this.f3952j);
        simpleGraphicsLayerModifier.d(this.f3953k);
        simpleGraphicsLayerModifier.l0(this.f3954l);
        simpleGraphicsLayerModifier.K0(this.f3955m);
        simpleGraphicsLayerModifier.t(this.f3956n);
        simpleGraphicsLayerModifier.c(null);
        simpleGraphicsLayerModifier.r(this.f3957o);
        simpleGraphicsLayerModifier.u(this.f3958p);
        simpleGraphicsLayerModifier.n(this.f3959q);
        simpleGraphicsLayerModifier.Q1();
    }

    public String toString() {
        return "GraphicsLayerElement(scaleX=" + this.f3944b + ", scaleY=" + this.f3945c + ", alpha=" + this.f3946d + ", translationX=" + this.f3947e + ", translationY=" + this.f3948f + ", shadowElevation=" + this.f3949g + ", rotationX=" + this.f3950h + ", rotationY=" + this.f3951i + ", rotationZ=" + this.f3952j + ", cameraDistance=" + this.f3953k + ", transformOrigin=" + ((Object) g5.g(this.f3954l)) + ", shape=" + this.f3955m + ", clip=" + this.f3956n + ", renderEffect=" + ((Object) null) + ", ambientShadowColor=" + ((Object) w1.t(this.f3957o)) + ", spotShadowColor=" + ((Object) w1.t(this.f3958p)) + ", compositingStrategy=" + ((Object) y3.g(this.f3959q)) + ')';
    }
}

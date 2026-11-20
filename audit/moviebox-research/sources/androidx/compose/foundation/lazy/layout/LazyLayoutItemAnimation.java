package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
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
public final class LazyLayoutItemAnimation {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f2599s = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2600t = 8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f2601u = q2.q.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.k0 f2602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4 f2603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f2604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.compose.animation.core.c0<Float> f2605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.compose.animation.core.c0<q2.p> f2606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.compose.animation.core.c0<Float> f2607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i1 f2609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i1 f2610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1 f2611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i1 f2612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GraphicsLayer f2615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Animatable<q2.p, androidx.compose.animation.core.l> f2616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Animatable<Float, androidx.compose.animation.core.k> f2617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final i1 f2618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2619r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return LazyLayoutItemAnimation.f2601u;
        }
    }

    public LazyLayoutItemAnimation(kotlinx.coroutines.k0 k0Var, c4 c4Var, Function0<Unit> function0) {
        this.f2602a = k0Var;
        this.f2603b = c4Var;
        this.f2604c = function0;
        Boolean bool = Boolean.FALSE;
        this.f2609h = u2.c(bool, null, 2, null);
        this.f2610i = u2.c(bool, null, 2, null);
        this.f2611j = u2.c(bool, null, 2, null);
        this.f2612k = u2.c(bool, null, 2, null);
        long j11 = f2601u;
        this.f2613l = j11;
        q2.p.a aVar = q2.p.f74244b;
        this.f2614m = aVar.a();
        this.f2615n = c4Var != null ? c4Var.a() : null;
        this.f2616o = new Animatable<>(q2.p.b(aVar.a()), VectorConvertersKt.f(aVar), null, null, 12, null);
        this.f2617p = new Animatable<>(Float.valueOf(1.0f), VectorConvertersKt.b(FloatCompanionObject.f68904a), null, null, 12, null);
        this.f2618q = u2.c(q2.p.b(aVar.a()), null, 2, null);
        this.f2619r = j11;
    }

    public final void A(boolean z11) {
        this.f2612k.setValue(Boolean.valueOf(z11));
    }

    public final void B(boolean z11) {
        this.f2611j.setValue(Boolean.valueOf(z11));
    }

    public final void C(androidx.compose.animation.core.c0<Float> c0Var) {
        this.f2605d = c0Var;
    }

    public final void D(androidx.compose.animation.core.c0<Float> c0Var) {
        this.f2607f = c0Var;
    }

    public final void E(long j11) {
        this.f2614m = j11;
    }

    public final void F(long j11) {
        this.f2619r = j11;
    }

    public final void G(boolean z11) {
        this.f2609h.setValue(Boolean.valueOf(z11));
    }

    public final void H(long j11) {
        this.f2618q.setValue(q2.p.b(j11));
    }

    public final void I(androidx.compose.animation.core.c0<q2.p> c0Var) {
        this.f2606e = c0Var;
    }

    public final void J(long j11) {
        this.f2613l = j11;
    }

    public final void k() {
        GraphicsLayer graphicsLayer = this.f2615n;
        androidx.compose.animation.core.c0<Float> c0Var = this.f2605d;
        if (t() || c0Var == null || graphicsLayer == null) {
            if (v()) {
                if (graphicsLayer != null) {
                    graphicsLayer.J(1.0f);
                }
                kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$animateAppearance$1(this, null), 3, null);
                return;
            }
            return;
        }
        z(true);
        boolean z11 = !v();
        if (z11) {
            graphicsLayer.J(0.0f);
        }
        kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$animateAppearance$2(z11, this, c0Var, graphicsLayer, null), 3, null);
    }

    public final void l() {
        GraphicsLayer graphicsLayer = this.f2615n;
        androidx.compose.animation.core.c0<Float> c0Var = this.f2607f;
        if (graphicsLayer == null || v() || c0Var == null) {
            return;
        }
        B(true);
        kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$animateDisappearance$1(this, c0Var, graphicsLayer, null), 3, null);
    }

    public final void m(long j11, boolean z11) {
        androidx.compose.animation.core.c0<q2.p> c0Var = this.f2606e;
        if (c0Var == null) {
            return;
        }
        long jK = q2.p.k(r(), j11);
        H(jK);
        G(true);
        this.f2608g = z11;
        kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, c0Var, jK, null), 3, null);
    }

    public final void n() {
        if (w()) {
            kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$cancelPlacementAnimation$1(this, null), 3, null);
        }
    }

    public final long o() {
        return this.f2614m;
    }

    public final GraphicsLayer p() {
        return this.f2615n;
    }

    public final long q() {
        return this.f2619r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long r() {
        return ((q2.p) this.f2618q.getValue()).n();
    }

    public final long s() {
        return this.f2613l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t() {
        return ((Boolean) this.f2610i.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean u() {
        return ((Boolean) this.f2612k.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean v() {
        return ((Boolean) this.f2611j.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w() {
        return ((Boolean) this.f2609h.getValue()).booleanValue();
    }

    public final boolean x() {
        return this.f2608g;
    }

    public final void y() {
        c4 c4Var;
        if (w()) {
            G(false);
            kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$release$1(this, null), 3, null);
        }
        if (t()) {
            z(false);
            kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$release$2(this, null), 3, null);
        }
        if (v()) {
            B(false);
            kotlinx.coroutines.j.d(this.f2602a, null, null, new LazyLayoutItemAnimation$release$3(this, null), 3, null);
        }
        this.f2608g = false;
        H(q2.p.f74244b.a());
        this.f2613l = f2601u;
        GraphicsLayer graphicsLayer = this.f2615n;
        if (graphicsLayer != null && (c4Var = this.f2603b) != null) {
            c4Var.b(graphicsLayer);
        }
        this.f2615n = null;
        this.f2605d = null;
        this.f2607f = null;
        this.f2606e = null;
    }

    public final void z(boolean z11) {
        this.f2610i.setValue(Boolean.valueOf(z11));
    }
}

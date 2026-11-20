package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.g5;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.graphics.z4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
@Metadata
@SourceDebugExtension
public final class RenderNodeLayer implements androidx.compose.ui.node.w0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f5358o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5359p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Function2<y0, Matrix, Unit> f5360q = new Function2<y0, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(y0 y0Var, Matrix matrix) {
            invoke2(y0Var, matrix);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(y0 y0Var, Matrix matrix) {
            y0Var.x(matrix);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> f5362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f5363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5364d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o4 f5368i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final y0 f5372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5373n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m1 f5365f = new m1();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1<y0> f5369j = new i1<>(f5360q);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.ui.graphics.p1 f5370k = new androidx.compose.ui.graphics.p1();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5371l = g5.f4145a.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.f5361a = androidComposeView;
        this.f5362b = function2;
        this.f5363c = function0;
        y0 a2Var = Build.VERSION.SDK_INT >= 29 ? new a2(androidComposeView) : new n1(androidComposeView);
        a2Var.w(true);
        a2Var.p(false);
        this.f5372m = a2Var;
    }

    private final void b(boolean z11) {
        if (z11 != this.f5364d) {
            this.f5364d = z11;
            this.f5361a.notifyLayerIsDirty$ui_release(this, z11);
        }
    }

    private final void c() {
        if (Build.VERSION.SDK_INT >= 26) {
            d3.f5460a.a(this.f5361a);
        } else {
            this.f5361a.invalidate();
        }
    }

    public final void a(androidx.compose.ui.graphics.o1 o1Var) {
        if (this.f5372m.v() || this.f5372m.t()) {
            this.f5365f.a(o1Var);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        if (this.f5372m.l()) {
            this.f5372m.k();
        }
        this.f5362b = null;
        this.f5363c = null;
        this.f5366g = true;
        b(false);
        this.f5361a.requestClearInvalidObservations();
        this.f5361a.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        if (canvasD.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z11 = this.f5372m.H() > 0.0f;
            this.f5367h = z11;
            if (z11) {
                o1Var.l();
            }
            this.f5372m.o(canvasD);
            if (this.f5367h) {
                o1Var.n();
                return;
            }
            return;
        }
        float fI = this.f5372m.i();
        float fU = this.f5372m.u();
        float fM = this.f5372m.m();
        float fZ = this.f5372m.z();
        if (this.f5372m.getAlpha() < 1.0f) {
            o4 o4VarA = this.f5368i;
            if (o4VarA == null) {
                o4VarA = androidx.compose.ui.graphics.t0.a();
                this.f5368i = o4VarA;
            }
            o4VarA.setAlpha(this.f5372m.getAlpha());
            canvasD.saveLayer(fI, fU, fM, fZ, o4VarA.x());
        } else {
            o1Var.d();
        }
        o1Var.c(fI, fU);
        o1Var.o(this.f5369j.b(this.f5372m));
        a(o1Var);
        Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2 = this.f5362b;
        if (function2 != null) {
            function2.invoke(o1Var, null);
        }
        o1Var.k();
        b(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.f5364d || this.f5366g) {
            return;
        }
        this.f5361a.invalidate();
        b(true);
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo57isInLayerk4lQ0M(long j11) {
        float fM = y1.g.m(j11);
        float fN = y1.g.n(j11);
        if (this.f5372m.t()) {
            return 0.0f <= fM && fM < ((float) this.f5372m.getWidth()) && 0.0f <= fN && fN < ((float) this.f5372m.getHeight());
        }
        if (this.f5372m.v()) {
            return this.f5365f.f(j11);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y1.e eVar, boolean z11) {
        if (!z11) {
            k4.g(this.f5369j.b(this.f5372m), eVar);
            return;
        }
        float[] fArrA = this.f5369j.a(this.f5372m);
        if (fArrA == null) {
            eVar.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            k4.g(fArrA, eVar);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo58mapOffset8S9VItk(long j11, boolean z11) {
        if (!z11) {
            return k4.f(this.f5369j.b(this.f5372m), j11);
        }
        float[] fArrA = this.f5369j.a(this.f5372m);
        return fArrA != null ? k4.f(fArrA, j11) : y1.g.f81070b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo59movegyyYBs(long j11) {
        int i11 = this.f5372m.i();
        int iU = this.f5372m.u();
        int iH = q2.p.h(j11);
        int i12 = q2.p.i(j11);
        if (i11 == iH && iU == i12) {
            return;
        }
        if (i11 != iH) {
            this.f5372m.y(iH - i11);
        }
        if (iU != i12) {
            this.f5372m.s(i12 - iU);
        }
        c();
        this.f5369j.c();
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo60resizeozmzZPI(long j11) {
        int iG = q2.t.g(j11);
        int iF = q2.t.f(j11);
        this.f5372m.A(g5.d(this.f5371l) * iG);
        this.f5372m.B(g5.e(this.f5371l) * iF);
        y0 y0Var = this.f5372m;
        if (y0Var.q(y0Var.i(), this.f5372m.u(), this.f5372m.i() + iG, this.f5372m.u() + iF)) {
            this.f5372m.C(this.f5365f.b());
            invalidate();
            this.f5369j.c();
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        b(false);
        this.f5366g = false;
        this.f5367h = false;
        this.f5371l = g5.f4145a.a();
        this.f5362b = function2;
        this.f5363c = function0;
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (this.f5364d || !this.f5372m.l()) {
            Path pathD = (!this.f5372m.v() || this.f5365f.e()) ? null : this.f5365f.d();
            final Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2 = this.f5362b;
            if (function2 != null) {
                this.f5372m.F(this.f5370k, pathD, new Function1<androidx.compose.ui.graphics.o1, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.graphics.o1 o1Var) {
                        invoke2(o1Var);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.compose.ui.graphics.o1 o1Var) {
                        function2.invoke(o1Var, null);
                    }
                });
            }
            b(false);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(z4 z4Var) {
        Function0<Unit> function0;
        int iD = z4Var.D() | this.f5373n;
        int i11 = iD & 4096;
        if (i11 != 0) {
            this.f5371l = z4Var.i0();
        }
        boolean z11 = false;
        boolean z12 = this.f5372m.v() && !this.f5365f.e();
        if ((iD & 1) != 0) {
            this.f5372m.b(z4Var.v());
        }
        if ((iD & 2) != 0) {
            this.f5372m.h(z4Var.E());
        }
        if ((iD & 4) != 0) {
            this.f5372m.setAlpha(z4Var.k());
        }
        if ((iD & 8) != 0) {
            this.f5372m.j(z4Var.z());
        }
        if ((iD & 16) != 0) {
            this.f5372m.a(z4Var.y());
        }
        if ((iD & 32) != 0) {
            this.f5372m.r(z4Var.H());
        }
        if ((iD & 64) != 0) {
            this.f5372m.D(androidx.compose.ui.graphics.y1.j(z4Var.l()));
        }
        if ((iD & 128) != 0) {
            this.f5372m.G(androidx.compose.ui.graphics.y1.j(z4Var.K()));
        }
        if ((iD & 1024) != 0) {
            this.f5372m.g(z4Var.q());
        }
        if ((iD & 256) != 0) {
            this.f5372m.e(z4Var.B());
        }
        if ((iD & 512) != 0) {
            this.f5372m.f(z4Var.o());
        }
        if ((iD & 2048) != 0) {
            this.f5372m.d(z4Var.s());
        }
        if (i11 != 0) {
            this.f5372m.A(g5.d(this.f5371l) * this.f5372m.getWidth());
            this.f5372m.B(g5.e(this.f5371l) * this.f5372m.getHeight());
        }
        boolean z13 = z4Var.m() && z4Var.I() != x4.a();
        if ((iD & 24576) != 0) {
            this.f5372m.E(z13);
            this.f5372m.p(z4Var.m() && z4Var.I() == x4.a());
        }
        if ((131072 & iD) != 0) {
            y0 y0Var = this.f5372m;
            z4Var.G();
            y0Var.c(null);
        }
        if ((32768 & iD) != 0) {
            this.f5372m.n(z4Var.x());
        }
        boolean zH = this.f5365f.h(z4Var.F(), z4Var.k(), z13, z4Var.H(), z4Var.i());
        if (this.f5365f.c()) {
            this.f5372m.C(this.f5365f.b());
        }
        if (z13 && !this.f5365f.e()) {
            z11 = true;
        }
        if (z12 != z11 || (z11 && zH)) {
            invalidate();
        } else {
            c();
        }
        if (!this.f5367h && this.f5372m.H() > 0.0f && (function0 = this.f5363c) != null) {
            function0.invoke();
        }
        if ((iD & 7963) != 0) {
            this.f5369j.c();
        }
        this.f5373n = z4Var.D();
    }
}

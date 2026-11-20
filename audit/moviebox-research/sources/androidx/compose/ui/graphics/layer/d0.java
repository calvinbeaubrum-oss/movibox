package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.p1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.unit.LayoutDirection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class d0 implements GraphicsLayerImpl {
    public static final b J = new b(null);
    public static final boolean K = !r0.f4304a.a();
    public static final Canvas L;
    public float A;
    public float B;
    public float C;
    public float D;
    public long E;
    public long F;
    public float G;
    public float H;
    public float I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawChildContainer f4241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1 f4243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewLayer f4244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Resources f4245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f4246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f4247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Picture f4248i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z1.a f4249j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p1 f4250k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4251l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4252m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4254o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4255p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4256q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4257r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f4258s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4259t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public x1 f4260u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4261v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f4262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f4264y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f4265z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Canvas {
        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        L = Build.VERSION.SDK_INT >= 23 ? new a() : (Canvas) new a2.a();
    }

    public d0(DrawChildContainer drawChildContainer, long j11, p1 p1Var, z1.a aVar) {
        this.f4241b = drawChildContainer;
        this.f4242c = j11;
        this.f4243d = p1Var;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, p1Var, aVar);
        this.f4244e = viewLayer;
        this.f4245f = drawChildContainer.getResources();
        this.f4246g = new Rect();
        boolean z11 = K;
        this.f4248i = z11 ? new Picture() : null;
        this.f4249j = z11 ? new z1.a() : null;
        this.f4250k = z11 ? new p1() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.f4253n = q2.t.f74253b.a();
        this.f4255p = true;
        this.f4258s = View.generateViewId();
        this.f4259t = e1.f4102a.B();
        this.f4261v = androidx.compose.ui.graphics.layer.b.f4212a.a();
        this.f4262w = 1.0f;
        this.f4264y = y1.g.f81070b.c();
        this.f4265z = 1.0f;
        this.A = 1.0f;
        w1.a aVar2 = w1.f4564b;
        this.E = aVar2.a();
        this.F = aVar2.a();
    }

    public /* synthetic */ d0(DrawChildContainer drawChildContainer, long j11, p1 p1Var, z1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawChildContainer, j11, (i11 & 4) != 0 ? new p1() : p1Var, (i11 & 8) != 0 ? new z1.a() : aVar);
    }

    private final boolean P() {
        return androidx.compose.ui.graphics.layer.b.e(p(), androidx.compose.ui.graphics.layer.b.f4212a.c()) || Q();
    }

    private final boolean Q() {
        return (e1.E(m(), e1.f4102a.B()) && i() == null) ? false : true;
    }

    private final void S() {
        if (P()) {
            M(androidx.compose.ui.graphics.layer.b.f4212a.c());
        } else {
            M(p());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long A() {
        return this.E;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float B() {
        return this.G;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.F;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix D() {
        return this.f4244e.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float E() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z11) {
        this.f4255p = z11;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        boolean z11 = !this.f4244e.setLayerOutline(outline);
        if (N() && outline != null) {
            this.f4244e.setClipToOutline(true);
            if (this.f4257r) {
                this.f4257r = false;
                this.f4254o = true;
            }
        }
        this.f4256q = outline != null;
        if (z11) {
            this.f4244e.invalidate();
            O();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(q2.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super z1.g, Unit> function1) {
        if (this.f4244e.getParent() == null) {
            this.f4241b.addView(this.f4244e);
        }
        this.f4244e.setDrawParams(eVar, layoutDirection, graphicsLayer, function1);
        if (this.f4244e.isAttachedToWindow()) {
            this.f4244e.setVisibility(4);
            this.f4244e.setVisibility(0);
            O();
            Picture picture = this.f4248i;
            if (picture != null) {
                Canvas canvasBeginRecording = picture.beginRecording(q2.t.g(this.f4253n), q2.t.f(this.f4253n));
                try {
                    p1 p1Var = this.f4250k;
                    if (p1Var != null) {
                        Canvas canvasV = p1Var.a().v();
                        p1Var.a().w(canvasBeginRecording);
                        androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
                        z1.a aVar = this.f4249j;
                        if (aVar != null) {
                            long jD = q2.u.d(this.f4253n);
                            z1.a.C0925a c0925aD = aVar.D();
                            q2.e eVarA = c0925aD.a();
                            LayoutDirection layoutDirectionB = c0925aD.b();
                            o1 o1VarC = c0925aD.c();
                            long jD2 = c0925aD.d();
                            z1.a.C0925a c0925aD2 = aVar.D();
                            c0925aD2.j(eVar);
                            c0925aD2.k(layoutDirection);
                            c0925aD2.i(g0VarA);
                            c0925aD2.l(jD);
                            g0VarA.d();
                            function1.invoke(aVar);
                            g0VarA.k();
                            z1.a.C0925a c0925aD3 = aVar.D();
                            c0925aD3.j(eVarA);
                            c0925aD3.k(layoutDirectionB);
                            c0925aD3.i(o1VarC);
                            c0925aD3.l(jD2);
                        }
                        p1Var.a().w(canvasV);
                        Unit unit = Unit.f68710a;
                    }
                } finally {
                    picture.endRecording();
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(long j11) {
        this.f4264y = j11;
        if (!y1.h.d(j11)) {
            this.f4263x = false;
            this.f4244e.setPivotX(y1.g.m(j11));
            this.f4244e.setPivotY(y1.g.n(j11));
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                v0.f4307a.a(this.f4244e);
                return;
            }
            this.f4263x = true;
            this.f4244e.setPivotX(q2.t.g(this.f4253n) / 2.0f);
            this.f4244e.setPivotY(q2.t.f(this.f4253n) / 2.0f);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.f4261v = i11;
        S();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.D;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(o1 o1Var) {
        R();
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        if (canvasD.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.f4241b;
            ViewLayer viewLayer = this.f4244e;
            drawChildContainer.drawChild$ui_graphics_release(o1Var, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.f4248i;
            if (picture != null) {
                canvasD.drawPicture(picture);
            }
        }
    }

    public final void M(int i11) {
        ViewLayer viewLayer = this.f4244e;
        androidx.compose.ui.graphics.layer.b.a aVar = androidx.compose.ui.graphics.layer.b.f4212a;
        boolean z11 = true;
        if (androidx.compose.ui.graphics.layer.b.e(i11, aVar.c())) {
            this.f4244e.setLayerType(2, this.f4247h);
        } else if (androidx.compose.ui.graphics.layer.b.e(i11, aVar.b())) {
            this.f4244e.setLayerType(0, this.f4247h);
            z11 = false;
        } else {
            this.f4244e.setLayerType(0, this.f4247h);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z11);
    }

    public boolean N() {
        return this.f4257r || this.f4244e.getClipToOutline();
    }

    public final void O() {
        try {
            p1 p1Var = this.f4243d;
            Canvas canvas = L;
            Canvas canvasV = p1Var.a().v();
            p1Var.a().w(canvas);
            androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
            DrawChildContainer drawChildContainer = this.f4241b;
            ViewLayer viewLayer = this.f4244e;
            drawChildContainer.drawChild$ui_graphics_release(g0VarA, viewLayer, viewLayer.getDrawingTime());
            p1Var.a().w(canvasV);
        } catch (Throwable unused) {
        }
    }

    public final void R() {
        Rect rect;
        if (this.f4254o) {
            ViewLayer viewLayer = this.f4244e;
            if (!N() || this.f4256q) {
                rect = null;
            } else {
                rect = this.f4246g;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.f4244e.getWidth();
                rect.bottom = this.f4244e.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.C = f11;
        this.f4244e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4265z = f11;
        this.f4244e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(y4 y4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            x0.f4309a.a(this.f4244e, y4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.f4244e.setCameraDistance(f11 * this.f4245f.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.G = f11;
        this.f4244e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.H = f11;
        this.f4244e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.I = f11;
        this.f4244e.setRotation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4262w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.A = f11;
        this.f4244e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public x1 i() {
        return this.f4260u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.B = f11;
        this.f4244e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        this.f4241b.removeViewInLayout(this.f4244e);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public /* synthetic */ boolean l() {
        return c.a(this);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f4259t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public y4 n() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.H;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int p() {
        return this.f4261v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.I;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.E = j11;
            v0.f4307a.b(this.f4244e, y1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float s() {
        return this.f4244e.getCameraDistance() / this.f4245f.getDisplayMetrics().densityDpi;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4262w = f11;
        this.f4244e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void t(boolean z11) {
        boolean z12 = false;
        this.f4257r = z11 && !this.f4256q;
        this.f4254o = true;
        ViewLayer viewLayer = this.f4244e;
        if (z11 && this.f4256q) {
            z12 = true;
        }
        viewLayer.setClipToOutline(z12);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.F = j11;
            v0.f4307a.c(this.f4244e, y1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float v() {
        return this.f4265z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void w(float f11) {
        this.D = f11;
        this.f4244e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void x(int i11, int i12, long j11) {
        if (q2.t.e(this.f4253n, j11)) {
            int i13 = this.f4251l;
            if (i13 != i11) {
                this.f4244e.offsetLeftAndRight(i11 - i13);
            }
            int i14 = this.f4252m;
            if (i14 != i12) {
                this.f4244e.offsetTopAndBottom(i12 - i14);
            }
        } else {
            if (N()) {
                this.f4254o = true;
            }
            this.f4244e.layout(i11, i12, q2.t.g(j11) + i11, q2.t.f(j11) + i12);
            this.f4253n = j11;
            if (this.f4263x) {
                this.f4244e.setPivotX(q2.t.g(j11) / 2.0f);
                this.f4244e.setPivotY(q2.t.f(j11) / 2.0f);
            }
        }
        this.f4251l = i11;
        this.f4252m = i12;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.C;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float z() {
        return this.B;
    }
}

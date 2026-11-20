package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.g5;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.graphics.y3;
import androidx.compose.ui.graphics.z4;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class ViewLayer extends View implements androidx.compose.ui.node.w0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Method f5380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static Field f5381t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f5382u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f5383v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawChildContainer f5385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> f5386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f5387d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m1 f5388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f5390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.ui.graphics.p1 f5393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i1<View> f5394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5396n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f5397o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5398p;
    public static final b Companion = new b(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Function2<View, Matrix, Unit> f5378q = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Matrix matrix) {
            invoke2(view, matrix);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ViewOutlineProvider f5379r = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.e(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            Outline outlineB = ((ViewLayer) view).f5388f.b();
            Intrinsics.d(outlineB);
            outline.set(outlineB);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ViewLayer.f5382u;
        }

        public final boolean b() {
            return ViewLayer.f5383v;
        }

        public final void c(boolean z11) {
            ViewLayer.f5383v = z11;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void d(View view) {
            try {
                if (!a()) {
                    ViewLayer.f5382u = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.f5380s = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.f5381t = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.f5380s = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.f5381t = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.f5380s;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.f5381t;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.f5381t;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.f5380s;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                c(true);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5399a = new c();

        @JvmStatic
        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.f5384a = androidComposeView;
        this.f5385b = drawChildContainer;
        this.f5386c = function2;
        this.f5387d = function0;
        this.f5388f = new m1();
        this.f5393k = new androidx.compose.ui.graphics.p1();
        this.f5394l = new i1<>(f5378q);
        this.f5395m = g5.f4145a.a();
        this.f5396n = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.f5397o = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.f5388f.e()) {
            return null;
        }
        return this.f5388f.d();
    }

    private final void setInvalidated(boolean z11) {
        if (z11 != this.f5391i) {
            this.f5391i = z11;
            this.f5384a.notifyLayerIsDirty$ui_release(this, z11);
        }
    }

    public final void a() {
        Rect rect;
        if (this.f5389g) {
            Rect rect2 = this.f5390h;
            if (rect2 == null) {
                this.f5390h = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.d(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.f5390h;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    public final void b() {
        setOutlineProvider(this.f5388f.b() != null ? f5379r : null);
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        setInvalidated(false);
        this.f5384a.requestClearInvalidObservations();
        this.f5386c = null;
        this.f5387d = null;
        boolean zRecycle$ui_release = this.f5384a.recycle$ui_release(this);
        if (Build.VERSION.SDK_INT >= 23 || f5383v || !zRecycle$ui_release) {
            this.f5385b.removeViewInLayout(this);
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z11;
        androidx.compose.ui.graphics.p1 p1Var = this.f5393k;
        Canvas canvasV = p1Var.a().v();
        p1Var.a().w(canvas);
        androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z11 = false;
        } else {
            g0VarA.d();
            this.f5388f.a(g0VarA);
            z11 = true;
        }
        Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2 = this.f5386c;
        if (function2 != null) {
            function2.invoke(g0VarA, null);
        }
        if (z11) {
            g0VarA.k();
        }
        p1Var.a().w(canvasV);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        boolean z11 = getElevation() > 0.0f;
        this.f5392j = z11;
        if (z11) {
            o1Var.l();
        }
        this.f5385b.drawChild$ui_release(o1Var, this, getDrawingTime());
        if (this.f5392j) {
            o1Var.n();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.f5385b;
    }

    public long getLayerId() {
        return this.f5397o;
    }

    public final AndroidComposeView getOwnerView() {
        return this.f5384a;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return c.a(this.f5384a);
        }
        return -1L;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.f5396n;
    }

    @Override // android.view.View, androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.f5391i) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.f5384a.invalidate();
    }

    /* JADX INFO: renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    public void m74inverseTransform58bKbWc(float[] fArr) {
        float[] fArrA = this.f5394l.a(this);
        if (fArrA != null) {
            k4.n(fArr, fArrA);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo57isInLayerk4lQ0M(long j11) {
        float fM = y1.g.m(j11);
        float fN = y1.g.n(j11);
        if (this.f5389g) {
            return 0.0f <= fM && fM < ((float) getWidth()) && 0.0f <= fN && fN < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.f5388f.f(j11);
        }
        return true;
    }

    public final boolean isInvalidated() {
        return this.f5391i;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y1.e eVar, boolean z11) {
        if (!z11) {
            k4.g(this.f5394l.b(this), eVar);
            return;
        }
        float[] fArrA = this.f5394l.a(this);
        if (fArrA != null) {
            k4.g(fArrA, eVar);
        } else {
            eVar.g(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo58mapOffset8S9VItk(long j11, boolean z11) {
        if (!z11) {
            return k4.f(this.f5394l.b(this), j11);
        }
        float[] fArrA = this.f5394l.a(this);
        return fArrA != null ? k4.f(fArrA, j11) : y1.g.f81070b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo59movegyyYBs(long j11) {
        int iH = q2.p.h(j11);
        if (iH != getLeft()) {
            offsetLeftAndRight(iH - getLeft());
            this.f5394l.c();
        }
        int i11 = q2.p.i(j11);
        if (i11 != getTop()) {
            offsetTopAndBottom(i11 - getTop());
            this.f5394l.c();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo60resizeozmzZPI(long j11) {
        int iG = q2.t.g(j11);
        int iF = q2.t.f(j11);
        if (iG == getWidth() && iF == getHeight()) {
            return;
        }
        setPivotX(g5.d(this.f5395m) * iG);
        setPivotY(g5.e(this.f5395m) * iF);
        b();
        layout(getLeft(), getTop(), getLeft() + iG, getTop() + iF);
        a();
        this.f5394l.c();
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        if (Build.VERSION.SDK_INT >= 23 || f5383v) {
            this.f5385b.addView(this);
        } else {
            setVisibility(0);
        }
        this.f5389g = false;
        this.f5392j = false;
        this.f5395m = g5.f4145a.a();
        this.f5386c = function2;
        this.f5387d = function0;
    }

    public final void setCameraDistancePx(float f11) {
        setCameraDistance(f11 * getResources().getDisplayMetrics().densityDpi);
    }

    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    public void m75transform58bKbWc(float[] fArr) {
        k4.n(fArr, this.f5394l.b(this));
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (!this.f5391i || f5383v) {
            return;
        }
        Companion.d(this);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(z4 z4Var) {
        Function0<Unit> function0;
        int iD = z4Var.D() | this.f5398p;
        if ((iD & 4096) != 0) {
            long jI0 = z4Var.i0();
            this.f5395m = jI0;
            setPivotX(g5.d(jI0) * getWidth());
            setPivotY(g5.e(this.f5395m) * getHeight());
        }
        if ((iD & 1) != 0) {
            setScaleX(z4Var.v());
        }
        if ((iD & 2) != 0) {
            setScaleY(z4Var.E());
        }
        if ((iD & 4) != 0) {
            setAlpha(z4Var.k());
        }
        if ((iD & 8) != 0) {
            setTranslationX(z4Var.z());
        }
        if ((iD & 16) != 0) {
            setTranslationY(z4Var.y());
        }
        if ((iD & 32) != 0) {
            setElevation(z4Var.H());
        }
        if ((iD & 1024) != 0) {
            setRotation(z4Var.q());
        }
        if ((iD & 256) != 0) {
            setRotationX(z4Var.B());
        }
        if ((iD & 512) != 0) {
            setRotationY(z4Var.o());
        }
        if ((iD & 2048) != 0) {
            setCameraDistancePx(z4Var.s());
        }
        boolean z11 = false;
        boolean z12 = getManualClipPath() != null;
        boolean z13 = z4Var.m() && z4Var.I() != x4.a();
        if ((iD & 24576) != 0) {
            this.f5389g = z4Var.m() && z4Var.I() == x4.a();
            a();
            setClipToOutline(z13);
        }
        boolean zH = this.f5388f.h(z4Var.F(), z4Var.k(), z13, z4Var.H(), z4Var.i());
        if (this.f5388f.c()) {
            b();
        }
        boolean z14 = getManualClipPath() != null;
        if (z12 != z14 || (z14 && zH)) {
            invalidate();
        }
        if (!this.f5392j && getElevation() > 0.0f && (function0 = this.f5387d) != null) {
            function0.invoke();
        }
        if ((iD & 7963) != 0) {
            this.f5394l.c();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            if ((iD & 64) != 0) {
                s2.f5547a.a(this, androidx.compose.ui.graphics.y1.j(z4Var.l()));
            }
            if ((iD & 128) != 0) {
                s2.f5547a.b(this, androidx.compose.ui.graphics.y1.j(z4Var.K()));
            }
        }
        if (i11 >= 31 && (131072 & iD) != 0) {
            t2 t2Var = t2.f5551a;
            z4Var.G();
            t2Var.a(this, null);
        }
        if ((iD & 32768) != 0) {
            int iX = z4Var.x();
            y3.a aVar = y3.f4585a;
            if (y3.e(iX, aVar.c())) {
                setLayerType(2, null);
            } else {
                if (y3.e(iX, aVar.b())) {
                    setLayerType(0, null);
                } else {
                    setLayerType(0, null);
                }
                this.f5396n = z11;
            }
            z11 = true;
            this.f5396n = z11;
        }
        this.f5398p = z4Var.D();
    }
}

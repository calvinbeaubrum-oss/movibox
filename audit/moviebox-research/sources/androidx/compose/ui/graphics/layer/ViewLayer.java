package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.p1;
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
public final class ViewLayer extends View {
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ViewOutlineProvider f4196l = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f4197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1 f4198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z1.a f4199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Outline f4201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q2.e f4203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LayoutDirection f4204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super z1.g, Unit> f4205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GraphicsLayer f4206k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Outline outline2;
            if (!(view instanceof ViewLayer) || (outline2 = ((ViewLayer) view).f4201f) == null) {
                return;
            }
            outline.set(outline2);
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

    public ViewLayer(View view, p1 p1Var, z1.a aVar) {
        super(view.getContext());
        this.f4197a = view;
        this.f4198b = p1Var;
        this.f4199c = aVar;
        setOutlineProvider(f4196l);
        this.f4202g = true;
        this.f4203h = z1.e.a();
        this.f4204i = LayoutDirection.Ltr;
        this.f4205j = GraphicsLayerImpl.f4193a.a();
        setWillNotDraw(false);
        setClipBounds(null);
    }

    public /* synthetic */ ViewLayer(View view, p1 p1Var, z1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i11 & 2) != 0 ? new p1() : p1Var, (i11 & 4) != 0 ? new z1.a() : aVar);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        p1 p1Var = this.f4198b;
        Canvas canvasV = p1Var.a().v();
        p1Var.a().w(canvas);
        androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
        z1.a aVar = this.f4199c;
        q2.e eVar = this.f4203h;
        LayoutDirection layoutDirection = this.f4204i;
        long jA = y1.n.a(getWidth(), getHeight());
        GraphicsLayer graphicsLayer = this.f4206k;
        Function1<? super z1.g, Unit> function1 = this.f4205j;
        q2.e density = aVar.Q0().getDensity();
        LayoutDirection layoutDirection2 = aVar.Q0().getLayoutDirection();
        o1 o1VarE = aVar.Q0().e();
        long jI = aVar.Q0().i();
        GraphicsLayer graphicsLayerG = aVar.Q0().g();
        z1.d dVarQ0 = aVar.Q0();
        dVarQ0.b(eVar);
        dVarQ0.a(layoutDirection);
        dVarQ0.h(g0VarA);
        dVarQ0.f(jA);
        dVarQ0.d(graphicsLayer);
        g0VarA.d();
        try {
            function1.invoke(aVar);
            g0VarA.k();
            z1.d dVarQ1 = aVar.Q0();
            dVarQ1.b(density);
            dVarQ1.a(layoutDirection2);
            dVarQ1.h(o1VarE);
            dVarQ1.f(jI);
            dVarQ1.d(graphicsLayerG);
            p1Var.a().w(canvasV);
            this.f4200d = false;
        } catch (Throwable th2) {
            g0VarA.k();
            z1.d dVarQ2 = aVar.Q0();
            dVarQ2.b(density);
            dVarQ2.a(layoutDirection2);
            dVarQ2.h(o1VarE);
            dVarQ2.f(jI);
            dVarQ2.d(graphicsLayerG);
            throw th2;
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final boolean getCanUseCompositingLayer$ui_graphics_release() {
        return this.f4202g;
    }

    public final p1 getCanvasHolder() {
        return this.f4198b;
    }

    public final View getOwnerView() {
        return this.f4197a;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.f4202g;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.f4200d) {
            return;
        }
        this.f4200d = true;
        super.invalidate();
    }

    public final boolean isInvalidated() {
        return this.f4200d;
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z11) {
        if (this.f4202g != z11) {
            this.f4202g = z11;
            invalidate();
        }
    }

    public final void setDrawParams(q2.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super z1.g, Unit> function1) {
        this.f4203h = eVar;
        this.f4204i = layoutDirection;
        this.f4205j = function1;
        this.f4206k = graphicsLayer;
    }

    public final void setInvalidated(boolean z11) {
        this.f4200d = z11;
    }

    public final boolean setLayerOutline(Outline outline) {
        this.f4201f = outline;
        return j0.f4296a.a(this);
    }
}

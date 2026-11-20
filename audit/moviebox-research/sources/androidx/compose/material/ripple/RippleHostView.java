package androidx.compose.material.ripple;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y1.m;

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
public final class RippleHostView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f3141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f3142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f3143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f3144d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f3145f;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f3139g = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f3140h = new int[0];

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RippleHostView(Context context) {
        super(context);
    }

    private final void setRippleState(boolean z11) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.f3144d;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l11 = this.f3143c;
        long jLongValue = jCurrentAnimationTimeMillis - (l11 != null ? l11.longValue() : 0L);
        if (z11 || jLongValue >= 5) {
            int[] iArr = z11 ? f3139g : f3140h;
            k kVar = this.f3141a;
            if (kVar != null) {
                kVar.setState(iArr);
            }
        } else {
            Runnable runnable2 = new Runnable() { // from class: androidx.compose.material.ripple.g
                @Override // java.lang.Runnable
                public final void run() {
                    RippleHostView.setRippleState$lambda$2(this.f3178a);
                }
            };
            this.f3144d = runnable2;
            postDelayed(runnable2, 50L);
        }
        this.f3143c = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$2(RippleHostView rippleHostView) {
        k kVar = rippleHostView.f3141a;
        if (kVar != null) {
            kVar.setState(f3140h);
        }
        rippleHostView.f3144d = null;
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m39addRippleKOepWvA(o1.k.b bVar, boolean z11, long j11, int i11, long j12, float f11, Function0<Unit> function0) {
        if (this.f3141a == null || !Intrinsics.b(Boolean.valueOf(z11), this.f3142b)) {
            b(z11);
            this.f3142b = Boolean.valueOf(z11);
        }
        k kVar = this.f3141a;
        Intrinsics.d(kVar);
        this.f3145f = function0;
        kVar.c(i11);
        m40setRippleProperties07v42R4(j11, j12, f11);
        if (z11) {
            kVar.setHotspot(y1.g.m(bVar.a()), y1.g.n(bVar.a()));
        } else {
            kVar.setHotspot(kVar.getBounds().centerX(), kVar.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void b(boolean z11) {
        k kVar = new k(z11);
        setBackground(kVar);
        this.f3141a = kVar;
    }

    public final void disposeRipple() {
        this.f3145f = null;
        Runnable runnable = this.f3144d;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.f3144d;
            Intrinsics.d(runnable2);
            runnable2.run();
        } else {
            k kVar = this.f3141a;
            if (kVar != null) {
                kVar.setState(f3140h);
            }
        }
        k kVar2 = this.f3141a;
        if (kVar2 == null) {
            return;
        }
        kVar2.setVisible(false, false);
        unscheduleDrawable(kVar2);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Function0<Unit> function0 = this.f3145f;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* JADX INFO: renamed from: setRippleProperties-07v42R4, reason: not valid java name */
    public final void m40setRippleProperties07v42R4(long j11, long j12, float f11) {
        k kVar = this.f3141a;
        if (kVar == null) {
            return;
        }
        kVar.b(j12, f11);
        Rect rect = new Rect(0, 0, a20.b.d(m.i(j11)), a20.b.d(m.g(j11)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        kVar.setBounds(rect);
    }
}
